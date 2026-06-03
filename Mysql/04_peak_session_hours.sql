-- 4. Peak Session Hours
-- Count how many sessions are scheduled between 10:00 and 12:00 for each event.

SELECT event_id, COUNT(*) AS sessions_10_12
FROM sessions
WHERE TIME(start_time) >= '10:00:00'
  AND TIME(start_time) < '12:00:00'
GROUP BY event_id;
