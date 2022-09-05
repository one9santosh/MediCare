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

<input type="text" name="" id="myInput" placeholder="Search For Medicine......" onkeyup="serachFun()">

<%List<Medicine> list=(List<Medicine>)request.getAttribute("list");  %>
<table id="myTable" border="1" cellpadding = "10" cellspacing = "10" bordercolor = "red" bgcolor = "BlanchedAlmond" width="100%">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Action</th></tr>
<% for(Medicine s:list){%>
<tr><td><%=s.getId() %><td><%=s.getName() %></td><td><%=s.getPrice()%></td> <td><a href="addtocart?id=<%=s.getId()%>">Add To Cart</a></td></tr>
<%}%> <br><br>
</table><br><br>
</center>
<script type="text/javascript">

const serachFun = () => {
let filter = document.getElementById('myInput').value.toUpperCase();
let myTable = document.getElementById('myTable');
let tr = myTable.getElementsByTagName('tr');

for(var i=0; i<tr.lenght; i++){
let td = tr[i].getElementsByTagName('td')[1];
if(td){
	let textvalue = td.textContent || td.innerHTML;
	if(textvalue.toUpperCase().indexOf(filter)> -1){
    tr[i].style.display = "";
		}else{
       tr[i].style.display = "none";
			}
               }	
          }
       }

</script>
</body>
</html>