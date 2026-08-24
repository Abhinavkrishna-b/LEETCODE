# Write your MySQL query statement below
select d.name as Department,
e.name as Employee,
e.salary as Salary
from Employee as e 
join Department as d
on e.departmentId = d.id
where 3 > (
    select count(distinct salary) from Employee as e1
    where e.departmentId = e1.departmentId and 
    e1.salary > e.salary
);