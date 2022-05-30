# :garlic: Ahanou Online

Model and implement the database of a web application to exhibit local products in the region with voting system.

 - :date: Date Started: **26-05-2022.** 
 - :computer: Developed By: [NajibRachid](https://github.com/n4j1Br4ch1D) && [MustaphaIhoum](https://github.com/ihoumm)  && [NawalBoulahsaire](https://github.com/BOULAHSAIRE).
 - :office: Developed At: TechnoPark Agadir, Simplon Talent4Startups, Group *SoussTalents101*.
 - :pushpin: Version: **Alpha Version 0.0.1**.

---

## Trello Workspace Link
[Agile Sprint Board](https://trello.com/b/5H1idTXv/agile-sprint-board)

## Project Scope Statement

<div style="display:flex">
<img src="/brief4-database/1.PNG" height="200" width="300"/>
<img src="/brief4-database/2.PNG" height="200" width="300"/>
<img src="/brief4-database/3.PNG" height="200" width="300"/>
</div>

[Ahanou Project Scope Statement(Cahier des charges).](https://docs.google.com/document/d/13BMaJ3Wtsd5IpteMFtCpJZ_XhhdpAdW5CRWlVEjHfho/edit?usp=sharing)

## Use case diagram

<div style="display:flex">
<img src="/brief4-database/useCase.png" height="200" width="300"/>
</div>

[DiagCasUtilisation_Breif4.boo](/brief4-database/DiagCasUtilisation_Breif4.boo)

## Class diagram

<div style="display:flex">
<img src="/brief4-database/class_diagram.png" height="200" width="300"/>
</div>

[diagram_class_ahanou.boo](/brief4-database/diagram_class_ahanou.boo)


## Database Model Sketch

<div style="display:flex">
<img src="/brief4-database/DBModelSketch.jpg" height="200" width="300"/>
</div>

## Database Snapshots

<div style="display:flex">
<img src="/brief4-database/db_users.png" height="200" width="300"/>
<img src="/brief4-database/db_products.png" height="200" width="300"/>
<img src="/brief4-database/db_categories.png" height="200" width="300"/>
<img src="/brief4-database/db_votes.png" height="200" width="300"/>
</div>

## Download Links

[:arrow_down: ahanou_online_migration.sql](/brief4-database/ahanou_online_migration.sql)     
[:arrow_down: ahanou_online_seeder.sql](/brief4-database/ahanou_online_seeder.sql)      
[:arrow_down: ahanou_online_full.sql](/brief4-database/ahanou_online_full.sql)

## Database Migration 

  ```sql
  
  /*Create database Ahanou:*/
  CREATE DATABASE "Ahanou";
  
  /*Drope Table Users:*/ 
  DROP TABLE public.users;

  /*Create Table Users:*/
  CREATE TABLE IF NOT EXISTS public.users
  (
   id serial NOT NULL,
   email char(45) NOT NULL,
   password char(45) NOT NULL,
   first_name char(25) NOT NULL,
   last_name char(25) NOT NULL,
   approved boolean NOT NULL DEFAULT false,
   created_at timestamp with time zone NOT NULL DEFAULT NOW(),
   updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
   CONSTRAINT "Users_pkey" PRIMARY KEY (id, email),
   UNIQUE (id)
 )

  /*Alter Table Users Add Role Column:*/
  ALTER TABLE public.users ADD "role_type" char(6);
  ALTER TABLE public.users Alter COLUMN "role_type" SET DEFAULT 'client';
  
  /*Select Table Users:*/
  SELECT * from public.users;
  
  /*Drop Table Categories:*/
  DROP TABLE public.categories;

  /*Create Table Categories:*/
  CREATE TABLE IF NOT EXISTS public.categories
  (
    id serial NOT NULL,
    name char(45) NOT NULL,
    img char(255),
    created_at timestamp with time zone NOT NULL DEFAULT NOW(),
    updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
    CONSTRAINT "categories_pkey" PRIMARY KEY (id, name),
    UNIQUE (id)
  )

  /*Select Table Categories:*/
   SELECT * from public.categories;
 
  /*Drop Table Products:*/
  DROP TABLE public.products;
 
  /*Create Table Products:*/
  CREATE TABLE IF NOT EXISTS public.products
  (
  id serial NOT NULL,
  name char(45) NOT NULL,
  img char(255) NOT NULL,
  description text,
  price float NOT NULL,
  unit  char(18) NOT NULL,
  city char(25) NOT NULL,
  category_id int,
  created_at timestamp with time zone NOT NULL DEFAULT NOW(),
  updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
  CONSTRAINT "products_pkey" PRIMARY KEY (id, name),
     UNIQUE (id),
  CONSTRAINT "category_fkey"
    FOREIGN KEY(category_id) 
    REFERENCES public.categories(id) MATCH SIMPLE
      ON UPDATE NO ACTION
      ON DELETE NO ACTION
      NOT VALID
 );
 
  /*Select Table Products:*/
  SELECT * from public.products;

  /*Drop Table Votes:*/ 
  DROP TABLE public.votes;
  
  /*Create Table Votes:*/ 
  CREATE TABLE IF NOT EXISTS public.votes
  (
    id serial NOT NULL,
    vote_percent int NOT NULL,
    client_id int NOT NULL,
	product_id int NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT NOW(),
    updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
    CONSTRAINT "votes_pkey" PRIMARY KEY (id),
	UNIQUE (id),
    CONSTRAINT "client_fkey"
      FOREIGN KEY(client_id) 
      REFERENCES public.users(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
	 CONSTRAINT "product_fkey"
      FOREIGN KEY(product_id) 
      REFERENCES public.products(id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
  )
  
  /*Select Table Votes:*/ 
   SELECT * from public.votes;
    
 ```

## Database Seeder

  ```sql
  
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
    
 ```
 
 ## Database CRUDs & Operations

  ```sql
  
  /************** Users(Authentication & Autherization) **************/
  
  /*Register:*/
   INSERT INTO public.users 
   (email, password, first_name, last_name)
 VALUES
   ('latifa@anmoon.ma','qwerty123', 'latifa', 'amougauay');
  
  /*Login:*/
   SELECT * FROM public.users where email='latifa@anmoon.ma' AND  password='123qwerty';  /*Wrong email or password!*/
   SELECT * FROM public.users where email='latifa@anmoon.ma' AND  password='qwerty123';  /*Correct email & password!*/
    
  /*List users:*/
   SELECT * FROM public.users;

  /*List clients:*/
   SELECT * FROM public.users WHERE role_type='client';
  
  /*Add user:*/
   INSERT INTO public.users 
 (email, password, first_name, last_name, approved)
    VALUES
 ('omar@anmoon.ma','password', 'omar', 'dbaa', true);
 
  /*View user:*/
   SELECT * FROM public.users WHERE id=1;
  
  /*Approve user:*/
  UPDATE public.users SET approved = true WHERE id = 3;

  /*Edit user:*/
   UPDATE public.users SET email ='najibadmin@anmoon.ma', updated_at=now()  WHERE id = 1;

  /*Delete user:*/
   DELETE FROM public.users WHERE id= 6;

  /*Check Role if Admin*/
   SELECT * FROM public.users WHERE id = 1 AND role_type='admin';  /*True!*/
   SELECT * FROM public.users WHERE id = 2 AND role_type='admin';  /*False!*/

  /*Check Role if Client & Approved*/
  SELECT * FROM public.users WHERE id =  2 AND role_type='client' AND approved= true;  /*True!*/
  SELECT * FROM public.users WHERE id =  4 AND role_type='client' AND approved= true;  /*False!*/

  /************** Products **************/
  
  /* Count Number Of Products: */
  SELECT COUNT(id) FROM public.products;

  /*List products order by most voted (number of votes):*/
  SELECT public.products.name,
COUNT(public.votes.vote_percent) AS votes_number FROM public.products
LEFT JOIN public.votes ON public.votes.product_id = public.products.id
GROUP BY name;

  /*List products order by most voted (percentage):*/
  SELECT public.products.id, public.products.name, public.products.img, public.products.description,
public.products.price, public.products.unit, public.products.category_id,
SUM(public.votes.vote_percent) AS votes_percent_total,
COUNT(public.votes.vote_percent) AS votes_number FROM public.products
LEFT JOIN public.votes ON public.votes.product_id = public.products.id
LEFT JOIN public.categories ON public.categories.id = public.products.category_id
GROUP BY public.products.id, public.products.name, public.products.img, description,price,unit,category_id
ORDER BY votes_percent_total DESC NULLS LAST;
  
  /*List product client voted for:*/
  SELECT *, public.votes.vote_percent FROM public.products
LEFT JOIN public.votes ON public.votes.product_id = public.products.id
WHERE client_id = 2;

  /*View Product with votes:*/ 

  /*Add Product:*/ 
 INSERT INTO public.products 
(name, img, description, price, unit, city, category_id)
  VALUES
('Orange','orange.jpg', ' a fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus × sinensis, which is also called sweet orange,', 3, 'kilogram', 'Houara', null);

/*Edit Product:*/ 
 UPDATE public.products SET price = 6, updated_at=now()  WHERE name = 'Orange';

/*Delete Product:*/ 
DELETE FROM public.products WHERE id= 5;

  /*Vote Produt(retract/modify if vote exist):*/ 
UPDATE public.votes SET client_id = 2, vote_percent=50, updated_at=now() WHERE product_id = 1;

  /************** Categories **************/
  
  /*List categories*/
  SELECT * FROM public.categories;

/*List a category products*/
select * from public.products where category_id = 2;
 
select * from public.products
inner join public.categories ON public.categories.id = public.products.category_id
where public.categories.name = 'spices';

/*View category:*/ 
SELECT * FROM public.categories WHERE id=1;

/*Add category:*/ 
 INSERT INTO public.categories 
(name, img) VALUES
('fruits','fruits.png');

/*Edit category:*/ 
 UPDATE public.categories SET img ='fruits.jpg', updated_at=now()  WHERE name = 'fruits';

/*Delete category:*/ 
DELETE FROM public.categories WHERE id= 4;

/*Get most voted category:*/ 

  /* Notes: To Do
      get yearly  
      with category
      join 3 tables.
   */
   
```

## Tools

- PowerDesigner.
- MarkDown.
- Google Docs.
- PostgreSQL.
- Trello.
- Discord.

## The 5Ws of the project

- **What?**   
 
   A Web application allowing to expose local products of the region. for selling, also managing competition voting on best product of the year.
 
- **Why?** 

  This project to bring regional products closer to visitors also determning the best product of the year.

- **Where?** 

   Products are Locale to Morocco but they are aimed to be advertised & voted internationaly/Globaly.
  
- **When?**  

  The competition will be seasonal as some products are seasonal only. the website voting will start every year.on a website that 24/7.

- **Who?**  

  The Admins (Owners of 1 product or more) & the Clients who can contact the saler to purchase the item, plus voting.
  

## Working Methodology
  
1. Brainstorming & Understanding client requirments.
2. Imagine & Design a basic UI/UX sketch on a whiteboard & papers.
3. BenchMarking & take Inspiratin from oher projects.
4. Coming up with unique features & values-added.
5. Put Down Initial Specifications(Project name /Description /Features /Actors).
6. Design UML Use Case Diagram.
7. Design UML Class Diagram.
8. Verify & Modify.
9. Rewrite Specifications & add Suggested Technologies, Estimated Budget & Duration.
10. Design Database.
11. Install & Config PostgreSQL.
12. Make Database Migrations.
13. Make Database Seeders.
  
## Concepts Checklist

- [X] UML modeling.
- [X] Use case diagram.
- [X] class diagram.
- [X] DBMS.
- [X] PostgreSQL.
- [X] tables.
- [X] primary keys.
- [X] foreign keys.
- [X] SQL queries.
- [X] Agile method.
     - Deadline 2 days.
     - Team: Divide Tasks  Members Strenghts & Weakneses.
     - Validation: Versioning start with Important Features first
- [X] Scrum.
- [X] sprint.
- [X] Sprint backlog(To do list).
- [X] User Story Mapping.


## Brief Objectives Checklist

- [X] Team of 3 learners.
- [X] Duration 2 days.
- [X] The product code must respect the instructions explained in the context of the brief.
- [ ] Oral presentation of the work.
- [X] A GitHub link to the project folder
