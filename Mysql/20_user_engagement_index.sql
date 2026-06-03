-- 20. User Engagement Index
-- For each user, calculate how many events they attended and how many feedbacks they submitted.

SELECT u.id, u.name,
  COALESCE(SUM(CASE WHEN r.attended = 1 THEN 1 ELSE 0 END), 0) AS events_attended,
  COALESCE(COUNT(f.id), 0) AS feedbacks_submitted
FROM users u
LEFT JOIN registrations r ON r.user_id = u.id
LEFT JOIN feedback f ON f.user_id = u.id
GROUP BY u.id;
