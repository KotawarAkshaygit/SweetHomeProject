<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
int result=(Integer)request.getAttribute("resultset");
String pdate=(String) request.getAttribute("pdate1");
out.println("Sum of total on "+pdate+" is Rs"+result);
session.invalidate();
%>
<a href="home.jsp"><button>Go Back To Home</button></a>
</body>
</html>