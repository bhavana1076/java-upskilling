-- 11. Daily New User Count
-- Number of users who registered each day in the last 7 days.

SELECT DATE(created_at) AS day, COUNT(*) AS new_users
FROM users
WHERE created_at >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY DATE(created_at)
ORDER BY day;
