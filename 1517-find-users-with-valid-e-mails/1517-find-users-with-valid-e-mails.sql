# Write your MySQL query statement below

select *
from Users
where regexp_like(
    mail, '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode[.]com$', 'c'
)
-- ^[A-Za-z] start with (^) [A-Za-z]
-- [A-Za-z0-9_.-]* zero or more time (*)
-- In regex, . normally means any character so put [.]
-- $ ensure that the string @leetcode.com ends at last
-- The regexp is not case sensitive so you force it to be case sensitive by 'c'with regexp_like