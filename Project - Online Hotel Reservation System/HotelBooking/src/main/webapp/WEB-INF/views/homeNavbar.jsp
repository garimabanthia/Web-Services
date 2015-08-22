 <link rel="stylesheet" type="text/css" href="${context}/resources/css/nav.css" />
<link rel="stylesheet" type="text/css" href="${context}/resources/css/style.css" />
<div id="titlebar">
	<img src="${context}/resources/images/left.jpg" class="floatleftimage">
	<img src="${context}/resources/images/right.jpg" class="floatrightimage">
   <h1>Lake View </h1>
   <h2> Awesome view at Affordable Rates</h2>  
   
</div>
<div id="wrap">
 
 <nav>
  <ul>
	<li><a href="${context}/">HOME</a> 
	<li><a href="#">Customer Profile</a>
		<ul>
			<li><a href="${context}/customer/insertNewCustomerDataForm">INSERT Customer</a> 
			 <li><a href="${context}/customer/removeCustomerDataPage">DELETE Customer</a>
			<li><a href="${context}/customer/selectACustomerID">SELECT Customer</a>
			<li><a href="${context}/customer/updateCustomerGetID">UPDATE Customer</a> 
		</ul>
	</li>
	 <li><a href="#">Booking</a> 
	 	<ul>
			<li class="insidetag"><a href="${context}/reservation/insertNewReservationDataForm">INSERT Booking</a> 
			<li class="insidetag"><a href="${context}/reservation/removeReservationDataPage">DELETE Booking</a>
			<li class="insidetag"><a href="${context}/reservation/selectAReservationID">SELECT Booking</a>
			<li class="insidetag"><a href="${context}/reservation/updateReservationGetID">UPDATE Booking</a>
		</ul>
	</li> 
	
	<%-- <li><a href="${context}/testTransactions">Test Transaction Rollback</a>
  --%>
 
  </ul>
</nav>	 
	
	
	