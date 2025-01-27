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
        border-collapse: collapse; /* Change to collapse for border spacing */
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #000000; /* Add border to th and td */
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: red;
        color: white;
    }

    tr:nth-child(even) {
        background-color: antiquewhite;
    }
</style>

</head>
<body>
 <%@ include file="adminnavbar.jsp" %>
 <br>
 <div class = "c1">
 <h3 style = "text-align: center;"><u>Rejected Leaves</u></h3>
    <table>
        <tr bgcolor="#007BFF" style="color:white">
           <th>ID</th>
            <th>EMPLOYEE ID</th>
            <th>NAME</th>
            <th>LEAVE TYPE</th>
            <th>FROM DATE</th>
            <th>TO DATE</th>
            <th>ACTION</th>
        </tr>

        <c:forEach items="${leavedata}" var="leave">
            <tr>
                 <td><c:out value="${leave.sno}" /></td>
                <td><c:out value="${leave.lname}" /></td>
                <td><c:out value="${leave.empid}" /></td>
                <td><c:out value="${leave.leavetype}" /></td>
                <td><c:out value="${leave.fromdate}" /></td>
                <td><c:out value="${leave.todate}" /></td>
                <td>Rejected</td>
 
                
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>
