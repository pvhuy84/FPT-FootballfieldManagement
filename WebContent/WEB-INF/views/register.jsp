<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="images/icon.png" />
<title>Register</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/formpage.css" />
</head>
<body>
	<div class="panel panel-primary col-sm-4 col-sm-push-4">
	<%
		if (request.getAttribute("status") != null) { 
			String status=(String) request.getAttribute("status");
			if(status.equals("success")) {
				out.print("<p style='color:green;margin-top: 15px'>" + status + "</p>");
			} else {
				out.print("<p style='color:red;margin-top: 15px'>" + status + "</p>");
			}
		}
	%>
		<form method="post" action="add-user">
			<input type="text" name="tfPhonenumber" class="form-control"
											placeholder="Phonenumber" autofocus /> 
			<input type="password" name="tfPassword" class="form-control" 
											placeholder="Password" required />
			<input type="password" name="tfRepassword" class="form-control" 
											placeholder="Re-Password" required />
			<input type="text" name="tfName" class="form-control"
											placeholder="Name" required />
			<select name="slRole" class="form-control">
				<option value="0">User</option>
			</select> 
			<div class="col-sm-4">
				<a href="home" class="btn btn-default col-sm-10 " name="btReset">Cancel</a>
			</div>
			<div class="col-sm-4 ">
				<button class="btn btn-default col-sm-10 col-sm-push-1"
					name="btReset" type="reset">Reset</button>
			</div>
			<div class="col-sm-4 ">
				<button class="btn btn-primary col-sm-10 col-sm-push-2"
					name="btLogin" type="submit">Register</button>
			</div>
		</form>
	</div>
</body>
</html>