CREATE TABLE IF NOT EXISTS Items (
    item_id INT PRIMARY KEY UNIQUE,
    item_name VARCHAR(50),
    price DECIMAL(10,2),
    quantity INT,
    category VARCHAR(50),
    image_url VARCHAR(100),
    description VARCHAR(255),
    allergen_info VARCHAR(255)
);