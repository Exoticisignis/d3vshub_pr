CREATE TABLE IF NOT EXISTS Couriers (
    courier_id SERIAL PRIMARY KEY UNIQUE,
    name VARCHAR(50),
    surname VARCHAR(50),
    phone VARCHAR(20),
    salt VARCHAR(64),
    hashed_password VARCHAR(64),
    login VARCHAR(50) UNIQUE
);