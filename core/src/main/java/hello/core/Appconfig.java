package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class Appconfig {

    public MemberService memberService(){
        return new MemberServiceImpl();
    }
}
