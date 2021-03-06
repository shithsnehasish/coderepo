<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Jumbotron-->
<div class="jumbotron jumbotron6">
	<h1>
		Welcome 2 <strong>ADMS</strong>
	</h1>
	<p class="lead">ADMS &#8212; fully responsive admin template
		powered by BootStrap 3 Framework. ADMS is packed with tons of
		accurately styled and predefined components, plugins and features that
		can be used in creation of admin dashboards, CRM and CMS panels.</p>
	<small>ADMS has own premium and unique features, such as
		powerfull <a href="admin-widgets.html">ADMS Widgets</a>, <a
		href="admin-portlets.html">Portlets Gallery</a>, <a
		href="admin-inbox.html">Prototyped Inbox</a>, <a
		href="admin-forms-validation.html">Form Validation and AJAX
			Processing</a>, <a href="admin-animation.html">revised Bootstrap
			Modal and Popover</a> classes and much more. ADMS is also bundled with 6
		predefined styles.
	</small>
	<p>
		<a href="http://dell.com" class="btn margin-top btn-danger"><i
			class="fa fa-star"></i> Check Dell Services</a>
	</p>
</div>
<!--/Jumbotron-->

<!-- Widget Row Start grid -->
<div class="row" id="powerwidgets">
	<div class="col-md-12 bootstrap-grid">

		<!-- New widget -->

		<div class="powerwidget powerwidget-as-portlet-white"
			id="serverstatuz-indexpage2">
			<header>
				<h2>
					Source Geo<small>Money!</small>
				</h2>
			</header>
			<div>
				<div class="powerwidget-editbox">
					<div>
						<label>Title:</label> <input class="form-control" type="text" />
					</div>
					<div>
						<label>Styles:</label> <span data-widget-setstyle="pink"
							class="pink-btn"></span> <span data-widget-setstyle="blue"
							class="blue-btn"></span> <span data-widget-setstyle="dark-blue"
							class="dark-blue-btn"></span> <span data-widget-setstyle="green"
							class="green-btn"></span> <span data-widget-setstyle="green-alt"
							class="green-alt-btn"></span> <span
							data-widget-setstyle="green-acid" class="green-acid-btn"></span>
						<span data-widget-setstyle="yellow" class="yellow-btn"></span> <span
							data-widget-setstyle="purple" class="purple-btn"></span> <span
							data-widget-setstyle="cold-grey" class="cold-grey-btn"></span> <span
							data-widget-setstyle="dark-cold-grey" class="dark-cold-grey-btn"></span>
						<span data-widget-setstyle="orange" class="orange-btn"></span> <span
							data-widget-setstyle="red" class="red-btn"></span> <span
							data-widget-setstyle="dark-red" class="dark-red-btn"></span> <span
							data-widget-setstyle="black" class="black-btn"></span>
					</div>
				</div>
				<div class="inner-spacer">
					<div class="row">
						<!--Row-->

						<div class="col-md-12">
							<div class="flotchart-container  margin-negative-top-10px">
								<div id="placeholder9" class="flotchart-placeholder"></div>
							</div>
							<div class="row margin-bottom-10px">
								<ul class="countries-demo" id="choices">
									<li class="col-md-2 col-sm-4">
										<h3>
											UK <span class="label bg-marine"><i
												class="fa fa-caret-up"></i> 22%</span>
										</h3>
										<div class="orb-form">
											<label class="toggle" for="iduk"> <input name="uk"
												checked id="iduk" type="checkbox"> Uncheck to hide </input>
												<i></i></label>
										</div>
									</li>
									<li class="col-md-2 col-sm-4">
										<h3>
											Japan <span class="label bg-red"><i
												class="fa fa-caret-down"></i> 5%</span>
										</h3>
										<div class="orb-form">
											<label class="toggle" for="idjapan"> <input
												name="japan" checked id="idjapan" type="checkbox">
												Uncheck to hide </input> <i></i></label>
										</div>
									</li>
									<li class="col-md-2 col-sm-4">
										<h3>
											USA <span class="label bg-marine"><i
												class="fa fa-caret-up"></i> 16%</span>
										</h3>
										<div class="orb-form">
											<label class="toggle" for="idusa"> <input name="usa"
												checked id="idusa" type="checkbox"> Uncheck to hide
												</input> <i></i></label>
										</div>
									</li>
									<li class="col-md-2 col-sm-4">
										<h3>
											Russia <span class="label bg-marine"><i
												class="fa fa-caret-up"></i> 7%</span>
										</h3>
										<div class="orb-form">
											<label class="toggle" for="idrussia"> <input
												name="russia" checked id="idrussia" type="checkbox">
												Uncheck to hide </input> <i></i></label>
										</div>
									</li>
									<li class="col-md-2 col-sm-4">
										<h3>
											China <span class="label bg-marine"><i
												class="fa fa-caret-up"></i> 1%</span>
										</h3>
										<div class="orb-form">
											<label class="toggle" for="idchina"> <input
												name="china" checked id="idchina" type="checkbox">
												Uncheck to hide </input> <i></i></label>
										</div>
									</li>
									<li class="col-md-2 col-sm-4">
										<h3>
											Others <span class="label bg-red"><i
												class="fa fa-caret-down"></i> 13%</span>
										</h3>
										<div class="orb-form">
											<label class="toggle" for="idothers"> <input
												name="others" checked id="idothers" type="checkbox">
												Uncheck to hide </input> <i></i></label>
										</div>
									</li>
								</ul>
							</div>
							<!--/Row-->

						</div>
						<!--/Col-md-12-->
					</div>
					<!--/Row-->

				</div>
			</div>
		</div>

		<!-- End .powerwidget -->

		<!-- New widget-->
		<div class="powerwidget cold-grey" id="calendar-widget-index2"
			data-widget-editbutton="false">
			<header>
				<h2>
					Calendar<small>Events</small>
				</h2>
			</header>
			<div class="inner-spacer">
				<div class="row">
					<div class="col-md-8">
						<div id='calendar2'></div>
					</div>
					<div class="col-md-4">

						<!--Calendar-->
						<div class="calendar-day-block">
							<div class="day-block">
								<p class="week-day">Saturday</p>
								<p class="day">28</p>
								<p class="month-year">June 2014</p>
								<div class="btn-group">
									<button class="btn btn-default btn-sm">
										<i class="fa fa-plus-circle"></i> Add Event
									</button>
									<button class="btn btn-default btn-sm">
										<i class="fa fa-gift"></i> Birthdays
									</button>
								</div>
							</div>
							<form action="" id="data-pickers" class="orb-form bg-blue">
								<fieldset>
									<section>
										<div id="inline"></div>
									</section>
							</form>
						</div>
						<!--/calendar-day-block-->

						<div class="weather-block bg-blue">
							<div class="weather-current-city">
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-6">
										<span class="current-city">London, GB <span
											class="badge bg-blue"><i class="fa fa-clock-o"></i>
												GMT+1</span></span><span class="current-temp">22&deg;C</span><span
											class="current-day">Saturday, 28 June</span>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-6">
										<span class="current-day-icon">
											<canvas id="clear-day" width="120" height="120"></canvas>
										</span>
									</div>
								</div>
							</div>
							<div class="row">
								<ul class="days">
									<li class="col-md-3 col-sm-3 col-xs-3"><strong>Tue</strong>
										<canvas id="snow" width="50" height="50"></canvas> <span>19&deg;</span></li>
									<li class="col-md-3 col-sm-3 col-xs-3"><strong>Fri</strong>
										<canvas id="rain" width="50" height="50"></canvas> <span>17&deg;</span></li>
									<li class="col-md-3 col-sm-3 col-xs-3"><strong>Sat</strong>
										<canvas id="sleet" width="50" height="50"></canvas> <span>23&deg;</span></li>
									<li class="col-md-3 col-sm-3 col-xs-3"><strong>Sun</strong>
										<canvas id="fog" width="50" height="50"></canvas> <span>21&deg;</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--End Widget -->

		<!-- New widget -->
		<div class="powerwidget blue" id="vectormap-index2"
			data-widget-editbutton="false">
			<header>
				<h2>
					Traffic Geo<small>Just Demo</small>
				</h2>
			</header>
			<div class="inner-spacer">
				<div class="row">
					<!--Row-->
					<div class="col-md-6">
						<div id="vmap" class="jqvmap"></div>
					</div>
					<div class="col-md-6">
						<div class="table-responsive">
							<table
								class="table table-striped table-hover margin-0px airtable">
								<thead>
									<tr>
										<th colspan="2">Country</th>
										<th>Source/Data</th>
										<th>Part</th>
										<th>Dinamic</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><span class="num">1</span></td>
										<td><h5>United States</h5> <small><i
												class="fa fa-clock-o"></i> Last Update</small> <span class="badge">12:20</span></td>
										<td><h5>
												Google<small class="text-muted">Google Analytics</small>
											</h5> <small><strong>589871 <span
													class="text-green">(567113)</span></strong> <i
												class="fa fa-caret-down"></i></small></td>
										<td class="text-center"><span
											class="table-sparkline-pie2">1,3,2,5,3</span></td>
										<td class="text-center"><span
											class="table-sparkline-lines">5,6,7,9,9,5,3,2,2,4,6,7</span></td>
									</tr>
									<tr>
										<td><span class="num">2</span></td>
										<td><h5>China</h5> <small><i
												class="fa fa-clock-o"></i> Last Update</small> <span class="badge">12:21</span></td>
										<td><h5>
												Google<small class="text-muted">Google Analytics</small>
											</h5> <small><strong>82871 <span
													class="text-green">(99143)</span></strong> <i class="fa fa-caret-up"></i></small></td>
										<td class="text-center"><span
											class="table-sparkline-pie2">3,3,2,1,5</span></td>
										<td class="text-center"><span
											class="table-sparkline-lines">9,3,3,2,4,5,6,2,8,4,9,0</span></td>
									</tr>
									<tr>
										<td><span class="num">3</span></td>
										<td><h5>Germany</h5> <small><i
												class="fa fa-clock-o"></i> Last Update</small> <span class="badge">12:22</span></td>
										<td><h5>
												Google<small class="text-muted">Google Analytics</small>
											</h5> <small><strong>589666 <span
													class="text-red">(542313)</span></strong> <i
												class="fa fa-caret-down"></i></small></td>
										<td class="text-center"><span
											class="table-sparkline-pie2">1,3,2,3,1</span></td>
										<td class="text-center"><span
											class="table-sparkline-lines">5,6,7,9,9,5,3,2,8,4,6,7</span></td>
									</tr>
									<tr>
										<td><span class="num">4</span></td>
										<td><h5>Russian Federation</h5> <small><i
												class="fa fa-clock-o"></i> Last Update</small> <span class="badge">12:23</span></td>
										<td><h5>
												Google<small class="text-muted">Google Analytics</small>
											</h5> <small><strong>589788 <span
													class="text-green">(508113)</span></strong> <i
												class="fa fa-caret-down"></i></small></td>
										<td class="text-center"><span
											class="table-sparkline-pie2">4,3,2,2,5</span></td>
										<td class="text-center"><span
											class="table-sparkline-lines">5,6,7,9,9,5,3,9,2,4,6,7</span></td>
									</tr>
									<tr>
										<td><span class="num">5</span></td>
										<td><h5>India</h5> <small><i
												class="fa fa-clock-o"></i> Last Update</small> <span class="badge">12:24</span></td>
										<td><h5>
												Google<small class="text-muted">Google Analytics</small>
											</h5> <small><strong>589871 <span
													class="text-blue">(567113)</span></strong> <i
												class="fa fa-caret-down"></i></small></td>
										<td class="text-center"><span
											class="table-sparkline-pie2">3,3,2,5,7</span></td>
										<td class="text-center"><span
											class="table-sparkline-lines">5,6,7,9,9,5,3,2,2,4,6,7</span></td>
									</tr>
									<tr>
										<td><span class="num">6</span></td>
										<td><h5>Antarctica</h5> <small><i
												class="fa fa-clock-o"></i> Last Update</small> <span class="badge">12:25</span></td>
										<td><h5>
												Google<small class="text-muted">Google Analytics</small>
											</h5> <small><strong>589871 <span
													class="text-green">(567113)</span></strong> <i
												class="fa fa-caret-up"></i></small></td>
										<td class="text-center"><span
											class="table-sparkline-pie2">2,3,2,2,6</span></td>
										<td class="text-center"><span
											class="table-sparkline-lines">5,6,7,2,4,5,1,2,8,4,6,9</span></td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<th colspan="2">Country</th>
										<th>Source</th>
										<th>Part</th>
										<th>Dynamic</th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
				<!--/Row-->
			</div>
		</div>
		<!-- End Widget -->

	</div>
	<div class="col-md-6 bootstrap-grid">

		<!-- New widget -->
		<div
			class="powerwidget powerwidget-as-portlet powerwidget-as-portlet-white"
			id="chatez-index" data-widget-editbutton="false">
			<header>
				<h2>
					Chat<small>Yeah!</small>
				</h2>
			</header>
			<div class="inner-spacer nopadding">
				<div class="chat-container">
					<div class="top-buttons clearfix">
						<h2 class="margin-0px pull-left">Chat</h2>
						<span class="badge">25</span>
						<div class="btn-group btn-group-sm pull-right">
							<a class="btn btn-default"><i class="fa fa-thumbs-down"></i>
								<span class="hidden-xs">Leave</span></a> <a class="btn btn-default"><i
								class="fa fa-times-circle"></i> <span class="hidden-xs">Clear</span></a>
						</div>
					</div>
					<nav class="chat-users-menu">

						<!--Adding Some Scroll-->
						<div class="nano">
							<div class="nano-content">
								<div class="menu-header">
									<a class="btn btn-default chat-toggler"><i
										class="fa fa-user"></i> <i class="fa fa-arrow-down"></i></a>
								</div>
								<ul>
									<li><a href="#"><span class="chat-name">Gluck
												Dorris</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span><span
											class="badge">5</span></a></li>
									<li><a href="#"><span class="chat-name">ADMS
												COE Team</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Spiderman</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Muchu</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-default">Offline</span></a></li>
									<li><a href="#"><span class="chat-name">Mr.
												Joker</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Chewbacca</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">The
												Piggy</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">ADMS
												COE Team</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Spiderman</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Muchu</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">ADMS
												COE Team</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Spiderman</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Muchu</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">ADMS
												COE Team</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Spiderman</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Muchu</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">ADMS
												COE Team</span><span class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-default">Offline</span></a></li>
									<li><a href="#"><span class="chat-name">Spiderman</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
									<li><a href="#"><span class="chat-name">Muchu</span><span
											class="user-img"><img
												src="<c:url value="/resources/images/150x150.gif" />"
												alt="User" /></span><span class="label label-success">Online</span></a></li>
								</ul>
							</div>
						</div>
					</nav>
					<div class="chat-container">
						<div class="chat-pusher">
							<div class="chat-content">
								<!-- this is the wrapper for the content -->
								<div class="nano">
									<!-- this is the nanoscroller -->
									<div class="nano-content">
										<div class="chat-content-inner">
											<!-- extra div for emulating position:fixed of the menu -->

											<!-- Top Navigation -->

											<div class="clearfix">
												<div class="chat-messages chat-messages-with-sidebar">
													<ul>
														<li class="left clearfix">
															<div class="user-img pull-left">
																<img
																	src="<c:url value="/resources/images/150x150.gif" />"
																	alt="User Avatar" />
															</div>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">Gluck Dorris</span><span
																		class="name"></span> <span class="badge"><i
																		class="fa fa-clock-o"></i>14 mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Praesent porttitor nulla vitae
																	interdum fermentum. Ut in vulputate neque. Praesent
																	luctus lacus a dolor tempus pellentesque. Cras sit amet
																	urna eu augue suscipit eleifend. Mauris mollis pharetra
																	faucibus. Phasellus eu massa quam. Nunc id metus
																	placerat neque feugiat commodo.</p>
															</div>
														</li>
														<li class="right clearfix"><span
															class="user-img pull-right"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">ADMS COE Team</span><span
																		class=" badge"><i class="fa fa-clock-o"></i>13
																		mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Curabitur bibendum ornare dolor, quis
																	ullamcorper ligula sodales.</p>
															</div></li>
														<li class="left clearfix"><span
															class="user-img pull-left"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" class="img-circle" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">Spiderman</span> <span class="badge"><i
																		class="fa fa-clock-o"></i>14 mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Curabitur bibendum ornare dolor, quis
																	ullamcorper ligula sodales.</p>
															</div></li>
														<li class="right clearfix"><span
															class="user-img pull-right"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" class="img-circle" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">Muchu</span><small class="badge"><i
																		class="fa fa-clock-o"></i>15 mins ago</small>
																</div>
																<p>Nunc ipsum dui, tempus id sagittis eu, rutrum ac
																	libero. Morbi non enim a tortor pulvinar feugiat at
																	consectetur nunc. Curabitur pulvinar tincidunt nisi id
																	bibendum. Nulla ut diam iaculis, venenatis velit
																	hendrerit, fringilla arcu. Mauris accumsan pulvinar
																	augue, non blandit justo vestibulum a. Proin non eros
																	semper, accumsan nisl in, imperdiet justo. Pellentesque
																	convallis commodo porttitor. Nam feugiat dignissim
																	felis sed tempor. Sed pretium eros nec mi semper
																	aliquam. Phasellus eget accumsan felis. Nulla varius
																	risus quis dapibus porta. Donec vel magna viverra,
																	semper velit eu, adipiscing arcu. Integer sollicitudin
																	elementum est eget ullamcorper. Mauris eget
																	sollicitudin erat. Nullam et lacinia nibh, a aliquam
																	nunc. Curabitur ullamcorper metus ac purus commodo, sit
																	amet mattis arcu mollis.</p>
															</div></li>
														<li class="left clearfix"><span
															class="user-img pull-left"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" class="img-circle" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">Gluck Dorris</span> <span
																		class="badge"><i class="fa fa-clock-o"></i>14
																		mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Curabitur bibendum ornare dolor, quis
																	ullamcorper ligula sodales.</p>
															</div></li>
														<li class="right clearfix"><span
															class="user-img pull-right"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" class="img-circle" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">ADMS COE Team</span><span
																		class=" badge"><i class="fa fa-clock-o"></i>13
																		mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Curabitur bibendum ornare dolor, quis
																	ullamcorper ligula sodales.</p>
															</div></li>
														<li class="left clearfix"><span
															class="user-img pull-left"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" class="img-circle" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">Spiderman</span> <span class="badge"><i
																		class="fa fa-clock-o"></i>14 mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Curabitur bibendum ornare dolor, quis
																	ullamcorper ligula sodales.</p>
															</div></li>
														<li class="right clearfix"><span
															class="user-img pull-right"> <img
																src="<c:url value="/resources/images/150x150.gif" />"
																alt="User Avatar" class="img-circle" />
														</span>
															<div class="chat-body clearfix">
																<div class="header">
																	<span class="name">Spiderman</span> <span class="badge"><i
																		class="fa fa-clock-o"></i>14 mins ago</span>
																</div>
																<p>Lorem ipsum dolor sit amet, consectetur
																	adipiscing elit. Curabitur bibendum ornare dolor, quis
																	ullamcorper ligula sodales.</p>
															</div></li>
													</ul>
												</div>
											</div>
										</div>

										<!-- /chat-content-inner -->
									</div>
								</div>

								<!-- /nano -->

							</div>

							<!-- /chat-content -->
						</div>
						<!-- /chat-pusher -->
					</div>
				</div>
				<!-- /chat-container-->
				<!--Chat-form -->
				<div class="chat-message-form">
					<div class="row">
						<div class="col-md-12">
							<textarea placeholder="Write Your Message Here"
								class="form-control margin-bottom" rows="2"></textarea>
						</div>
						<div class="col-md-8 col-sm-8 col-xs-8">
							<div class="btn-group">
								<button class=" btn btn-default">
									<i class="fa fa-location-arrow"></i>
								</button>
								<button class=" btn btn-default">
									<i class="fa fa-camera"></i>
								</button>
								<button class=" btn btn-default">
									<i class="fa fa-music"></i>
								</button>
								<button class=" btn btn-default">
									<i class="fa fa-file"></i>
								</button>
							</div>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4">
							<button class="btn btn-info pull-right" type="button">Chat!</button>
						</div>
					</div>
				</div>

				<!-- /Chat-form -->

			</div>
		</div>
		<!-- End Widget -->

	</div>
	<!-- /Inner Row Col-md-6 -->

	<div class="col-md-6 bootstrap-grid">

		<!-- New widget -->
		<div
			class="powerwidget powerwidget-as-portlet powerwidget-as-portlet-white"
			id="widget5" data-widget-editbutton="false">
			<header>
				<h2>
					Portlet<small>With Carousel</small>
				</h2>
			</header>
			<div class="inner-spacer nopadding">
				<div class="portlet-profile">
					<div class="user-img">
						<img src="<c:url value="/resources/images/150x150.gif" />"
							alt="User Picture" />
					</div>
					<h1>ADMS COE Team</h1>
					Followers: 451 | Friends: 45
				</div>
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item item4 active"></div>
						<div class="item item5"></div>
						<div class="item item6"></div>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>
		<!-- /New widget -->

		<!-- New widget -->
		<div
			class="powerwidget powerwidget-as-portlet powerwidget-as-portlet-green"
			id="googlemapindex">
			<header>
				<h2>
					Google Map<small>Styled</small>
				</h2>
			</header>
			<div>
				<div class="powerwidget-editbox">
					<div>
						<label>Title:</label> <input class="form-control" type="text" />
					</div>
					<div>
						<label>Styles:</label> <span data-widget-setstyle="pink"
							class="pink-btn"></span> <span data-widget-setstyle="blue"
							class="blue-btn"></span> <span data-widget-setstyle="dark-blue"
							class="dark-blue-btn"></span> <span data-widget-setstyle="green"
							class="green-btn"></span> <span data-widget-setstyle="green-alt"
							class="green-alt-btn"></span> <span
							data-widget-setstyle="green-acid" class="green-acid-btn"></span>
						<span data-widget-setstyle="yellow" class="yellow-btn"></span> <span
							data-widget-setstyle="purple" class="purple-btn"></span> <span
							data-widget-setstyle="cold-grey" class="cold-grey-btn"></span> <span
							data-widget-setstyle="dark-cold-grey" class="dark-cold-grey-btn"></span>
						<span data-widget-setstyle="orange" class="orange-btn"></span> <span
							data-widget-setstyle="red" class="red-btn"></span> <span
							data-widget-setstyle="dark-red" class="dark-red-btn"></span> <span
							data-widget-setstyle="black" class="black-btn"></span>
					</div>
				</div>
				<div class="inner-spacer nopadding">
					<div class="map-container" id="map_canvas"></div>
				</div>
			</div>
		</div>
		<!-- End Widget -->

	</div>
	<!-- /Inner Row Col-md-6 -->

</div>
<!-- /Widgets Row End Grid-->

