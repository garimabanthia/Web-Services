<%@ include file="../include.jsp"%>
<html>
<head>
	<title>Page Not Found!!</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
<h1>Please enter the valid ID! </h1>
    <div id="content">
	  <form:form action="./viewInvalidReservation" method="GET" >
	  <table>
	  <tr>
	  <td> This ID is not exists!!</td>
	   </tr>
	    </table>
	  </form:form>
	 </div>
	</div>
</body>
</html>




<!-- 	 <tr>
	  	<td>Reservation ID to make UPDATE : </td>
	        <td><input type="TEXT" name="reservationID" /></td>
	    </tr> -->
	  	<%-- <tr>
	    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
	    </tr> --%>