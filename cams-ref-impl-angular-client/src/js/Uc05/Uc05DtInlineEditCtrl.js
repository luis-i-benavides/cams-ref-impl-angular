'use strict';
//
// Use case mainApp controller: Uc05DtInlineEditCtrl
// 
angular.module('mainApp').controller('Uc05DtInlineEditCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'Uc05Srv', '$stateParams', 'teamVOListPre', 
            function ($scope, $window, $state, transferSrv, Uc05Srv, $stateParams, teamVOListPre) {
				$scope.data = {
					contract: {},selectedPlayer: {},selectedTeam: {},teamVOList: []
				};
				// Assign preloading variable to scope
				$scope.data.teamVOList = teamVOListPre.data;

				// On Load Action
				var OnLoad = function() {
					// preload action skipping call: getTeamWithPlayers
				}
				OnLoad();
				// Event action BtnUpdateEventClick
				$scope.BtnUpdateEventClick = function( causeValidation) {
					Uc05Srv.updateContract($scope.data.contract).success(function() {
						Uc05Srv.UpdatePlayerEF($scope.data.selectedPlayer).success(function() {
						});
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
