CREATE TABLE IF NOT EXISTS Trackings (
    tracking_id INT PRIMARY KEY UNIQUE,
    delivery_id INT,
    location VARCHAR(100),
    status VARCHAR(50),
    update_date DATE,
    FOREIGN KEY (delivery_id) REFERENCES Delivery(delivery_id)
);