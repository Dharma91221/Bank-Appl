<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#phnpe{
float:right;
margin-bottom:20px;
padding:10px;
}
.space{
display:inline-block;
padding: 10px;
}
div{
margin-top:20px;
align-content:center;
margin-left:45%;
display:inline-block;
}
a{
text-decoration: none;
}

</style>
</head>
<body bgcolor="yellow">
<a href="Main.jsp" id="phnpe"><img src="images/pelogo.png" alt="blank" height="60" width="60" /></a>
<div>
<center>
<h1>Operations</h1>
<a href="create1.jsp" class="space"><button>CREATE</button></a><br>
<a href="display.jsp" class="space"><button>DISPLAY</button></a><br>
<a href="update.jsp" class="space"><button>UPDATE</button></a><br>
<a href="delete.jsp" class="space"><button>DELETE</button></a><br>
</center>
</div>
</body>
</html>