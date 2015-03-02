'use strict';

//
// Application routing configuration.
//

// Configuration application routing.
angular.module('mainApp').config(
    ['$stateProvider', '$urlRouterProvider', '$locationProvider',
      function ($stateProvider, $urlRouterProvider, $locationProvider) {
    	$urlRouterProvider
              .otherwise('/main/StartView');
    	$stateProvider
              .state('main', {
                  abstract: true,
                  controller: 'DataTableShellCtrl',
                  url: '/main',
                  templateUrl: 'partials/Main/DataTableShell.html',
                      resolve: {
                          deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                            name: 'mainApp',
                                            files: [
                                            		'/js/Main/MainSrv.js'
                                            		,'/js/Main/StartViewCtrl.js'
    												,'/js/LoginComp/LoginCompCtrl.js'
    												,'/js/LoginComp/LoginCompSrv.js'
    												,'/js/Menu/MenuCtrl.js'
    												,'/js/Menu/MenuSrv.js'
    												,'/js/ModelDocumentation/ModelDocumentationCtrl.js'
    												,'/js/ModelDocumentation/ModelDocumentationSrv.js'
                                            	]
                                        }
                                    );
                                }]
                      }
              })
              .state('main.StartView', {
                  url: '/StartView',
                  templateUrl: 'partials/Main/StartView.html',
                  controller: 'StartViewCtrl',
              })
              .state('main.Uc01DtSimple', {
                  url: '/Uc01DtSimple',
                  templateUrl: 'partials/Uc01/Uc01DtSimple.html',
                  controller: 'Uc01DtSimpleCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                            function ($ocLazyLoad) {
                                return $ocLazyLoad.load({
                                        name: 'mainApp',
                                        files: [
                                        		'/js/Uc01/Uc01Srv.js'
                                        		,'/js/Uc01/Uc01DtSimpleCtrl.js'
                                        	]
                                    }
                                );
                            }]
                      ,teamListPre: ['deps', 'Uc01Srv', '$stateParams', function(deps, Uc01Srv, $stateParams) {
                                return Uc01Srv.getTeamWithPlayersDefered();
                            }]
                  }
              })
              .state('main.Uc04DtSortedPage', {
                  url: '/Uc04DtSortedPage',
                  templateUrl: 'partials//Uc04/Uc04DtSortedPage.html',
                  controller: 'Uc04DtSortedPageCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                            function ($ocLazyLoad) {
                                return $ocLazyLoad.load({
                                        name: 'mainApp',
                                        files: [
                                        		'/js/Uc04/Uc04Srv.js'
                                        		,'/js/Uc04/Uc04DtSortedPageCtrl.js'
                                        	]
                                    }
                                );
                            }]
                      ,playerListPre: ['deps', 'Uc04Srv', '$stateParams', function(deps, Uc04Srv, $stateParams) {
                                return Uc04Srv.getPlayersPagedDefered();
                            }]
                  }
              })
              .state('main.Uc05DtInlineEdit', {
                  url: '/Uc05DtInlineEdit',
                  templateUrl: 'partials/Uc05/Uc05DtInlineEdit.html',
                  controller: 'Uc05DtInlineEditCtrl',
                  resolve: {
                      deps: ['$ocLazyLoad',
                            function ($ocLazyLoad) {
                                return $ocLazyLoad.load({
                                        name: 'mainApp',
                                        files: [
                                        		'/js/Uc05/Uc05Srv.js'
                                        		,'/js/Uc05/Uc05DtInlineEditCtrl.js'
												,'/js/PlayerSelector/PlayerSelectorCtrl.js'
												,'/js/PlayerSelector/PlayerSelectorSrv.js'
												,'/js/ContractEditor/ContractEditorCtrl.js'
												,'/js/ContractEditor/ContractEditorSrv.js'
                                        	]
                                    }
                                );
                            }]
                      ,teamVOListPre: ['deps', 'Uc05Srv', '$stateParams', function(deps, Uc05Srv, $stateParams) {
                                return Uc05Srv.getTeamWithPlayersDefered();
                            }]
                  }
              });
    	// use the HTML5 History API
        $locationProvider.html5Mode(true);
      }
]);
