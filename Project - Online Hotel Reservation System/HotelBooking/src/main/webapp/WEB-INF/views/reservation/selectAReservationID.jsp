<%@ include file="../include.jsp"%>
<html>
<head>
	<title>View Reservation Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
	<h1>Select A Reservation ID</h1>

	  <form:form action="./viewAReservation" method="GET" >
	  <table>
	  	 <tr>
	  	<td>Reservation ID to </td>
	        <td>View :<input type="TEXT" name="reservationID" /></td>
	    </tr>
	  
		<tr>
	    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
	    </tr>
	    </table>
	  </form:form>
 	</div>
</body>
</html>
