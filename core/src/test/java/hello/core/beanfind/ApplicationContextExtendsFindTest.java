package hello.core.beanfind;

import hello.core.Appconfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘이상 있으면 중복 오류가 발생한다")
    void findBeanBYParentTypeDuplicate(){
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                ()-> ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시 자식이 둘이상 있으면 빈이름을 지정한다")
    void findBeanBYParentTypeBeanName(){
        DiscountPolicy rateDiscount = ac.getBean("rateDiscount",DiscountPolicy.class);
        assertThat(rateDiscount).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회")
     void findBeanBySubName(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }
    @Test@DisplayName(" 부모 타입으로 모두 조회하기")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for(String key : beansOfType.keySet()){
            System.out.println("key  = " + key+ "value = "+beansOfType.get(key) );
        }
    }

    @Test
    @DisplayName("object 타입으로 조회하기")
    void findAllBeanByObjectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        for(String key : beansOfType.keySet()){
            System.out.println("key  = " + key+ "value = "+beansOfType.get(key) );
        }
    }
    @Configuration
    static  class TestConfig{
        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return  new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy FixDiscountPolicy(){
            return  new FixDiscountPolicy();
        }
    }

}

