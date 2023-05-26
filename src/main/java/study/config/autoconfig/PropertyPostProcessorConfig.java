package study.config.autoconfig;

import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import study.config.MyAutoConfiguration;
import study.config.MyConfigurationProperties;

/**
 * MyConfigurationProperties 어노테이션이 붙은 클래스들은 Bean을 자동으로 바인딩하게 하는 로직
 */
@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties annotation =
                    AnnotationUtils.findAnnotation(
                        bean.getClass(), MyConfigurationProperties.class);

                if (annotation == null) return bean;

                Map<String, Object> attrs =
                    AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String) attrs.get("prefix");

                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}
