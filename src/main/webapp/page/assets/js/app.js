angular.module('starter', ['ngRoute', 'ngResource', 'starter.controllers', 'starter.services'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/login/:url', {
                templateUrl: 'login.html',
                controller: 'loginCtrl'
            })
            .when('/category/:pageType', {
                templateUrl: 'index.html',
                controller: 'loginCtrl'
            })
            .otherwise({
                redirectTo: '/login/index'
            });
    }])
    .config(function ($httpProvider) {
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
        $httpProvider.defaults.transformRequest = [function (data) {
            var param = function (obj) {
                var query = '';
                var name, value, fullSubName, subName, subValue, innerObj, i;
                for (name in obj) {
                    value = obj[name];
                    if (value instanceof Array) {
                        for (i = 0; i < value.length; ++i) {
                            subValue = value[i];
                            fullSubName = name + '[' + i + ']';
                            innerObj = {};
                            innerObj[fullSubName] = subValue;
                            query += param(innerObj) + '&';
                        }
                    } else if (value instanceof Object) {
                        for (subName in value) {
                            subValue = value[subName];
                            fullSubName = name + '[' + subName + ']';
                            innerObj = {};
                            innerObj[fullSubName] = subValue;
                            query += param(innerObj) + '&';
                        }
                    } else if (value !== undefined && value !== null) {
                        query += encodeURIComponent(name) + '='
                            + encodeURIComponent(value) + '&';
                    }
                }
                return query.length ? query.substr(0, query.length - 1) : query;
            };
            return angular.isObject(data) && String(data) !== '[object File]'
                ? param(data)
                : data;
        }];
    })
    .directive("goToTop", function () {
        return {
            restrict: 'E',
            replace: true,
            scope: {
                minHeight: '@'
            },
            templateUrl: 'tmpl.html',
            link: function (scope, elem, attrs) {
                elem.click(function () {
                    jQuery('html,body').animate({scrollTop: 0}, 700);
                })
                    .hover(function () {
                        jQuery(this).addClass("hover");
                    }, function () {
                        jQuery(this).removeClass("hover");
                    });
                scope.minHeight = scope.minHeight ? scope.minHeight : 600;
                jQuery(window).scroll(function () {
                    var s = jQuery(window).scrollTop();
                    if (s > scope.minHeight) {
                        jQuery("#gotoTop").fadeIn(100);
                    } else {
                        jQuery("#gotoTop").fadeOut(200);
                    }
                    ;
                });
            }
        };
    })
    .value('constant', {
        "http": "http://",
        "domain": "http://" + window.location.host,
        "host": window.location.hostname
    });

angular.module('starter.controllers', [])
    .controller('loginCtrl', ['$scope', 'userService', function ($scope, userService) {
        $scope.submit = function () {
            userService.login($scope);
        }
    }])
    .controller('indexCtrl', ['$scope', 'userService', function ($scope, userService) {

    }])

angular.module('starter.services', ['ngResource'])
    .factory('userService', ['$resource', '$rootScope', 'constant', function ($resource, $rootScope, constant) {
        var loginApi = $resource(constant.domain + "/user/login.api")
        return {
            login: function ($scope) {
                return loginApi.save({
                    'user': $scope.user,
                    'password': $scope.password,
                    'url': $scope.url
                }, function () {

                })
            }
        }

    }])
