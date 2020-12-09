package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    //정액 할인 정책
   private  int discountFixAccoint = 1000;//1000원 할인

    @Override
    public int discont(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAccoint;
        }
        else{
            return 0;
        }

    }
}
