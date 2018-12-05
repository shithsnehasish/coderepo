<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>GLIT | Validate Client Forms</title>
    <meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no"/>
	<link href="../GLITApp/assets/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href='../GLITApp/css/fonts.css'
	rel='stylesheet' type='text/css'>
<link href="../GLITApp/assets/css/responsiveslides.css" rel="stylesheet">
<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="../GLITApp/css/breadcrumb.css" rel="stylesheet"
	type="text/css" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="GLITApp/../css/jquery-ui.css" rel="stylesheet"
	type="text/css" />

    <script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
  <script src="js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="js/demos.js" type="text/javascript"></script>  
     <script src="../js/jquery.js" type="text/javascript"></script>
     <link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
		
		<link rel="stylesheet" href="../GLITApp/assets/css/responsiveslides.css">
		<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet"
		type="text/css" />
		<style type="text/css">
		.myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #97c4fe;
	-webkit-box-shadow:inset 0px 1px 0px 0px #97c4fe;
	box-shadow:inset 0px 1px 0px 0px #97c4fe;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #3d94f6), color-stop(1, #1e62d0));
	background:-moz-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-webkit-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-o-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-ms-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:linear-gradient(to bottom, #3d94f6 5%, #1e62d0 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#3d94f6', endColorstr='#1e62d0',GradientType=0);
	background-color:#3d94f6;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #337fed;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 30px;
	text-decoration:none;
	text-shadow:0px 1px 0px #1570cd;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #1e62d0), color-stop(1, #3d94f6));
	background:-moz-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:-webkit-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:-o-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:-ms-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
	background:linear-gradient(to bottom, #1e62d0 5%, #3d94f6 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#1e62d0', endColorstr='#3d94f6',GradientType=0);
	background-color:#1e62d0;
}
.myButton:active {
	position:relative;
	top:1px;
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
						href="form.spring?clientId=${clientId}">Form Details</a> 
						<a href="copyClientForm.spring">Copy Client Forms</a>
						<a href="#" class="active">Validate Client Forms</a>


				</div>

			</div>
		</div> 
		
		<div style="width: 95%; padding: 16px 0px 0px 60px">
				<div class="panel panel-default" >
                        <div class="panel-heading">
		Validate Client Forms
                        </div>
                        <!-- /.panel-heading -->
		
			<form action="submitCopyForm.spring" id="clientForm" method="post" onsubmit="return validateForm()" >
                        <div class="panel-body" style="background-color:#F1F6F9">
				<table>
					<tr>
						<td><span class="divider">Client Name : </span>
						</td>
						<td> &nbsp;</td>
						<td>
							<input type="hidden" id="clientId" name="clientId" value="${client.clientId}">
							<input type="text" name="clientName" readonly="readonly" id="clientName" value="${client.clientName}"  />
						</td>
					</tr>
					<tr>
						<td>					<span id="duplicate"></span><br/>
						<span class="divider">Forms To Copy :</span>

						</td>
					</tr>
					<c:forEach var="formData" items="${formUtil}" varStatus="field">
					
						<tr>
							<style type="text/css">
		input.odd${field.count} {background: #e35152}
		input.even${field.count} {background: #ccffcc}
	</style>
							<td><span class="divider">&nbsp;&nbsp;&nbsp;</span>
							</td>
							<td> &nbsp;</td>
							<c:choose>
							<c:when test="${formData.nameExist}">
							<td>
							<input class="odd${field.count} odd" type="text" name="${formData.form.formId}" id="${formData.form.formId}" value="${formData.form.formName}"  />&nbsp;<span class="status${field.count}"></span>
							<br/><span id="errorMsg${field.count}" style="color:red">Form name must be changed as it's duplicate !</span>
							
							<script>
							 $(document).ready(function(){
							        $(".odd${field.count}").change(function(){
							            var formName = $(this).val();
							            if(formName.length > 3){
							                $(".status${field.count}").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
							                 $.ajax({
							                    type: "GET",
							                    url: "checkFormNames.spring",
							                    data: "formName="+ formName,
							                    success : function(response) { 
							                    	$(".status${field.count}").html(response);
							                    	var chkResponse ="<font color=green><b>"+formName+"</b> is avaliable";
							                    	if(response == chkResponse)
							                    		{
							                    		$(".odd${field.count}").removeClass("odd${field.count} odd").addClass("even${field.count} even");
							                    		$('#errorMsg${field.count}').hide();
							                    		}
							                    	else
						                    		{
						                    		$(".even${field.count}").removeClass("even${field.count} even").addClass("odd${field.count} odd");
						                    		$('#errorMsg${field.count}').show();
						                    		}
							          	     },  
							          	     error : function(e) {  
							          	      alert('Error: ' + e);   
							          	     }  
							                }); 
							            }
							            else{
							                 
							                $(".status${field.count}").html("<font color=red>Form Name shold be <b>3</b> chars</font>");
							            }
							            
							        });
							    });
							   
							
							
							</script>
							</td>
							</c:when>
							<c:otherwise>
							<td>
							<input type="text" class="even${field.count} even" name="${formData.form.formId}" id="${formData.form.formId}" value="${formData.form.formName}"  readonly="readonly" /></td>
							</c:otherwise>
							</c:choose>
							<c:if test="">
							</c:if>
							<td>
							 <input type="image" src="../GLITApp/images/delete-button.png" onclick="deleteRow(this);"/>
				            </td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="panel-footer">
				<span style="margin-left:110px;"  >
					<input type="submit" value="Submit" class="myButton" />
				</span>	
				</div>
			</form>	
			</div>
			</div>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
	<script type="text/javascript">
	function validateForm(){
    	   if($('input').hasClass("odd"))
    		{
    		return false;
    		}  
    	var temp; var indexOfInput;  var timeRepeated = 0;
  	  var count = 0;
    	 
        $( "input.even" ).each(function( index ) {
        	temp = $(this).val();
        	indexOfInput = $(this).index();
        	 count++;
        	$( "input.even" ).each(function( index ) {
         	
         	if(indexOfInput != index){
         		
         		if(temp == $(this).val()){
         			timeRepeated++;
         		}
         	}
         	
         	 });
        });
        
         
        var calculatedTimeRepeated = count -1;
	    if(timeRepeated == calculatedTimeRepeated){
        	return true;
        }
        else
        	{
        	$("#duplicate").html("<font color=red>Found duplicate form Name !</font>");
        	return false;
        	}
	    
        	
        }
	
    function deleteRow(el) {
  	  // while there are parents, keep going until reach TR 
  	  while (el.parentNode && el.tagName.toLowerCase() != 'tr') {
  	    el = el.parentNode;
  	    
  	  }

  	  // If el has a parentNode it must be a TR, so delete it
  	  // Don't delte if only 3 rows left in table
  	  if (el.parentNode && el.parentNode.rows.length > 2) {
  	    el.parentNode.removeChild(el);
  	  }
  	  
  	  if(el.parentNode.rows.length > 1)
  		  {
alert("This is a mandatory row, it can't be deleted !")  	;	  }
  	}
    
    $(document).ready(function(){
    	$('#add').submit(function()
    			{
    		$("input[type='checkbox']").not(':checked').each(function(){
    			$this.val(0).attr('checked',true);
    		});
    			});
    });

    </script>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>