var app=angular.module("MyApp",["ui.router"]);
// https://stackoverflow.com/questions/41169385/http-get-success-is-not-a-function

app.config(function($stateProvider,$urlRouterProvider){
$stateProvider.state('home',{
    url:'/home',
    templateUrl:'views/home.html',
    controller:'HomeController'
});
$stateProvider.state('chercher',{
    url:'/chercher',
    templateUrl:'views/chercher.html',
    controller:'MyController'
});
$stateProvider.state('newProduit',{
    url:'/newProduit',
    templateUrl:'views/newProduit.html',
    controller:'NewProduitController'
});
});

app.controller("HomeController", function(){

});

app.controller("MyController", function($scope,$http){
    $scope.pageProduits=null;
    $scope.motCle="";
    $scope.pageCourante=0;
    $scope.size=4;
    $scope.pages=[];
    $scope.motCleTemporaire=null;
    $scope.chercherProduits=function(){
        //si différent on remet à la page 0
        //et mc = mc
        if($scope.motCleTemporaire!=$scope.motCle){
        $scope.pageCourante=0;
        $scope.motCleTemporaire=$scope.motCle;
        }
    $http({
        method:"GET",
        url:"http://localhost:8080/chercherProduits?mc="
        +$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size
    }).then(function(response){
        data = response.data;
        $scope.pageProduits=data;
        $scope.pages=new Array(data.totalPages);
    },function (error){
        console.log(error, "can not get data");
    });
        // $http.get("http://localhost:8080/chercherProduits?mc=")
    // .success(function(data){
    //     $scope.pageProduits=data;
    // })
    // .error(function(err){
    //     console.log(err);
    // })
    }
    
    $scope.goToPage=function(p){
    $scope.pageCourante=p;
    $scope.chercherProduits();
}

});

app.controller("NewProduitController", function($){

});

