# Write your MySQL query statement below
select u.name,
sum(
    ifnull(t.amount,0)
) as balance
from Users as u
left join Transactions as t
on u.account = t.account
group by u.account, u.name
having balance > 10000;