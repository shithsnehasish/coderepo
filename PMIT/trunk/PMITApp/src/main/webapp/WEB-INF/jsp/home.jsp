<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title> PMIT CoE</title>
<meta http-equiv="x-ua-compatible" content="IE=8">
<meta charset="UTF-8">

<link rel="stylesheet" href="PMITApp/../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="PMITApp/../css/bootstrap.min.css">
<link rel="stylesheet" href="PMITApp/../css/application.css">
<script src="PMITApp/../js/jquery.min.js"></script>
<script src="PMITApp/../js/jquery.validate.min.js"></script>
<script src="PMITApp/../js/bootstrap.min.js"></script>
<script type="text/javascript">
        function Checkfiles()
        {
        var fup = document.getElementById('Upload');
        var file = document.getElementById('Upload').files[0];
        var sizeInKiloBytes = file.size * 0.001;
        var fileName = fup.value;
        var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
     /*    if(ext == "jpeg" || ext == 'jpg' || ext == 'png')
        { */
        	if(sizeInKiloBytes < 2048)
        		{
        		document.getElementById("UploadLabel").innerHTML = "";
       		 document.getElementById("UploadLabel").style.color ="#333";
       		 document.getElementById("Upload").style.color ="#333";
       		 document.getElementById("UploadLabelTag").style.color ="#333";
        return true;
        		}
        	else
        		{
        		 document.getElementById("UploadLabel").innerHTML = "<b>Upload image max size is 2 MB</b>";
        		 document.getElementById("UploadLabel").style.color ="#a94442";
        		 document.getElementById("Upload").style.color ="#a94442";
        		 document.getElementById("UploadLabelTag").style.color ="#a94442";
        		 fup.focus();
        	        return false;
        		}
        }
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
					<div class="form-group">
							${message}
					</div>
					<div class="form-group">
							${error}
					</div>
				</header>
			</div>
			<div class="row col-md-12">
				<div class="bs-example col-md-8">
					<form:form class="form-horizontal" id="form" action="submitForm.spring" commandName="issueDetail" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label class="col-md-4 control-label">Select Product</label>
							<div class=" input-group col-xs-8">
								<form:select path="project" cssClass="form-control">
									<form:option value="">--Select Product--</form:option>
									<form:options items="${projectList}" itemLabel="projectName" itemValue="projectId"/>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Issue Severity</label>
							<div class="input-group col-xs-8">
								<form:select path="severity" cssClass="form-control">
									<form:option value="">--Select issue--</form:option>
									<form:option value="major">Major</form:option>
									<form:option value="medium">Medium</form:option>
									<form:option value="minor">Minor</form:option>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="projectname">Name
								Of Project</label>
							<div class="input-group col-xs-8">
								<form:input type="text" cssClass="form-control" path="issueForProject"
									placeholder="Project Name" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="personname">Contact
								Person Name</label>
							<div class="col-xs-8 input-group">
								<form:input type="text" id="inputWarning" cssClass="form-control"
									path="contactName" placeholder="Name" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="personemail">Contact
								Person Email</label>
							<div class="col-xs-8 input-group">
								<form:input type="email" cssClass="form-control"
									path="contactEmail" placeholder="Email ID" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="contact">Contact
								Person Ph.No</label>
							<div class="col-xs-8 input-group">
								<form:input type="text" cssClass="form-control"
									path="contactNumber"  placeholder="Phone Number" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="Upload" id="UploadLabelTag">Upload </label>
							<div class="col-xs-8 input-group">
								<input type="file" id="Upload" name="Upload" onchange="return Checkfiles();"/>
								<h5 class="help-block" id="UploadLabel"></h5>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="issue">Issue
								Details</label>
							<div class="col-xs-8 input-group">
								<form:textarea cssClass="col-xs-12" path="description"/>
							</div>
						</div>
						<div class="form-group">

							<div class="pull-right">
								<button class="btn btn-primary" type="submit">Submit
									Issue</button>
							</div>
						</div>

					</form:form>
				</div>
				<div class="bs-example col-md-3">
					<h2>Severity</h2>
					<div class="list-group">
						<a class="list-group-item list-group-item-danger"><b>Major
								:</b> Completely blocked, Unable to proceed and No workaround.</a> 
						<a class="list-group-item list-group-item-warning"><b>Medium
								:</b> Acting as a hindrance, Still able to proceed with the product.</a>
						<a class="list-group-item list-group-item-info"><b>Minor
								:</b> Issue is not likely to affect the usability of the product.</a>
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
	<script src="PMITApp/../js/application.js"></script>
</body>
</html>
