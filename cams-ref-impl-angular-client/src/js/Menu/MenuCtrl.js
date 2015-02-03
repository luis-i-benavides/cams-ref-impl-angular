'use strict';
//
// Use case mainApp controller: MenuCtrl
// 
angular.module('mainApp').controller('MenuCtrl', 
        ['$scope','$window', '$state', 'transferSrv', 'MenuSrv', '$stateParams', 
            function ($scope, $window, $state, transferSrv, MenuSrv, $stateParams) {
				
				// On Load Action
				var OnLoad = function() {
					MenuSrv.howToSystemUCFindAll().success(function(ucMenus) {
						$scope.data.ucMenus = ucMenus.data;
					});
				}
				OnLoad();
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
