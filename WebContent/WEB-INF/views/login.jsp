<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="shortcut icon" type="image/x-icon" href="images/icon.png" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/formpage.css" rel="stylesheet">
</head>
<body>
	<div class="panel panel-primary col-sm-4 col-sm-push-4">
		<form method="post" action="check-login">
			<input type="text" name="tfPhonenumber" class="form-control"
											placeholder="Phone number" autofocus> 
			<input type="password" name="tfPassword" class="form-control" 
											placeholder="Password" required>
			<p id="thongbao" style="color: red; margin-top: 15px"></p>
			<%
				if (request.getAttribute("error") != null) {
					String error = (String) request.getAttribute("error");
					out.print("<p style='color:red;'>" + error + "</p>");
				}
			%>
			<div class="checkbox">
				<label> 
					<input type="checkbox"> Remember
				</label>
			</div>
			<div class="col-sm-4">
				<a href="home" class="btn btn-default col-sm-10 " name="btReset">Cancel</a>
			</div>
			<div class="col-sm-4 ">
				<button class="btn btn-default col-sm-10 col-sm-push-1"
					name="btReset" type="reset">Reset</button>
			</div>
			<div class="col-sm-4 ">
				<button class="btn btn-primary col-sm-10 col-sm-push-2"
					name="btLogin" type="submit">Login</button>
			</div>
		</form>
	</div>
	
	<script	src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>