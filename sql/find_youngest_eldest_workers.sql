(SELECT
     'YOUNGEST' AS type,
     NAME,
     BIRTHDAY
 FROM
     worker
 ORDER BY
     BIRTHDAY DESC
     LIMIT 1)

UNION

(SELECT
     'OLDEST' AS type,
     NAME,
     BIRTHDAY
 FROM
     worker
 ORDER BY
     BIRTHDAY
     LIMIT 1);