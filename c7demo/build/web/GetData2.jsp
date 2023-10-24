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
       <h1>  ${name} </h1><br>
       
       <h2>Welcome , ${customer}  </h2><br>
       
       <h4>Loan Amount : RM ${loan.loanAmount} <br>
           Number of years ${loan.numberOfYears} </h4>
           Annual Interest rate : ${loan.getAnnualInterestRate()} <br>
           Monthly payment : RM ${loan.getMonthlyPayment() }<br>
           Total payment : RM ${loan.getTotalPayment() }<br>    
    </body>
</html>
