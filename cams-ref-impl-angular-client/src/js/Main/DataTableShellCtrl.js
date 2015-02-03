'use strict';
//
// Use case mainApp controller: DataTableShellCtrl
// 
angular.module('mainApp').controller('DataTableShellCtrl', 
        ['$scope', '$rootScope', '$window', '$state', 'transferSrv', 'MainSrv', '$stateParams', 
            function ($scope, $rootScope, $window, $state, transferSrv, MainSrv, $stateParams) {
				$scope.data = {
					htSys: {}
				};
				
				// On Load Action
				var OnLoad = function() {

				}
				OnLoad();
				$scope.closeMessage = function(index) {
					$scope.messages.splice(index, 1);
				};
				// function libraries
				// Check if the object is not undefined.
				$scope.isNotEmpty = function (obj) {
				    for (var i in obj) if (obj.hasOwnProperty(i)) return true;
				    return false;
				};
				// Display messages.
				$scope.$on('MESSAGE-DISPLAY', function () {
				    $scope.data.messages = $rootScope.messages;
				});
			}]);
