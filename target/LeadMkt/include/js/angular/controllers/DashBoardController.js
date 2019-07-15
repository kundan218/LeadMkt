var leadApp=angular.module('leadApp',['ui.bootstrap','datatables', 'datatables.bootstrap']);

leadApp.controller ('DashBoardController',function($scope,$uibModal,$filter,$window,DashBoardService,DTOptionsBuilder,$compile,$rootScope,DTColumnBuilder){

	$scope.myvalue=false;
	//$scope.locationId=locationPkId;
	$scope.showRole = function(){
		$scope.myvalue = true; 
	};

	$scope.init=function(role){
		$scope.role=role;
		$scope.regionList();

		$scope.prepareTableLeadManage();	
	}
	toastr.options = {
			extendedTimeOut: 1000,
			timeOut: 5000,
			positionClass: 'toast-top-center',
	}
	DashBoardService.getLeadCount().then(function(result){
		$scope.leadCount=result;
		$scope.totalLead=result[0].leadCount;

	});
	DashBoardService.getLeadSourceCount().then(function(result){
		$scope.leadResourceCount=result;
	});
	$scope.regionList=function(){
		DashBoardService.getRegion().then(function(result){
			$scope.region=result;
			// alert(JSON.stringify(result));
		});
	}
	$scope.assigned=function(region){
		var regionId=region.regionPkId;
		DashBoardService.getRsmList(regionId).then(function(result){
			$scope.regionRsm=result;
			// alert(JSON.stringify(result));
		});

		DashBoardService.getSoList(regionId).then(function(result){
			$scope.regionSo=result;
			// alert(JSON.stringify(result));
		});
		
		DashBoardService.getStockyardList(regionId).then(function(result){
			$scope.regionStockyard=result;
		});
	}
	$scope.prepareTableLeadManage = function () {

		$scope.dtColumnsLeadManage = [
			DTColumnBuilder.newColumn("#", "#").renderWith(renderSrNo),
			DTColumnBuilder.newColumn("", "Lead No").renderWith(renderLeadNo),
			DTColumnBuilder.newColumn("name", "Company Name").withOption('name', 'Name'),
			DTColumnBuilder.newColumn("", "Region").renderWith(renderRegion),
			DTColumnBuilder.newColumn("leadSourceFkId.companyName", "Lead Source").withOption('source', 'Source'),	
			DTColumnBuilder.newColumn("full.createdDate", "Created Date").renderWith(renderCreatedDate),
			DTColumnBuilder.newColumn("createdBy.name", "Created By").withOption('name', 'Name'),
			DTColumnBuilder.newColumn("", "Assigned To").renderWith(renderAssignedTo),
			DTColumnBuilder.newColumn("", "Lead Status").renderWith(renderLeadStatus),
			DTColumnBuilder.newColumn("", "Ageing").renderWith(renderAgeing),
			DTColumnBuilder.newColumn("Action", "Action").renderWith(renderAction),
			]
		function renderSrNo(data, type, full, meta) {
			return meta.settings._iDisplayStart+meta.row + 1;
		}
		function renderCreatedDate(data, type, full, meta) {
			var rs = "";
			rs += $filter('date')(full.createdDate, 'dd-MMM-yyyy');	
			return rs;
		}
		function renderLeadNo(data, type, full, meta) {
			var rs = "";
			rs+='<a href="#" ng-click="openLeadDetails(\''+full.leadManagePkId+'\')"><strong>'+full.leadId+'</strong></a>';
			return rs;
		}
		function renderRegion(data, type, full, meta) {
			var rs = "";
			rs+='<strong>'+full.regionFkId.regionName+'</strong>';
			return rs;
		}
		function renderLeadStatus(data, type, full, meta) {
			var rs = "";
			if(full.leadStatus.commonConstantPkId==25)
			{
				rs+='<label class="label label-pill label-success label d-block">'+full.leadStatus.commonConstantValue+'</label>';
			}
			else if(full.leadStatus.commonConstantPkId==24){
				rs+='<label class="label label-pill label-danger d-block">'+full.leadStatus.commonConstantValue+'</label>';
			}
			else
			{
				rs+='<label class="label label-pill label-primary d-block">'+full.leadStatus.commonConstantValue+'</label>';
			}
			return rs;
		}
		function renderAgeing(data, type, full, meta) {
			var rs = "";
			var createdDate = full.createdDate;
			var currentDate = new Date();
			var minutes = 1000 * 60;
			var hours = minutes * 60;
			var days = hours * 24;
			rs += (Math.round((currentDate - createdDate) / days));
			return rs;
		}
		function renderAssignedTo(data, type, full, meta) {
			var rs = "";
			if(full.leadStatus.commonConstantPkId==25){
				rs+='<strong>'+full.convertedToSaleBy.name+'</strong>'
			}
			if(full.leadStatus.commonConstantPkId==24){
				rs+='<strong>'+full.cancelledBy.name+'</strong>'
			}
			if(full.leadStatus.commonConstantPkId==22){
				rs+='<strong>'+full.rsmAssignFkId.name+'</strong>'
			}if(full.leadStatus.commonConstantPkId==23){
				rs+='<strong>'+full.soAssignFkId.name+'</strong>'
			}
			if(full.leadStatus.commonConstantPkId==28){
				rs+='<strong>'+full.stockyardAssignFkId.name+'</strong>'
			}
			return rs;
		}

		function renderAction(data, type, full, meta) {
			//var rs+ = '<a href="#cancelPopup" data-toggle="modal" class="btn btn-danger btn-xs btn-pill"><i class="fa fa-close" data-toggle="tooltip" title="Cancel Lead"></i></a>';;
			var rs="";
			if($scope.role=='REGIONAL_MANAGER'){
				if(full.leadStatus.commonConstantPkId==22){
					rs+= '<a href="" ng-click="openCancelLeadModal(\''+full.leadManagePkId+'\')" class="btn btn-danger btn-xs btn-pill mr-1"><i class="fa fa-close" data-toggle="tooltip" title="Cancel lead"></i></a>';
				}
				if(full.leadStatus.commonConstantPkId==22){
					rs+= '<a href="" ng-click="openAssignLeadModal(\''+full.leadManagePkId+'\')" class="btn btn-success btn-xs btn-pill mr-1"><i class="fa fa-check" data-toggle="tooltip" title="Assign lead"></i></a>';
				}
				if(full.leadStatus.commonConstantPkId==22){
					rs+= '<a href="" ng-click="openLeadCloseModal(\''+full.leadManagePkId+'\')"  class="btn btn-primary btn-xs btn-pill mr-1"><i class="fa fa-bullhorn" data-toggle="tooltip" title="Convert to Sale"></i></a>';
				}
			}
			if($scope.role=='SALES_MARKETING'){
				if(full.leadStatus.commonConstantPkId==23){
					rs+= '<a href="" ng-click="openCancelLeadModal(\''+full.leadManagePkId+'\')" class="btn btn-danger btn-xs btn-pill mr-1"><i class="fa fa-close" data-toggle="tooltip" title="Cancel lead"></i></a>';
					rs+= '<a href="" ng-click="openLeadCloseModal(\''+full.leadManagePkId+'\')"  class="btn btn-primary btn-xs btn-pill mr-1"><i class="fa fa-bullhorn" data-toggle="tooltip" title="Convert to Sale"></i></a>';
					rs+= '<a href="" ng-click="openAssignLeadModalBySales(\''+full.leadManagePkId+'\')" class="btn btn-success btn-xs btn-pill mr-1"><i class="fa fa-check" data-toggle="tooltip" title="Assign lead"></i></a>';
				}
				
				
			}
			if($scope.role=='STOCKYARD_MANAGER'){
				if(full.leadStatus.commonConstantPkId==28){
					rs+= '<a href="" ng-click="openCancelLeadModal(\''+full.leadManagePkId+'\')" class="btn btn-danger btn-xs btn-pill mr-1"><i class="fa fa-close" data-toggle="tooltip" title="Cancel lead"></i></a>';
					rs+= '<a href="" ng-click="openLeadCloseModal(\''+full.leadManagePkId+'\')"  class="btn btn-primary btn-xs btn-pill mr-1"><i class="fa fa-bullhorn" data-toggle="tooltip" title="Convert to Sale"></i></a>';
					//rs+= '<a href="" ng-click="openAssignLeadModalBySales(\''+full.leadManagePkId+'\')" class="btn btn-success btn-xs btn-pill mr-1"><i class="fa fa-check" data-toggle="tooltip" title="Assign lead"></i></a>';
				}
				
				
			}
			if($scope.role=='ADMIN'){
				/*rs+= '<a href="" ng-click="openCancelLeadModal(\''+full.leadManagePkId+'\')" class="btn btn-danger btn-xs btn-pill mr-1"><i class="fa fa-close" data-toggle="tooltip" title="Cancel lead"></i></a>';
				rs+= '<a href="" ng-click="openAssignLeadModal(\''+full.leadManagePkId+'\')" class="btn btn-success btn-xs btn-pill mr-1"><i class="fa fa-check" data-toggle="tooltip" title="Assign lead"></i></a>';*/
			}
			// rs+ = '<a href=""  class="btn btn-danger btn-xs btn-pill"><i class="fa fa-close" data-toggle="tooltip" title="Cancel Lead"></i></a>';
			return rs;
		}

		$scope.dtOptionsLeadManage = DTOptionsBuilder.newOptions()
		.withOption('fnServerParams', function (aoData) {
			var arr = $("#dtDataTableDto").serializeArray();
			$.each(arr, function (i, field) {
				if (field.value != null && field.value != '') {
					aoData[field.name] = field.value;
				}
			});
		})

		.withOption('ajax', {
			contentType: 'application/json',
			url: 'getLeadManageList',
			type: 'POST',
			data: function (data, dtInstance) {
				return JSON.stringify(data);
			}
		})
		.withDataProp(function (json) {
			json.draw = json.draw;
			json.recordsTotal = json.recordsTotal;
			json.recordsFiltered = json.recordsFiltered;
			//alert(JSON.stringify(json.leadManageDtoList));
			return json.leadManageDtoList;
		})
		.withOption('serverSide', true)
		.withOption('destroy', true)
		.withBootstrap()
		.withPaginationType('simple_numbers')
		.withDisplayLength(10)
		.withOption('createdRow', function (row) {
			$compile(angular.element(row).contents())($scope);
		})
		.withOption('saveState', false)
		.withOption('order', [0, 'asc'])
		.withOption('sSearch', 'search');
	}
	$scope.openCancelLeadModal=function(leadManagePkId){
		DashBoardService.getLeadDetails(leadManagePkId).then(function(result){
			$scope.leadDetails=result;
		});
		$scope.leadManagePkId=leadManagePkId;
		var modalInstance = $uibModal.open({
			templateUrl: 'cancelLead.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
			},
		});


	}
	$scope.openAssignLeadModal=function(leadManagePkId){
		DashBoardService.getLeadDetails(leadManagePkId).then(function(result){
			$scope.leadDetails=result;
		});
		DashBoardService.getLocationList().then(function(result){
			//alert(JSON.stringify(result));
			$scope.locationList=result;
			$scope.licationId=result[0].locationPkId;
		//	alert(licationId);
		});
		DashBoardService.getSmList().then(function(result){
			//alert(JSON.stringify(result));
			$scope.smList=result;
		});

		DashBoardService.getStockyardList().then(function(result){
			//alert(JSON.stringify(result));
			$scope.stockyardList=result;
		});


		$scope.leadManagePkId=leadManagePkId;
		var modalInstance = $uibModal.open({
			templateUrl: 'assignLead.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
			},
		});

	}
	$scope.openAssignLeadModalBySales=function(leadManagePkId){
		DashBoardService.getLeadDetails(leadManagePkId).then(function(result){
			$scope.leadDetails=result;
		});
		DashBoardService.getLocationList().then(function(result){
			$scope.locationList=result;
		});

		DashBoardService.getStockyardList().then(function(result){
			$scope.stockyardList=result;
		});


		$scope.leadManagePkId=leadManagePkId;
		var modalInstance = $uibModal.open({
			templateUrl: 'assignLeadBySales.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
			},
		});

	}
	$scope.openLeadCloseModal=function(leadManagePkId){
		DashBoardService.getLeadDetails(leadManagePkId).then(function(result){
			$scope.leadDetails=result;
		});
		DashBoardService.getActionList().then(function(result){
			$scope.leadAction=result;

		});
		$scope.leadManagePkId=leadManagePkId;
		var modalInstance = $uibModal.open({
			templateUrl: 'closeLead.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
			},
		});

	}
	$scope.openLeadDetails=function(leadManagePkId){
		DashBoardService.getLeadDetails(leadManagePkId).then(function(result){
			$scope.leadDetails=result;
		});
		$scope.leadManagePkId=leadManagePkId;
		var modalInstance = $uibModal.open({
			templateUrl: 'openLeadDeatils.html',
			controller: 'ModalInstanceCtrl',
			scope: $scope,
			resolve: {
			},
		});

	}



});
leadApp.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance,DashBoardService) {
	$scope.comment=null;
	$scope.cancelLead = function(leadManagePkId, status, comment) {
		/*alert(leadManagePkId)
alert(status)
alert(comment)*/	
		DashBoardService.cancelByRsm($scope.leadManagePkId,status,comment).then(function(result) {

			if(result)
			{
				toastr["success"]("lead cancelled successfully <br /><br />Thank You!");
				$uibModalInstance.dismiss();
				window.location.reload();
			}
			else{
				toastr["error"]("lead not cancelled successfully <br /><br />Thank You!");

			}
		});


	}


	$scope.selectRole=function(status,role){
		$scope.stockDisable=false;
		$scope.smDisable=false;
		
if(status==23){
	$scope.smDisable=true;
}
else if(status==28){
	$scope.stockDisable=true;
}
		$scope.status=status;
		$scope.roleList=role;

	}
$scope.reset=function(sm)
{
	$scope.sm=sm;
	$scope.sm={};
	$scope.stockDisable=false;
	$scope.smDisable=false;
	}


	$scope.assignLead=function(status,sm,leadManagePkId,locationPkId){
	//	alert(JSON.stringify(locationPkId));


		DashBoardService.assignLeadByRsm(leadManagePkId,$scope.status,sm.userPkId,$scope.roleList).then(function(result) {
			if(result)
			{
				toastr["success"]("lead assigned successfully <br /><br />Thank You!");
				$uibModalInstance.dismiss();
				window.location.reload();				
			}
			else{
				toastr["error"]("lead not assigned successfully <br /><br />Thank You!");
			}
		});
	}
	$scope.assignLeadBySales=function(status,sm,leadManagePkId){

		DashBoardService.assignLeadBySales(leadManagePkId,status,sm.userPkId,$scope.roleList).then(function(result) {
			if(result)
			{
				toastr["success"]("lead assigned successfully <br /><br />Thank You!");
				$uibModalInstance.dismiss();
				window.location.reload();				
			}
			else{
				toastr["error"]("lead not assigned successfully <br /><br />Thank You!");
			}
		});
	}
	$scope.closeLead=function(leadManagePkId,action,comment){
		DashBoardService.assignLeadActionByRsm(leadManagePkId,action.commonConstantPkId,comment).then(function(result) {
			if(result)
			{
				toastr["success"]("lead action assigned successfully <br /><br />Thank You!");
				$uibModalInstance.dismiss();
				window.location.reload();				
			}
			else{
				toastr["error"]("lead action not assigned successfully <br /><br />Thank You!");				
			}
		});
	}

	$scope.cancel = function() {
		$uibModalInstance.dismiss();

	};

});
