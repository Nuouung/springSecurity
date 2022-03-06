package hello.springSecurity.controller;

import hello.springSecurity.domain.dao.Member;
import hello.springSecurity.domain.repository.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemoryMemberRepository memoryMemberRepository;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        Member member = memoryMemberRepository.findByUsername("userA").get();

        HttpSession session = request.getSession(true);
        session.setAttribute("user", member);

        return "index";
    }

}
