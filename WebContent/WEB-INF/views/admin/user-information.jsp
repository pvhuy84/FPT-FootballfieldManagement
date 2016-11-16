<%@page import="model.bean.BookfieldState"%>
<%@page import="model.bean.User"%>
<%
	User user = (User) session.getAttribute("user");
%>

<%@page import="model.bean.Timepacket"%>
<%@page import="model.bean.Field"%>
<%@page import="java.util.ArrayList"%>
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
		<%@ include file="../../htmls/navbar-admin.html"%>
		<!--/navbar-->
		
		<!-- table -->
		<div class="table col-sm-12" style="margin-top: 20px">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Customer</th>
						<th>Phone Number</th>
					</tr>
				</thead>
				<tbody>
				<%
					if(request.getAttribute("customer")!=null) {
						User customer =(User)request.getAttribute("customer");
							%>
							<tr>
								<td colspan="1" style='width: 50%'><%=customer.getName() %></td>
								<td colspan="1" style='width: 50%'><%=customer.getPhonenumber() %></td>
							</tr>
							<%
					} 
				%>
				</tbody>
			</table>
		</div>
		<!-- /table -->
	</div>
	
	<script	src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>