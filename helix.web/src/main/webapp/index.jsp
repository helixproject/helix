<!doctype html>
<%@page import="controller.RefreshTable"%>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<!-- this is just for testing -->

<title>Dashboard</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<!-- this is just for testing -->

	<div class="container">
		<div class="page-header">
			<h1>Dashboard</h1>
		</div>
		<a href="CreateContainer.jsp" role="button" class="btn btn-primary btn-large">Create container</a>
		<div class="row spacer">
			<div class="span4"></div>
		</div>
		<br/>
		
		<p> This is the JSON list of containers for user called "customer":</p>
		<%
			out.println(RefreshTable.getContainerList());
		%>
		
		<ul class="list-group">
	  		<li class="list-group-item">Container 1</li>
	 		<li class="list-group-item">Container 2</li>
	 		<li class="list-group-item">Container 3</li>
	 		<li class="list-group-item">Container 4</li>
	 		<li class="list-group-item">Container 5</li>
		</ul>
	</div>
</body>
</html>