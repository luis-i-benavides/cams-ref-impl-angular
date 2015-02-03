'use strict';

//
// Application routing configuration.
//

// Configuration application routing.
angular.module('mainApp').config(
    ['$stateProvider', '$urlRouterProvider',
      function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider
              .otherwise('/main/StartView');
      $stateProvider
              .state('main', {
                  abstract: true,
                  controller: 'DataTableShellCtrl',
                  url: '/main',
                  templateUrl: 'partials/Main/DataTableShell.html'
              })
             .state('main.StartView', {
                  url: '/StartView',
                  templateUrl: 'partials/Main/StartView.html',
                  controller: 'StartViewCtrl',
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
 ;
      }]);
