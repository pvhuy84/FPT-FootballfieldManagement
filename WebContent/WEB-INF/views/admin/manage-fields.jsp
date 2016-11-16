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
		<!-- navbar -->
		<%@ include file="../../htmls/navbar-admin.html"%>
		<!--/navbar-->
		
		<!-- filter -->
		<div class="filter">
			<form method="post" action="get-book-field-state" onsubmit="return check()">
				<div class="col-sm-5">
					<input class="form-control" id="day" name="day"
					<%
						String day=(String) request.getAttribute("day");
					%>
						value="<%=day %>" placeholder="dd/mm/yyyy"/>
				</div>
				<div class="col-sm-4"> 
					<select class="form-control" name="listtimepacket" id="listtimepacket">
					<%
						int timepacket_id=((request.getAttribute("timepacket_id"))==null)?1:((int) request.getAttribute("timepacket_id"));
						if(session.getAttribute("listTimepacket")!=null) {
							ArrayList<Timepacket> listTimepacket = (ArrayList<Timepacket>) session.getAttribute("listTimepacket");
							for(int i = 0; i < listTimepacket.size(); i ++) {
								out.print("<option value='"+listTimepacket.get(i).getTimepacket_id() +"' " + ((i+1)==timepacket_id?"selected":"") + ">"+listTimepacket.get(i).getDescription() +"</option>");
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
		<%
			if(request.getAttribute("actionReport")!=null) {
				out.print("<p style='color:red'>"+(String)request.getAttribute("actionReport")+"</p>");
			}
		%>
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
				<%
					if(request.getAttribute("listBookFieldState")!=null) {
						ArrayList<BookfieldState> listBookFieldState = new ArrayList<>();
						listBookFieldState=(ArrayList<BookfieldState>)request.getAttribute("listBookFieldState");
						for(int i = 0; i < listBookFieldState.size(); i ++) {
							String field = listBookFieldState.get(i).getField();
							String status = listBookFieldState.get(i).getStatus()==null?"":listBookFieldState.get(i).getStatus();
							String booker = listBookFieldState.get(i).getBooker()==null?"":listBookFieldState.get(i).getBooker();
							String action = status.equals("")?"book":(status.equals("confirmed")?"cancel":"confirm");
							String dataUrl="field="+field+"&&day="+day+"&&timepacket="+timepacket_id;
							%>
							<tr>
									<td colspan="1"><label><%=field %></label></td>
									<td colspan="1"><label><%=status %></label></td>
									<td colspan="1"><label><a href="user-information?phonenumber=<%=listBookFieldState.get(i).getBookerPhonenumber()%>"><%=booker %></a></label></td>
									<td>
										<%
											if(status.equals("confirmed")) {
												out.print("<a href='cancel?" + dataUrl + "' style='width: 80%' class='btn btn-warning'> " + action + " </a>");
											} else if(status.equals("unconfirmed")) {
												out.print("<a href='confirm?" + dataUrl + "' style='width: 80%' class='btn btn-primary'> " + action + " </a>");
											} else {
												dataUrl="field="+field+"&&booker="+listBookFieldState.get(i).getBookerPhonenumber()+"&&timepacket="+timepacket_id+"&&day="+day;
												out.print("<a href='book?" + dataUrl + "' style='width: 97%' class='btn btn-primary'> " + action + " </a>");
											}
										%>
										
										<%
											if(!status.equals("")) {
												out.print("<a class='btn btn-danger' style='width: 15%' href='delete?" + dataUrl + "'>X</a>");
											}
										%>
									</td>
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