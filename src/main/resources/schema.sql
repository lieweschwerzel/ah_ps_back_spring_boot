 create table subscription (
       id int8 not null,
        discount varchar(255),
        email varchar(255),
        img_url varchar(255),
        price float8,
        product_name varchar(255),
        unit varchar(255),
        primary key (id)
    )