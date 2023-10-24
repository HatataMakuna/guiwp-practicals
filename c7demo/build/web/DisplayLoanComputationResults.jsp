<%-- View component: DisplayLoanComputationResult.jsp --%>

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
        
        Monthly payment: RM: ${loan.getMonthlyPayment()}<br />
        Total payment: RM: ${loan.getMonthlyPayment()}<br /><br />
      
    </body>
</html>
