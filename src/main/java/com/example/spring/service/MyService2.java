package com.example.spring.service;

import com.example.spring.dao.MyDao9;
import com.example.spring.domain.MyDto33Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MyService2 {

    private final MyDao9 dao;

    public boolean validate(MyDto33Employee dto) {
        if (dto.getBirthDate() == null) {
            return false;
        }

        if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
            return false;
        }

        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            return false;
        }

        if (dto.getNotes() == null || dto.getNotes().isBlank()) {
            return false;
        }

        return true;
    }

    public int add(MyDto33Employee dto) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return dao.insertEmployee(dto);
    }
}
