<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Orders List</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	
	<style>
		table {
			border-collapse: collapse;
			margin: auto;
		}
		td, th {
			padding: 10px;
			border: 1px solid black;
			text-align: center;
			font-family: Arial, sans-serif;
		}
		th {
			background-color: #a8d6ff;
		}
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
	</style>
</head>
<body>
	<center><h2 class="my-3">Orders List</h2></center>
	
	<br><br>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${orders ne null and not empty orders}">
			<table class="table">
				<thead class="table-light">
					<tr>
						<th>ID</th>
						<th>Seed</th>
						<th>Farmer</th>
						<th>Supplier</th>
						<th>Quantity</th>
						<th>Price(in Rupees)</th>
						<th>Order Date</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td>${order.id}</td>
							<td>${order.seed.name}</td>
							<td>${order.farmer.name}</td>
							<td>${order.supplier.name}</td>
							<td>${order.quantity}</td>
							<td>${order.price}</td>
							<td>${order.orderDate}</td>
							<td>
								<a href="<%=request.getContextPath()%>/order/${order.id}">Details</a>
								&nbsp;
								<a href="<%=request.getContextPath()%>/update/order/${order.id}">Update</a>
								&nbsp;
								<a href="<%=request.getContextPath()%>/delete/order/${order.id}" onclick="return confirm('Do you really want to delete this order?')">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
		</c:when>
		<c:otherwise>
			<p>No orders found in the database.</p>
		</c:otherwise>
	</c:choose>
	<center>
	<button type="button" class="btn btn-dark my-3"><a href="<%=request.getContextPath()%>/addOrder" class="text-white">Add Order</a></button>
	</center>
</body>
</html>
