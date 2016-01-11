<!doctype html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page import="model.Container"%>
<%@page import="daoImpl.DatabaseConnection"%>
<%@page import="daoImpl.ContainerDaoImpl"%>
<html lang="en">
<head>
<%@ include file="navbar.jsp" %>
<% 
	String name = c.getLogin();
	String id = request.getParameter("id");
	String nameContainer = request.getParameter("name");
%>
<title>View Container - Helix</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Welcome, <% out.println(name); %>!</h1>
		</div>

	<div class="dropdown">
	    <% if(account.equals("premium")){%>
    <button class="btn btn-primary btn-large dropdown-toggle" type="button" data-toggle="dropdown">Checkpoint
    <span class="caret"></span>
    </button>

    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a href="Checkpoint?id=<%=id %>&action=do" role="menuitem" tabindex="-1">Do checkpoint</a></li>
      <li role="presentation"><a href="Checkpoint?id=<%=id %>&action=leaverunning" role="button" role="menuitem" tabindex="-1">Do checkpoint leaving container running</a></li>
      <li role="presentation"><a href="Checkpoint?id=<%=id %>&action=restore" role="menuitem" tabindex="-1">Restore Last checkpoint</a></li>
    </ul>
    <% } if(account.equals("free")){%>
    	<a role="button" class="btn btn-primary btn-large">Migrate to Premium Container</a>
    	<% }%>
    	<a href="upload.jsp?name=<%=nameContainer%>" role="button" class="btn btn-primary btn-large">Upload Webapps</a>
     </div>
		<div class="row spacer">
			<div class="span4"></div>
		</div>
	<br/>
		
		<div class="row">
		<div class="col-md-12">
		<% if(account.equals("premium")){%>
		<table class="table table-hover" id="stats">
			<thead>
				<tr>
					<th>Time</th>
					<th>Container ID</th>
					<th>CPU%</th>
					<th>Memory Usage</th>
					<th>Memory Limit</th>
					<th>Memory%</th>
				</tr>
			</thead>
		</table>
		<%} %>
		
		<% if(account.equals("free")){%>
<div class="jumbotron spacer">
<p>Want more premium exclusive features?</p>
<p><a class="btn btn-primary btn-large">Upgrade Now!</a>
</p>
</div>
		<%} %>
		</div>
		<div class="col-md-2">
		<!-- for future use -->
		</div>
		</div>
	</div>
	
</body>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script type="text/javascript">
$(function(){
	
    $.extend($.fn.dataTable.defaults.oLanguage, {
        "sLoadingRecords": '<i class="fa fa-spinner fa-spin"></i> Loading...',
    });
    
    $("#stats").dataTable({
        "ajax": {
            "url": "/helix.web/GetContainerStats?idContainer=<%=id%>",
            "dataType": "json",
            "cache": false,
            "contentType": "application/json; charset=utf-8"
            },
        "bInfo": false,
        "paging": false,
        "bSort" : false,
        "bFilter" : false,
        "stripeClasses":[],
        "columns":
        	[
 			{ data: "time"},
			{ data: "id"},
            { data: "cpu_per"},
            { data: "mem_usage"},
            { data: "mem_limit"},
            { data: "mem_per"},
        ],
    }).fadeIn();
});

setInterval( function () {
    table.ajax.reload( null, false ); // user paging is not reset on reload
}, 1000 );

</script>

	<%@ include file="footer.jsp" %>
</html>