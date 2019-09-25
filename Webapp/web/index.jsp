<%--
  Created by IntelliJ IDEA.
  User: marsel
  Date: 9/17/2019
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link href="style.css" rel="stylesheet"/>
    <title>Server</title>
  </head>
  <body>
  <div class="header">
      <h1 align="center">
          Form
      </h1>
  </div>
    <div align="center">
      <form action="/news" method="post">
          <input id="name" type="text" name="name" placeholder="Enter name">
          <br>
          <input id="group" type="text" name="group" placeholder="Enter group">
          <br>
          <input type="submit" >
      </form>
    </div>

  </body>
</html>
