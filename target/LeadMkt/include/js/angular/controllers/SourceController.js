var leadApp = angular.module('leadApp',['ui.bootstrap']);
leadApp.controller ('SourceController', function($scope,$uibModal,SourceService){
	toastr.options = {
			extendedTimeOut: 1000,
			timeOut: 5000,
			positionClass: 'toast-top-center',
	}

	$scope.leadStatusList=[];
	$scope.leadSourceList=[];
	$scope.initSource = function(){
		$scope.getLeadSourceList();	
	}

	$scope.getLeadSourceStatusList=function(){
		SourceService.getLeadSourceStatusList().then(function(result){
			$scope.leadStatusList=result;
		});		
	}

	$scope.getLeadSourceList=function(){
		SourceService.getLeadSourceList().then(function(result){
			$scope.leadSourceList=result;
		});		
	}

	$scope.deleteLeadSource=function(leadSourcePkId,index){
		$scope.index=index;
		var v= confirm("Are u sure want to delete?");
		if(v==true){		
			SourceService.deleteLeadSource(leadSourcePkId).then(function(result){
				if(result == true){
					$scope.leadSourceList.splice($scope.index,1);
					toastr["success"]("Lead Source details deleted successfully.<br /><br />Thank You!");
				}
			});
		}	
	}



	$scope.createSource= function () {
		$scope.getLeadSourceStatusList();
		$scope.leadSource={};
		var modalInstance = $uibModal.open({
			templateUrl: 'createSource.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
			},
		});
	};

	$scope.editSource= function (leadSource) {
		$scope.getLeadSourceStatusList();
		$scope.leadSource=leadSource;
		var modalInstance = $uibModal.open({
			templateUrl: 'createSource.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
				leadSource: function () {
					return $scope.leadSource;
				}
			},
		});

	};
});

leadApp.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance,SourceService) {
	//$scope.leadSource={};
	$scope.cancel = function () {
		$uibModalInstance.dismiss();

	};

	$scope.dt = new Date();
	$scope.clear = function() {
		$scope.dt = null;
	};


	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};
	$scope.open2 = function() {
		$scope.popup12.opened = true;
	};


	$scope.setDate = function(month,day,year) {
		$scope.dt = new Date(month,day,year);
	};

	$scope.format = 'dd/MM/yyyy';
	$scope.popup1 = {
			opened: false
	};
	$scope.popup2 = {
			opened: false
	};
	$scope.fromDateOptions={'minDate':new Date()};
	////
	$scope.dt = new Date();
	$scope.clear = function() {
		$scope.dt = null;
	};


	$scope.open3 = function() {
		$scope.popup3.opened = true;
	};
	$scope.open4 = function() {
		$scope.popup4.opened = true;
	};


	$scope.setDate = function(month,day,year) {
		$scope.dt = new Date(month,day,year);
	};

	$scope.format = 'dd/MM/yyyy';

	$scope.popup3 = {
			opened: false
	};
	$scope.popup4 = {
			opened: false
	};
	$scope.saveEditSource=function(leadSource){
		SourceService.saveEditLeadSource(leadSource).then(function(result){
			$scope.leadSource={};
			$uibModalInstance.dismiss();
			$scope.getLeadSourceList();	
		});
	}
});