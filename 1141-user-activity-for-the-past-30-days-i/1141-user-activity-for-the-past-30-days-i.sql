# Write your MySQL query statement below

select activity_date as day,
count( distinct user_id) as active_users
from Activity
group by activity_date
having day > "2019-06-27" and day <= "2019-07-27";