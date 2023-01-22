CREATE TABLE orders (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    CONSTRAINT order_id_pk PRIMARY KEY(id)
);

CREATE TABLE order_details (
    id int NOT NULL AUTO_INCREMENT,
    order_id int NOT NULL,
    item_name varchar(30) NOT NULL,
    qty smallint NOT NULL,

    CONSTRAINT order_details_id_pk PRIMARY KEY(id),
    CONSTRAINT order_details_order_id_fk FOREIGN KEY(order_id) REFERENCES orders(id)
);

INSERT INTO order_details(order_id,item_name,qty) values(1,'Bag',1);

CREATE TABLE approvers (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,

    CONSTRAINT approvers_id_pk PRIMARY KEY(id)
);

CREATE TABLE approver_orders (
    id int NOT NULL AUTO_INCREMENT,
    approver_id int NOT NULL,
    order_id int NOT NULL,

    CONSTRAINT approver_orders_id_pk PRIMARY KEY(id),
    CONSTRAINT approver_orders_approver_id_fk FOREIGN KEY(approver_id) REFERENCES approvers(id),
    CONSTRAINT approver_orders_order_id_fk FOREIGN KEY(order_id) REFERENCES orders(id)
);

INSERT INTO approvers(name) values('krit');

INSERT INTO approver_orders(approver_id,order_id) values(1,1);

INSERT INTO approvers(name) values('kasama');

ALTER TABLE approver_orders ADD COLUMN status enum('approved','waiting','rejected') NOT NULL DEFAULT 'waiting';

ALTER TABLE approver_orders ALTER status DROP DEFAULT;

ALTER TABLE approver_orders ADD COLUMN active bit NOT NULL DEFAULT 1;

ALTER TABLE approver_orders ALTER active DROP DEFAULT;

ALTER TABLE approver_orders MODIFY COLUMN active bit NOT NULL DEFAULT 1;
