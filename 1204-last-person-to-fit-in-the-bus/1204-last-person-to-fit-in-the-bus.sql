# Write your MySQL query statement below

select a.person_name
from Queue as a 
join Queue as b
on a.turn >= b.turn
group by a.turn
having sum(b.weight) <= 1000 -- here we are filtering all the persons within or equal to our range of 1000
order by a.turn desc -- here desc because the last person only we need
limit 1;

-- Better first execute the join and you can understand
-- select * from Queue as q1 join Queue as q1 on q1.turn >= q2.turn order by q1.turn;
-- and from here you you can group by and use having
