use w3schools;

-- 밑 3개 문법은 다 동일함
SELECT *
FROM products P
         JOIN suppliers S
              ON P.SupplierID = S.SupplierID;

SELECT *
FROM products P JOIN suppliers S
USING (SupplierID);

SELECT *
FROM products P NATURAL JOIN suppliers S; -- 두 테이블에 같은 이름의 테이블을 찾아서 JOIN 함

