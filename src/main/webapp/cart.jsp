 <%@ page import="com.medicare.*" %>
    <%@ page import="java.util.*" %>
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
  background: #33CCCC; /* Fallback */
  animation: color 9s infinite linear;
  text-align: center;
  padding: 2em;
}
</style>
<h1>Cart</h1>
<center>

<%Medicine s=(Medicine)session.getAttribute("MediCine");%>
<table id="myTable" border="1" cellpadding = "10" cellspacing = "10" bordercolor = "red" bgcolor = "BlanchedAlmond" width="100%">
<tr><th>Id</th><th>Name</th><th>Price</th></tr>
<tr><td><%=s.getId()%><td><%=s.getName()%></td><td><%=s.getPrice() %></td>
</table><br><br>
<form action="payment.jsp" method="post" class="signin-form">
                        <div class="input-grids">
                            <div class="row">
                                <div class="col-sm-6">
                                    <input type="text" name="name" id="name" placeholder="Your Name"
                                        class="contact-input" /><br><br>
                                </div>
                                <div class="col-sm-6">
                                
                                    <input type="text" name="mobileNum" id="mobileNum" placeholder="Your Mobile Number"
                                        class="contact-input" /><br><br>
                                </div>
                            </div>
                            <div class="col-sm-6">
                            <input type="text" name="email" id="email" placeholder="Your Email"
                                class="contact-input" />
                            <input type="text" name="address" id="address" placeholder="Address"
                                class="contact-input" /><br><br>
                   </div>
                        <div class="text-start">
                        <div class="col-sm-6">
                            <button class="btn btn-style btn-style-3">Pay Now</button>
                        </div>
                    </form>
</center>
</body>
</html>
</body>
</html>