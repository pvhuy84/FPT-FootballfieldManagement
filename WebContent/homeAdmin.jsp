
<%
	if (session.getAttribute("username") != null) {
%>
<%@page import="model.bean.FootballField"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.TimePacket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý cho thuê sân bóng</title>
<link rel="shortcut icon" type="image/x-icon" href="images/icon.png" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/quanlychothuesanbong.css" rel="stylesheet">
</head>
<%
	if (request.getAttribute("information") != null) {
			ArrayList<String> information = (ArrayList<String>) request.getAttribute("information");
			//out.println("<body onload=setInformation('"+information.get(0)+"', '"+information.get(1)+"', '"+information.get(2)+"')>");
%>
<body onload="setInformation('<%=information.get(0)%>','<%=information.get(1)%>','<%=information.get(2)%>')">
	<%
		} else {
	%>

<body>
	<%
		}
	%>


	<div class="container col-sm-8 col-sm-push-2">
		<div class="navbar">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="">Quản Lý Cho Thuê Sân Bóng</a></li>
						<li><a href="">Quản Lý Khách Hàng</a></li>
						<li><a href="">Quản Lý Thức Uống</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="logoutServlet"><span
								class="glyphicon glyphicon-log-out"></span> Đăng xuất</a></li>
					</ul>
				</div>
			</div>
			<!--/container-fluid--> </nav>
		</div>
		<!--/navbar-->

		<form method="post" action="getTimePacketForAdminServlet">
			<div class="content">
				<div class="col-sm-2">
					<select class="form-control" name="field" id="field">
						<%
							if (request.getAttribute("footballFieldArrayList") != null) {
									ArrayList<FootballField> footballFieldArrayList = (ArrayList<FootballField>) request
											.getAttribute("footballFieldArrayList");
									int i = 0;
									while (i < footballFieldArrayList.size()) {
										out.println("<option value='" + footballFieldArrayList.get(i).getName() + "'>Sân "
												+ footballFieldArrayList.get(i).getName() + "</option>");
										i++;
									}
								}
						%>
					</select>
				</div>
				<div class="col-sm-4">
					<input class="form-control" id="datepicker" type="date"
						max="2020-12-31" onchange="datepickerchanged()" name="date" />
				</div>
				<div class="col-sm-4">
					<select class="form-control" name="condition" id="condition">
						<option value="1">Tất cả</option>
						<option value="2">Chưa đăng ký</option>
						<option value="3">Đã đăng ký nhưng chưa xác nhận</option>
						<option value="4">Đã đăng ký và xác nhận</option>
					</select>
				</div>
				<div class="col-sm-2">
					<input type="submit" class="btn btn-primary col-sm-12" value="Xem" />
				</div>
		</form>
		<div class="table col-sm-12" style="margin-top: 20px">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Thời Gian</th>
						<th>Đã Đăng Ký</th>
						<th>Đã Xác Nhận</th>
						<th>Người Thuê</th>
						<th>Giá</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (request.getAttribute("information") != null) {
								ArrayList<String> information = (ArrayList<String>) request.getAttribute("information");

							}

							if (request.getAttribute("timePacketArrayList") != null) {
								ArrayList<TimePacket> timePacketArrayList = (ArrayList<TimePacket>) request
										.getAttribute("timePacketArrayList");
								if (timePacketArrayList.size() == 0) {
					%>
					<tr>
						<td colspan="5">Không có dữ liệu</td>
					</tr>
					<%
						} else {
									int i = 0;
									while (i < timePacketArrayList.size()) {
										out.println("<tr><td>" + timePacketArrayList.get(i).getIdPacket() + "</td><td>"
												+ timePacketArrayList.get(i).getIsRegister() + "</td><td>"
												+ timePacketArrayList.get(i).getIsConfirm() + "</td><td>"
												+ timePacketArrayList.get(i).getPhonenumberofcustomer() + "</td><td>"
												+ timePacketArrayList.get(i).getPrice() + "</td></tr>");
										i++;
									}
								}
							} else {
					%>
					<tr>
						<td colspan="5">Không có dữ liệu</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<!--/table-->
	</div>
	<!--/content-->
	<div class="" style="margin-top: 550px">
		<h2 align="center" style="color: blue">SE-10-TEAM</h2>
	</div>
	<script src="js/bootstrap.min.js"></script>
	<script>
		function setInformation(field, date, condition) {
			document.getElementById("field").value = field;

			document.getElementById("condition").value = condition;
		}
	</script>
	</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("loginServlet");
	}
%>