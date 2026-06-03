-- 17. Multi-Session Speakers
-- Identify speakers who are handling more than one session across all events.

-- If sessions have `speaker_id`:
SELECT sp.id, sp.name, COUNT(s.id) AS session_count
FROM speakers sp
JOIN sessions s ON s.speaker_id = sp.id
GROUP BY sp.id
HAVING session_count > 1;

-- If there is a mapping table `session_speakers(session_id, speaker_id)`, swap join accordingly.
