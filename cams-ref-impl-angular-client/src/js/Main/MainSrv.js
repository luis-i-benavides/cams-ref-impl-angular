'use strict';

//
// Service factory for the view main
//
angular.module('mainApp').factory('MainSrv', ['$http', '$q', function ($http, $q) {

    var MainSrv = {};
	// Calling service operation LoadLogin
	MainSrv.LoadLogin = function () {
		return $http.get("/Main/LoadLogin");
	};
	// Calling service operation LoginUser
	MainSrv.LoginUser = function (appUser) {
		return $http.post("/Main/LoginUser", appUser);
	};
	// Calling service operation LogoutUser
	MainSrv.LogoutUser = function () {
		return $http.get("/Main/LogoutUser");
	};
	// Calling service operation howToSystemUCFindAll
	MainSrv.howToSystemUCFindAll = function () {
		return $http.get("/Main/howToSystemUCFindAll");
	};
    return MainSrv;
}]);
