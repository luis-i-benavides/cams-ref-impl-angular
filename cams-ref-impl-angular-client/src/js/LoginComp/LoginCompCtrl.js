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
						//$scope.data.loginSession = loginSession.data;
						if(loginSession.name) {
							$scope.data.loginSession = {signon: loginSession.name, isNotLogged: false, isAdmin: true};
						} else {
							$scope.data.loginSession = {isNotLogged: true};
						}
					})
					.error(function(error){
						console.log('Retrieving authenticated user failed with error: ' + error)
						$scope.data.loginSession = {isNotLogged: true};
					});
				}
				OnLoad();
				// Event action lnkLoginEventClick
				$scope.lnkLoginEventClick = function(loginSession, causeValidation) {
					var isNotLogged = false;
					isNotLogged = $scope.data.loginSession.isNotLogged;
					if(!isNotLogged) {
						LoginCompSrv.LogoutUser().success( function() {
							//$scope.data.loginSession = loginSession.data;
							$scope.data.loginSession = {isNotLogged: true};
						})
						.error(function(error){
							console.log("Logout failed")
							$scope.data.loginSession = {isNotLogged: true};
						});
					}
					else {
						LoginCompSrv.LoginUser($scope.data.loginSession).success( function(loginSession) {
							//$scope.data.loginSession = loginSession.data;
							OnLoad();
						});
					}
					// Remove all cache from template, to ensure the security is working.	
					$scope.removeSecurityCache();
				};
			}]);
