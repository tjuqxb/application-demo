## A Simple Spring Boot Backend ##
### How to Run ####
This project uses PostgreSQL.  
Command line:    
```mvn clean package && java -jar target/demo-0.0.1-SNAPSHOT.jar```


### Features ###
**When deleting, allow deletion comments and undeletion.**   
**For one item, only the most recent deletion can be cancelled, but all deletion histories are stored in database.**  
The frontend would show undeleted items and deletion histories.  
Sever-side checks all the parameters using DTO layer.  
Sever-side adopts transactional process for delete/undelete/edit items, as editting a deleted item is not allowed.   

### API ###
GET **items/list**:get a list of items  
POST  **items/add**: add an item  
PUT **items/edit**: edit an item  
POST **items/delete**: mark an item as deleted, add a delete record  
GET **records/list**: get a list of delete records  
PUT **records/cancel/:recordId**: mark a delete record as cancelled
  


### Database Design ###
Item and DeleteRecord are in "one to many" relationship.  
In item, use "is\_deleted" field to mark deleted.   
In deleteRecord, use "is\_cancelled" field to mark cancelled.  

Schemas:  
```
CREATE TABLE items (  
    item_id SERIAL,  
    name VARCHAR NOT NULL,
    quantity INT NOT NULL,
    is_deleted BOOLEAN NOT NULL,
    PRIMARY KEY (item_id)
);
```  
```  
CREATE TABLE delete_records (
    rec_id SERIAL,
    item_id INT NOT NULL,
    comment VARCHAR,
    is_cancelled BOOLEAN,
    timestamp BIGINT NOT NULL,
    PRIMARY KEY (rec_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);
```