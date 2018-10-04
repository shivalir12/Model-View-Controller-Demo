<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Employee Leave Management System</h1>
<h3>Please login to check your a/c details</h3>
<h4 style ="color:red">${result}</h4>
<form action="validate.html" method="post">
<table>
<tr>
<td>Username:</td>
<td><input type="text" name="uname"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="upass" /></td>
</tr>
<tr>
<td colspan="2" align="right">
<input type="submit" value="Login" />
</td>
</tr>
<tr>
<td colspan="2" align="right">
<a href="register.html">New Employee? Sign-Up here</a>
</td>
</tr>
</table>
</form>
</body>
</html>