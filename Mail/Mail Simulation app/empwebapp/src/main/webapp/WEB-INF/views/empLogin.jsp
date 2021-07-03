<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String errMsg = (String) request.getAttribute("errMsg");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errMsg%>
	</h1>
	<%
		}
	%>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green;"><%=msg%>
	</h1>
	<%
		}
	%>
	<fieldset>
		<legend>Login</legend>
		<form action="./loginm" method="post">
			<table>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required="required"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Login"></td>
					<td><a href="./addEmp">Register</a></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>