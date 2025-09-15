package com.ll.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 서버용 주석 - 아래는 모두 고객x서버o에서
// 창구직원 어노테이션 - 클래스 객체 자동 생성해서 요청 올 때마다 사용하는 컨트롤러
@Controller
public class HomeController {
    // 액션메서드 어노테이션 - 외부에서 호출 가능한 메서드
    @GetMapping("a")
    @ResponseBody // 브라우저에 리턴 어노테이션
    public String hello(
            String age,
            String id
    ) { // http://localhost:8080/a?age=22&id=1
        return "안녕하세요. %s번 사람의 나이는 %s살 입니다.".formatted(id, age);
    }

    @GetMapping("b")
    @ResponseBody
    public String plus( // 변수이름!=쿼리파라미터 ok
            @RequestParam("a") String num1Str,
            @RequestParam("b") String num2Str
    ) {
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        return "a + b = %d".formatted(num1 + num2);
    }
}