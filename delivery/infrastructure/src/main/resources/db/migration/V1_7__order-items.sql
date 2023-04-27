CREATE TABLE IF NOT EXISTS Order_Items (
    order_id INT,
    item_id INT,
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