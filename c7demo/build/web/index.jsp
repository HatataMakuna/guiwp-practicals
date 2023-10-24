<%-- 
    Document   : index
    Created on : Nov 20, 2015, 6:40:39 PM
    Author     : TARUC
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
        <% 
            getServletContext().setAttribute("name", "Tunku Abdul Rahman University College");
            out.print(getServletContext().getAttribute("name"));
        %>
        <a href="ComputeLoan.html">Loan Calculator</a>
    </body>
</html>
