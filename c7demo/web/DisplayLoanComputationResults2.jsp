<%-- View component: DisplayLoanComputationResult2.jsp --%>
<jsp:useBean id="loan" scope="request" class="domain.Loan" />

<%-- alternate way
<%@page import="domain.Loan" %>
<% Loan loan =(Loan)request.getAttribute("loan"); %>
--%>

<html>
    <head>
        <title>Loan Computation Results</title>
    </head>
    <body>
        <h1>  ${name}</h1>
        <h2>Name : ${customer}</h2><br><br>
        <h2>Loan Information</h2>
        Loan amount: RM${loan.loanAmount}<br />
        <%--
        Annual Interest Rate: ${loan.annualInterestRate}<br /> --%>

        Annual Interest Rate: ${loan["annualInterestRate"]}<br />
        Duration (in years) : ${loan.numberOfYears}<br />
        
        Monthly payment: RM: <%= String.format("%.2f",loan.getMonthlyPayment()) %><br />
        Total payment: RM: <%= String.format("%.2f",loan.getMonthlyPayment()) %><br /><br />
      
    </body>
</html>
