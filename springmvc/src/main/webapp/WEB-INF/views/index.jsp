
<!-- step 4 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page from view</title>
</head>
<body>
	<h1>this is home page</h1>
	<h1>called by home controller</h1>
	<h1>url /home</h1>

	<%
	
	// getting the data from the home(Model model) controller
	String name = (String) request.getAttribute("name"); // type cast in String 
	
	//getting list 
	//List<String> friends = (List<String>) request.getAttribute("f");
	// after getting type casting is important;
	
	%>
	<h1>
		Hello My Name is :
		<%=name%></h1>


	<%
	//for (String s : friends) {
		//out.println(s);
	//}
	%>


</body>
</html>