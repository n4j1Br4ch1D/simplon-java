/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, is_male, email, password, tel, ROLE, enabled)
VALUES ('Najib Rachid', TRUE, 'najib@anmoon.ma','password', '06000000','admin',TRUE),
       ('Mohamed id ', TRUE,'med@anmoon.ma','password', '06000040','manager',TRUE),
       ('Ayoub Oudor ', TRUE, 'ayoub@anmoon.ma','password', '06000040','manager',TRUE),
       ('Fatiha El habti', FALSE, 'anas@anmoon.ma','password', '06000090','participant',TRUE),
       ('Seny Balde', TRUE, 'seny@anmoon.ma','password', '06000090','participant',TRUE),
       ('Anass EL', TRUE, 'anas@anmoon.ma','password', '06000090','participant',TRUE),
       ('Omar db', TRUE, 'omar@anmoon.ma','password', '06040090','participant', FALSE);

/*Seed Table Admins:*/
INSERT INTO public.admins (id, LEVEL)
VALUES (1, 'senior');

/*Seed Table Managers:*/
INSERT INTO public.managers (id, DOMAIN, TYPE)
VALUES (2, 'Backend','trainer'),
       (3, 'Frontend','speaker');

/*Seed Table Participants:*/
INSERT INTO public.participants (id, DOMAIN)
VALUES (4, 'Backend'),
       (5, 'Frontend'),
       (6, 'Backend');

/*Seed Table Activities:*/
INSERT INTO public.activities (id, name, description, TYPE, enabled, started_at, ended_at, manager_id)
VALUES (1, 'Java', 'Java is ...', 'training', TRUE, '2022-08-22', '2022-08-22', 2),
       (2, 'Angular', 'Angular is ...', 'talking', TRUE, '2022-08-22', '2022-08-26', 2),
       (3, 'PostgreSQL', 'PostgreSQL is ...', 'event', TRUE, '2022-08-22', '2022-10-22', 2),
       (4, 'Bootstrap', 'Bootstrap is ...', 'training', TRUE, '2022-08-22', '2022-09-22', 3),
       (5, 'Thymleaf', 'Thymleaf is ...', 'training', FALSE, '2022-08-22', '2022-08-22', 3);

/*Seed Table Exercises:*/
INSERT INTO public.exercises (id, name, enabled, started_at, ended_at, activity_id)
VALUES (1, 'Java Exercise', TRUE, '2022-08-22', '2022-09-22', 1),
       (2, 'Angular Exercise', TRUE, '2022-08-22', '2022-08-26', 3),
       (3, 'PostgreSQL Exercise', TRUE, '2022-08-22', '2022-10-22', 3),
       (4, 'Bootstrap Exercise', TRUE, '2022-08-22', '2022-09-22', 4),
       (5, 'Thymleaf Exercise', TRUE, '2022-08-22', '2022-08-22', 5);

/*Seed an Update exercise_id Table Activities:*/
UPDATE public.activities
SET exercise_id = 1
WHERE id = 1;


UPDATE public.activities
SET exercise_id = 2
WHERE id = 2;


UPDATE public.activities
SET exercise_id = 3
WHERE id = 3;


UPDATE public.activities
SET exercise_id = 4
WHERE id = 4;


UPDATE public.activities
SET exercise_id = 5
WHERE id = 5;

/*Seed Table Activities Participants:*/
INSERT INTO public.participant_activities (activity_id, participant_id, activity_status, excercice_status)
VALUES (1, 4, 'ended', 'ended'),
       (1, 5, 'ended', 'in-progress'),
       (1, 6, 'in-progress', 'ended'),
       (2, 4, 'in-progress', 'in-progress'),
       (3, 5, 'in-progress', 'in-progress');