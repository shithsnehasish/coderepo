<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Navigation-->
<nav class="main-header clearfix" role="navigation">
	<a class="navbar-brand" href="#"><span
		class="text-blue">Excel File Upload</span></a>

	<!--Search-->
	<!--  <div class="site-search">
      <form action="#" id="inline-search">
        <i class="fa fa-search"></i>
        <input type="search" placeholder="Search">
      </form>
    </div> -->

	<!--Navigation Itself-->

	<div class="navbar-content">

		<!--Sidebar Toggler-->
		<!--   <a href="#" class="btn btn-default left-toggler"><i class="fa fa-bars"></i></a>  -->
		<!--Right Userbar Toggler-->
		<!--  <a href="#" class="btn btn-user right-toggler pull-right"><i class="entypo-vcard"></i> <span class="logged-as hidden-xs">Logged as</span><span class="logged-as-name hidden-xs">ADMS COE Team</span></a>  -->
		<!--Fullscreen Trigger-->
		<button type="button" class="btn btn-default hidden-xs pull-right"
			id="toggle-fullscreen">
			<i class=" entypo-popup"></i>
		</button>
		<button type="button"
			class="btn btn-default hidden-xs pull-right logout">
			<i class="fa fa-power-off"></i>
		</button>
		<!--Settings Dropdown-->
		<!-- <div class="btn-group pull-right">
        <div id="settings-dropdown" class="dropdown-menu keep_open orb-form">
          <div class="dropdown-header">Settings <span class="badge pull-right">6</span></div>
          <div class="dropdown-container">
            <div class="nano">
              <div class="nano-content">
                <ul class="settings-dropdown">
                  <li>
                    <label class="toggle">
                      <input type="checkbox" name="checkbox-toggle" checked>
                      <i></i>Prevent Midnblow</label>
                  </li>
                  <li>
                    <label class="toggle">
                      <input type="checkbox" name="checkbox-toggle" checked>
                      <i></i>Sleep All nights</label>
                  </li>
                  <li>
                    <label class="toggle">
                      <input type="checkbox" name="checkbox-toggle" checked>
                      <i></i>Drink more Coffee</label>
                  </li>
                  <li>
                    <label class="toggle">
                      <input type="checkbox" name="checkbox-toggle" checked>
                      <i></i>Auto feed cat</label>
                  </li>
                  <li>
                    <label class="toggle">
                      <input type="checkbox" name="checkbox-toggle" checked>
                      <i></i>Dummy Checkbox</label>
                  </li>
                  <li>
                    <label class="toggle">
                      <input type="checkbox" name="checkbox-toggle" checked>
                      <i></i>Read More Books</label>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="dropdown-footer"> <a class="btn btn-dark" href="#">Save</a> </div>
        </div>
      </div> -->

		<!--Lock Screen-->
		<!--  <a href="#" data-toggle="modal" class="btn btn-default hidden-xs pull-right lockme"> <i class="entypo-lock"></i> </a>  -->

		<!--Notifications Dropdown-->

		<!--  <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> <i class="entypo-megaphone"></i><span class="new"></span></button>
        <div id="notification-dropdown" class="dropdown-menu">
          <div class="dropdown-header">Notifications <span class="badge pull-right">8</span></div>
          <div class="dropdown-container">
            <div class="nano">
              <div class="nano-content">
                <ul class="notification-dropdown">
                  <li class="bg-warning"><a href="#"> <span class="notification-icon"><i class="fa fa-bolt"></i></span>
                    <h4>Server Down</h4>
                    <p>Server #435 was shut down (Power loss)</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 59 mins ago</span> </a> </li>
                  <li class="bg-info"><a href="#"> <span class="notification-icon"><i class="fa fa-bolt"></i></span>
                    <h4>Too Many Connections</h4>
                    <p>Too many connections to Database Server</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 2 hours ago</span> </a> </li>
                  <li class="bg-danger"><a href="#"> <span class="notification-icon"><i class="fa fa-android"></i></span>
                    <h4>Sausage Stolen</h4>
                    <p>Someone stole your hot sausage</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 3 hours ago</span> </a> </li>
                  <li class="bg-success"><a href="#"> <span class="notification-icon"><i class="fa fa-bolt"></i></span>
                    <h4>Defragmentation Completed</h4>
                    <p>Disc Defragmentation Completed on Server</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 3 hours ago</span> </a> </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="dropdown-footer"><a class="btn btn-dark" href="#">See All</a></div>
        </div>
      </div> -->

		<!--Inbox Dropdown-->
		<%--  <div class="btn-group">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><i class="entypo-mail"></i><span class="new"></span></button>
        <div id="inbox-dropdown" class="dropdown-menu inbox">
          <div class="dropdown-header">Inbox <span class="badge pull-right">32</span></div>
          <div class="dropdown-container">
            <div class="nano">
              <div class="nano-content">
                <ul class="inbox-dropdown">
                  <li><a href="#"> <span class="user-image"><img src="<c:url value="/resources/images/150x150.gif" />" alt="Gluck Dorris" /></span>
                    <h4>Why don't u answer calls?</h4>
                    <p>Listen, dude, time is off. I'll find you soon! Sounds good?...</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 59 mins ago</span> <span class="delete"><i class="entypo-back"></i></span> </a> </li>
                  <li><a href="#"> <span class="user-image"><img src="<c:url value="/resources/images/150x150.gif" />" alt="Gluck Dorris" /></span>
                    <h4>Rawrr, rawrrr...</h4>
                    <p>Listen, dude, time is off. I'll find you soon! Sounds good?...</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 2 hours ago</span> <span class="delete"><i class="entypo-back"></i></span> </a> </li>
                  <li><a href="#"> <span class="user-image"><img src="<c:url value="/resources/images/150x150.gif" />" alt="Gluck Dorris" /></span>
                    <h4>Why so serious?</h4>
                    <p>Listen, dude, time is off. I'll find you soon! Sounds good?...</p>
                    <span class="label label-default"><i class="entypo-clock"></i> 3 hours ago</span> <span class="delete"><i class="entypo-back"></i></span> </a> </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="dropdown-footer"><a class="btn btn-dark" href="admin-inbox.html">Save All</a></div>
        </div>
      </div> --%>
	</div>
</nav>

<!--/Navigation-->

