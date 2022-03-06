package hello.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/member")
    public String getMember() {
        return "member/memberInfo";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/adminPage";
    }
}
