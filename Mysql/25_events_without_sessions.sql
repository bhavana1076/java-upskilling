-- 25. Events Without Sessions
-- List all events that currently have no sessions scheduled under them.

SELECT e.id, e.name
FROM events e
LEFT JOIN sessions s ON s.event_id = e.id
WHERE s.id IS NULL;
