CREATE TABLE IF NOT EXISTS Orders (
    order_id INT PRIMARY KEY UNIQUE,
    customer_id INT,
    order_date DATE,
    order_total DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);