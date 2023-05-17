package study.springboot.tobyspring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration // 구성 정보를 가진 클래스다. 전체 애플리케이션을 구성하는 정보를 다루기 때문에, AnnotationConfigWebApplicationContext에는 가장 먼저 등록이 된다.
@ComponentScan // @Component가 붙은 클래스를 Bean으로 등록해줘!
public class TobyspringApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(TobyspringApplication.class, args);
    }
}