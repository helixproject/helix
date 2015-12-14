<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Login - Helix</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		<form data-toggle="validator" class="form-horizontal" action="${pageContext.request.contextPath}/Login" method="post" novalidate>
				<div class="page-header">
		<h1>Log in</h1>
		</div>
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
		<input type="password" class="form-control" name="password" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<br/>
		<br/>
		<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Log in" />
		</form>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>