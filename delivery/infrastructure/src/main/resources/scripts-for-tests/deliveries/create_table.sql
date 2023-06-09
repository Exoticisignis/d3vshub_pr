CREATE TABLE IF NOT EXISTS Deliveries (
    uuid VARCHAR(255),
    delivery_id SERIAL PRIMARY KEY UNIQUE,
    order_id INT,
    courier_id INT,
    delivery_date TIMESTAMP,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (courier_id) REFERENCES Couriers(courier_id)
);