package hello.core.member;

public class MemberServiceImpl implements  MemberService{


    private  final MemberRepository memberRepository=new MemoryMemberRepository();
    //다형성에 의해 얘네가 호출됨
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
