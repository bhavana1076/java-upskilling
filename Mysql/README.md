# MySQL Analytics Queries for Events System

This folder contains 25 SQL files implementing analytics and maintenance queries for an events management system. Each file includes a short description and a parameterized SQL query. These queries assume a conventional schema with tables such as:

- `users` (id, name, city, created_at, ...)
- `events` (id, name, city, organizer_id, start_date, status, ...)
- `organizers` (id, name, ...)
- `registrations` (id, user_id, event_id, created_at, attended, ...)
- `sessions` (id, event_id, name, start_time, end_time, speaker_id, ...)
- `feedback` (id, user_id, event_id, rating, comment, created_at, ...)
- `resources` (id, event_id, type /*pdf,image,link*/, url, uploaded_at, ...)
- `speakers` (id, name, ...)

Replace placeholders like `:user_id` with actual values when running.
