package servlet;

import da.ProgrammeDA;
import domain.Programme;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProgrammeWithHttpSessionAndDA extends HttpServlet {

    private ProgrammeDA progDA;

    // Initialize variables
    @Override
    public void init() throws ServletException {
        progDA = new ProgrammeDA();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain data from the form
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String faculty = request.getParameter("faculty");

        if (code.length() == 0 || name.length() == 0) {
            out.println("Programme code and name are required.");
        } else {
            // Create Programme object
            Programme p = new Programme(code, name, faculty);
            
            // Get a HttpSession or create one if it does not exist
            HttpSession httpSession = request.getSession();
            
            // Store Programme object to the session
            httpSession.setAttribute("programme", p);

            // ask for confirmation
            out.println("You entered the following data");
            out.println("<p>Programme code: " + code);
            out.println("<br>Programme name: " + name);
            out.println("<br>Faculty: " + faculty);

            // Set the action for processing the answers
            out.println("<p><form method=\"post\" action=AddProgrammeWithHttpSessionAndDA>");
            out.println("<p><input type=\"submit\" value=\"Confirm\" >");
            out.println("</form>");

            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain the HttpSession
        HttpSession httpSession = request.getSession();
        
        // Get the Programame object in the HttpSession
        Programme prog = (Programme)(httpSession.getAttribute("programme"));

        try {
            progDA.addRecord(prog);
            out.println("New programme " + prog.getCode() + " " + prog.getName() + " from the faculty "
                    + prog.getFaculty() + " has been added to the database.");
        } catch (Exception ex) {
            out.println("ERROR: " + ex.getMessage());
        } finally {
            out.close();
        }
    }

}