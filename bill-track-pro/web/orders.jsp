<%-- 
    Document   : orders
    Created on : 8 Oct, 2017, 7:19:36 AM
    Author     : User
--%>

<%@page import="java.sql.*;" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
    </head>
    <body>
         <button><a href="LogoutServlet">logout</a></button><br><br>
        <% 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jugal","jugal","jugal");
            PreparedStatement pst=cn.prepareStatement("Select *from jugal.ITEMS");
            ResultSet rs=pst.executeQuery();%>
        <form action="Carter" method="post">
            <select name="items">
            <optgroup label="name  price" ></optgroup>
        <% while(rs.next()){
        %>
                <option value="<% out.print(rs.getInt(1));%>"><% out.print(rs.getString(2));%>&nbsp;&nbsp;<% out.print(rs.getInt(3));%>
            </option>
                
  <% } %>
    </select>
    <input type="number" name="quantity"/>
    <input type="submit" value="add"/>
        </form>
    <a href="cart.jsp">show cart</a>
    </body>
</html>
