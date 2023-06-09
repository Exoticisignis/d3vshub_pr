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