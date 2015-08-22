<%@ include file="../include.jsp"%>
<html>
<head>
	<title>View Reservation Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>


<%@ include file="../homeNavbar.jsp"%>

    <div id="content">
    <h1>Reservation Information : </h1>
	  <table>
	  	 <tr>
	  	<td> Reservation ID : </td>
	        <td>${reservation.reservationID}
	        </td>
	    </tr>
	  	 <tr>
	  	<td>Room Type : </td>
	        <td>${reservation.roomType}
	        </td>
	    </tr>
	    <tr>
	  	<td>Check In Date : </td>
	        <td> ${reservation.checkINDate}
	        </td>
	    </tr>
	    <tr>
	    <td>Check Out Date : </td>
	        <td> ${reservation.checkOUTDate}
	        </td>
	    </tr>
	   
	    <tr>
	  	<td>Amount Paid $ : </td>
	        <td> ${reservation.amountPaid }
	        </td>
	    </tr>    
	     <tr>
	  	<td>Total Amount $: </td>
	        <td> ${reservation.totalAmount}
	        </td>
	    </tr>
	    
	    </table>
 	</div>
</body>
</html>
