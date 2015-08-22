 <%@ include file="../include.jsp"%>
<html>
<head>
	<title>Reservation Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
	<h1>Insert New Car Information : </h1>

	  <form:form action="./processNewReservationProfile" method="POST" commandName="reservation">
	  <table>
	  	 <tr>
	  	<td>Room Type : </td>
	        <td><form:input path="roomType" />
	            <form:errors path="roomType" cssClass="error"/>
	        </td>
	    </tr>
	    <tr>
	  	<td>Check-In-Date : </td>
	        <td><form:input path="checkINDate" />
	            <form:errors path="checkINDate" cssClass="error"/>
	        </td>
	    </tr>
	    <tr>
	    <td>Check-Out-Date : </td>
	        <td><form:input path="checkOUTDate" />
	            <form:errors path="checkOUTDate" cssClass="error"/>
	        </td>
	    </tr>
	   
	    <tr>
	  	<td>Amount Paid : </td>
	        <td><form:input path="amountPaid" />
	            <form:errors path="amountPaid" cssClass="error"/>
	        </td>
	    </tr>    
	     <tr>
	  	<td>Total Amount : </td>
	        <td><form:input path="totalAmount" />
	            <form:errors path="totalAmount" cssClass="error"/>
	        </td>
	    </tr>
	    
		<tr>
	    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
	    </tr>
	    </table>
	  </form:form>
 	</div>
</body>
</html>
