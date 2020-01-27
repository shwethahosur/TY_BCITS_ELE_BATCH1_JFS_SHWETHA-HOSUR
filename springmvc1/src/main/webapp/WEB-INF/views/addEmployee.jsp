<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend> Add Employee</legend>
<form action="./add" method="post">
<table>
<tr>
<td>employee id</td>
<td> : </td>
<td> <input type="number" name="empid" required></td>
</tr>
<tr>
<td>employee name</td>
<td> : </td>
<td> <input type="text" name="name" required></td>
</tr>
<tr>
<td>employee phone number</td>
<td> : </td>
<td> <input type="number" name="mobileno" required></td>
</tr>
<tr>
<td> employee designation</td>
<td> : </td>
<td> <input type="text" name="designation" required></td>
</tr>

<tr>
<td> joining date</td>
<td> : </td>
<td> <input type="date" name="date_of_joining" required></td>
</tr>

</table>
<input type="submit"value="add">
</form>
</fieldset>
</body>
</html>