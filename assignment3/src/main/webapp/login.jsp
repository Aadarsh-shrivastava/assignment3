<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="css/style.css"
	rel="stylesheet">
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
	if(session.getAttribute("message")!=null){%><h1><%session.getAttribute("message"); %></h1><%} %>
	<div class="card m-5 prime_col">
		<div class="sec_col heading p-1"><b>Login</b></div><br>
		<form action="/assignment3/login" method="post">
			<div class=" d-flex justify-content-start">

				Username<input type="email" class="form-control" id="email"
					name="email" placeholder="name@example.com">
			</div>
			<br>
			<div class="mb-3 d-flex justify-content-start">
				Password <input type="password" class="form-control" id="password"
					name="password">
			</div>
			<div class="sec_col">
			<input class="mb-3 float-right" type="submit"  value="Login">
			<a href="Register.jsp">Dont have an account?? register </a>
			</div>
		</form>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>