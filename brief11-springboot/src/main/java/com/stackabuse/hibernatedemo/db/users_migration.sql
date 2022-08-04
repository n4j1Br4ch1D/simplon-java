/*Create Table Users:*/
CREATE TABLE IF NOT EXISTS public.users
(
id serial NOT NULL,
full_name char(50) NOT NULL,
role VARCHAR(45) NOT NULL,
approved boolean NOT NULL DEFAULT false,
email VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
tasks_number int,
created_at timestamp with time zone NOT NULL DEFAULT NOW(),
updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
CONSTRAINT "Users_pkey" PRIMARY KEY (id, email),
UNIQUE (id),
UNIQUE (email) 
);
