package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인 대상 금액
     */
    int discont(Member member, int price);
}

