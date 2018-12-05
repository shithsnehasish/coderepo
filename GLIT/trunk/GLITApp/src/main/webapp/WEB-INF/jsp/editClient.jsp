<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>GLIT | Add Client</title>
    <meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no"/>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
		<link href="../GLITApp/assets/css/style.css" rel="stylesheet" type="text/css"  media="all" />
	
	<link href="../GLITApp/assets/css/responsiveslides.css" rel="stylesheet" >
	<link href="GLITApp/../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../GLITApp/css/breadcrumb.css" rel="stylesheet" type="text/css"/>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
	
	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>

    <script>
        if (!window.jQuery) { document.write('<script src="js/jquery-1.9.1.min.js"><\/script>'); }
    </script>
   
	<script src="js/bootstrap-tab.js" type="text/javascript"></script>
    <script src="js/demos.js" type="text/javascript"></script>  
    <script type="text/javascript">
    $(document).ready(function(){
        $(".clientName").change(function(){
            var clientName = $(this).val();
            if(clientName.length > 3){
                $(".status").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                 $.ajax({
                    type: "GET",
                    url: "checkClientNames.spring",
                    data: "clientName="+ clientName,
                    success : function(response) { 
                    	$(".status").html(response);
                       	var chkResponse ="<font color=red><b>"+clientName+"</b> is already in use</font>";
                    	if(response == chkResponse)
                    		{
                    		$(".clientName").addClass("check");
                    		document.getElementById('clientName').style.background ='#e35152';
                    		}
                    	else
                    		{
                    		$(".clientName").removeClass("check");
                    		document.getElementById('clientName').style.background ='#ccffcc';
                    		}
          	     },  
          	     error : function(e) {  
          	      alert('Error: ' + e);   
          	     }  
                }); 
            }
            else{
                 
                $(".status").html("<font color=red>Client Name shold be <b>3</b> chars</font>");
            }
            
        });
    });
    
    function validateForm() {
    	 if(validateName()) {
	    	if(validateAddress()) {
    			if(validateEmail()) {
    			  if(validateSPOC()) {
			    	if(validateContact()) {
			    		if($('input').hasClass("check")){
						return false;			    		
			    			}else{
			    				true;
			    			}
			    	} else {
			    		return false;
			    	}
    			  } else {
    		    		return false;
    		    	}
    			} else {
    	    		return false;
    	    	}
	    	} else {
	    		return false;
	    	}
    	 } else {
    		 return false;
    	 }
    }
    
    function validateName(){
        // Validation rule
        var re = /([A-Za-z])$/;
        // Check input
        if(re.test(document.getElementById('clientName').value)){
          // Style green
          document.getElementById('clientName').style.background ='#ccffcc';
          // Hide error prompt
          document.getElementById('clientNameError').style.display = "none";
          document.getElementById('clientNameEmpty').style.display = "none";
          return true;
        }
        else if(document.getElementById('clientName').value == null || document.getElementById('clientName').value == ""){
        	document.getElementById('clientName').style.background ='#e35152';
        	document.getElementById('clientNameEmpty').style.display = "block";
        	document.getElementById('clientNameError').style.display = "none";
            return false;
        }
        
        else{
          // Style red
          document.getElementById('clientName').style.background ='#e35152';
          // Show error prompt
          document.getElementById('clientNameError').style.display = "block";
          document.getElementById('clientNameEmpty').style.display = "none";
          return false;
        }
      }
    
    function validateSPOC(){
        // Validation rule
        var re = /([A-Za-z])$/;
        // Check input
        if(re.test(document.getElementById('clientSPOC').value)){
          // Style green
          document.getElementById('clientSPOC').style.background ='#ccffcc';
          // Hide error prompt
          document.getElementById('clientSPOCError').style.display = "none";
          document.getElementById('clientSPOCEmpty').style.display = "none";
          return true;
        }
        
        else if(document.getElementById('clientSPOC').value == null || document.getElementById('clientSPOC').value == ""){
        	document.getElementById('clientSPOC').style.background ='#e35152';
        	document.getElementById('clientSPOCEmpty').style.display = "block";
        	document.getElementById('clientSPOCError').style.display = "none";
            return false;
        }
        
        else{
          // Style red
          document.getElementById('clientSPOC').style.background ='#e35152';
          // Show error prompt
          document.getElementById('clientSPOCError').style.display = "block";
          document.getElementById('clientSPOCEmpty').style.display = "none";
          return false;
        }
      }
    function validateEmail(){
        var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(re.test(document.getElementById('clientEmail').value)){
          document.getElementById('clientEmail').style.background ='#ccffcc';
          document.getElementById('clientEmailError').style.display = "none";
          document.getElementById('clientEmailEmpty').style.display = "none";
          return true;
        }
        else if(document.getElementById('clientEmail').value == null || document.getElementById('clientEmail').value == ""){
        	document.getElementById('clientEmail').style.background ='#e35152';
        	document.getElementById('clientEmailEmpty').style.display = "block";
        	 document.getElementById('clientEmailError').style.display = "none";
            return false;
        }
        
        else{
          document.getElementById('clientEmail').style.background ='#e35152';
          document.getElementById('clientEmailError').style.display = "block";
          document.getElementById('clientEmailEmpty').style.display = "none";
          return false;
        }
      }
    
    function validateContact(){
        var re = /([0-9]{10})$/;
        if(re.test(document.getElementById('contact').value)){
          document.getElementById('contact').style.background ='#ccffcc';
          document.getElementById('contactError').style.display = "none";
          document.getElementById('contactEmpty').style.display = "none";
          return true;
        }
        else if(document.getElementById('contact').value == null || document.getElementById('contact').value == ""){
        	document.getElementById('contact').style.background ='#e35152';
        	 document.getElementById('contactError').style.display = "none";
        	document.getElementById('contactEmpty').style.display = "block";
            return false;
        }
        else{
          document.getElementById('contact').style.background ='#e35152';
          document.getElementById('contactError').style.display = "block";
          document.getElementById('contactEmpty').style.display = "none";
          return false;
        }
      }
    
    function validateAddress(){
        
         if(document.getElementById('clientAddress').value == null || document.getElementById('clientAddress').value == ""){
        	document.getElementById('clientAddress').style.background ='#e35152';
        	document.getElementById('clientAddressEmpty').style.display = "block";
            return false;
        }
        else{
        	document.getElementById('clientAddress').style.background ='#ccffcc';
          document.getElementById('clientAddressEmpty').style.display = "none";
          return true;
        }
      }
    
    </script>
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
}</style>
    </head>
<body>
	<div class="demo-container">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="width:95%;padding:16px 0px 0px 66px">
		
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
	    <a href="client.spring">Client Details</a>
        <a href="#" class="active">Add Clients </a>
        
	
</div>
        
                        </div>
                        </div> 
       	<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-heading">
                            Client List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
		<form action="addClient.spring" id="clientForm" onsubmit="return validateForm()" method="post" >
		<input type="hidden" name="clientId" id="clientId" value="${client.clientId}" />
		<table>
		<tr>
		<td><span class="divider">Client Name <span style="color:red;">*</span> </span>
		</td>
		<td> &nbsp;</td>
		<td><input type="text" name="clientName" id="clientName" class="clientName" onblur="return validateName()" value="${client.clientName}" /><span class="status"></span>
		<span id="clientNameError" style="display: none;">You can only use alphabetic characters, hyphens and apostrophes</span>
		<span id="clientNameEmpty" style="display: none;color:red">Client name must be filled out</span>
		</td>
		</tr>
		
		<tr>
		<td><span class="divider">Client Address <span style="color:red;">*</span> </span></td>
		<td> &nbsp;</td>
		<td> <textarea name="clientAddress" id="clientAddress" onblur="return validateAddress()" >${client.clientAddress}</textarea>
		<span id="clientAddressEmpty" style="display: none;color:red">Client address must be filled out</span></td>
		</tr>
		<tr>
		<td><span class="divider">Client E-Mail ID <span style="color:red;">*</span> </span></td>
		<td> &nbsp;</td>
		<td><input type="text" name="clientEmail" id="clientEmail" onblur="return validateEmail()" value="${client.clientEmail}"/>
      <span id="clientEmailError" style="display: none;">You must enter a valid email address</span>
		<span id="clientEmailEmpty" style="display: none;color:red">Client Email Address must be filled out</span>
		</td>
		</tr>
		<tr>
		<td><span class="divider">Client SPOC <span style="color:red;">*</span></span></td>
		<td> &nbsp;</td>
		<td><input type="text" name="clientSPOC" id="clientSPOC"  onblur="return validateSPOC()" value="${client.clientSPOCName}"/>
		<span id="clientSPOCError" style="display: none;">You can only use alphabetic characters, hyphens and apostrophes</span>
		<span id="clientSPOCEmpty" style="display: none;color:red">Client SPOC must be filled out</span></td>
		</tr>
		<tr>
		<td><span class="divider">Contact No.<span style="color:red;">*</span> </span></td>
		<td> &nbsp;</td>
		<td><input type="text" name="contact"  id="contact" onblur="return validateContact()" value="${client.clientContactNo}" />
      <span id="contactError" style="display: none;">You must enter a valid contact number</span>
		<span id="contactEmpty" style="display: none;color:red">Client Contact No. must be filled out</span>
		</td>
		</tr>
		<tr>
		<td><span class="divider">&nbsp; </span></td>
		<td> <input type="reset" value="Reset" class="myButton" /> &nbsp;</td>
		<td><input type="submit" value="Edit Client" class="myButton" /></td>
		</tr>
		</table>
		</form>
		</div>
		<div class="panel-footer">
	<label>	<span style="color:red;">*</span> &nbsp;Fields are mandatory !</label> </div>
		</div>
		
		</div>
	</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
