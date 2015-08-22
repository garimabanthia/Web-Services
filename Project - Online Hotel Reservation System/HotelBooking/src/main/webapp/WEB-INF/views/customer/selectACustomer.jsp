<%@ include file="../include.jsp"%>
<html>
<head>
	<title>View Customer Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>


<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
    <h1>Customer Information : </h1>
	  <table>
	  	 <tr>
	  	<td>Customer ID : </td>
	        <td>${customer.customerID}
	        </td>
	    </tr>
	  	 <tr>
	  	<td><fmt:message key="firstnameLabel" /></td>
	        <td>${customer.firstName}
	        </td>
	    </tr>
	    <tr>
	  	<td><fmt:message key="lastnameLabel" /></td>
	        <td> ${customer.lastName}
	        </td>
	    </tr>
	    <tr>
	    <td><fmt:message key="phoneNumberLabel" /></td>
	        <td> ${customer.phoneNumber}
	        </td>
	    </tr>
	   
	    <tr>
	  	<td><fmt:message key="emailAddressLabel" /></td>
	        <td> ${customer.emailAddress}
	        </td>
	    </tr>    
	     <tr>
	  	<td><fmt:message key="mailingAddressLabel" /></td>
	        <td> ${customer.mailingAddress}
	        </td>
	    </tr>
	    </table>
 	</div>
</body>
</html>
