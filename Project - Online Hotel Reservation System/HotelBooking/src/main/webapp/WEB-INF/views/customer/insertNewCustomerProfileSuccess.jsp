<%@ include file="../include.jsp"%>
<html>
<head>
<title> New Customer Profile Created</title>
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
	<h2>A new profile has been successfully created for:
      	<font color="blue">${customer.firstName} ${customer.lastName} and it's ID is:${customer.customerID} </font></h2>
		<br>
		<h2>
		<a href="${context}">Home</a>
		</h2>
     </div>
</body>
</html>
