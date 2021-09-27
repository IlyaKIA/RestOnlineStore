angular.module('app', ['ngStorage'])
    .controller('indexController', function ($scope, $http, $location, $localStorage) {

        const contextPath = 'http://localhost:8080/api/v1'

        $scope.loadProduct = function(pageNumber) {
            $http({
                url: "/api/v1/product",
                method: "GET",
                params: $scope.filter
            }).then(function(response){
                $scope.products = response.data;
                console.log($scope.products)
            });
        };

        $scope.sendProduct = function() {
            console.log($scope.newProduct)
            $http.post(contextPath + "/product", $scope.newProduct)
                .then(function(response){
                console.log(response)
                    $scope.loadProduct(1);
                }, function errorCallback(response) {
                    console.log(response)
                });
        };
        $scope.loadProduct(1)
    });