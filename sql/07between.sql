-- between
-- between AND 양 옆에 있는 값은 등호를 사용한것과 동일함
-- 등호를 사용하거나 BETWEEN 사용하거나 취향에 맞게 하면됨

SELECT * FROM products WHERE Price >= 10 AND Price <= 13;
SELECT * FROM products WHERE Price BETWEEN 10 AND 13;
SELECT * FROM products WHERE Price BETWEEN 10 AND 12.99;

SELECT * FROM products WHERE Price BETWEEN '10' AND '13';
SELECT * FROM customers WHERE CustomerName BETWEEN 'A' AND 'B';
SELECT * FROM orders WHERE OrderDate BETWEEN '1996-01-01' AND '1996-12-31';

-- 1) 가격이 30 ~ 40(포함) 사이인 상품 조회
SELECT * FROM products WHERE Price BETWEEN 30 AND 40;

-- 2) 1998년 2월에 주문한 주문조회
SELECT * FROM orders WHERE OrderDate BETWEEN '1998-02-01' AND '1998-02-28';

-- 3) 1958년 9월 태어난 직원 조회
SELECT * FROM employees WHERE BirthDate BETWEEN '1958-09-01' AND '1958-09-30';