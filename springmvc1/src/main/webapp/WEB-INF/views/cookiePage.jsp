<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String)request.getAttribute("msg"); %>
    <% String errmsg=(String)request.getAttribute("errmsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./createCookie">click here</a>to create cookie<br>
<a href="./readCookie"> click here</a>to read cookie.


<% if(msg!=null && !msg.isEmpty()){ %>
<h3 style="color: green;"><%=msg %></h3>
<%} %>

<% if(errmsg!=null && !errmsg.isEmpty()){ %>
<h3 style="color: red;"><%=errmsg %></h3>
<%} %>
</body>
</html>