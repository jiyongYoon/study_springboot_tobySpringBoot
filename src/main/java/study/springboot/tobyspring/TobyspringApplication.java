package study.springboot.tobyspring;


import javax.annotation.PostConstruct;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import study.config.MySpringBootApplication;

@MySpringBootApplication
public class TobyspringApplication {

    private final JdbcTemplate jdbcTemplate;

    public TobyspringApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct // 모든 프로퍼티 세팅이 다 끝나고 나면 스프링 컨테이너가 자동으로 실행해줌
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

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