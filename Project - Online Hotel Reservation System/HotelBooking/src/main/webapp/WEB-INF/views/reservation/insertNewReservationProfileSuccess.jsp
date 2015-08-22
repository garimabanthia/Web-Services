<%@ include file="../include.jsp"%>
<html>
<head>
<title>Reservation Done</title>
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
	<h2>A new Reservation has been successfully done for:
      	<font color="blue">${reservation.reservationID} and the room Type is ${reservation.roomType} </font></h2>
		<br>
		<h2>
		<a href="${context}">Home</a>
		</h2>
     </div>
</body>
</html>
