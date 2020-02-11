<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="css" value="/resources/css" />
<jsp:include page="sidebar.jsp" />

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

	<form action="./addConsumer" name="signup" method="post"
		onsubmit="validateForm();return false">

		<label for="">First Name:</label><br> <input type="text"
			name="firstName" id="firstname" placeholder="Enter your first name"><br>
		<br> <label for="">Last Name:</label><br> <input type="text"
			name="lastName" id="lastname" placeholder="Enter your last name"><br>
		<br> <label for="">Meter No:</label><br> <input type="text"
			name="meterNo" id="meternumber" placeholder="Enter your meter number"><br>
		<p id="meterErr"
			style="color: rgb(230, 98, 98); font-size: 10px; display: none;">invalid
			meter number</p>
		<br> <label for="">Email:</label><br> <input type="email"
			name="email" id="usermail" placeholder="Enter your email"><br>
		<p id="emailErr"
			style="color: rgb(235, 65, 65); font-size: 10px; display: none;">invalid
			email</p>
		<br> <label for="">Password:</label> <br> <input
			type="password" name="userPassword" id="userpassword"
			placeholder="Enter your password"><br>
		<p id="pwdErr"
			style="color: rgb(235, 65, 65); font-size: 10px; display: none;">invalid
			password</p>
		<br> <label for="">Mobile No:</label> <br> <input
			type="text" name="mobileNo" id="mobilenumber"
			placeholder="Enter your mobile number"><br>
		<p id="mobileNoErr"
			style="color: rgb(235, 65, 65); font-size: 10px; display: none;">invalid
			mobile number</p>
		<br> <label for="">Address:</label><br>
		<textarea name="address" id="adrs" cols="30" rows="10"
			placeholder="Enter your address"></textarea>
		<br> <br> <label for="">Type of consumer</label><br> <select
			name="consumertype" id="toc">
			<option value="" selected disabled>select</option>
			<option value="Residential consumers">Residential consumers</option>
			<option value="Commercial consumers">Commercial consumers</option>
			<option value="Industries consumers">Industries consumers</option>
		</select><br> <br> <label>Pincode:</label><br> <input
			type="text" name="pincode" id="pincode" placeholder="Enter pincode"><br>
		<br> <label for="">Region</label><br> <select name="region"
			id="region">
			<option value="" selected disabled>select</option>
			<option value="south">South</option>
			<option value="north">North</option>
		</select><br> <br>
		<button type="submit">Sign Up</button>
		&nbsp;
		<button type="reset">Reset</button>

		<p>
			Already have an account? <a href="./consumerlogin">Login</a>
		</p>
	</form>
	<script src="${js}/signup.js"></script>
	<script type="${js}/jquery-3.4.1.js"></script>
	<script type="${js}/bootstrap.min.js"></script>
	
</body>

</html>