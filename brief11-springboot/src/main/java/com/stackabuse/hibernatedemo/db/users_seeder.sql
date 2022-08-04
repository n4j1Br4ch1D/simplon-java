/*Seed Table Users:*/
 INSERT INTO public.users 
   (full_name, role, approved, email, password, tasks_number)
 VALUES
   ('Leila M`haidrat', 'admin', true, 'leila@anmoon.ma', 'password', null),
   ('Najib Rachid', 'employee', true, 'najib@anmoon.ma', 'password', 0),
   ('Anas Oussous', 'employee', true, 'najib@anmoon.ma', 'password', 1),
   ('Fatiha El habti', 'employee', false, 'anas@anmoon.ma', 'password', 2),
   ('Seny Balde', 'employee', false, 'seny@anmoon.ma', 'password', 3),
   ('Ayoub Oudor', 'employee', false, 'ayoub@anmoon.ma', 'password', 4);