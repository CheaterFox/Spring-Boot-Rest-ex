# REST API

In this repository there are 3 projects and all of them doing same stuff but with different techniques.
​
## 1. Project (jpa-cruddemo):
In this project there are 2 implementation classes of repository interface(EmployeeDAO.java)
First one is "EmployeeDAOHibernateImpl" class. So in this class i used Entity Manager but leverage native Hibernate API.
Second one is "EmployeeDAOJpaImpl" class. And for this class i used Entity Manager but leverage standard JPA API.
So like i said before this techniques are different but doing same crud operations. In the service class we need to specify the class with qualifier when autowiring the repository! 
## 2. Project (spring-data-jpa-cruddemo):
In this class i extend the JpaRepository<EntityClass, PrimaryKey> for my repository interface. So with specifing our entity and it's primary key we can access the database quickly without creating implementation class for our repository interface. And also we don't need to use @Transaction annotation in the service because behind scenes JpaRepository deals with it. Thanks to JpaRepository :).  

## 3. Project (spring-data-rest):
This project not about DAO techniques but also doing the operations which we write in the RestController class on the previous project, for us. So we don't need to create RestController and Service class, behind scenes Spring Data Rest creating endpoints for us, like if you have Entity class which name is student, it creates an endpoint with "students" and when we GET request we can recieve list of students, and also for the other crud operations and some other basic operations it creates endpoints for us.

List of Endpoints for Example Student Entity Class:

HTTP Method - Endpoints                     | CRUD ACTION
--------------------------------------------|------------------------------------------------
POST   : /students                          | Create a new student        
GET    : /students                          | Read a list of students          
GET    : /students/{studentId}              | Read a single student   
PUT    : /students/{studentId}              | Update an existing student   
DELETE : /students/{studentId}              | Delete an existing student
--------------------------------------------|-------------------------------------------------
SORTING - Endpoints                         | ACTION           
--------------------------------------------|-------------------------------------------------
/students?sort=lastName                     | - Sort by last name (Ascending is default) 
/students?sort=firstName,desc               | - Sort by first name, descending
/students?sort=lastName,firstName,asc       | - Sort by last name, then first name, ascending
--------------------------------------------|-------------------------------------------------

You can say "all these stuffs are good but what if we want to specify our endpoints", maybe you want to /magic-api in front of the  /students endpoint or maybe you have a person entity class, you do not want endpoint like /persons rigth! :D
So if you want /api endpoint in front of your basic endpoint, you need to write "spring.data.rest.base-path=/api" to the application properties.
And if you want a custom endpoint like people you need to specify it in the Repository interface with the @RepositoryRestResource(path="people") annotaion.


So this is it thanks for reading and do not forget dependcy :)
