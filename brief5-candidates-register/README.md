# :man_student: Candidates Registration form

This console application allows you to create, modify, delete and list a “CRUD” candidate.

 - :date: Date Started: **31-05-2022.** 
 - :computer: Developed By: [NajibRachid](https://github.com/n4j1Br4ch1D).
 - :office: Developed At: TechnoPark Agadir, Simplon Talent4Startups, Group *SoussTalents101*.
 - :pushpin: Version: **Alpha Version 0.0.1**.

---

## Database Migration & Seeder

  ```sql

/*Create Table Candidates:*/
CREATE TABLE IF NOT EXISTS public.candidates
(
id serial NOT NULL,
email char(45) NOT NULL,
first_name char(25) NOT NULL,
last_name char(25) NOT NULL,
address char(90) NOT NULL,
city char(25) NOT NULL,
country char(25) NOT NULL,
created_at timestamp with time zone NOT NULL DEFAULT NOW(),
updated_at timestamp with time zone NOT NULL DEFAULT NOW(),
CONSTRAINT "Users_pkey" PRIMARY KEY (id, email),
UNIQUE (id),
UNIQUE (email) 
);

/*Seed Table Candidates:*/
INSERT INTO public.candidates 
   (email, first_name, last_name, address, city, country)
 VALUES
   ('najib@anmoon.ma', 'najib', 'rachid', '123 Main Street, New York, NY 10030', 'Agadir', 'Morocco'),
   ('mustapha@anmon.ma', 'mustapha', 'ihoum', '123 Main Street, New York, NY 10030', 'Tizinit', 'Morocco'),
   ('nawal@anmoon.ma', 'nawal', 'boulahsaire', '123 Main Street, New York, NY 10030', 'Rabat', 'Morocco');
 
 ```
 
 ## Database CRUDs & Operations

  ```sql
   
  /*List*/
  SELECT * FROM candidates;
  
  /*Create:*/
  INSERT INTO candidates (email, first_name, last_name, address, city, country) VALUES ("latifadev@anmon.ma", "latifa", "amougauay", "123 Main Street, New York, NY 10030", "Tizinit", "Morocco");
  
  /*Read*/
  SELECT * FROM candidates WHERE id=4;
  
  /*Update:*/
  UPDATE candidates SET email="latifadev@anmon.ma", updated_at=NOW() WHERE id=4;

  /*Delete:*/
  DELETE FROM candidates WHERE id=4;
  
```
  
## Concepts Checklist

- [X] Use the “data access object” DAO design pattern
- [X] Java Maven (software project management & production automation tool)
- [X] JDBC(Java DataBase Connectivity).
<!---
- [X] BDD.
- [X] MVC.
- [X] ORM.
-->

## Brief Objectives Checklist

- [X] Individual work.
- [X] Duration 2 days.
- [X] The product code must respect the instructions explained in the context of the brief.
- [X] Oral presentation of the work.
- [X] A GitHub link to the project folder
