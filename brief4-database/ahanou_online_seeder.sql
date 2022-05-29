



/*Seed Table Users:*/
 INSERT INTO public.users 
   (email, password, first_name, last_name, approved)
 VALUES
   ('najib@anmoon.ma','password', 'najib', 'rachid', true),
   ('mustapha@anmon.ma','password', 'mustapha', 'ihoum', true),
   ('nawal@anmoon.ma','password', 'nawal', 'boulahsaire', false);

/*Update Make Some Users Admins:*/
 UPDATE public.users SET role_type = 'admin', updated_at=now()   WHERE id = 1;

/*Seed Table Categories:*/
INSERT INTO 
  public.categories (name, img)
VALUES
  ('oils','oils.jpg'),
  ('spices','spices.jpg'),
  ('vegetables','vegetables.jpg');

/*Seed Table Products:*/
INSERT INTO 
public.products (name, img , description, price, unit, city, category_id)
VALUES
('Saffron','saffron.jpg', 'Saffron is a spice derived from the flower of Crocus sativus, commonly known as the "saffron crocus".', 25, 'gram', 'Taliouine', 2),
('Garlic','garlic.jpg', 'Garlic is a species of bulbous flowering plant in the genus Allium. Its close relatives include the onion...', 40, 'kilogram', 'Asakui', 2),
('Argan','argan.jpg', 'Argan oil is a plant oil produced from the kernels of the argan tree that is endemic to Morocco. In Morocco...', 400, 'liter', 'Taroudant', 1),
('Ratte potato','ratte-potato.jpg', 'The Ratte potato is a small potato with a unique nutty flavor and smooth, buttery texture...', 15, 'kilogram', 'Tiznit', 3);

/*Seed Table Votes:*/ 
  INSERT INTO 
  public.votes (vote_percent, client_id, product_id)
VALUES
  (85, 3, 3),
  (90, 3, 1),
  (100, 2, 4),
  (30, 2, 3);
