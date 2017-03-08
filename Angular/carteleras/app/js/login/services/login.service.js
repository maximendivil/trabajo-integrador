'use strict';
angular.module('myapp.login')
.factory('LoginService', function(ENV, $http, $q){

  var config = {
    headers : {
      'Content-Type': 'application/json;charset=utf-8;',
    }
  };
  
  var login = function(user, password) {
    var defer = $q.defer();
    $http.post(ENV.endpoint.url + '/login',
    {
      'usuario': user,
      'password': password
    }, config)
    .success(function(data){
      console.log('El login responde: ');
      console.log(data);
      localStorage.setItem('tokenSeguridad', data.token);
      defer.resolve(data);
    })
    .error(defer.reject);

    return defer.promise;
  };

  var logout = function() {
    var defer = $q.defer();
    // invalido el token
    localStorage.removeItem('tokenSeguridad');
    defer.resolve();

    return defer.promise;
  };

  var isLoggedIn = function() {
    var isToken = angular.isDefined(getToken()) && getToken() !== null;
    return isToken;
  };

  var getToken = function() {
    return localStorage.getItem('tokenSeguridad');
  };


  return {
    login: login,
    logout: logout,
    getToken: getToken,
    isLoggedIn: isLoggedIn
  };
})
