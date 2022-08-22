/*Seed Table Users:*/
 INSERT INTO public.users 
   (full_name, email, password, tel, role, enabled,  status)
     VALUES
         ('Najib Rachid','najib@anmoon.ma','password', '06000000','admin',true  ,null),
         ('Mohamed id ','med@anmoon.ma','password', '06000040','manager',true ,null),
         ('Ayoub Oudor ','ayoub@anmoon.ma','password', '06000040','manager',true ,null),
         ('Fatiha El habti','anas@anmoon.ma','password', '06000090','participant',true ,null),
         ('Seny Balde','seny@anmoon.ma','password', '06000090','participant',true ,null),
         ('Anass EL','anas@anmoon.ma','password', '06000090','participant',true ,null),
         ('Omar db','omar@anmoon.ma','password', '06040090','participant', false  ,null);


   

INSERT INTO public.admins
    (id, level, enabled)
    VALUES
        (1, 'senior', true);

           
INSERT INTO public.managers
    (id, domain, type, enabled)
    VALUES
         (2, 'Backend','Database', true),
         (3, 'Backend','Spring boot', true);


                     
INSERT INTO public.participants
    (id ,domain ,isMale ,enabled)
    VALUES
           (4, 'Backend', false, true),
           (5, 'Backend', true, true),
           (6, 'Backend', true, false);




INSERT INTO public.activities
        (id, name, description, type, status, started_at, ended_at, manager_id, exercises_id) 
        VALUES
            (1,  'Java' , 'Java is ...' , 'Backend', 'inprogrees', 22-08-22 , null,  2, 1),
            (2,  'Angular' , 'Angular is ...' , 'Frontend','inprogrees' , 22-08-22 , null, 3, 1),
            (3,  'PostgreSQL' , 'PostgreSQL is ...' , 'Database','ended',22-08-22 , null, 2, 3),
            (4,  'Bootstrap' , 'Bootstrap is ...' , 'css framework','inprogrees' , 22-08-22 , null, 3, 4);      




INSERT INTO public.exercises 
      (id, name, startedAt, endedAt , activity_id)
        VALUES
         (1,  'Exercise1', 22-08-22, 30-08-22, 1),
         (2,  'Exercise2', 22-08-22, 12-08-22, 3),
         (3,  'Exercise3', 22-08-22, 03-08-22, 3),
         (4,  'Exercise4', 22-08-22, 27-08-22, 4);
        


INSERT INTO public.activities_participants
      (activity_id, participant_id)
        VALUES
          (1, 4),
          (1, 5),
          (1, 6),
          (2, 4),
          (3, 5);



