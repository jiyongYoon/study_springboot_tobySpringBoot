package study.springboot.tobyspring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class) // 스프링 컨텍스트를 이용하는 테스트가 가능해짐
@ContextConfiguration(classes = TobyspringApplication.class) // 어플리케이션에서 사용하는 모든 Bean 구성정보를 가져오게 됨
@TestPropertySource("classpath:/application.properties") // 프로퍼티 정보를 읽어오도록 설정
@Transactional
public @interface HelloBootTest {

}
