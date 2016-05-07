var myApp = angular.module('app',['ui.router']);

myApp
.controller('mainCtrl',['$scope',function($scope){
    $scope.name = 'Fajri Rahmat';
}])
.controller('postingCtrl',PostingCtrl)
.controller('profileCtrl',function($scope, $state){
	$scope.goToProfile = function(){
		$state.go('profile.kamu');
	};
})
.controller('settingCtrl',function($scope, $state){
	$scope.goToProfile = function(){
		$state.go('profile.kamu');
	};
})
.controller('invoiceCtrl',InvoiceCtrl)
.controller('createInvoiceCtrl', CreateInvoiceCtrl)
.service('PostingService',PostingService)
.service('InvoiceService',InvoiceService)
.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state('hackme',{
        url: '/',
        templateUrl: 'resources/templates/post.html',
        controller: 'postingCtrl'
    })
    .state('settings',{
		url: '/settings',
		templateUrl: 'resources/templates/setting.html',
		controller: 'profileCtrl'
	}).state('profile',{
		url: '/profile',
		controller: 'profileCtrl',
		templateUrl: 'resources/templates/profile.html'
	}).state('profile.kamu',{
		url:'/kamu',
		template: '<div>Kamu ini kok gitu</div>'
	}).state('account',{
		url: '/account',
		template: '<div>Account pages</div>'
	}).state('invoice',{
        url: '/invoice/view',
        controller: 'invoiceCtrl',
        templateUrl:'resources/templates/invoice.html'
    }).state('invoiceAdd',{
    	url: '/invoie/create',
    	controller: 'createInvoiceCtrl as createInvoiceCtrl',
    	templateUrl: 'resources/templates/invoiceEdit.html'
    });
	
	$urlRouterProvider.otherwise('/');
});