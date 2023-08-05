<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
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
	<h2>Spring Boot MVC and Hibernate CRUD Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Update Seed</h3>
	<form method="POST" name="update_seed"
		action="<%=request.getContextPath()%>/update/seed">
		<input hidden="hidden" name="id" value="${id}" type="text" />
        Name: <input name="name" value="${seed.name}" type="text" /> <br /> <br />
		Description: <input name="description" value="${seed.description}"
			type="text" /> <br /> <br />
		Quantity: <input name="quantity" value="${seed.quantity}" type="text" />
		 <br /> <br />
		Price: <input name="price" value="${seed.price}" type="text" />
		<br /> <br />
        Purchase Date: <input name="purchaseDate" value="${seed.purchaseDate}" type="text" />
		<br /> <br />
		<input value="Update Seed" type="submit" />
	</form>
</body>
</html>



