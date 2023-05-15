<%@page import="java.sql.Blob"%>
<%@page import="com.nagarro.assignment3.Entities.*"%>
<%@page import="com.nagarro.assignment3.dao.*"%>
<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*"%>

<%@page import="java.util.List"%>
<html>
<head>
<script src=""></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div>
	<%@include file="logout.jsp"%> 
	</div>
	<%
		if (session.getAttribute("current-user") == null)
			response.sendRedirect("login.jsp");
	%>
	
	<h2><center>Product Management System</center></h2>
	<h5>Please enter prouct details to add to stock</h5>

	<form action="productServelet" method="Post"
		enctype="multipart/form-data">
		
		<input type="text" placeholder="title" name="title" class="row m-2"> <input
			type="text" placeholder="quantity" name="quantity" class="row m-2"> <input
			type="text" placeholder="size" name="size" class="row m-2"> 
			<div class="d-flex justify-content-start">
			<input type="file" placeholder="image" name="image" class=" m-2 "> <input
			type="submit" value="Upload" class="">
			</div>
	</form>
	<div id="container">

		<div id="content">
			<table class="table table-bordered m-2 p-2">
				<tr>
					<th>S No.</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Image</th>
					<th>Action</th>
				</tr>

				<%
					ProductDao dao = new ProductDao(FactoryProvider.Productfactory());
					List<Product> list = null;

					list = dao.listAllProducts();

					Blob img = null;
					for (Product product : list) {
				%>

				<tr>
					<td><%=product.getId()%></td>
					<td><%=product.getTitle()%></td>
					<td><%=product.getQuantiity()%></td>
					<td><%=product.getSize()%></td>
					<td><img alt="..."
						style="max-height: 200px; max-width: 100px; width: auto;"
						src="images/<%=product.getImage()%>" class="card-img-top m-2"></td>
					<td><a href="EditProduct.jsp?id=<%=product.getId()%>">Edit</a> <a
						href="Delete?id=<%=product.getId()%>"
						onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete </a></td>
				</tr>

				<%
					}
				%>

			</table>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>



</body>
</html>
