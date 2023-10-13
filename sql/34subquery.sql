-- 비상관 쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용되지 않을 때
-- 각 공급자가 있는 나라의 고객 수는?
SELECT * FROM suppliers;

SELECT COUNT(*) FROM customers WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 1);
SELECT COUNT(*) FROM customers WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 2);
SELECT COUNT(*) FROM customers WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 3);

-- 상관쿼리 : 외부쿼리의(S.Ccountry) 컬럼이 내부쿼리에 사용될 때
SELECT
    S.SUPPLIERID, (SELECT COUNT(*) FROM customers WHERE Country = S.Country) AS 'Number of Cusomters'
FROM suppliers S;

-- 1) 각 직원보다 나이가 많은 직원의 수
SELECT e.LastName ,
       (SELECT COUNT(*)
        FROM employees
        WHERE BirthDate < E.BirthDate ) 'NumberOfEmp'
FROM employees E;