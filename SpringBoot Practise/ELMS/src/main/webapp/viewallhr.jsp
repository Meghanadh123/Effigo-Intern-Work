<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
   <style>
    body {
        font-family: Arial, sans-serif;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: red;
        color: white;
        padding: 15px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    /* Center-align the table heading */
    h3 {
        text-align: center;
    }

    /* Style for the "View" button */
    .view-button {
        background-color: green;
        color: white;
        padding: 8px 12px;
        border: none;
        border-radius: 5px;
        text-align: center;
        cursor: pointer;
        display: block; /* Ensure the button expands to full width */
        text-decoration: none; /* Remove underline from anchor tag */
    }

    .view-button:hover {
        background-color: #333; /* Darken on hover */
    }
</style>
   
</head>
<body>

<%@ include file="adminnavbar.jsp" %>

<br>
<div class="c1">
<h3 style = "text-align: center;"><u>View All HR(s)</u></h3>

<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>LOCATION</th>
        <th>EMAIL ID</th>
        <th>CONTACT NO</th>
        <th>ACTION</th>
    </tr>

    <c:forEach items="${hrdata}" var="hr">
        <tr>
            <td><c:out value="${hr.id}" /></td>
            <td><c:out value="${hr.name}" /></td>
            <td><c:out value="${hr.location}" /></td>
            <td><c:out value="${hr.email}" /></td>
            <td><c:out value="${hr.contact}" /></td>
            <td>
                <a href='<c:url value="viewhr?id=${hr.id}"></c:url>' class="view-button">View</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>