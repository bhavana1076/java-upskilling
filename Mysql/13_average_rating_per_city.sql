-- 13. Average Rating per City
-- Calculate average feedback rating of events conducted in each city.

SELECT e.city, AVG(f.rating) AS avg_rating, COUNT(f.id) AS feedback_count
FROM events e
JOIN feedback f ON f.event_id = e.id
GROUP BY e.city
ORDER BY avg_rating DESC;
