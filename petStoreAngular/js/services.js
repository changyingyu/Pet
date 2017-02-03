

angular.module('movieApp.services',[]).factory('Pet',function($resource){
    return $resource('http://localhost:8082/pet/:id',{id:'@_id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});