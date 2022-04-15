create or replace function get_department_count_by_name(dep_name varchar)
    returns int
    language plpgsql
as
$$
declare
department_count integer;
begin
select count(*)
into department_count
from employees
where department = dep_name;

return department_count;
end;
$$;

select get_department_count_by_name('Sports');