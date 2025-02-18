+<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
 
<html> 

<head> 
<title>JPA Relational Mapping</title>
<style>

body
{
	background-color: lightblue;
}
.button {
  background-color: black;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

input[type=text],input[type=password],input[type=number],input[type=email],
select,input[type=date],input[type=datetime-local]
{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

label 
{
  padding: 12px 12px 12px 0;
  display: inline-block;
  font-weight: bold;
}
</style>
</head> 

<body>

<h2 align="center">SpringBoot JPA Relational Mapping</h2>

<a href="/">Home</a>&nbsp;&nbsp;
<a href="viewallcourses">View Courses</a>&nbsp;&nbsp;
<a href="viewfaculty">View Faculty</a>&nbsp;&nbsp;
<a href="fcoursemapping">Faculty Course Mapping</a>&nbsp;&nbsp;
<a href="viewfcoursemapping">View Faculty Course Mapping</a>&nbsp;&nbsp;


<br><br><br>

<table align=center  border=2 style="text-align: center">
  
<tr style="font-weight: bold;"> 
<td>ID</td> 
<td>FACULTY ID</td> 
<td>FACULTY NAME</td> 
<td>COURSE CODE</td> 
<td>COURSE TITLE</td> 
<td>SECTION</td> 
<td>Type</td> 
</tr> 
 
<c:forEach items="${fcmdata}" var="fcm"> 

<tr> 

<td><c:out value="${fcm.id}" /></td> 
<td><c:out value="${fcm.faculty.id}" /></td> 
<td><c:out value="${fcm.faculty.name}" /></td>
<td><c:out value="${fcm.course.coursecode}" /></td> 
<td><c:out value="${fcm.course.coursetitle}" /></td> 
<td><c:out value="${fcm.section}" /></td> 
<td><c:out value="${fcm.facultytype}" /></td> 
 
</tr> 

</c:forEach> 
 
</table> 

</body> 
</html>