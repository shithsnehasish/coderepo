<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>GLIT | Add Form</title>
    <meta name="viewport" content="width = device-width, initial-scale = 1.0, minimum-scale = 1.0, maximum-scale = 1.0, user-scalable = no"/>
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
    function deleteRow(el) {
  	  // while there are parents, keep going until reach TR 
  	  while (el.parentNode && el.tagName.toLowerCase() != 'tr') {
  	    el = el.parentNode;
  	    
  	  }

  	  // If el has a parentNode it must be a TR, so delete it
  	  // Don't delte if only 3 rows left in table
  	  if (el.parentNode && el.parentNode.rows.length > 2) {
  	    el.parentNode.removeChild(el);
  	  return false;
  	  }
  	  
  	  if(el.parentNode.rows.length > 1)
  		  {
  		alert("This is a mandatory row, it can't be deleted !")  	;
  		return false;
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
}
    .CSSTableGenerator {
	margin:0px;padding:0px;
	width:100%;
	box-shadow: 10px 10px 5px #888888;
	border:1px solid #000000;
	
	-moz-border-radius-bottomleft:0px;
	-webkit-border-bottom-left-radius:0px;
	border-bottom-left-radius:0px;
	
	-moz-border-radius-bottomright:0px;
	-webkit-border-bottom-right-radius:0px;
	border-bottom-right-radius:0px;
	
	-moz-border-radius-topright:0px;
	-webkit-border-top-right-radius:0px;
	border-top-right-radius:0px;
	
	-moz-border-radius-topleft:0px;
	-webkit-border-top-left-radius:0px;
	border-top-left-radius:0px;
}.CSSTableGenerator table{
    border-collapse: collapse;
        border-spacing: 0;
	width:100%;
	height:100%;
	margin:0px;padding:0px;
}.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright:0px;
	-webkit-border-bottom-right-radius:0px;
	border-bottom-right-radius:0px;
}
.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft:0px;
	-webkit-border-top-left-radius:0px;
	border-top-left-radius:0px;
}
.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright:0px;
	-webkit-border-top-right-radius:0px;
	border-top-right-radius:0px;
}.CSSTableGenerator tr:last-child td:first-child{
	-moz-border-radius-bottomleft:0px;
	-webkit-border-bottom-left-radius:0px;
	border-bottom-left-radius:0px;
}.CSSTableGenerator tr:hover td{
	
}
.CSSTableGenerator tr:nth-child(odd){ background-color:#e5e5e5; }
.CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff; }.CSSTableGenerator td{
	vertical-align:middle;
	
	
	border:1px solid #000000;
	border-width:0px 1px 1px 0px;
	text-align:left;
	padding:7px;
	font-size:10px;
	font-family:Arial;
	font-weight:normal;
	color:#000000;
}.CSSTableGenerator tr:last-child td{
	border-width:0px 1px 0px 0px;
}.CSSTableGenerator tr td:last-child{
	border-width:0px 0px 1px 0px;
}.CSSTableGenerator tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.CSSTableGenerator tr:first-child td{
		background:-o-linear-gradient(bottom, #cccccc 5%, #b2b2b2 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #cccccc), color-stop(1, #b2b2b2) );
	background:-moz-linear-gradient( center top, #cccccc 5%, #b2b2b2 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#cccccc", endColorstr="#b2b2b2");	background: -o-linear-gradient(top,#cccccc,b2b2b2);

	background-color:#cccccc;
	border:0px solid #000000;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:14px;
	font-family:Arial;
	font-weight:bold;
	color:#000000;
}
.CSSTableGenerator tr:first-child:hover td{
	background:-o-linear-gradient(bottom, #cccccc 5%, #b2b2b2 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #cccccc), color-stop(1, #b2b2b2) );
	background:-moz-linear-gradient( center top, #cccccc 5%, #b2b2b2 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#cccccc", endColorstr="#b2b2b2");	background: -o-linear-gradient(top,#cccccc,b2b2b2);

	background-color:#cccccc;
}
.CSSTableGenerator tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.CSSTableGenerator tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
}
    </style>
</head>
<body>
	<div class="demo-container">
	<jsp:include page="header.jsp"></jsp:include>
	    <div style="width:95%;padding:16px 0px 0px 66px">
		
                        <div>
		<div class="breadcrumb flat" style="width:100%;">
	    <a href="client.spring">Client Details</a>
        <a href="form.spring?clientId=${clientId}">Form Details</a>
       	<a href="#" class="active">Add Form </a>
        
	
</div>
        
                        </div>
                        </div>
						
		<form action="addNewForm.spring" method="post" onsubmit="return validate();" >
		<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
                        <div class="panel-body" style="background-color:#F1F6F9">
		<table>
		<tr>
		<td><span class="divider">Form Name </span></td>
		<td> &nbsp;</td>
		<c:if test="${flag eq 0 }">
		<td><input type="text" name="formName" value="${formName}" class="formName required" />&nbsp;<span class="status"></span></td>
		</c:if>
		<c:if test="${flag eq 1 }">
		<td><input type="text" name="formName" value="${formName}" class="formName required" />&nbsp;<span class="status"></span></td>
		</c:if>
		<c:if test="${flag eq 2 }">
		<td><input type="text" name="formName" value="${formName}" class="formName required" readonly="readonly"/>&nbsp;<span class="status"  ></span></td>
		</c:if>
		</tr>
		</table>
		</div>
		</div>
		</div>
		<div style="width:95%;padding:16px 0px 0px 66px">
				<div class="panel panel-default" >
				<div class="panel-heading">
				<c:if test="${flag ne 2 }">
		<input type="button" id="btnAdd" class="myButton" onClick="insertRow()" value="+ Add Records"></input>
		</c:if>
                        </div>
                                          <!-- /.panel-heading -->
                        <div class="panel-body" style="background-color:#F1F6F9">
		<table id="addField">
		<tr>
		<th>Field Name</th>
		<th>Text Limit</th>
		<th>Data Type</th>
		<th>Multi Select</th>
		<th>Mandatory Field</th>
		<th>&nbsp;</th>
		</tr>
		<c:choose>
			<c:when test="${flag==0}">
		
		<tr>
		<td><input type="text" id="fieldName" name="fieldName" class="required fieldName"  /></td>
        <td><input type="text" id="textLimit" name="textLimit" class="required textLimit" /></td>
        <td><select id="fieldDataType" name="fieldDataType" class="required">
		<option value="Text">Text</option>
		<option value="Numeric">Numeric</option>
		<option value="Email">Email</option>
		<option value="Date">Date</option>
		</select> </td>
		<td><select id="multiSelect" name="multiSelect" class="required">
		<option value="0">No</option>
		<option value="1">Yes</option>
		</select> </td>
		<td><select id="mandatory" name="mandatory" class="required">
		<option value="0">No</option>
		<option value="1">Yes</option>
		</select> </td>
		<td>
		<a href="#" onclick="deleteRow(this);"> <img alt="Delete Row" src="../GLITApp/images/delete-button.png"/></a>
		</td>
        </tr>
        </c:when>
        <c:when test="${flag==2}">
		<c:forEach var="field" items="${ formFields}">
			<tr>
		<td><input type="text" id="fieldName" name="fieldName" value="${field.fieldName }" class="required fieldName" readonly="readonly"   /></td>
        <td><input type="text" name="textLimit" value="${field.fieldLimit }" class="required textLimit" readonly="readonly" /></td>
        <td><c:if test="${field.fieldDataType == 'Text' }">
        <select id="fieldDataType" name="fieldDataType" class="required" disabled>
		<option value="Text" selected="selected">Text</option>
		<option value="Numeric">Numeric</option>
		<option value="Email">Email</option>
		<option value="Date">Date</option>
		</select>
        </c:if>
        <c:if test="${field.fieldDataType == 'Numeric' }">
        <select id="fieldDataType" name="fieldDataType" class="required" disabled >
		<option value="Text">Text</option>
		<option value="Numeric" selected="selected">Numeric</option>
		<option value="Email">Email</option>
		<option value="Date">Date</option>
		</select>
        </c:if>
        <c:if test="${field.fieldDataType == 'Email' }">
        <select id="fieldDataType" name="fieldDataType" class="required" disabled>
		<option value="Text">Text</option>
		<option value="Numeric" >Numeric</option>
		<option value="Email" selected="selected">Email</option>
		<option value="Date">Date</option>
		</select>
        </c:if>
        <c:if test="${field.fieldDataType == 'Date' }" >
        <select id="fieldDataType" name="fieldDataType" class="required" disabled >
		<option value="Text">Text</option>
		<option value="Numeric" >Numeric</option>
		<option value="Email" >Email</option>
		<option value="Date" selected="selected">Date</option>
		</select>
        </c:if>
        
         </td>
		<td>
<c:if test="${field.multiSelect == false }">

		<select id="multiSelect" name="multiSelect" class="required" disabled>
		<option value="0" selected="selected">No</option>
		<option value="1">Yes</option>
		</select> 

</c:if>	

<c:if test="${field.multiSelect == true }">

		<select id="multiSelect" name="multiSelect" class="required" disabled>
		<option value="0">No</option>
		<option value="1" selected="selected">Yes</option>
		</select> 

</c:if>	
	</td>
	<td>
<c:if test="${field.mandatory == false }">

		<select id="mandatory" name="mandatory" class="required" disabled>
		<option value="0" selected="selected">No</option>
		<option value="1">Yes</option>
		</select> 

</c:if>	

<c:if test="${field.mandatory == true }">

		<select id="mandatory" name="mandatory" class="required" disabled>
		<option value="0">No</option>
		<option value="1" selected="selected">Yes</option>
		</select> 

</c:if>	
	</td>
		<td> <a href="#"> <img alt="Delete Row" src="../GLITApp/images/delete-button.png"/></a></td>
        </tr>
			</c:forEach>
        <input type="hidden" id="formid" name="formId" value="${formId}">
        </c:when>
			<c:otherwise>
			<c:forEach var="field" items="${ formFields}">
			<tr>
		<td><input type="text" id="fieldName" name="fieldName" value="${field.fieldName }" class="required fieldName"   /></td>
        <td><input type="text" name="textLimit" value="${field.fieldLimit }" class="required textLimit" /></td>
        <td><c:if test="${field.fieldDataType == 'Text' }">
        <select id="fieldDataType" name="fieldDataType" class="required" >
		<option value="Text" selected="selected">Text</option>
		<option value="Numeric">Numeric</option>
		<option value="Email">Email</option>
		<option value="Date">Date</option>
		</select>
        </c:if>
        <c:if test="${field.fieldDataType == 'Numeric' }">
        <select id="fieldDataType" name="fieldDataType" class="required" >
		<option value="Text">Text</option>
		<option value="Numeric" selected="selected">Numeric</option>
		<option value="Email">Email</option>
		<option value="Date">Date</option>
		</select>
        </c:if>
        <c:if test="${field.fieldDataType == 'Email' }">
        <select id="fieldDataType" name="fieldDataType" class="required" >
		<option value="Text">Text</option>
		<option value="Numeric" >Numeric</option>
		<option value="Email" selected="selected">Email</option>
		<option value="Date">Date</option>
		</select>
        </c:if>
        <c:if test="${field.fieldDataType == 'Date' }">
        <select id="fieldDataType" name="fieldDataType" class="required" >
		<option value="Text">Text</option>
		<option value="Numeric" >Numeric</option>
		<option value="Email" >Email</option>
		<option value="Date" selected="selected">Date</option>
		</select>
        </c:if>
        
         </td>
		<td>
<c:if test="${field.multiSelect == false }">

		<select id="multiSelect" name="multiSelect" class="required">
		<option value="0" selected="selected">No</option>
		<option value="1">Yes</option>
		</select> 

</c:if>	

<c:if test="${field.multiSelect == true }">

		<select id="multiSelect" name="multiSelect" class="required">
		<option value="0">No</option>
		<option value="1" selected="selected">Yes</option>
		</select> 

</c:if>	
	</td>
	<td>
<c:if test="${field.mandatory == false }">

		<select id="mandatory" name="mandatory" class="required">
		<option value="0" selected="selected">No</option>
		<option value="1">Yes</option>
		</select> 

</c:if>	

<c:if test="${field.mandatory == true }">

		<select id="mandatory" name="mandatory" class="required">
		<option value="0">No</option>
		<option value="1" selected="selected">Yes</option>
		</select> 

</c:if>	
	</td>
		<td> <a href="#" onclick="deleteRow(this);"> <img alt="Delete Row" src="../GLITApp/images/delete-button.png"/></a></td>
        </tr>
			</c:forEach>
        <input type="hidden" id="formid" name="formId" value="${formId}">
        </c:otherwise>
		</c:choose>
        </table>
        </div>
                        <div class="panel-footer">
        <table>
		<tr>
		<td><span class="divider">&nbsp; </span></td>
		<c:if test="${flag ne 2 }">
		<td><input type="reset" value="Reset" class="myButton" /> &nbsp;</td>
		<td><input type="submit" value="Add Form" class="myButton" id="add"/></td>
		</c:if>
		</tr>
		</table>
		</div>
        </div>
        </div>
        <input type="hidden" id="flag" name="flag" value="${flag}"/>
		</form>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		</div>
	<script type="text/javascript">
	function validateForm() {
		var errorFlag = false;
		 $('input.required').each(function() { 
			    if($(this).val() == "") {
			    	alert("All fields are mandatory");
			    	errorFlag = true;
			    }
		  });
	    if($('input').hasClass("check"))
			{
	    	errorFlag = true;
			}  
	    if(errorFlag == true)
	    	{
	    	
	    return false;
	    	}
	    else
	    	{
	    	return true;
	    	}
	  }
var validate = (function() {
  var validateFormResult = validateForm();
  if(validateFormResult == true){
	  var temp; var indexOfInput; 
	  var timeRepeated = 0;
	  var count = 0;
	    $( "input.fieldName" ).each(function( index ) {
	    	temp = $(this).val();
	    	indexOfInput = $(this).index();
             count++;
	    	$( "input.fieldName" ).each(function( index1 ) {
	     	
	     	if(index1>indexOfInput){
	     		var resp = $(this).val();
	     		if(temp == resp){
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
	    	alert("Field name is duplicate !");
	    	return false;
	    	}
	    
	     
	  }
  else
	  {
	  return false;
	  }
}

);
</script>
<script type="text/javascript">
$(document).ready(function () {
    $(".textLimit").forceNumeric();
});


// forceNumeric() plug-in implementation
jQuery.fn.forceNumeric = function () {

    return this.each(function () {
        $(this).keydown(function (e) {
            var key = e.which || e.keyCode;

            if (!e.shiftKey && !e.altKey && !e.ctrlKey &&
            // numbers   
                key >= 48 && key <= 57 ||
            // Numeric keypad
                key >= 96 && key <= 105 ||
            // comma, period and minus, . on keypad
               key == 190 || key == 188 || key == 109 || key == 110 ||
            // Backspace and Tab and Enter
               key == 8 || key == 9 || key == 13 ||
            // Home and End
               key == 35 || key == 36 ||
            // left and right arrows
               key == 37 || key == 39 ||
            // Del and Ins
               key == 46 || key == 45)
                return true;

            return false;
        });
    });
}
</script>
    <SCRIPT language="javascript">
    $(document).ready(function(){
        $(".formName").change(function(){
            var formName = $(this).val();
            if(formName.length > 3){
                $(".status").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                 $.ajax({
                    type: "GET",
                    url: "checkFormNames.spring",
                    data: "formName="+ formName,
                    success : function(response) { 
                    	$(".status").html(response);
                       	var chkResponse ="<font color=red><b>"+formName+"</b> is already in use</font>";
                    	if(response == chkResponse)
                    		{
                    		$(".formName").addClass("check");
                    		}
                    	else
                    		{
                    		$(".formName").removeClass("check");
                    		}
          	     },  
          	     error : function(e) {  
          	      alert('Error: ' + e);   
          	     }  
                }); 
            }
            else{
                 
                $(".status").html("<font color=red>Form Name shold be <b>3</b> chars</font>");
            }
            
        });
    });
    
    $(document).ready(function(){
    	$('#add').submit(function()
    			{
    		$("input[type='checkbox']").not(':checked').each(function(){
    			$this.val(0).attr('checked',true);
    		});
    			});
    });
        var index = 1;
    function insertRow(){
                var table=document.getElementById("addField");
                var row=table.insertRow(table.rows.length);
                var cell1=row.insertCell(0);
                var t1=document.createElement("input");
                    t1.type = "text"; 
                    t1.id = "fieldName"+index;
                    t1.name = "fieldName";
                    t1.className = "required fieldName";
                    cell1.appendChild(t1);
                var cell2=row.insertCell(1);
                var t2=document.createElement("input");
                    t2.type = "text"; 
                    t2.id = "textLimit";
                    t2.name = "textLimit";
                    t2.className = "required textLimit";
                    cell2.appendChild(t2);
               
                    var cell3=row.insertCell(2);
                    var array = ["Text","Numeric","Email","Date"];
                    //Create and append select list
                    var t3 = document.createElement("select");
                    t3.id = "fieldDataType";
                    t3.name = "fieldDataType";
                    cell3.appendChild(t3);

                    //Create and append the options
                    for (var i = 0; i < array.length; i++) {
                        var option = document.createElement("option");
                        option.value = array[i];
                        option.text = array[i];
                        t3.appendChild(option);
                    }
                    
                    var cell4=row.insertCell(3);
                var array2 = ["No","Yes"];
                var array3 = ["0","1"];
                //Create and append select list
                var t4 = document.createElement("select");
                t4.id = "multiSelect";
                t4.name = "multiSelect";
                cell4.appendChild(t4);
                
                for (var i = 0; i < array2.length; i++) {
                    var option1 = document.createElement("option");
                    option1.value = array3[i];
                    option1.text = array2[i];
                    t4.appendChild(option1);
                }
                var cell5=row.insertCell(4);
                var array4 = ["No","Yes"];
                var array5 = ["0","1"];
                //Create and append select list
                var t5 = document.createElement("select");
                t5.id = "mandatory";
                t5.name = "mandatory";
                cell5.appendChild(t5);

                //Create and append the options
                for (var j = 0; j < array4.length; j++) {
                    var option2 = document.createElement("option");
                    option2.value = array5[j];
                    option2.text = array4[j];
                    t5.appendChild(option2);
                }
                var cell6=row.insertCell(5);
                //Create and append select list
            	var strHtml6 = "<a href='#' onclick='deleteRow(this);'> <img alt='Delete Row' src='../GLITApp/images/delete-button.png'/></a>";
                cell6.innerHTML = strHtml6;
                
                
          index++;
          var rows = document.getElementById("addField").getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
    }
</SCRIPT>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
