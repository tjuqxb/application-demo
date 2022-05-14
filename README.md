## A Simple Spring Boot Backend ##
### How to Run ####
This project uses PostgreSQL.
Set the right environment variables(DATABASE_URL, USER_NAME and PASSWORD).  
```mvn clean package && java -jar target/demo-0.0.1-SNAPSHOT.jar```


### Features ###
Implement CRUD operations for items.  
Users can add comments when deleting itmes and cancel past deletions.  
The frontend would show undeleted items and deletion histories.   
Adopt transactional process for delete/undelete items.


### Database Design ###
Item and DeleteRecord are in "one to many" relationship.  
In item use "is\_deleted" field to mark deleted.   
In deleteRecord, use "is\_cancelled" field to mark cancelled.  
For one item, only the most recent deletion can be cancelled, 