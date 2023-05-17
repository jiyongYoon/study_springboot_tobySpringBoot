package study.springboot.tobyspring;

import org.springframework.stereotype.Service;

@Service // @Component를 가지고 있는 Meta-Annotation
public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
