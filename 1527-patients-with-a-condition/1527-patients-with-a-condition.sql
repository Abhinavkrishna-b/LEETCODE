# Write your MySQL query statement below

-- DIAB1%       → DIAB1 is at the beginning
-- % DIAB1%     → DIAB1 comes after a space
select patient_id, patient_name, conditions
from Patients
where conditions like  'DIAB1%' or conditions like '% DIAB1%';