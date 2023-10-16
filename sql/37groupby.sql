use w3schools;

-- GROUP BY: 그룹함수 사용 시 그룹함수의 범위(그룹) 지정
SELECT COUNT(DISTINCT CategoryID)
FROM products;
SELECT CategoryID, MAX(Price)
FROM products
GROUP BY CategoryID;

SELECT CategoryID, MAX(Price) 'maxPrice', MIN(Price) 'minPrice'
FROM products
GROUP BY CategoryID
ORDER BY maxPrice DESC;

-- 일별 매출액
SELECT O.OrderDate, SUM(P.Price * OD.Quantity) '매출액'
FROM products P
         JOIN orderdetails OD
              ON P.ProductID = OD.ProductID
         JOIN orders O
              ON O.OrderID = OD.OrderID
GROUP BY O.OrderDate
ORDER BY O.OrderDate;

-- 1) 직원별 주문 처리금액 조회
-- 컬럼 : 직원명 , 직원별 주문 처리액
SELECT CONCAT(FirstName, ' ', LastName) '직원명', SUM(P.Price * OD.Quantity) '직원별 주문 처리액'
FROM orders O
         JOIN orderdetails OD
              ON O.OrderID = OD.OrderID
         JOIN employees E
              ON E.EmployeeID = O.EmployeeID
         JOIN products P
              ON OD.ProductID = P.ProductID
GROUP BY E.EmployeeID
ORDER BY 2 DESC;
-- 내림차순 (비싼 금액순)

-- 2) 고객별 총 주문 금액 조회
-- 고객명, 고객별 주문금액
SELECT C.CustomerName '고객명', SUM(P.Price * OD.Quantity) '고객별 주문 금액'
FROM products P
         JOIN orderdetails OD
              ON P.ProductID = OD.ProductID
         JOIN orders O
              ON O.OrderID = OD.OrderID
         JOIN customers C
              ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID
ORDER BY 2; -- 오름차순 (낮은 금액순)


-- 10만 달러 이상 소비한 고객 조회
-- 서브쿼리 방식
SELECT *
FROM
    (SELECT C.CustomerName '고객명', SUM(P.Price * OD.Quantity) '고객별 주문 금액'
      FROM products P
               JOIN orderdetails OD
                    ON P.ProductID = OD.ProductID
               JOIN orders O
                    ON O.OrderID = OD.OrderID
               JOIN customers C
                    ON C.CustomerID = O.CustomerID
      GROUP BY C.CustomerID
      ORDER BY 2) T1
WHERE T1.`고객별 주문 금액` >= 100000





















