<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <<jsp:include page="header.jsp"></jsp:include>
     <% String msg=(String)request.getAttribute("msg");
    String errmsg=(String)request.getAttribute("errmsg");
     %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend> update Employee</legend>
<form action="./update" >
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
<td> employee salary</td>
<td> : </td>
<td> <input type="text" name="salary" required></td>
</tr>
</table>
<input type="submit"value="update">
</form>
</fieldset>
</body>
</html>
<%if(msg!=null && !msg.isEmpty()) {%>
<h3 style="color:green"><%=msg %></h3>

<%}%>
<%if(errmsg!=null && !errmsg.isEmpty()) {%>
<h3 style="color:red"><%=errmsg %></h3>

<%}%>
<jsp:include page="Footer.jsp"/>