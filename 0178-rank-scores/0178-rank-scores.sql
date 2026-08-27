# Write your MySQL query statement below
-- Intiution is find all the distinct scores that is greater than current score and +1 gives you the rank of that score

select s1.score,
(
    select count(distinct score) from Scores as s2
    where s1.score < s2.score
) +1 as 'rank'
from Scores as s1
order by s1.score desc;