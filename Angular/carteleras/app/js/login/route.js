angular.module('myapp.login')
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('login', {
		url:'/login',
		views:{
			'main':{
				templateUrl: 'js/login/views/login.html',
				controller: 'LoginCtrl'
			}
		}
	});
}]);
