# Write your MySQL query statement below

-- Refer the notes(in leetcode platform itself) for better understanding and intuition
(select u.name as results
from MovieRating as m 
join Users as u
on m.user_id = u.user_id
group by m.user_id, u.name
order by count(*) desc, u.name asc
limit 1)

union all

(select m2.title as results
from MovieRating as m1
join Movies as m2
on m1.movie_id = m2.movie_id
where m1.created_at >= "2020-02-01" and m1.created_at <= "2020-02-29"
group by m1.movie_id, m2.title
order by avg(rating) desc, m2.title asc
limit 1);