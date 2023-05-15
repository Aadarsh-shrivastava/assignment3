<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		int id=Integer.parseInt(request.getParameter("id"));
		%>
	<form action="Edit" method="post"
		enctype="multipart/form-data" class="col">
		<input type="text" class="row m-3" placeholder="id" name="id" value="<%=id %>"> 
		<input type="text" class="row m-3" placeholder="title" name="title"> 
		<input type="text" class="row m-3" placeholder="quantity" name="quantity"> 
		<input type="text" class="row m-3" placeholder="size" name="size"> 
		<input type="file" class="row m-3" placeholder="image" name="image"> 
		<input type="submit" class="row m-3" onclick="if (!(confirm('Are you sure you want to Edit this product?'))) return false" value="Update">
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>