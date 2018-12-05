<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> PMIT | Dashboard</title>
<meta http-equiv="x-ua-compatible" content="IE=8">
<meta charset="UTF-8">
	<link href="WebApps_PMIT/../css/sb-admin-2.css" rel="stylesheet">
	<link rel="stylesheet" href="WebApps_PMIT/../css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="WebApps_PMIT/../css/bootstrap.min.css">
	<link rel="stylesheet" href="WebApps_PMIT/../css/application.css">
	<link href="WebApps_PMIT/../css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="WebApps_PMIT/../css/plugins/dataTables.bootstrap.css" rel="stylesheet">
	
    <link href="WebApps_PMIT/../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		a {
	    color: #0254EB
		}
		a:visited {
		    color: #0254EB
		}
		a.morelink {
		    text-decoration:none;
		    outline: none;
		}
		.morecontent span {
		    display: none;
		}
		.comment {
		    width: 400px;
		    background-color: #f0f0f0;
		    margin: 10px;
		}
	</style>
	<script type="text/javascript" src="WebApps_PMIT/../js/jquery.js"></script>
	<script src="WebApps_PMIT/../js/jquery.validate.min.js"></script>
	<script src="WebApps_PMIT/../js/bootstrap.min.js"></script>
    <script src="WebApps_PMIT/../js/plugins/metisMenu/metisMenu.min.js"></script>
    <script src="WebApps_PMIT/../js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="WebApps_PMIT/../js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="WebApps_PMIT/../js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').dataTable();
    });
    $(document).ready(function() {
        var showChar = 100;
        var ellipsestext = "...";
        var moretext = "more";
        var lesstext = "less";
        $('.more').each(function() {
            var content = $(this).html();
     
            if(content.length > showChar) {
     
                var c = content.substr(0, showChar);
                var h = content.substr(showChar, content.length - showChar);
     
                var html = c + '<span class="moreellipses">' + ellipsestext+ '&nbsp;</span><span class="morecontent"><span>' + h + '</span>&nbsp;&nbsp;<a href="" class="morelink">' + moretext + '</a></span>';
     
                $(this).html(html);
            }
     
        });
     
        $(".morelink").click(function(){
            if($(this).hasClass("less")) {
                $(this).removeClass("less");
                $(this).html(moretext);
            } else {
                $(this).addClass("less");
                $(this).html(lesstext);
            }
            $(this).parent().prev().toggle();
            $(this).prev().toggle();
            return false;
        });
    });
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
			    <div id="wrapper">
					<div class="row">
		                    <div class="panel panel-default">
		                        <div class="panel-heading">
		                        &nbsp;&nbsp;&nbsp;
		                        </div>
		                        <div class="panel-body">
		                            <div class="table-responsive">
		                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
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
												<tr class="odd gradeX">
													<td>${issueDetails.issueForProject}</td>
													<td>${issueDetails.project.projectName}</td>
													<td>${issueDetails.severity}</td>
													<td class="comment more">${issueDetails.description}</td>
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
		                            </div>
		                        </div>
		                </div>
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
