var dmsApp = angular.module('dmsApp',['ui.bootstrap']);
dmsApp.controller ('MaterialController', function($scope,$uibModal,MaterialService){
	/* toastr.options = {
				extendedTimeOut: 1000,
				timeOut: 5000,
				positionClass: 'toast-top-center',
				}*/
	$scope.materials=[];
	$scope.sapMaterials=[];
	$scope.addSAPMaterial=[1];
	$scope.materialIndex=null;
	$scope.sbuTypeList=[];
	$scope.initMaterial = function(){
		MaterialService.getMaterialList().then(function(result){
		$scope.materials = result;
	});	
}
	
	$scope.getSbuTypeList=function(){
		MaterialService.getSbuTypeList().then(function(result){
			$scope.sbuTypeList=result;
		});		
	}

	
    $scope.addRow = function() {
		$scope.addSAPMaterial.push($scope.addSAPMaterial.length+1);	
    	$scope.addSAPMaterial.length+1;
	}
    
    $scope.removeRow = function(index) {
    	$scope.sapMaterials.splice(index,1);
    	$scope.addSAPMaterial.splice(index,1);
	}

	  $scope.openMaterialModal = function (material,index) {
		  $scope.material=material;
		  $scope.materialIndex=index;
		  $scope.getSbuTypeList();
	 
		 	var modalInstance = $uibModal.open({
	        templateUrl: 'addMaterial.html',
	        controller: 'ModalInstanceCtrl',
	        scope: $scope,
	        resolve: {
	        	material: function () {
	            return $scope.material;
	            
	          }
	        },
	      });
	    };
	    
		
	    //Modal Pop for remove Distributor
	    $scope.openRemoveMaterialModal = function (materialId,index) {
	    	
			  $scope.materialId=materialId;
			  $scope.materialIndex=index;
			 	    var modalInstance = $uibModal.open({
		        templateUrl: 'removeMaterial.html',
		        controller: 'ModalInstanceCtrl',
		        scope: $scope,
		        resolve: {
		        	materialId: function () {
		            return $scope.materialId;
		            
		          }
		        },
		      });
			 	  
		    };
	    
	

	 
});

dmsApp.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance,MaterialService) {
    $scope.cancel = function () {
        $uibModalInstance.dismiss();
       
    };
	$scope.saveMaterial = function(material,sapMaterials){
		material.materialPlant=sapMaterials;
	//	alert(JSON.stringify(material));
		MaterialService.saveMaterial(material).then(function(result){
				$scope.material=result;
				if (material.materialPkId == null || material.materialPkId == undefined || material.materialPkId==''   ) {
					$scope.materials.splice(0,0,$scope.material);
				}else{
					$scope.materials.splice($scope.materialIndex,1,$scope.material);
					
				}
				$scope.material='';
				});
		$uibModalInstance.close($scope.material);
		/* if(material.materialPkId == null || material.materialPkId == undefined || material.materialPkId==''  ){
			toastr["success"]("Material is successfully Added.<br /><br />Thank You!")
	     }else{
	    	 toastr["success"]("Material is successfully Updated.<br /><br />Thank You!")
	}*/
					
	}
	   $scope.deleteMaterial= function(materialId){
		   MaterialService.deleteMaterial(materialId).then(function(result){
				if(result){
					$scope.materials.splice($scope.materialIndex,1);
					
				}
				$uibModalInstance.close();
	   			
			    //	 toastr["success"]("Material deleted successfully <br /><br />Thank You!")
		});
		}
	
	

});