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

		<table class="table table-striped table-hover" id="containers">
			<thead>
				<tr>
					<th>Name</th>
					<th>?</th>
					<th>Actions</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10-dev/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script type="text/javascript">
$(function(){
	function actionButtons(d) {
		btnBegin = '<a href="#"><i class="success fa fa-';
		btnEnd = '"></i></a> &nbsp;';
		
		actions = "";
		if (d.status === "down") {
			actions += btnBegin + "play" + btnEnd;
		} else if (d.status === "up") {
			actions += btnBegin + "stop" + btnEnd;
			actions += btnBegin + "pause" + btnEnd;
		}
		return actions;
	}
    $.extend($.fn.dataTable.defaults.oLanguage, {
        "sLoadingRecords": '<i class="fa fa-spinner fa-spin"></i> Loading...',
    });
    $("#containers").dataTable({
        "ajax": "js/example.json",
        "columns":
        	[
            { "data": "name", className: "table-name" },
            { "data": null, className: "table-status" },
            { "data": actionButtons, className: "table-actions" },
        ],
    }).fadeIn();
});
</script>
</html>