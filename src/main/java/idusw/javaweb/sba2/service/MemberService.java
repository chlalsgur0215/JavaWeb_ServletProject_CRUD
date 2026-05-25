package idusw.javaweb.sba2.service;

import idusw.javaweb.sba2.domain.Member;

import java.util.List;

public interface MemberService {
    int create(Member member);
    Member read(Member member);
    List<Member> readList();
    int update(Member member);
    int delete(Member member);
}
