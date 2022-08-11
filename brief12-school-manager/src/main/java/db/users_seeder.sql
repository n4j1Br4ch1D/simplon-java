/*Seed Table Users:*/
 INSERT INTO public.users 
   (full_name, role, approved, email, password)
 VALUES
   ('Leila M`haidrat', 'admin', true, 'leila@anmoon.ma', 'password'),
   ('Najib Rachid', 'trainer', true, 'najib@anmoon.ma', 'password'),
   ('Anas Oussous', 'trainer', true, 'anas@anmoon.ma', 'password'),
   ('Fatiha El habti', 'talent', true, 'fatiha@anmoon.ma', 'password'),
   ('Seny Balde', 'talent', true, 'seny@anmoon.ma', 'password'),
   ('Ayoub Oudor', 'talent', true, 'ayoub@anmoon.ma', 'password'),
   ('mustapha ihoum', 'talent', true, 'mustapha@anmoon.ma', 'password'),
   ('nawal boulahsaire', 'talent', false, 'nawal@anmoon.ma', 'password');

 /*Seed Table Courses:*/
 INSERT INTO public.courses 
   (name, active, trainer_id)
 VALUES
   ('Java', true, 2),
   ('AngularJs', true, 2),
   ('PostgreSQL', true, 2),
   ('MySQL', false, 3),
   ('VueJs', true, 3),
   ('ReactJs', true, 3);
   
/*Seed Courses for Users:*/   
UPDATE public.users SET course_id = 1 WHERE id = 4 or id = 5;
UPDATE public.users SET course_id = 2 WHERE id = 6;
UPDATE public.users SET course_id = 4 WHERE id = 7;