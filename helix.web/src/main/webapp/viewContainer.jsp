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
<% Customer c = (Customer)request.getSession().getAttribute("user");
	String name = c.getLogin();
%>

<title>View Container - Helix</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Welcome, <% out.println(name); %>!</h1>
		</div>
		<a href="create_container.jsp" role="button" class="btn btn-primary btn-large">Do checkpoint</a>
		<a href="create_container.jsp" role="button" class="btn btn-primary btn-large">Restore checkpoint</a>
		<a href="create_container.jsp" role="button" class="btn btn-primary btn-large">Export checkpoint</a>
		<div class="row spacer">
			<div class="span4"></div>
		</div>
		<br/>
		
		<div class="row">
		<div class="col-md-12">
		<table class="table table-hover" id="containers">
			<thead>
				<tr>
					<th>CPU%</th>
					<th>Memory usage / Limit</th>
					<th>Memory%</th>
					<th>Network I/O</th>
					<th>Block I/O</th>
				</tr>
			</thead>
		</table>
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
    
    $("#containers").dataTable({
        "ajax": {
            "url": "/helix.web/GetContainerList",
            "dataType": "json",
            "cache": false,
            "contentType": "application/json; charset=utf-8"
            },
        "bInfo": false,
        "paging": false,
        "bSort" : false,
        "stripeClasses":[],
        
        "columnDefs": [ {
            "targets": 0,
            "render": function ( data, type, full, meta ) {
              return '<a href="'+"viewContainer.jsp?"+data+'"><i class="fa fa-plus-square"></i></a>';
            }
          } ],
        
        "columns":
        	[
			{ data: "idDocker"},
            { data: "name"},
            { data: "image"},
            { data: "portmappers[:].externalPort"},
            { data: "ram"},
            { data: "cpu"},
            { data: "status"},
            { data: actionButtons, className: "table-actions" },
        ],
    }).fadeIn();
});
</script>
	<%@ include file="footer.jsp" %>
</html>