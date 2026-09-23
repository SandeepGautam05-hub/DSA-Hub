-- -- # Write your MySQL query statement below
-- -- Select 
-- -- a.machine_id,
-- -- b.timestamp-a.timestamp as processing_time
-- -- From Activity a
-- -- join activity b
-- -- on a.machine_id = b.machine_id
-- -- and a.process_id = b.process_id
-- -- and a.activity_type = 'start'
-- -- and b.activity_type = 'end';

-- SELECT
--     a.machine_id,
--     b.timestamp - a.timestamp AS processing_tim
-- FROM Activity a
-- JOIN Activity b
--     ON a.machine_id = b.machine_id
--     AND a.process_id = b.process_id
--     AND a.activity_type = 'start'
--     AND b.activity_type = 'end';

SELECT
    a.machine_id,
    ROUND(AVG(b.timestamp - a.timestamp), 3) AS processing_time
FROM Activity a
JOIN Activity b
    ON a.machine_id = b.machine_id
    AND a.process_id = b.process_id
    AND a.activity_type = 'start'
    AND b.activity_type = 'end'
GROUP BY a.machine_id;