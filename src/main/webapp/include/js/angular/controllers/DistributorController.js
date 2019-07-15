var dmsApp = angular.module('dmsApp',['ui.bootstrap']);
dmsApp.controller ('DistributorController', function($scope,$uibModal,$window,DistributorService){
	/* toastr.options = {
				extendedTimeOut: 1000,
				timeOut: 5000,
				positionClass: 'toast-top-center',
				}*/
	$scope.distributors=[];
	$scope.editDisFlag=false;
	$scope.states=[];
	$scope.countrys=[];
	$scope.salesOfficers=[];
	$scope.regionalOfficers=[];
	$scope.locations=[];
	 $scope.distributorIndex=null;
	$scope.ph_numbr = /^[0-9]{10}$/;
	$scope.distributerDetail={};
	$scope.initDistributor = function(){
		DistributorService.getDistributorList().then(function(result){
		$scope.distributors = result;
	});
		DistributorService.getStateList().then(function(result){
			$scope.states = result;
		});
		
		DistributorService.getCountryList().then(function(result){
			$scope.countrys = result;
		});
		
		DistributorService.getSOList().then(function(result){
			$scope.salesOfficers = result;
		});
		
		DistributorService.getRMList().then(function(result){
			$scope.regionalOfficers = result;
		});
		
		DistributorService.getLocationList().then(function(result){
			$scope.locations = result;
		});
	
			DistributorService.getDistributorById().then(function(result){
				$scope.distributerDetail=result;
			});
		
}
	$scope.editDistributer=function(){
		$scope.editDisFlag=true;
	}
	
	

	  $scope.openDistributorModal = function (distributor,index) {//alert(JSON.stringify(distributor.regionalManager));
		  $scope.distributor=distributor;
		  $scope.distributorIndex=index;
		 	    var modalInstance = $uibModal.open({
	        templateUrl: 'addDistributor.html',
	        controller: 'ModalInstanceCtrl',
	        scope: $scope,
	        resolve: {
	        	distributor: function () {
	            return $scope.distributor;
	            
	          }
	        },
	      });
	    };
	    
		
	    //Modal Pop for remove Distributor
	    $scope.openRemoveDistributorModal = function (distributorId,index) {
			  $scope.distributorId=distributorId;
			  $scope.distributorIndex=index;
			 	    var modalInstance = $uibModal.open({
		        templateUrl: 'removeDistributor.html',
		        controller: 'ModalInstanceCtrl',
		        scope: $scope,
		        resolve: {
		        	distributorId: function () {
		            return $scope.distributorId;
		            
		          }
		        },
		      });
			 	  
		    };
			$scope.saveDistributorDetail = function(distributerDetail){
			//	alert(JSON.stringify(distributerDetail));
				DistributorService.saveDistributor(distributerDetail).then(function(result){
						$scope.distributor=result;
						if (distributerDetail.distributorPkId == null || distributerDetail.distributorPkId == undefined || distributerDetail.distributorPkId==''   ) {
							$scope.distributors.splice(0,0,$scope.distributor);
						}else{
							$scope.distributors.splice($scope.distributorIndex,1,$scope.distributor);
							
						}
						$scope.distributor='';
						});
				 if(distributerDetail.distributorPkId == null || distributerDetail.distributorPkId == undefined || distributerDetail.distributorPkId==''  ){
					toastr["success"]("Distributor is successfully Added.<br /><br />Thank You!")
			     }else{
			    	 toastr["success"]("Distributor is successfully Updated.<br /><br />Thank You!")
			}
				 $scope.editDisFlag=false;
							
			}

			 $scope.cancelProfile = function () {
				 $window.location.href = 'dashboard';
			       
			    };
});

dmsApp.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance,DistributorService) {
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
       
    };
	$scope.saveDistributor = function(distributor){
		//alert(JSON.stringify(distributor));
		DistributorService.saveDistributor(distributor).then(function(result){
				$scope.distributor=result;
				if (distributor.distributorPkId == null || distributor.distributorPkId == undefined || distributor.distributorPkId==''   ) {
					$scope.distributors.splice(0,0,$scope.distributor);
				}else{
					$scope.distributors.splice($scope.distributorIndex,1,$scope.distributor);
					
				}
				$scope.distributor='';
				});
		$uibModalInstance.close($scope.distributor);
		 if(distributor.distributorPkId == null || distributor.distributorPkId == undefined || distributor.distributorPkId==''  ){
			toastr["success"]("Distributor is successfully Added.<br /><br />Thank You!")
	     }else{
	    	 toastr["success"]("Distributor is successfully Updated.<br /><br />Thank You!")
	}
					
	}
	   $scope.deleteDistributor= function(distributorId){
		   DistributorService.deleteDistributor(distributorId).then(function(result){
				if(result){
					$scope.distributors.splice($scope.distributorIndex,1);
					
				}
				$uibModalInstance.close();
	   			
			    	 toastr["success"]("Distributor deleted successfully <br /><br />Thank You!")
		});
		}
	   
	  /* DistributorService.getDistributorById(userId).then(function(result){
   		$scope.user=result;
  	if($scope.user !=null && $scope.user !=undefined && $scope.user !=''){
  		if($scope.user.userLocationRoleMaps !=null && $scope.user.userLocationRoleMaps !=undefined && $scope.user.userLocationRoleMaps !=''){
   		angular.forEach($scope.user.userLocationRoleMaps, function (userRoleLocation,index) {
   			$scope.userLocationRoleList.push(userRoleLocation.role);
   			 $scope.location=userRoleLocation.location;
        });
   		 $scope.role=$scope.userLocationRoleList;	
   		
  	}else{
  		$scope.passwordhide=false;	
  	 $scope.location='';
  	}
  		
  	}else{
  		$scope.passwordhide=true;
  	}

		 $scope.userIndex=index;
		 	    var modalInstance = $uibModal.open({
	        templateUrl: 'user.html',
	        controller: 'ModalInstanceCtrl',
	        scope: $scope,
	        resolve: {
	        	user: function () {
	            return $scope.user;
	            
	          }
	        },
	      });
   });  
	*/

});