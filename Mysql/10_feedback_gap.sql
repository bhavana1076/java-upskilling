-- 10. Feedback Gap
-- Identify events that had registrations but received no feedback at all.

SELECT e.id, e.name
FROM events e
WHERE EXISTS (
  SELECT 1 FROM registrations r WHERE r.event_id = e.id
)
AND NOT EXISTS (
  SELECT 1 FROM feedback f WHERE f.event_id = e.id
);
