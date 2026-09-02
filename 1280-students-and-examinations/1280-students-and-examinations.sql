# Write your MySQL query statement below
select t1.student_id,
t1.student_name,
t1.subject_name,
count(e.student_id) as attended_exams -- the joined final table is Examinations as e
from
(
    select *
    from Students as s1
    cross join Subjects as s2
) as t1
left join Examinations as e
on t1.student_id = e.student_id and t1.subject_name = e.subject_name
group by t1.student_id, t1.student_name, t1.subject_name
order by t1.student_id, t1.subject_name;