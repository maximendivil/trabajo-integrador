'use strict';

angular.module('myapp.cartelera')
.factory('CarteleraService', function($http){

  var getCartelera = function(id){
    // if (anio == 'primero') {
    //   return $http.get('https://mockbin.org/bin/fbf0fd99-1eee-4a07-8644-21b6b3ef0052');
    // }
    // else if (anio == 'segundo') {
    //   return $http.get('https://mockbin.org/bin/d4b2771d-347a-4f7e-aa74-0566603a4fd3');
    // } else if (anio == 'tercero') {
    //   return $http.get('https://mockbin.org/bin/daf0cf4b-3341-4e50-b78b-aecbc89640de');
    // } else if (anio == 'cuarto') {
    //   return $http.get('https://mockbin.org/bin/37543bc3-fa45-47d5-87e5-d37cd4de7f16');
    // } else {
    //   return $http.get('https://mockbin.org/bin/000b8b36-d20c-43eb-8103-fcad0c6c61de');
    // }
    return $http.get('http://localhost:8080/Grupo4/carteleras/' + id);
  };

  var config = {
    headers : {
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,OPTIONS',
      'Access-Control-Allow-Headers': 'Content-Type, Authorization, Content-Length, X-Requested-With'
    }
  }

  var getCarteleras = function() {
    return $http.get('http://localhost:8080/Grupo4/carteleras');
  }

  return {
    getCartelera:getCartelera,
    getCarteleras:getCarteleras
  };
});
