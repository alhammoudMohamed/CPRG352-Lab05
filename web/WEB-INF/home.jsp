<%-- 
    Document   : home
    Created on : Jun 9, 2021, 1:26:33 PM
    Author     : 844568
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <form method="get" action="login" >


            <h1>Home</h1>
            <h2> ${user.username} is logged in</h2>

            <a href="login?logout">Logout</a>


        </form>



    </body>
</html>
