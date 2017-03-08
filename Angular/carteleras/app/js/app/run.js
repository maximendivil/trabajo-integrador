angular.module('myapp')
.run(function ($rootScope, $state, LoginService) {

    $rootScope.$on('$stateChangeStart', function (event, toState) {
        if (!LoginService.isLoggedIn() && toState.url != "/login") {
            console.log('Denegar');
            event.preventDefault();
            $state.go('login');
        }
    });
});
