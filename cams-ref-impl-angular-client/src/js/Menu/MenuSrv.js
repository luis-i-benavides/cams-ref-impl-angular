'use strict';

//
// Service factory for the view main
//
angular.module("mainApp").factory("MenuSrv", ["$http", function ($http) {

    var MenuSrv = {};
		
	// Calling service operation howToSystemUCFindAll
	MenuSrv.howToSystemUCFindAll = function () {
		return $http.get("/Menu/howToSystemUCFindAll");
	};
    return MenuSrv;
}]);
