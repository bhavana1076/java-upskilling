-- 9. Organizer Event Summary
-- For each organizer, show number of events created and their current status counts.

SELECT o.id AS organizer_id, o.name AS organizer_name,
  COUNT(e.id) AS total_events,
  SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) AS upcoming_events,
  SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) AS completed_events,
  SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) AS cancelled_events
FROM organizers o
LEFT JOIN events e ON e.organizer_id = o.id
GROUP BY o.id;
