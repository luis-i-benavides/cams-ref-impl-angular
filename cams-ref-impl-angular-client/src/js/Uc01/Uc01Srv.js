'use strict';

//
// Service factory for the view main
//
angular.module('mainApp').factory('Uc01Srv', ['$http', '$q', function ($http, $q) {

    var Uc01Srv = {};
	// Calling service operation getTeamWithPlayers
	Uc01Srv.getTeamWithPlayers = function () {
		return $http.get("/Uc01/getTeamWithPlayers");
	};
	
	// Calling defered service operation  getTeamWithPlayers
   Uc01Srv.getTeamWithPlayersDefered = function () {
        var deferred = $q.defer();
        $http.get("/Uc01/getTeamWithPlayers").
	        success(function (data, status) {
	            deferred.resolve(data);
	        }).error(function (data, status) {
	            deferred.reject(data);
	        });
        return deferred.promise;
    };
    return Uc01Srv;
}]);
