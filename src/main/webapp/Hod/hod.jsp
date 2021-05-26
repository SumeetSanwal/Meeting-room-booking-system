<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
	<title>HOD</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="Hod/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="Hod/css/perfect-scrollbar.css">
	<link rel="stylesheet" type="text/css" href="Hod/css/style_status.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css">
</head>

<script type="text/javascript">
	function toggleSidebar(ref){
  		document.getElementById("sidebar").classList.toggle('active');
}
</script>
<body>
	<div class="row">
					<div id="sidebar">
  						<div class="toggle-btn" onclick="toggleSidebar(this)">
    						<span></span>
    						<span></span>
    						<span></span>
  						</div>  
  					<div class="list">
    				<div class="item">
    					<a href="index.html">Home</a>
    				</div>
    				<div class="item">
    					<a href="changepass.html">Change Password</a>
    				</div>
    				<div class="item">
    					<a href="index.html">Log Out</a>
    				</div>
  					</div>
		</div>
		
		</div>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1">
					<div class="table100-firstcol">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Application Number</th>
								</tr>
							</thead>
								<tbody>
								<!--   for (Todo todo: todos) {  -->
								<c:forEach var="event" items="${listEvents}">			
									<tr>
										<td class="cell100 column1"><br><c:out value="${event.id}" /></td>
									</tr>
								</c:forEach>
						</table>
					</div>
					
					<div class="wrap-table100-nextcols js-pscroll">
						<div class="table100-nextcols">
							<table>
								<thead>
									<tr class="row100 head">
										<th class="cell100 column2">Meeting Room</th>
										<th class="cell100 column2">Description</th>
										<th class="cell100 column3">From</th>
										<th class="cell100 column4">To</th>
										<th class="cell100 column4">Date</th>
										<th class="cell100 column5">Approve/deny</th>
									</tr>
								</thead>
								<tbody>
									<tr class="row100 body">
										<c:forEach var="ev" items="${listEvents}">

												<tr class="row100 body">
													
													<td><c:out value="${ev.room}" /></td>
													<td><c:out value="${ev.description}" /></td>
													<td><c:out value="${ev.from}" /></td>
													<td><c:out value="${ev.to}" /></td>
													<td><c:out value="${ev.dt}" /></td>
							 						<td class="cell100 column5"><button type="button" class="btn btn-success"><i class="far fa-check-square"></i></button>
            										<button type="button" class="btn btn-danger"><i class="fas fa-times"></i></button>
										
									</tr>
									</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="Hod/js/jquery-3.2.1.min.js"></script>
	<script src="Hod/js/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})

			$(this).on('ps-x-reach-start', function(){
				$(this).parent().find('.table100-firstcol').removeClass('shadow-table100-firstcol');
			});

			$(this).on('ps-scroll-x', function(){
				$(this).parent().find('.table100-firstcol').addClass('shadow-table100-firstcol');
			});

		});

		
		
		
	</script>

	<script src="js/main.js"></script>

</body>
</html>