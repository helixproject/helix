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
		<form data-toggle="validator" class="form-horizontal" action="create_container_servlet" method="post" novalidate>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="container_name">Container name:</label>
		<input type="text" class="form-control" name="container_name" required />
		<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="cpu">CPU:</label>
		<select class="form-control" name="cpu" required>
		<option>1 core</option>
		<option>2 core</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="memory">Memory:</label>
		<select class="form-control" name="memory" required>
		<option>512MB RAM</option>
		<option>1GB RAM</option>
		<option>2GB RAM</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="storage">Storage:</label>
		<select class="form-control" name="storage" required>
		<option>1GB</option>
		<option>2GB</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="webserver">Web server:</label>
		<select class="form-control" name="webserver" required>
		<option data-hidden="true">none</option>
		<option>Tomcat 7.0</option>
		</select>
		</div>
		</div>
		
		<div class = "form-group">
		<div class="col-xs-3">
		<label for="database">Database:</label>
		<select class="form-control" name="database" required>
		<option data-hidden="true">none</option>
		<option>MySQL 5.7</option>
		</select>
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