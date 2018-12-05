<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>GLIT | Edit Form</title>
    <meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no"/>
	<link href="../GLITApp/assets/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href='../GLITApp/css/fonts.css'
	rel='stylesheet' type='text/css'>
<link href="../GLITApp/assets/css/responsiveslides.css" rel="stylesheet">
<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="../GLITApp/css/breadcrumb.css" rel="stylesheet"
	type="text/css" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="GLITApp/../css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
    <script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
	<script src="js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="js/demos.js" type="text/javascript"></script>
    <link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		
		<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
		<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
		type="text/css" />
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
</head>
<body>
	<div class="demo-container">
	<jsp:include page="header.jsp"></jsp:include>
      	<div style="width: 95%; padding: 16px 0px 0px 66px">

			<div>
				<div class="breadcrumb flat" style="width: 100%;">
					<a href="client.spring">Client Details</a> 
					<a href="form.spring?clientId=${clientId}">Form Details</a> 
					<a href="formdata.spring?formId=${formId}">Form Data</a>
					<a href="#" class="active">${formName}</a>


				</div>

			</div>
		</div>
       
		<div style="width: 95%; padding: 16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            Fill ${formName}
                        </div>
                        <!-- /.panel-heading -->
		<form action="saveForm.spring" method="post" onsubmit="return validate(this);">
                        <div class="panel-body" style="background-color:#F1F6F9">
		<table>
		<c:choose>
			<c:when test="${flag==0}">
				<c:forEach items="${fieldList}" var="field">
					<tr>
						<td><span class="divider"> ${field.fieldName} <c:if test="${field.mandatory == true}"> <span style="color: red;">*</span></c:if></span></td>
						<td> &nbsp;</td>
						<td>
						<c:if test="${field.mandatory == true}">
						<input type="${field.fieldType}" name="${field.fieldName}" maxlength="${field.fieldLimit}" class="required" />
						</c:if>
						<c:if test="${field.mandatory == false}">
						<input type="${field.fieldType}" name="${field.fieldName}" maxlength="${field.fieldLimit}" />
						</c:if>
						
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fieldDataList}" var="fieldData">
					<tr>
						<td><span class="divider"> ${fieldData.formFields.fieldName}</span></td>
						<td> &nbsp;</td>
						<td><input type="${fieldData.formFields.fieldType}" name="${fieldData.formFields.fieldName}" maxlength="${fieldData.formFields.fieldLimit}"  value="${fieldData.value }" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</table>
		<input type="hidden" name="dataId" value="${flag}"/>
		<input type="hidden" name="formId" value="${formId}"/>
		</div>
		<div class="panel-footer">
		<input type="reset"  value="Reset" class="myButton" />
		<input type="submit" value="Save" class="myButton"/>
		</div>
		</form>
		
		</div>
		</div>
		<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
	</div>
    <script type="text/javascript">
var validate = (function() {
  var reClass = /(^|\s)required(\s|$)/;  // Field is required
  var reValue = /^\s*$/;                 // Match all whitespace

  return function (form) {
    var elements = form.elements;
    var el;

    for (var i=0, iLen=elements.length; i<iLen; i++) {
      el = elements[i];

      if (reClass.test(el.className) && reValue.test(el.value)) {
        // Required field has no value or only whitespace
        // Advise user to fix
        alert('please fix ' + el.name);
        return false;
      }
    }
  }
}());
</script>
<jsp:include page="footer.jsp"></jsp:include>    
</body>
</html>
