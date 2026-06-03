-- 12. Event with Maximum Sessions
-- List event(s) with the highest number of sessions.

-- First compute counts per event, then select those matching the maximum.

WITH event_counts AS (
  SELECT event_id, COUNT(*) AS session_count
  FROM sessions
  GROUP BY event_id
)
SELECT e.id, e.name, ec.session_count
FROM event_counts ec
JOIN events e ON e.id = ec.event_id
WHERE ec.session_count = (
  SELECT MAX(session_count) FROM event_counts
);
