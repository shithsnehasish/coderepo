/**
 * New node file
 */
"use strict";

// Use Application configuration module to register a new module
ApplicationConfiguration.registerModule("app");

angular.module("app", ['ngAnimate', 'ngSanitize']).config(["$stateProvider", "$urlRouterProvider",
    function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise("dashboard/landing");
		
		$stateProvider.
		state("dashboard", {
	        url: "/dashboard",
	        templateUrl: "app/views/dashboard.client.view.html"	        
	    })
	    .state("dashboard.landing", {
	        url: "/landing",
	        views: {
	        	"header" : {templateUrl: "app/views/dashboard.header.client.view.html"},
	        	"content": {templateUrl: "app/views/dashboard.filter.client.view.html"},
	        	"leftpanel":{templateUrl: "app/views/dashboard.leftpanel.client.view.html"},
	        	"footer": {templateUrl: "app/views/dashboard.footer.client.view.html"}
	        }
	    })
		  .state("dashboard.charts", {
	        url: "/charts",
	        views: {
				"header" : {templateUrl: "app/views/dashboard.header.client.view.html"},
	        	"content": {templateUrl: "app/views/dashboard.charts.client.view.html"},
				"leftpanel":{templateUrl: "app/views/dashboard.leftpanel.client.view.html"},
	        	"footer": {templateUrl: "app/views/dashboard.footer.client.view.html"}
	        }
	    })
	}
]);

