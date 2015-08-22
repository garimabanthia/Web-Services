<%@ include file="../include.jsp"%>
<html>
<head>
<title>New Customer Information</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
</head>
<body>
	<%@ include file="../homeNavbar.jsp"%>
	<div id="content">
		<h1>
			<fmt:message key="customerDataForm.title" />
		</h1>

		<form:form action="./processNewCustomerProfile" method="POST"
			commandName="customer">
			<table>

				<tr>
					<td><fmt:message key="firstnameLabel" /></td>
					<td><form:input path="firstName" /> <form:errors
							path="firstName" cssClass="error" /></td>
				</tr>

				<tr>
					<td><fmt:message key="lastnameLabel" /></td>
					<td><form:input path="lastName" /> <form:errors
							path="lastName" cssClass="error" /></td>
				</tr>

				<tr>
					<td><fmt:message key="phoneNumberLabel" /></td>
					<td><form:input path="phoneNumber" /> <form:errors
							path="phoneNumber" cssClass="error" /></td>
				</tr>

				<tr>
					<td><fmt:message key="emailAddressLabel" /></td>
					<td><form:input path="emailAddress" /> <form:errors
							path="emailAddress" cssClass="error" /></td>
				</tr>

				<tr>
					<td><fmt:message key="mailingAddressLabel" /></td>
					<td><form:input path="mailingAddress" /> <form:errors
							path="mailingAddress" cssClass="error" /></td>
				</tr>

				<tr>
					<td><input type="submit"
						value="<fmt:message key="enterBtn" />"></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>
