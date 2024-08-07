package org.choongang.board.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoardData;
import org.choongang.board.entities.BoardData;
import org.choongang.board.mappers.BoardDataMapper;
import org.choongang.board.validators.BoardSaveValidator;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;

/**
 * 게시글 추가, 수정
 *
 */
@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardDataMapper mapper;
    private final BoardSaveValidator validator;

    public void save(RequestBoardData form) {

        validator.check(form);

        String mode = form.getMode();
        mode = mode == null || mode.isBlank() ? "write" : mode;
        BoardData data = new ModelMapper().map(form, BoardData.class);
        
        if(mede.equals("update")) {
            // 수정
        } else {
            // 현재 로그인한 회원 번호
            if (memberUtil.islogin()) {
                data.setMemberSeq(MemberUtil.getMember().getUserNo());
            }
            // 작성자 환경 정보
            HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);
            String ua = request.getHeader("User-Agent"); // 사용자 브라우저 정보
            String ip = request.getRemoteAddr(); // 작성자 IP 정보
            data.setUa(ua);
            data.setIp(ip);
        }
    }
}
