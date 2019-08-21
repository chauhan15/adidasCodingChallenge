# Overview
This application has been developed following SOA (Service Oriented Approach), there are three microservices in this application.
All applications are totally indepenedent and communicate effectively with each other. Each service can be build and executed indepenedently.

# List of microservices
1. notification-service
2. subscribe-service
3. newsletter-service

# notification-service
This service will be used to trigger an email whenever subscriber provides a valid email.

# subscribe-service
Using this service, subcriber can subscribe for newsletter services.

# newsletter-service
This service can be considered as a public service and it will be exposed to the subscribers.

Each microservice has been assinged a separate docker file, using this docker file, a corresponding docker image will be created.

# Following technologies have been used to develop this application
1. Java8 (Programming language)
2. Spring Boot (To create microservices)
3. Spring security (For application purpose) 
4. Spring boot actuator
5. Swagger (For documentation purpose)
6. Rabbit MQ (To trigger emails to the subcribers)
7. H2 Database (Internal DB)
8. Spring JPA (For persistence purpose)
9. Spring Feign (to handle HTTP client services):
Feign proxy is being used to communicate with other services, popularity of Feign framework can be seen by the fact that it makes REST communication easier between different microservices.
10. Maven (Code management tool)
11. Git (for code versioning control)

# End Point used:
/newsletter-subscription

# Validation
Each and every parameter would be validated properly.

# database
I am using internal database H2, there is no need to store the data in external database.

# Steps to execute the services
Step-1: Install Java8 (JDK8)
Step-2: Install local docker on your machine.
Step-3: Create the docker images by using following command in the folder of each microservice:
$ mvn clean package

Step-4: Run the docker using following command:
$ docker-compose up -d

Port for notification-service: 8200
Port for subscribe-service: 8100
Port for newsletter-service: 8000

# Invoke the end point using Postman or any other REST client:
End Point: "/newsletter-subscription"

    {
        "campaignId"= "adidasCampaign1",
        "dateOfBirth"= "15.06.1991",
        "firstName"= "john",
        "gender"= "male",
        "email"= "xyz@gmail.com",
        "consent"= "true"
    }
	
# Optional fields:
firstName
Gender

# Once POST request is invoked using POSTMAN, user will receive the email notification on provided email id.

# How can it be improved in future:
1. Proper test cases can be added to implement the TDD approach.
2. BDD can be implemented using JBehave.
3. Kafka will be introduced for load balancing and asynchronous message transfer.
4. CI/CD would be introduced using Jenkins, Docker and AWS.

# documentation framework
Swagger has been used as documentation API.