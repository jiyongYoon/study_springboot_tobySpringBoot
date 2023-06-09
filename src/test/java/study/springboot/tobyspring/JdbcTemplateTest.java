package study.springboot.tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
//@Rollback(value = false) // 롤백하지 않겠다는 어노테이션
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @BeforeEach
//    void init() {
//        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
//    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values (?, ?)", "Toby", 3);
        jdbcTemplate.update("insert into hello values (?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }

    @Test
    void insertAndQuery2() { // 위 테스트 코드가 롤백되는지 한번 확인해보고자 함
        jdbcTemplate.update("insert into hello values (?, ?)", "Toby2", 3);
        jdbcTemplate.update("insert into hello values (?, ?)", "Spring2", 1);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        Assertions.assertThat(count).isEqualTo(2);
    }
}
