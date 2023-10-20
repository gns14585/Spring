package com.example.spring.service;

import com.example.spring.dao.MyDao6;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// sevice 안에는 하나의 @Transactional이 있어야함
@Service // 실제 업무를 하는 bean(Service)
@RequiredArgsConstructor
// 해당 어노테이션은 사용 하려는 같은 bean 안에선 불가하고, 따로 bean을 만들어서 그 bean을 호출해야함 그래서 이렇게 분리했음
@Transactional(rollbackFor = Exception.class) // checked exception 에도 롤백을 일으키고싶으면 매개변수 작성
public class MyService1 {

    private final MyDao6 dao;

    public void tx1() {
        dao.update1();

        int c = 1 / 0; // runtimeException

        dao.update2();
    }
}
