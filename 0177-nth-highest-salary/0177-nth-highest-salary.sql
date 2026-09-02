CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
-- you need to set n = n-1 because offset is based on 0th index but according to syntax you cannot give offset n-1 here
SET N = N-1;
  RETURN (
    # Write your MySQL query statement below.
    select distinct salary from Employee
    order by salary desc
    limit 1 offset N
  );
END