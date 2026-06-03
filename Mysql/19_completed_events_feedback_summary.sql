-- 19. Completed Events with Feedback Summary
-- For completed events, show total registrations and average feedback rating.

SELECT e.id, e.name,
  COUNT(DISTINCT r.user_id) AS total_registrations,
  AVG(f.rating) AS avg_feedback_rating
FROM events e
LEFT JOIN registrations r ON r.event_id = e.id
LEFT JOIN feedback f ON f.event_id = e.id
WHERE e.status = 'completed'
GROUP BY e.id;
