package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @DisplayName("어노테이션 필터 테스트")
    @Test
    void filterScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean(BeanB.class));
    }


    @Configuration
    @ComponentScan(
            includeFilters = @Filter(classes = MyIncludeComponent.class),
            excludeFilters = @Filter(classes = MyExcludeComponent.class)
            )
    static class ComponentFilterAppConfig {

    }
}
