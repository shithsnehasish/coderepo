<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--Modals-->

<!--Power Widgets Modal-->
<div class="modal" id="delete-widget">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-lock"></i>
			</div>
			<div class="modal-body text-center">
				<p>Are you sure to delete this widget?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"
					id="trigger-deletewidget-reset">Cancel</button>
				<button type="button" class="btn btn-primary"
					id="trigger-deletewidget">Delete</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--Sign Out Dialog Modal-->
<div class="modal" id="signout">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-lock"></i>
			</div>
			<div class="modal-body text-center">Are You Sure Want To Sign
				Out?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="yesigo">Ok</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--Lock Screen Dialog Modal-->
<div class="modal" id="lockscreen">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-lock"></i>
			</div>
			<div class="modal-body text-center">Are You Sure Want To Lock
				Screen?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="yesilock">Ok</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal" id=deleteModule>
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-trash-o"></i>
			</div>
			<div class="modal-body text-center">Are You Sure Want To Delete
				the Module?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="yesidelete">Ok</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<div class="modal" id=copyModule>
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-copy"></i>
			</div>
			<div class="modal-body text-center">Are You Sure Want To Copy
				the Module?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="yesicopy">Ok</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<div class="modal" id=configureModule>
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-warning"></i>
			</div>
			<div class="modal-body text-center">Configuration is lost if
				already configured.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="yesiconfigure">Ok</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<div class="modal" id=Logout>
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<i class="fa fa-sign-out"></i>
			</div>
			<div class="modal-body text-center">Are you sure you want to
				LogOut ?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="yesilogout">Ok</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
