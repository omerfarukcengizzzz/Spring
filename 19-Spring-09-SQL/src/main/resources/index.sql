CREATE TABLE Towns
(
    id      SERIAL UNIQUE NOT NULL,
    code    VARCHAR(10)   NOT NULL, -- not unique
    article TEXT,
    name    TEXT          NOT NULL  -- not unique
);

create index idx_towns_name on towns (name);
drop index if exists idx_towns_name;

insert into towns (code, article, name)
select left(md5(i::text), 10),
    md5(random()::text),
    md5(random()::text)
from generate_series(1, 1000000) s(i);

explain analyze
select *
from towns
where name = '4de3193755c5b5453eaf7080c9536663';

select tablename,
       indexname,
       indexdef
FROM pg_indexes
WHERE schemaname = 'public'
ORDER BY tablename,
         indexname;