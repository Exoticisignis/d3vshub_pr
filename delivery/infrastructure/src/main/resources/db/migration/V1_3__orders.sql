CREATE TABLE IF NOT EXISTS Orders (
    order_id SERIAL PRIMARY KEY UNIQUE,
    customer_id BIGINT,
    order_date TIMESTAMP,
    total_price DECIMAL(10,2),
    address VARCHAR(100),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);