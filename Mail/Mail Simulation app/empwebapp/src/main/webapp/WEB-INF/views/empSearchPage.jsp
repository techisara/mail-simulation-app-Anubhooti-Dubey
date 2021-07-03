<%@page import="com.te.empwebapp.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String errMsg = (String) request.getAttribute("errMsg");
EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("empData");
%>

<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>

	<fieldset>
		<legend>Search Employee</legend>
		<form action="./search">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="search"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
		if (employeeInfoBean != null) {
	%>
	<h3>
		Name :
		<%=employeeInfoBean.getName()%></h3>
	<h3>
		ID :
		<%=employeeInfoBean.getId()%></h3>
	<h3>
		Date of Birth :
		<%=employeeInfoBean.getDob()%></h3>

	<%
		}
	%>
	
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2>
		<%=errMsg%></h2>
	<%
		}
	%>

</body>
</html>