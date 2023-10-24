/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Loan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TARUC
 */
public class ServletToJsp extends HttpServlet {

  	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getServletContext().setAttribute("name", "Bolton Finance");
		
                String custName = "John Smith";
		HttpSession session = request.getSession();
                session.setAttribute("customer", custName);

                
                Loan loan = new Loan(6.5, 20,300000);
                request.setAttribute("loan",loan);

		//Servlet JSP communication
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("GetData2.jsp");
		reqDispatcher.forward(request,response);
	}
}