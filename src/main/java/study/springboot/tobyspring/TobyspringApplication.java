package study.springboot.tobyspring;


import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class TobyspringApplication {

    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> { // 익명 클래스를 람다식으로 해서 서블릿 컨테이너에 서블릿을 등록
            HelloController helloController = new HelloController();

            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) { // url 과 HttpMethod 검증
                        // 해당 서블릿이 받을 web HTTP 요청
                        String name = req.getParameter("name");

                        String ret = helloController.hello(name); // Body를 만드는 로직은 다른 클래스에 위임

                        // 해당 서블릿이 응답할 web HTTP 응답 만들기
                        resp.setStatus(HttpStatus.OK.value()); // 상태 코드
                        resp.setHeader(HttpHeaders.CONTENT_TYPE,
                            MediaType.TEXT_PLAIN_VALUE); // Header
                        resp.getWriter().println(ret); // Body
                    }
                    else if (req.getRequestURI().equals("/user")) {
                        // 블라블라
                    }
                    else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*"); // Mapping
        });
        webServer.start();
    }

}