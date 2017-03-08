'use strict';
/**
 * @ngdoc service
 * @name todopago.Services.AuthService
 * @description AuthService Factory
 */
angular.module('todopago')
  .factory('AuthService', [
    '$localStorage', '$sessionStorage',
    function($localStorage, $sessionStorage) {
      var
        getToken = function() {
          return $localStorage.accessToken;
        },
        getSecondFactorToken = function() {
          return $localStorage.tokenSeguridad;
        },
        setSecondFactorToken = function(tokenSeguridad) {
          $localStorage.tokenSeguridad = tokenSeguridad;
        },
        isLoggedIn = function() {
          var isToken = angular.isDefined(getToken()) && getToken() !== null;
          return isToken;
        },
        isLoggedInAndSecondFactor = function() {
          var isToken = angular.isDefined(getToken()) && getToken() !== null;
          var isSecondFactor = angular.isDefined(getSecondFactorToken()) && getSecondFactorToken() !== null;
          return isToken && isSecondFactor;
        },
        login = function(accessToken) {
          $localStorage.accessToken = accessToken;
        },
        logout = function() {
          $localStorage.accessToken = null;
          delete $sessionStorage.externalLoad;
        };

      return {
        isLoggedIn: isLoggedIn,
        getToken: getToken,
      };
    }
  ]);
