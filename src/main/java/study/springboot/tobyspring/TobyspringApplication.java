package study.springboot.tobyspring;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import study.config.MySpringBootApplication;

@MySpringBootApplication
public class TobyspringApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name: " + name);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TobyspringApplication.class, args);
    }
}