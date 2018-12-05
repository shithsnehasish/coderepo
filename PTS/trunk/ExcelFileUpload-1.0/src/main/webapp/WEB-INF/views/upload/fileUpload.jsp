<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta name="keywords"
	content="admin template, admin dashboard, inbox templte, calendar template, form validation">
<meta name="author" content="DazeinCreative">
<meta name="description"
	content="ADMS - Powerfull and Massive Admin Dashboard Template with tonns of useful features">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ADMS WebApps PTS</title>
<jsp:include page="../common/include-ext.jsp" />
<jsp:include page="../common/include-css.jsp" />
</head>
<body>
	<!--Smooth Scroll-->
	<div class="smooth-overflow">
		<jsp:include page="../common/navigation.jsp" />
		<!--MainWrapper-->
		<div class="main-wrap">
			<%-- <jsp:include page="../common/off-canvas-page.jsp" />
			<jsp:include page="../common/main-menu-page.jsp" /> --%>
			<div class="content-wrapper">

				<%-- <jsp:include page="../common/breadcrumb-page.jsp" /> --%>
				<nav class="cbp-hsmenu-wrapper" id="cbp-hsmenu-wrapper">
				<div class="cbp-hsinner"></div>
				</nav>
				<div class="row" id="powerwidgets">

					<div class="col-md-12 bootstrap-grid col-margin">

						<div class="powerwidget blue" id="datatable-basic-init"
							data-widget-editbutton="false">
							<header>
							<h2>
								PTS<small>UPLOAD FORM</small>
							</h2>
							</header>
							<div class="inner-spacer">
								<form action="upload.dell" method="POST" id="excelUpload-form"
									class="orb-form" enctype="multipart/form-data">
									Please select a file to upload : <input type="file" name="file" />
									<input type="submit" value="upload" />
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- / Content Wrapper -->
		</div>
		<!--/MainWrapper-->
	</div>
	<!--/Smooth Scroll-->
	<!-- scroll top -->
	<div class="scroll-top-wrapper hidden-xs">
		<i class="fa fa-angle-up"></i>
	</div>
	<!-- /scroll top -->
	<jsp:include page="../common/model-page.jsp" />

	<jsp:include page="../common/include-js.jsp" />
</body>
</html>