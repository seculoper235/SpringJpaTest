package Controller;

import Domain.Member;
import Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberController {
    @Autowired
    MemberService memberService;

    public List<Member> showAllMembers() {
        return memberService.findMemberAll();
    }
}
