package idusw.javaweb.sba2.service;

import idusw.javaweb.sba2.domain.Member;
import idusw.javaweb.sba2.repository.MemberDAO;
import idusw.javaweb.sba2.repository.MemberDAOImpl;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    public MemberServiceImpl() {
        memberDAO = new MemberDAOImpl();
    }



    @Override
    public int create(Member member) {
        return memberDAO.saveMember(member);
    }

    @Override
    public Member read(Member member) {
            return memberDAO.getMember(member);
    }

    @Override
    public List<Member> readList() {
        return memberDAO.getAllMember();
    }

    @Override
    public int update(Member member) {
        return memberDAO.updateMember(member);
    }

    @Override
    public int delete(Member member) {
        return memberDAO.deleteMember(member);
    }
}
