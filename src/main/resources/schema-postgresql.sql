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
    timestamp BIGINT NOT NULL,
    PRIMARY KEY (rec_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

INSERT INTO delete_records (item_id, comment, is_cancelled, timestamp) VALUES
(4, 'test', FALSE , 1652535979730),
(5, 'test', FALSE , 1652535996061),
(6, 'test', FALSE , 1652535997061);






















