package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //컨트롤러가 정적 파일보다 우선순위가 높아서 index.html 대신 home.html이 뜸
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
