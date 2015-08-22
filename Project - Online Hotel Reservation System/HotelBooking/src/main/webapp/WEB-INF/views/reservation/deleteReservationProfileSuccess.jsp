<%@ include file="../include.jsp"%>
<html>
<head>
<title>New Reservation Profile Created</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
		<h2>A profile for : <font color="blue">${reservationID} </font> room has been successfully removed!!</h2>
		<br>
		<h2>
		<a href="${context}">Home</a>
		</h2>
	</div>
</body>
</html>
