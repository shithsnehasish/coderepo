<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GLIT | Questionnaire</title>
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

<script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
<script src="GLITApp/../js/bootstrap-tab.js" type="text/javascript"></script>
<script src="GLITApp/../js/demos.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
		href="../GLITApp/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/resources/syntax/shCore.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/resources/demo.css">
	<style type="text/css" class="init">
	th,td {
		white-space: nowrap;
	}
	
	div.dataTables_wrapper {
		/* width: 800px;
			margin: 0 auto; */
		
	}
	</style>
	<script type="text/javascript" language="javascript"
		src="../GLITApp/js/jquery.js"></script>
	<script type="text/javascript" language="javascript"
		src="../GLITApp/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript"
		src="../GLITApp/resources/syntax/shCore.js"></script>
	<script type="text/javascript" language="javascript"
		src="../GLITApp/resources/demo.js"></script>
	<script type="text/javascript" language="javascript" class="init">
		$(document).ready(function() {
			$('#example').dataTable({
				"scrollY" : 200,
				"scrollX" : true
			});
		});
	</script>
</head>
<body>
	<div class="demo-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div style="width: 95%; padding: 16px 0px 0px 66px">

			<div>
				<div class="breadcrumb flat" style="width: 100%;">
					<a href="client.spring">Client Details</a> <a
						href="form.spring?clientId=${clientId}">Form Details</a> <a
						href="questionnaire.spring">Questionnaire Details </a>
						<a href="#" class="active">Interaction Report </a>


				</div>

			</div>
		</div>

			<c:choose>
				<c:when test="${role eq 'ROLE_ADMIN'}">
				<div class="content-grids">
		    	<div style="width: 95%; padding: 16px 0px 0px 60px">
		    	<div class="section group">
		    	<div class="listview_1_of_3 images_2_of_3">
					<div class="listimg listimg_1_of_2">
						<a href="addInteractionReport.spring?questionaireId=${questionaireId}">  <img src="../GLITApp/assets/images/interaction.jpg"></a>
					</div>
					<div class="text list_1_of_2">
						 <a href="addInteractionReport.spring?questionaireId=${questionaireId}" style="text-decoration: none"> <h3>New Interaction</h3></a>
						  <div class="button"><span><a href="addInteractionReport.spring?questionaireId=${questionaireId}">View More</a></span></div>
				     </div>
				</div>	
            		</div>
            		</div>
            		</div>
				</c:when>
				<c:otherwise>
            		&nbsp;&nbsp;&nbsp;
            	</c:otherwise>
			</c:choose>
			<div style="width: 95%; padding: 16px 0px 0px 60px">
        <div class="panel panel-default" >
                        <div class="panel-heading">
                           Interaction List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
				   <table id="example" class="display"  border="1">
                	<c:forEach var="map" items="${headerMap}">
                		<thead>
                			<tr>
                			<th rowspan="2">${map.key}</th>
                			<c:forEach var="innerMap" items="${map.value}">
                			<th>
                			<div class="panel panel-default" >
                        <div class="panel-heading">
                			${innerMap.key}
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
                				<table border="1" style="background-color:#F1F6F9 ">
        							<thead>
								         <tr>
								     <c:forEach var="value" items="${innerMap.value}">
								           <th>${value}</th>
								      </c:forEach>
								         <tr>
								     <thead>  
								</table> 
								</div>
								</div>
								                			</th>
                			</c:forEach>
                			</tr>
                		</thead>
                	</c:forEach>
                	<c:forEach var="value" items="${valueMap}">
                		<tbody>
                			<tr>
                			<td>${value.key}</td>
                			<c:forEach var="innerValueMap" items="${value.value}">
                			<td>
                				<table border="1" style="background-color:#F1F6F9 ">
								         <tr>
								     <c:forEach var="valueList" items="${innerValueMap.value}">
								           <td>${valueList}</td>
								      </c:forEach>
								         <tr>
								</table> 
                			</td>
                			</c:forEach>
                			</tr>
                		</tbody>
                	</c:forEach>
                </table> 
                </div>
                </div>
                </div>
                <p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
			</div>

	<script type="text/javascript">
        $(function () {
			$('table').footable();

					$('#change-page-size').change(function (e) {
						e.preventDefault();
						var pageSize = $(this).val();
						$('.footable').data('page-size', pageSize);
						$('.footable').trigger('footable_initialized');
					});

					$('#change-nav-size').change(function (e) {
						e.preventDefault();
						var navSize = $(this).val();
						$('.footable').data('limit-navigation', navSize);
						$('.footable').trigger('footable_initialized');
					});
        });
    </script>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
