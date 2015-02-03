'use strict';

//
// Application configuration.
//

// Configuration ui router.
angular.module('mainApp').run(
    ['$rootScope', '$state', '$stateParams','$templateCache', 
        function ($rootScope, $state, $stateParams, $templateCache) {
            $rootScope.messages = [];
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;

            // Saving state for return from login.
            $rootScope.prevRoute = '';
            $rootScope.prevParams = {};

            //
            // Function to remove templates from cache. This is usefull after a user login or signout, 
            // it will force angular to reload these templates.
            //
            $rootScope.removeSecurityCache = function () {
                $templateCache.remove('/ContractEditor/ContractEditor');
                $templateCache.remove('/DataTableShell/DataTableShell');
                $templateCache.remove('/LoginComp/LoginComp');
                $templateCache.remove('/Main/LoginPage');
                //$templateCache.remove('/Main/StartView');
                $templateCache.remove('/Menu/Menu');
                $templateCache.remove('/ModelDocumentation/ModelDocumentation');
                $templateCache.remove('/PlayerSelector/PlayerSelector');
                $templateCache.remove('/Uc01/Uc01DtSimple');
                $templateCache.remove('/Uc02/Uc02DtNestedSimple');
                $templateCache.remove('/Uc03/Uc03DtNested');
                $templateCache.remove('/Uc04/Uc04DtSortedPage');
                $templateCache.remove('/Uc05/Uc05DtInlineEdit');
                $templateCache.remove('/Uc09/Uc09RptDropDown');
                $templateCache.remove('/Uc09Repeated/Uc09Repeated');
                $templateCache.remove('/Uc10/Uc10RptTabList');
                $templateCache.remove('/Uc11/Uc11RptAccordion');
                $templateCache.remove('/Uc15/Uc15AutoComplete');
                $templateCache.remove('/Uc16/Uc16RadioCheckBox');
                $templateCache.remove('/Uc17/Uc17OvertGuest');
                $templateCache.remove('/Uc18/Uc18SecretAdmin');
                $templateCache.remove('/Uc20/Uc20TransfertObject');
                $templateCache.remove('/Uc20/Uc20TransfertObjectBis');
                $templateCache.remove('/Uc20/Uc20TransfertObjectUrl');
                $templateCache.remove('/Uc21/Uc21PickList');
                $templateCache.remove('/Uc22/Uc22Validation');
                $templateCache.remove('/Uc23/Uc23SpecificView');
                $templateCache.remove('/Uc24/Uc24Menu');
                $templateCache.remove('/Uc25/Uc25Dialogs');
                $templateCache.remove('/Uc25ConfirmationDialog/Uc25ConfirmationDialog');
                $templateCache.remove('/Uc25RichDialog/Uc25RichDialog');
                $templateCache.remove('/Uc26/Uc26Enabling');
                $templateCache.remove('/Uc27/Uc27BindingSpecific');
            }
            
            //
            // Perform navigation. Used for redirecting to the security page.
            // 
            $rootScope.goToState = function (state) {
                $state.go(state);
            }
            $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
                if (toState.name !== 'LoginPage') {
                    $rootScope.prevRoute = toState.name;
                    $rootScope.prevParams = toParams;
                }
            });
            $rootScope.previousState = function () {
                $state.go($rootScope.prevRoute, $rootScope.prevParams);
            };
        }
    ]
);

