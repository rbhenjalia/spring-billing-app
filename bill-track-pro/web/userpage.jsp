<%-- 
    Document   : userpage
    Created on : 8 Oct, 2017, 7:21:38 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>userpage</title>
    </head>
    <body>
      <% 
        out.println("<h1>hello "+request.getSession().getAttribute("name")+"</h1>");
        %><br>
        <button><a href="bookings.jsp">make bookings</a></button><br>
        <button><a href="orders.jsp">place order</a></button><br>
       <button><a href="LogoutServlet">logout</a></button>
    </body>
</html>
