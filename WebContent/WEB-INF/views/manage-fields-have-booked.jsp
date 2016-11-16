<%@page import="model.bean.FieldBooked"%>
<%@page import="model.bean.Bookfield"%>
<%@page import="model.bean.BookfieldState"%>
<%@page import="model.bean.User"%>
<%
	if(session.getAttribute("user")==null) response.sendRedirect("login"); 
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
	
		<!-- check role to include file -->
		<%
			if(user.getRole()==1) {
		%>
		<!-- navbar -->
		<%@ include file="../htmls/navbar-admin.html"%>
		<!--/navbar-->
		
		<%
			} else { 
		%>
		<!-- navbar -->
		<%@ include file="../htmls/navbar-customer.html"%>
		<!--/navbar-->
		<%
			}
		%>
		
		<!-- table -->
		<div class="table col-sm-12" style="margin-top: 20px">
		<%
			if(request.getAttribute("actionReport")!=null) {
				out.print("<p style='color:red'>"+(String)request.getAttribute("actionReport")+"</p>");
			}
		%>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Field</th>
						<th>Day</th>
						<th>Time</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<%
					if(request.getAttribute("listFieldBooked")!=null&&((ArrayList<FieldBooked>)request.getAttribute("listFieldBooked")).size()!=0) {
						ArrayList<FieldBooked> listFieldBooked = new ArrayList<>();
						listFieldBooked=(ArrayList<FieldBooked>)request.getAttribute("listFieldBooked");
						for(int i = 0; i < listFieldBooked.size(); i ++) {
							String field = listFieldBooked.get(i).getField_id();
							String day = listFieldBooked.get(i).getDay().toString();
							day=day.substring(8, day.length()) + "/" + day.substring(5, 7) + "/" + day.substring(0, 4);
							String timepacketDescription = listFieldBooked.get(i).getTimepacketDescription();
							String status = listFieldBooked.get(i).getStatus();
							%>
							<tr>
									<td colspan="1"><label><%=field %></label></td>
									<td colspan="1"><label><%=day %></label></td>
									<td colspan="1"><label><%=timepacketDescription %></label></td>
									<td colspan="1"><label><%=status %></label></td>
									<td>
										<%
											if(status.equals("unconfirmed")) {
												String dataUrl="field="+field+"&&day="+day+"&&timepacket="+listFieldBooked.get(i).getTimepacket_id()+"&&phonenumber=="+user.getPhonenumber();
												out.print("<a class='btn btn-danger' style='width: 85%' href='delete?" + dataUrl + "'>X</a>");
											}
										%>
									</td>
							</tr>
							<%
						}
					} else {
						%>
						<tr>
							<td colspan="5">No data</td>
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