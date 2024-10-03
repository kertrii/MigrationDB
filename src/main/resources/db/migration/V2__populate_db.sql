INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('Viktor', '1985-01-23', 'Middle', 2500),
    ('Maksim', '2006-05-05', 'Trainee', 500),
    ('Anna', '1990-07-14', 'Middle', 2100),
    ('Denis', '2000-10-01', 'Junior', 1300),
    ('Roman', '2001-09-19', 'Junior', 1800),
    ('Viktoria', '1988-12-27', 'Senior', 3000),
    ('Katerina', '1973-05-21', 'Senior', 5500),
    ('Oleksiy', '1980-08-30', 'Senior', 7000),
    ('Sofia', '2006-03-08', 'Trainee', 500),
    ('Maksim', '2003-02-24', 'Junior', 1700);

INSERT INTO client (ID, NAME)
VALUES
    (1, 'Oleksandra'),
    (2, 'Andriy'),
    (3, 'Katya'),
    (4, 'Kirill'),
    (5, 'Petro'),
    (6, 'Oleg');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (2, '2024-03-01', '2025-03-08'),
    (3, '2021-07-03', '2023-10-05'),
    (3, '2024-09-11', '2024-12-22'),
    (5, '2019-08-29', '2020-02-14'),
    (4, '2020-05-28', '2025-05-28'),
    (6, '2023-09-10', '2023-10-11'),
    (5, '2022-04-23', '2023-08-15'),
    (5, '2024-02-25', '2024-07-18'),
    (2, '2024-01-31', '2024-11-24'),
    (6, '2021-06-29', '2023-02-14');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 9),
    (2, 6), (2, 2), (2, 3),
    (3, 7),
    (4, 5), (4, 4),
    (5, 1),
    (6, 8),
    (7, 1), (7, 9),
    (8, 10), (8, 4), (8, 5), (8, 3),
    (9, 6),
    (10, 7), (10, 8);