<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Breadcrumb-->
<div class="breadcrumb clearfix">
	<ul>
		<li><a href="estimation.dell"><i class="fa fa-home"></i></a></li>
		<c:forEach items="${pageMap}" var="page">
			<li><a href="${page.value}">${page.key}</a></li>
		</c:forEach>
		<li class="active">${currentPage}</li>
	</ul>
</div>
<!--/Breadcrumb-->

