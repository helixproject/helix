<!doctype html>
<html>
<head>
<%@ include file="navbar.jsp" %>
<title>File Uploading Form</title>
</head>

<% 
	String name = c.getLogin();
	String nameContainer = request.getParameter("name");
%>

<body>
	<div class="container">
		<div class="page-header">
			<h1>Welcome, <% out.println(name); %>!</h1>
		</div>
		<br/>
		<div class="row">
		<div class="col-md-12">
		<h3>File Upload:</h3>
			Select a webapp (.war file) to upload: 
			<br/>
			<br/>
			<form action="Upload?name=<%=nameContainer %>" method="post" enctype="multipart/form-data">
			<input type="file" name="file" size="50" />
			<br/>
			<input type="submit" class="btn btn-primary" value="Upload WebApp" />
			</form>
		</div>
		<div class="col-md-2">
		<!-- for future use -->
		</div>
		</div>
	</div>
</body>
	<%@ include file="footer.jsp" %>
</html>