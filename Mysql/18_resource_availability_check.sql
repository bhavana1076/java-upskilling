-- 18. Resource Availability Check
-- List all events that do not have any resources uploaded.

SELECT e.id, e.name
FROM events e
LEFT JOIN resources r ON r.event_id = e.id
WHERE r.id IS NULL;
