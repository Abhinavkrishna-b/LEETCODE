# Write your MySQL query statement below

select 
round(
    count(a1.player_id) / (select count(distinct player_id) from Activity)
,2) as fraction
from Activity as a1
join
(
    -- you need to find the player after the first login not consecutive log in
    -- so we need to find the 1st date of login of each player and find the consecutive login
    select player_id, 
    min(event_date) as first_date
    from Activity 
    group by player_id
) as a2
on a1.player_id = a2.player_id and datediff(a1.event_date, a2.first_date) = 1;