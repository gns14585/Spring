-- page
SELECT * FROM suppliers;
SELECT COUNT(*) FROM suppliers;
SELECT * FROM customers

-- 1페이지에 10개 ROWS
-- suppliers 목록은 3페이지가 마지막페이지
-- COUNT(*) : records 수 : 마지막 페이지
-- 1 ~ 10                : 1
-- 11 ~ 20               : 2
-- 21 ~ 30               : 3
-- 31 ~ 40               : 4

-- 레코드가 N개이고, 페이지가 10개씩 보여줄 때 마지막 페이지 번호는?
-- ((N-1) / 10) + 1
