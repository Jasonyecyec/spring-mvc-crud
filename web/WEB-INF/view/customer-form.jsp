<%--
  Created by IntelliJ IDEA.
  User: JASON
  Date: 1/6/2023
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

 <div id="wrapper">
     <div id="header">
         <h2>CRM - Customer Relationship Manager</h2>
     </div>

    <div id="container">
        <h2>Save Customer</h2>

        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <!--need to associate this data with customer id -->
            <form:hidden path="id" />

            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td> <form:input path="firstName"/> </td>
                    </tr>

                    <tr>
                        <td><label>Last name:</label></td>
                        <td> <form:input path="lastName"/> </td>
                    </tr>

                    <tr>
                        <td><label>Email:</label></td>
                        <td> <form:input path="email"/> </td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <div>
            <button>
                <a href="list">Back to List</a>
            </button>
        </div>
    </div>
 </div>
</body>
</html>
