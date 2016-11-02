<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản Lý Sân Bóng</title>
<link rel="shortcut icon" type="image/x-icon" href="images/icon.png" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<div class="panel panel-primary col-sm-4 col-sm-push-4">
		<form method="post" action="checkLoginServlet">
			<h2 class="form-signin-heading" align="center">Đăng Nhập Hệ
				Thống</h2>
			<input type="text" name="tfUsername" class="form-control"
				placeholder="Tên đăng nhập"  autofocus> <input
				type="password" name="tfPassword" class="form-control"
				placeholder="Mật khẩu" required>
			<p id="thongbao" style="color: red; margin-top: 15px"></p>
			<%
				if (request.getAttribute("errorReport")!=null) {
					String errorReport=(String) request.getAttribute("errorReport");
					out.print("<p style='color:red;'>"+errorReport+"</p>");
				}
			%>
			<div class="checkbox">
				<label> <input type="checkbox"> Ghi nhớ mật khẩu
				</label>
			</div>
			<div class="clearfix"></div>
			<button class="btn btn-default col-sm-5 " name="btReset" type="reset">Reset</button>
			<button class="btn btn-primary col-sm-5 col-sm-push-2" name="btLogin"
				type="submit">Đăng nhập</button>

		</form>
	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>