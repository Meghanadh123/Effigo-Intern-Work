<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>

<link type="text/css" rel="stylesheet" href="css/style.css">

<style>

</style>
</head>
<body>

<%@ include file="adminnavbar.jsp" %>

<br>
<div class="c1">
<span class="blink">
<h3 align=center style="color:red">${message}</h3>
</span>

<span class ="blink"></span>
<h3 style = "text-align: center;"><u>Add HR</u></h3>

<br>

<form:form modelAttribute="hr" method="post" action="inserthr">

<table align=center>

<tr>
<td><label>Name</label></td>
<td>
<form:input path="name" required="required"></form:input>
</td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Gender</label></td>
<td>
<form:radiobutton path="gender" value="Male" required="required"/>Male
<form:radiobutton path="gender" value="Female" required="required"/>Female
</td>
</tr>


<tr><td></td></tr>


<tr>
<td><label>Date Of Birth</label></td>
<td><form:input type="date" path="dateofbirth" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Salary</label></td>
<td><form:input path="salary" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Email ID</label></td>
<td><form:input path="email" required="required"/></td>
</tr>

<tr><td></td></tr>


<tr>
<td><label>Password</label></td>
<td><form:password path="password" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Location</label></td>
<td><form:input path="location" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Contact</label></td>
<td><form:input path="contact" required="required"/></td>
</tr>

<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Add" class="button"></td>
</tr>

</table>
</div>
</form:form>



</body>
</html>