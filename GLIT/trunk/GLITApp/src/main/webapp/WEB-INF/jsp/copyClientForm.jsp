<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Copy Client Forms</title>
		
		<meta name="viewport"
			content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />
			<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
	
	<link href="../GLITApp/assets/css/responsiveslides.css" rel="stylesheet" >
	<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../GLITApp/css/breadcrumb.css" rel="stylesheet" type="text/css"/>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />

		<script>
			if (!window.jQuery) {
				document.write('<script src="js/jquery-1.9.1.min.js"><\/script>');
			}
		</script>
		
		<script src="js/bootstrap-tab.js" type="text/javascript"></script>
		<script src="js/demos.js" type="text/javascript"></script>
		    
		<script src="<%=request.getContextPath()%>/jquery/json2.js"></script>
		<script src="<%=request.getContextPath()%>/jquery/jquery2.js"></script>
		<script type="text/javascript">
		function getFormsByClientId() {
			$.ajax({  
			    type : "Get",   
			    url : "getClientForms.spring",   
			    data : "clientId=" + document.getElementById("clientId").value,
			    success : function(response) { 
			    	 $('#unSelectedForm').empty("");
			    	var neww = "";
			        for ( var i = 1; i < response.length-1; i++) {
			       	 neww = neww+response[i];
			        }
			        var splited = neww.split('\,');
			        for ( var i = 0; i < splited.length; i=i+2) {
			            var splited1 = splited[i];
			            var grpId = splited1.slice(1, splited1.length);
			            var splited3 = splited[i+1].slice(1);
			            var grpName = splited3.slice(0,-2);
			            $('#unSelectedForm').append("<option value=\"" + grpId + "\">" +	 grpName  + "</option>");
			 		 }
			    },  
			    error : function(e) {  
			     alert('Error: ' + e);   
			    }  
			   });
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
	</head>
	<body>
	<div class="demo-container">
		<jsp:include page="header.jsp" />
        <div style="width:95%;padding:16px 0px 0px 66px">
		
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
	    <a href="client.spring">Client Details</a>
        <a href="form.spring?clientId=${clientId}">Form Details</a>
        <a href="#" class="active">Copy Clients Form </a>
        
	
</div>
        
                        </div>
                        </div>
						
        <div style="width:95%;padding:16px 0px 0px 66px">
        <div class="panel panel-default" >
                        <div class="panel-heading">
                            Copy Client Forms
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
                            <div class="table-responsive">
	    <form method="post" action="selectedForm.spring" onsubmit="return validate(this)">
	       <table>
	        	<tr>
					<td><label>Clients : </label></td> 
					<td colspan="2">
						<select id="clientId" name="clientId" onchange="getFormsByClientId()">
							<option value='0'>-- Please Select --</option>
							<c:forEach items="${clientList}" var="client">
								<option value="${client.clientId}">${client.clientName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<label>Forms : </label>
					</td>
				</tr>
				<tr>
					<td>
						<label></label>
					</td>
					<td>
						<select id="unSelectedForm" size="10" name="unSelectedForm" multiple="multiple" style="width:100;">
						</select>
					</td>
					<td>
						<div class="span1">
							<span id="addForms" class='add'>
								<a class="btn btn-primary marb5">></a>
							</span>
							<span id="removeForms" class='rem'>
							 	<a class="btn btn-primary marb5"><</a>
							</span>
						</div>
					</td>
					<td>
						<select id="selectedForm" size="10" name="selectedForm" multiple="multiple" style="width:100;">
							<c:forEach var="selectedForm" items="${selectedForms}">
								<option value="${selectedForm.formId}">${selectedForm.formName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
		    </table>
		    <br/>
		    <span style="margin-left:50px;"  >
				<input type="submit" class="myButton" value="Validate Form" />
			</span>
	    </form>
	    </div>
	    </div>
	    </div>
	    </div>
		</div>
		<script type="text/javascript">	
		function validate(selectForm) 
		{
		if( document.getElementById('clientId').value == "" || document.getElementById('clientId').value == null || document.getElementById('clientId').value == '0')
		{
		  alert( "Please select client!" );
		  return false;
		}
		if( document.getElementById('selectedForm').value == "" || document.getElementById('selectedForm').value == null )
		   {
		     alert( "Please select form!" );
		     return false;
		   }
		   
		}
		$(document).ready(function(){
			$('#addForms').click(function(){
					$('#unSelectedForm option:selected').clone().appendTo('#selectedForm').end().remove();
					$('#selectedForm option').attr('selected', true);
			});
			$('#removeForms').click(function() {
					$('#selectedForm option:selected').clone().appendTo('#unSelectedForm').end().remove();
					$('#selectedForm option').attr('selected', true);
			});
			});
		
		</script>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>