-- HAVING : 그룹함수(GROUP BY) 연산결과를 조건으로 줄 수 있는 키워드
-- 10만 달러 이상 소비한 고객 조회
SELECT C.CustomerName `고객명`, SUM(P.Price * OD.Quantity) `고객별 주문 금액`
FROM products P
         JOIN orderdetails OD
              ON P.ProductID = OD.ProductID
         JOIN orders O
              ON O.OrderID = OD.OrderID
         JOIN customers C
              ON C.CustomerID = O.CustomerID
GROUP BY C.CustomerID
HAVING `고객별 주문 금액` >= 100000;

-- 1) 총 처리 금액 10만 달러 미만인 직원 조회
-- orders, orderDetail, products, employees
SELECT CONCAT(E.FirstName, ' ', E.LastName) `직원명`, SUM(P.Price * OD.Quantity) `총 주문금액`
FROM employees E
         JOIN orders O
              ON E.EmployeeID = O.EmployeeID
         JOIN orderdetails OD
              ON OD.OrderID = O.OrderID
         JOIN products P
              ON P.ProductID = OD.ProductID
GROUP BY E.EmployeeID
HAVING `총 주문금액` < 100000
ORDER BY `총 주문금액`;




