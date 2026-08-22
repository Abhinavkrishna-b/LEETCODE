# Write your MySQL query statement below

-- Refer the notes in leetcode for better understanding
select 
visited_on,
(
    select sum(amount) from Customer 
    where datediff(c.visited_on, visited_on) between 0 and 6
) as amount,
(
    select round(sum(amount)/7,2) from Customer
    where datediff (c.visited_on, visited_on) between 0 and 6
) as average_amount
from Customer as c
where visited_on >= (
    -- Any valid visited on date must be >= to 7th day as seen in the Eg 1 => date = 7
    -- So we need to fing the min date
    select date_add(min(visited_on), interval 6 day) from Customer
)
group by visited_on
order by visited_on;