-- 1. User Upcoming Events
-- Show a list of all upcoming events a user is registered for in their city, sorted by date.
-- Params: :user_id

SELECT e.*
FROM events e
JOIN registrations r ON r.event_id = e.id
WHERE r.user_id = :user_id
  AND e.city = (SELECT city FROM users WHERE id = :user_id)
  AND e.start_date >= CURDATE()
ORDER BY e.start_date;
