package hello.core.member;

import hello.core.Appconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        //Appconfig appconfig= new Appconfig();
        //MemberService memberService= appconfig.memberService();

        //얘가 @bean으로 되있는거 다 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        // 메서드 이름으로 접근. 두번째 인자는 타입
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member member1 = memberService.findMember(1L);
        System.out.println("new findMember="+ member1.getName());
        System.out.println("member="+member.getName());
    }
}
