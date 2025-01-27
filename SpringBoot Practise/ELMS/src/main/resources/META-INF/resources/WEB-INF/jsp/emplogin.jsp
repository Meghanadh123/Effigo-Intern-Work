<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<script src="https://js.hcaptcha.com/1/api.js" async defer></script>
<link type="text/css" rel="stylesheet" href="css/style.css">

<style>


</style>
</head>
<body>

<%@ include file="navbar.jsp" %>

<br>


<div class="c1">
<span class="blink">
<h3 align=center style="color:red">${message}</h3>
</span>

<span class ="blink"></span>
<h3 align=center><u>Employee Login</u></h3>

<br>


<form method="post" action="checkemplogin">

<table align=center>


<tr>
<td><label>Email ID</label></td>
<td><input type="email" name="email" required/></td>
</tr>

<tr><td></td></tr>

<tr>
<td><label>Password</label></td>
<td><input type="password" name="pwd" required/></td>
</tr>


<tr><td></td></tr>
<tr><td></td></tr>

<tr align=center>
<td colspan=2><input type="submit" value="Login" class="button"></td>
</tr>

</table>

</form>

<br>

<div
  class="h-captcha"
  data-sitekey="cb2f68b1-2bed-4f13-b3ea-385d203384a3"
  data-theme="dark"
  data-error-callback="onError"
></div>
<h3 align="center">
New Registration ? <a href="empreg">Click Here</a>
</h3>
</div>


</body>
</html>