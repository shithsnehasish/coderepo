<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GLIT | Dashboard Configuration</title>

<meta name="viewport"
	content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />
<link href="../GLITApp/assets/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href='../GLITApp/css/fonts.css' rel='stylesheet' type='text/css'>
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
<script src="GLITApp/../js/bootstrap-tab.js" type="text/javascript"></script>
<script src="GLITApp/../js/demos.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/jquery/json2.js"></script>
<script src="<%=request.getContextPath()%>/jquery/jquery2.js"></script>
<script type="text/javascript">
 function addRow(availableConfigCount) {
    var table = document.getElementById("dashConfigTable");
    var rowCount = table.rows.length;
    if(null != rowCount && rowCount > 0 && rowCount < availableConfigCount) {
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell5 = row.insertCell(2);
    var cell3 = row.insertCell(3);
    var cell4 = row.insertCell(4);
    //var cell6 = row.insertCell(5);
    var cell6 = row.insertCell(5);
    cell1.innerHTML = "<input id='reportName' name='reportName' class='required reportName' type='text'/>";
    cell2.innerHTML = "<select id='formBox"+rowCount+"' name ='formBox' class ='formBox'  onchange='getField("+rowCount+")'><option value='0'>-- Select Form --</option></select>";
    cell3.innerHTML = "<select id='chartBox' name ='chartBox' class ='chartBox' ><option value='0'>-- Select Chart --</option> <option value='Line Chart'>Line Chart</option> <option value='Bar Chart'>Bar Chart</option></select>";
    cell4.innerHTML = "<select id='criteriaBox' name ='criteriaBox' class ='criteriaBox' ><option value='0'>-- Select Criteria --</option> <option value='Daily'>Daily</option> <option value='Weekly'>Weekly</option><option value='Monthly'>Monthly</option></select>";
    cell5.innerHTML = "<select id='fieldBox"+rowCount+"' name ='fieldBox' class ='fieldBox' ><option value='0'>-- Select Field --</option></select>";
    /* cell6.innerHTML = "<select id='priorityBox"+rowCount+"' name ='priorityBox'><option value=''>-- Select Priority --</option><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select>"; */
    cell6.innerHTML = "<a href='#' onclick='deleteRow("+rowCount+")'  style='text-decoration: none;'>&nbsp;<img alt='' title='Remove Chart Configuartion ' src='../GLITApp/images/chart_delete.png'/></a>";
    $.ajax({  
	     type : "Get",   
	     url : "getForms.spring",   
	     data : "questionaireData=" + document.getElementById("questionaireData").value,
	     success : function(response) { 
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
	             $('#formBox'+rowCount).append("<option value=\"" + grpId + "\">" +	 grpName  + "</option>");
	  		 }
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	    });   
    }
} 

 function getForms(){
	 var table = document.getElementById("dashConfigTable");
	 var rowCount = table.rows.length;
	 if(null != rowCount && rowCount > 1){
		 if(confirm('click ok to reset')){
			 for(var i=rowCount-1; i > 0; i--){
				 table.deleteRow(i);
			 }
		 }else{
			 document.getElementById("questionaireData").value = questionaireValue;
			 return;
		 }
	 }
	 $.ajax({  
	     type : "Get",   
	     url : "getForms.spring",   
	     data : "questionaireData=" + document.getElementById("questionaireData").value,
	     success : function(response) { 
	    	 $('#formBox0').empty("");
	    	 $('#formBox0').append("<option value='0'>-- Select Form --</option>");
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
	             $('#formBox0').append("<option value=\"" + grpId + "\">" +	 grpName  + "</option>");
	  		 }
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	    }); 
 } 
 var questionaireValue = '';
function getQuestionaireValue(){
	questionaireValue = document.getElementById("questionaireData").value;
}
function getField(rowCount) {
	 $.ajax({  
	     type : "Get",   
	     url : "getField.spring",   
	     data : "formBox=" + document.getElementById("formBox"+rowCount).value,    
	     success : function(response) { 
	    	  $('#fieldBox'+rowCount).empty("");
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
	             $('#fieldBox'+rowCount).append("<option value=\"" + grpId + "\">" +	 grpName  + "</option>");
	  		 }
	     },  
	     error : function(e) {  
	      alert('Error: ' + e);   
	     }  
	    });  
}

function checkPriority() {
	 var table = document.getElementById("dashConfigTable");
	 var rowCount = table.rows.length;
	 var priority = 0;
	 if(rowCount == 1){
		 priority = parseInt(document.getElementById("priorityBox0").value);
		 if(priority == 1){
			 document.getElementById('setConfig').submit();
		 }else{
			 alert("Please select the correct priorities");
			 return false;
		 }
	 }else if(rowCount == 2){
		 var p1 = document.getElementById("priorityBox0").value;
		 var p2 = document.getElementById("priorityBox1").value;
		 priority = parseInt(p1) + parseInt(p2);
		 if(priority == 3){
			 document.getElementById('setConfig').submit();
		 }else{
			 alert("Please select the correct priorities");
			 return false;
		 }
	 }else if(rowCount == 3){
		 var p1 = document.getElementById("priorityBox0").value;
		 var p2 = document.getElementById("priorityBox1").value;
		 var p3 = document.getElementById("priorityBox2").value;
		 priority = parseInt(p1)+parseInt(p2)+parseInt(p3);
		 if(priority == 6){
			 document.getElementById('setConfig').submit();
		 }else{
			 alert("Please select the correct priorities");
			 return false;
		 }
	 }else if(rowCount == 4){
		 var p1 = document.getElementById("priorityBox0").value;
		 var p2 = document.getElementById("priorityBox1").value;
		 var p3 = document.getElementById("priorityBox2").value;
		 var p4 = document.getElementById("priorityBox3").value;
		 priority = parseInt(p1)+parseInt(p2)+parseInt(p3)+parseInt(p4);
		 if(priority == 10){
			 document.getElementById('setConfig').submit();
		 }else{
			 alert("Please select the correct priorities");
			 return false;
		 }
	 }else if(rowCount == 5){
		 var p1 = document.getElementById("priorityBox0").value;
		 var p2 = document.getElementById("priorityBox1").value;
		 var p3 = document.getElementById("priorityBox2").value;
		 var p4 = document.getElementById("priorityBox3").value;
		 var p5 = document.getElementById("priorityBox4").value;
		 priority = parseInt(p1)+parseInt(p2)+parseInt(p3)+parseInt(p4)+parseInt(p5);
		 if(priority == 15){
			 document.getElementById('setConfig').submit();
		 }else{
			 alert("Please select the correct priorities");
			 return false;
		 }
	 }else{
		 alert("Please select the correct priorities");
		 return false;
	 }
}
	 

function deleteRow(rowId) {
    var table = document.getElementById("dashConfigTable");
    table.deleteRow(rowId);
}
</script>
<style type="text/css">
.myButton {
	-moz-box-shadow: inset 0px 1px 0px 0px #97c4fe;
	-webkit-box-shadow: inset 0px 1px 0px 0px #97c4fe;
	box-shadow: inset 0px 1px 0px 0px #97c4fe;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #3d94f6
		), color-stop(1, #1e62d0));
	background: -moz-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background: -webkit-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background: -o-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background: -ms-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background: linear-gradient(to bottom, #3d94f6 5%, #1e62d0 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#3d94f6',
		endColorstr='#1e62d0', GradientType=0);
	background-color: #3d94f6;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #337fed;
	display: inline-block;
	cursor: pointer;
	color: #ffffff;
	font-family: arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 30px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #1570cd;
}

.myButton:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #1e62d0
		), color-stop(1, #3d94f6));
	background: -moz-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background: -webkit-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background: -o-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background: -ms-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background: linear-gradient(to bottom, #1e62d0 5%, #3d94f6 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#1e62d0',
		endColorstr='#3d94f6', GradientType=0);
	background-color: #1e62d0;
}

.myButton:active {
	position: relative;
	top: 1px;
}
</style>
</head>
<body>
	<div class="demo-container">
		<jsp:include page="header.jsp"></jsp:include>

		<div style="width: 95%; padding: 16px 0px 0px 66px">

			<div>
				<div class="breadcrumb flat" style="width: 100%;">
					<a href="client.spring">Client Details</a> <a
						href="form.spring?clientId=${clientId}">Form Details</a> <a
						href="dashboard.spring">Dashboard</a> <a href="#" class="active">Dashboard
						Configuration</a>
				</div>
			</div>
		</div>
		<div class="content-grids">
			<div style="width: 95%; padding: 16px 0px 0px 66px">
				<div class="section group">
					<div class="listview_1_of_3 images_3_of_3">
						<div class="listimg listimg_1_of_2">
							<a href="questionnaire.spring"> <img
								src="../GLITApp/assets/images/questionnaire.png"></a>
						</div>
						<div class="text list_1_of_2">
							<a href="questionnaire.spring" style="text-decoration: none;">
								<h3>Questionnaire</h3>
							</a> <a href="questionnaire.spring" style="text-decoration: none;">
								<p>Need More info?</p>
							</a>
							<div class="button">
								<span><a href="questionnaire.spring">View More</a></span>
							</div>
						</div>
					</div>
					<div class="listview_1_of_3 images_1_of_3">
						<div class="listimg listimg_1_of_2">
							<a href="selectDashboard.spring"> <img
								src="../GLITApp/assets/images/dashboard.png"></a>
						</div>
						<div class="text list_1_of_2">
							<a href="selectDashboard.spring" style="text-decoration: none;">
								<h3>Dashboard</h3>
							</a> <a href="selectDashboard.spring" style="text-decoration: none;">
								<p>Need More info?</p>
							</a>
							<div class="button">
								<span><a href="selectDashboard.spring">View More</a></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- onsubmit="return checkPriority()" -->
		<form id="setConfig" name="setConfig" method="post"
			action="saveConfig.spring">
			<div style="width: 95%; padding: 16px 0px 0px 66px">
				<div class="panel panel-default">
					<div class="panel-heading">Configure Dashboard</div>
					<div class="panel-body" style="background-color: #F1F6F9">
						<table>
							<tr>
								<td><label>Dashboard Name : </label></td>
								<td><input type="text" id="dashboardName"
									name="dashboardName" class="required"
									value="${dashboard.dashboardName}" /> <input type="hidden"
									id="dashboardId" name="dashboardId"
									value="${dashboard.dashboardId}" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><input type="hidden" id="questionaireData"
									name="questionaireData"
									value="${dashboard.questionaire.questionaireId}" /> <label>Questionaire
										: </label></td>

								<td><select id="questionaireData1" name="questionaireData1"
									class="questionaireData" disabled="disabled">
										<option value='0'>-- Select Questionaire --</option>
										<option value="${dashboard.questionaire.questionaireId}"
											selected="selected">${dashboard.questionaire.name}</option>
								</select></td>
							</tr>
						</table>
						<br />
						<table name="dashConfigTable" id="dashConfigTable">
							<c:forEach items="${configDTO.configUtils}" var="config"
								varStatus="count">
								<tr>
									<td><input id="reportName" name="reportName" type="text"
										class="required reportName" placeholder="Report Name"
										value="${config.reportName}" /></td>
									<td><select id="formBox${count.index}" name="formBox"
										class="formBox" onchange="getField(${count.index})">
											<option value='0'>-- Select Form --</option>
											<c:forEach items="${forms}" var="formD">
												<c:choose>
													<c:when test="${config.formName eq formD.formName}">
														<option value="${formD.formId}" selected="selected">${formD.formName}</option>
													</c:when>
													<c:otherwise>
														<option value="${formD.formId}">${formD.formName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
									<td><select id='fieldBox${count.index}' name='fieldBox'
										class="fieldBox">
											<option value='0'>-- Select Field --</option>
											<c:forEach items="${config.formFields}" var="formFields">
												<c:choose>
													<c:when test="${config.fieldId eq formFields.fieldId}">
														<option value="${formFields.fieldId}" selected="selected">${formFields.fieldName}</option>
													</c:when>
													<c:otherwise>
														<option value="${formFields.fieldId}">${formFields.fieldName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
									</select></td>
									<td><select id="chartBox" name="chartBox" class="chartBox"><option
												value='0'>-- Select Chart --</option>
											<c:choose>
												<c:when test="${config.typeOfChart eq 'Line Chart'}">
													<option value='Line Chart' selected="selected">Line
														Chart</option>
													<option value='Bar Chart'>Bar Chart</option>
												</c:when>
												<c:otherwise>
													<option value='Line Chart'>Line Chart</option>
													<option value='Bar Chart' selected="selected">Bar
														Chart</option>
												</c:otherwise>
											</c:choose>
									</select></td>
									<td><select id="criteriaBox" name="criteriaBox"
										class="criteriaBox"><option value='0'>--
												Select Criteria --</option>
											<c:choose>
												<c:when test="${config.criteria eq 'Daily'}">
													<option value='Daily' selected="selected">Daily</option>
													<option value='Weekly'>Weekly</option>
													<option value='Monthly'>Monthly</option>
												</c:when>
												<c:when test="${config.criteria eq 'Weekly'}">
													<option value='Daily'>Daily</option>
													<option value='Weekly' selected="selected">Weekly</option>
													<option value='Monthly'>Monthly</option>
												</c:when>
												<c:otherwise>
													<option value='Daily'>Daily</option>
													<option value='Weekly'>Weekly</option>
													<option value='Monthly' selected="selected">Monthly</option>
												</c:otherwise>
											</c:choose>
									</select></td>
									<td><a href="#" onclick="deleteRow(${count.index})"
										style="text-decoration: none;">&nbsp;<img alt=""
											title="Remove Chart Configuartion "
											src="../GLITApp/images/chart_delete.png" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="panel-footer">
						<a href="#" onclick="addRow(${availableConfigCount})"
							class="myButton" style="text-decoration: none;">Add Chart</a>&nbsp;&nbsp;&nbsp;
						<!-- <a href="#" onclick="deleteRow()">Remove Chart</a>&nbsp;&nbsp;&nbsp; -->
						<a href="#" onclick="return validate(this);" class="myButton"
							style="text-decoration: none;">Save Dashboard</a>&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
			<!-- <input type="submit" value="Save" /> -->
		</form>
	</div>
	<script type="text/javascript">
	 function validateForm() {
		 var errorFlag =false;
		  $('input.required').each(function() { 
			    if($(this).val() == "") {
			    	alert("All fields are mandatory");
			    	errorFlag = true;
			    }
		  });
		  $(".questionaireData").each(function() {
			   
			  if($(this).val() == "0")
		    	{
		    	alert( "Questionaire name is mandatory!" );
		    	errorFlag = true;
		    	}
			});
		  
		  $(".formBox").each(function() {
			   
			  if($(this).val() == "0")
		    	{
		    	alert( "Form name is mandatory!" );
		    	errorFlag = true;
		    	}
			});
		  $(".fieldBox").each(function() {
			   
			  if($(this).val() == "0")
		    	{
		    	alert( "Field name is mandatory!" );
		    	errorFlag = true;
		    	}
			});
		  $(".chartBox").each(function() {
			   
			  if($(this).val() == "0")
		    	{
		    	alert( "Chart type field is mandatory!" );
		    	errorFlag = true;
		    	}
			});
	    
		  $(".criteriaBox").each(function() {
			   
			  if($(this).val() == "0")
		    	{
		    	alert( "Criteria field is mandatory!" );
		    	errorFlag = true;
		    	}
			});
		  return errorFlag;
	  }
	var validate = function() {
  var reClass = /(^|\s)required(\s|$)/;  // Field is required
  var reValue = /^\s*$/;                 // Match all whitespace
 
  
  var validateFormResult = validateForm();
  if(validateFormResult == false){
	  var temp; var indexOfInput; 
	  var timeRepeated = 0;
	  var count = 0;
	    $( "input.reportName" ).each(function( index ) {
	    	temp = $(this).val();
	    	indexOfInput = $(this).index();
	    	 count++;
	    	$( "input.reportName" ).each(function( index ) {
	     	
	     	if(indexOfInput != index){
	     		
	     		if(temp == $(this).val()){
	     			timeRepeated++;
	     		}
	     	}
	     	
	     	 });
	    });
	    
	    var calculatedTimeRepeated = count;
	    if(timeRepeated == calculatedTimeRepeated){
	    	document.getElementById('setConfig').submit();
	    	return true;
	    }
	    else
	    	{
	    	alert("Report name is duplicate !");
	    	return false;
	    	} 
	    
  }
}
</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>