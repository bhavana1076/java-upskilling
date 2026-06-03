-- 3. Inactive Users
-- Retrieve users who have not registered for any events in the last 90 days.

SELECT u.*
FROM users u
WHERE NOT EXISTS (
  SELECT 1 FROM registrations r
  WHERE r.user_id = u.id
    AND r.created_at >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
);
