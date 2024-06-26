package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String loginPs(RequestLogin form, HttpServletRequest request) {

        loginService.process(form);
        
        String redirectUrl = form.getRedirectUrl();
        redirectUrl = redirectUrl == null || redirectUrl.isBlank() ? "/" : redirectUrl;
//        값이 없을 때는 메인 페이지, 값이 있을 때는 redirectUrl로 이동

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + redirectUrl);

        request.setAttribute("script", script);
//        원하는 주소로 이동

        return "commons/execute_script";
    }

    @RequestMapping("/logout") // get 방식이든 post 방식이든 모든 요청방식을 허용하면서 로그아웃
        public String logout(HttpSession session) {
            session.invalidate(); // 세션 비우기 : 로그아웃

            return "redirect:/member/login"; // 페이지 이동 response.sendRedirect(..)
    }
}
