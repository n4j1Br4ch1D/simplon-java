/*Seed TABLE Users:*/
INSERT INTO public.users (full_name, is_male, username, email, password, tel, ROLE, enabled)
VALUES ('Najib Rachid', TRUE, 'najib', 'najib@anmoon.ma','$2a$10$OLqXyrDqoKyGkJu.3Tr/lesUfNs05hM.ZFRHzX6e8mnkBgh5.oo4G', '06000000','ROLE_ADMIN',TRUE),
       ('Mohamed idlmhor', TRUE,'med','med@anmoon.ma','$2a$10$iZstRX1sXhxnJpGfCUI2quSxvld5XDPRbB5Scw7eq27mqntCWA59C', '06000040','ROLE_MANAGER',TRUE),
       ('Ayoub Oudor ', TRUE, 'ayoub','ayoub@anmoon.ma','$2a$10$3Rk0JxAID7kSqWYijvtB6eu7DplUsXnIMvcwr04sOGzaK3pRwk726', '06000040','ROLE_MANAGER',TRUE),
       ('Fatiha El habti', FALSE, 'fatiha','fatiha@anmoon.ma','$2a$10$uOqFjk3kQ482jDRIRaZmhe20slxLkM4c/b4YMRVfKCPOOU88HAC72', '06000090','ROLE_PARTICIPANT',TRUE),
       ('Latifa Amouguay', FALSE, 'latifa','latifa@anmoon.ma','$2a$10$HvPODtiJ1K9jmDY10iUt9.fVMSzvuTVYP4cPoMqbEV41JrtORpfbm', '06000090','ROLE_PARTICIPANT',TRUE),
       ('Anass ELmkhloufi', TRUE, 'anas', 'anas@anmoon.ma','$2a$10$U6FJN3PbkePwVUoRSG7waOt0iBRdme9r1og5jLIdfdU3VjnX0yZry', '06000090','ROLE_PARTICIPANT',TRUE),
       ('Omar Dbaa', TRUE, 'omar', 'omar@anmoon.ma','$2a$10$zTkULoo0xe9w6KDdNt185e0HvPCaxr80X/RejhnhthbNKgy8oJhiq', '06040090','ROLE_PARTICIPANT', FALSE);

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
INSERT INTO public.exercises (id, name, enabled, started_at, ended_at)
VALUES (1, 'Java Exercise', TRUE, '2022-08-22', '2022-09-22'),
       (2, 'Angular Exercise', TRUE, '2022-08-22', '2022-08-26'),
       (3, 'PostgreSQL Exercise', TRUE, '2022-08-22', '2022-10-22'),
       (4, 'Bootstrap Exercise', TRUE, '2022-08-22', '2022-09-22'),
       (5, 'Thymleaf Exercise', TRUE, '2022-08-22', '2022-08-22');

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