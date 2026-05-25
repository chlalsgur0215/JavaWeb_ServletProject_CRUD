package idusw.javaweb.sba2.repository;

import idusw.javaweb.sba2.domain.Member;

import java.util.List;

public interface MemberDAO {
    int saveMember(Member member);
    Member getMember(Member member);
    List<Member> getAllMember();
    int updateMember(Member member);
    int deleteMember(Member member);
}
