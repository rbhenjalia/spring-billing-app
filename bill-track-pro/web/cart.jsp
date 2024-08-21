<%-- 
    Document   : cart
    Created on : 8 Oct, 2017, 7:27:38 AM
    Author     : User
--%>

<%@page import="java.sql.*;" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cart</title>
    </head>
    <body>
        <button><a href="LogoutServlet">logout</a></button><br><br>
        <table>
        <%
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jugal","jugal","jugal");
            PreparedStatement pst=cn.prepareStatement("Select *from jugal.ORDERS");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
        %>
        <tr>
            <td><% out.println(rs.getInt(1)); %>
            <td><% out.println(rs.getString(2)); %>
            <td><% out.println(rs.getString(3)); %>
            <td><% out.println(rs.getInt(4)); %>
            <td><% out.println(rs.getInt(5)); %>
         </tr>
         <% } %>
        </table>
        <a href="cbookings.jsp">cancel order</a>
    </body>
</html>
