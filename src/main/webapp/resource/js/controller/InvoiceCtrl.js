var InvoiceCtrl = function($scope, InvoiceService){
    var items = [];
    var promise = InvoiceService.getInvoices();
    
    promise.then(function(response){
        var reply = response.data;
        for(var i=0;i<reply.length; i++){
            items.push(reply[i]); 
        }
    });
    
    $scope.items = items;
    
};

InvoiceCtrl.$inject = ['$scope','InvoiceService'];