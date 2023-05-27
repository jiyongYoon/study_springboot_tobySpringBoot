package study.springboot.tobyspring;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class) // 스프링 컨텍스트를 이용하는 테스트가 가능해짐
//@ContextConfiguration(classes = TobyspringApplication.class) // 어플리케이션에서 사용하는 모든 Bean 구성정보를 가져오게 됨
//@TestPropertySource("classpath:/application.properties") // 프로퍼티 정보를 읽어오도록 설정
@HelloBootTest
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
