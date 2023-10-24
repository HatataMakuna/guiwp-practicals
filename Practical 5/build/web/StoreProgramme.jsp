<%@page import="domain.Programme" %>

<jsp:useBean id="programmeId"
    class="domain.Programme" scope="session">
</jsp:useBean>
<jsp:useBean id="programmeDAId"
    class="da.ProgrammeDA" scope="application">
</jsp:useBean>
<html>
    <body>
    <%
    programmeDAId.addRecord(programmeId);
    out.println(programmeId.getCode() + " " + programmeId.getName() +
    " has been stored in the database");
    out.close();
    %>
    </body>
</html>