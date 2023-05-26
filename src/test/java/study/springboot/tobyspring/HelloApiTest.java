package study.springboot.tobyspring;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi() {

        TestRestTemplate rest = new TestRestTemplate();
        // 요청 만들어서 보내기
        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app2/hello?name={name}",
            String.class, "YOON");

        // 검증
        assertThat(res.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
        assertThat(res.getHeaders().getContentType().toString()).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(res.getBody()).isEqualTo("*Hello, YOON*");
    }

    @Test
    void failsHelloApi() {
        TestRestTemplate rest = new TestRestTemplate();
        // 요청 만들어서 보내기
        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app2/hello?name={name}",
            String.class, "");

        ResponseEntity<String> res2 = rest.getForEntity("http://localhost:9090/app2/hello?name=",
            String.class);

        // 검증
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(res2.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
