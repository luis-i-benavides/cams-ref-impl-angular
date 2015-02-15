'use strict';
//
// Use case mainApp controller: LoginPageCtrl
// 
angular.module('mainApp').controller('LoginPageCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'MainSrv', '$stateParams', 
            function ($scope, $window, $state, transferSrv, MainSrv, $stateParams) {
				$scope.data = {
					loginSession: {}
				};
				
				// Event action homeClick
				$scope.homeClick = function( causeValidation) {
					$state.go('main.StartView');
				};
				// Event action loginClick
				$scope.loginClick = function( causeValidation) {
					MainSrv.LoginUser($scope.data.loginSession).success( function(loginSession) {
						$scope.data.loginSession = loginSession.data;
						$scope.previousState();
					});
					// Remove all cache from template, to ensure the security is working.	
					$scope.removeSecurityCache();
				};
			}]);
