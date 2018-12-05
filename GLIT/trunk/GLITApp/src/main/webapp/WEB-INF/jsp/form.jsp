<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>GLIT | Form List</title>
	<meta name="viewport"
		content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />
	<link href="GLITApp/../css/bootstrap.css" rel="stylesheet"
		type="text/css" />
		<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		
		<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
		<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
		type="text/css" />
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
		type="text/javascript"></script>
	<script>
		if (!window.jQuery) {
			document.write('<script src="js/jquery-1.9.1.min.js"><\/script>');
		}
	</script>
	<script src="GLITApp/../js/bootstrap-tab.js" type="text/javascript"></script>
	<script src="GLITApp/../js/demos.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/css/breadcrumb.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/resources/syntax/shCore.css">
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
		<div style="width:95%;padding:16px 0px 0px 66px">
		
						
		 <div>
		<div class="breadcrumb flat" style="width:100%;">
	<a href="client.spring">Client Details</a>
	<a href="#" class="active">Form Details</a>
	
</div>				
                        </div>
						</div>
			 
		    				
				<div class="content-grids">
				<div style="width:95%;padding:16px 0px 0px 66px">
		    	<div class="section group">
			<c:if test="${role eq 'ROLE_ADMIN' }">
				
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<a href="addform.spring?formId=0">  <img src="../GLITApp/assets/images/new form.png"></a>
					</div>
					<div class="text list_1_of_2">
						 <a href="addform.spring?formId=0" style="text-decoration: none;"> <h3>New Form</h3></a>
						<a href="addform.spring?formId=0" style="text-decoration: none;"> <p>Need More info?</p></a>
						  <div class="button"><span><a href="addform.spring?formId=0">View More</a></span></div>
				     </div>
				</div>	
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<a href="copyClientForm.spring">  <img src="../GLITApp/assets/images/copy form.png"></a>
					</div>
					<div class="text list_1_of_2">
						<a href="copyClientForm.spring" style="text-decoration: none;">  <h3>Copy Form</h3></a>
						<a href="copyClientForm.spring" style="text-decoration: none;">  <p>Need More info?</p></a>
						  <div class="button"><span><a href="copyClientForm.spring">View More</a></span></div>
				     </div>
				</div>
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<a href="uploadExcel.spring?value=false">  <img src="../GLITApp/assets/images/import.png"></a>
					</div>
					<div class="text list_1_of_2">
						<a href="uploadExcel.spring?value=false" style="text-decoration: none;">  <h3>Import</h3></a>
					<a href="uploadExcel.spring?value=false" style="text-decoration: none;">	  <p>Need More info?</p></a>
						  <div class="button"><span><a href="uploadExcel.spring?value=false">View More</a></span></div>
				     </div>
				</div>			
					</c:if>		
					<div class="listview_1_of_3 images_3_of_3">
					<div class="listimg listimg_1_of_2">
						 <a href="questionnaire.spring"> <img src="../GLITApp/assets/images/questionnaire.png"></a>
					</div>
					<div class="text list_1_of_2">
						<a href="questionnaire.spring" style="text-decoration: none;">  <h3>Questionnaire</h3></a>
						 <a href="questionnaire.spring" style="text-decoration: none;"> <p>Need More info?</p></a>
						  <div class="button"><span><a href="questionnaire.spring">View More</a></span></div>
				     </div>
				</div>	
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						 <a href="selectDashboard.spring"> <img src="../GLITApp/assets/images/dashboard.png"></a>
					</div>
					<div class="text list_1_of_2">
						<a href="selectDashboard.spring" style="text-decoration: none;">  <h3>Dashboard</h3></a>
						<a href="selectDashboard.spring" style="text-decoration: none;">  <p>Need More info?</p></a>
						  <div class="button"><span><a href="selectDashboard.spring">View More</a></span></div>
				     </div>
				</div>	
			</div>
		    </div>
		   </div>
			<c:choose>
				<c:when test="${formListSize ne 0 }">
				<div style="width: 95%;padding: 16px 0px 0px 66px;">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            Form List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
                            <div class="table-responsive">
					<table id="example" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th align="left">Form Name</th>
								<th align="left">Total Form Data</th>
								<th align="left">Total Form Fields</th>
								<th align="left">&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${formList}" var="form">
								<tr>
									<td><a href="formdata.spring?formId=${form.formId}">${form.formName}</a></td>
									<td>${form.totalEntries }</td>
									<td>${form.totalFields }</td>
									<td><c:if test="${role eq 'ROLE_ADMIN' }">
											<c:choose>
												<c:when
													test="${form.totalEntries ne 0}">
													<p style="color: grey; display: inline">
														<a href="copyform.spring?formId=${form.formId}"><img alt="Copy" title="Copy" src="../GLITApp/images/copy.png"></a> |
														<a href="disabledform.spring?formId=${form.formId}">  <img alt="Edit" title="Edit" src="../GLITApp/images/edit-disabled.png"> </a>| <img alt="Delete" title="Delete" src="../GLITApp/images/delete-disabled.png">
													</p>
												</c:when>
												<c:otherwise>
													<a href="copyform.spring?formId=${form.formId}"><img alt="Copy" title="Copy" src="../GLITApp/images/copy.png"></a> | <a
														href="addform.spring?formId=${form.formId}"><img alt="Edit" title="Edit" src="../GLITApp/images/edit.png"></a> | <a
														href="deleteForm.spring?formId=${form.formId}"
														onclick="return confirm('Do you really want to delete?')"><img alt="Delete" title="Delete" src="../GLITApp/images/delete.png"></a>
												</c:otherwise>
											</c:choose>
										</c:if>
										<c:if test="${role ne 'ROLE_ADMIN' }">
											<p style="color: grey; display: inline"><img alt="Copy" title="Copy" src="../GLITApp/images/copy-disabled.png"> |<a href="disabledform.spring?formId=${form.formId}"> <img alt="Edit" title="Edit" src="../GLITApp/images/edit-disabled.png"></a> | <img alt="Delete" title="Delete" src="../GLITApp/images/delete-disabled.png"> </p>
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
				</c:when>
				<c:otherwise>
				<div style="width: 95%;padding: 16px 0px 0px 66px;">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            Form List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
					<table>
						<tr>
							<td>No Records to Display</td>
						</tr>
					</table>
					</div>
					</div>
					</div>
				</c:otherwise>
			</c:choose>
			<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>