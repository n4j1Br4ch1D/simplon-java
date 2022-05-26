# :garlic: Ahanou
Model and implement the database of a web application to exhibit local products in the region

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

[cas_dutilisation_pharmacist.oom](/brief4-database/cas_dutilisation_pharmacist.oom)

## Class diagram

<div style="display:flex">
<img src="/brief4-database/class_diagram.png" height="200" width="300"/>
</div>

[Diagramme_de_classes.moo](/brief4-database/Diagramme_de_classes.moo)


## Database Migration 

  ```sql
  
  /*Create database:*/
  CREATE DATABASE "Ahanou";
  
  /*Create Table Users:*/
  
  /*Alter Table Users Add Role Column:*/
  
  /*Create Table Categories:*/
 
  /*Create Table Products:*/
  
  /*Create Table Votes:*/ 
    
 ```

## Database Seeder

  ```sql
  
  /*Seed Table Users:*/
  
  /*Update Make Some Users Admins*
  
  /*Seed Table Categories:*/
 
  /*Seed Table Products:*/
  
  /*Seed Table Votes:*/ 
    
 ```
 
 ## Database CRUDs Snapshots

  ```sql
  
  /************** Users(Authentication & Autherization) **************/
  
  /*Register:*/
  
  /*Login:*/
  
  /*Alter Table Users Add Role Column:*/
  
  /*List users:*/
  
  /*List clients:*/
  
  /*Add user:*/
  
  /*View user:/*
  
  /*Approve user:*/

  /*Edit user:*/
  
  /*Delete user:*/

  /*Check Role if Admin*/
  
  /*Check Role if Client & Approved*/
  

  /************** Products **************/

  /*List products order by most voted:*/
  
  /*List product client voted for:*/
  
  /*View Produt with votes:*/ 
  
  /*Edit Produt:*/ 
  
  /*Add Produt:*/ 
 
  /*Vote Produt(retract/modify if vote exist):*/ 
  
  /*Delete Produt:*/ 
  
  /************** Categories **************/

  /*List categories*/
  
  /*View category:*/ 
  
  /*Edit category:*/ 
  
  /*Add category:*/ 
   
  /*Delete category:*/ 
 
  /*Get most voted category:*/ 
  
```

## Tools

- PowerDesigner.
- MarkDown.
- Google Docs.
- PostgreSQL.
- Trello.

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
- [ ] Duration 2 days.
- [ ] The product code must respect the instructions explained in the context of the brief.
- [ ] Oral presentation of the work.
- [X] A GitHub link to the project folder
