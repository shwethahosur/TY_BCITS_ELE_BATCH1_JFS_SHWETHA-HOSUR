<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<legend>search</legend>
		<form action="./delete">
			Employee ID:<input type="text" name="empid" required>
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="Delete">

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