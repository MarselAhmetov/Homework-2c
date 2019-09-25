package web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "ServletLogin")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    private Cookie findCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                   return cookie;
                }
            }
        }
        return null;
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login.equals("admin") && password.equals("password")) {
            if (request.getParameter("rememberMe") != null) {
                Cookie cookie = new Cookie("login", login);
                response.addCookie(cookie);
            }
            HttpSession session = request.getSession(true);
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
        Cookie cookie;
        if (request.getSession(false).getAttribute("name") != null) {
            response.sendRedirect("profile");
        } else if ((cookie = findCookie(request, "login")) != null) {
                request.getSession(false).invalidate();
                HttpSession session = request.getSession(true);
                session.setAttribute("name", cookie.getValue());
                response.sendRedirect("profile");
        } else {
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
                    "          <input id=\"rememberMe\" type=\"checkbox\" name=\"rememberMe\">Remember me\n" +
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
}
