package web;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "ServletLogin")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login.equals("admin") && password.equals("password")) {
            HttpSession session = request.getSession(false);
            session.setAttribute("name", login);
            response.sendRedirect("profile");
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
                    "          Incorrect username or password\n" +
                    "      </h1>\n" +
                    "  </div>\n" +
                    "    <div align=\"center\">\n" +
                    "        <a href=\"/login\">Home</a>\n" +
                    "    </div>\n" +
                    "\n" +
                    "  </body>\n" +
                    "</html>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        final String html = "<html>\n" +
                "  <head>\n" +
                "      <link href=\"style.css\" rel=\"stylesheet\"/>\n" +
                "    <title>Server</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "  <div class=\"header\">\n" +
                "      <h1 align=\"center\">\n" +
                "          Form\n" +
                "      </h1>\n" +
                "  </div>\n" +
                "    <div align=\"center\">\n" +
                "      <form action=\"/login\" method=\"post\">\n" +
                "          <input id=\"name\" type=\"text\" name=\"login\" placeholder=\"Enter name\">\n" +
                "          <br>\n" +
                "          <input id=\"group\" type=\"password\" name=\"password\" placeholder=\"Enter group\">\n" +
                "          <br>\n" +
                "          <input type=\"submit\" >\n" +
                "      </form>\n" +
                "    </div>\n" +
                "\n" +
                "  </body>\n" +
                "</html>";
        PrintWriter writer = response.getWriter();
        writer.write(html);
    }
}
