var CreateInvoiceCtrl = function($scope, InvoiceService, $state){
    var vm = this;
    vm.save = function(){
        var request = {};
        request.noFaktur = vm.noFaktur;
        request.tglFaktur = vm.tglFaktur.getTime();
        request.dariKepada = vm.dariKepada;
        request.keterangan = vm.keterangan;
        request.lastUpdate = (new Date()).getTime();
        request.lastUser = 'admin';
        var promise = InvoiceService.addInvoices(request);
        promise.then(function(respose){
            $state.go('invoice');
        });
    };
	
};

CreateInvoiceCtrl.$inject = ['$scope','InvoiceService','$state'];