<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>GLIT | Dashboard</title>

<meta name="viewport"
	content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />
	
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

<style type="text/css" class="init">
	th,td {
		white-space: nowrap;
	}
	
	div.dataTables_wrapper {
		/* width: 800px;
			margin: 0 auto; */
		
	}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script src="GLITApp/../js/bootstrap-tab.js" type="text/javascript"></script>
<script src="GLITApp/../js/demos.js" type="text/javascript"></script>
<script src="GLITApp/../js/Chart.js" type="text/javascript"></script>
<!-- For DateTimePicker -->
<script src="GLITApp/../jquery/jquery.js" type="text/javascript"></script>
<script src="GLITApp/../jquery/jquery-ui.js" type="text/javascript"></script>
<script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>

<style>
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

#ui-datepicker-div {
	font: 80% "Trebuchet MS", sans-serif;
}
</style>
</head>
<body>

	<script>
$(function() {
$( "#fromMonth" ).datepicker({
	changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
    dateFormat: 'MM yy',
    
    onClose: function(dateText, inst) { 
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker('setDate', new Date(year, month, 1));
        $( "#toMonth" ).datepicker( "option", "minDate", new Date(year, month, 1) );
        month++;
        $( "#fromMonthDate" ).val(month+"/01/"+year);
    }
});
$( "#toMonth" ).datepicker({
	changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
    dateFormat: 'MM yy',
    
    onClose: function(dateText, inst) { 
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker('setDate', new Date(year, month, 1));
        month++;
        $( "#toMonthDate" ).val(month+"/01/"+year);
    }
});


 $("#fromMonth ,#toMonth ").focus(function () {
	      $(".ui-datepicker-calendar").hide();
	      $("#ui-datepicker-div").position({
	          my: "center top",
	          at: "center bottom",
	          of: $(this)
	      });
	   });
	 
	   $("#fromMonth ,#toMonth").blur(function () {
	     $(".ui-datepicker-calendar").hide();
	   });
	    
});


$(function() {
$( "#from" ).datepicker({
	defaultDate: "+1w",
	changeMonth: true,
	numberOfMonths: 3,
		onClose: function( selectedDate ) {
		$( "#to" ).datepicker( "option", "minDate", selectedDate );
		}
		});
	$( "#to" ).datepicker({
	defaultDate: "+1w",
	changeMonth: true,
	numberOfMonths: 3,
		onClose: function( selectedDate ) {
		$( "#from" ).datepicker( "option", "maxDate", selectedDate );
		}
	});
});

</script>

	<div class="demo-container">
		<jsp:include page="header.jsp" />
		<div style="width: 95%; padding: 16px 0px 0px 66px">

			<div>
				<div class="breadcrumb flat" style="width: 100%;">
					<a href="client.spring">Client Details</a> <a
						href="form.spring?clientId=${clientId}">Form Details</a> <a
						href="#" class="active">Dashboard </a>


				</div>

			</div>
		</div>

		<div class="content-grids">
			<div style="width: 95%; padding: 16px 0px 0px 60px">
				<div class="section group">
					<div class="listview_1_of_3 images_2_of_3">
						<div class="listimg listimg_1_of_2">
							<a href="questionnaire.spring" style="text-decoration: none;"> <img
								src="../GLITApp/assets/images/questionnaire.png"></a>
						</div>
						<div class="text list_1_of_2">
							<a href="questionnaire.spring" style="text-decoration: none;">
								<h3>Questionnaire</h3>
							
							</a>
							<div class="button">
								<span><a href="questionnaire.spring" style="text-decoration: none;">View More</a></span>
							</div>
						</div>
					</div>

					<c:choose>
						<c:when test="${role eq 'ROLE_ADMIN'}">
							<div class="listview_1_of_3 images_2_of_3">
								<div class="listimg listimg_1_of_2">
									<a href="dashboardConfig.spring"> <img
										src="../GLITApp/assets/images/dashboard.png"></a>
								</div>
								<div class="text list_1_of_2">
									<a href="dashboardConfig.spring" style="text-decoration: none;">
										<h3>Dashboard Configuration</h3>
									</a> <a href="dashboardConfig.spring"
										style="text-decoration: none;">
										<p>Need More info?</p>
									</a>
									<div class="button">
										<span><a href="dashboardConfig.spring">View More</a></span>
									</div>
								</div>
							</div>


						</c:when>
						<c:otherwise>
            		&nbsp;&nbsp;&nbsp;
            	</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<div style="width: 95%; padding: 16px 0px 0px 66px">
			<div class="panel panel-default">
				<div class="panel-heading">Dashboard Selection Panel</div>
				<!-- /.panel-heading -->
				<div class="panel-body" style="background-color: #F1F6F9">
					<form id="selectDashboardForm" method="post"
						action="dashboard.spring">
						<table style="margin-left: 25px;">
							<tr>
								<td><label>Dashboard : </label></td>
								<td><select id="dashboardId" name="dashboardId">
										<option value=''>-- Select Dashboard --</option>
										<c:forEach items="${dashboards}" var="dashboard">
											<c:choose>
												<c:when test="${dashboardId == dashboard.dashboardId}">
													<option value="${dashboard.dashboardId}"
														selected="selected">${dashboard.dashboardName}</option>
												</c:when>
												<c:otherwise>
													<option value="${dashboard.dashboardId}">${dashboard.dashboardName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select></td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><a href="#" onclick="return validate()"
									class="myButton" style="text-decoration: none;">Show
										Dashboard</a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<c:if test="${chartUtils != null}">
			<c:forEach items="${chartUtils }" var="chartData" varStatus="t">
				<div style="width: 95%; padding: 16px 0px 0px 66px">
					<div class="panel panel-default">
						<div class="panel-heading">Dashboard Charts Panel</div>
						<!-- /.panel-heading -->
						<div class="panel-body" style="background-color: #F1F6F9">
							<div>
								<table style="margin-left: 25px;">
									<tr>
										<td><label>Report Name : </label></td>
										<td><label style="color: blue;">${chartData.reportName}</label></td>
									</tr>
									<tr>
										<td><label>Report Criteria : </label></td>
										<td><label style="color: blue;">${chartData.reportCriteria}</label></td>
										<td><label>&nbsp;</label></td>
										<td><label>Report Type : </label></td>
										<td><label style="color: blue;">${chartData.reportType}</label></td>
									</tr>
									<tr>
										<td><br /></td>
									</tr>
								</table>
								<c:if test="${chartData.reportCriteria == 'Daily'}">
									<form id="periodForm" method="post"
										action="getPeriodDailyData.spring">
										<input type="hidden" value="${chartData.dashboardConfigId}"
											id="dashboardConfigId" name="dashboardConfigId"> <input
											type="hidden" value="${dashboardId}" id="dashboardId"
											name="dashboardId"> <input type="hidden"
											value="Daily" id="reportCriteria" name="reportCriteria">
										<table style="margin-left: 25px;" id="dataPickerTable">
											<tr>
												<td><label for="from">From</label></td>
												<td><input type="text" id="from" name="from"
													data-calendar="true"></td>
												<td><label for="to">to</label></td>
												<td><input type="text" id="to" name="to"
													data-calendar="true"></td>
												<td><a href="#"
													onclick="document.getElementById('periodForm').submit()"><img
														alt="Show Chart" title="Show Chart"
														src="../GLITApp/images/show-chart.png" /></a></td>
											</tr>
										</table>
									</form>
								</c:if>

								<c:if test="${chartData.reportCriteria == 'Monthly'}">
									<form id="periodFormMonth" method="post"
										action="getPeriodDailyData.spring">
										<input type="hidden" value="${chartData.dashboardConfigId}"
											id="dashboardConfigId" name="dashboardConfigId"> <input
											type="hidden" value="${dashboardId}" id="dashboardId"
											name="dashboardId"> <input type="hidden"
											value="Monthly" id="reportCriteria" name="reportCriteria">
										<input type="hidden" id="fromMonthDate" name="fromMonthDate">
										<input type="hidden" id="toMonthDate" name="toMonthDate">
										<table style="margin-left: 25px;" id="dataPickerTableMonth">
											<tr>
												<td><label for="from">From</label></td>
												<td><input type="text" id="fromMonth" name="fromMonth"
													data-calendar="false"></td>
												<td><label for="to">to</label></td>
												<td><input type="text" id="toMonth" name="toMonth"
													data-calendar="false"></td>
												<td><a href="#"
													onclick="document.getElementById('periodFormMonth').submit()"><img
														alt='Show Chart' title='Show Chart'
														src='../GLITApp/images/show-chart.png' /></a></td>
											</tr>
										</table>
									</form>
								</c:if>
								<table style="margin-left: 25px;">
									<tr>
										<td><canvas id="canvas${t.count}" height="500"
												width="1000"></canvas></td>
									</tr>
									<tr>
										<td><br />
										<br />
										<br />
										<br /></td>
									</tr>
								</table>

							</div>
						</div>
					</div>
				</div>

				<script>
			var lineChartData = {
				labels : ${chartData.dailyBasisDatas[0].dateList},
				datasets : [
					<c:forEach items="${chartData.dailyBasisDatas}" var="dailyBasisData">
					{
						label: "${dailyBasisData.value}",
						fillColor : "${dailyBasisData.color}",
						strokeColor : "rgba(30,144,255,1)",
						pointColor : "rgba(169,169,169,1)",
						pointStrokeColor : "#000",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(220,220,220,1)",
						highlightFill: "rgba(30,144,255,1,0.75)",
						highlightStroke: "rgba(147,112,219,1)",
						data : ${dailyBasisData.counts}
					},
					</c:forEach>
				]
	
			}
	   
	   var chartType = "${chartData.reportType}";
	   if(chartType == "Line Chart"){
		drawLineChart(lineChartData); 
	   }else if(chartType == "Bar Chart"){
	   	drawBarChart(lineChartData);
	   }
		
	 function drawLineChart(lineChartData){
		 var ctx = document.getElementById("canvas${t.count}").getContext("2d");
			window.myLine = new Chart(ctx).Line(lineChartData, {
				responsive: true
			});
	 }
	 
	 function drawBarChart(lineChartData){
			var ctx = document.getElementById("canvas${t.count}").getContext("2d");
			window.myBar = new Chart(ctx).Bar(lineChartData, {
				responsive : true
			});
	 }
	
		</script>
			</c:forEach>
		</c:if>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
	</div>
	<script type="text/javascript">
function validate() 
{
if( document.getElementById('dashboardId').value == '' || document.getElementById('dashboardId').value == null)
{
  alert( "Please select a dashboard!" );
  return false;
}
else
	{
	document.getElementById('selectDashboardForm').submit();
	return true;
	}
}
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>