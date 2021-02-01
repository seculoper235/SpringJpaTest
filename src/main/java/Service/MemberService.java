package Service;

import Domain.Member;
import Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findMemberAll() {
        return memberRepository.findAll();
    }
}
