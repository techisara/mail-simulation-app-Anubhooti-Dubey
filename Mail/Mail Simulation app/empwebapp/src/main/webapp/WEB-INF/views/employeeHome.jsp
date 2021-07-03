<%@page import="com.te.empwebapp.beans.Mail"%>
<%@page import="com.te.empwebapp.beans.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String name = (String) request.getAttribute("name");
List<Mail> mails = (List) request.getAttribute("infos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<a href="./logout">logout</a>
	<fieldset>
		<h1 style="color: maroon; text-decoration: underline;">
			Welcome
			<%=name%></h1>
	</fieldset>

	<%
		if (mails != null) {
	%>
	<fieldset>
		<legend>All Records</legend>
		<table  border="1" style="width:100%">
			<tr>
				<th>Subject</th>
				<th>Message</th>
				<th>Status</th>
			</tr>
			<%
				for (Mail mail: mails) {
			%>
			<tr>
				<td><%=mail.getSubject()%></td>
				<td><%=mail.getMesssage()%></td>
				<td><%=mail.getStatus()%></td>
			</tr>
			<%
				}
			%>
		</table>

	</fieldset>
	<%
		}
	%>
</body>
</html>