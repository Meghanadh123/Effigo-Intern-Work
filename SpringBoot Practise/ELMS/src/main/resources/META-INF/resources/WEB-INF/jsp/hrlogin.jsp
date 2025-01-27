<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<html>
<head>

<link type="text/css" rel="stylesheet" href="css/style.css">

<style>

</style>
</head>
<body>

<%@ include file="navbar.jsp" %>

<br>
<span class="blink">
<h3 align=center style="color:red">  ${message} </h3>
</span>
<div class="c1">

<h3 align=center><u>HR Login</u></h3>

<br>

<form method="post" action="checkhrlogin">

<table align=center>


<tr>
<td><label>Email</label></td>
<td><input type="text" name="email" required/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Password</label></td>
<td><input type="password" name="password" required/></td>
</tr>



<tr><td></td></tr>
<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Login" class="button"></td>
</tr>

</table>

</form>
</div>
</body>
</html>