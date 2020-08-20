package com.github.wangyuheng.utmanual.conf;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class ComponentConfigTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(ComponentConfig.class);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_context_load() {
        this.contextRunner
                .run(context -> {
                    assertNotNull(context.getBean("a"));
                    assertNotNull(context.getBean("customB"));
                    thrown.expect(NoSuchBeanDefinitionException.class);
                    context.getBean("c");
                });
    }

    @Test
    public void should_init_c_with_properties() {
        this.contextRunner
                .withPropertyValues("a=b")
                .run(context -> {
                    assertNotNull(context.getBean("a"));
                    assertNotNull(context.getBean("customB"));
                    assertNotNull(context.getBean("c"));
                });
    }

}