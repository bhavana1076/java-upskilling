-- 2. Top Rated Events
-- Identify events with the highest average rating, considering only those with at least 10 feedbacks.

SELECT e.id, e.name, AVG(f.rating) AS avg_rating, COUNT(f.id) AS feedback_count
FROM events e
JOIN feedback f ON f.event_id = e.id
GROUP BY e.id
HAVING feedback_count >= 10
ORDER BY avg_rating DESC;
