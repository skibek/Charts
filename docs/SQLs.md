ORACLE

List table names in Schema

```sql
SELECT OBJECT_NAME
FROM USER_OBJECTS
WHERE OBJECT_TYPE = 'TABLE' order by OBJECT_NAME;
```

Data Size

```sql
select owner, table_name, round((num_rows*avg_row_len)/(1024*1024)) MB , num_rows
from all_tables
where owner like 'COREP_TEST%'  -- Exclude system tables.
and num_rows > 0  -- Ignore empty Tables.
order by MB desc -- Biggest first.
;
 
 
begin
   dbms_stats.gather_table_stats('COREP_TEST','DATA_KONTRAKTY_WYNIKI');
end;
```

Fast delete tables

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

Size of a Schema
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

```

- - - 
Other SQLs - almost ETL
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
