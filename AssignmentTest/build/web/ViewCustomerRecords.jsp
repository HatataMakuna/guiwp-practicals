<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<jsp:include page="../ViewCustomerRecords"/>
<%String user = (String) session.getAttribute("user");%>
<%
    List<Customer> customerList = (List) session.getAttribute("customerList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <title>View Customer Records</title>
        <style>
            .sidebar {
                height: 100%;
                width: 20%;
                position: fixed;
                top: 0;
                left: 0;
                background-color: #143649; 
            }
            .sidebar a{
                color: white;
            }
            li a:hover{
                color: black;
                background-color: white;
            }
            .main{
                margin-left: 20%;
                padding-bottom: 1%;
                padding-left: 2%;
                padding-right: 1%;
                padding-top: 2%;
                background-color: #EDEDEE;
            }
            table{
                width: 80%;
                padding-top: 2%;
                padding-left: 2%;
            }
            tr:nth-child(odd){
                background-color: #CCCCCC;
            }
            th,td{
                padding-top: 1%;
                padding-bottom: 1%;
                padding-left: 1%;
            }
        </style>
    </head>
    <body style="background-color: #EDEDEE">
        <div class="sidebar w3-sidebar" >
            <img src="../picture/harvenLogo.jfif" alt="HARVEN" width="100%" height="200px">
            
            <ul class="nav nav-pills flex-column" >
                <li class="nav-item">
                    <a href="ViewOrderStatus.jsp" class="nav-link">
                        <svg class="bi me-1" width="16" height="16"><use xlink:href="#home"/></svg>
                        Order
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ViewSalesRecords.jsp" class="nav-link">
                        <svg class="bi me-1" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
                        Sale
                    </a>
                </li>
                <li class="nav-item">
                    <a href="AllProduct_Backend.jsp" class="nav-link">
                        <svg class="bi me-1" width="16" height="16"><use xlink:href="#table"/></svg>
                        Product
                    </a>
                </li>
                <li class="nav-item">
                    <a href="../AdminShowRatingComment" class="nav-link">
                        <svg class="bi me-1" width="16" height="16"><use xlink:href="#grid"/></svg>
                        Rating & Comment
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ViewCustomerRecords.jsp" class="nav-link">
                        <svg class="bi me-1" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                        Customer
                    </a>
                </li>
                <li class="nav-item">
                    <a href="../GetStaffDetails" class="nav-link">
                        <svg class="bi me-1" width="16" height="16"><use xlink:href="#people-circle"/></svg>
                        Staff
                    </a>
                </li>
                <li class="nav-item dropdown" style="padding-left: 20px;">
                    <a class="nav-link  dropdown-toggle" data-toggle="dropdown">  Report  
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" style="padding-left: 20px;">
                        <li><a class="dropdown-item" href="SalesReport.jsp"> Sales Report </a></li>
                        <li><a class="dropdown-item" href="ProductReport.jsp"> Product Report </a></li>
                        <li><a class="dropdown-item" href="customerReport.jsp"> Customer Report </a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div>
            <nav class="TopNavigation" style="margin-left:200px">
                <div class="searchfield">
                    <table>
                        <tr>
                            <td>
                                <form action="../SearchBy_customerlist" method="POST">
                                    <select id="fieldselected" name="fieldselected">
                                        <option value="username">Username</option>
                                        <option value="password">Password</option>
                                        <option value="name">Name</option>
                                        <option value="gender">Gender</option>
                                        <option value="ic">IC</option>
                                        <option value="gmail">Gmail</option>
                                        <option value="address">Address</option>
                                        <option value="phone">Phone</option>
                                    </select>
                                    <input type="text" id="details" name="details">   
                                    <input id="submitS" name="submit" type="submit" value="Search">
                                </form>
                            </td>
                            <td><input id="submitS" name="submit" type="submit" value="Reload" onclick= "remain()"></td>
                            <td><p style="padding-left: 600px;padding-top: 15px;"><%=user%></p></td>
                            <td><img src="../picture/people-outline.svg" alt="userIcon.png" style="margin-left: 20px; width: 30px ; height: 30px" ></td>
                        </tr>
                    </table>
                </div>
            </nav>
        </div>
        <div class="main">
            <h1>Customer Records</h1>
            <div style="margin:2%;">
                <p><a href="index.html">Back to home page</a></p>
                <div style="margin:2%;">
                    <%if (customerList.size() == 0) {%>
                        <div style="text-align:center;">**No customer details in Database !!</div>
                    <% } else {%>
                        <table class="info table-responsive" cellspacing="1" cellpudding="1">
                            <tr style = "background-color: #BCBCBC;">
                                <th style="width:10%">Username</th>
                                <th style="width:10%">Name</th>
                                <th style="width:15%">Gender</th>
                                <th style="width:10%">IC</th>
                                <th style="width:15%">Phone</th>
                                <th style="width:20%">Gmail</th>
                                <th style="width:20%">Address</th>
                            </tr>
                        <% for (Customer cus: customerList){ %>
                            <tr>
                                <td><%= cus.getUsername() %></td>
                                <td><%= cus.getName() %></td>
                                <td><%= cus.getGender() %></td>
                                <td><%= cus.getIc() %></td>
                                <td><%= cus.getPhone() %></td>
                                <td><%= cus.getGmail() %></td>
                                <td><%= cus.getAddress() %></td>
                            </tr>
                        <% } %>
                    </table>
                </div>
            </div>
        </div>
        <%  }%>
    </body>
    <script>
        function remain() {
            location.href = "ViewCustomerRecords.jsp";
        }
    </script>
</html>