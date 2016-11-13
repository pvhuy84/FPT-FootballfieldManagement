<%@page import="model.bean.Timepacket"%>
<%@page import="model.bean.Field"%>
<%@page import="java.util.ArrayList"%>
<%if(session.getAttribute("user")==null) response.sendRedirect("login"); %>
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
			<form method="post" action="getTimePacketForAdminServlet" onsubmit="return check()">
				<div class="col-sm-5">
					<input class="form-control" id="day" name="day" onchange="checkFormatDate()"
						value="<%=(String) session.getAttribute("today") %>" placeholder="dd/mm/yyyy"/>
				</div>
				<div class="col-sm-4"> 
					<select class="form-control" name="listtimepacket" id="listtimepacket">
					<%
						if(session.getAttribute("listTimepacket")!=null) {
							ArrayList<Timepacket> listTimepacket = (ArrayList<Timepacket>) session.getAttribute("listTimepacket");
							for(int i = 0; i < listTimepacket.size(); i ++) {
								out.print("<option value="+listTimepacket.get(i).getTimepacket_id() +">"+listTimepacket.get(i).getDescription() +"</option>");
							}
						}
					%>
					</select>
				</div>
				<div class="col-sm-3">
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
						<th>Field</th>
						<th>State</th>
						<th>Booker</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="4">No data</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- /table -->
	</div>
	
	<script	src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/date.customize.js"></script>
	<script type="text/javascript">
		function check() {
			day  = document.getElementById("day").value;
			if(!checkFormatDate(day)) {
				alert("Error format day!");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>