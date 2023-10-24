<%@page import="domain.Programme" %>
<jsp:useBean id="programmeId"
class="domain.Programme" scope="session"></jsp:useBean>
<jsp:setProperty name="programmeId" property="*" />
<html>
<body>
<h1>Add Programme Using JSP</h1>
<%
if (programmeId.getCode() == null || programmeId.getName() == null
|| programmeId.getFaculty() == null) {
out.println("Programme code, name and faculty are required");
return;
}
%>
<p>You entered the following data</p>
<p>Programme code: <%= programmeId.getCode() %></p>
<p>Programme name: <%= programmeId.getName() %></p>
<p>Faculty: <%= programmeId.getFaculty() %></p>
<!-- Set the action for processing the answers -->
<form method="post" action="StoreProgramme.jsp">
<input type="submit" value="Confirm">
</form>
</body>
</html>