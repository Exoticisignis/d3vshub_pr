INSERT INTO couriers(uuid, name, surname, phone, salt, hashed_password, login)
VALUES ('adkas0svd','name1','surname1','phone1','salt1','pass1','login1');
INSERT INTO couriers(uuid, name, surname, phone, salt, hashed_password, login)
VALUES ('s9010msd','name2','surname2','phone2','salt2','pass2','login2');
INSERT INTO couriers(uuid, name, surname, phone, salt, hashed_password, login)
VALUES ('saf23sadfs','name3','surname3','phone3','salt3','pass3','login3');
INSERT INTO couriers(uuid, name, surname, phone, salt, hashed_password, login)
VALUES ('190fsdfms','name4','surname4','phone4','salt4','pass4','login4');
INSERT INTO couriers(uuid, name, surname, phone, salt, hashed_password, login)
VALUES ('1salda;lm1','name5','surname5','phone5','salt5','pass5','login5');
INSERT INTO customers(uuid, name, surname, address, phone, salt, hashed_password, email)
VALUES ('adkas0svd','name1','surname1','address1','phone1','salt1','pass1','login1');
INSERT INTO customers(uuid, name, surname, address, phone, salt, hashed_password, email)
VALUES ('s9010msd','name2','surname2','address2','phone2','salt2','pass2','login2');
INSERT INTO customers(uuid, name, surname, address, phone, salt, hashed_password, email)
VALUES ('saf23sadfs','name3','surname3','address3','phone3','salt3','pass3','login3');
INSERT INTO customers(uuid, name, surname, address, phone, salt, hashed_password, email)
VALUES ('190fsdfms','name4','surname4','address4','phone4','salt4','pass4','login4');
INSERT INTO customers(uuid, name, surname, address, phone, salt, hashed_password, email)
VALUES ('1salda;lm1','name5','surname5','address5','phone5','salt5','pass5','login5');
INSERT INTO items(uuid, item_name, price, quantity, category, image_url, description, allergen_info)
VALUES ('12k0smo','item1',1,1,'category1','image1','desc1','allergen1');
INSERT INTO items(uuid, item_name, price, quantity, category, image_url, description, allergen_info)
VALUES ('omp01dfs','item2',1,1,'category2','image2','desc2','allergen2');
INSERT INTO items(uuid, item_name, price, quantity, category, image_url, description, allergen_info)
VALUES ('omp01dfs','item3',1,1,'category3','image3','desc3','allergen3');
INSERT INTO items(uuid, item_name, price, quantity, category, image_url, description, allergen_info)
VALUES ('omp01dfs','item4',1,1,'category4','image4','desc4','allergen4');
INSERT INTO items(uuid, item_name, price, quantity, category, image_url, description, allergen_info)
VALUES ('omp01dfs','item5',1,1,'category5','image5','desc5','allergen5');
INSERT INTO orders(uuid, customer_id, order_date, total_price, address)
VALUES ('wkfsdfk21',1, '2022-06-06 12:00:00', 0, 'address1');
INSERT INTO orders(uuid, customer_id, order_date, total_price, address)
VALUES ('qppaifm1km',2, '2022-06-06 12:00:00', 0, 'address2');
INSERT INTO orders(uuid, customer_id, order_date, total_price, address)
VALUES ('sq09ijasf',3, '2022-06-06 12:00:00', 0, 'address3');
INSERT INTO deliveries(uuid, order_id, courier_id, delivery_date)
VALUES ('1kdoaspf11', 1, 1, '2022-06-06 12:00:00');
INSERT INTO deliveries(uuid, order_id, courier_id, delivery_date)
VALUES ('1kdoaspf11', 2, 2, '2022-06-06 12:00:00');
INSERT INTO deliveries(uuid, order_id, courier_id, delivery_date)
VALUES ('1kdoaspf11', 3, 3, '2022-06-06 12:00:00');
INSERT INTO order_items(uuid, order_id, item_id, quantity)
VALUES ('1f0jdsfm', 1, 1, 1);
INSERT INTO order_items(uuid, order_id, item_id, quantity)
VALUES ('1oifaa;fsa', 1, 2, 1);
INSERT INTO order_items(uuid, order_id, item_id, quantity)
VALUES ('wpinfsdlf', 1, 3, 1);
INSERT INTO tracking(uuid, delivery_id, location, status, update_date)
VALUES ('dpmfddps', 2 , 'location1', 'status1', '2022-06-06 12:00:00');
INSERT INTO tracking(uuid, delivery_id, location, status, update_date)
VALUES ('asofpwme', 3 , 'location2', 'status2', '2022-06-06 12:00:00');