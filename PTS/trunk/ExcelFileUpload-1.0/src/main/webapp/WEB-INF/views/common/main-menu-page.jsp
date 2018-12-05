<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Main Menu-->
<div class="responsive-admin-menu">
	<div class="responsive-menu">
		Excel File Upload
		<div class="menuicon">
			<i class="fa fa-angle-down"></i>
		</div>
	</div>
	<ul id="menu">
		<c:forEach items="${menuMap}" var="menu">
			<c:set var="currentPage" value="/${menu.value}" />
			<c:set var="currentPageFromRequest"
				value="${requestScope['javax.servlet.forward.servlet_path']}" />
			<c:if test="${currentPage eq currentPageFromRequest}">
				<li><a class="active" href="${menu.value}" title="${menu.key}"
					data-id="dash-sub"><i class="entypo-folder"></i><span>
							${menu.key}</span></a></li>
			</c:if>
			<c:if test="${currentPage ne currentPageFromRequest}">
				<li><a href="${menu.value}" title="${menu.key}"
					data-id="dash-sub"><i class="entypo-folder"></i><span>
							${menu.key}</span></a></li>
			</c:if>

			<!-- <li><a class="submenu" href="#" title="Baseline" data-id="widgets-sub"><i class="entypo-folder"></i><span> Baseline</span></a>
          <ul id="widgets-sub">
            <li><a href="#" title="Configuration"><i class="entypo-folder"></i><span> Configuration</span></a></li>
            <li><a href="#" title="Content"><i class="entypo-folder"></i><span> Content</span></a></li>
            <li><a href="#" title="Dependency"><i class="entypo-folder"></i><span> Dependency</span></a></li>
            <li><a href="#" title="Technology"><i class="entypo-folder"></i><span> Technology</span></a></li>
            <li><a href="#" title="Capability"><i class="entypo-folder"></i><span> Capability</span></a></li>
            <li><a href="#" title="Complexity"><i class="entypo-folder"></i><span> Complexity</span></a></li>
          </ul>
        </li> -->
		</c:forEach>
		<!--  <li><a   href="" title="Projects" data-id="dash-sub"><i class="entypo-folder"></i><span> Projects</span></a></li>
       <li><a href="" title="Reports" data-id="dash-sub"><i class="entypo-folder"></i><span> Reports</span></a></li>
       <li><a href="" title="Users" data-id="dash-sub"><i class="entypo-folder"></i><span> Users</span></a></li>
       <li><a href="" title="Roles" data-id="dash-sub"><i class="entypo-folder"></i><span> Roles</span></a></li>
       <li><a href="" title="Server Settings" data-id="dash-sub"><i class="entypo-folder"></i><span> Server Settings</span></a></li> -->
	</ul>

</div>
<!--/MainMenu-->


