use w3schools;

SELECT * FROM employees E1 JOIN employees E2;

-- 같은 테이블끼리의 컬럼 비교
SELECT E1.LastName, E1.BirthDate, E2.LastName, E2.BirthDate
FROM employees E1 JOIN employees E2
WHERE E1.BirthDate < E2.BirthDate
AND E2.LastName = 'Leverling';


-- 1) 'Ipoh coffee' 보다 비싼 상품명 조회
SELECT p1.ProductName, p1.price
FROM products P1 JOIN products P2
WHERE P1.Price > P2.Price
AND P2.ProductName = 'Ipoh coffee';
