<%-- 
    Document   : adminpage
    Created on : 8 Oct, 2017, 7:23:37 AM
    Author     : User
--%>

<%@page import="java.sql.*;"  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>adminpage</title>
    </head>
    <body>
       <button><a href="LogoutServlet">logout</a></button><br><br>
        <% 
        out.println("<h1>hello "+request.getSession().getAttribute("name")+"</h1>");
        %><br>
    <center>
        <br><h1>checkout users</h1><br>
        <form action="adminpage.jsp" method="post">
                <input type="text" name="customer"/>
                <input type="submit" value="go"/>
        </form></center>
        <%
        if(request.getParameter("customer")!=null)
        {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jugal","jugal","jugal");
            PreparedStatement pst;
        pst=cn.prepareStatement("Select *from jugal.BOOKINGS where UID=?");
        pst.setString(1,request.getParameter("customer"));
        ResultSet rs=pst.executeQuery();
        out.println("<h3>bookings</h3>");
        while(rs.next())
            {
                out.println("<h3>"+rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getInt(4)+"</h3>");
            }
        out.println("<h3>orders</h3>");
        pst=cn.prepareStatement("Select *from jugal.ORDERS where UID=?");
        pst.setString(1,request.getParameter("customer"));
            rs=pst.executeQuery();
            while(rs.next()){
            out.println("<h3>"+rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getInt(4)+"|"+rs.getInt(5)+"</h3>");
            }
        out.println("<button><a href='checkout?customer="+request.getParameter("customer")+"'>Click</a></button>");
        }
                
        %>
    
    <center><br><h1>add admins</h1><br>
            <form action="addadmin" method="post">
                <input type="text" name="useradmin"/>
                <input type="submit" value="add admins"/>
        </form></center>
    
    </body>
</html>
