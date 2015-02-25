'use strict';
//
// Use case mainApp controller: Uc04DtSortedPageCtrl
// 
angular.module('mainApp').controller('Uc04DtSortedPageCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'Uc04Srv', '$stateParams', 'playerListPre', 
            function ($scope, $window, $state, transferSrv, Uc04Srv, $stateParams, playerListPre) {
				$scope.data = {
					playerList: []
				};
				// Paginated instance & change.
				$scope.data.playerListPaged = {
					page: 1,
					pageSize: 5
				};
				$scope.playerListPagedChange = function (order, direction) {
					if (typeof order === 'undefined') {
				        $scope.data.playerListPaged.orderBy = $scope.dtPlayersOrder;
				    } else {
				        $scope.data.playerListPaged.orderBy = order;
				    }
				    if (typeof direction === 'undefined') {
				        $scope.data.playerListPaged.orderByDirection = $scope.dtPlayersReverse;
				    } else {
				        $scope.data.playerListPaged.orderByDirection = direction;
				    }
					Uc04Srv.getPlayersPaged($scope.data.playerListPaged).success(function(result) {
						$scope.data.playerList = result.data.data;
						$scope.data.playerListPaged = result.data;
					});
				};
				// Assign preloading variable to scope
				$scope.data.playerListPaged = playerListPre.data;
				$scope.data.playerList = playerListPre.data.data;

				// On Load Action
				var OnLoad = function() {
					// preload action skipping call: getPlayersPaged
				}
				OnLoad();
				// Event action LoadData
				$scope.LoadData = function( causeValidation) {
					Uc04Srv.getPlayersPaged($scope.data.playerListPaged).success(function(playerList) {
						$scope.data.playerListPaged = playerList.data;
						$scope.data.playerList = playerList.data.data;
					});
				};
 				// Generic multi selection component.
				$scope.multiSel = function (item, list) {
				    var idx = list.indexOf(item);
				    if (idx > -1) {
				        list.splice(idx, 1);
				    } else {
				        list.push(item);
				    }
				};
			}]);
