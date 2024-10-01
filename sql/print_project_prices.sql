SELECT
    CONCAT('Project #', p.ID) AS project_name,
    SUM(w.SALARY * (DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE))) AS price
FROM
    project p
        JOIN
    project_worker pw ON p.ID = pw.PROJECT_ID
        JOIN
    worker w ON pw.WORKER_ID = w.ID
GROUP BY
    p.ID
ORDER BY
    price DESC;