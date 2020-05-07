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

String id= request.getParameter("id");
request.getSession();
request.setAttribute("id", id);
%>


<form action="delete1">
Do you want to Delete : <input type="radio" name="delete" value="yes">Yes  <input type="radio" name="delete" value="no">No<br>
<input type="submit" value="confirm"> 
</form>
</body>
</html>