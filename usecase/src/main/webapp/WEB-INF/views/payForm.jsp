<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="sidebar.jsp" />
<%
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="/payForm.css" />
<link href="/payForm.js/">

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
}

table {
	width: 100%;
	background-color: #f1f1c1;
}

body {
	background-color: rgb(205, 133, 63);
}
</style>




</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>

	<h2 style="color: green"><%=msg%></h2>
	<%
		}
	%>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>

	<h2 style="color: red"><%=errMsg%></h2>
	<%
		}
	%>





	<div class="container">
		<div class="row-fluid">
			<form action="./payBill" method="post" form-horizontal>
				<fieldset>
					<div id="legend">
						<legend class="">Payment</legend>
					</div>

					<!-- Name -->
					<div class="control-group">
						<label class="control-label" for="amount">Amount</label>
						<div class="controls">
							<input type="number" id="amount" name="amount" placeholder="500"
								class="input-xlarge">
						</div>
					</div>
					<!-- Name -->
					<div class="control-group">
						<label class="control-label" for="username">Card Holder's
							Name</label>
						<div class="controls">
							<input type="text" id="username" name="username" placeholder=""
								class="input-xlarge">
						</div>
					</div>

					<!-- Card Number -->
					<div class="control-group">
						<label class="control-label" for="email">Card Number</label>
						<div class="controls">
							<input type="text" id="email" name="email" placeholder=""
								class="input-xlarge">
						</div>
					</div>

					<!-- Expiry-->
					<div class="control-group">
						<label class="control-label" for="password">Card Expiry
							Date</label>
						<div class="controls">
							<select class="span3" name="expiry_month" id="expiry_month">
								<option></option>
								<option value="01">Jan (01)</option>
								<option value="02">Feb (02)</option>
								<option value="03">Mar (03)</option>
								<option value="04">Apr (04)</option>
								<option value="05">May (05)</option>
								<option value="06">June (06)</option>
								<option value="07">July (07)</option>
								<option value="08">Aug (08)</option>
								<option value="09">Sep (09)</option>
								<option value="10">Oct (10)</option>1
								<option value="11">Nov (11)</option>
								<option value="12">Dec (12)</option>
							</select> <select class="span2" name="expiry_year">
								<option value="13">2013</option>
								<option value="14">2014</option>
								<option value="15">2015</option>
								<option value="16">2016</option>
								<option value="17">2017</option>
								<option value="18">2018</option>
								<option value="19">2019</option>
								<option value="20">2020</option>
								<option value="21">2021</option>
								<option value="22">2022</option>
								<option value="23">2023</option>
							</select>
						</div>
					</div>

					<!-- CVV -->
					<div class="control-group">
						<label class="control-label" for="password_confirm">Card
							CVV</label>
						<div class="controls">
							<input type="password" id="password_confirm"
								name="password_confirm" placeholder="" class="span2">
						</div>
					</div>

					<!-- Save card -->
					<div class="control-group">
						<div class="controls">
							<label class="checkbox" for="save_card"> <input
								type="checkbox" id="save_card" value="option1"> Save
								card on file?
							</label>
						</div>
					</div>

					<!-- Submit -->
					<div class="control-group">
						<div class="controls">
							<button class="btn btn-success">Pay Now</button>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
	</div>

</body>
</html>
