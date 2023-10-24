<%-- 
    Document   : confirmRegistration
    Created on : Mar 9, 2022, 5:29:02 PM
    Author     : TARUC
--%>

<%@page import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="student" scope="session" class="entity.Student"/>
<jsp:useBean id="registration" scope="session" class="entity.Registration"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Excel Tuition Center</h1>
        <br/>
        <br/>
        <h2>Subject registration details</h2>
        <br/>
        <h3> Student: ${student.name} [${student.ic}]</h3>
        <br/>
        Registration No: <%= registration.getRegId()%>
        
    </body>
</html>
