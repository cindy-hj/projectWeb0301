<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="projectWeb0301.Student"%>
<%@page import="projectWeb0301.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	request.setCharacterEncoding("UTF-8");
	String username = request.getParameter("username");
	String univ = request.getParameter("univ");
	String birth = request.getParameter("birth");
	String email = request.getParameter("email");
	
	Student student = new Student();
	student.setUsername(username);
	student.setUniv(univ);
	student.setEmail(email);
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	java.util.Date date = formatter.parse(birth);
	student.setBirth(new Date(date.getTime()));
	
	StudentDAO sDAO = new StudentDAO();
	sDAO.insert(student);
%>

</body>
</html>