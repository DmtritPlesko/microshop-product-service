CREATE TABLE IF NOT EXISTS products (
    id varchar(32) PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(100),
    sku varchar(32),
    price double,
    brand varchar(32),
    model varchar(64),
    create_at timestamp,
    availability boolean
);