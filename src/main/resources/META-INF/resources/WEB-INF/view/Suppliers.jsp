<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
/* Reset default styles */
body, h1, table, th, td,button {
  margin: 0;
  padding: 0;
  border: none;
  background: none;
  font-family: inherit;
  font-size: inherit;
  color: inherit;
  text-decoration: none;
}

/* Center align h1 */
h1 {
  text-align: center;
  font-size : 34px;
}

/* Reset default styles for table */
table {
  margin: 0;
  padding: 0;
  border-collapse: collapse;
  width: 100%;
}

/* Set font styles for table */
table th,
table td {
  font-family: Arial, sans-serif;
  font-size: 14px;
  font-weight: normal;
  color: #333;
}

/* Style table headers */
table th {
  padding: 10px;
  background-color: #f2f2f2;
  text-align: left;
  border: none;
}

/* Style table cells */
table td {
  padding: 10px;
  border: none;
  border-bottom: 1px solid #ddd;
}

/* Add hover effect on table rows */
table tr:hover {
  background-color: #f9f9f9;
}

/* Style table with border */
table.table-bordered {
  border: 1px solid #ddd;
}

/* Style table headers in bordered table */
table.table-bordered th {
  border: 1px solid #ddd;
}

/* Style table cells in bordered table */
table.table-bordered td {
  border: 1px solid #ddd;
}

/* Style buttons */
a button, button a {
  display: block;
  width: 200px;
  margin: 0 auto;
  padding: 10px;
  text-align: center;
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
}

/* Change button color on hover */
a button:hover, button a:hover {
  background-color: #0056b3;
}

</style>
</head>
<body>
	<h1>Suppliers List</h1>
	
	<br><br>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${Suppliers ne null and not empty Suppliers}">
			<table class="table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>address</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Supplier" items="${Suppliers}">
						<tr>
							<td>${Supplier.id}</td>
							<td>${Supplier.name}</td>
							<td>${Supplier.address}</td>
							<td>
								<a href="<%=request.getContextPath()%>/Supplier/${Supplier.id}">Details</a>
								&nbsp;
								<a href="<%=request.getContextPath()%>/update/Supplier/${Supplier.id}">Update</a>
								&nbsp;
								<a href="<%=request.getContextPath()%>/delete/Supplier/${Supplier.id}" onclick="return confirm('Do you really want to delete this Supplier?')">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p>No Suppliers found in the database.</p>
		</c:otherwise>
	</c:choose>
	<center><button><a href="<%=request.getContextPath()%>/addSupplier">Add Supplier</a></button></center>
</body>
</html>
