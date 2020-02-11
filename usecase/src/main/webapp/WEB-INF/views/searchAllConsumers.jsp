<%@page import="com.bcits.usecase.beans.ConsumerInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<ConsumerInfoBean> list = (List<ConsumerInfoBean>) request.getAttribute("loggedInConsInfo");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<%-- <jsp:include page="header.jsp" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
	<fieldset>
		<legend>Search ALL Consumer</legend>
		<form action="./getAllConsumers" method="get">
			<input type="submit" value="search">



			<%
				if (errMsg != null && !errMsg.isEmpty()) {
			%>

			<h2 style="color: red"><%=errMsg%></h2>
			<%
				}
			%>


			<%
				if (list != null) {
			%>

			<table border="1" style="width: 70%">
				<tr style="background-color: navy; color: pink">
					<th>FirstName</th>
					<th>LastName</th>
					<th>MeterNo</th>
					<th>Email-Id</th>
					<th>MobileNo</th>
					<th>Address</th>
					<th>Pincode</th>
					<th>Consumertype</th>
					<th>Region</th>
				</tr>
				<%
					for (ConsumerInfoBean consumerInfoBean : list) {
				%>
				<tr>
					<td><%=consumerInfoBean.getFirstName()%></td>
					<td><%=consumerInfoBean.getLastName()%></td>
					<td><%=consumerInfoBean.getMeterNo()%></td>
					<td><%=consumerInfoBean.getEmail()%></td>
					<td><%=consumerInfoBean.getMobileNo()%></td>
					<td><%=consumerInfoBean.getAddress()%></td>
					<td><%=consumerInfoBean.getPincode()%></td>
					<td><%=consumerInfoBean.getConsumertype()%></td>
					<td><%=consumerInfoBean.getRegion()%></td>

				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</form>
	</fieldset>
	<%-- <jsp:include page="footer.jsp" /> --%>
</body>
<fieldset>
		<legend>bill generate</legend>
		<form action="./billUpdatePage" method="get">
			RRNo.:<input type="text" name="rrNo" required="required"><br>
			<input type="submit" value="generate"> -->
		</form>
	</fieldset>
	<fieldset>
		<legend>bill generate</legend>
		<form action="./billUpdatePage" method="post">
			<!-- RRNo.:<input type="text" name="rrNo" required="required"><br> -->
			<input type="submit" value="generate"> 
		</form>
	</fieldset>
	
</html>