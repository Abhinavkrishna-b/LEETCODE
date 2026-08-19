# Write your MySQL query statement below

-- intuition 
-- display all the names as it is but you can put id+1 or id-1 accordingly
select 
(
    case 
    when id%2 = 0 then id-1
    when id%2 = 1 and id+1 in (select id from Seat) then id+1
    else id
    end
) as id,
student
from Seat
order by id;