package study.springboot.tobyspring;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Component를 가지고 있는 Meta-Annotation
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello") // DispatcherServlet은 Bean을 다 뒤져서 해당 정보를 찾음.
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }

}
