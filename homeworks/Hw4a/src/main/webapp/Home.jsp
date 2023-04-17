<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String username = (String)session.getAttribute("username");
	if(username==null){
		response.sendRedirect("Login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	Hosgeldin <%=username %><br/><br/>
	<a href="Logout.jsp">Cik</a>
</body>
</html>