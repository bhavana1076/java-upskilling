-- 8. Sessions per Upcoming Event
-- Display upcoming events with the count of sessions scheduled for them.

SELECT e.id, e.name, COUNT(s.id) AS session_count
FROM events e
LEFT JOIN sessions s ON s.event_id = e.id
WHERE e.start_date >= CURDATE()
GROUP BY e.id
ORDER BY e.start_date;
