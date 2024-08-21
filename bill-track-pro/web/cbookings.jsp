<%-- 
    Document   : cbookings
    Created on : 8 Oct, 2017, 7:29:19 AM
    Author     : User
--%>

<%@page import="java.sql.*;"contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cbookings</title>
    </head>
    <body>
     <%
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jugal","jugal","jugal");
            PreparedStatement pst=cn.prepareStatement("delete from jugal.ORDERS where UID=?");
            pst.setString(1,session.getAttribute("name").toString());
            if(pst.executeUpdate()>0)
            {
            response.sendRedirect("bookings.jsp");
            }
        %>
    </body>
</html>
