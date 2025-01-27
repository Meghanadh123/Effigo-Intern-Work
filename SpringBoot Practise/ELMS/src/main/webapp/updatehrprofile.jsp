<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 

<html>
<head>

<link type="text/css" rel="stylesheet" href="css/style.css">

<style>

</style>
</head>
<body>

<%@ include file="hrnavbar.jsp" %>


<h3 align=right>Hi, ${hname}</h3>
<div class="c1">
<h3 align=center><u>Update HR Profile</u></h3>

<form method="post" action="updatehr">

<table align=center>

<tr>
<td><label>Name</label></td>
<td>
<input type="text" name="name" required="required" value="${hr.name}"/>
</td>
</tr>

<tr><td></td></tr>



<tr>
<td><label>Date of Birth</label></td>
<td>
<input type="date" name="dob" required="required"  value="${hr.dateofbirth}"   />
</td>
</tr>

<tr><td></td></tr>




<tr>
<td><label>Salary</label></td>
<td><input type="number" name="salary" step="0.01" required  value="${hr.salary}"    /></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Email ID</label></td>
<td><input type="email" name="email" required  value="${hr.email}" readonly/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Password</label></td>
<td><input type="password" name="pwd" required  value="${hr.password}" /></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Location</label></td>
<td><input type="text" name="location" required value="${hr.location}"/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Contact No</label></td>
<td><input type="text" name="contact" required value="${hr.contact}" /></td>
</tr>

<tr><td></td></tr>
<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Update" class="button"></td>
</tr>

</table>

</form>
</div>
</body>
</html>