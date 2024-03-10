# MongoDB Commands

## Useful commands that can be used in the MongoDB

1. Login to the Mongo DB 
```
mongosh -u <username> -p <password>
```

2. **To show the DBs**
```
show dbs;
```

3. **To create the blackRockLogs DB and To use the blackRockLogs DB**
```
use blackRockLogs;
```

4. **To create the collections in the BlackRockLogs Database**
```
db.createCollection("brLogs"); 
```

5. **To create the user and assign the database permission**
```
db.createUser({user:"bruser",pwd:"bruserpassword123",roles: [{ role: "readWrite", db: "blackRockLogs" }]}); 
```
