-- 24. Average Session Duration per Event
-- Compute average duration (in minutes) of sessions in each event.

SELECT event_id, AVG(TIMESTAMPDIFF(MINUTE, start_time, end_time)) AS avg_duration_minutes
FROM sessions
GROUP BY event_id;
