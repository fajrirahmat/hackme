var InvoiceService = function($http){
    this.getInvoices = function(){
        return $http.get('invoice/view');  
    };
    
    this.addInvoices = function(invoice){
        return $http.post('invoice/add', {invoice});
    };
    
};

InvoiceService.$inject = ['$http'];