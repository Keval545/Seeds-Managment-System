<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<html>
<title>Seed Details</title>
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
    <h2>Seed Details</h2>
    Id: ${seed.id} <br />
    Name: ${seed.name} <br />
    Description: ${seed.description} <br />
    Quantity: ${seed.quantity} <br />
    Price: ${seed.price} <br />
    Purchase Date: ${seed.purchaseDate} <br />
</body>
</html>