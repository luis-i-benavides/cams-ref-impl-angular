'use strict';

//
// Application directives.
//

// Error management
// add css class showError on container.
angular.module('mainApp').directive('showErrors', function () {
    return {
        restrict: 'AC',
        require: '^form',
        link: function (scope, el, attrs, formCtrl) {
            // find the text box element, which has the 'name' attribute
            var inputEl = el[0].querySelector("[name]");
            // convert the native text box element to an angular element
            var inputNgEl = angular.element(inputEl);
            // get the name on the text box so we know the property to check
            // on the form controller
            var inputName = inputNgEl.attr('name');

            // only apply the has-error class after the user leaves the text box
            inputNgEl.bind('blur', function () {
                el.toggleClass('has-error', formCtrl[inputName].$invalid);
            });

            scope.$on('show-errors-check-validity', function () {
                el.toggleClass('has-error', formCtrl[inputName].$invalid);
            });

            scope.$on('show-errors-reset', function () {
                $timeout(function () {
                    el.removeClass('has-error');
                }, 0, false);
            });
        }
    }
});
// IE, $http is always cached
angular.module('mainApp').config(['$httpProvider', function ($httpProvider) {
    //initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    //disable IE ajax request caching
    $httpProvider.defaults.headers.get['If-Modified-Since'] = '0';
}]);
// Context menu.
angular.module('mainApp').directive('context', [function () {
    return {
        restrict: 'A',
        scope: '@&',
        compile: function compile(tElement, tAttrs, transclude) {
            return {
                post: function postLink(scope, iElement, iAttrs, controller) {
                    var ul = $('#' + iAttrs.context),
                        last = null;

                    ul.css({ 'display': 'none' });

                    $(iElement).contextmenu(function (event) {
                        ul.css({
                            position: "fixed",
                            display: "block",
                            left: event.clientX + 'px',
                            top: event.clientY + 'px'
                        });
                        last = event.timeStamp;
                        event.stopPropagation();
                        event.preventDefault();
                    });

                    $(document).click(function (event) {
                        var target = $(event.target);
                        if (!target.is(".popover") && !target.parents().is(".popover")) {
                            if (last === event.timeStamp)
                                return;
                            ul.css({
                                'display': 'none'
                            });
                        }
                    });
                }
            };
        }
    };
}]);

// Datatable Sort directive.
// Applied on TH.
angular.module('mainApp').directive('thsort', function ($parse) {
    return {
        restrict: 'A',
        transclude: true,
        replace: true,
        template:
            '<th><a ng-click="onClick()"><span ng-transclude="ng-transclude">' +
            '</span><span ng-show="order === by">&nbsp;<i ng-show="!reverse" class="fa fa-sort-asc"></i>' +
            '<i ng-show="reverse" class="fa fa-sort-desc"></i></span></a></th>',
        scope: {
            order: '=',
            by: '=',
            reverse: '=',
            paginatorChange: '=?'
        },
        link: function(scope, element, attrs) {
            scope.onClick = function () {
					// Test on order to determine the direction.
                if (scope.order === scope.by) {
                    scope.reverse = !scope.reverse;
                } else {
                    scope.by = scope.order;
                    scope.reverse = false;
                }
                // Call back on page change is optionnal. 
                // It needs to be called only if the data is paged. 
                if (typeof scope.paginatorChange !== 'undefined') {
                    scope.paginatorChange(scope.order, scope.reverse);
                }
            }
        }
    }
});

// Manage messages & errors.
var HEADER_NAME = 'ERR-500';
var specificallyHandleInProgress = false;

angular.module('mainApp').factory('RequestsErrorHandler', ['$q', '$rootScope', function ($q, $rootScope) {
    return {
        // --- The user's API for claiming responsiblity for requests ---
        specificallyHandled: function (specificallyHandledBlock) {
            specificallyHandleInProgress = true;
            try {
                return specificallyHandledBlock();
            } finally {
                specificallyHandleInProgress = false;
            }
        },
        // Handle messages in all request.
        response: function (response) {
            if (typeof response.data.Messages !== 'undefined') {
                $rootScope.messages = response.data.Messages;
                $rootScope.$broadcast('MESSAGE-DISPLAY');
            }
            return response || $q.when(response);
        },
        // Handles errors generically.
        responseError: function (rejection) {
            var shouldHandle = (rejection && rejection.config && rejection.config.headers
            && rejection.config.headers[HEADER_NAME]);

            if (rejection.status === 401) {
                // Only redirect for secured template.
                if (rejection.config.headers.Accept === "text/html") {
                    $rootScope.goToState('LoginPage');
                }
            } else if (shouldHandle) {
                $rootScope.messages.push(rejection.data);
                $rootScope.$broadcast('MESSAGE-DISPLAY');
            }
            return $q.reject(rejection);
        }
    };
}]);

angular.module('mainApp').config(['$provide', '$httpProvider', function ($provide, $httpProvider) {
    $httpProvider.interceptors.push('RequestsErrorHandler');

    // --- Decorate $http to add a special header by default ---

    function addHeaderToConfig(config) {
        config = config || {};
        config.headers = config.headers || {};

        // Add the header unless user asked to handle errors himself
        if (!specificallyHandleInProgress) {
            config.headers[HEADER_NAME] = true;
        }

        return config;
    }

    // The rest here is mostly boilerplate needed to decorate $http safely
    $provide.decorator('$http', ['$delegate', function ($delegate) {
        function decorateRegularCall(method) {
            return function (url, config) {
                return $delegate[method](url, addHeaderToConfig(config));
            };
        }

        function decorateDataCall(method) {
            return function (url, data, config) {
                return $delegate[method](url, data, addHeaderToConfig(config));
            };
        }

        function copyNotOverriddenAttributes(newHttp) {
            for (var attr in $delegate) {
                if (!newHttp.hasOwnProperty(attr)) {
                    if (typeof ($delegate[attr]) === 'function') {
                        newHttp[attr] = function () {
                            return $delegate.apply($delegate, arguments);
                        };
                    } else {
                        newHttp[attr] = $delegate[attr];
                    }
                }
            }
        }

        var newHttp = function (config) {
            return $delegate(addHeaderToConfig(config));
        };

        newHttp.get = decorateRegularCall('get');
        newHttp.delete = decorateRegularCall('delete');
        newHttp.head = decorateRegularCall('head');
        newHttp.jsonp = decorateRegularCall('jsonp');
        newHttp.post = decorateDataCall('post');
        newHttp.put = decorateDataCall('put');

        copyNotOverriddenAttributes(newHttp);

        return newHttp;
    }]);
}]);
