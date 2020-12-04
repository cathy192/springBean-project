package hello.core.member;

import hello.core.Appconfig;

public class MemberApp {
    public static void main(String[] args) {

        Appconfig appconfig= new Appconfig();
        MemberService memberService= appconfig.memberService();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("new findMember="+ member1.getName());
        System.out.println("member="+member.getName());
    }
}
