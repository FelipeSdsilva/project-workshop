INSERT INTO tb_user (name, email, phone, password) VALUES ('Felipe Sousa', 'felipe.fps09@hotmail.com','11954705118','123456');

INSERT INTO tb_order (moment, status, client_id) VALUES (NOW(), 0 , 1);

INSERT INTO tb_category(name) VALUES ('Book');
INSERT INTO tb_category(name) VALUES ('Electronics');
INSERT INTO tb_category(name) VALUES ('Computers');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('The Lord of Rings','Lorem ipsum dolor sit amet, consectetur.',90.5,'');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Smart TV','Lorem ipsum dolor sit amet, consectetur.',2190.0,'');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Macbook Pro','Lorem ipsum dolor sit amet, consectetur.',1250.0,'');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Pc Gamer','Lorem ipsum dolor sit amet, consectetur.',1200.0,'');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Rails for Dummies','Lorem ipsum dolor sit amet, consectetur.',100.99,'');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1,1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2,2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2,3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3,2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3,3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4,3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4,2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5,1);