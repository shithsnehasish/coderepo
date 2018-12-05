angular.module("app").controller("DashboardController",  
		function($scope, $rootScope, $stateParams, $location, $window, $http, ProjectService) {	  
		$scope.techDetails={};
		$scope.userDefinedDetails=[];
		$rootScope.reqDetails=[];
		$scope.pageNumber= 1;
		$scope.techDetails.name = '';
		$scope.isPagedQuery = 1;
		$rootScope.listErrorShowMsg = "No records found";
	$scope.init = function(){
		$rootScope.msg = "No records found";
		$scope.showDashboard = true;
		$scope.showDasboardArrow=true;
		$scope.showChartArrow=false;
		$scope.gridDiv = true;
		$scope.moreDiv = false;
		$scope.findProjects = false;
		$scope.disableIconDiv = true; 
		$scope.AddIconDiv = false;
		$scope.techNameSelect=true;
		$scope.whiteGridIcon = true;
		$scope.greyGridIcon = false;
		$scope.greyListIcon = true;
		$scope.whiteListIcon = false;
		$rootScope.totalProjects = 0;
		$rootScope.projectsCount=0;
		$scope.techArray  = [];
		ProjectService.getProjectCategory();
		ProjectService.getProjectNames($scope,$scope.techDetails.category);
	}
			
		
	/*$scope.getLocation = function(val) {
		if(val.length === 3){
			$scope.load1= true;
			$('#txtInput').attr('readonly','readonly');
			if ($scope.techDetails.category === undefined){
				var customUrl= '../rest/technologyService/retrieveTechnologybyKeyword/' +val;}
			else{
				var customUrl= '../rest/technologyService/retrieveTechnologybyKeyword/' +val +'?technologyCatId='+$scope.techDetails.category.technologyCategoryId;
			}
			return $http.get(customUrl, {
			 headers: {'Accept': 'application/json'} ,
						cache:false
			}).then(function(response){
				$scope.techArray = response.data;
				$scope.load1= false;
				$('#txtInput').removeAttr('readonly');
				$('#txtInput').focus();
				
				return response.data;
			});
		}
		return filterTechs(val);
		
	
  };
  
  var filterTechs = function(val){
		var filterArray = [];
		var valLower = val.toLowerCase();
		for(var tech in $scope.techArray){
			var techLower = $scope.techArray[tech].techName.toLowerCase();
			if(techLower.search(valLower) !== -1 ){
				filterArray.push($scope.techArray[tech]);
			}
		}
		return filterArray;
  };
  	 $scope.onSelect = function ($item, $model, $label) {
		ProjectService.getProjectVersion($scope,$scope.techDetails.category, $model);
	};*/

	
	$scope.changeTechCategory = function() {
			$rootScope.catNameSelect = true;
			if($scope.techDetails.category !== null){
				//$scope.disableIconDiv = true;
				//$scope.AddIconDiv = false;
				$scope.techDetails.version='';
				$(".select2-selection__rendered").text("Select Technology Name");
				$(".select2-selection__rendered").removeAttr( "title" );
				$scope.techNameSelect=true;
				ProjectService.getProjectNames($scope, $scope.techDetails.category);
			}
			else if($scope.techDetails.category == null){
				//$scope.disableIconDiv = true;
				//$scope.AddIconDiv = false;
				$scope.techDetails.version='';
				$(".select2-selection__rendered").text("Select Technology Name");
				$(".select2-selection__rendered").removeAttr( "title" );
				$scope.techNameSelect=true;
				ProjectService.getProjectNames($scope);
		}
		
    };
	
	
	$scope.changeTechName = function() {
	if($scope.techDetails.name !== null){
		$scope.techNameSelect=true;
		$(".select2-selection__rendered").removeAttr( "title" );
		ProjectService.getProjectVersion($scope, $scope.techDetails.category, $scope.techDetails.name);
		if($scope.techDetails.name == undefined){
			$scope.disableIconDiv = true;
			$scope.AddIconDiv = false;
		}
		}	
    };
	
	
	
	$scope.compareInput = function (inputData){
	
		for(var countInput=0; countInput < $scope.userDefinedDetails.length; countInput++){
			if($scope.userDefinedDetails[countInput] == inputData){
				alert('Input criteria already exists.');
				return true;
			}
		}
	}
	
	
		//Add details
	$scope.showViewDiv = function (techDetails){
		var reqBodyPre = [];
		var tReqCount = 0;
		$scope.disableDIV = true;
		$scope.ViewDiv = true;
		$scope.findProjects = true;
	//	$rootScope.projectsResult = [];
	//	$rootScope.totalProjects = 0;
	//	$rootScope.projectsCount = 0;
		$rootScope.msgErr = false;
		var technologyCategoryName = ($scope.techDetails.category === undefined || $scope.techDetails.category === null) ? '': $scope.techDetails.category.catName;
		var	technologyName = ($scope.techDetails.name === '' || $scope.techDetails.name === null || $scope.techDetails.name === undefined) ? '': (technologyCategoryName === ''? $scope.techDetails.name.techName:(',' +$scope.techDetails.name.techName));
		var technologyVersion = ($scope.techDetails.version === undefined || $scope.techDetails.version === '' || $scope.techDetails.version === null) ? '': (technologyName === ''? $scope.techDetails.version.techVersion:(',' +$scope.techDetails.version.techVersion));
		
		var resultInput = $scope.compareInput(technologyCategoryName + technologyName + technologyVersion);
		//User view	
		if(!resultInput){
			$scope.userDefinedDetails.push(technologyCategoryName + technologyName + technologyVersion);
		
		//Req body for Find project
/*		var technologyCategoryId = $scope.techDetails.category === undefined ? '': $scope.techDetails.category.technologyCategoryId;
		technologyCategoryId === '' ? '': $rootScope.reqDetails.push({'technologyCategoryId':technologyCategoryId});
		technologyName === '' ? '': ($scope.techDetails.category === undefined ? $rootScope.reqDetails.push({'technologyName':$scope.techDetails.name.techName}): $rootScope.reqDetails[0]["technologyName"]= $scope.techDetails.name.techName);
		technologyVersion === '' ? '': $rootScope.reqDetails[0]["technologyVersion"]= $scope.techDetails.version.techVersion;*/
		
			var technologyCategoryId = ($scope.techDetails.category === undefined || $scope.techDetails.category === null) ? '': $scope.techDetails.category.technologyCategoryId;
		
			reqBodyPre.push(technologyCategoryId === '' ? '': technologyCategoryId);
			reqBodyPre.push(technologyName === '' ? '': ($scope.techDetails.category === undefined ? $scope.techDetails.name.techName: $scope.techDetails.name.techName));
			reqBodyPre.push(technologyVersion === '' ? '': $scope.techDetails.version.techVersion);
		
			var reqBodyPreCount;
			for( reqBodyPreCount = 1; reqBodyPreCount <=3; reqBodyPreCount++ ){
				if( reqBodyPre[reqBodyPreCount-1] != '' )
					tReqCount += reqBodyPreCount;
			}
			reqBodyFunction(tReqCount, reqBodyPre);
	
			$scope.techDetails={};
			$scope.techNameSelect=true;
			$scope.disableIconDiv = true; 
			$scope.AddIconDiv = false;
			$rootScope.catNameSelect = true;
			$(".select2-selection__rendered").text("Select Technology Name");
			$(".select2-selection__rendered").removeAttr( "title" );
			ProjectService.getProjectNames($scope,$scope.techDetails.category);
		}
		else{
			$scope.techDetails={};
			$scope.techNameSelect=true;
			$scope.disableIconDiv = true; 
			$scope.AddIconDiv = false;
			$rootScope.catNameSelect = true;
			$(".select2-selection__rendered").text("Select Technology Name");
			$(".select2-selection__rendered").removeAttr( "title" );
			ProjectService.getProjectNames($scope,$scope.techDetails.category);
		}
	}
	var reqBodyFunction = function(reqCount,reqBodyPre){
		switch(reqCount){
			case 1 :
					$rootScope.reqDetails.push({
						'technologyCategoryId':reqBodyPre[0]
					});
					break;
			case 2 :
					$rootScope.reqDetails.push({
						'technologyName':reqBodyPre[1]
					});
					break;
			case 3 :
					$rootScope.reqDetails.push({
						'technologyCategoryId':reqBodyPre[0],
						'technologyName':reqBodyPre[1]
					});
					break;
			case 5 :
					$rootScope.reqDetails.push({
						'technologyName':reqBodyPre[1],
						'technologyVersion':reqBodyPre[2]
					});
					break;
			case 6 :
					$rootScope.reqDetails.push({
						'technologyCategoryId':reqBodyPre[0],
						'technologyName':reqBodyPre[1],
						'technologyVersion':reqBodyPre[2]
					});
					break;
		}
	};
	$scope.CountPageNumber = function (){
		$scope.pageNumber++;
	}
	
	//Delete details
	$rootScope.removeProjectDetails = function(arrayItem) {
		$rootScope.projectsResult = [];
		$rootScope.totalProjects = 0;
		$rootScope.projectsCount = 0;
		var valIndexComponent = $scope.userDefinedDetails.indexOf(arrayItem);
        $scope.userDefinedDetails.splice(valIndexComponent, 1);
		$rootScope.reqDetails.splice(valIndexComponent, 1);
		if($scope.userDefinedDetails.length === 0){
			$scope.findProjects = false;
		}
		else{
		ProjectService.fetchProjects($rootScope.reqDetails,$scope.isPagedQuery);
		}
    };
	
	
	//Click Dashboard Icons
	$scope.showDashboardDiv = function (){
		$scope.showDashboard = true;
		$scope.showChartArrow=false;
		$scope.showDasboardArrow=true;
/*		$rootScope.totalProjects = 0;*/
/*		$rootScope.projectsResult = [];*/
	}
	
	$scope.showChartDiv = function (){
		$scope.showGraphs = true;
		$scope.showChartArrow=true;
		$scope.showDasboardArrow=false;
/*		$rootScope.totalProjects = 0;*/
/*		$rootScope.projectsResult = [];*/
	}
	
	//Icons on Click project bar Grid
	$scope.showGridDiv = function (){
		$scope.gridDiv = true;
		$scope.listDiv = false;
		$scope.moreDiv = true;
		
		//Icons Color
		$scope.whiteGridIcon = true;
		$scope.greyGridIcon = false;
		$scope.greyListIcon = true;
		$scope.whiteListIcon = false;
	}
	
	//Icons on Click project bar List
	$scope.showListDiv = function (){
		$scope.listDiv = true;
		$scope.gridDiv = false;
		$scope.moreDiv = true;
		
		//Icons Color
		$scope.whiteGridIcon = false;
		$scope.greyGridIcon = true;
		$scope.greyListIcon = false;
		$scope.whiteListIcon = true;
		
	}
		
	//Modal Values
	$scope.clickModal = function(projectType) {
		ProjectService.ProjectDetails(projectType);
	};
	
	//Download code
	$scope.downloadReport = function(projectType) {
		ProjectService.downloadProjectPDF($scope, projectType);
    };

	//Post service for find Projects button
	$scope.searchProjects = function(){
		ProjectService.fetchProjects($rootScope.reqDetails,$scope.isPagedQuery);
    };
	
	//Post service for find Projects button
	$scope.getMoreProjects = function(){
		$scope.pageNumber++;
		ProjectService.getMoreProjects($rootScope.reqDetails,$scope.pageNumber,$rootScope.totalProjects,$scope.isPagedQuery);
    };
	
	$scope.init();
});