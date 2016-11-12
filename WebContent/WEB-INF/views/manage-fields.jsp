<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Management Field</title>
<link rel="shortcut icon" type="image/x-icon" href="images/icon.png" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/container.css" rel="stylesheet" />
</head>
<body>
	<div class="container col-sm-8 col-sm-push-2">
		<!-- navbar -->
		<%@ include file="../htmls/navbar-admin.html"%>
		<!--/navbar-->
		
		<!-- filter -->
		<div class="filter">
			<form method="post" action="getTimePacketForAdminServlet">
				<div class="col-sm-2">
					<select class="form-control" name="field" id="field">
					</select>
				</div>
				<div class="col-sm-4">
					<input class="form-control" id="day" name="day" placeholder="dd/mm/yyyy"/>
				</div>
				<div class="col-sm-4">
					<select class="form-control" name="condition" id="condition">
						<option value="1">All</option>
						<option value="2">Unregistered</option>
						<option value="3">Registered but unconfirmed</option>
						<option value="4">Confirmed</option>
					</select>
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-primary col-sm-12" value="Xem" />
				</div>
			</form>
		</div>
		<!-- /filter -->
		
		<!-- table -->
		<div class="table col-sm-12" style="margin-top: 20px">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Time</th>
						<th>Registered</th>
						<th>Confirmed</th>
						<th>Phone number of hirer</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="5">No data</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /table -->
	</div>
	
	<script	src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>