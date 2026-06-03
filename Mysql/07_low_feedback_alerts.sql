-- 7. Low Feedback Alerts
-- List all users who gave feedback with rating < 3, with comments and event names.

SELECT f.user_id, u.name AS user_name, f.rating, f.comment, e.id AS event_id, e.name AS event_name
FROM feedback f
JOIN users u ON f.user_id = u.id
JOIN events e ON f.event_id = e.id
WHERE f.rating < 3
ORDER BY f.created_at DESC;
