-- 6. Event Resource Summary
-- Number of resources (PDFs, images, links) uploaded for each event.

SELECT event_id,
  SUM(CASE WHEN type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
  SUM(CASE WHEN type = 'image' THEN 1 ELSE 0 END) AS image_count,
  SUM(CASE WHEN type = 'link' THEN 1 ELSE 0 END) AS link_count,
  COUNT(*) AS total_resources
FROM resources
GROUP BY event_id;
