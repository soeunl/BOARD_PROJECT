package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.annotations.ModelAttribute;
import org.choongang.global.exceptions.*;
import org.choongang.member.entities.Member;
import org.choongang.member.validators.MemberUtil;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang")
public class CommonControllerAdvice {

    private final MemberUtil memberUtil;

    @ModelAttribute
    public boolean isLogin() {
        // 메서드명 자체가 속성명이 됩니다
        // 모든 컨트롤러가 이 속성을 공유하게 됩니다
        return memberUtil.isLogin();
    }

    @ModelAttribute
    public boolean isAdmin() {
        return memberUtil.isAdmin();
    }

    @ModelAttribute("commonValue2")
    public String commonValue() { // 여기에서 로그인 데이터 유지를 할 수 있음
        return "공통 값 속성 추가 테스트";
    }

    @ModelAttribute
    public Member loggedMember() { // 저장을 유지하려고 만든 기능
        return memberUtil.getMember();
    }

    /**
     * 공통 에러 페이지 처리
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {

        e.printStackTrace();

        if (e instanceof CommonException commonException) {
            int status = commonException.getStatus();
            response.setStatus(status); // 응답코드 추가를 위해 commonException에 정의했습니다

            StringBuffer sb = new StringBuffer(1000);
            if (e instanceof AlertException) {
                sb.append(String.format("alert('%s');", e.getMessage()));
            }

            if (e instanceof AlertBackException alertBackException) {
                String target = alertBackException.getTarget();
                sb.append(String.format("%s.history.back();", target));
            }

            if (e instanceof AlertRedirectException alertRedirectException) {
                String target = alertRedirectException.getTarget();
                String url = alertRedirectException.getRedirectUrl();

                sb.append(String.format("%s.location.replace('%s');", target, url));
            }

            if (!sb.isEmpty()) {
                request.setAttribute("script", sb.toString());
                return "commons/execute_script";
            }
        } else {
            // CommonException으로 정의한 예외가 아닌 경우 - 응답코드 500으로 처리
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }


        return "errors/error";
    }
}