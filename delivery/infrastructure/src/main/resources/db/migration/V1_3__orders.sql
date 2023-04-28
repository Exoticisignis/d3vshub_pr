CREATE TABLE IF NOT EXISTS Orders (
    order_id INT PRIMARY KEY UNIQUE,
    customer_id INT,
    order_date DATE,
    total_price DECIMAL(10,2),
    address VARCHAR(100),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);