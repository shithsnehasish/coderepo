defaultURL = 'http://www.wikipedia.org/';
//load page for a specific URL
function loadPage(url)	{
	if ( url != '' && url.substr(0,7) !== 'http://' && url.substr(0,8) !== 'https://' && url.substr(0, 7) !== 'file://' ) {
		url = 'http://'+url;
	 }
	$('#frameId').attr('src', url);
}

function responsiveness(){
	var width = prompt("Enter the device width","320");
	var height = prompt("Enter the device height","480");
	var device = prompt("Enter the device name","Laptop");
	var pixelDensity = prompt("Enter the device pxd","1");
	var title = prompt("Enter the device title","iPhone");
	
	var newWidth = parseInt(width,10)+17;
	$('#frameDiv').attr('class','show text-center');
	$('#frameId').animate({'width': newWidth, 'height': height},1500);
	
	var textVal = prompt("Enter the website","http://atifzaidi.github.io/");
	if(textVal == '')
	{
		$('#urlText').val(defaultURL);
		loadPage(defaultURL);
	}
	else{
		$('#urlText').val(defaultURL);
		loadPage(textVal);
	}
}


$('#deviceOrientation').on("click", function () {
	  
	  var width = $('#frameId').css("width");
	  var height = $('#frameId').css("height");
	  
	  var newWidth = parseInt(width,10)-17;
	  var newHeight = parseInt(height,10);
	  
	  newHeight = newHeight+17;
	  $('#frameId').animate({'width': newHeight, 'height': newWidth},1500);
	  
});	 

$('#width').on("change keyup paste", function(){
	  width =  $('#width').val();
	  if(width!=0 || width!=null)
	  {
		  var newWidth = parseInt(width,10)+17;
		  $('#frameId').animate({'width': newWidth},500);
	  }
	  
});

$('#height').on("change keyup paste", function(){
	  height =  $('#height').val();
	  if(height!=0 || height!=null)
	  $('#frameId').animate({'height': height},500);
});