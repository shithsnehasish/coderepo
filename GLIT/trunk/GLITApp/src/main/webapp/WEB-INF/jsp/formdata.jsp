<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>GLIT | Form Data</title>
    <meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no"/>
	<link href="GLITApp/../css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="GLITApp/../css/footable.core.css?v=2-0-1" rel="stylesheet" type="text/css"/>
    <link href="GLITApp/../css/footable-demos.css" rel="stylesheet" type="text/css"/>
    		<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		
		<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
    <script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
    <link rel="stylesheet" type="text/css"
		href="../GLITApp/css/breadcrumb.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/resources/syntax/shCore.css">
	<link rel="stylesheet" type="text/css"
		href="../GLITApp/resources/demo.css">
		<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		
		<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
		<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
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
	<script src="GLITApp/../js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="GLITApp/../js/demos.js" type="text/javascript"></script>
</head>
<body>
	<div class="demo-container">
	<jsp:include page="header.jsp"></jsp:include>
		 		<div style="width:95%;padding:16px 0px 0px 66px">
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
			<a href="client.spring">Client Details</a>
            <a href="form.spring?clientId=${clientId}">Form Details</a>
            <a href="#" class="active">Form Data</a>
	
</div>
        
                        </div>
                        </div>

			<c:choose>
				<c:when test="${role eq 'ROLE_USER' }">
					&nbsp;&nbsp;&nbsp;				
				</c:when>
				<c:otherwise>
				<div class="content-grids">
		    	<div style="width:95%;padding:16px 0px 0px 66px">
		    	<div class="section group">
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						 <a href="displayform.spring?formId=${formId}&dataId=0"> <img src="../GLITApp/assets/images/new form.png"></a>
					</div>
					<div class="text list_1_of_2">
						 <a href="displayform.spring?formId=${formId}&dataId=0" style="text-decoration: none"> <h3>Form Data</h3></a>
						 <a href="displayform.spring?formId=${formId}&dataId=0" style="text-decoration: none"> <p>Need More info?</p></a>
						  <div class="button"><span><a href="displayform.spring?formId=${formId}&dataId=0">View More</a></span></div>
				     </div>
				</div>	
				</div>
				</div>
				</div>
				</c:otherwise>
			</c:choose>
				<c:choose>
					<c:when test="${formDataArrayStringSize eq 0}">
					<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            <strong>${form.formName}</strong> Data Entries
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
					</c:when>
					<c:otherwise>
					<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            <strong>${form.formName}</strong> Data Entries
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
					<table id="example" class="display" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Id</th>
								<c:forEach var="formField" items="${formFields}">
									<th>
										${formField.fieldName}
									</th>
								</c:forEach>
									<th>
									</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="formDataArray" items="${formDataArrayStrings}" >
		    					<tr>
			    					<c:forEach var="formData" items="${formDataArray}" varStatus="iterator" >
										<td> ${formData} </td>
			    					</c:forEach>
									<td>
										<c:if test="${role ne 'ROLE_USER' }">
											<a href="displayform.spring?formId=${formId}&dataId=${formDataArray[0]}" onclick="return confirm('Do you really want to edit?')"><img alt="Edit" title="Edit" src="../GLITApp/images/edit.png"></a>
											<c:choose>
												<c:when test="${isClientHaveQuestionaire}">
													|<span style="color: grey;" ><img alt="Delete" title="Delete" src="../GLITApp/images/delete-disabled.png"></span>
												</c:when>
												<c:otherwise>
													|&nbsp;<a href="deleteFormData.spring?formId=${formId}&dataId=${formDataArray[0]}" onclick="return confirm('Do you really want to delete?')"><img alt="Delete" title="Delete" src="../GLITApp/images/delete.png"></a>
												</c:otherwise>
											</c:choose>
										</c:if>
										<c:if test="${role eq 'ROLE_USER' }">
											<p style="color: grey;"><img alt="Edit" title="Edit" src="../GLITApp/images/edit-disabled.png">|<img alt="Delete" title="Delete" src="../GLITApp/images/delete-disabled.png"></p>
										</c:if>
									</td>
								</tr>
							</c:forEach>
							</tbody>
				</table>
				</div>
				</div>
				</div>
					</c:otherwise>
				</c:choose>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
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
