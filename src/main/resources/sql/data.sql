-- 주문 데이터
INSERT INTO orders (order_id, product_name, order_amount, order_date) VALUES ('000001', '치킨', 17000, '2023-04-01');
INSERT INTO orders (order_id, product_name, order_amount, order_date) VALUES ('000002', '피자', 21000, '2023-04-02');
INSERT INTO orders (order_id, product_name, order_amount, order_date) VALUES ('000003', '커피', 12000, '2023-04-03');

-- 주문 메뉴 데이터
INSERT INTO order_menus (order_id, product_name, price) VALUES ('000001', '후라이드치킨', 17000);
INSERT INTO order_menus (order_id, product_name, price) VALUES ('000002', '페퍼로니피자', 11000);
INSERT INTO order_menus (order_id, product_name, price) VALUES ('000002', '치즈피자', 10000);
INSERT INTO order_menus (order_id, product_name, price) VALUES ('000003', '아메리카노', 4000);
INSERT INTO order_menus (order_id, product_name, price) VALUES ('000003', '카페라떼', 5000);
INSERT INTO order_menus (order_id, product_name, price) VALUES ('000003', '카푸치노', 3000);

-- 주문 결제 데이터
INSERT INTO order_payments (order_id, payment_method, payment_date) VALUES ('000001', '카드', '2023-04-01');
INSERT INTO order_payments (order_id, payment_method, payment_date) VALUES ('000002', '카드', '2023-04-02');
INSERT INTO order_payments (order_id, payment_method, payment_date) VALUES ('000003', '현금', '2023-04-03');

-- 주문 예약 데이터
INSERT INTO order_reservations (reservation_id, payment_type, store_code, order_amount, discount_amount, payment_amount) VALUES ('A01BC2345', 'AA01', 'S0001', 20000, 2000, 18000);
INSERT INTO order_reservations (reservation_id, payment_type, store_code, order_amount, discount_amount, payment_amount) VALUES ('A02DE3456', 'AA02', 'S0002', 15000, 1500, 13500);
INSERT INTO order_reservations (reservation_id, payment_type, store_code, order_amount, discount_amount, payment_amount) VALUES ('A03FG4567', 'AA01', 'S0003', 30000, 6000, 24000);
INSERT INTO order_reservations (reservation_id, payment_type, store_code, order_amount, discount_amount, payment_amount) VALUES ('A04HI5678', 'AA02', 'S0004', 12000, 1200, 10800);
INSERT INTO order_reservations (reservation_id, payment_type, store_code, order_amount, discount_amount, payment_amount) VALUES ('A05JK6789', 'AA01', 'S0005', 10000, 500, 9500);

-- 샘플 데이터 입력
INSERT INTO users (name, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO users (name, email) VALUES ('Jane Doe', 'jane.doe@example.com');