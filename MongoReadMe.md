# MongoDB

MongoDB is a NoSQL database that stores data in flexible, JSON-like documents rather than traditional tables (as in relational databases). It’s designed for scalability, high performance, and easy development, and is particularly useful for handling large volumes of unstructured or semi-structured data.

Here’s a breakdown of key MongoDB concepts:

- Document-Oriented: Instead of rows and columns, MongoDB stores data in documents (JSON-like format) that can have varying structures.
- Collections: Groups of documents, analogous to tables in relational databases.
- Schema Flexibility: MongoDB allows documents in a collection to have different fields, which means you don’t need to define the structure before inserting data.
- Indexing: MongoDB supports rich queries and can index fields for fast searches.
- Replication & Sharding: Replication provides data redundancy and high availability, while sharding allows horizontal scaling, distributing data across multiple servers.

## MongoDB Commands

### Useful commands that can be used in the MongoDB

1. Login to the Mongo DB 
```
mongosh -u <username> -p <password>
```

2. **To create the user and assign the database permission**
```
db.createUser({user:"bruser",pwd:"bruserpassword123",roles: [{ role: "readWrite", db: "blackRockLogs" }]}); 
```

3. **To delete the user under MongoDB**
```
db.dropUser("bruser");
```

4. **To show the DBs**
```
show dbs;
```

5. **To create the blackRockLogs DB and To use the blackRockLogs DB**
```
use blackRockLogs;
```

6. **To create the collections in the BlackRockLogs Database**
```
db.createCollection("brLogs"); 
```

7. **Drop a collection in the BlackRockLogs Database**
```
db.brLogs.drop()
```

8. **Find all logs specific data query**
```
db.brLogs.find({age: 30})
```

9. **Find one specific logs query**
```
db.brLogs.findOne({name: "John"})
```

10. **Update the Logs Details**
```
db.brLogs.update({name: "John"}, {$set: {age: 31}})
```

11. **Remove the logs using specific logs**
```
db.brLogs.remove({name: "John"})
```

## MongoDB FAQ

1. What is MongoDB, and how is it different from relational databases (like MySQL)?
Explanation: Highlight MongoDB's document-based storage, schema flexibility, and scalability features. Contrast it with relational databases that use structured tables and enforce schemas.

2. What are the advantages of using MongoDB?
Explanation: Discuss features like scalability, high availability, flexibility in data modeling, and performance benefits for large-scale data processing.

3. Explain how MongoDB handles relationships between documents.
Explanation: MongoDB doesn’t support joins like SQL databases, so relationships are often handled through embedded documents or by referencing documents in other collections (like foreign keys).

4. What are indexes in MongoDB, and why are they important?
Explanation: Indexes improve query performance by allowing MongoDB to locate documents quickly. Discuss the various index types (single field, compound, text, etc.) and their impact on performance.

5. What is a replica set in MongoDB?
Explanation: A replica set is a group of MongoDB servers that maintain the same data. It provides redundancy and fault tolerance by replicating data across servers, enabling automatic failover.

6. What is sharding in MongoDB, and how does it work?
Explanation: Sharding is MongoDB’s method for horizontal scaling. It splits large datasets across multiple servers to distribute load. Explain the role of the shard key and how it determines which shard stores a document.

7. How does MongoDB ensure consistency, and what is the default isolation level?
Explanation: MongoDB uses a consistency model that can be tuned for eventual consistency or strict consistency, depending on the replication and write concern settings. Discuss the default isolation level as "read committed."

8. What are the different types of NoSQL databases, and why would you choose MongoDB?
Explanation: Compare document-based, key-value, columnar, and graph databases. Highlight why MongoDB’s document model is advantageous for certain applications.

9. How do you perform transactions in MongoDB?
Explanation: Since version 4.0, MongoDB supports multi-document ACID transactions, which allow you to execute a series of read and write operations across multiple documents and collections with full consistency.

10. What are some use cases where MongoDB would be a good choice?
Explanation: Suitable for content management systems, IoT applications, real-time analytics, and scenarios involving semi-structured or unstructured data.
