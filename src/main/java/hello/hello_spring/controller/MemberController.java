package hello.hello_spring.controller;


import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //연결
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //회원 등록 폼 (조회할 때는 GET)
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    //회원 등록 (데이터를 등록할 때는 POST)
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //가입 끝나면 홈 화면으로
    }

    //회원 목록 조회
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
