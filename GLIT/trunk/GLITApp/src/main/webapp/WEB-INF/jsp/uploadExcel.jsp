<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>GLIT | Import Forms</title>
    <meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no"/>
		<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
	
	<link href="../GLITApp/assets/css/responsiveslides.css" rel="stylesheet" >
	<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../GLITApp/css/breadcrumb.css" rel="stylesheet" type="text/css"/>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	
	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>

    <script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
   
	<script src="GLITApp/../js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="GLITApp/../js/demos.js" type="text/javascript"></script>
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
    .CSSTableGenerator {
	margin:0px;padding:0px;
	width:100%;
	box-shadow: 10px 10px 5px #888888;
	border:1px solid #000000;
	
	-moz-border-radius-bottomleft:0px;
	-webkit-border-bottom-left-radius:0px;
	border-bottom-left-radius:0px;
	
	-moz-border-radius-bottomright:0px;
	-webkit-border-bottom-right-radius:0px;
	border-bottom-right-radius:0px;
	
	-moz-border-radius-topright:0px;
	-webkit-border-top-right-radius:0px;
	border-top-right-radius:0px;
	
	-moz-border-radius-topleft:0px;
	-webkit-border-top-left-radius:0px;
	border-top-left-radius:0px;
}.CSSTableGenerator table{
    border-collapse: collapse;
        border-spacing: 0;
	width:100%;
	height:100%;
	margin:0px;padding:0px;
}.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright:0px;
	-webkit-border-bottom-right-radius:0px;
	border-bottom-right-radius:0px;
}
.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft:0px;
	-webkit-border-top-left-radius:0px;
	border-top-left-radius:0px;
}
.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright:0px;
	-webkit-border-top-right-radius:0px;
	border-top-right-radius:0px;
}.CSSTableGenerator tr:last-child td:first-child{
	-moz-border-radius-bottomleft:0px;
	-webkit-border-bottom-left-radius:0px;
	border-bottom-left-radius:0px;
}.CSSTableGenerator tr:hover td{
	
}
.CSSTableGenerator tr:nth-child(odd){ background-color:#e5e5e5; }
.CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff; }.CSSTableGenerator td{
	vertical-align:middle;
	
	
	border:1px solid #000000;
	border-width:0px 1px 1px 0px;
	text-align:left;
	padding:7px;
	font-size:10px;
	font-family:Arial;
	font-weight:normal;
	color:#000000;
}.CSSTableGenerator tr:last-child td{
	border-width:0px 1px 0px 0px;
}.CSSTableGenerator tr td:last-child{
	border-width:0px 0px 1px 0px;
}.CSSTableGenerator tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.CSSTableGenerator tr:first-child td{
		background:-o-linear-gradient(bottom, #cccccc 5%, #b2b2b2 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #cccccc), color-stop(1, #b2b2b2) );
	background:-moz-linear-gradient( center top, #cccccc 5%, #b2b2b2 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#cccccc", endColorstr="#b2b2b2");	background: -o-linear-gradient(top,#cccccc,b2b2b2);

	background-color:#cccccc;
	border:0px solid #000000;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:14px;
	font-family:Arial;
	font-weight:bold;
	color:#000000;
}
.CSSTableGenerator tr:first-child:hover td{
	background:-o-linear-gradient(bottom, #cccccc 5%, #b2b2b2 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #cccccc), color-stop(1, #b2b2b2) );
	background:-moz-linear-gradient( center top, #cccccc 5%, #b2b2b2 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#cccccc", endColorstr="#b2b2b2");	background: -o-linear-gradient(top,#cccccc,b2b2b2);

	background-color:#cccccc;
}
.CSSTableGenerator tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.CSSTableGenerator tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
}
    </style>
	
	<script type="text/javascript" language="javascript" src="../GLITApp/js/jquery.js"></script>
	<script type="text/javascript" language="javascript" class="init">

$(document).ready(function() {
	$('#example').dataTable( {
		"scrollY": 200,
		"scrollX": true
	} );
} );

	</script>
	</head>
	<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="demo-container">
		 <div style="width:95%;padding:16px 0px 0px 66px">
		
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
	    <a href="client.spring">Client Details</a>
        <a href="form.spring?clientId=${clientId}">Form Details</a>
       	<a href="#" class="active">Import Forms </a>
        
	
</div>
        
                        </div>
                        </div>
						<br/>
        <div style="width:95%;padding:16px 0px 0px 66px">
        <div class="panel panel-default" >
                        <div class="panel-heading">
                            Import Forms
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
			<span style="color: green;">${message }</span>
			<form:form method="POST" commandName="fileUploadForm" enctype="multipart/form-data" action="submitExcel.spring">
				 <table>
         		<tr><td colspan="2" style="color: red;"><form:errors path="*" cssStyle="color : red;"/>
        			 ${errors}
		         </td></tr>
		         <tr><td>Upload: </td><td><form:input type="file" path="fileData" /></td></tr>
		         </table>
				  <div class="panel-footer">
        <table>
		<tr>
		<td><span class="divider">&nbsp; </span></td>
		<td><input type="submit" id="btnAdd" class="myButton" onClick="insertRow()" value="Upload File"></input></td>
		
		</tr>
		</table>
		</div>
				 
				 
		        
			    <c:if test="${errorList != null}">
		        <table>
			        <tr> 
			        	<td colspan="2" style="color: red;">
			        	Please put Form name as specified. The following names are not as per specification : 
			        	</td>
			        	<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			        </tr>
					    <c:forEach items="${errorList}" var="errorName">
					        <tr>
					        	<td>&nbsp;&nbsp;&nbsp;</td>
					        	<td style="color: red;">${errorName.key}</td>
					        </tr>
					    </c:forEach>
		        </table>
			    </c:if>
			    <c:if test="${formNameError != null}">
		        <table>
			        <tr> 
			        	<td colspan="2" style="color: red;">
			        	Following Form Name already exsist. Please change the form Name &amp; again upload the sheet : 
			        	</td>
			        	<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			        </tr>
					    <c:forEach items="${formNameError}" var="formName">
					        <tr>
					        	<td>&nbsp;&nbsp;&nbsp;</td>
					        	<td style="color: red;">${formName}</td>
					        </tr>
					    </c:forEach>
		        </table>
			    </c:if>
			</form:form>
			</div>
			</div>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>