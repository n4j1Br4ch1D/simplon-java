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
UNIQUE (id),
UNIQUE (email) 
);

/*Alter Table Users Add Role Column:*/
ALTER TABLE public.users ADD "role_type" char(6);
ALTER TABLE public.users Alter COLUMN "role_type" SET DEFAULT 'client';

/*Create Table Categories:*/
CREATE TABLE IF NOT EXISTS public.categories
(
id serial NOT NULL,
name char(45) NOT NULL,
img char(255),
created_at timestamp with time zone NOT NULL DEFAULT NOW(),
updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
CONSTRAINT "categories_pkey" PRIMARY KEY (id, name),
UNIQUE (id),
UNIQUE (name) 
);

/*Create Table Tasks:*/
CREATE TABLE IF NOT EXISTS public.tasks
(
id serial NOT NULL,
name char(45) NOT NULL,
description text,
status char(25) NOT NULL,
tobefinished_at timestamp with time zone,
finished_at timestamp with time zone,
category_id int,
created_at timestamp with time zone NOT NULL DEFAULT NOW(),
updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
CONSTRAINT "tasks_pkey" PRIMARY KEY (id, name),
UNIQUE (id),
UNIQUE (name),
CONSTRAINT "category_fkey"
FOREIGN KEY(category_id) 
REFERENCES public.categories(id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE SET NULL
NOT VALID
);