-- 23. Registration Trends
-- Month-wise registration count trend over the past 12 months.

SELECT DATE_FORMAT(created_at, '%Y-%m') AS month, COUNT(*) AS registrations
FROM registrations
WHERE created_at >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY month
ORDER BY month;
