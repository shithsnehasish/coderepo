angular.module("app").controller("ChartsController",
	function($scope, $compile, $rootScope, $stateParams, $location, $window, $http, ProjectService){
	$rootScope.reqChartDetails = [];
	ProjectService.getColumnChart($scope);
	ProjectService.getDonutChart();	
	ProjectService.retrieveSummary();
	$rootScope.listErrorMsg = "No records found";

/*	$scope.backButton = function(data){
		console.log(data);
//		if(data == 'cat'){
			$scope.cat = false;
			$scope.details = false;
			$scope.list = true;			
//		}
	}*/

	$scope.getClass = function(data){
		if(data.length > 2){
			return 2;}
		else{
			return 1;}
	};
	
	$scope.techColumnFun = function(e) {
		$scope.divName = 'Category';
		$("#myProjectModal").modal('show');
		$scope.searchProjectsBy(e.point.technologyCategoryVO);
	};
	
	$scope.techDonutFun = function(e){
		$scope.divName = 'Technology';
		$('#myProjectModal').modal('show');
		$scope.searchProjectsBy(e.point.technologyStackVO);
	};
	
	$scope.columnOptions = {
    	"chart": {
        	"type": "discreteBarChart",
        	"height": 450,
        	"margin": {
        	    "top": 20,
            	"right": 20,
            	"bottom": 80,
            	"left": 55
        	},
			x: function(d){return d.technologyCategoryVO.catName;},
        	y: function(d){return d3.format(',.2f')(d.projectCount);},
		    "showValues": true,
        	valueFormat: function(d){
                return d3.format(',.0f')(d);
            },
        	"transitionDuration": 500,
        	"xAxis": {
            	"axisLabel": "Technology Category",
            	"dispatch": {},
            	"axisLabelDistance": 0,
            	"staggerLabels": false,
            	"rotateLabels": -20,
            	"rotateYLabel": true,
            	"showMaxMin": false,
            	"height": 60,
            	"ticks": null,
            	"width": 75,
            	"margin": {
            	    "top": 0,
                	"right": 0,
                	"bottom": 0,
                	"left": 0
            	},
            	"duration": 250,
            	"orient": "bottom",
            	"tickValues": "",
            	"tickSubdivide": 0,
            	"tickSize": 6,
            	"tickPadding": 3,
            	"domain": [
            	    0,
            	    1
            	],
            	"range": [
            	    0,
                	1
            	]
        	},
        	"yAxis": {
            	"axisLabel": "Project Count",
            	"axisLabelDistance": 30,
            	"dispatch": {},
            	"staggerLabels": false,
            	"rotateLabels": 0,
            	"rotateYLabel": true,
            	"showMaxMin": true,
            	"height": 60,
            	"ticks": null,
            	"width": 75,
            	"margin": {
            	    "top": 0,
                	"right": 0,
                	"bottom": 0,
                	"left": 0
            	},
            	"duration": 250,
            	"orient": "left",
            	"tickValues": null,
            	"tickSubdivide": 0,
            	"tickSize": 6,
            	"tickPadding": 3,
				"tickFormat": function(d){
                	return d3.format(',f')(d);
            	},
			    "domain": [
            	    0,
            	    1
            	],
            	"range": [
            	    0,
            	    1
            	]
        	},
        	"dispatch": {},
        	"discretebar": {
            	"dispatch": {
					"elementClick": function(e){ $scope.techColumnFun(e); }
				},
            	"width": 960,
            	"height": 500,
            	"forceY": [
            	    0
            	],
            	"showValues": false,
            	"id": 4649,
            	"rectClass": "discreteBar",
            	"margin": {
                	"top": 0,
                	"right": 0,
                	"bottom": 0,
                	"left": 0
           	 	},
            	"duration": 250
        	},
			"tooltipContent": function (key, x, y, e, graph) {
				return '<div class="tooltipCustomCheck"><h3>' + e.point.technologyCategoryVO.catName + '</h3><p>' + e.point.projectCount + '</p></div>';
			},
			"tooltip":{
				"duration":0,
	            "gravity":"w",
	            "distance":0,
	            "snapDistance":0,
	            "classes":null,
	            "chartContainer":null,
	            "fixedTop":null,
	            "enabled":true,
	            "hideDelay":400,
	            "headerEnabled":false,
	            "position":{
					"left":null,
	                "top":null
				},
	            "offset":{
					"left":0,
	                "top":0
	            },
	            "hidden":true,
	            "data":null,
	            "tooltipElem":null,
	            "id":"nvtooltip-57432"
			},
        	"width": null,
        	"forceY": [
            0
	        ],
	        "rectClass": "discreteBar",
	        "duration": 250,
	        "staggerLabels": false,
	        "showXAxis": true,
	        "showYAxis": true,
	        "noData": "Processing...",
	        "tooltips": true,
	        "rightAlignYAxis": false
	    },
	    "title": {
	        "enable": true,
	        "text": "Top 10 Category Distribution",
	        "className": "h4",
	        "css": {
	            "width": "nullpx",
	            "textAlign": "center"
	        }
	    },
	    "subtitle": {
	        "enable": false,
	        "text": "",
	        "css": {
	            "width": "nullpx",
	            "textAlign": "center"
	        }
	    },
	    "caption": {
	        "enable": false,
	        "text": "Figure 1. Write Your Caption text.",
	        "css": {
	            "width": "nullpx",
	            "textAlign": "center"
	        }
	    },
	    "styles": {
	        "classes": {
	            "with-3d-shadow": true,
	            "with-transitions": true,
	            "gallery": false
	        },
	        "css": {}
	    }
	};

$rootScope.columnData = [  
	{
		key: "Cumulative Return",
		values: []
	}
];

$scope.config={ 
	refreshDataOnly: true 
};

$scope.donutOptions = {
	chart: {
		type: 'pieChart',
	    height: 500,
	    x: function(d){return d.technologyStackVO.techName;},
	    y: function(d){return (d3.format(',.0f')(d.projectCount));},
	    showLabels: true,
		valueFormat: function(d){
			return d3.format(',.0f')(d);
		},
	    transitionDuration: 500,
	    labelThreshold: 0.05,
	    legend: {
			margin: {
			top: 227,
	        right: 35,
	        bottom: -227,
	        left: 0
			},
		    "width":400,
		    "height":20,
		    "align":true,
		    "rightAlign":true,
		    "padding":32,
		    "updateState":true,
		    "radioButtonMode":false,
		    "expanded":false,
		    "vers":"classic"
		},
	    "pie":{
			"width":500,
		    "height":500,
		    "showLabels":true,
		    "title":false,
		    "titleOffset":0,
		    "labelThreshold":0.05,
		    "id":4374,
		    "endAngle":false,
		    "startAngle":false,
		    "padAngle":false,
		    "cornerRadius":0,
		    "donutRatio":0.35,
		    "labelsOutside":false,
		    "labelSunbeamLayout":false,
		    "donut":false,
		    "growOnHover":true,
		    "pieLabelsOutside":false,
		    "donutLabelsOutside":false,
		    "margin":{
				"top":0,
		        "right":0,
		        "bottom":0,
		        "left":0
			},
		    "labelType":"percent",
			"dispatch": {
				"elementClick": function(e){ $scope.techDonutFun(e); }
			}
		},
		"tooltip":{
			"duration":0,
		    "gravity":"w",
		    "distance":25,
		    "snapDistance":0,
		    "classes":null,
		    "chartContainer":null,
		    "fixedTop":null,
		    "enabled":true,
		    "hideDelay":400,
		    "headerEnabled":false,
		    "position":{
				"left":null,
		        "top":null
			},
		    "offset":{
				"left":0,
		        "top":0
		    },
		    "hidden":true,
		    "data":null,
		    "tooltipElem":null,
		    "id":"nvtooltip-57432"
		},
		"width":500,
		"title":true,
		"titleOffset":0,
		"endAngle":false,
		"startAngle":false,
		"padAngle":false,
		"cornerRadius":0,
		"donutRatio":0.35,
		"labelsOutside":false,
		"labelSunbeamLayout":false,
		"donut":true,
		"growOnHover":true,
		"pieLabelsOutside":false,
		"donutLabelsOutside":false,
		"margin":{
			"top":30,
		    "right":20,
		    "bottom":20,
		    "left":20
		},
		"labelType":"percent",
		"noData":"Processing...",
		"showLegend":true,
		"legendPosition":"top",
		"defaultState":null,
		"tooltips":true,
		"duration":250
	},
	"title":{
		"enable":true,
		"text":"Top 10 Technology Distribution",
		"className":"h4",
		"css":{
			"width":"500px",
			"textAlign":"center"
		}
	},
	"styles":{
		"classes":{
			"with-3d-shadow":true,
		    "with-transitions":true,
		    "gallery":false
		},
	}
};

$rootScope.donutData = [];
	
$scope.clickProjectModal = function( name ) {
	$scope.divName = name;
	$scope.cat = false;
	$scope.details = false;
	$scope.list = true;
	$rootScope.projectsResultChart = [];
	if(name === 'Project'){
		ProjectService.etrieveProjectList();
	}
	else if(name === 'Category'){
		 ProjectService.etrieveCategoryList();
	}
	else if(name === 'Technology'){
		ProjectService.etrieveTechnologyStackList();
	}
	else
		console.log("Error");
};	

$scope.searchProjectsBy = function(data){
	$scope.list = false;
	$rootScope.reqChartDetails = [];
/*	console.log(data);*/
	$rootScope.projectsResultChart = [];
	if($scope.divName === 'Project'){
		$scope.details = true;
		$scope.cat = false;
		ProjectService.ProjectDetails(data.projectId);
	}
	else if($scope.divName === 'Category'){
		var isPagedQuery = 0;
		$scope.details = false;
		$scope.cat = true;
		$scope.divName = 'Category - ' + data.catName;
		$rootScope.reqChartDetails.push({
			'technologyCategoryId':data.technologyCategoryId
		});
		ProjectService.fetchProjects($rootScope.reqChartDetails,isPagedQuery);
	}
	else if($scope.divName === 'Technology'){
		var isPagedQuery = 0;
		$scope.details = false;
		$scope.cat = true;
		$scope.divName = 'Technology - ' + data.techName;
		$rootScope.reqChartDetails.push({
			"technologyName": data.techName
		});
		ProjectService.fetchProjects($rootScope.reqChartDetails,isPagedQuery);
		}
		else
			console.log("Error");
	};
});