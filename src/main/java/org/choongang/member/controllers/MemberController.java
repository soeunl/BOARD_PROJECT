package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.services.JoinService;

@Controller
@RequestMapping("/member") // 항상 앞에 주소는 member로 매칭이 됩니다
@RequiredArgsConstructor
public class MemberController {
    
    private final JoinService joinService; // 매번 객체를 만들 필요 없이 주입
    
    // 회원가입 양식
    @GetMapping("/user/join") // /memebr/join으로 유입됩니다
    public String join() {
        return "member/user/join";
    }
    
    // 회원가입 처리
    @PostMapping("/user/join")
    public String joinPs(RequestJoin form) { // 알아서 값이 다 주입된다
        joinService.process(form);
        return "member/user/join";
    }
    
    // 로그인 양식
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String loginPs(RequestJoin form) { // 값이 알아서 주입된다
        // 양식을 제출하면 데이터가 넘어온다
        return null;
    }

    // 회원 관리 페이지
    @GetMapping("/admin/members") //
    public String members() {
        return "member/admin/members";
    }
}
