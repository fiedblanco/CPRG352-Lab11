<%-- 
    Document   : forgot
    Created on : Jul 30, 2021, 2:05:20 AM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Page</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <form action="forgot" method="post">
            Email Address: <input type="text" name="email" value=""><br>
          <input type="submit" value="Submit">
            <br>
            <a href="login">Back</a>
        </form>
        
        <p>${message}</p>
    </body>
</html>
