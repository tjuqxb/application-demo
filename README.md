## A Simple Spring Boot Backend ##
### How to Run ####
This project uses PostgreSQL.  
Command line:    
```mvn clean package && java -jar target/demo-0.0.1-SNAPSHOT.jar```


### Features ###
**When deleting, allow deletion comments and undeletion.**   
**For one item, only the most recent deletion can be cancelled, but all deletion histories are displayed.**  
The frontend would show undeleted items and deletion histories.  
Sever-side checks all the parameters using DTO layer.  
Sever-side adopts transactional process for delete/undelete/edit items, as editting a deleted item is not allowed.   


### Database Design ###
Item and DeleteRecord are in "one to many" relationship.  
In item use "is\_deleted" field to mark deleted.   
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
    delete_date DATE NOT NULL,
    delete_time TIME NOT NULL,
    PRIMARY KEY (rec_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);
```