# Microservice-Architecture

Microservice architecture refers to a micro-architectural style for developing the application. Microservice allow huge organization application to be separated into smaller independent services with each part having its realm of responsibility and working together with other services via RESTful API to serve purposes.

In a monolithic app, all the services will bundle together and if one service is down, the other services will be crashed. The structure of monolithic architecture will be huge and complicated where all the services have been compiled together.

The microservice architecture is collaborating to serve the functions of the huge monolithic applications. In a microservice architecture, the container will be widely used to increase performance and manage its services among the container.

## The benefits of Microservice architecture

There are many benefits of having microservice architecture than monolithic architecture. Under the developer scope having microservice architecture the development teams can create independently the services. Since they communicate via messaging if at all, they are not dependent on the same coding language. Developers can use the programming language that they are comfortable with it, to develop microservice applications. This helps them manage the services on their own, with lower costs and fewer bugs.

Since the developer teams are working on smaller applications and more focused problem domains, the projects tend to be more agile. They can iterate faster, address new features on a shorter schedule, and fixes the bug almost immediately. Microservice improve the scalability of the architecture.

Nowadays more enterprises are going forward to the cloud, so microservice is a good solution. Moreover, most of the cloud providers currently provide services for applications that want to support microservice architecture. The services cloud service providers offer such as containerization where it able to scale up the performance of the applications and able to deploy separately without having any dependent on each other.

## Java-based frameworks

Several Java-based frameworks exist that are great for building Java microservices. Some examples include:

- **Spring Boot.** This is a popular framework for building Java applications, especially microservices because it simplifies the setup and configuration process for running your applications.
- **Jersey.** This is a Java framework for simplifying the development of REST web services. This can help with the communications layer between microservices.
- **Swagger.** This is a Java framework for building APIs. This also can help with the communications layer between microservices.

Below is the sample architecture of Microservice that I'm going to build and run it:


![This is an image](https://github.com/lingkeshra10/Microservice-Architecture/blob/main/Microservice%20Architecture.png)


## Communication channel between services

In a distributed system built with Spring services, several communication channels can be used to enable communication between the services. Here are some commonly used channels:

- **RESTful APIs:** REST (Representational State Transfer) is a popular architectural style for designing networked applications. Spring provides robust support for building RESTful APIs, allowing services to communicate with each other over HTTP. Services can expose their functionalities as REST endpoints and other services can consume these endpoints to exchange data.

- **Messaging Systems:** Spring provides integration with messaging systems like Apache Kafka, RabbitMQ, and ActiveMQ. Messaging systems enable asynchronous communication between services by sending messages to and receiving messages from message brokers. Services can publish messages to specific topics or queues, and other services can subscribe to those topics or queues to consume the messages.

- **Remote Procedure Calls (RPC):** RPC is a communication protocol that enables one service to invoke methods or functions in another service, making it appear as if they were local method calls. Spring provides support for RPC mechanisms like gRPC, which is a high-performance, language-agnostic framework for building remote services. gRPC uses Protocol Buffers as the interface definition language and offers efficient serialization and deserialization of data.

- **Event-driven Architecture:** Spring supports event-driven architecture patterns, where services communicate with each other through events. Events represent significant occurrences within the system, and services can publish and subscribe to events using event brokers like Spring Cloud Stream or Spring Integration. This approach allows services to be loosely coupled and react to events asynchronously.

- **Service Mesh:** A service mesh is a dedicated infrastructure layer for handling service-to-service communication within a distributed system. It provides features like service discovery, load balancing, circuit breaking, and observability. Popular service mesh implementations like Istio or Linkerd can be integrated with Spring services to manage and secure communication between them.

It's worth noting that the choice of communication channel depends on factors such as the requirements of the system, scalability needs, performance considerations, and the expertise of the development team. Spring provides a rich ecosystem of libraries and frameworks to support different communication patterns, allowing developers to choose the most suitable approach for their specific use case.

 ## Databases

A database is a structured collection of data that is organized, stored, and managed to facilitate efficient retrieval, manipulation, and analysis of information. Databases play a crucial role in modern applications and systems, serving as a reliable and scalable storage solution for structured and unstructured data.

There are different types of databases, but two widely used categories are:

1. Relational Databases: Relational databases are based on the relational model, which organizes data into tables with rows and columns. Each table represents an entity or concept, and the relationships between tables are established through keys (primary keys and foreign keys). Relational databases use SQL (Structured Query Language) for querying and manipulating data. Popular relational database management systems (RDBMS) include MySQL, PostgreSQL, Oracle, and Microsoft SQL Server.

2. NoSQL Databases: NoSQL (Not Only SQL) databases are a broad category of databases that provide flexible data models and are designed to handle large volumes of unstructured or semi-structured data. NoSQL databases move away from the tabular structure of relational databases and adopt various data models, such as document-oriented (e.g., MongoDB), key-value (e.g., Redis), columnar (e.g., Cassandra), and graph-based (e.g., Neo4j). NoSQL databases often offer high scalability and performance by distributing data across multiple servers.

Databases offer several key features and concepts:

**Data Schema:** A database schema defines the structure and organization of the data. In a relational database, the schema defines tables, columns, and relationships. In a NoSQL database, the schema can be more flexible, allowing dynamic and evolving data structures.

**Data Manipulation:** Databases support operations for creating, reading, updating, and deleting data, commonly referred to as CRUD operations. These operations are performed using specific query languages (e.g., SQL for relational databases) or APIs provided by the database system.

**Indexing:** Indexing improves the performance of data retrieval operations by creating additional data structures (indexes) that allow faster searching and sorting of data based on specific columns or fields.

**Transactions:** Transactions ensure the atomicity, consistency, isolation, and durability (ACID) properties of data operations. ACID compliance ensures that database operations are executed reliably and maintain data integrity.

**Concurrency Control:** Databases employ concurrency control mechanisms to manage simultaneous access to data by multiple users or processes. These mechanisms prevent data inconsistencies and ensure that concurrent operations are properly coordinated.

**Data Security:** Databases provide security mechanisms to protect data from unauthorized access and ensure data privacy. This includes user authentication, authorization, and encryption of sensitive data.

**Data Replication and Sharding:** For scalability and fault tolerance, databases often support data replication, which involves maintaining multiple copies of data across different servers. Sharding is another technique that partitions data across multiple servers to distribute the workload and enable horizontal scalability.

**PostgreSQL** and **MySQL** are both popular relational database management systems (RDBMS) that belong to the category of relational databases. While they share some similarities, they also have distinct features and characteristics.

**a. PostgreSQL:** PostgreSQL is an open-source RDBMS known for its robustness, scalability, and extensive feature set. It provides a wide range of advanced features and capabilities, making it suitable for complex and demanding applications. Some key features of PostgreSQL include:

- **Data Types:** PostgreSQL offers a rich set of built-in data types, including support for arrays, JSON, XML, and geometric data types.

- **Advanced SQL:** PostgreSQL supports advanced SQL features such as window functions, common table expressions (CTEs), and full-text search capabilities.

- **Extensibility:** It allows users to define custom data types, operators, and functions, making it highly extensible.

- **Concurrency Control:** PostgreSQL implements multi-version concurrency control (MVCC), which allows for concurrent read and write operations without blocking.

- **Replication and High Availability:** PostgreSQL supports various replication methods for data redundancy and high availability, including streaming replication and logical replication.

**b. MySQL:** MySQL is another popular open-source RDBMS widely used for web applications and other lightweight to moderately complex systems. It is known for its ease of use, speed, and simplicity. Key features of MySQL include:

- **Performance:** MySQL is optimized for speed and can handle high-traffic websites efficiently.
Scalability: It offers scalability through features like replication, clustering, and sharding.

- **SQL Compatibility:** MySQL supports the SQL standard and provides an extensive set of SQL functionalities, although it may have some limitations compared to PostgreSQL.

- **High Availability:** MySQL provides built-in features for high availability, including master-slave replication and automatic failover with tools like MySQL Cluster or third-party solutions like MySQL Replication Manager.

- **Community and Ecosystem:** MySQL has a large and active community, with a wide range of tools, libraries, and frameworks that integrate well with it.

When choosing between PostgreSQL and MySQL, it's essential to consider factors such as the complexity of the application, the need for advanced features, scalability requirements, performance considerations, and the skills and preferences of the development team. Both databases are widely used and have extensive documentation and community support, which can be beneficial when seeking assistance or resources.
