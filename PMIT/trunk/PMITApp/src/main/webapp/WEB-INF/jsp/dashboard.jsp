<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> PMIT | Dashboard</title>
<meta http-equiv="x-ua-compatible" content="IE=8">
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="PMITApp/../css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css" href="PMITApp/../css/shCore.css">
	<link rel="stylesheet" type="text/css" href="PMITApp/../css/demo.css">
	<link rel="stylesheet" href="PMITApp/../css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="PMITApp/../css/bootstrap.min.css">
	<link rel="stylesheet" href="PMITApp/../css/application.css">
	
	<script type="text/javascript" src="PMITApp/../js/jquery.js"></script>
	<script type="text/javascript" src="PMITApp/../js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="PMITApp/../js/shCore.js"></script>
	<script type="text/javascript" src="PMITApp/../js/demo.js"></script>
	<script src="PMITApp/../js/jquery.validate.min.js"></script>
	<script src="PMITApp/../js/bootstrap.min.js"></script>
	<script type="text/javascript" class="init">
	$(document).ready(function() {
		$('#example').dataTable( {
			columnDefs: [ {
				targets: [ 0 ],
				orderData: [ 0, 1 ]
			}, {
				targets: [ 1 ],
				orderData: [ 1, 0 ]
			}, {
				targets: [ 4 ],
				orderData: [ 4, 0 ]
			} ]
		} );
	} );
	</script>
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container" >
		<div class="row">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a href="" class="pull-left" id="dell-logo"> <img
							src="img/dell-logo.png" />
						</a> <a class="brand text-center" href="#"> ADMS | WebApps - COE</a>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<header>
					<div class="page-header">
						<h2 style="margin-top: 85px;">(PMIT) Product Management Issue
							Tracker</h2>
					</div>
				</header>
			</div>
			<div class="row col-md-12">
				<div class="form-group" style="padding-bottom: 25px;">
					<a href="logout.spring"><img alt="logout" title="Logout" src="img/logout.png" align="right" height="20px;"/> </a>	
				</div>
				<div class="container" >
					<section>
						<table id="example" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product</th>
									<th>Severity</th>
									<th>Description</th>
									<th>Date</th>
									<th>Contact Details</th>
									<th>Uploaded</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${issueList}" var="issueDetails">
								<tr>
									<td>${issueDetails.issueForProject}</td>
									<td>${issueDetails.project.projectName}</td>
									<td>${issueDetails.severity}</td>
									<td>${issueDetails.description}</td>
									<td>${issueDetails.loggedDate}</td>
									<td>${issueDetails.contactName},<br/>${issueDetails.contactNumber},<br/>${issueDetails.contactEmail}</td>
									<td>
									<c:if test="${issueDetails.filePath ne null}">
									<a href="download.spring?path=${issueDetails.filePath}">Download</a>
									</c:if>
									<c:if test="${issueDetails.filePath eq null}">
									N/A
									</c:if>
									
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</section>
				</div>
			</div>
			<div class="row col-md-12" style="text-align: center;">
				<footer>
				<p class="muted">Member of COE will contact you in minimum one
					working day for the discussion of the issue based on severity.</p>
				<p class="muted">
					For further enquiry Contact us at <a
						href="mailto:Arvind_Gopalakrishna@Dell.com">WebApps-COE</a>
				</p>
				</footer>
			</div>
		</div>
	</div>
	<script src="PMITApp/../js/application.js"></script>
</body>
</html>
