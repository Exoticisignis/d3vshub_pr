CREATE TABLE IF NOT EXISTS Tracking (
    tracking_id BIGINT PRIMARY KEY UNIQUE,
    delivery_id BIGINT,
    location VARCHAR(100),
    status VARCHAR(50),
    update_date TIMESTAMP,
    FOREIGN KEY (delivery_id) REFERENCES Deliveries(delivery_id)
);