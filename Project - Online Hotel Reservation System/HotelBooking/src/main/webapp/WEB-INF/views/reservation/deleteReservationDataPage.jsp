<%@ include file="../include.jsp"%>
<html>
<head>
	<title>New Reservation Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
   	<h1>Enter Room Type</h1>

	  <form:form action="./removeReservationByID" method="GET" >
	  <table>
	  	 <tr>
	  	<%-- <td><fmt:message key="reservationID" /></td> --%>
	        <td> Please enter the ID to delete the booking  : <input type="TEXT" name="reservationID" /></td>
	    </tr>
	  
		<tr>
	    <td><input type="submit" value="Delete"> </td>
	    </tr>
	    </table>
	  </form:form>
 	</div>
</body>
</html>
