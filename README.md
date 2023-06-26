# Microservice-Architecture

Microservice architecture refers to a micro-architectural style for developing the application. Microservice allow huge organization application to be separated into smaller independent services with each part having its realm of responsibility and working together with other services via RESTful API to serve purposes.

In a monolithic app, all the services will bundle together and if one service is down, the other services will be crashed. The structure of monolithic architecture will be huge and complicated where all the services have been compiled together.

The microservice architecture is collaborating to serve the functions of the huge monolithic applications. In a microservice architecture, the container will be widely used to increase performance and manage its services among the container.

## The benefits of Microservice architecture

There are many benefits of having microservice architecture than monolithic architecture. Under the developer scope having microservice architecture the development teams can create independently the services. Since they communicate via messaging if at all, they are not dependent on the same coding language. Developers can use the programming language that they are comfortable with it, to develop microservice applications. This helps them manage the services on their own, with lower costs and fewer bugs.

Since the developer teams are working on smaller applications and more focused problem domains, the projects tend to be more agile. They can iterate faster, address new features on a shorter schedule, and fixes the bug almost immediately. Microservice improve the scalability of the architecture.

Nowadays more enterprises are going forward to the cloud, so microservice is a good solution. Moreover, most of the cloud providers currently provide services for applications that want to support microservice architecture. The services cloud service providers offer such as containerization where it able to scale up the performance of the applications and able to deploy separately without having any dependent on each other.

## Several Java-based frameworks exist that are great for building Java microservices. Some examples include:

- **Spring Boot.** This is a popular framework for building Java applications, especially microservices because it simplifies the setup and configuration process for running your applications.
- **Jersey.** This is a Java framework for simplifying the development of REST web services. This can help with the communications layer between microservices.
- **Swagger.** This is a Java framework for building APIs. This also can help with the communications layer between microservices.

Below is the sample architecture of Microservice that I'm going to build and run it:


![This is an image](https://github.com/lingkeshra10/Microservice-Architecture/blob/main/Microservice%20Architecture.png)


## The communication channel between services

In a distributed system built with Spring services, several communication channels can be used to enable communication between the services. Here are some commonly used channels:

- **RESTful APIs:** REST (Representational State Transfer) is a popular architectural style for designing networked applications. Spring provides robust support for building RESTful APIs, allowing services to communicate with each other over HTTP. Services can expose their functionalities as REST endpoints and other services can consume these endpoints to exchange data.

- **Messaging Systems:** Spring provides integration with messaging systems like Apache Kafka, RabbitMQ, and ActiveMQ. Messaging systems enable asynchronous communication between services by sending messages to and receiving messages from message brokers. Services can publish messages to specific topics or queues, and other services can subscribe to those topics or queues to consume the messages.

- **Remote Procedure Calls (RPC):** RPC is a communication protocol that enables one service to invoke methods or functions in another service, making it appear as if they were local method calls. Spring provides support for RPC mechanisms like gRPC, which is a high-performance, language-agnostic framework for building remote services. gRPC uses Protocol Buffers as the interface definition language and offers efficient serialization and deserialization of data.

- **Event-driven Architecture:** Spring supports event-driven architecture patterns, where services communicate with each other through events. Events represent significant occurrences within the system, and services can publish and subscribe to events using event brokers like Spring Cloud Stream or Spring Integration. This approach allows services to be loosely coupled and react to events asynchronously.

- **Service Mesh:** A service mesh is a dedicated infrastructure layer for handling service-to-service communication within a distributed system. It provides features like service discovery, load balancing, circuit breaking, and observability. Popular service mesh implementations like Istio or Linkerd can be integrated with Spring services to manage and secure communication between them.

It's worth noting that the choice of communication channel depends on factors such as the requirements of the system, scalability needs, performance considerations, and the expertise of the development team. Spring provides a rich ecosystem of libraries and frameworks to support different communication patterns, allowing developers to choose the most suitable approach for their specific use case.

