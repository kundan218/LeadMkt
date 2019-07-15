var leadApp = angular.module('leadApp', [ 'ui.bootstrap', 'datatables',
	'datatables.bootstrap' ]);
leadApp
.controller(
		'LeadController',
		function($scope, $uibModal, $filter, $window, LeadService,
				DashBoardService, DTOptionsBuilder, $compile,
				$rootScope, DTColumnBuilder) {
			toastr.options = {
					extendedTimeOut : 5000,
					timeOut : 5000,
					positionClass : 'toast-top-center',
			}
			$scope.uploadBulk=[];
			$scope.editFlag = false;
			$scope.material = [ 1 ];
			$scope.materialList = [];
			$scope.leadDetails = {};
			$scope.leadManage = {};

			$scope.init = function() {
				LeadService.getCountry().then(function(result) {
					$scope.countries = result;
				});
				
				LeadService.getStateList().then(function(result) {
					$scope.states = result;
				});

				$scope.regionList();
				$scope.leadTypeList();
				$scope.leadSourceList();
				$scope.sbuList();
				$scope.prepareTableLeadManage();
				$scope.showRegionList();

				if ($window.localStorage.getItem("leadManage") != null) {
					// alert("welcome")
					$scope.leadManage = angular
					.fromJson($window.localStorage
							.getItem("leadManage"));
					openDetail();
					$scope.editFlag = true;
					$scope
					.materialListFunction($scope.leadManage.sbuFkId);
					for (var i = 0; i < $scope.leadManage.leadMaterialMaps.length; i++) {
						var material = $scope.leadManage.leadMaterialMaps[i];
						// alert("--before::material::"+JSON.stringify(material));
						material["materialFkId"]["materialPkId"] = ""
							+ material.materialFkId.materialPkId
							+ "";
						// alert("--after::material::"+JSON.stringify(material));
						$scope.materialList.push(material);

					}
					$window.localStorage.removeItem("leadManage");
				} else {
					$scope.materialList.push({});
				}

			}

			$scope.rsmUnderExecutive = function(region) {
				var regionId = region.regionPkId;
				DashBoardService.getRsmList(regionId).then(
						function(result) {
							// alert(JSON.stringify(result));
							$scope.regionRmList = result;
							// alert(JSON.stringify(result));
						});

			}

			

			$scope.addRow = function() {
				$scope.materialList.push({});
			}

			$scope.removeRow = function(index) {
				$scope.materialList.splice(index, 1);
				if ($scope.materialList.length <= 0) {
					$scope.materialList = [];
					$scope.materialList.push({});
				}
			}
			$scope.checkMaterialFunction = function(index) {
				/* alert("--index::"+index); */
				for (var i = 0; (i <= $scope.materialList.length && i != index); i++) {
					if ($scope.materialList[i].materialFkId.materialPkId == $scope.materialList[index].materialFkId.materialPkId) {
						//	alert("Duplicate Select");
						$scope.materialList[index].materialFkId.materialPkId = "";
					}
				}
			}

			$scope.materialListFunction = function(sbuObj) {
				$scope.sbuFkId = sbuObj.commonConstantPkId;
				LeadService.getMaterial($scope.sbuFkId).then(
						function(result) {
							$scope.material = result;
							if (!$scope.editFlag) {
								$scope.materialList = [];
								$scope.materialList.push({});
							}

						});
			}

			$scope.sbuList = function() {
				LeadService.getSbu().then(function(result) {
					$scope.sbu = result;
				});
			}

			$scope.leadTypeList = function() {
				LeadService.getLeadType().then(function(result) {
					$scope.leadType = result;
					// alert(result);
				});
			}

			$scope.regionList = function() {
				LeadService.getRegion().then(function(result) {
					$scope.region = result;
					// alert(JSON.stringify(result));
				});
			}

			$scope.showRegionList = function() {
				LeadService.getRegion().then(function(result) {
					$scope.showRegion = result;
					// alert(JSON.stringify(result));
				});
			}

			$scope.leadSourceList = function() {
				LeadService.getLeadSource().then(function(result) {
					$scope.leadSource = result;
					// alert(JSON.stringify(result));
				});
			}

			$scope.saveLead = function(status, leadManage) {

				$scope.loading = false;
				$scope.leadDetails = leadManage;
				$scope.leadDetails["leadStatus"] = {};
				$scope.leadDetails.leadStatus.commonConstantPkId = status;
				$scope.leadDetails["leadMaterialMaps"] = $scope.materialList;
				LeadService
				.saveLeadManage($scope.leadDetails)
				.then(
						function(result) {
							if (result) {
								if (status) {
									//	alert(status);
									$scope.loading = true;
									toastr["success"]
									("Lead Added successfully.<br /><br />Thank You!");
									$window.location.href = '../executive/executiveHistory';
									$scope.cancel();
								} else {
									toastr["success"]
									("Lead Drafted/updated successfully.<br /><br />Thank You!");
									$scope.loading = true;
									$window.location.href = '../executive/executiveHistory';
									$scope.cancel();
								}
							} else {
								if (status) {
									alert("Unable to Submit");
								} else {
									alert("Unable to Saved/Drafted");
								}
							}

						});

			}



			$scope.prepareTableLeadManage = function() {
				$scope.dtColumnsLeadManage = [
					DTColumnBuilder.newColumn("#", "#").renderWith(
							renderSrNo),

							DTColumnBuilder.newColumn("leadId", "Lead No")
							.renderWith(renderLeadNo),
							DTColumnBuilder.newColumn("name",
							"Company Name").withOption('name',
							'Name'),
							DTColumnBuilder.newColumn(
									"leadSourceFkId.companyName",
							"Lead Source").withOption('source',
							'Source'),
							DTColumnBuilder.newColumn("full.createdDate",
							"Created Date").renderWith(
									renderCreatedDate),
									DTColumnBuilder.newColumn("rsmAssignFkId.name",
									"Assigned Rsm").withOption('name',
									'Name'),
									DTColumnBuilder.newColumn(
											"leadStatus.commonConstantValue",
									"Lead Status").renderWith(renderLeadStatus),
									DTColumnBuilder.newColumn("Action", "Action")
									.renderWith(renderAction),

									]
				function renderSrNo(data, type, full, meta) {
					return meta.settings._iDisplayStart+meta.row + 1;
				}
				function renderCreatedDate(data, type, full, meta) {
					var rs = "";
					rs += $filter('date')(full.createdDate,
					'dd-MMM-yyyy');
					return rs;
				}

				function renderLeadNo(data, type, full, meta) {
					var rs = "";
					rs+='<a href="#" ng-click="openLeadDetails(\''+full.leadManagePkId+'\')"><strong>'+full.leadId+'</strong></a>';
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
					else if(full.leadStatus.commonConstantPkId==26){
						rs+='<label class="label label-pill label-warning d-block">'+full.leadStatus.commonConstantValue+'</label>';
					}
					else
					{
						rs+='<label class="label label-pill label-primary d-block">'+full.leadStatus.commonConstantValue+'</label>';
					}
					return rs;
				}


				function renderAction(data, type, full, meta) {
					var rs = "";
					if (full.leadStatus.commonConstantPkId == 26) {
						rs += '<a href="" ng-click="Edit(\''
							+ full.leadManagePkId
							+ '\')" class="btn btn-info btn-xs"><i class="fa fa-edit"></i></a>';
					}

					return rs;
				}

				$scope.dtOptionsLeadManage = DTOptionsBuilder
				.newOptions()
				.withOption(
						'fnServerParams',
						function(aoData) {
							var arr = $("#dtDataTableDto")
							.serializeArray();
							$
							.each(
									arr,
									function(i, field) {
										if (field.value != null
												&& field.value != '') {
											aoData[field.name] = field.value;
										}
									});
						})

						.withOption('ajax', {
							contentType : 'application/json',
							url : 'getLeadManageList',
							type : 'POST',
							data : function(data, dtInstance) {
								return JSON.stringify(data);
							}
						})
						.withDataProp(
								function(json) {
									json.draw = json.draw;
									json.recordsTotal = json.recordsTotal;
									json.recordsFiltered = json.recordsFiltered;
									// alert(JSON.stringify(json.leadManageDtoList));
									return json.leadManageDtoList;
								}).withOption('serverSide', true)
								.withOption('destroy', true).withBootstrap()
								.withPaginationType('simple_numbers')
								.withDisplayLength(10).withOption(
										'createdRow',
										function(row) {
											$compile(
													angular.element(row)
													.contents())
													($scope);
										}).withOption('saveState', false)
										.withOption('order', [ 0, 'asc' ]).withOption(
												'sSearch', 'search');
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

			$scope.Edit = function(leadManagePkId) {

				DashBoardService
				.getLeadDetails(leadManagePkId)
				.then(
						function(result) {
							$scope.leadDetails = result;

							$window.localStorage["leadManage"] = JSON
							.stringify($scope.leadDetails);
							// alert("here is the data"
							// +$window.localStorage.getItem("leadManage"))
							$window.location.href = '../executive/home';
						});
			}
			$scope.bulkUpload= function () {
				var modalInstance = $uibModal.open({
					templateUrl: 'bulkUpload.html',
					controller: 'ModalInstanceCtrl',
					scope: $scope,
				});	
			};

		});


leadApp.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance,LeadService,$window) {

	$scope.cancel = function() {
		$uibModalInstance.dismiss();

	};
	$scope.bulkUpload=false;
	$scope.$on("BulkDocument", function (event, args) { 		
		$scope.$apply(function () {  
			$scope.uploadBulk.push(args.file);


		});  
	});

	$scope.bulkUploadExcel = function() {
		$scope.bulkUpload=true;

		LeadService.getBulkUploadExcel($scope.uploadBulk).then(function(result) {

			if(result)
			{
				$scope.bulkUpload=false;		
				$uibModalInstance.dismiss();
				toastr["success"]
				("Bulk excel uploaded succesfully.<br /><br />Thank You!");
				$window.location.href = '../executive/executiveHistory';
			}


		});
	}



});
