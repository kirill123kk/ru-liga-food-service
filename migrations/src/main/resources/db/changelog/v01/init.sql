create sequence if not exists courers_seq;

create table if not exists courers
(
    id bigint not null default nextval ('courers_seq'),
    phone text not null,
    status text not null,
    coordinats text not null,
    constraint courers_pk primary key (id)
);

comment on table courers is 'Курьеры';
comment on column courers.id is 'Id курьера';
comment on column courers.phone is 'Телефон';
comment on column courers.status is 'Статус';
comment on column courers.coordinats is 'Координаты';



create sequence if not exists customers_seq;

create table if not exists customers
(
    id bigint not null default nextval ('customers_seq'),
    phone text not null,
    email text not null,
    address text not null,
    constraint customers_pk primary key (id)
);

comment on table customers is 'Курьеры';
comment on column customers.id is 'Id курьера';
comment on column customers.phone is 'Телефон';
comment on column customers.address is 'Адресс';





create sequence if not exists order_seq;

create table if not exists orders
(
    id bigint not null default nextval ('order_seq'),
    customer_id bigint not null,
    restaurant_id bigint not null,
    status text not null,
    courier_id bigint ,
    timestamp timestamptz  not null default now(),
    constraint  orders_courers_fk foreign key (courier_id)
        references courers(id),
    constraint  orders_customers_fk foreign key (customer_id)
        references customers(id),
    constraint orders_pk primary key (id)
    );

comment on table orders is 'Заказы';
comment on column orders.id is 'Идентификатор';
comment on column orders.customer_id is 'Ник';
comment on column orders.restaurant_id is 'Id ресторана';
comment on column orders.status is 'Статус';
comment on column orders.timestamp is 'Время прибытия';



create sequence if not exists orderitems_seq;

create table if not exists order_items
(
    id bigint not null default nextval ('orderItems_seq'),
    order_id bigint not null,
    restaurant_menu_item bigint not null,
    price double precision not null,
    quantity bigint not null,
    constraint order_items_orders_fk foreign key (order_id)
        references orders(id),
    constraint order_items_pk primary key (id)
);

comment on table order_items is 'Заказы';
comment on column order_items.id is 'Идентификатор';
comment on column order_items.order_id is 'Id заказа';
comment on column order_items.restaurant_menu_item is 'Меню';
comment on column order_items.price is 'Ценна';
comment on column order_items.quantity is 'Расположение';




create sequence if not exists restaurants_seq;

create table if not exists restaurants
(
    id bigint not null default nextval ('restaurants_seq'),
    address text not null,
    status text not null,
    constraint restaurant_pk primary key (id)
);

comment on table restaurants is 'Ресторан';
comment on column restaurants.id is 'Идентификатор';
comment on column restaurants.address is 'Авресс';
comment on column restaurants.status is 'Статус';

create sequence if not exists restaurantMenuItems_seq;

create table if not exists restaurant_menu_items
(
    id bigint not null default nextval ('restaurantMenuItems_seq'),
    restaurant_id bigint,
    name text not null,
    price double precision not null,
    image text not null,
    description text not null,
    constraint restaurant_menu_items_order_items_fk foreign key (id)
        references order_items(id) ,
    constraint restaurant_menu_items_restaurants_fk foreign key (restaurant_id)
        references restaurants(id) ,
    constraint restaurant_menu_items_pk primary key (id)
);

comment on table restaurant_menu_items is 'Заказы';
comment on column restaurant_menu_items.id is 'Идентификатор';
comment on column restaurant_menu_items.restaurant_id is 'Id заказа';
comment on column restaurant_menu_items.name is 'Имя ресторана';
comment on column restaurant_menu_items.price is 'Ценна';
comment on column restaurant_menu_items.image is 'Картинка';
comment on column restaurant_menu_items.description is 'Описание';


