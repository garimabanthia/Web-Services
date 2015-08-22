<%@ include file="../include.jsp"%>
<html>
<head>
	<title>Update Customer Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
	<h1>Update Customer Profile</h1>

	  <form:form action="./updateCustomerSuccess" method="POST" commandName="customer">
	  <table>
		<tr>
	  	<td>Customer ID : </td>
	        <td><form:input path="customerID" readonly="true"/>
	        </td>
	    </tr>
	  	 <tr>
	  	 <tr>
	  	<td><fmt:message key="firstnameLabel" /></td>
	        <td><form:input path="firstName"/>
	            <form:errors path="firstName" cssClass="error"/>
	        </td>
	    </tr>
	    <tr>
	  	<td><fmt:message key="lastnameLabel" /></td>
	        <td><form:input path="lastName"  />
	            <form:errors path="lastName" cssClass="error"/>
	        </td>
	    </tr>
	    <tr>
	    <td><fmt:message key="phoneNumberLabel" /></td>
	        <td><form:input path="phoneNumber" />
	            <form:errors path="phoneNumber" cssClass="error"/>
	        </td>
	    </tr>
	    <tr>
	  	<td><fmt:message key="emailAddressLabel" /></td>
	        <td><form:input path="emailAddress" />
	            <form:errors path="emailAddress" cssClass="error"/>
	        </td>
	    </tr>    
	     <tr>
	  	<td><fmt:message key="mailingAddressLabel" /></td>
	        <td><form:input path="mailingAddress" />
	            <form:errors path="mailingAddress" cssClass="error"/>
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


 <%-- 
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
    <td><fmt:message key="driverNoLabel" /></td>
        <td> ${customer.drivLicNum}
        </td>
    </tr>
   
    <tr>
  	<td><fmt:message key="emailLable" /></td>
        <td> ${customer.email}
        </td>
    </tr>    
     <tr>
  	<td><fmt:message key="addressLabel" /></td>
        <td> ${customer.address}
        </td>
    </tr>
    <tr>
  	<td><fmt:message key="cityLabel" /></td>
        <td> ${customer.city}
        </td>
    </tr>
    <td><fmt:message key="stateLabel" /></td>
        <td> ${customer.state}
        </td>
    </tr>
    <tr>
  	<td><fmt:message key="zipcodeLabel" /></td>
        <td> ${customer.zipCode}
        </td>
    </tr>
 --%>