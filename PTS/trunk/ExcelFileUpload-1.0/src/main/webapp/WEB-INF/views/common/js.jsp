<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--JQuery-->

<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/modernizr/modernizr.custom.js" />"></script>

<!--Scripts-->
<!--GMaps-->
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
    $('#unSelectedComponents').multiSelect({
    	  selectableHeader: "<div class='custom-header'>Selectable items</div>",
    	  selectionHeader: "<div class='custom-header'>Selection items</div>",
    	  selectableFooter: "<div class='custom-header'>Selectable footer</div>",
    	  selectionFooter: "<div class='custom-header'>Selection footer</div>"
    	});
    
	</script>
<c:url var="getAccount" value="/getAccount.dell" />

<script type="text/javascript">
var opFlag=true;
$("#verticals").change(function(){
	 $('#account').html("");
	 var html = '<option value="">Select Account</option>';
	 $('#account').html(html);
	 $.getJSON('${getAccount}', {
			verticals:$(this).val()
		 //  ajax : 'true'
	     }, function(data) {
	    	
	     var len = data.length;
	      
	      for ( var i = 0; i < len; i++) {
	       html += '<option value="' + data[i].accountId + '">'
	         + data[i].name + '</option>';
	      } 
	   
	      $('#account').html(html);
	    	 
	     }
	   
	     
	 );});
</script>

<!--Forms-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/forms/jquery.form.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/forms/jquery.validate.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/forms/jquery.maskedinput.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/jquery-steps/jquery.steps.min.js" />"></script>

<!--Datatables-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/datatables/jquery.dataTables.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/datatables/jquery.dataTables-bootstrap.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/datatables/dataTables.colVis.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/datatables/colvis.extras.js" />"></script>


<!--GMap-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/gmap/jquery.gmap.js" />"></script>

<!--EasyPieChart-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/easing/jquery.easing.1.3.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/easypie/jquery.easypiechart.min.js" />"></script>

<!--Fullscreen-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/fullscreen/screenfull.min.js" />"></script>

<!--NanoScroller-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/nanoscroller/jquery.nanoscroller.min.js" />"></script>

<!--Sparkline-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/sparkline/jquery.sparkline.min.js" />"></script>

<!--Horizontal Dropdown-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/horisontal/cbpHorizontalSlideOutMenu.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/classie/classie.js" />"></script>



<!--Morris Chart-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/raphael/raphael-min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/morris/morris.min.js" />"></script>

<!--FlotChart-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/flotchart/jquery.flot.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/flotchart/jquery.flot.resize.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/flotchart/jquery.flot.axislabels.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/flotchart/jquery.flot-tooltip.js" />"></script>

<!--Chart.js-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/chartjs/chart.min.js" />"></script>

<!--Calendar-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/fullcalendar/fullcalendar.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/fullcalendar/gcal.js" />"></script>

<!--Bootstrap-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/bootstrap/bootstrap.min.js" />"></script>

<!--Vector Map-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/vector-map/jquery.vmap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/vector-map/jquery.vmap.sampledata.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/vector-map/jquery.vmap.world.js" />"></script>

<!--ToDo-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/todos/todos.js" />"></script>

<!--SkyCons-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/skycons/skycons.js" />"></script>
<script>
      var icons = new Skycons({"color": "#fff"}),
          list  = [
            "clear-day", "clear-night", "partly-cloudy-day",
            "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
            "fog"
          ],
          i;

      for(i = list.length; i--; )
        icons.set(list[i], list[i]);

      icons.play();
    </script>

<!--Main App-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/scripts.js" />"></script>

<!--/Scripts-->

