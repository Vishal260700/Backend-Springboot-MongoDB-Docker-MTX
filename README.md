## Backend for Demo-MTX

# Intro
EmployeeConnect is an app for admin to add/delete/update/search user details to manage them and connect them with Team leads for intra-company transfer. Technologies utilized include Spring-MongoDB Backend, Docker-run MongoDB Database, Angular (seperate github repo), Angular-material and Firebase (authentication purpose)

# Setup
1. git clone repo
2. mvn spring-boot:run in project root folder

# Dependencies 
1. Spring-boot-starter-mongodb
2. Spring-boot-web
3. Lombok

# Classes
1. BackendApplication
2. user - user data architecture with data variable type includes details like id, name, email, title, team, technologies (List<String>), experience (List<Map<String, String>>)
3. UserController - API Controller (GET, DELETE, POST, PUT)
4. UserRepository (Interface) - extends mongorepository and contains custom queries for API service
5. UserService - Centered service for custom functions to get data
6. Application.properties - spring-boot mongodb params for setup and connect
7. Docker compose - Docker container params service for mongodb
