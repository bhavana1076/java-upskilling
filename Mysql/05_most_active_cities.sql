-- 5. Most Active Cities
-- Top 5 cities with the highest number of distinct user registrations.

SELECT e.city, COUNT(DISTINCT r.user_id) AS distinct_users
FROM registrations r
JOIN events e ON r.event_id = e.id
GROUP BY e.city
ORDER BY distinct_users DESC
LIMIT 5;
