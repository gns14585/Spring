package com.example.spring.controller;

import com.example.spring.dao.MyDao6;
import com.example.spring.domain.MyDto37;
import com.example.spring.domain.MyDto38;
import com.example.spring.service.MyService1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {

    private final MyDao6 dao;
    private final MyService1 component;

    @GetMapping("sub1")
    public void method1(MyDto37 dto) {
        dao.insert1(dto);
        System.out.println("dto = " + dto);
    }

    // /main32/sub2?lastName=흥민
    @GetMapping("sub2")
    public void method2(MyDto38 dto) {
        dao.insert2(dto); // 직원 테이블에 lastName 입력
        System.out.println("dto = " + dto); // 새 직원의 id , lastName 출력
    }

    @GetMapping("sub3")
    public void method3() {

    }

    @PostMapping("sub4")
    public String method4(MyDto38 dto, RedirectAttributes rttr) {
        dao.insert3(dto);

        rttr.addFlashAttribute("message", dto.getId() + "번 직원이 등록되었습니다.");
        return "redirect:/main32/sub3";
    }

    // 예외 발생했을때의 잘못된 방식
    // 돈만 빠져나가고 받은 사람은 없음
    @GetMapping("sub5")
    public void method5() {
        try {
            // 방지하기 위해 @Transactional 어노테이션 삽입해줘야함 (변경하기 전으로 롤백해줌)
            // 사용 하려는 같은 bean 안에선 불가하고, 따로 bean을 만들어서 그 bean을 호출해야함 그래서 이렇게 분리했음
            component.tx1();
        } finally {
            System.out.println("dao.select3() = " + dao.select3());
        }
    }


}






















































