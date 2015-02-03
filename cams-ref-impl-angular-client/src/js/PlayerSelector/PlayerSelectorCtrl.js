'use strict';
//
// Use case mainApp controller: PlayerSelectorCtrl
// 
angular.module('mainApp').controller('PlayerSelectorCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'PlayerSelectorSrv', '$stateParams', 
            function ($scope, $window, $state, transferSrv, PlayerSelectorSrv, $stateParams) {
				$scope.ddPlayerItems =  [  ] ;
				$scope.ddTeamItems =  [  ] ;
				
				// Event action DdPlayerEventItemSelect
				$scope.DdPlayerEventItemSelect = function(selectedPlayer, causeValidation) {
					console.log('Selected player: '+selectedPlayer.Name);
				};
				// Event action DdTeamEventItemSelect
				$scope.DdTeamEventItemSelect = function(selectedTeam, causeValidation) {
					console.log('Selected team:' + selectedTeam.Name);
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
