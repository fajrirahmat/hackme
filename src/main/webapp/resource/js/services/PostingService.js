var PostingService = function($http){
    this.getMessages = function(){
        return $http.get('message/getAll');
    };
};