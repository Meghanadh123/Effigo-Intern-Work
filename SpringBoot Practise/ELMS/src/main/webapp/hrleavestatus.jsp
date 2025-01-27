<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR Table</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
    }

    table {
        margin: 0 auto;
        background-color: antiquewhite;
        border-collapse: collapse; /* Change to collapse for border spacing */
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }


    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #000000; /* Add a border to cells */
    }

    th {
        background-color: red;
        color: white;
    }

    tr:nth-child(even) {
        background-color: antiquewhite;
    }

    a.button {
        background-color: #909090;
        color: antiquewhite;
        border: none;
        border-radius: 5px;
        padding: 5px 15px;
        text-decoration: none;
    }

    a.button:hover {
        background-color: antiquewhite;
    }
</style>
    
</head>
<body>
 <%@ include file="hrnavbar.jsp" %>
 <br>
 <div class = "c1">
 <h3 align="center"><u>View All Leaves</u></h3>
    <table>
        <tr bgcolor="#007BFF" style="color:white">
            <th>ID</th>
            <th>EMPLOYEE ID</th>
            <th>NAME</th>
            <th>LEAVE TYPE</th>
            <th>FROM DATE</th>
            <th>TO DATE</th>
            <th>Status</th>
        </tr>

        <c:forEach items="${leavedata}" var="leave">
            <tr>
                <td><c:out value="${leave.sno}" /></td>
                 <td><c:out value="${leave.empid}" /></td>
                <td><c:out value="${leave.lname}" /></td>
                <td><c:out value="${leave.leavetype}" /></td>
                <td><c:out value="${leave.fromdate}" /></td>
                <td><c:out value="${leave.todate}" /></td>
         <c:if test="${leave.status==true }">
        <td bgcolor="green"> Approved</td>
        </c:if>
        <c:if test="${leave.status==false }">
        <td bgcolor="red"> Rejected</td>
        </c:if>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>