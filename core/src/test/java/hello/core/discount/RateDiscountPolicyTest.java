package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy=new RateDiscountPolicy();


    @Test
    @DisplayName("vip는 10프로 할인이 적용되어야한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discont(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("vip가 아니면 10% 할인이 적용되어선 안된다.")
    void vip_x(){
        Member member2 = new Member(2L, "membernomarl", Grade.BASIC);

        int discount = discountPolicy.discont(member2,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }

}