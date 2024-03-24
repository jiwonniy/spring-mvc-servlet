package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //서블릿이 호출되면 서비스 메서드가 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service"); //호출하면 콘솔창에 print
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        //메시지 파싱해서 읽을 필요가 없기 때문에 귀찮음을 줄여줌!
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //헤더 정보에 들어감
        response.setContentType("text/plain"); // 단순 문자
        response.setCharacterEncoding("utf-8"); //문자 인코딩, euc-kr 안씀

        response.getWriter().write("hello " + username);

    }
}
