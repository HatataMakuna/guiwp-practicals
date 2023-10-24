<%-- 
    Document   : Test
    Created on : Dec 4, 2015, 1:26:17 PM
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
        <%@page import="domain.Loan" %>
       <h1>  <%= application.getAttribute("name") %></h1><br>
       
       <h2>Welcome , <%= session.getAttribute("customer") %> </h2><br>
       
       <% Loan loan= (Loan)request.getAttribute("loan"); %>
       <h4>Loan Amount : RM <%= String.format("%.2f",loan.getLoanAmount()) %><br>
           Number of years : <%= loan.getNumberOfYears() %> <br>
           Annual Interest rate : <%= loan.getAnnualInterestRate() %> <br>
           Monthly payment : RM <%= String.format("%.2f",loan.getMonthlyPayment() %><br>
           Total payment : RM <%= String.format("%.2f",loan.getTotalPayment() %><br>
       </h4>
               
    </body>
</html>
