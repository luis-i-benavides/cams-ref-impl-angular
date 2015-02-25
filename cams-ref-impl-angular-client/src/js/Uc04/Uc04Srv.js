'use strict';

//
// Service factory for the view main
//
angular.module('mainApp').factory('Uc04Srv', ['$http', '$q', function ($http, $q) {

    var Uc04Srv = {};
	// Calling paged service operation getPlayersPaged
	Uc04Srv.getPlayersPaged = function (paged) {
		return $http.post("/Uc04/getPlayersPaged", paged);
	};
	// Calling defered pqged service operation  getPlayersPaged
   Uc04Srv.getPlayersPagedDefered = function () {
        var deferred = $q.defer();
        var pagedArg = { page:1, pageSize: 5 };
        $http.post("/Uc04/getPlayersPaged", pagedArg).
        success(function (data, status) {
            deferred.resolve(data);
        }).error(function (data, status) {
            deferred.reject(data);
        });
        return deferred.promise;
    };
    return Uc04Srv;
}]);
