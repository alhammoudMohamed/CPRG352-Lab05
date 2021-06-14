<%-- 
    Document   : login
    Created on : Jun 9, 2021, 1:27:13 PM
    Author     : 844568
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login page</h1>

        <form method="post" action="login">

            <label>Username:</label>
            <input type="text" placeholder="john" name="username"  required></input>
            <br>
            <br>
            <label>Password:</label>
            <input type="password" name="password"  required >
            <br>
            <br>
            <input type="submit" value="login">

         
            <p> ${errorMessage}</p>
            
               <p>${logoutMessage}</p>
        </form>


    </body>
</html>
