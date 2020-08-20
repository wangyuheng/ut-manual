package com.github.wangyuheng.utmanual.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {

    @Bean
    public A a() {
        return new A();
    }


    @Bean
    public B customB() {
        return new B();
    }

    @Bean
    @ConditionalOnProperty("a")
    public C c() {
        return new C();
    }


    private static class A {

    }

    private static class B {

    }

    private static class C {

    }


}
