package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletProfile")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            //response.sendRedirect("/login");
        } else {
            PrintWriter writer = response.getWriter();
            writer.write("\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "      <link href=\"style.css\" rel=\"stylesheet\"/>\n" +
                    "    <title>Server</title>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "  <div class=\"header\">\n" +
                    "      <h1 align=\"center\">\n" +
                    "          Profile\n" +
                    "      </h1>\n" +
                    "  </div>\n" +
                    "    <div align=\"center\">\n" +
                    "        <a href=\"/logout\">Logout</a>\n" +
                    "    </div>\n" +
                    "\n" +
                    "  </body>\n" +
                    "</html>");
        }
    }
}
