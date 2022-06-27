/*Seed Table Users:*/
 INSERT INTO public.users 
   (email, password, first_name, last_name, approved)
 VALUES
   ('najib@anmoon.ma','password', 'najib', 'rachid', true),
   ('mustapha@anmon.ma','password', 'mustapha', 'ihoum', true),
   ('nawal@anmoon.ma','password', 'nawal', 'boulahsaire', false);

/*Update Make Some Users Admins:*/
 UPDATE public.users SET role_type = 'admin' WHERE id = 1;

/*Seed Table Categories:*/
INSERT INTO 
  public.categories (name, img)
VALUES
  ('presentation','presentation.jpg'),
  ('watch','watch.jpg'),
  ('research','research.jpg');


/*Seed Table Tasks:*/
INSERT INTO 
public.tasks (name, description, status, tobefinished_at, finished_at, category_id)
VALUES
('watch java story','ill watch a video talking about how java come about.', 'not-yet', '2022-06-16 10:48:45.681703+02', '2022-06-16 10:48:45.681703+02', 2),
('make this app migration','ill have to make table for users, cats & tasks.', 'done', '2022-06-16 10:48:45.681703+02', '2022-06-16 10:48:45.681703+02', null),
('searching java','ill have to make a search aboute thread-safe, stateless , immutiblity in java', 'not-yet', '2022-06-16 10:48:45.681703+02', '2022-06-16 10:48:45.681703+02', 3),
('next brief presentation', 'ill have to think about atopic for my next presntation i have docker and microservices', 'in-progress', '2022-06-16 10:48:45.681703+02', '2022-06-16 10:48:45.681703+02', 1);
