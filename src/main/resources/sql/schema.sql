-- 주문 테이블
CREATE TABLE orders (
    order_id CHAR(6) PRIMARY KEY,
    product_name VARCHAR(255),
    order_amount INT,
    order_date DATE
);

COMMENT ON COLUMN orders.order_id IS '주문 고유 식별자';
COMMENT ON COLUMN orders.product_name IS '상품명';
COMMENT ON COLUMN orders.order_amount IS '주문금액';
COMMENT ON COLUMN orders.order_date IS '주문날짜';

-- 주문 메뉴 테이블
CREATE TABLE order_menus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id CHAR(6),
    product_name VARCHAR(255),
    price INT,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

COMMENT ON COLUMN order_menus.id IS '주문 메뉴 고유 식별자';
COMMENT ON COLUMN order_menus.order_id IS '주문 고유 식별자';
COMMENT ON COLUMN order_menus.product_name IS '상품 이름';
COMMENT ON COLUMN order_menus.price IS '상품 가격';

-- 주문 결제정보 테이블
CREATE TABLE order_payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id CHAR(6),
    payment_method VARCHAR(255),
    payment_date DATE,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

COMMENT ON COLUMN order_payments.payment_id IS '결제 정보 고유 식별자';
COMMENT ON COLUMN order_payments.order_id IS '주문 고유 식별자';
COMMENT ON COLUMN order_payments.payment_method IS '결제 수단';
COMMENT ON COLUMN order_payments.payment_date IS '결제 날짜';

-- 주문 예약 테이블
CREATE TABLE order_reservations (
    reservation_id CHAR(9) PRIMARY KEY,
    payment_type CHAR(4),
    store_code CHAR(5),
    order_amount INT,
    discount_amount INT,
    payment_amount INT
);

COMMENT ON COLUMN order_reservations.reservation_id IS '예약 고유 식별자';
COMMENT ON COLUMN order_reservations.payment_type IS '결제 유형';
COMMENT ON COLUMN order_reservations.store_code IS '매장 코드';
COMMENT ON COLUMN order_reservations.order_amount IS '주문 금액';
COMMENT ON COLUMN order_reservations.discount_amount IS '할인 금액';
COMMENT ON COLUMN order_reservations.payment_amount IS '결제 금액';

-- 샘플 테이블
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);