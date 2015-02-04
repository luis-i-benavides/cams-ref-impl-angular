'use strict';
//
// Use case mainApp controller: Uc01DtSimpleCtrl
// 
angular.module('mainApp').controller('Uc01DtSimpleCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'Uc01Srv', '$stateParams', 'teamListPre', 
            function ($scope, $window, $state, transferSrv, Uc01Srv, $stateParams, teamListPre) {
				$scope.data = {
					teamBusiness: {},teamList: []
				};
				// Assign preloading variable to scope
				$scope.data.teamList = teamListPre.data;

				// On Load Action
				var MainEventOnLoad = function() {
					// preload action skipping call: getTeamWithPlayers
				}
				MainEventOnLoad();
				// Event action BtnSelectEventClick
				$scope.BtnSelectEventClick = function(teamBusiness, causeValidation) {
					$scope.message = { Severity: 'success', Message: teamBusiness.name };
				};
				$scope.closeMessage = function() {
					$scope.message.Severity = "";
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
