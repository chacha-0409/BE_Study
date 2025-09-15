package com.ll.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 액션 메서드가 리턴하는 것을 json(String) 형태로 변경

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
                        @RequestParam("a") int num1,
                        @RequestParam("b") int num2,
                        @RequestParam(name = "c", defaultValue = "0") int num3
    ) {
        return "a + b + c = %d".formatted(num1 + num2 + num3);
    }

    @GetMapping("c")
    @ResponseBody
    public String c(
            boolean married
    ) {
        return married ? "결혼" : "미혼";
    }

    @GetMapping("d")
    @ResponseBody
    public String d(
            Boolean married // null 허용
    ) { // 입력x true false
        if ( married == null ) return "정보를 입력해주세요.";
        return married ? "결혼" : "미혼";
    }
    
    // 바로 클래스 정의
    public static class Person {
        private String name;
        private int age;

        // 생성자
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        // 객체를 문자열로 읽기 좋게
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @GetMapping("person1")
    @ResponseBody
    public String person(
            String name,
            int age
    ) {
        Person person = new Person(name, age);
        return person.toString(); // tostring 직접 호출해서 리턴
    }

    @GetMapping("person2")
    @ResponseBody
    public String person2(
            Person person // 쿼리 파라미터를 자동으로 객체로 모아줌
    ) {
        return person.toString();
    }

    @GetMapping("e")
    @ResponseBody
    public int e() { // jackson이 string으로 리턴
        int age = 10;

        return age;
    }

    @GetMapping("f")
    @ResponseBody
    public Person g() { // ,, 객체를 json으로
        Person person = new Person("Paul", 22);

        return person;
    }

    @GetMapping("g")
    @ResponseBody
    public Map<String, Object> j() {
        Map<String, Object> person = new HashMap<>();
        person.put("age", 23);
        person.put("name", "Paul");

        return "a + b = %d".formatted(num1 + num2);
        return person;
    }
}