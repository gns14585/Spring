-- IN : 조건이 같으면 동일한 결과가 나옴

SELECT * FROM customers WHERE Country = 'UK' OR Country = 'Spain' OR Country = 'Italy';
SELECT * FROM customers WHERE Country IN ('UK', 'SPAIN', 'ITALY');

-- 1) 카테고리 3 또는 4에 속한 상품들
SELECT * FROM categories WHERE CategoryID IN (3,4);

-- 2) 1996년 7월 4일, 5일에 주문한 주문들
SELECT * FROM orders WHERE OrderDate IN ('1996-07-04', '1996-07-05');

-- 3) london이나 madrid, sevilla에 있는 고객들
SELECT * FROM customers WHERE City IN ('London', 'Madrid', 'Sevilla');