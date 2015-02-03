'use strict';
//
// Use case mainApp controller: LoginCompCtrl
// 
angular.module('mainApp').controller('LoginCompCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'LoginCompSrv', '$stateParams', 
            function ($scope, $window, $state, transferSrv, LoginCompSrv, $stateParams) {
				
				// On Load Action
				var OnLoad = function() {
					LoginCompSrv.LoadLogin().success( function(loginSession) {
						$scope.data.loginSession = loginSession.data;
					});
				}
				OnLoad();
				// Event action lnkLoginEventClick
				$scope.lnkLoginEventClick = function(loginSession, causeValidation) {
					var isNotLogged = false;
					isNotLogged = $scope.data.loginSession.IsNotLogged;
					if(!isNotLogged) {
						LoginCompSrv.LogoutUser().success( function(loginSession) {
							$scope.data.loginSession = loginSession.Data;
						});
					}
					else {
						LoginCompSrv.LoginUser($scope.data.loginSession).success( function(loginSession) {
							$scope.data.loginSession = loginSession.Data;
						});
					}
					// Remove all cache from template, to ensure the security is working.	
					$scope.removeSecurityCache();
				};
			}]);
