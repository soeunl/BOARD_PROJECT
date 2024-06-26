package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;

@Controller
@RequestMapping("/member") // 항상 앞에 주소는 member로 매칭이 됩니다
@RequiredArgsConstructor
public class MemberController {
    
    private final JoinService joinService; // 매번 객체를 만들 필요 없이 주입
    private final LoginService loginService;
    
    // 회원가입 양식
    @GetMapping("/join") // /memebr/join으로 유입됩니다
    public String join() {
        return "member/join";
    }
    
    // 회원가입 처리
    @PostMapping("/join")
    public String joinPs(RequestJoin form, HttpServletRequest request) { // 알아서 값이 다 주입된다

        joinService.process(form);

        String url = request.getContextPath() + "/member/login";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }
    
    // 로그인 양식
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }


    // 로그인 처리
    @PostMapping("/login")
    public String loginPs(RequestLogin form) {

        loginService.process(form);

        return "commons/execute_script";
    }
}
