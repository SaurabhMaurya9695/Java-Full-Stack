<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<!-- jstl uri -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<h1>My name is ${name }</h1>
	<hr>
	<h1>Mark is ${marks }</h1>

	<c:forEach var="item" items="${marks }">
		<h1>${item }</h1>

	</c:forEach>


</body>
</html>