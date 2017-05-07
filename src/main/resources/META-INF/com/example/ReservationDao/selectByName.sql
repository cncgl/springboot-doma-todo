SELECT
  id,
  NAME
FROM reservation
WHERE name LIKE /* @prefix(name) */'spring%' ESCAPE '$'