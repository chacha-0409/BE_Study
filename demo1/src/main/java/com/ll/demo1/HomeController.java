package com.ll.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 서버용 주석 - 아래는 모두 고객x서버o에서
// 창구직원 어노테이션 - 클래스 객체 자동 생성해서 요청 올 때마다 사용하는 컨트롤러
@Controller
public class HomeController {
    // 액션메서드 어노테이션 - 외부에서 호출 가능한 메서드
    @GetMapping("a")
    @ResponseBody // 브라우저에 리턴 어노테이션
    public String hello() {
        return "Hello";
    }

    @GetMapping("b")
    @ResponseBody
    public String hello2() {
        System.out.println("Hello2!");

        return "안녕하세요";
    }
}