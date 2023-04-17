<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String username = null;
	String password = null;
	
	if(request.getParameter("login")!=null){
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		if(username.equals("godoro") && password.equals("java")){
			session.setAttribute("username", username);
			response.sendRedirect("Home.jsp");
		}
		else{
			%>
			<script type="text/javascript">
				alert("Kullanici adi veya sifre hatali.");
			</script>
	<%
		}
	}
	
	
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="Login.jsp">
		Username : <input type="text" name="username"/><br>
		Password : <input type="password" name="password"/><br>
		<input type="submit" value="Login" name="login"/>
	</form>
</body>
</html>