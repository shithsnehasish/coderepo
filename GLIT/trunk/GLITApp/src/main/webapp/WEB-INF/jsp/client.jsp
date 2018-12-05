<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>GLIT | Client</title>
	<meta name="viewport"
		content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no" />
	<link href="GLITApp/../css/bootstrap.css" rel="stylesheet" type="text/css"/>
    		<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		
		<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
		<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
		type="text/css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
    <script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
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
			$('#example').dataTable( {
				"scrollY": 200,
				"scrollX": true
			} );
		} );
	</script>
	 <script src="../GLITApp/js/prefixfree.min.js"></script>
</head>
<body >
	<div class="demo-container">
		<jsp:include page="header.jsp"></jsp:include>
		<div style="width:95%;padding:16px 0px 0px 66px">
		
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
	<a href="#" class="active">Client Details</a>
	
</div>
        
                        </div>
                        </div>
			<c:choose>
				<c:when test="${role eq 'ROLE_ADMIN' }">
				 <div class="content-grids">
		    	<div style="width:95%;padding:16px 0px 0px 66px">
		    	<div class="section group">
							
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<a href="addclientform.spring">  <img src="../GLITApp/assets/images/grid-img2.png"></a>
					</div>
					<div class="text list_1_of_2">
						<a href="addclientform.spring" style="text-decoration: none;">  <h3>New Client</h3></a>
						<a href="addclientform.spring" style="text-decoration: none;">  <p>Need More info?</p></a>
						  <div class="button"><span><a href="addclientform.spring">View More</a></span></div>
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
			<c:choose>
				<c:when test="${clientListSize eq 0 }">
				<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            Client List
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
				<div style="width: 95%;padding: 16px 0px 0px 66px;">
				<div class="panel panel-default">
                        <div class="panel-heading">
                            Client List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
                            <div class="table-responsive">
					<table id="example" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th align="left">Name</th>
								<th align="left">Address</th>
								<th align="left">E-Mail Address</th>
								<th align="left">Client SPOC</th>
								<th align="left">Contact No.</th>
								<th align="left"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${clientList }" var="client">
								<tr>
									<td><a href="form.spring?clientId=${client.clientId}">${client.clientName }</a></td>
									<td>${client.clientAddress }</td>
									<td>${client.clientEmail }</td>
									<td>${client.clientSPOCName }</td>
									<td>${client.clientContactNo }</td>
									<td>
									<c:if test="${role eq 'ROLE_ADMIN' }">
										<a href="editClient.spring?clientId=${client.clientId}"><img alt="Edit" title="Edit" src="../GLITApp/images/edit.png"></a> |
										<a href="deleteClient.spring?clientId=${client.clientId}"
											onclick="return confirm('Do you really want to delete?')"><img alt="Delete" title="Delete" src="../GLITApp/images/delete.png"></a>
									</c:if>
									<c:if test="${role ne 'ROLE_ADMIN' }">
										<p style="color: grey; display: inline"><img alt="Edit" title="Edit" src="../GLITApp/images/edit-disabled.png"> | <img alt="Delete" title="Delete" src="../GLITApp/images/delete-disabled.png"> </p>
									</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
					</div>
					</div></div>
				</c:otherwise>
			</c:choose>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
