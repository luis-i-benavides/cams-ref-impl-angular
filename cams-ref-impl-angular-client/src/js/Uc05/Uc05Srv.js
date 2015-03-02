'use strict';

//
// Service factory for the view main
//
angular.module('mainApp').factory('Uc05Srv', ['$http', '$q', function ($http, $q) {

    var Uc05Srv = {};
	// Calling service operation updateContract
	Uc05Srv.updateContract = function (contract) {
		return $http.post("/Uc05/updateContract", contract);
	};
	// Calling service operation getTeamWithPlayers
	Uc05Srv.getTeamWithPlayers = function () {
		return $http.get("/Uc05/getTeamWithPlayers");
	};
	// Calling defered service operation  getTeamWithPlayers
   Uc05Srv.getTeamWithPlayersDefered = function () {
        var deferred = $q.defer();
        $http.get("/Uc05/getTeamWithPlayers").
	        success(function (data, status) {
	            deferred.resolve(data);
	        }).error(function (data, status) {
	            deferred.reject(data);
	        });
        return deferred.promise;
    };
	// Calling service operation UpdatePlayerEF
	Uc05Srv.UpdatePlayerEF = function (selectedPlayer) {
		return $http.post("/Uc05/updatePlayerEF", selectedPlayer);
	};
    return Uc05Srv;
}]);
