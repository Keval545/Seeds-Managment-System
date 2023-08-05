<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Update Order</title>
<head>
<style>
/* Reset default styles */
body, h1, table, th, td, a, button {
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

/* Center align table */
table {
  margin: 0 auto;
}

/* Add some spacing between buttons */
th, td {
  padding: 10px;
}

/* Style buttons */
a button {
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
a button:hover {
  background-color: #0056b3;
}

</style>
</head>
<body>
	<h2>Update Order</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="update_order"
		action="<%=request.getContextPath()%>/update/order">
		<input hidden="hidden" name="order_id" value="${order.id}" type="text" />
		Seed ID: 
		<select name = "seed_id">
			<c:forEach items = "${seeds}" var="v">
					<option value="${v.id}">${v.name}</option>
			</c:forEach>
		</select>
		
		<br /> <br />
		Farmer ID: <select name = "farmer_id">
			<c:forEach items = "${farmers}" var="v">
					<option value="${v.id}">${v.name}</option>
			</c:forEach>
		</select>
		<br><br>
		Supplier ID: <select name = "supplier_id">
			<c:forEach items = "${suppliers}" var="v">
					<option value="${v.id}">${v.name}</option>
			</c:forEach>
		</select>
		<br><br>
		Order Date: <input name="orderDate" type="date" /> <br /> <br />
		Quantity: <input name="quantity" type="text" /> <br /> <br />
		<input type="submit" value="Update Order" />
	</form>
</body>
</html>
