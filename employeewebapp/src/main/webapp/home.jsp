<%@page import="com.bcits.bean.Test1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% Test1 test1=(Test1)session.getAttribute("loggedInEmpInfo"); %>
    <<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome <%= test1.getEmpname() %>......</h1>
</body>
</html>