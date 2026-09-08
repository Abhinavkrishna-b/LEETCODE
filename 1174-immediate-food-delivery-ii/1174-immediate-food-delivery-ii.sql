# Write your MySQL query statement below
select 
round(
    count(customer_id) / (select count(distinct customer_id) from Delivery) * 100
,2) as immediate_percentage
from Delivery
where (customer_id, customer_pref_delivery_date) in 
    (select customer_id,min(order_date)
    from Delivery
    group by customer_id);