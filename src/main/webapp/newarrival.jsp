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
.search-container{
position:relative;
}
.search-result{
position:absolute;
background:white;
width: 100%;
padding:10px;
display:none;
}
</style>
<meta charset="ISO-8859-1">
<title>MediCare</title>
</head>
<style>
body {
  background: #33CCCC;
  animation: color 9s infinite linear;
  text-align: center;
  padding: 2em;
}
</style>

<center>
<div class="search-container">
<input type="text" name="" id="search-input" class="form-control" placeholder="Search For Medicine......" onkeyup="search()" >
<div class="search-result">
<!-- Result Here.... -->


</div>

</div>



<%List<Medicine> list=(List<Medicine>)request.getAttribute("list");  %>
<table id="myTable" border="1" cellpadding = "10" cellspacing = "10" bordercolor = "red" bgcolor = "BlanchedAlmond" width="100%">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Action</th></tr>
<% for(Medicine s:list){%>
<tr><td><%=s.getId() %><td><%=s.getName() %></td><td><%=s.getPrice()%></td> <td><a href="addtocart?id=<%=s.getId()%>">Buy Now</a></td></tr>
<%}%> <br><br>
</table><br><br>
</center>

<script src="js/new.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>

</body>
</html>