<%--
  Created by IntelliJ IDEA.
  User: JASON
  Date: 1/5/2023
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
   <div id="wrapper">
       <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
       </div>

       <button>
           <a href="showFormAdd">Add Customer</a>
       </button>
       <!--  add a search box -->
       <form:form action="search" method="GET">
           Search customer: <input type="text" name="theSearchName" />

           <input type="submit" value="Search" class="add-button" />
       </form:form>
       <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th>
                            First Name
                        </th>
                        <th>
                             Last Name
                        </th>
                        <th>
                            Email
                        </th>
                        <th>Action</th>
                    </tr>

                    <%-- loop over and print out customers  --%>
                    <c:forEach var="tempCustomer" items="${customers}">

                        <!-- construct an "update" link with customer id -->
                        <c:url var="updateLink" value="/customer/showFormUpdate">
                                <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>

                        <!-- construct a "delete" link with customer id -->
                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${tempCustomer.id}"/>
                        </c:url>


                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                    onclick="return confirm(`Are you sure you want to delete ${tempCustomer.firstName} ${tempCustomer.lastName}?`)">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
       </div>
   </div>
</body>
</html>
