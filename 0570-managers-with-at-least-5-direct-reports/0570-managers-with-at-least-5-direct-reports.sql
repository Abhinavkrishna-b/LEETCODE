# Write your MySQL query statement below
SELECT name from 
Employee as e JOIN 
(
    SELECT managerID, COUNT(managerID) as reportCount from Employee 
    Group by managerID
) as innerquery
ON innerquery.reportCount >= 5 AND e.id = innerquery.managerID;