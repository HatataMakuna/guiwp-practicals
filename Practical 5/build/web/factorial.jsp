<%-- 
    Document   : factorial
    Created on : Feb 14, 2022, 10:05:31 AM
    Author     : harch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table border ="1">
            <tr>
                <td> Number </td>
                <td> Factorial </td>
            </tr>
            <%!int result = 1;%>
            <% for (int i = 1; i < 10; i++){
            result = result * i; %>
            <%-- to display data using tr --%>
            <tr>
                <%--to display number and factorial--%>
                <td> <%= i%> </td>
                <td> <%= result %> </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
