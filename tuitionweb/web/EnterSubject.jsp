<%-- 
    Document   : EnterSubject
    Created on : Mar 7, 2022, 11:46:06 AM
    Author     : user1
--%>


<%@page import="java.util.*"%>
<%@page import="entity.Subject" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="student" scope="session" class="entity.Student"/>
<% List<Subject> subjectList = (List<Subject>)session.getAttribute("subjectList");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration of Subject</title>
    </head>
    <body>
        <h1>Excel Tuition Center</h1>
        <h2>Registration of Subjects</h2>
        <form action="processRegistration" method="POST">
        <table>
            <tr>
                <td>Student ID: </td>
                <td><input type="text" name="id" value="${student.id}" readonly="readonly"/>
                </td>
            </tr>
              <tr>
                <td>Student Name: </td>
                <td><input type="text" name="name" value="${student.name}" size="50" readonly="readonly"/>
                </td>
            </tr>
              <tr>
                <td>MyKad Number: </td>
                <td><input type="text" name="ic" value="${student.ic}" size="14" readonly="readonly"/>
                </td>
            </tr>
              <tr>
                <td>Contact Number: </td>
                <td><input type="text" name="phone" value="${student.phone}" readonly="readonly"/>
                </td>
            </tr>
            
        </table>
                
                <h2>Select Subjects</h2>
                <table border="1">
                    <thead>
                        <tr>
                    <th>Subject Code</th>
                     <th>Title</th>
                      <th>Fee(RM)</th>
                       <th>Select</th>
                        </tr>
                    </thead>  
                    <tbody>
                        <% int[] subjectArr = new int[subjectList.size()];
                            for(int in=0; in<subjectList.size(); in++){
                                Subject subject = subjectList.get(in);%>
                                <tr>
                                    <td> <%=subject.getSubjectCode()%></td> 
                                    <td> <%=subject.getTitle() %> </td>
                                    <td> <%=subject.getFee() %> </td>
                                    <td> <input type="checkbox" name="<%="subjectArr[" + in + "]"%>"/></td>
                                    
                                </tr>   
                                
                           <% }%>
                          
                        
                    </tbody>
                    
                </table>
        <input type="submit" value="Confirm Registration" name="submit"/>
        <input type="reset" value="Reset" name="reset"/>
   </form>
        </body>
</html>
