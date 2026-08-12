# Write your MySQL query statement below

select p.product_name, sum(o.unit) as unit from Products as p 
join Orders as o
on p.product_id = o.product_id
where year(o.order_date) = 2020 and month(o.order_date) = 2
group by p.product_id, p.product_name
having sum(o.unit) >= 100;

-- The MONTH() function in SQL extracts the month component from a date, datetime, or valid date string and returns it as an integer from 1 to 12.
-- The same concept for the YEAR()