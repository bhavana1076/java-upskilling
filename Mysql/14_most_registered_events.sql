-- 14. Most Registered Events
-- Top 3 events based on total number of user registrations.

SELECT e.id, e.name, COUNT(r.user_id) AS registrations
FROM events e
JOIN registrations r ON r.event_id = e.id
GROUP BY e.id
ORDER BY registrations DESC
LIMIT 3;
