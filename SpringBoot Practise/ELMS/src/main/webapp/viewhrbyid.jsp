<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 
 
</style> 
</head> 
<body> 


<%@ include file="adminnavbar.jsp" %>
<div class="c1">
ID : ${hr.id}<br>
Name : ${hr.name}<br>
Gender : ${hr.gender}<br>
DateofBirth : ${hr.dateofbirth}<br>
Salary : ${hr.salary}<br>
Email : ${hr.email}<br>
Location : ${hr.location}<br>
Contact No : ${hr.contact}<br>
</div>
</body>
</html>