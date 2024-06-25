package org.choongang.member.mappers;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    Member get(String email); // mapper.xml의 id 값이 메서드 명이 됩니다
    int exist(String email);
    int register(Member member);
}
// SQL을 간단하게 사용하기 위해 인터페이스로 정의
