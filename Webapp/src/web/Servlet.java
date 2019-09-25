package web;

import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends javax.servlet.http.HttpServlet {
    
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        printWriter.write("<html>\n" +
                "  <head>\n" +
                "      <link href=\"style.css\" rel=\"stylesheet\"/>\n" +
                "    <title>Server</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "  <div class=\"header\">\n" +
                "      <h1 align=\"center\">\n" +
                "          Hello " + name + ". Welcome to the group " + group + "\n" +
                "      </h1>\n" +
                "  </div>\n" +
                "    <div align=\"center\">\n" +
                " <a href=\"/login\">Login</a>" +
                "    </div>\n" +
                "\n" +
                "  </body>\n" +
                "</html>");
    }
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html>\n" +
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
                " <a href=\"/login\">Login</a>" +
                "    </div>\n" +
                "\n" +
                "  </body>\n" +
                "</html>");


    }
}
