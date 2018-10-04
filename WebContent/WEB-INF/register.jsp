<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Leave Management System</h1>
<h3>Please login to check your a/c details</h3>
<h4>${result }</h4>
<form action="empSave.html" method="post">
<table>
<tr>
	<td>Name:</td>
	<td><input type="text" name="name"/></td>
</tr>
<tr>
	<td>UserName:</td>
	<td><input type="text" name="uname"/></td>
</tr>
<tr>
	<td>Password:</td>
	<td><input type="password" name="password"/></td>
</tr>
<tr>
	<td>Salary:</td>
	<td><input type="text" name="salary"/></td>
</tr>
<tr>
	<td>Gender:</td>
	<td><input type="radio" value="M"/>Male
	<input type="radio" value="F"/>Female</td>
</tr>

<tr>
<td colspan="2" align="right">
<input type="submit" value="Save" />
</td>
</tr>
<tr>
<td colspan="2" align="right">
<a href="home.html">Go Back!</a>
</td>
</tr>



</table>
</form>

</body>
</html>