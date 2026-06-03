-- 16. Unregistered Active Users
-- Users who created an account in the last 30 days but haven’t registered for any events.

SELECT u.*
FROM users u
WHERE u.created_at >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
  AND NOT EXISTS (
    SELECT 1 FROM registrations r WHERE r.user_id = u.id
  );
