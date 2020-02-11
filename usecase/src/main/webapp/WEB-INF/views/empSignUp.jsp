<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="css" value="/resources/css" />
<jsp:include page="empsidebar.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>consumer signup page</title>
<link rel="stylesheet" href="${css}/signup.css">

<!-- <script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 -->
</head>
<body>
	<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> -->
	<div class="card col-md-6 col-sm-6 col-6 col-lg-6 col-xl-6">
		<pre>
            <h1>Create your account</h1>
        </pre>
	</div>

	<form action="./addEmployee" name="signup" method="post"
		onsubmit="validateForm();return false">

		<label for="">Employee Name:</label><br> <input type="text"
			name="empName" id="empName" placeholder="Enter employee  name"><br>
		<br>  <label for="">empId:</label><br> <input type="text"
			name="empId" id="empId" placeholder="Enter employee ID"><br>
		<p id="meterErr"
			style="color: rgb(230, 98, 98); font-size: 10px; display: none;">invalid
			empID </p>
		<br>  <label for="">Password:</label> <br> <input
			type="password" name="password" id="password"
			placeholder="Enter your password"><br>
		<p id="pwdErr"
			style="color: rgb(235, 65, 65); font-size: 10px; display: none;">invalid
			password</p>
		<br> <label for="">Designation:</label> <br> <input
			type="text" name="designation" id="designation"
			placeholder="Enter designation"><br>
		
		<br>  <label for="">Region</label><br> <select name="region"
			id="region">
			<option value="" selected disabled>select</option>
			<option value="south">South</option>
			<option value="north">North</option>
		</select><br> <br>
		<button type="submit">Sign Up</button>
		&nbsp;
		<button type="reset">Reset</button>

		<p>
			Already have an account? <a href="./employeelogin">Login</a>
		</p>
	</form>
	<script src="${js}/signup.js"></script>
	<script type="${js}/jquery-3.4.1.js"></script>
	<script type="${js}/bootstrap.min.js"></script>
	
</body>

</html>