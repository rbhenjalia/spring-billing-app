<%-- 
    Document   : index
    Created on : 8 Oct, 2017, 8:53:58 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
       <form method="post" action="login">
            Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text" name="uid" /><br><br>
            Password:<input type="password" name="password"/><br><br>
            <input type="radio" value="admin" name="table"/>Administrator&nbsp;
            <input type="radio" value="user" name="table"/>User&nbsp;<br><br>
            <input type="submit" value="login"/>
        </form>
         <center><h1>Register</h1>
   <form method="post" action="register">
            Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text" name="uid"/><br><br>
            Password<input type="password" name="password"/><br><br>
            <input type="submit" value="register"/>
        </form> </center>>
    </body>
</html>
