/**
 * Created by Sandeep on 01/06/14.
 */
angular.module('movieApp.controllers',[]).controller('PetListController',function($scope,$state,$stateParams,popupService,$window,Pet){
    
    $scope.pets=Pet.query();
    
    //



    $scope.deletePet=function(petId){
        if(popupService.showPopup('Really delete this?')){

            Pet.delete({id:petId.id});
            
               $window.location.reload();
            

        }
    }

}).controller('PetViewController',function($scope,$stateParams,Pet){

    $scope.pet=Pet.get({id:$stateParams.id});
    //console.log($scope.movies);

}).controller('PetCreateController',function($scope,$state,$stateParams,Pet){

    $scope.pet=new Pet();
    $scope.status = ['available', 'pending', 'sold'];

    $scope.addPet=function(){

        //alert($state.go('pets'));
        console.log($state.go('pets'));
        $scope.pet.$save(function(){

            $state.go('pets');

        });
    }

}).controller('PetEditController',function($scope,$state,$stateParams,Pet){

    $scope.updatePet=function(){
        $scope.pet.$update(function(){
            $state.go('pets');
        });
    };

    $scope.loadPet=function(){
        $scope.pet=Pet.get({id:$stateParams.id});
    };

    $scope.loadPet();
});