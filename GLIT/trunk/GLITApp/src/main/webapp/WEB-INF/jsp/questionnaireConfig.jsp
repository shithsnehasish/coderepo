<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GLIT | Add Questionnaire</title>
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />

	<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
	
	<link href="../GLITApp/assets/css/responsiveslides.css" rel="stylesheet" >
	<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../GLITApp/css/breadcrumb.css" rel="stylesheet" type="text/css"/>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	
	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>

	<script>
	if (!window.jQuery) {
		document.write('<script src="js/jquery-1.9.1.min.js"><\/script>');
	}
</script>
<style type="text/css">
.myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #97c4fe;
	-webkit-box-shadow:inset 0px 1px 0px 0px #97c4fe;
	box-shadow:inset 0px 1px 0px 0px #97c4fe;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #3d94f6), color-stop(1, #1e62d0));
	background:-moz-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-webkit-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-o-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-ms-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:linear-gradient(to bottom, #3d94f6 5%, #1e62d0 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#3d94f6', endColorstr='#1e62d0',GradientType=0);
	background-color:#3d94f6;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #337fed;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 30px;
	text-decoration:none;
	text-shadow:0px 1px 0px #1570cd;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #1e62d0), color-stop(1, #3d94f6));
	background:-moz-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:-webkit-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:-o-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:-ms-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:linear-gradient(to bottom, #1e62d0 5%, #3d94f6 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#1e62d0', endColorstr='#3d94f6',GradientType=0);
	background-color:#1e62d0;
}
.myButton:active {
	position:relative;
	top:1px;
}
</style>
<script src="js/bootstrap-tab.js" type="text/javascript"></script>
<script src="js/demos.js" type="text/javascript"></script>
</head>
<body>
	<div class="demo-container">
		<jsp:include page="header.jsp"></jsp:include>
		
		<div style="width:95%;padding:16px 0px 0px 66px">
		
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
	    <a href="client.spring">Client Details</a>
        <a href="form.spring?clientId=${clientId}">Form Details</a>
        <a href="questionnaire.spring">Questionnaire Details</a>
		<a href="#" class="active">Questionnaire Configuration </a>
        
	
</div>
        
                        </div>
                        </div>
<c:if test="${flag ne 2 }">
	<form action="submitQuestionaireConfig.spring" method="post" onsubmit="return validate(this)" >
		<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-body" style="background-color:#F1F6F9">
            <input type="hidden" name="questionaireId" value="${questionaire.questionaireId}">
			<label>Questionaire Name</label>
			<input type="text" name="questionaireName" id="questionaireName" value="${questionaire.name}"/>
		</span>
		</div>
		</div>
		</div>
		<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
				<div class="panel-heading">
		Copy Forms
                        </div>
                                          <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
		<table border=1 style="margin-left: 30px;" valign=center>
			<tr>
				<th>All Forms</th>
				<th></th>
				<th>Selected Forms</th>
			</tr>
			<tr>
				<td>
					<select id="unSelectedForm" size="10" name="unSelectedForm" multiple="multiple" style="width:100;">
						<c:forEach var="form" items="${formList}">
							<option value="${form.formId}">${form.formName}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<div class="span1">
						<span id="addForms" class='add'>
							<a class="btn btn-primary marb5">
	>						</a>
						</span>
						<span id="removeForms" class='rem'>
						 	<a class="btn btn-primary marb5">
	<
							</a>
						</span>
					</div>
				</td>
				<td>
					<select id="selectedForm" size="10" name="selectedForm" multiple="multiple" style="width:100;">
						<c:forEach var="selectedForm" items="${selectedForms}">
							<option value="${selectedForm.formId}" selected="selected">${selectedForm.formName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		</div>
		<div class="panel-footer">
		<span style="margin-left:50px;"  >
			<input type="reset" class="myButton" value="Reset" />
			<input type="submit" class="myButton" value="Save" />
		</span>
		</div>
		</div>
		</div>
	</form>
	</c:if>
	<c:if test="${flag eq 2 }">
		<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-body" style="background-color:#F1F6F9">
            <input type="hidden" name="questionaireId" value="${questionaire.questionaireId}">
			<label>Questionaire Name</label>
			<input type="text" name="questionaireName" id="questionaireName" value="${questionaire.name}" readonly="readonly"/>
		</span>
		</div>
		</div>
		</div>
		<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
				<div class="panel-heading">
		Copy Forms
                        </div>
                                          <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
		<table border=1 style="margin-left: 30px;" valign=center>
			<tr>
				<th>All Forms</th>
				<th></th>
				<th>Selected Forms</th>
			</tr>
			<tr>
				<td>
					<select id="unSelectedForm" size="10" name="unSelectedForm" multiple="multiple" style="width:100;" disabled="disabled">
						<c:forEach var="form" items="${formList}">
							<option value="${form.formId}">${form.formName}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<div class="span1">
						<span>
							<a class="btn btn-primary marb5">
	>						</a>
						</span>
						<span>
						 	<a class="btn btn-primary marb5">
	<
							</a>
						</span>
					</div>
				</td>
				<td>
					<select id="selectedForm" size="10" name="selectedForm" multiple="multiple" style="width:100;" disabled="disabled">
						<c:forEach var="selectedForm" items="${selectedForms}">
							<option value="${selectedForm.formId}" selected="selected">${selectedForm.formName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		</div>
		<div class="panel-footer">
		<span style="margin-left:50px;"  >
		<c:if test="${flag ne 2 }">
			<input type="reset" class="myButton" value="Reset" />
			<input type="submit" class="myButton" value="Save" />
			</c:if>
		</span>
		</div>
		</div>
		</div>
	</c:if>
</div>	
<script type="text/javascript">	
		function validate(selectForm) 
		{
		if( document.getElementById('questionaireName').value == "" || document.getElementById('questionaireName').value == null)
		{
		  alert( "Please enter questionnaire name!" );
		  return false;
		}
		if( document.getElementById('selectedForm').value == "" || document.getElementById('selectedForm').value == null )
		   {
		     alert( "Please select form!" );
		     return false;
		   }
		}
		</script>
<script type="text/javascript">	
	$('#addForms').click(
		function() {
			$('#unSelectedForm option:selected').clone().appendTo('#selectedForm').end().end().remove();
			$('#selectedForm option').prop('selected', 'selected');
		});
	$('#removeForms').click(
		function() {
			$('#selectedForm option:selected').clone().appendTo('#unSelectedForm').end().end().remove();
			$('#selectedForm option').prop('selected', 'selected');
		});

</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
