# :zipper_mouth_face: SoussTalent101 STC Activity Manager.

Conceptualization for a Dynamic Web Application For Managing Evenets, Built using Java Spring Boot,
DAO Design Pattern, Repository Design Pattern, PostregSQL, and ORM: Hibernate, also Thymleaf.

 - :date: Date Started: **16-08-2022.** 
 - :computer:	Developed By: [MohamedIdlmhor](https://github.com/idmed22/) &&[NajibRachid](https://github.com/n4j1Br4ch1D).
 - :office: Developed At: TechnoPark Agadir, Simplon Talent4Startups, Group *SoussTalent101*.
 - :pushpin: Version: **Alpha Version 0.0.1**.

---

<!---## Snapshots

<div style="display:flex">
<img src="/brief13-stc/1.PNG" height="200" width="300"/>
<img src="/brief13-stc/2.PNG" height="200" width="300"/>
<img src="/brief13-stc/3.PNG" height="200" width="300"/>
<img src="/brief13-stc/4.PNG" height="200" width="300"/>
<img src="/brief13-stc/5.PNG" height="200" width="300"/>
<img src="/brief13-stc/6.PNG" height="200" width="300"/>
</div> -->



## Planning

1. Analyze Requirements.
2. Starts Jira bored with Tasks.
3. Make Use Case Diagram.
4. Make Class Diagram.
5. Make DB Schema sketch.
6. Design Rest API Endpoints & Parameters.
7. Environment Setup.
8. Make Migrations.
9. Make Seeders.
10. Make Entities.
11. Develop API.
12. Maintenance.
13. Prepare presentation.

## ScreenShots
<div style="display:flex">
<img src="/brief13-stc/jira1.png" height="200" width="300"/>
<img src="/brief13-stc/jira2.png" height="200" width="300"/>
<img src="/brief13-stc/jira3.png" height="200" width="300"/>
<img src="/brief13-stc/useCase_diagram.png" height="200" width="300"/>
<img src="/brief13-stc/class_diagram.png" height="200" width="300"/>
<img src="/brief13-stc/db_sketch.png" height="200" width="300"/>
<img src="/brief13-stc/tables_seeders.PNG" height="200" width="300"/>
<img src="/brief13-stc/rest_apis.PNG" height="200" width="300"/>
<img src="/brief13-stc/source_code.PNG" height="200" width="300"/>
</div>

## Constraints Checklist

- [X] Sign in as administrator(httpSession).
- [X] Sign out (httpSession).
- [X] Adding a user (role:admin, manager, particpant).
- [X] Modify users.
- [X] Delete users.
- [X] See user details.
- [X] List users.
- [X] Adding a course.
- [X] Modify courses.
- [X] Delete courses.
- [X] See course details.
- [X] List courses.
- [X] Users report(Number of Trainers,talents & Number of Courses).

## Api Endpoints & PArams Design.

```
=========
/login
/register
/token
=========/
get user/filters role(), gender, activities, ...
get user/id
post user/
put user/id
delete user/id
=========
get activity/filters
get activity/id
post activity/  [import multi participants]
put activity/id
delete activity/id
=========
get exercise/filters
get exercise/id
post exercise/
put exercise/id
delete exercise/id
=========

user->admin->
user->manager->activities(he created->excercises->particpants)
user->particpant->activities(he particpated in->excercies)

```

## Issues:
   - [X] Issue1: Get Role Attribures.
   - [X] Issue2: Add attributes to pivot table.
   - [X] Issue3: Make Foreign key nullable.
   - [X] Issue4: Fix recursive in relations.
   - [X] Issue5: Get Pagination info.
   - [X] Issue6: Parameter Filtering.
   - [X] Issue7: Saving multiple items.
   - [X] Issue8: Fix DTO Validation.
   - [X] Issue9: Protect API endpoints JWT.


## Technologies Checklist

- [X] Spring Boot.
- [X] PostgreSQL database.
- [X] Use the JDBC.
- [X] Use the Java Maven.
- [X] Use Services.
- [X] Use Repository.
- [X] Use Hibernate ORM.
- [X] Use Thymleaf.
- [X] Use Spring Security.

## Extras

- [X] Rest Client .http to test apis.


## Brief Objectives Checklist

- [X] Improved program by adding other features.
- [X] Team work.
- [X] Deadline Respected.
- [X] A complete initial source code according to the instructions and respects good practices.
- [X] Code demo and review.
- [X] Github repository.
- [X] Restitution in public (Detailed presentation of the work carried out)
- [X] The database must conform to the model produced; Ability to create database query requests that meet a specific need.
- [X] Deliver: Diagrams of use case, classes A link to Jira/Trello showing all the different stages of the project, Source Code Repo,Rest API Documentation.
