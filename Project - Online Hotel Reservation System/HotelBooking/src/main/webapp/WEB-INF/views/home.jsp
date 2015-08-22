<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Hotel Lake View</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
	<%@ include file="./homeNavbar.jsp"%>
		<center>
			<h1>Welcome to Hotel Lake View</h1>
			<img src="${context}/resources/images/HotelFront.jpg" width="597" height="640">
			<br>
			<br>
			<br>
		</center>
	</div>
</body>
</html>
