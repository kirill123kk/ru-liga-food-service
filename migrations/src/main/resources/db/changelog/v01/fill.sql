INSERT INTO courers (phone,  status,coordinats)
VALUES
    (6622255885,'active','"fdsf"'),
    (9906585485,'active' ,'"fdsf"'),
    (9303490488,'active' ,'"fdsf"'),
    (9645651545,'active' , '"fdsf"'),
    (56655666599,'active' , '"fdsf"');

-- Добавление тестовых данных в таблицу customer
INSERT INTO restaurants (name,address, status)
VALUES
    ('mac','rr d.1 kv 2.', 'active'),
    ('papa','rr d.2 kv 2.', 'complete'),
    ('Bounsuare','read d.1 kv 2.', 'denied'),
    ('nova','read d.36 kv 554.', 'denied');

-- Добавление тестовых данных в таблицу restaurant
INSERT INTO customers (phone, email, address)
VALUES
    (6622255885,'jfjfjf@gmail.ru', 'rr d.1 kv 2.'),
    (9906585485,'5552sdssdsf@mal.ru' , 'rr d.1 kv 2.'),
    (9303490488,'jfjfsadadjf@gmail.ru' , 'rr d.1 kv 3.'),
    (9645651545,'2323sfsdf@gmail.ru' , 'read d.1 kv 2.'),
    (56655666599,'2323sfsdf@gmail.ru' , 'rr d.3 kv 2.');

-- Добавление тестовых данных в таблицу orders
INSERT INTO orders (customer_id, restaurant_id, status, courier_id)
VALUES
    (1, 1, 'active', 1),
    (2, 2, 'complete', 2),
    (3, 3, 'denied', 3),
    (4, 4, 'denied', 4);

-- Добавление тестовых данных в таблицу order_items
INSERT INTO order_items (order_id, restaurant_menu_item,price, quantity)
VALUES
    (1, 1,12, 1),
    (1, 2,20, 2),
    (3, 3,17, 3),
    (3, 2,336, 1);

-- Добавление тестовых данных в таблицу restaurant_menu_item
INSERT INTO restaurant_menu_items (restaurant_id, name, price, description, image)
VALUES
    (1, 'Item 1', 10.99, 'Description 1', 'image1.jpg'),
    (2, 'Item 2', 8.50, 'Description 2', 'image2.jpg'),
    (3, 'Item 3', 12.75, 'Description 3', 'image3.jpg'),
    (4, 'Item 4', 129.90, 'Description: I need money ', 'image3.jpg');

