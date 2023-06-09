CREATE TABLE IF NOT EXISTS Customers (
    uuid VARCHAR(255),
    customer_id SERIAL PRIMARY KEY UNIQUE,
    name VARCHAR(50),
    surname VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50) UNIQUE,
    salt VARCHAR(64),
    hashed_password VARCHAR(64)
);
