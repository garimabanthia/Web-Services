<%@ include file="../include.jsp"%>
<html>
<head>
	<title>Update Reservation Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
<h1>Update A Reservation </h1>
    <div id="content">
	  <form:form action="./updateReservationData" method="GET" >
	  <table>
	  	 <tr>
	  	<td>Reservation ID to make UPDATE : </td>
	        <td><input type="TEXT" name="reservationID" /></td>
	    </tr>
	  
		<tr>
	    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
	    </tr>
	    </table>
	  </form:form>
	 </div>
	</div>
</body>
</html>
