angular.module('myapp.cartelera')
.controller('CarteleraCtrl', function($scope, $state, CarteleraService, LoginService){

	var  imagenRandom = function () {
		var height = ~~(Math.random() * 500) + 100;
		var id = ~~(Math.random() * 10000);
		return 'http://lorempixel.com/g/280/' + height + '/?' + id;
	};

	$scope.cargarCartelera = function(id){
		CarteleraService.getCartelera(id)
		.then(function(response){
			  //$scope.anioActivo = id;
			$scope.cartelera = response.data;
			console.log(response.data);
		});
	};

	$scope.logout = function() {
		LoginService.logout()
		.then(function(){
			$state.go('login');
		});
	};

	/*$scope.anioActivo = 'primero';
	//inicializo la cartelera con el primer año
  	$scope.cargarCartelera($scope.anioActivo);*/

  	$scope.cargarCarteleras = CarteleraService.getCarteleras().then(function(response){
	  	$scope.carteleras = response.data;
	}, 
	function(response) {
      console.log("algo anduvo mal");
  	}
	);

});
