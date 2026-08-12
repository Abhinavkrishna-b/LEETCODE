# Write your MySQL query statement below
-- also refer the other submissions

select 
s.user_id, 
round(
    sum(
        case
            when c.action = 'confirmed' then 1
            else 0
        end
    ) / count(s.user_id)
    ,2
) as confirmation_rate
from Signups as s
left join Confirmations as c
on s.user_id = c.user_id 
-- here you not give c.action = 'confirmed' because you also need the non conformed row to get avg
group by s.user_id;

-- you can also use the avg - basically no of confirmed msg / total msg is avg of confirmed msg