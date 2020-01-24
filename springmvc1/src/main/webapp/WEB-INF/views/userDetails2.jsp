<%@page import="com.bcits.springmvc1.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% UserBean userBean=(UserBean) request.getAttribute("userBean");
     String name= (String) request.getAttribute(name) ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
user Id=<%= userBean.getEmpId() %><br>
password=<%= userBean.getPassword()%><br>
  Name= <%=name %>
</body>
</html>