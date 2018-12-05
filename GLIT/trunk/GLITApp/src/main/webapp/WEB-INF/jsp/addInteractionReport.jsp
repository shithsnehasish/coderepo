<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GLIT | Add Questionnaire</title>
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
	if (!window.jQuery) {
		document.write('<script src="js/jquery-1.9.1.min.js"><\/script>');
	}
</script>
<script src="js/bootstrap-tab.js" type="text/javascript"></script>
<script src="js/demos.js" type="text/javascript"></script>
<link href="../GLITApp/assets/css/style.css" rel="stylesheet"
	type="text/css" media="all" />

<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
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
						href="questionnaire.spring">Questionnaire Details</a> <a
						href="interActionReport.spring?qId=${questionaireId}">Interaction
						Report </a> <a href="#" class="active">Add Interaction </a>


				</div>

			</div>
		</div>

		<c:choose>
			<c:when test="${questionaireListSize eq 0 }">
				<div style="width: 95%; padding: 16px 0px 0px 66px">
					<div class="panel panel-default">
						<div class="panel-heading">Add Interaction</div>
						<!-- /.panel-heading -->
						<div class="panel-body" style="background-color: #F1F6F9">
							<table>
								<tr>
									<td>No Forms to Display</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div style="width: 95%; padding: 16px 0px 0px 66px">
					<div class="panel panel-default">
						<div class="panel-heading">Add Interaction</div>
						<!-- /.panel-heading -->
						<form action="submitInteractionReport.spring" method="post"
							onsubmit="return validate(this)">
							<div class="panel-body" style="background-color: #F1F6F9">
								<c:forEach var="questionaire" items="${questionaireList}">
									<div style="width: 95%; padding: 16px 0px 0px 66px">
										<div class="panel panel-default">
											<div class="panel-heading">${questionaire.name}</div>
											<div class="pane-body">
												<table
													style="border-left: 1px solid #000000; border-right: 1px solid #000000; border-top: 1px solid #000000">
													<tr align="left"
														style="border-left: 1px solid #000000; border-right: 1px solid #000000; border-top: 1px solid #000000">
														<c:forEach items="${questionaire.fieldUtilList }"
															var="fieldUtil">
															<th align="left" style="border: 1px solid #000000;">${fieldUtil.fieldName}</th>
														</c:forEach>
													</tr>
													<tr
														style="border-left: 1px solid #000000; border-right: 1px solid #000000; border-bottom: 1px solid #000000;">
														<c:forEach items="${questionaire.fieldUtilList }"
															var="fieldUtils">
															<td>
																<table>
																	<c:forEach items="${fieldUtils.formDataValues}"
																		var="values">
																		<c:choose>
																			<c:when test="${fieldUtils.multiselect}">

																				<tr style="border-left: 1px solid #000000;">
																					<td><input type="checkbox" required
																						id="${ fieldUtils.fieldId}"
																						name="${ fieldUtils.fieldId}"
																						value="${values.formValueId}" />${values.value}</td>
																				</tr>
																			</c:when>
																			<c:otherwise>
																				<tr>
																					<td><input type="radio" required
																						id="${ fieldUtils.fieldId}"
																						name="${ fieldUtils.fieldId}"
																						value="${values.formValueId}" />${values.value}</td>
																				</tr>

																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																</table>
															</td>
														</c:forEach>
													</tr>
												</table>
											</div>
										</div>
									</div>
									<br />

								</c:forEach>

								<br />
							</div>
							<div class="panel-footer">
								<table>
									<tr>

										<td><span class="divider">&nbsp; </span></td>
										<td><input type="reset" value="Reset" class="myButton" />&nbsp;</td>
										<td><input type="submit" value="Add Interaction"
											class="myButton" id="add" /></td>
									</tr>
								</table>
								<input type="hidden" name="questionaireId"
									value="${questionaireId}" />
							</div>
						</form>
					</div>
				</div>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</c:otherwise>
		</c:choose>
	</div>
	<script type="text/javascript">
		var validate = (function() {
			var reClass = /(^|\s)required(\s|$)/; // Field is required
			var reValue = /^\s*$/; // Match all whitespace

			return function(form) {
				var elements = form.elements;
				var el;

				for (var i = 0, iLen = elements.length; i < iLen; i++) {
					el = elements[i];

					if (reClass.test(el.className) && reValue.test(el.value)) {
						// Required field has no value or only whitespace
						// Advise user to fix
						alert('Selection of all fields are mandatory ! ');
						return false;
					}
				}
			}
		}());
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
