/* Controller component: ComputeLoan.java *.
 * 
 */
import domain.Loan;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ComputeLoan"})
public class ComputeLoan extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      
    double amount = Double.parseDouble(request.getParameter("loanAmount"));
    double rate = Double.parseDouble(request.getParameter("annualInterestRate"));
    int duration = Integer.parseInt(request.getParameter("numberOfYears"));
    Loan loan = new Loan(rate, duration, amount);
    request.setAttribute("loan", loan);
  
    RequestDispatcher rd = request.getRequestDispatcher("DisplayLoanComputationResults2.jsp");
    rd.forward(request, response);
  }
}
