
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	

	<title>Booking Page</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="Event-Organiser/css/bootstrap.min.css" />

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="Event-Organiser/css/style_event.css" />

	<!-- jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- js file -->
	<script type="text/javascript" src="Event-Organiser/js/event_organiser.js"></script>

</head>

<body>
	<div id="booking" class="section">
		<div class="section-center">
				<div class="row">
					<div id="sidebar">
  						<div class="toggle-btn" onclick="toggleSidebar(this)">
    						<span></span>
    						<span></span>
    						<span></span>
  						</div>  
  					<div class="list">
					<div class="item">Home</div>
    				<div class="item">Application Status</div>
    				<div class="item">Change Password</div>
    				<div class="item">Log Out</div>
  					</div>
				</div>
					<div class="booking-form">
						<div class="form-header">
							<h2>Book Your Meetings</h2>
						</div>

						<form action="<%= request.getContextPath() %>/EventServlet" method="post">
							<div class="form-group">
								<span class="form-label">Meeting Room</span>
										<select class="form-control" name="room">
											<option>Computer seminar hall</option>
											<option>IT seminar hall</option>
											<option>ENTC seminar hall</option>
											<option>Labs</option>
										</select>
										<span class="select-arrow"></span>
							</div>
									<div class="form-group">
										<span class="form-label">Date</span>
										<input class="form-control" type="date" id="datecontrol" name="dt" required />
									</div>
									                         
								<div class="row">
								<div class="col-md-5">
									<div class="form-group">
										<span class="form-label">From</span>
										<input class="form-control" type="time" name="from" required>
									</div>
									
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<span class="form-label">To</span>
										<input class="form-control" type="time" name="to" required>
									</div>
								</div>
							</div>
							<div class="form-group">
								<span class="form-label">Description</span>
								<textarea placeholder="Enter details about the event." class="form-control" rows="30" cols="100" name="description"></textarea>
							</div>
							<div class="row">
								<div class="col-md-6">
								<div class="form-group">
									<span class="form-label">Upload File</span>
									<input class="form-control" type="file" id="my file" name="path" onchange="validatePDF(this)" />
								</div>
								</div>
							</div>	              
							<div class="form-btn">
								<button class="submit-btn">Book Now</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>