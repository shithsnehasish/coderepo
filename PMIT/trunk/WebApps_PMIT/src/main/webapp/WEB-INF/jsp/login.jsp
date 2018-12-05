<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> PMIT CoE</title>
<meta http-equiv="x-ua-compatible" content="IE=8">
<meta charset="UTF-8">

<link rel="stylesheet" href="WebApps_PMIT/../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="WebApps_PMIT/../css/bootstrap.min.css">
<link rel="stylesheet" href="WebApps_PMIT/../css/application.css">
<script src="WebApps_PMIT/../js/jquery.min.js"></script>
<script src="WebApps_PMIT/../js/jquery.validate.min.js"></script>
<script src="WebApps_PMIT/../js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	  $("#userName").focus();
	});
</script>
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a href="" class="pull-left" id="dell-logo"> <img
							src="img/dell-logo.png" />
						</a> <a class="brand text-center" href="#"> ADMS | WebApps - COE</a>
						<!-- <form class="navbar-search pull-right" id="searchText">
				<input type="text" class="input-medium search-query" placeholder="Search">
			</form> -->
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
				<div class="bs-example col-md-8">
					<div class="form-group">
							${error}
					</div>
					<form:form class="form-horizontal" id="form" action="authorizeUser.spring" commandName="login" method="post">
						<div class="form-group">
							<label class="col-md-4 control-label" for="userName">User Name</label>
							<div class="input-group col-xs-6">
								<form:input type="text" cssClass="form-control" path="userName"
									placeholder="User Name"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="password">Password</label>
							<div class="col-xs-6 input-group">
								<form:password id="inputWarning" cssClass="form-control"
									path="password" placeholder="Password" />
							</div>
						</div>
						<div class="form-group">
							<div class="pull-right">
								<button class="btn btn-primary" type="submit">Login >></button>
							</div>
						</div>

					</form:form>
				</div>
				<div class="bs-example col-md-3">
					<div class="list-group">
					</div>
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
	<script src="WebApps_PMIT/../js/application.js"></script>
</body>
</html>
