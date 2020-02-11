<%@page import="com.bcits.usecase.beans.CommentsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%String errMsg=(String)request.getAttribute("errMsg");
		List<CommentsInfo> list=(List<CommentsInfo>)request.getAttribute("list");
     %>
 <jsp:include page="empsidebar.jsp" /> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}/comments.css">
<style type="text/css">
    
    
</style>
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
	width: 50%;
	background-color: #f1f1c1;
	align: centre;
	margin-left: 400px;
}

body {
	background-color: rgb(205, 133, 63);
}
</style>

</style>
</head>
<body style="background-color: rgb(205, 133, 63);"><br><br>
<h3 style="color:green; text-align:center;">View Consumer Comments</h3><br>

	<%if(list!=null&&!list.isEmpty()){ %>
	<h5>
		<table>
			<tr style="color:black;">
				<th>R.R Number</th>
				<th>Name</th>
				<th>Email</th>
				<th>comments</th>
			</tr>
		<%for(CommentsInfo details:list){ %>
			<tr style="color:navy;">
				<td><%=details.getRrNo() %></td>
				<td><%=details.getName() %></td>
				<td><%=details.getEmail()%></td>
				<td><%=details.getComments() %></td>
		<%} %>
		</table>
		</h5>
	<%} %>



<%if(errMsg!=null&&!errMsg.isEmpty()) {%>
		<h2 style="color: red; text-align: center;"><%=errMsg %></h2>
	<%} %>
<script src="${js}/jquery-3.4.1.js"></script>
<script src="${js}/bootstrap.min.js"></script>
</body>
</html>