<%-- 
    Document   : GetCountryDetails
    Created on : Feb 16, 2022, 5:24:07 PM
    Author     : harch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.Loan" %>
<jsp:useBean id="loan"
class="domain.Loan" scope="session"></jsp:useBean>
<jsp:setProperty name="programmeId" property="*" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <p>You entered the following data</p>
        
        <p>Loan Amount         : RM<%= loan.getAmount() %></p>
        <p>Annual interest rate: <%= loan.getRate() %></p>
        <p>Number of years     : <%= loan.getYr() %></p>
        <!-- Set the action for processing the answers -->
        <form method="post" action="StoreProgramme.jsp">
            <input type="submit" value="Confirm">
        </form>
    </body>
</html>
