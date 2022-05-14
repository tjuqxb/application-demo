DROP TABLE IF EXISTS delete_records;
DROP TABLE IF EXISTS items;

CREATE TABLE items (
    item_id SERIAL,
    name VARCHAR NOT NULL,
    quantity INT NOT NULL,
    is_deleted BOOLEAN NOT NULL,
    PRIMARY KEY (item_id)
);

INSERT INTO items (name, quantity, is_deleted) VALUES
('a', 10, false),
('b', 10, false),
('c', 11, false),
('d', 11, true),
('e', 12, true),
('f', 13, true);

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

INSERT INTO delete_records (item_id, comment, is_cancelled, delete_date, delete_time) VALUES
(4, 'test', FALSE , '2022-5-12','09:01:01'),
(5, 'test', FALSE , '2022-5-12','09:01:02'),
(6, 'test', FALSE , '2022-5-12','09:01:03');






















