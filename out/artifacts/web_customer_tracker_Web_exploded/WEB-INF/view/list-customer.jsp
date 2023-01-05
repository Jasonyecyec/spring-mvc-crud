<%--
  Created by IntelliJ IDEA.
  User: JASON
  Date: 1/5/2023
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Customer</title>
</head>
<body>
   <div id="wrapper">
       <div class="header">
            <h2>CRM - Customer Relationship Manager</h2>
       </div>

       <div class="container">
            <div class="content">
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>

                    <%-- loop over and print out customers  --%>
                    <c:forEach var="tempCustomer" items="${customers}">
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
       </div>
   </div>
</body>
</html>
