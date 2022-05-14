## A Simple SpringBoot Backend ##
### How to Run ####
Set the right environment variables(database url, user name and password).  
```mvn clean package && java -jar target/demo-0.0.1-SNAPSHOT.jar```


### Features ###
Implement CRUD operations for items.  
User can add comments when deleting itmes and cancel past deletions.  
The frontend would show undeleted items and deletion hitories.   
For one item, only the most recent deletion can be cancelled, but the history would be kept.  
Adopt transactional process for delete/undelete items.


### Database Design ###
Item and DeleteRecord are in "one to many" relationship.  
Use an "is_deleted" field in item to mark deleted.   
For one item, only the most recent deletion can be cancelled, use an "is_cancelled" field to mark cancelled.  