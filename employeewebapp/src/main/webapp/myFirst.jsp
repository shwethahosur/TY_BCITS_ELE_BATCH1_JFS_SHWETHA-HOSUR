<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%! private int a=10;    
public void setA(int a){
	this.a=a;
}
public int getA(){
	return a;
}
 public String name="seema"   ;
 
 public String getName(){
	 return name;
 }
 public String getName(String name){
	 return name;
 }
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: blue;">welcome to jsp...</h1>
a=<%=a %><br>

a=<%= getA() %><br>
<% setA(100) ;%>
a=<%=getA() %><br><br>

Name=<%= name %><br>
Name=<%= getName() %><br>
Name=<%= getName("Dinga") %><br><br>

<% for(int i=0;i<5;i++){ %> <!-- for business logic scriptlet tag -->
<%= getName() %><br>     <!-- display or presentation logic expression tag -->
<%} %>



</body>
</html>
<%-- <jsp:forward page="./Date.html"></jsp:forward> --%>
 <%-- <jsp:forward page="./CurrentDate"></jsp:forward> --%>

<%-- <jsp:forward page="./searchEmp">
<jsp:param value="987457" name="empId"/>
</jsp:forward> --%>
<%-- <jsp:include page="/CurrentDate"></jsp:include>  --%>
<%-- <jsp:include page="/searchemployee.html">
<jsp:param value="456" name="empid"/>
</jsp:include>  --%>


<%@ include file="Date.html"%>
<%-- <%@ include file="/CuurentDate"%> dynamic resource is not allowed --%>
