package study.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import study.config.ConditionalMyOnClass;
import study.config.MyAutoConfiguration;
//import study.config.autoconfig.TomcatWebServerConfig.TomcatCondition;

@MyAutoConfiguration
//@Conditional(TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.setContextPath("/app");
//        factory.setContextPath(env.getProperty("contextPath"));
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());
        return factory;
    }

//    static class TomcatCondition implements Condition {
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",
//                context.getClassLoader());
//        }
//    }
}
