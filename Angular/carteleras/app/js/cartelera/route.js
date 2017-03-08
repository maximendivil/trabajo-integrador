angular.module('myapp.cartelera')
.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('cartelera', {
		url:'/cartelera',
		views:{
			'main':{
				templateUrl: 'js/cartelera/views/home.html',
				controller: 'CarteleraCtrl'
			}
		}
	})
	.state('detail', {
		url:'/detail',
		views:{
			'main':{
				templateUrl: 'js/cartelera/views/detail.html',
				controller: 'DetailCtrl'
			}
		},
		params:{
			brick: null
		}
	});

	//$urlRouterProvider.otherwise('/cartelera');
}]);
