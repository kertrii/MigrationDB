WITH month_counts AS (
    SELECT
        CONCAT('Project #', ID) AS project_name,
        DATEDIFF('MONTH', START_DATE, FINISH_DATE) AS month_count
    FROM
        project
),
     max_month_count AS (
         SELECT
             MAX(month_count) AS max_count
         FROM
             month_counts
     )
SELECT
    project_name,
    month_count
FROM
    month_counts
WHERE
    month_count = (SELECT max_count FROM max_month_count);