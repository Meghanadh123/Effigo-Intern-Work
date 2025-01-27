<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
        }

       table {
            margin: 0 auto;
            background-color: #fff;
            border-collapse: separate;
            border-spacing: 0;
            border-radius: 10px; /* Add rounded corners */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 0px solid #000000;
            
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #909090;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a.button {
            background-color:#909090;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 5px 15px;
            text-decoration: none;
        }

        a.button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
 <%@ include file="adminnavbar.jsp" %>
 <br>
 <h3 align="center"><u>Delete Employee</u></h3> 
    <table>
        <tr bgcolor="#007BFF" style="color:white">
            <th>ID</th>
            <th>NAME</th>
            <th>DEPARTMENT</th>
            <th>LOCATION</th>
            <th>EMAIL ID</th>
            <th>CONTACT NO</th>
            <th>ACTION</th>
        </tr>

        <c:forEach items="${empdata}" var="emp">
            <tr>
                <td><c:out value="${emp.id}" /></td>
                <td><c:out value="${emp.name}" /></td>
                <td><c:out value="${emp.department}" /></td>
                <td><c:out value="${emp.location}" /></td>
                <td><c:out value="${emp.email}" /></td>
                <td><c:out value="${emp.contact}" /></td>
                <td>
                    
                    <a href='<c:url value="delete/${emp.id}"></c:url>' class="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
