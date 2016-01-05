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
					<th>Detail</th>
					<th>Name</th>
					<th>Image</th>
					<th>Port : SSH Port</th>
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

		if (d.status === "up") {
			
			actions += '<i title="pause" class="success fa fa-pause active"></i>';
			actions += ' &nbsp' ;
			actions += '<i title="stop" class="success fa fa-stop active"></i>';
			actions += ' &nbsp' ;
			
			$(".success.fa.fa-stop").click(function(){
				window.location = '/helix.web/ManageContainer?action=stop&id='+d.idDocker;
			});
			$(".success.fa.fa-pause").click(function(){
				window.location = '/helix.web/ManageContainer?action=pause&id='+d.idDocker;
			});
			$(".success.fa.fa-play-circle").click(function(){
				window.location = '/helix.web/ManageContainer?action=unpause&id='+d.idDocker;
			});
		} else if (d.status === "down" ){
			
			actions += '<i title="play" class="success fa fa-play active"></i>';
			actions += ' &nbsp' ;
			
			$(".success.fa.fa-play").click(function(){
				window.location = '/helix.web/ManageContainer?action=play&id='+d.idDocker;
			});
		}
		else if (d.status === "created" ){
			actions += '<i title="play" class="success fa fa-play active"></i>';
			actions += ' &nbsp' ;
			
			$(".success.fa.fa-play").click(function(){
				window.location = '/helix.web/ManageContainer?action=play&id='+d.idDocker;
			});
		}		else if(d.status === "paused"){
			
			actions += '<i title="unpause" class="success fa fa-play-circle active"></i>';
			actions += ' &nbsp' ;
			$(".success.fa.fa-play-circle").click(function(){
				window.location = '/helix.web/ManageContainer?action=unpause&id='+d.idDocker;
			});
		}

		return actions;
	}
	
	
function detail(d) {	
		actions = "";
		actions += '<i title="more" class="fa fa-arrow-right active"></i>';
		actions += ' &nbsp' ;
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
        
        "columnDefs": [ {
            "targets": 0,
            "render": function ( data, type, full, meta ) {
              return '<a href="'+"ManageContainer?action=detail&id="+data+'"><i class="fa fa-plus-square"></i></a>';
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
        "order": [[ 1, "desc" ]],
    }).fadeIn();
});
</script>
	<%@ include file="footer.jsp" %>
</html>
