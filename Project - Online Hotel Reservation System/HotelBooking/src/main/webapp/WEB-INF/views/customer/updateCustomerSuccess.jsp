<%@ page session="false" %>
<%@ include file="../include.jsp"%>

<html>
<head>
	<title>Customer Updated</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
<%@ include file="../homeNavbar.jsp"%>
 	<div id="content">
	   <h2>A profile for ID : <font color="blue">${customerID} </font> has been successfully Updated!! </h2>
	   <h2>${resultMsg}</h2>
  	 </div>

</body>
</html>
