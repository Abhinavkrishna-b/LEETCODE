# Write your MySQL query statement below

-- MySQL is designed to be forgiving with data analysis. In MySQL, any number divided by 0 results in NULL.

SELECT 
    s.user_id, 
    ROUND(IFNULL(SUM(IF(c.action = 'confirmed', 1, 0)) / COUNT(c.user_id), 0), 2) AS confirmation_rate
FROM 
    Signups s
LEFT JOIN 
    Confirmations c ON s.user_id = c.user_id
GROUP BY 
    s.user_id;

-- you can also use the avg - basically no of confirmed msg / total msg is avg of confirmed msg