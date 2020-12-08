package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
//메모리에서 코드용 메모리 리퍼지터리
@Component
public class MemoryMemberRepository implements  MemberRepository{ //인터페이스 구현

    private static Map<Long, Member>store= new HashMap<>(); //저장소니까 MAP으로


    @Override
    public void save(Member member) {

        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }
}
