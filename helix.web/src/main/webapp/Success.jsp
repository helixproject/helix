<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp"%>
<title>Success</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<%
String id = (String)request.getAttribute("container") ;
%>

<body>
	<div class="container">
		<div class="page-header">
			<h1>Success</h1>
		</div>
		<div class="row spacer">
			<div class="span4"></div>
		</div>
		<br/>
		<p>Success on creating container: </p>
		<p>
		<%
		out.println("Below is the id");
		out.println(id);
		%>
		</p>
	</div>
</body>
</html>