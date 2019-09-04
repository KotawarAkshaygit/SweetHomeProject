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

String name=(String) session.getAttribute("customerName");
int fkgs=(Integer) session.getAttribute("finalskg");
int result=(Integer) session.getAttribute("result");
out.println("Thanks for Shopping "+name +"<br>");
out.println("Your Total Amount for "+fkgs+"Kgs is "+result);		
		
   
%>
<a href="GoToHomePage"><button>Go to home Page</button></a>
</body>
</html>