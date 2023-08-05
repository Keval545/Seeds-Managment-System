<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Admin Page</title>
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
	<center><h1>HELLO ADMIN</h1></center>
	<br><br><br>
	<table align="center" width=50% border="3px solid black" border-color = "black">
	<th>
	<a href ="<%=request.getContextPath()%>/seeds" ><button>For Seeds</button></a>
	</th><th>
	<a href ="<%=request.getContextPath()%>/Farmers" ><button>For Farmers</button></a>
	</th><th>
	<a href ="<%=request.getContextPath()%>/Suppliers" ><button>For Suppliers</button></a>
	</th><th>
	<a href ="<%=request.getContextPath()%>/orders" ><button>For Orders</button></a>
	</th>
	</table>
</body>
</html>