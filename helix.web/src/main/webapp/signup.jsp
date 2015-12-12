<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Sign up - Helix</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		<div class="page-header">
		<h1>Sign up</h1>
		</div>
		<form data-toggle="validator" class="form-horizontal" action="SignupServlet" method="post" novalidate>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="container_name">User login:</label>
		<input type="text" class="form-control" name="login" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="container_name">Password:</label>
		<input type="text" class="form-control" name="password" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="container_name">Confirm password:</label>
		<input type="text" class="form-control" name="cpassword" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="container_name">Email:</label>
		<input type="text" class="form-control" name="email" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="cpu">Account:</label>
		<select class="form-control" name="account" required>
		<option value="free">Free</option>
		<option value="premium">Premium</option>
		</select>
		</div>
		</div>

		<br/>
		<br/>
		<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Sign up" />
		</form>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>