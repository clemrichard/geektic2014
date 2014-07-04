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