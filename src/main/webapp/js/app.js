var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('GeekCtrl', function($scope, $http) {     
    $scope.remplircombo = function()
    {
    	   $http.get('/sawgeeks/combo').success(function(listeInterets) {

           $scope.interets = listeInterets;
    	   });
    }	   
    $scope.remplircombo();
    
    $scope.findGeeksByInterest = function()
    {
    	$http.get('/sawgeeks/seek/'+$scope.sexe+'/'+$scope.interet.nom).success(function(listeGeeks){
    		$scope.geeksByInterest = listeGeeks;
    	});
    };
    
    
  });

app.controller('ShowCtrl', function($scope, $http, $routeParams) {
	$http.get('/sawgeeks/showgeek/'+ $routeParams.id).success(function(geek){
		$scope.geek = geek;
	});
});

app.config(function($routeProvider){
	$routeProvider
	    .when('/', {
	        templateUrl: '/view/main.html',
	        controller: 'GeekCtrl'
	    })
	    .when('/showgeek/:id', {
	        templateUrl: '/view/showgeek.html',
	        controller: 'ShowCtrl'
	    })
	    .otherwise('/');
	});