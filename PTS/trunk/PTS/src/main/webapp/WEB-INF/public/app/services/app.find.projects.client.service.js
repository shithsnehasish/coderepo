angular.module('app').factory('ProjectService',function($http, $rootScope){

	var ProjectService = {};
	
	ProjectService.etrieveProjectList = function(){
		$rootScope.listError = true;
		$rootScope.summary = {};
		$rootScope.listErrorShowMsg = false;
		var reqConfig = {
				method: 'GET',
				url: '../rest/projectService/retrieveProjectList',
				headers: {'Accept': 'application/json'}      
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.summary = response;
				$rootScope.listError = false;
				if(typeof $rootScope.summary === 'undefined' || $rootScope.summary == null || $rootScope.summary.length == 0)
					$rootScope.listErrorShowMsg = true;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				console.log(status);
				$rootScope.listError = false;
			});		
	}
	
	ProjectService.etrieveCategoryList = function(){
		$rootScope.listError = true;
		$rootScope.summary = {};
		$rootScope.listErrorShowMsg = false;
		var reqConfig = {
				method: 'GET',
				url: '../rest/technologyCategoryService/retrieveTechnologyCategoryList',
				headers: {'Accept': 'application/json'}      
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.summary = response;
				$rootScope.listError = false;
				if(typeof $rootScope.summary === 'undefined' || $rootScope.summary == null || $rootScope.summary.length == 0)
					$rootScope.listErrorShowMsg = true;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				console.log(status);
				$rootScope.listError = false;
			});		
	}
	
	ProjectService.etrieveTechnologyStackList = function(){
		$rootScope.listError = true;
		$rootScope.summary = {};
		$rootScope.listErrorShowMsg = false;
		var reqConfig = {
				method: 'GET',
				url: '../rest/technologyService/retrieveTechnologyStackList',
				headers: {'Accept': 'application/json'}      
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.summary = response;
				$rootScope.listError = false;
				if(typeof $rootScope.summary === 'undefined' || $rootScope.summary == null || $rootScope.summary.length == 0)
					$rootScope.listErrorShowMsg = true;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				console.log(status);
				$rootScope.listError = false;
			});		
	}
	
	ProjectService.retrieveSummary = function(){
		$rootScope.retNumber = true;
		var reqConfig = {
				method: 'GET',
				url: '../rest/summaryService/retrieveSummary',
				headers: {'Accept': 'application/json'}      
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.reSummary = response;
				$rootScope.retNumber = false;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				$rootScope.retNumber = false;
				console.log(status);
			});		
	}
	
	ProjectService.getColumnChart = function(scope){
		$rootScope.load= true;
		var reqConfig = {
				method: 'GET',
				url: '../rest/technologyCategoryService/retrieveTechnologyDistribution', 
				headers: {'Accept': 'application/json'}      
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.columnData[0].values = response;
				$rootScope.load= false;
				scope.api.refresh();
				// TODO ELSE				
			}).error(function(data,status,headers) {
				$rootScope.load= false;
				console.log(status);
			});
					
	}

	ProjectService.getDonutChart = function(assessmentOptions){
		$rootScope.load= true;
		var reqConfig = {
				method: 'GET',
				url: '../rest/projectService/retrieveProjectCategoryDistribution',
				headers: {'Accept': 'application/json'}      
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.donutData = response;
				$rootScope.load= false;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				$rootScope.load= false;
				console.log(status);
			});		
	}
	
	ProjectService.getProjectCategory = function(){
		$rootScope.techCategory={};
		var reqConfig = {
				method: 'GET',
				url: '../rest/technologyCategoryService/retrieveTechnologyCategoryList',
				headers: {'Accept': 'application/json'},
				cache:false				
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.techCategory= response;
				return response;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				console.log(status);
			});		
	}
	
	ProjectService.getProjectNames = function(scope,techCatId){
		$rootScope.techNames = {};
		scope.disableIconDiv = true; 
		scope.AddIconDiv = false;
		if (techCatId == undefined){
			var customUrl= '../rest/technologyService/retrieveOrderedTechnologyStack';
		}
		else{
			var customUrl= '../rest/technologyService/retrieveOrderedTechnologyStack?technologyCatId='+techCatId.technologyCategoryId;
		}
		var reqConfig = {
				method: 'GET',
				url: customUrl,
				headers: {'Accept': 'application/json'}  ,
					cache:false
		};
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.techNames= response;
				$rootScope.catNameSelect = false;
				scope.disableIconDiv = false;
				scope.AddIconDiv = true;
				return response;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				$rootScope.catNameSelect = false;
				console.log(status);
			});		
	}
	
	ProjectService.getProjectVersion = function(scope,techCatId, technologyName){
		$rootScope.techVersionArray={};
		scope.disableIconDiv = true; 
		scope.AddIconDiv = false;
		if (techCatId == undefined){
			var customUrl= '../rest/technologyService/retrieveTechnologyVersionbyName/' +technologyName.techName;
		}
		else{
			var customUrl= '../rest/technologyService/retrieveTechnologyVersionbyName/' +technologyName.techName +'?technologyCatId='+techCatId.technologyCategoryId;
		}
		var reqConfig = {
				method: 'GET',
				url: customUrl,
				headers: {'Accept': 'application/json'} ,
				cache:false
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.techVersionArray = response;
				scope.techNameSelect=false;
				scope.disableIconDiv = false;
				scope.AddIconDiv = true;
				return response;
				
				// TODO ELSE				
			}).error(function(data,status,headers) {
				console.log(status);
				scope.disableIconDiv = false;
				scope.AddIconDiv = true;
			});		
	}
		
	ProjectService.ProjectDetails = function(projectId){
		$rootScope.listError = true;
		$rootScope.listErrorShowMsg = false;
		$rootScope.modalDetails={};
		var reqConfig = {
				method: 'GET',
				url: '../rest/project/getProjectById/'+projectId,
				headers: {'Accept': 'application/json'}  ,
					cache:false
		};		
		
		$http(reqConfig)
			.success(function(response) {
				$rootScope.modalDetails= response;
				$rootScope.listError = false;
				if(!($rootScope.modalDetails && $rootScope.modalDetails !== "null" && $rootScope.modalDetails!== "undefined"))
				{
					$rootScope.listErrorShowMsg = true;
				}
				return response;
				// TODO ELSE				
			}).error(function(data,status,headers) {
				$rootScope.listError = false;
				console.log(status);
			});		
	}
	
	ProjectService.fetchProjects = function(userDefinedDetails,isPagedQuery){
		$('#wait_lightbox').show();
		$rootScope.listError = true;
		$rootScope.listErrorShowMsg = false;
		$rootScope.msgErr = false;
		var customUrl= '../rest/projectService/findProjectbyTechnologyList?isPagedQuery='+isPagedQuery+'&pageNumber=1';
		var reqConfig = {
				method: 'POST',
				url: customUrl,
				headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
				cache:false
		};		
		reqConfig.data = userDefinedDetails;
		$http(reqConfig)
			.success(function(data,status,headers) {
				if(data !== undefined){
					if(isPagedQuery == 0){
						$rootScope.projectsResultChart={};
		//				$rootScope.projectsResult = data.wrappedList[0].searchProjectResultVOs;*/
						$rootScope.projectsResultChart = data.wrappedList[0].searchProjectResultVOs;
						if(typeof $rootScope.projectsResultChart === 'undefined' || $rootScope.projectsResultChart == null || $rootScope.projectsResultChart.length == 0)
						{
							$rootScope.listErrorShowMsg = true;
						}
						
					}else{
						$rootScope.projectsResult={};
						$rootScope.totalProjects = data.pageData.totalItems;
						$rootScope.projectsResult = data.wrappedList[0].searchProjectResultVOs;
						if(typeof $rootScope.projectsResult === 'undefined' || $rootScope.projectsResult == null || $rootScope.projectsResult.length == 0)
						{
							$rootScope.msgErr = true;
						}
						$rootScope.projectsCount = $rootScope.projectsResult.length +' of '+ $rootScope.totalProjects;
						$rootScope.displayProjNam=[];
						for(var item=0; item < $rootScope.projectsResult.length; item++){
							$rootScope.displayProjNam[item] = '';
							$rootScope.projectList = $rootScope.projectsResult[item];
							for(var itemTech=0; itemTech < $rootScope.projectList.technologyStackVOs.length; itemTech++){
								$rootScope.projectTechDetails = $rootScope.projectList.technologyStackVOs[itemTech];
								
										if($rootScope.displayProjNam[item] === '' || $rootScope.displayProjNam[item] === undefined){
											$rootScope.displayProjNam[item] = $rootScope.projectTechDetails.techName;}
									else{
										$rootScope.displayProjNam[item] = $rootScope.displayProjNam[item] + ',' + $rootScope.projectTechDetails.techName;
									}
								
							}
						}
					}
					
					$('#wait_lightbox').hide();
					$rootScope.listError = false;
				}
				// TODO ELSE
			}).error(function(data,status,headers) {
				console.log(status);
				$rootScope.listError = false;
				$('#wait_lightbox').hide();
			});
	}
	
	ProjectService.getMoreProjects = function(userDefinedDetails,pageNumber,totalProjects,isPagedQuery){
		$rootScope.load2= true;
		var customUrl= '../rest/projectService/findProjectbyTechnologyList?isPagedQuery='+isPagedQuery+'&pageNumber='+pageNumber+'&totalCount='+totalProjects;
		var reqConfig = {
				method: 'POST',
				url: customUrl,
				headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
				cache:false
		};		
		reqConfig.data = userDefinedDetails;
		$http(reqConfig)
			.success(function(data,status,headers) {
				if(data !== undefined){
					$rootScope.projectsResult = $rootScope.projectsResult.concat(data.wrappedList[0].searchProjectResultVOs);
					$rootScope.load2= false;
					$rootScope.projectsCount = $rootScope.projectsResult.length +' of '+ $rootScope.totalProjects;
						$rootScope.displayProjNam=[];
						for(var item=0; item < $rootScope.projectsResult.length; item++){
							$rootScope.displayProjNam[item] = '';
							$rootScope.projectList = $rootScope.projectsResult[item];
							for(var itemTech=0; itemTech < $rootScope.projectList.technologyStackVOs.length; itemTech++){
								$rootScope.projectTechDetails = $rootScope.projectList.technologyStackVOs[itemTech];
								
										if($rootScope.displayProjNam[item] === '' || $rootScope.displayProjNam[item] === undefined){
											$rootScope.displayProjNam[item] = $rootScope.projectTechDetails.techName;}
									else{
										$rootScope.displayProjNam[item] = $rootScope.displayProjNam[item] + ',' + $rootScope.projectTechDetails.techName;
									}
								
							}
						}
				}// TODO ELSE				
			}).error(function(data,status,headers) {
				$rootScope.load2= false;
				console.log(status);
			});
	}
	
	ProjectService.downloadProjectPDF = function(scope, downloadType){
		$('#wait_lightbox').show();
		var reqConfig = {
				method: 'GET',
				url: '../rest/ptsReports/generatePDF?reportType=' +downloadType,
				headers: {
					'Accept': 'application/pdf'
				},
				responseType:'arraybuffer'
		};		
		
		$http(reqConfig)
			.success(function(data, status, headers, config) {
				$('#wait_lightbox').hide();
				if(downloadType === 'project'){
					$rootScope.downloadComplete = saveAs(new Blob([data],{type:"application/pdf"}), 'Project_Details_Report.pdf');
				}
				else{
					$rootScope.downloadComplete = saveAs(new Blob([data],{type:"application/pdf"}), 'CategorizedTechStack_Report.pdf');
				}
				$('.downloadSelect').val('');
				// TODO ELSE				
			}).error(function(data,status,headers) {
				$('#wait_lightbox').hide();
				console.log(status);
			});		
	}
	return ProjectService;
});