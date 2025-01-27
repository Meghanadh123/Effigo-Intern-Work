<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 table {
  width: 100%;
  border-collapse: collapse;
  margin: 8px 0;
}
table th, table td {
  padding: 8px;
  border: 1px solid #ccc;
  text-align: left;
}

table th {
  background-color: #f2f2f2;
}
 
</style> 
</head> 
<body> 
 
 <%@ include file="adminnavbar.jsp" %>
 
<br> 
  <div class="c1">
<h3 style = "text-align: center;"><u>Delete HR</u></h3> 
 
<table align=center  border=2>  
<tr bgcolor="dark antiquewhite" style="color:white"> 
<td>ID</td> 
<td>NAME</td> 

<td>LOCATION</td> 
<td>EMAIL ID</td> 
<td>CONTACT NO</td> 
<td>ACTION</td>
</tr> 
 
<c:forEach items="${hrdata}"  var="hr"> 
<tr> 
<td><c:out value="${hr.id}" /></td> 
<td><c:out value="${hr.name}" /></td> 
<td><c:out value="${hr.location}" /></td> 
<td><c:out value="${hr.email}" /></td> 
<td><c:out value="${hr.contact}" /></td> 
<td>
<a href='<c:url value="deletehr/${hr.id}"></c:url>'>Delete</a>
</td>
 
</tr> 
</c:forEach> 
 
</table> 
</div>
 
</body> 
</html>