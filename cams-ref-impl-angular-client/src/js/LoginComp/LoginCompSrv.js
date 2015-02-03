'use strict';

//
// Service factory for the view main
//
angular.module("mainApp").factory("LoginCompSrv", ["$http", function ($http) {

    var LoginCompSrv = {};
		
	// Calling service operation 	
	LoginCompSrv.LoadLogin = function () {
		return $http.get("/LoginComp/LoadLogin");
	};
		
	// Calling service operation LoginUser
	LoginCompSrv.LoginUser = function (appUser) {
		return $http.post("/LoginComp/LoginUser", appUser);
	};
		
	// Calling service operation LogoutUser
	LoginCompSrv.LogoutUser = function () {
		return $http.get("/LoginComp/LogoutUser");
	};
    return LoginCompSrv;
}]);
