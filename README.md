## A Simple Spring Boot Backend ##
### How to Run ####
 Command line:    

```mvn clean package && java -jar target/demo-0.0.1-SNAPSHOT.jar``` 
 
This project uses PostgreSQL. It can be compliled and run without additional setup as it contains some necessary credentials from ElephantSQL，which can be replaced manually. A more secure way is using envrionment varibles with addtional setup.
### Features ###
**When deleting, allow deletion comments and undeletion.**   
**For one item, only the most recent deletion can be cancelled, but all deletion histories are stored in database.**  
The frontend would show undeleted items and deletion histories.  
Sever-side checks all the parameters using DTO layer.  
Sever-side adopts transactional process for delete/undelete/edit items, as editting a deleted item is not allowed.   

### API ###

| Routes   | RESTful   | Desription| JSON body|    
|----------|-----------|-----------|----------|    
|**items/list**|GET|get a list of items|  |      
|**items/add**|POST| add an item |{"name":"example", "quantity":123}|    
|**items/edit**|PUT| edit an item|{"item_id":1,"name":"example","quantity":123}|     
|**items/delete**|POST | mark an item as deleted and add a delete record|{"item_id":1, "comment":"deletion comment"}|  
|**records/list** |GET |get a list of delete records|  |  
|**records/cancel/:id**|PUT  |mark a delete record as cancelled|  |    
  


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