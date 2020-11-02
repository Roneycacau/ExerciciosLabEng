import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tabuada")
public class Tabuada extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer = resp.getWriter();
            String num = req.getParameter("num");
            int bla = num.isBlank() ? 8 : Integer.parseInt(num);
            for (int i = 1; i < 10; i++) {
                int result = i * bla;
                writer.printf("%d x  %d  = %d %n", bla, i, result);
            }
                writer.printf("%d x %d  = %d %n", bla, 10, bla*10);
                writer.flush();
        } catch (Exception e) {
            PrintWriter writer = resp.getWriter();
            for (int i = 1; i < 10; i++) {
                int result = i * 8;
                writer.printf("%d x  %d  = %d %n", 8, i, result);
            }
                writer.printf("%d x %d  = %d %n", 8, 10, (8*10));
                writer.flush();
        }
    }
}
