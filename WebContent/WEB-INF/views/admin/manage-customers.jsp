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
		<%
			if(request.getAttribute("deleteReport")!=null) {
				out.print("<p style='color:red'>"+(String)request.getAttribute("deleteReport")+"</p>");
			}
		%>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Customer</th>
						<th>Phone Number</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
				<%
					if(request.getAttribute("listCustomer")!=null) {
						ArrayList<User> listCustomer = new ArrayList<>();
						listCustomer=(ArrayList<User>)request.getAttribute("listCustomer");
						for(int i = 0; i < listCustomer.size(); i ++) {
							%>
							<tr>
								<td colspan="1" style='width: 40%'><%=listCustomer.get(i).getName() %></td>
								<td colspan="1" style='width: 40%'><%=listCustomer.get(i).getPhonenumber() %></td>
								<td colspan="1" style='width: 20%'><a class='btn btn-danger' style='width: 80%' href='delete-user?userphonenumber=<%=listCustomer.get(i).getPhonenumber()%>'>X</a></td>
							</tr>
							<%
						}
					} else {
						%>
						<tr>
							<td colspan="4">No data</td>
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