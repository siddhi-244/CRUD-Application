# CRUD Application using Dropwizard and Hibernate
A sImple CRUD application using dropwizard. Using GET,POST,PUT & DELETE we implement CRUD applications on the database 

### Tools and Libraries needed

- Dropwizard
- Hibernate
- Postman (to send requests to server)
- PgAdmin (For postgresql)
- Intellij IDEA (For initializing dropwizard projects using maven archetype)

### Table Structure
table name - book_review
columns 
1. id - (pk) - character varying (40)
2. bookid - character varying (40)
3. rating - integer
4. review - text

Port to send requests - 8080


### Parameters to be passed on localhost
|Request | Url | parameters | body |
|--------|--------|---------| ------ |
|GET | localhost:8080/book/review?bookid={id} | id | |
| POST | localhost:8080/book/review | | { "bookid": "612" , "rating":5,"review":"Awesome"} |
| PUT | localhost:8080/book/review?id={id}&rating={rating} | id,bookid,rating,review |   |
|DELETE | localhost:8080/book/review?id={id} |id | |
