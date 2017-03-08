angular.module('myapp')
.config(['$urlRouterProvider', function($urlRouterProvider) {

	$urlRouterProvider.otherwise('/login');

}]);
