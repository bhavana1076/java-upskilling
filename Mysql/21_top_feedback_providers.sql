-- 21. Top Feedback Providers
-- Top 5 users who have submitted the most feedback entries.

SELECT u.id, u.name, COUNT(f.id) AS feedback_count
FROM users u
JOIN feedback f ON f.user_id = u.id
GROUP BY u.id
ORDER BY feedback_count DESC
LIMIT 5;
