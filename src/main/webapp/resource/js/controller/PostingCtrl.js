var PostingCtrl = function($scope, PostingService){
    var messages = [];
    var promise = PostingService.getMessages();
    promise.then(function(response){
        var reply = response.data;
        for(var i=0;i<reply.length;i++ ){
            var data = {};
            data.postDate = reply[i].postDate;
            data.postUser = reply[i].postUser;
            data.message = reply[i].message;
            messages.push(data);
        }
    });
    /*data.postUser = 'fajri';
    data.postDate = '19-03-2016';
    data.message = 'Menambahkan rumah sebagai tabungan impian';
    messages.push(data);*/
    $scope.messages = messages;
};

PostingCtrl.$inject = ['$scope','PostingService'];