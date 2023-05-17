package study.springboot.tobyspring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME) // 이 어노테이션이 언제까지 유지될 것인가
@Target(ElementType.TYPE) // 이 어노테이션을 적용할 대상을 지정
@Component // Bean으로 사용될 클래스야!
public @interface MyComponent {

}
