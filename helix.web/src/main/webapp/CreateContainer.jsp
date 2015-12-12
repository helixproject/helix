<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Create container</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
	<div class="container">
		<div class="page-header">
		<h1>Create container</h1>
		</div>
		<form data-toggle="validator" class="form-horizontal" action="CreateContainerServlet" method="post" novalidate>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="container_name">Container name:</label>
		<input type="text" class="form-control" name="name" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="cpu">CPU:</label>
		<select class="form-control" name="cpu" required>
		<option value="1">1 GHZ</option>
		<option value="2">2 GHZ</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="memory">Memory:</label>
		<select class="form-control" name="ram" required>
		<option value="512">512MB RAM</option>
		<option value="1024">1GB RAM</option>
		<option value="2048">2GB RAM</option>
		</select>
		</div>
		</div>
	
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="Service">Service:</label>
		<select class="form-control" name="image" required>
		<option data-hidden="true">none</option>
		<option value="tomcat">Tomcat</option>
		<option value="mysql">Mysql</option>
		</select>
		</div>
		</div>
		
		
		</div>

		<br/>
		<br/>
		<input class = "btn btn-primary" type="submit" id="submit" name="submit" value="Go" />
		</form>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
</body>
</html>