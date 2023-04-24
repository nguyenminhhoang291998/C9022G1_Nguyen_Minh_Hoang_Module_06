-- role
INSERT INTO `be_technology_store`.`role` (`id`, `name`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `be_technology_store`.`role` (`id`, `name`) VALUES ('2', 'ROLE_EMPLOYEE');
INSERT INTO `be_technology_store`.`role` (`id`, `name`) VALUES ('3', 'ROLE_CUSTOMER');

-- person
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('13 Nguyễn Hoàng, Đà Nẵng', '1998-09-02', 'nguyenminhhoang291998@gmail.com', 1, '201736766', 0, 'Nguyễn Hoàng', '0905876666');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('45 Tố Hữu, Đà Nẵng', '2000-05-20', 'nguyenvananh2000@gmail.com', 1, '201738888', 0, 'Nguyễn Văn Ánh', '0908888888');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('133 Lê Duẩn, Đà Nẵng', '2001-06-11', 'nguyenthanhtam@gmail.com', 0, '871231212', 0, 'Nguyễn Thanh Tâm', '0903987123');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('231 Lê Lợi, Đà Nẵng', '1992-02-11', 'phanthuytien92@gmail.com', 0, '291212132', 0, 'Phan Thùy Tiên', '0905125123');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('55 Lê Thanh Nghị, Đà Nẵng', '1995-06-06', 'tranhuuthanh95@gmail.com', 1, '765221229', 0, 'Trần Hữu Thành', '0901332281');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('199 Tố Hữu, Đà Nẵng', '1990-02-16', 'thanhchien90@gmail.com', 1, '909123122', 0, 'Đỗ Thành Chiến', '0911387772');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('21 Đống Đa, Đà Nẵng', '1995-06-12', 'phuongnguyen95@gmail.com', 0, '012345678', 0, 'Nguyễn Thị Phương', '0909123456');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('144 Nguyễn Du, Đà Nẵng', '1999-01-02', 'duyhung99@gmail.com', 1, '012345679', 0, 'Phạm Duy Hưng', '0901999999');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('123 Lê Lợi, Đà Nẵng', '1992-08-25', 'hanhnguyen92@gmail.com', 0, '012345680', 0, 'Nguyễn Thị Hạnh', '0908888348');
INSERT INTO `be_technology_store`.`person` (`address`, `date_of_birth`, `email`, `gender`, `id_card`, `is_deleted`, `name`, `phone_number`) VALUES ('79 Trần Hưng Đạo, Đà Nẵng', '1997-12-28', 'ducthang97@gmail.com', 1, '012345681', 0, 'Trần Đức Thắng', '0907777777');

-- account
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES ('1', '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',1);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (2, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',2);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (3, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',3);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (4, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',4);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (5, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',5);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (6, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',6);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (7, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',7);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (8, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',8);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (9, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',9);
INSERT INTO `be_technology_store`.`account` (`id`, `password`,`person_id`) VALUES (10, '$2a$12$VT6AqwoYrCWsI0oeM2zmL.yRvJ4oDyOB4oZDo3uaQRUWeVXJcA0Ny',10);

-- account_role
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('3', '2');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('4', '2');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('5', '2');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('6', '3');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('7', '3');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('8', '3');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('9', '3');
INSERT INTO `be_technology_store`.`account_role` (`account_id`, `role_id`) VALUES ('10', '3');


-- order
INSERT INTO `be_technology_store`.`orders` (`date_purchase`, `is_paid`,`order_code`, `person_id`, `employee_id`) VALUES ('2023-03-13', 1,'1',6,2);
INSERT INTO `be_technology_store`.`orders` (`date_purchase`, `is_paid`,`order_code`, `person_id`, `employee_id`) VALUES ('2023-03-15', 1,'2',7,3);
INSERT INTO `be_technology_store`.`orders` (`date_purchase`, `is_paid`,`order_code`, `person_id`, `employee_id`) VALUES ('2023-04-11', 1,'3',8,4);
INSERT INTO `be_technology_store`.`orders` (`date_purchase`, `is_paid`,`order_code`, `person_id`, `employee_id`) VALUES ('2023-03-16', 1,'4',9,5);
INSERT INTO `be_technology_store`.`orders` (`date_purchase`, `is_paid`,`order_code`, `person_id`, `employee_id`) VALUES ('2023-04-16', 0,'5',10,2);
INSERT INTO `be_technology_store`.`orders` (`date_purchase`, `is_paid`,`order_code`, `person_id`, `employee_id`) VALUES ('2023-04-16', 0,'6',7,3);

-- product_type 
INSERT INTO `be_technology_store`.`product_type` (`id`, `name`) VALUES ('1', 'Laptop');
INSERT INTO `be_technology_store`.`product_type` (`id`, `name`) VALUES ('2', 'Điện thoại');

-- brands
INSERT INTO `be_technology_store`.`brands` (`id`, `name`) VALUES ('1', 'Apple');
INSERT INTO `be_technology_store`.`brands` (`id`, `name`) VALUES ('2', 'Microsoft');
INSERT INTO `be_technology_store`.`brands` (`id`, `name`) VALUES ('3', 'Samsung');
INSERT INTO `be_technology_store`.`brands` (`id`, `name`) VALUES ('4', 'Xiaomi');

-- product

INSERT INTO `be_technology_store`.`product` (`description`, `name`, `price`, `product_quantity`, `release_date`, `brands_id`, `product_type_id`)
VALUES 
    ('IPhone 13 là chiếc smartphone mới nhất của Apple với nhiều cải tiến về camera, hiệu năng và tính năng an toàn. ', 'Iphone 13', '17990000', '10', '2022-09-24', '1', '2'),
    ('IPhone 11 là một trong những sản phẩm điện thoại bán chạy nhất của Apple với màn hình Liquid Retina, camera kép 12MP và chip A13 Bionic. ', 'Iphone 11', '10990000', '15', '2019-09-20', '1', '2'),
    ('IPhone X có thiết kế toàn màn hình, Face ID, camera kép 12MP và chip A11 Bionic với khả năng xử lý tuyệt vời.', 'Iphone X', '9999000', '5', '2017-11-03', '1', '2'),
    ('IPhone XS Max là phiên bản lớn nhất của iPhone XS với màn hình OLED Super Retina 6.5 inch, camera kép 12MP và chip A12 Bionic.', 'Iphone XS Max', '17999000', '8', '2018-09-21', '1', '2');

INSERT INTO `be_technology_store`.`product` (`description`, `name`, `price`, `product_quantity`, `release_date`, `brands_id`, `product_type_id`) 
VALUES ('IPhone 14 Pro hội tụ những tính năng đẳng cấp nhất với thiết kế mới, bộ vi xử lý Apple A16 Bionic với sức mạnh chưa từng thấy, camera 48MP nâng cấp vượt trội, màn hình Always-On đầy thú vị và hơn thế nữa. ', 'Iphone 14 pro', '24900000', '12', '2023-01-13', '1', '2');

INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES ('MacBook Pro 2023 với M2 chip mới, 16GB RAM, 1TB SSD, màn hình Retina 14 inch, đáp ứng nhu cầu của những người dùng chuyên nghiệp.', 'MacBook Pro 2023', '39990000', '5', '2023-02-23', '1', '1');
INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES 
    ('MacBook Air M1 2020 với chip M1, màn hình Retina, bàn phím Magic Keyboard và Touch ID, là lựa chọn hoàn hảo cho các tác vụ hàng ngày.', 'MacBook Air M1 2020', '25990000', '10', '2020-11-17', '1', '1'),
    ('MacBook Pro M1 2020 với chip M1, RAM 8GB hoặc 16GB, màn hình Retina 13 inch, Touch Bar và Touch ID, là công cụ lý tưởng cho các công việc đòi hỏi hiệu năng cao.', 'MacBook Pro M1 2020', '30990000', '8', '2020-11-17', '1', '1'),
    ('MacBook Pro 13 inch M2 với chip M2 mới, RAM 16GB hoặc 32GB, 1TB hoặc 2TB SSD, màn hình Retina 13 inch cải tiến, mang lại hiệu năng và trải nghiệm tốt nhất cho người dùng.', 'MacBook Pro M2', '43990000', '5', '2023-07-15', '1', '1'),
    ('MacBook Air M2 2022 với chip M2 mới, RAM 8GB hoặc 16GB, 512GB hoặc 1TB SSD, màn hình Retina 13 inch cải tiến, là sự kết hợp hoàn hảo giữa hiệu năng và di động.', 'MacBook Air M2 2022', '29990000', '7', '2022-09-14', '1', '1');


INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES ('Surface Pro 9 với bộ vi xử lý Intel Core i7 thế hệ 12, màn hình 13.5 inch PixelSense, 16GB RAM, 1TB SSD, Windows 11, làm việc và giải trí trên cùng một thiết bị.', 'Surface Pro 9', '49990000', '3', '2023-04-01', '2', '1');
INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES 
    ('Surface Pro 7 với bộ vi xử lý Intel Core i5 hoặc i7, màn hình 12.3 inch PixelSense, RAM 8GB hoặc 16GB, 128GB hoặc 256GB hoặc 512GB hoặc 1TB SSD, Windows 10, giúp bạn làm việc và giải trí mọi lúc mọi nơi.', 'Surface Pro 7', '28990000', '7', '2019-10-22', '2', '1'),
    ('Surface Laptop 4 với bộ vi xử lý Intel Core i5 hoặc i7, màn hình 13.5 inch PixelSense hoặc 15 inch PixelSense, RAM 8GB hoặc 16GB hoặc 32GB, 128GB hoặc 256GB hoặc 512GB hoặc 1TB hoặc 2TB SSD, Windows 10 hoặc 11, đem lại trải nghiệm làm việc và giải trí tuyệt vời cho người dùng.', 'Surface Laptop 4', '32990000', '5', '2021-04-13', '2', '1'),
    ('Surface Pro 8 với bộ vi xử lý Intel Core i5 hoặc i7 thế hệ 11, màn hình 13 inch PixelSense, RAM 8GB hoặc 16GB hoặc 32GB, 128GB hoặc 256GB hoặc 512GB hoặc 1TB hoặc 2TB SSD, Windows 11, làm việc và giải trí trên cùng một thiết bị.', 'Surface Pro 8', '39990000', '4', '2022-10-05', '2', '1');



INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES ('Galaxy S23 Ultra với camera 108MP, Exynos 990, màn hình 6.9 inch Dynamic AMOLED, RAM 16GB, ROM 512GB, pin 6000mAh, hỗ trợ sạc siêu tốc 100W.', 'Galaxy S23 Ultra', '29990000', '10', '2023-05-18', '3', '2');
INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES ('Galaxy S22 Ultra với camera 64MP, Exynos 9855, màn hình 6.8 inch Dynamic AMOLED, RAM 12GB, ROM 256GB, pin 5000mAh, hỗ trợ sạc siêu tốc 80W.', 'Galaxy S22 Ultra', '22990000', '8', '2022-03-10', '3', '2'),
('Galaxy S20 FE với camera 12MP, Snapdragon 865, màn hình 6.5 inch Super AMOLED, RAM 8GB, ROM 128GB, pin 4500mAh, hỗ trợ sạc siêu tốc 45W.', 'Galaxy S20 FE', '13990000', '15', '2020-09-23', '3', '2'),
('Galaxy A34 với camera 64MP, Snapdragon 678, màn hình 6.5 inch Super AMOLED, RAM 6GB, ROM 128GB, pin 5000mAh, hỗ trợ sạc nhanh 25W.', 'Galaxy A34', '7490000', '20', '2023-02-01', '3', '2'),
('Galaxy Z Flip4 với camera 16MP, Snapdragon 888, màn hình 6.7 inch Dynamic AMOLED, RAM 8GB, ROM 256GB, pin 3300mAh, hỗ trợ sạc nhanh 25W.', 'Galaxy Z Flip4', '27990000', '5', '2023-07-15', '3', '2');

INSERT INTO be_technology_store.product (description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES ('Redmi Note 12 Pro với camera 108MP, Snapdragon 888, RAM 8GB, ROM 256GB, màn hình 6.8 inch IPS LCD, pin 5000mAh, sạc nhanh 66W.', 'Redmi Note 12 Pro', '9999000', '20', '2023-06-02', '4', '2');

INSERT INTO be_technology_store.product 
(description, name, price, product_quantity, release_date, brands_id, product_type_id)
VALUES
('Redmi Note 12 với Snapdragon 778G, RAM 6GB, ROM 128GB, camera 64MP, màn hình 6.6 inch AMOLED,
 pin 5000mAh, sạc nhanh 33W.', 'Redmi Note 12', '5999000', '30', '2023-08-10', '4', '2'),
('Redmi Note 11 với MediaTek Dimensity 920, RAM 6GB, ROM 128GB, camera 48MP, màn hình 6.5 inch IPS LCD,
 pin 5000mAh, sạc nhanh 44W.', 'Redmi Note 11', '4499000', '25', '2023-07-22', '4', '2'),
('Xiaomi 13 với Snapdragon 898, RAM 8GB, ROM 256GB, camera 108MP, màn hình 6.8 inch Super AMOLED,
 pin 4500mAh, sạc nhanh 120W.', 'Xiaomi 13', '26999000', '5', '2023-09-05', '4', '2'),
('Xiaomi 12T với Snapdragon 870, RAM 8GB, ROM 128GB, camera 64MP, màn hình 6.7 inch IPS LCD, pin 4500mAh,
 sạc nhanh 66W.', 'Xiaomi 12T', '13999000', '15', '2023-06-25', '4', '2'),
('Xiaomi Note 11 Pro với MediaTek Dimensity 1200, RAM 8GB, ROM 256GB, camera 108MP, màn hình 6.9 inch IPS LCD,
 pin 5000mAh, sạc nhanh 100W.', 'Xiaomi Note 11 Pro', '18999000', '10', '2023-08-01', '4', '2');


-- order_detail

INSERT INTO `be_technology_store`.`order_detail` (`id`, `ordered_quantity`, `order_id`, `product_id`) VALUES ('1', '1', '1', '1');
INSERT INTO `be_technology_store`.`order_detail` (`id`, `ordered_quantity`, `order_id`, `product_id`) VALUES ('2', '1', '2', '5');
INSERT INTO `be_technology_store`.`order_detail` (`id`, `ordered_quantity`, `order_id`, `product_id`) VALUES ('3', '1', '3', '7');
INSERT INTO `be_technology_store`.`order_detail` (`id`, `ordered_quantity`, `order_id`, `product_id`) VALUES ('4', '2', '4', '2');
INSERT INTO `be_technology_store`.`order_detail` (`id`, `ordered_quantity`, `order_id`, `product_id`) VALUES ('5', '1', '5', '9');

-- image
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('1', 'https://shopdunk.com/images/thumbs/0000617_starlight_550.png', '1');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('2', 'https://shopdunk.com/images/thumbs/0012169_black_550.jpeg', '2');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('3', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/i/p/iphone_x_64gb_4.jpg', '3');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('4', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/i/p/iphone_xs_max_256gb_1_3.jpg', '4');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('5', 'https://shopdunk.com/images/thumbs/0008744_iphone-14-pro-128gb_550.png', '5');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('6', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/m/b/mbp14-spacegray-select-202301_1.jpg', '6');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('7', 'https://shopdunk.com/images/thumbs/0006171_gold_550.webp', '7');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('8', 'https://shopdunk.com/images/thumbs/0001262_silver_550.webp', '8');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('9', 'https://shopdunk.com/images/thumbs/0008683_macbook-pro-13-inch-m2-chip-with-8-core-cpu-and-10-core-gpu-8gb-ram-256gb-ssd_550.webp', '9');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('10', 'https://shopdunk.com/images/thumbs/0008514_macbook-air-136-inch-m2-chip-with-8-core-cpu-and-8-core-gpu-256gb_550.png', '10');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('11', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/t/e/text_ng_n_23__7.png', '11');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('12', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/m/i/microsoft_surface_pro-02_3.jpg', '12');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('13', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/_/0/_0000_surface-laptop-4-02.jpg', '13');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('14', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/u/surface-laptop-pro-8-core-i7-ram-8gb-ssd-256gb-1_.jpg', '14');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('15', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/2/s23-ultra-xanh.png', '15');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('16', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/m/sm-s908_galaxys22ultra_front_green_211119_2.jpg', '16');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('17', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/a/samsung-galaxy-20-fe_3_.jpg', '17');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('18', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/m/sm-a346_galaxy_a34_5g_awesome_graphite_front.png', '18');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('19', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/a/samsung_galaxy_z_flip_m_i_2022-1_1.jpg', '19');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('20', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/g/t/gtt7766.jpg', '20');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('21', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/g/t/gtt_7766_3__1.jpg', '21');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('22', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/8/0/800x800-640x640-5.png', '22');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('23', 'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/p/m/pms_1670745783.80967984.png', '23');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('24', 'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/x/i/xiaomi-12t-den_1.jpg', '24');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('25', 'https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/t/_/t_i_xu_ng_2_18.png', '25');
INSERT INTO `be_technology_store`.`image` (`id`, `url`, `product_id`) VALUES ('26', 'https://shopdunk.com/images/thumbs/0000627_blue_550.webp', '1');
