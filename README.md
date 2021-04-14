Video presentation: 
https://www.youtube.com/watch?v=TWg36Qc0sGc

1. Clone the project to your computer
2. Import the project in IntelliJ (or your IDE)
3. Create a database schema "mmatoursafe" in MariaDB
4. Change lines 3 and 4 of application.properties file located in /src/main/resources to your datasource username & password
5. Run the application - it will create the tables
6. Stop application and change line 7 of application.properties file located in /src/main/resources to update instead of create (spring.jpa.hibernate.ddl-auto=update)
7. Run the application - now the data will be saved into the database and it will remain saved after you close the application
8. For frontend startup use Angular CLI and run ng serve from Command Prompt, inside the mmatoursafe-frontend folder
