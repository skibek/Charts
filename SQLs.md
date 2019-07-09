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

```
