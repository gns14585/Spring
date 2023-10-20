USE w3schools;

-- 업무, 단위, 거래
-- 하나 이상의 업무를 하나의 방식으로 처리
-- Tx:Auto -> Tx:Manual 변경

CREATE TABLE bank (
  name VARCHAR(10) PRIMARY KEY ,
  money INT NOT NULL DEFAULT 0
);
INSERT INTO bank (name, money)
VALUES ('son', 10000),
       ('kim', 10000);

-- 송금 업무 son -> kim 1000원 송금
UPDATE bank
SET money = money - 1000
WHERE name = 'son';
UPDATE bank
SET money = money + 1000
WHERE name = 'kim';

SELECT * FROM bank; -- TX:mANUAL 방식은 완료하기전까지 다른 연결에선 아직 반영되지 않았음.

-- 되돌리기
ROLLBACK; -- 다른 연결에 반영 안된 상태에 있는 정보랑 동일하게 하고싶을 경우 롤백사용
-- 반영하기
COMMIT; -- 변경내용이 반영되지 않은 다른 연결에 반영하기






























