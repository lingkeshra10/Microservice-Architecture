# Microservice-Architecture

Microservice architecture it refers as micro architural style for developing the application. Microservice allow huge organization application to be separated into smaller independent services with each parts having its own realm of responsibilty and works together with other services via RESTful API to serve purposes.

In monolithic app, all the services will bundle in together which one service is down, the other services will crashed. The structure of monolithic architecure will be huge and complicated where all the services have been compiled it together.

The microservice architecture is collabrating with each other to serve the functions of the huge monolithic applications.In microservice architecture, container will be widely used in order to increase the performance and manage its own services among the container.

## The benfits of Microservice architecture

There are many benefits of having microservice architecture than monolithic architecture. Under the developer scope having microservice architecture the development teams can create independently the services. Since they communicate via messaging if at all, they are not dependent on the same coding language. Developers can use the programming language that they comfortable with it, in order to develop microservice application. This helps them manage the services with their own, with lower costs and less bugs.

Since the developer teams are working on smaller applications and more focused problem domains, the projects tend to be more agile. They can iterate faster, address new features on a shorter schedule, and fixes the bug almost immediately. Microservice improve the scalability of the architecture.

Nowdays more enterprise are going forward to cloud, so microservice is a good solution. Moreover, most of the cloud providers currently providing services for application that want to support microservice architecture. The services cloud service providers provide such as containerization where it able to scale up the performance of the applications and able to deploy separately without having any dependent one and each other.

Several Java-based frameworks exist that are great for building Java microservices. Some examples include:

- **Spring Boot.** This is a popular framework for building Java applications, especially microservices, because it simplifies much of the setup and configuration process for getting your applications running.
- **Jersey.** This is a Java framework for simplifying the development of REST web services. This can help with the communications layer between microservices.
- **Swagger.** This is a Java framework for building APIs. This also can help with the communications layer between microservices.

Below is the sample architecture of Microservice that Im going to build it and run it:


![This is an image](https://github.com/lingkeshra10/Microservice-Architecture/blob/main/Microservice%20Architecture.png)


There will be few technology that Im going to use in order to develop these microservice applications.

- Spring Cloud API Gateway
- Docker
- Kubernetes
- MariaDB
- MongoDB
- PostgreSQL
- Redis
- Kafka
- RabbitMQ
