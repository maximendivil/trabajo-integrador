angular.module('myapp.login')
.controller('LoginCtrl', function($scope, $state, LoginService){

  $scope.loginErrorMessage = '';
  $scope.login = function(){
    console.log('Usuario: ' + $scope.username);
    console.log('Password: ' + $scope.password);

    LoginService.login($scope.username, $scope.password)
    .then(function(){
      $scope.loginErrorMessage = ''; //reset error message
      $state.go('cartelera');
    })
    .catch(function(){
      $scope.loginErrorMessage = 'Usuario o Contraseña invalido. Por favor, vuelva a intentarlo';
    });
  }
});
