# ORACLE

TOC
- [List table names in Schema](#list_table)
- [Data Size, Size of a Schema](#data_size)
- [Fast delete tables](#fast_delete)
- [Sequence](#sequence)
- [Other SQLs - almost ETL](#almost_etl)
- [ETL](#etl)

### List table names in Schema <a name="list_table"></a>

```sql
SELECT OBJECT_NAME
FROM USER_OBJECTS
WHERE OBJECT_TYPE = 'TABLE' order by OBJECT_NAME;
```

### Data Size, Size of a Schema <a name="data_size"></a>

```sql
select 
   sum(bytes)/1024/1024/1024 schema_size_gig
from 
   user_segments;
   
select owner, table_name, round((num_rows*avg_row_len)/(1024*1024)) MB , num_rows
from all_tables
where owner like 'TEST%'  -- Exclude system tables.
and num_rows > 0  -- Ignore empty Tables.
order by MB desc -- Biggest first.
;
  
begin
   dbms_stats.gather_table_stats('TEST','DATA_KONT');
end;
```

### Fast delete tables <a name="fast_delete"></a>

```sql
begin
  for rec in (select table_name
              from   user_tables
              where  table_name like 'SLOW_%'
             )
  loop
    execute immediate 'drop table KSKIBINSKI.'||rec.table_name;
  end loop;           
end;
  
begin
  for rec in (select table_name
              from   user_tables
              where  table_name like 'TMP_%'
             )
  loop
    execute immediate 'drop table KSKIBINSKI.'||rec.table_name;
  end loop;           
end;
begin
  for rec in (select table_name
              from   user_tables
              where  table_name like 'DATA_%'
             )
  loop
    execute immediate 'drop table KSKIBINSKI.'||rec.table_name;
  end loop;           
end;
```

### Sequence <a name="sequence"></a>

```sql
#if we copy from database to database this can break sequence
ALTER SEQUENCE PLIK_KOMUNIKACJI_SEQ INCREMENT BY 100;
select PLIK_KOMUNIKACJI_SEQ.nextval from dual;
ALTER SEQUENCE PLIK_KOMUNIKACJI_SEQ INCREMENT BY 1;
```

- - - 
### Other SQLs - almost ETL <a name="almost_etl"></a>
```sql
select SUM(AKT_WAZ_RYZ_BILANS_PO_MSP_WSP) + SUM(AKT_WAZ_RYZ_POZAB) * 0.08
from TEST.DATA_K
where DATA_DANYCH = '2018-03-31' AND (KLIENT_SPOLKI_ZALEZNEJ = 'N' OR KLIENT_SPOLKI_ZALEZNEJ IS NULL);


select 
k.NR_REF2,
k.ID_ANALITYKI, 
ROUND(SUM(r.ROZTERMINOWANIE_SUMA),2) as ROZTERMINOWANIE_SUMA, 
SUM(k.REZERWA) as REZERWA,
(SUM(NVL(k.EKSPOZYCJA_BILANSOWA_NETTO,0)) + SUM(NVL(k.EKSP_POZABILANSOWA_NETTO,0)) ) / COUNT(r.ID_ANALITYKI) as SUMA_Z_KONTRAKTU,
ROUND( 
SUM(r.ROZTERMINOWANIE_SUMA) - 
(SUM(NVL(k.EKSPOZYCJA_BILANSOWA_NETTO,0)) + SUM(NVL(k.EKSP_POZABILANSOWA_NETTO,0))) / COUNT(r.ID_ANALITYKI)
,2) as ROZNICA,
COUNT(r.ID_ANALITYKI) as ILOSC_RAT
from DATA_L r 
LEFT JOIN DATA_K k ON r.ID_ANALITYKI = k.ID_ANALITYKI AND k.DATA_DANYCH = r.DATA_DANYCH
where r.DATA_DANYCH = '2018-03-31' AND r.ID_ANALITYKI IS NOT NULL
GROUP BY k.ID_ANALITYKI, k.NR_REF2;
-- HAVING SUM(r.ROZTERMINOWANIE_SUMA) - 
--(SUM(NVL(k.EKSPOZYCJA_BILANSOWA_NETTO,0)) + SUM(NVL(k.EKSP_POZABILANSOWA_NETTO,0))) / COUNT(r.ID_ANALITYKI)  != 0 ;


WITH 
skonsolidowane_le as (
    select  ID_KLIENTA, 
            DATA_DANYCH,
            SUM(EKSPOZYCJA_BILANSOWA_BRUTTO) as EKSPOZYCJA_BILANSOWA_BRUTTO, 
            SUM(EKSP_POZABILANSOWA_BRUTTO) as EKSP_POZABILANSOWA_BRUTTO ,
            SUM(REZERWA) as REZERWA 
    from    TMP_KONTRAKTY_L
    group   by ID_KLIENTA, DATA_DANYCH
),
kontrakt as (
    select  ID_KLIENTA, 
            DATA_DANYCH,
            SUM(BILANS_NETTO) as BILANS_NETTO, 
            SUM(POZABILANS_NETTO) as POZABILANS_NETTO 
    from    DATA_KONT
    group   by ID_KLIENTA, DATA_DANYCH
),
rozterminowanie as (
    select  ID_KLIENTA, 
            DATA_DANYCH,
            SUM(ROZTERMINOWANIE_SUMA) as ROZTERMINOWANIE_SUMA
    from    DATA_LE_R
    group   by ID_KLIENTA, DATA_DANYCH
)
select 
ks.EKSPOZYCJA_BILANSOWA_BRUTTO as SKONS_EKSP_BIL_BRUTTO, 
ks.EKSP_POZABILANSOWA_BRUTTO as SKONS_EKSP_POZABIL_BRUTTO, 
ks.REZERWA as SKONS_REZERWA, 
kl.LE_S, -- tylko > 0 znajda sie w LE
kl.NAZWA_KLIENTA,
k.BILANS_NETTO as KONTRAKT_BILANS_NETTO, 
k.POZABILANS_NETTO as KONTRAKT_POZABILANS_NETTO,
Nvl(k.BILANS_NETTO,0) + Nvl(k.POZABILANS_NETTO,0) as KONTRAKT_SUMA,
r.ROZTERMINOWANIE_SUMA,
Nvl(r.ROZTERMINOWANIE_SUMA,0) - ( Nvl(k.BILANS_NETTO,0) + Nvl(k.POZABILANS_NETTO,0) ) as ROZNICA_ROZTERMINOWANIE, --tyle przyszlo z XLSa
Nvl(ks.EKSPOZYCJA_BILANSOWA_BRUTTO,0) + Nvl(ks.EKSP_POZABILANSOWA_BRUTTO,0) - Nvl(ks.REZERWA,0) as SKONS_ROZTERMINOWANIE_SUMA
from skonso ks
left join kont k ON ks.ID_KLIENTA = k.ID_KLIENTA AND ks.DATA_DANYCH = k.DATA_DANYCH
left join DATA_K kl ON ks.ID_KLIENTA = kl.ID_KLIENTA AND ks.DATA_DANYCH = kl.DATA_DANYCH
left join rozter r ON ks.ID_KLIENTA = r.ID_KLIENTA AND ks.DATA_DANYCH = r.DATA_DANYCH
where ks.DATA_DANYCH = '2018-04-30';

```

## ETL <a name="etl"></a>

Create a script

```sql
SELECT DISTINCT
        k.DATA_DANYCH, k.ID_KLIENTA, k.MODULO, k.NAZWA_KLIENTA,
        k.TYP_NBP_KOD, k.TYP_KLIENTA_KOD, k.KRAJ_KLIENTA_KOD,
        k.ILOSC_ZATR, k.PKD, k.PKD2007, k.NIP, k.PESEL_REGON, k.EKZ,
        mk.NACE,
        hk.AKTYWA_NETTO as AKTYWA_NETTO,
        hk.OBROTY_ROCZNE as OBROTY_ROCZNE,
        hk_kr.AKTYWA_NETTO as AKTYWA_NETTO_ROK,
        hk_kr.OBROTY_ROCZNE as OBROTY_ROCZNE_ROK,
        kk.LEI as KOD_LEI
      FROM M.KLI k
        LEFT JOIN M.M_KONTRAKTY mk
          ON k.ID_KLIENTA = mk.ID_KLIENTA AND k.DATA_DANYCH = mk.DATA_DANYCH
        LEFT JOIN H.KLIENCI hk
          ON k.ID_KLIENTA = hk.ID_KLIENTA
        LEFT JOIN H.KLIENCI_KR hk_kr
          ON k.ID_KLIENTA = hk_kr.ID_KLIENTA
        LEFT JOIN EXT_K.CPTY kk
          ON k.MODULO = kk.MODULO AND k.DATA_DANYCH = kk.DATA_DANYCH
      WHERE
        k.DATA_DANYCH = TO_DATE ('17/03/30', 'YY/MM/DD');
```

Creating Table from script

```sql
CREATE TABLE tmp_klienci_1
AS  

	  SELECT DISTINCT
        k.DATA_DANYCH, k.ID_KLIENTA, k.MODULO, k.NAZWA_KLIENTA,
        k.TYP_NBP_KOD, k.TYP_KLIENTA_KOD, k.KRAJ_KLIENTA_KOD,
        k.ILOSC_ZATR, k.PKD, k.PKD2007, k.NIP, k.PESEL_REGON, k.EKZ,
        mk.NACE,
        hk.AKTYWA_NETTO as AKTYWA_NETTO,
        hk.OBROTY_ROCZNE as OBROTY_ROCZNE,
        hk_kr.AKTYWA_NETTO as AKTYWA_NETTO_ROK,
        hk_kr.OBROTY_ROCZNE as OBROTY_ROCZNE_ROK,
        kk.LEI as KOD_LEI
      FROM M.M_KLIENCI k
        LEFT JOIN M.M_KONTRAKTY mk
          ON k.ID_KLIENTA = mk.ID_KLIENTA AND k.DATA_DANYCH = mk.DATA_DANYCH
        LEFT JOIN H.KLIENCI hk
          ON k.ID_KLIENTA = hk.ID_KLIENTA
        LEFT JOIN H.KLIENCI_KR hk_kr
          ON k.ID_KLIENTA = hk_kr.ID_KLIENTA
        LEFT JOIN EXT_K.CPTY kk
          ON k.MODULO = kk.MODULO AND k.DATA_DANYCH = kk.DATA_DANYCH
      WHERE
        k.DATA_DANYCH = TO_DATE ('17/03/30', 'YY/MM/DD');
```

Generating DDL of newly created table - this is for instalation scripts

Create INSERT for existing structure

```sql
INSERT INTO  tmp_klienci_1

      SELECT DISTINCT
        k.DATA_DANYCH, k.ID_KLIENTA, k.MODULO, k.NAZWA_KLIENTA,
        k.TYP_NBP_KOD, k.TYP_KLIENTA_KOD, k.KRAJ_KLIENTA_KOD,
        k.ILOSC_ZATR, k.PKD, k.PKD2007, k.NIP, k.PESEL_REGON, k.EKZ,
        mk.NACE,
        hk.AKTYWA_NETTO as AKTYWA_NETTO,
        hk.OBROTY_ROCZNE as OBROTY_ROCZNE,
        hk_kr.AKTYWA_NETTO as AKTYWA_NETTO_ROK,
        hk_kr.OBROTY_ROCZNE as OBROTY_ROCZNE_ROK,
        kk.LEI as KOD_LEI
      FROM M.M_KLIENCI k
        LEFT JOIN M.M_KONTRAKTY mk
          ON k.ID_KLIENTA = mk.ID_KLIENTA AND k.DATA_DANYCH = mk.DATA_DANYCH
        LEFT JOIN H.KLIENCI hk
          ON k.ID_KLIENTA = hk.ID_KLIENTA
        LEFT JOIN H.KLIENCI_KR hk_kr
          ON k.ID_KLIENTA = hk_kr.ID_KLIENTA
        LEFT JOIN EXT_K.CPTY kk
          ON k.MODULO = kk.MODULO AND k.DATA_DANYCH = kk.DATA_DANYCH
      WHERE
        k.DATA_DANYCH = TO_DATE ('17/03/30', 'YY/MM/DD');
```

Finally, creating Procedure in Packet
```sql
CREATE OR REPLACE PACKAGE BODY KLIENCI_ETL IS	
PROCEDURE krok1(p_data_danych IN DATE) IS
    BEGIN
      EXECUTE IMMEDIATE 'TRUNCATE TABLE tmp_klienci_1';
      INSERT INTO  tmp_klienci_1
        SELECT DISTINCT
          k.DATA_DANYCH, k.ID_KLIENTA, k.MODULO, k.NAZWA_KLIENTA,
          k.TYP_NBP_KOD, k.TYP_KLIENTA_KOD, k.KRAJ_KLIENTA_KOD,
          k.ILOSC_ZATR, k.PKD, k.PKD2007, k.NIP, k.PESEL_REGON, k.EKZ,
          mk.NACE,
          hk.AKTYWA_NETTO as AKTYWA_NETTO,
          hk.OBROTY_ROCZNE as OBROTY_ROCZNE,
          hk_kr.AKTYWA_NETTO as AKTYWA_NETTO_ROK,
          hk_kr.OBROTY_ROCZNE as OBROTY_ROCZNE_ROK,
          kk.LEI as KOD_LEI
        FROM M.M_KLIENCI k
          LEFT JOIN M.M_KONTRAKTY mk
            ON k.ID_KLIENTA = mk.ID_KLIENTA AND k.DATA_DANYCH = mk.DATA_DANYCH
          LEFT JOIN H.KLIENCI hk
            ON k.ID_KLIENTA = hk.ID_KLIENTA
          LEFT JOIN H.KLIENCI_KR hk_kr
            ON k.ID_KLIENTA = hk_kr.ID_KLIENTA
          LEFT JOIN EXT_K.CPTY kk
            ON k.MODULO = kk.MODULO AND k.DATA_DANYCH = kk.DATA_DANYCH
        WHERE
          k.DATA_DANYCH = p_data_danych;
    END;
```
