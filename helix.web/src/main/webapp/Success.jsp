<!doctype html>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<title>Success</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<%
String output = (String)request.getAttribute("json_output") ;
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
		out.println("Below is the info of container newly created in JSON format");
		out.println(output);
		%>
		</p>
	</div>
</body>
</html>