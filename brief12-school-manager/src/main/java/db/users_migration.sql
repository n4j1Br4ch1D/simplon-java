/*Create Table Users:*/
CREATE TABLE IF NOT EXISTS public.users
(
id serial NOT NULL,
full_name char(50) NOT NULL,
role VARCHAR(45) NOT NULL,
approved boolean NOT NULL DEFAULT false,
email VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
course_id int,
created_at timestamp with time zone NOT NULL DEFAULT NOW(),
updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
CONSTRAINT "Users_pkey" PRIMARY KEY (id, email),
UNIQUE (id),
UNIQUE (email)
);

/*Create Table Courses:*/
CREATE TABLE IF NOT EXISTS public.courses
(
id serial NOT NULL,
name char(50) NOT NULL,
active boolean NOT NULL DEFAULT false,
trainer_id int,
created_at timestamp with time zone NOT NULL DEFAULT NOW(),
updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
CONSTRAINT "Courses_pkey" PRIMARY KEY (id, name),
UNIQUE (id),
UNIQUE (name),
CONSTRAINT "Users_fkey"
FOREIGN KEY(trainer_id) 
REFERENCES public.users(id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE SET NULL
NOT VALID
);


/*Add User course_id*/
ALTER TABLE public.users
ADD CONSTRAINT "Courses_fkey"
FOREIGN KEY(course_id) 
REFERENCES public.courses(id) MATCH SIMPLE
ON UPDATE NO ACTION
ON DELETE SET NULL
NOT VALID;
