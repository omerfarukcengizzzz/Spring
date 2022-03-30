select *
from departments;

select *
from employees;

select *
from regions;

select employee_id, first_name, department
from employees;

select *
from employees
where department = 'Sports';

select *
from employees
where department like 'F%nit%';

select *
from employees
where salary > 100000;

select *
from employees
where salary < 100000;

select *
from employees
where department = 'Computers'
  and salary > 100000
  and region_id = 2;

select *
from employees
where department = 'Clothing'
   or department = 'Computers';

select *
from employees
where salary < 40000
  and (department = 'Clothing' or department = 'Pharmacy');

select *
from employees
where department != 'Sports';
-- != same as <>

select *
from employees
where not department = 'Sports';

select *
from employees
where email is null;

select *
from employees
where email is not null;

select *
from employees
where department = 'Sports'
or department = 'First Aid'
or department = 'Toys'
or department = 'Garden';

select *
from employees
where department in ('Sports', 'First Aid', 'Toys');

select *
from employees
where salary between 80000 and 100000;

select first_name, email
from employees
where gender = 'F'
  and department = 'Tools'
  and salary > 110000;

select first_name, hire_date
from employees
where salary > 165000
   or (department = 'Sports' and gender = 'M');

select *
from employees
order by employee_id;

select *
from employees
order by employee_id desc;

select distinct department
from employees;

select distinct department
from employees
    fetch first 3 row only;

select salary as yearly_salary
from employees;

select upper(first_name) as name, lower(department) as dp
from employees;

select length(first_name)
from employees;

select trim('    Hello there!    ');

select length(trim('    Hello there!    '));

select first_name || ' ' || last_name as full_name
from employees;

select (salary > 140000)
from employees;

select first_name || ' ' || last_name as full_name, (salary > 140000) as highly_paid
from employees
order by salary desc;

select department, (department like '%oth%')
from employees;

select 'This is test data' as test_data;

select substring('this is test data' from 1 for 5);

select substring('this is test data' from 9) as test_data;

select department, replace(department, 'Clothing', 'Clothes')
from departments;

select max(salary)
from employees;

select min(salary)
from employees;

select avg(salary)
from employees;

select round(avg(salary))
from employees;

select count(employee_id)
from employees;

select count(email)
from employees;

select sum(salary)
from employees
where department = 'Clothing';

select first_name || ' ' || last_name as full_name, upper(substring(department, 1, 3)) as department
from employees;

select max(salary), min(salary)
from employees
where first_name != 'Wilson';

select count(*), department
from employees
group by department;

select sum(salary) as total_salary, department
from employees
where department = 'Beauty'
group by department;

select min(salary), max(salary), avg(salary), count(*) as employee_count, department
from employees
group by department;

select sum(salary) as total_salary, department
from employees
where region_id in (4, 5, 6)
group by department;

select department, count(*)
from employees
group by department
order by department asc;

select department, count(*)
from employees
group by department
having count(department) < 36
order by department asc;

select count(*), substring(email, position('@' in email)+1) as email_domain
from employees
where email is not null
group by email_domain;

select e.department, d.department
from employees e, departments d;

select *
from employees
where department not in (select department from departments);

select *
from (select * from employees where salary > 150000) as a;

select first_name, last_name
from (select first_name, last_name from employees) as b;

select *
from employees
where department in (select department from departments where division like 'Electronics');

select *
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'))
and salary > 130000;

select first_name || ' ' || last_name as name, (select max(salary) from employees) - salary as less_from_max_salary
from employees
where region_id in (select region_id from regions where country in ('Asia', 'Canada'))
and first_name != 'Jacklyn';

select *
from employees
where department = any(select department from departments where division = 'Kids')
  and hire_date > all(select hire_date from employees where department = 'Maintenance');

select first_name, salary,
case
    when salary < 100000 then 'Under Paid'
    when salary > 100000 then 'Well Paid'
    else 'Unpaid'
end as category
from employees;

select category, count(*)
from (select first_name,salary, case
                                    when salary < 100000 then 'Under Paid'
                                    when salary > 100000 and salary < 160000 then 'Well Paid'
                                    else 'Executive'
                                end as category
    from employees) as a
group by category;

select first_name, country
from employees e,
     regions r
where r.region_id = e.region_id;

select first_name, email, division
from employees e,
     departments d,
     regions r
where e.department = d.department
  and e.region_id = r.region_id;

select first_name, country
from employees
         inner join regions
                    on employees.region_id = regions.region_id;

select first_name, email, division
from employees
         inner join departments
                    on employees.department = departments.department
where email is not null;

select first_name, email, division, country
from employees e
         inner join departments d
                    on e.department = d.department
         inner join regions r
                    on e.region_id = r.region_id
where e.email is not null;

select distinct department
from employees; --27

select distinct department
from departments; --24

select distinct e.department, d.department
from employees e
         left outer join departments d on e.department = d.department;

select distinct e.department, d.department
from employees e
         right outer join departments d on e.department = d.department;

select distinct e.department, d.department
from employees e
         full join departments d on e.department = d.department;

select department
from employees
union
select department
from employees
union
select country
from regions;

select department
from employees
union all
select department
from employees;

select department
from employees
except
select department
from departments;