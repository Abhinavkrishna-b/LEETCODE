# Write your MySQL query statement below
-- Use the LEFT function to get the YYYY-MM part from the trans_date. The LEFT() function extracts a number of characters from a string (starting from left).

select left(trans_date,7) as month,
country,
count(id) as trans_count,
sum(if(state = 'approved',1,0)) as approved_count,
sum(amount) as trans_total_amount,
sum(if(state = 'approved',amount,0)) as approved_total_amount
from Transactions
group by month, country;