<%@ page import="com.medicare.*" %>
    <%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
@keyframes color {
  0%   { background: #33CCCC; }
  20%  { background: #33CC36; }
  40%  { background: #B8CC33; }
  60%  { background: #FCCA00; }
  80%  { background: #33CC36; }
  100% { background: #33CCCC; }
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<style>
body {
  background: #33CCCC; /* Fallback */
  animation: color 9s infinite linear;
  text-align: center;
  padding: 2em;
}
</style>
<center>
<%List<Contact> list=(List<Contact>)request.getAttribute("lists");  %>
<table style="width:60%" border="1" cellpadding = "10" cellspacing = "10" bordercolor = "orange" bgcolor = "FloralWhite" width="100%">
<tr><th>Name</th><th>Email</th><th>Mobile Number</th><th>Subject</th><th>Message</th></tr>
<% for(Contact s:list){%>
<tr><td><%=s.getName() %></td> <td><%=s.getEmail() %></td> <td><%=s.getMobileNum() %></td> <td><%=s.getSubject() %></td> <td><%=s.getMessage()%></td></tr>
<%}%> <br><br>
</table><br><br>
<form action="admin.jsp">
<input type="submit" value="Goto Admin Page">
</form>

</center>
</body>
</html>