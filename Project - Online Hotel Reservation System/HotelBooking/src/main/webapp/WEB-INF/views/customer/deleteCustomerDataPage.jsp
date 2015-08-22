<%@ include file="../include.jsp"%>
<html>
<head>
	<title>New Customer Information</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
    <div id="content">
   	<h1>Enter Customer Name</h1>

	  <form:form action="./removeCustomerByName" method="GET" >
	  <table>
	  	 <tr>
	  	<%-- <td><fmt:message key="CustomerfirstNameLabel" /></td> --%>
	        <td> Please enter the first Name to delete   : <input type="TEXT" name="firstName" /></td>
	    </tr>
	  
		<tr>
	    <td><input type="submit" value="Delete"> </td>
	    </tr>
	    </table>
	  </form:form>
 	</div>
</body>
</html>
