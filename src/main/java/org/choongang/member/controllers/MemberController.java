package org.choongang.member.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/member") // 항상 앞에 주소는 member로 매칭이 됩니다
public class MemberController {
    
    // 회원가입 양식
    @GetMapping("/join") // /memebr/join으로 유입됩니다
    public String join() {
        return "member/join";
    }
    
    // 회원가입 처리
    @PostMapping("/join")
    public String joinPs() {
        return null;
    }
}
