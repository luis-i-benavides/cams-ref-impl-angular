'use strict';
//
// Use case mainApp controller: ContractEditorCtrl
// 
angular.module('mainApp').controller('ContractEditorCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'ContractEditorSrv', '$stateParams', 
            function ($scope, $window, $state, transferSrv, ContractEditorSrv, $stateParams) {
				$scope.transferableItems =  [ { Key:'Is tranferable', Value:'true' } ] ;
				
				// On Load Action
				var OnLoad = function() {
					if((typeof selectedPlayer !=="undefined") && (typeof selectedPlayer.contract !== "undefined")) {
						$scope.data.contract = $scope.data.selectedPlayer.contract;
					}
					else {
					}
				}
				OnLoad();
			}]);
