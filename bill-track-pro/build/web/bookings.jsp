<%-- 
    Document   : bookings
    Created on : 8 Oct, 2017, 7:25:49 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>bookings</title>
    </head>
    <body>
        <button><a href="LogoutServlet">logout</a></button><br><br>
       <center> <h1>Book your needs</h1>
        <form action="bookings" method="post">
            tables&nbsp;<input type="number"  name="table"/><br><br>
            rooms&nbsp;<input type="number" name="room"/><br><br>
            <input type="submit" value="book"/>
        </form></center>
    </body>
</html>
