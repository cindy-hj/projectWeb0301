<%@page import="projectWeb0301.Student"%>
<%@page import="projectWeb0301.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보</title>
</head>
<body>
<table border="1">
<tr>
	<th>id</th>
	<th>이름</th>
	<th>대학</th>
	<th>생일</th>
	<th>이메일</th>
</tr>
<%
	StudentDAO students = new StudentDAO();
	for(Student s:students.getAll()) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getUsername()%></td>
			<td><%=s.getUniv()%></td>
			<td><%=s.getBirth()%></td>
			<td><%=s.getEmail()%></td>
		</tr>
		<%
	}
%>
</table>
</body>
</html>