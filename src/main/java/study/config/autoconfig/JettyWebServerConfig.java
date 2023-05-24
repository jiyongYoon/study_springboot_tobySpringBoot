package study.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import study.config.ConditionalMyOnClass;
import study.config.MyAutoConfiguration;
//import study.config.autoconfig.JettyWebServerConfig.JettyCondition;

@MyAutoConfiguration
//@Conditional(JettyCondition.class)
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

//    static class JettyCondition implements Condition {
//
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            // ConditionContext: 현재 Spring Container와 애플리케이션이 돌아가는 환경에 대한 정보를 가진 클래스
//            // AnnotatedTypeMetadata: @Conditional 어노테이션이 붙은 다른 클래스들의 정보를 가진 클래스
//            // 를 활용해서 bean을 등록할지 말지 true, false를 리턴해주면 됨.
//            return ClassUtils.isPresent("org.eclipse.jetty.server.Server",
//                context.getClassLoader());
//        }
//    }
}
