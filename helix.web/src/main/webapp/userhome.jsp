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

<title>Dashboard - Helix</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

	<div class="container">
		<div class="page-header">
			<h1>Welcome, <% out.println(name); %>!</h1>
		</div>
		<a href="create_container.jsp" role="button" class="btn btn-primary btn-large">Create container</a>
		<div class="row spacer">
			<div class="span4"></div>
		</div>
		<br/>
		
		<div class="row">
		<div class="col-md-12">
		<table class="table table-hover" id="containers">
			<thead>
				<tr>
					<th>Name</th>
					<th>Image</th>
					<th>Port</th>
					<th>RAM</th>
					<th>CPU</th>
					<th>Status</th>
					<th>Action</th>
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
	function actionButtons(d) {
		
		actions = "";
		actions += '<i title="play" class="success fa fa-play active"></i>';
		actions += ' &nbsp' ;
		actions += '<i title="stop" class="success fa fa-stop active"></i>';
		actions += ' &nbsp' ;
		actions += '<i title="pause" class="success fa fa-pause active"></i>';
		actions += ' &nbsp' ;
		actions += '<i title="unpause" class="success fa fa-play-circle active"></i>';
		actions += ' &nbsp' ;
		
		if (d.status === "up") {
			$(".success.fa.fa-play").addClass("disabled");
			$(".success.fa.fa-play").removeClass("active");
			$(".success.fa.fa-stop").click(function(){
				window.location = '/helix.web/ManageContainer?action=stop&id='+d.idDocker;
			});
			$(".success.fa.fa-pause").click(function(){
				window.location = '/helix.web/ManageContainer?action=pause&id='+d.idDocker;
			});
			$(".success.fa.fa-play-circle").click(function(){
				window.location = '/helix.web/ManageContainer?action=unpause&id='+d.idDocker;
			});
		} else {
			$(".success.fa.fa-pause").addClass("disabled");
			$(".success.fa.fa-stop").addClass("disabled");
			$(".success.fa.fa-play-circle").addClass("disabled");
			$(".success.fa.fa-pause").removeClass("active");
			$(".success.fa.fa-stop").removeClass("active");
			$(".success.fa.fa-play-circle").removeClass("active");
			$(".success.fa.fa-play").click(function(){
				window.location = '/helix.web/ManageContainerServlet?action=play&id='+d.idDocker;
			});
		}
		return actions;
	}
	
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
        "columns":
        	[
            { "data": "name"},
            { "data": "image"},
            { "data": "portmappers"},
            { "data": "ram"},
            { "data": "cpu"},
            { "data": "cpu"},
            { "data": actionButtons, className: "table-actions" },
        ],
    }).fadeIn();
});
</script>
	<%@ include file="footer.jsp" %>
</html>