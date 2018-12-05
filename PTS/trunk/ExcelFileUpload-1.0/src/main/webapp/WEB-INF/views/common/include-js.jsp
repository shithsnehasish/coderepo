<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--JQuery-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/jquery/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/jquery/jquery-ui.min.js" />"></script>
<script src="<c:url value="/resources/adms/js/jquery.growl.js" />"
	type="text/javascript"></script>

<script type="text/javascript"
	src="<c:url value="/resources/adms/js/jquery.multi-select.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/modernizr/modernizr.custom.js" />"></script>
<!-- <script>
$(document).ready(function(){$(".Service_Complex").each(function(){$(this).keyup(function(){calculateSum();});});});
function calculateSum(){
	var sum=0;
	$(".Service_Complex").each(function(){
				if(!isNaN(this.value)&&this.value.length!=0)
				{
					sum+=parseFloat(this.value);
				}});
	$("#sum_Service_Complex").html(sum.toFixed(2));
	}
	</script> -->

<script type="text/javascript">
		$( document ).ready(function() {
	//	var verticalVal = $("#verticals").find('option[text="${verticals}"]').val();
		//alert($("#verticals").find('option[text="HEALTH CARE"]').val());
		
		<c:if test="${verticalId ne null }">
		$("#verticals").val("${verticalId}");
		</c:if>
		<c:if test="${accountId ne null }">
		$("#account").val("${accountId}");
		</c:if>
		<c:if test="${contentCategoryId ne null }">
		$("#categoryId").val("${contentCategoryId}");
		</c:if>
		<c:if test="${componentCategoryId ne null }">
		$("#componentCategoryId").val("${componentCategoryId}");
		</c:if>
		
		
	//	$("#account").val("${account}"); 
	});
	</script>
<script>
	function clickFirstButton()
	{
		 $( "#addFramework-form" ).submit();
		 $( "#addParmeter-form" ).submit();
		 $( "#createContent-form" ).submit();
		 
		 
		parent.jQuery.colorbox.close();
	}
	$(document).bind('cbox_closed', function(){
	    var url      = window.location.href;
	    window.location.href = url;
	});
	
	
			$(document).ready(function(){
				function dialogClose() {  //called from inside iframe, but with the parent's scope (see below)
					window.parent.$("#somediv").dialog("close");
				return false;
				}
				
				$("#closeDialog").click(function(){
					dialogClose();
					//window.parent.parent.$('#thedialog').dialog('close');
					 //$("#thedialog").parent().addClass('sgys');
					
					// $("#overlaydiv").css("display","none");
					 //$("#thedialog").attr('src', "about:blank");
					//console.log('sss');
				 });
				
				//Examples of how to assign the Colorbox event to elements
			/* 	$(".group1").colorbox({rel:'group1'});
				$(".group2").colorbox({rel:'group2', transition:"fade"});
				$(".group3").colorbox({rel:'group3', transition:"none", width:"75%", height:"75%"});
				$(".group4").colorbox({rel:'group4', slideshow:true});
				$(".ajax").colorbox();
				$(".youtube").colorbox({iframe:true, innerWidth:640, innerHeight:390});
				$(".vimeo").colorbox({iframe:true, innerWidth:500, innerHeight:409}); */
				$(".iframe").colorbox({iframe:true, width:"80%", height:"80%"});
				$(".content-iframes").colorbox({iframe:true, width:"80%", height:"48%"});
				$(".item-iframes").colorbox({iframe:true, width:"80%", height:"38%"});
				

				$(".parameter-iframes").colorbox({iframe:true, width:"80%", height:"48%"});
				$(".framework-iframes").colorbox({iframe:true, width:"80%", height:"80%"});
				$(".complexity-iframes").colorbox({iframe:true, width:"80%", height:"35%"});
				$(".component-iframes").colorbox({iframe:true, width:"80%", height:"50%"});
				$(".iframes").colorbox({iframe:true, width:"80%", height:"36%"});
				$(".module-iframes").colorbox({iframe:true, width:"80%", height:"36%"});
				$(".item").colorbox({inline:true, href:"#test"});
				/* $(".inline").colorbox({inline:true, width:"50%"}); */
				$(".callbacks").colorbox({
					onOpen:function(){ alert('onOpen: colorbox is about to open'); },
					onLoad:function(){ alert('onLoad: colorbox has started to load the targeted content'); },
					onComplete:function(){ alert('onComplete: colorbox has displayed the loaded content'); },
					onCleanup:function(){ alert('onCleanup: colorbox has begun the close process'); },
					onClosed:function(){ alert('onClosed: colorbox has completely closed'); }
				});

				$('.non-retina').colorbox({rel:'group5', transition:'none'})
				$('.retina').colorbox({rel:'group5', transition:'none', retinaImage:true, retinaUrl:true});
				
				//Example of preserving a JavaScript event for inline calls.
				$("#click").click(function(){ 
					$('#click').css({"background-color":"#f00", "color":"#fff", "cursor":"inherit"}).text("Open this window again and this message will still be here.");
					return false;
				});
			});
		</script>
<script type="text/javascript">
	
	 
	 $(document).ready(function () {
	 if ($('#taskForm').length) {
         $('#taskForm').validate({
         	
             // Rules for form validation
             rules: {
            	 <c:forEach items="${componentComplexityVOs }" var="layer">
          		<c:forEach items="${layer.complexityNames}" var="complexity">
            	 ${layer.componentName}_${complexity}: {
                     required: true
                 },
                 itemName: {
                	 required: true
                 },
                 assumption: {
                	 required: true
                 },
                 </c:forEach>
         		</c:forEach>
             },

             // Messages for form validation
             messages: {
            	 <c:forEach items="${componentComplexityVOs }" var="layer">
          		<c:forEach items="${layer.complexityNames}" var="complexity">
            	 ${layer.componentName}_${complexity}: {
                     required: 'Please enter the items count'
                 },
                 itemName: {
                	 required: 'Please enter the item name'
                 },
                 assumption: {
                	 required: 'Please enter the assumption'
                 },
                 
                 </c:forEach>
          		</c:forEach>
             },
             showErrors: function(errorMap, errorList) {
                 for (var error in errorMap) {
                     $.growl.error({ message: errorMap[error] });
                 }
            }
         });
     }
	 });
		
	 </script>

<c:forEach items="${ConfigureFrameworkVOList }" var="framework"
	varStatus="frameworks">
	<script>
      $("#weightType${frameworks.count}").val("${framework.weightType}");
      </script>
</c:forEach>
<c:forEach items="${ConfigureComplexityVO}" var="complexity"
	varStatus="complexiti">
	<script>
$("#weightType${complexiti.count}").val("${complexity.weightType}");
</script>
</c:forEach>
<script>
	
	function disableRow() {
		$("input[type='checkbox']").change(function (E) {

	        if ($(this).is(":checked")) {

	            $(this).closest('tr').children('td').children("input[type='text']").attr("disabled",true);
	            $(".itemName").removeAttr("disabled");

	        } else {

	        	$(this).closest('tr').children('td').children("input[type='text']").removeAttr("disabled");


	        }

	    });



	}
	   
	//$(document).on('click', '.pv', testing);
	//$(document).on('click', 'input[type="checkbox"]', testing);
	 <c:forEach items="${componentComplexityVOs }" var="layer" varStatus="chk">
		<c:forEach items="${layer.complexityNames}" var="complexity" varStatus="counter" >
		$(document).on("change", ".${layer.componentName}_${complexity}", function() {
	        var sum = 0;
	        $(".${layer.componentName}_${complexity}").each(function(){
	            sum += +$(this).val();
	        });
	        $("#sum_${layer.componentName}_${complexity}").html(sum);
	    });
		
	
	</c:forEach>
	</c:forEach>
	$(document).on("change", ".usage", function() {
        var sum = 0;
        $(".usage").each(function(){
            sum += +$(this).val();
        });
        if(sum!=100)
        	{
        	
        	 $(".usage").each(function(){
        		// $(this ).addClass( "errorUsage" );
        		 $(this ).parent().addClass( "state-error" );
             });
        	$("#submitConfig").attr('disabled','disabled');
        	}
        else if(sum==100)
        	{
        	$(".usage").each(function(){
        		$(this ).parent().removeClass( "state-error" );
            });
        	$("#submitConfig").removeAttr('disabled');
        	}
    });
	
	</script>

<!--Scripts-->
<!--GMaps-->
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<c:url var="getAccount" value="/getAccount.dell" />
<script type="text/javascript">
 
	$('#addFrameworks').click(
			function() {
			$('#unSelectedFrameworks option:selected').clone().appendTo('#selectedFrameworks').end().end().remove();
			$('#selectedFrameworks option').prop('selected', 'selected');
		});
	$('#removeFrameworks').click(
		function() {
			$('#selectedFrameworks option:selected').clone().appendTo('#unSelectedFrameworks').end().end().remove();
			$('#selectedFrameworks option').prop('selected', 'selected');
		});
	
	$('#addComplexities').click(
			function() {
			$('#unSelectedComplexities option:selected').clone().appendTo('#selectedComplexities').end().end().remove();
			$('#selectedComplexities option').prop('selected', 'selected');
		});
	$('#removeComplexities').click(
		function() {
			$('#selectedComplexities option:selected').clone().appendTo('#unSelectedComplexities').end().end().remove();
			$('#selectedComplexities option').prop('selected', 'selected');
		});
	</script>
<script type="text/javascript">
   
	$('#addComponents').click(
			function() {
			$('#unSelectedComponents option:selected').clone().appendTo('#selectedComponents').end().end().remove();
			$('#selectedComponents option').prop('selected', 'selected');
		});
	$('#removeComponents').click(
		function() {
			$('#selectedComponents option:selected').clone().appendTo('#unSelectedComponents').end().end().remove();
			$('#selectedComponents option').prop('selected', 'selected');
		});
	
</script>
<script type="text/javascript">
   
	$('#addParameters').click(
			function() {
			$('#unSelectedParameters option:selected').clone().appendTo('#selectedParameters').end().end().remove();
			$('#selectedParameters option').prop('selected', 'selected');
		});
	$('#removeParameters').click(
		function() {
			$('#selectedParameters option:selected').clone().appendTo('#unSelectedParameters').end().end().remove();
			$('#selectedParameters option').prop('selected', 'selected');
		});
	

	$('#addCategories').click(
			function() {
			$('#unSelectedCategories option:selected').clone().appendTo('#selectedCategories').end().end().remove();
			$('#selectedCategories option').prop('selected', 'selected');
		});
	$('#removeCategories').click(
		function() {
			$('#selectedCategories option:selected').clone().appendTo('#unSelectedCategories').end().end().remove();
			$('#selectedCategories option').prop('selected', 'selected');
		});
</script>

<script type="text/javascript">
var opFlag=true;
$("#verticals").change(function(){
	 $('#account').html("");
	 var html = '<option value="" disabled="" selected="">Select Account</option>';
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
	 
$(function(){
	  $(".dynamicColor:even").css("background-color","#DC5034");
	  $(".dynamicColor:odd").css("background-color","#444444 ");
	  
	  $(".dynamicNewColor:even").css("background-color","#F2AF00");
	  $(".dynamicNewColor:odd").css("background-color","#6E2585");
	});
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

<!--PowerWidgets-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/powerwidgets/powerwidgets.min.js" />"></script>

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

<!--Bootstrap Animation-->
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/vendors/animation/animation.js" />"></script>

<!--Lightbox -->
<script src="<c:url value="/resources/adms/js/jquery.colorbox.js" />"></script>
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


<script type="text/javascript"
	src="<c:url value="/resources/adms/js/jquery.mousewheel-3.0.4.pack.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/adms/js/jquery.fancybox-1.3.4.pack.js" />"></script>

<!--/Scripts-->

