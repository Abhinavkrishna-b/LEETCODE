# Write your MySQL query statement below
select round(sum(tiv_2016),2) as tiv_2016
from Insurance as i1
where tiv_2015 in (
    select tiv_2015 from Insurance as i2
    where i1.pid <> i2.pid
)
and (lat,lon) not in (
    select lat,lon from Insurance as i3
    where i1.pid <> i3.pid
);