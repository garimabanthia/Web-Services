<%@ include file="../include.jsp"%>
<html>
<head>
	<title>View Customer Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
<h1><fmt:message key="customerDataForm.title" /></h1>
    <div id="content">
	  <form:form action="./updateCustomerData" method="GET" >
	  <table>
	  	 <tr>
	  	<td><fmt:message key="customerIDLabel" /></td>
	        <td>Customer ID to make UPDATE :<input type="TEXT" name="customerID" /></td>
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
