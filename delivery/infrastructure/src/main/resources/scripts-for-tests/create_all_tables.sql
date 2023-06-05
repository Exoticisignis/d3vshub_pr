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
CREATE TABLE IF NOT EXISTS Couriers (
    uuid VARCHAR(255),
    courier_id SERIAL PRIMARY KEY UNIQUE,
    name VARCHAR(50),
    surname VARCHAR(50),
    phone VARCHAR(20),
    salt VARCHAR(64),
    hashed_password VARCHAR(64),
    login VARCHAR(50) UNIQUE
);
CREATE TABLE IF NOT EXISTS Items (
    uuid VARCHAR(255),
    item_id SERIAL PRIMARY KEY UNIQUE,
    item_name VARCHAR(50),
    price DECIMAL(10,2),
    quantity INT,
    category VARCHAR(50),
    image_url VARCHAR(100),
    description VARCHAR(255),
    allergen_info VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Orders (
    uuid VARCHAR(255),
    order_id SERIAL PRIMARY KEY UNIQUE,
    customer_id BIGINT,
    order_date TIMESTAMP,
    total_price DECIMAL(10,2),
    address VARCHAR(100),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);
CREATE TABLE IF NOT EXISTS Deliveries (
    uuid VARCHAR(255),
    delivery_id SERIAL PRIMARY KEY UNIQUE,
    order_id INT,
    courier_id INT,
    delivery_date TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (courier_id) REFERENCES Couriers(courier_id)
);
CREATE TABLE IF NOT EXISTS Order_Items (
    uuid VARCHAR(255),
    order_id BIGINT,
    item_id BIGINT,
    quantity INT,
    PRIMARY KEY (order_id, item_id),
    CONSTRAINT fk_order_id
        FOREIGN KEY (order_id)
        REFERENCES Orders(order_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_item_id
        FOREIGN KEY (item_id)
        REFERENCES Items(item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS Tracking (
    uuid VARCHAR(255),
    tracking_id SERIAL PRIMARY KEY UNIQUE,
    delivery_id BIGINT,
    location VARCHAR(100),
    status VARCHAR(50),
    update_date TIMESTAMP,
    FOREIGN KEY (delivery_id) REFERENCES Deliveries(delivery_id)
);