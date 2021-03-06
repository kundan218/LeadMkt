leadApp.factory('DashBoardService', function($http, $q){
	return {
		getLeadCount : function(){
			var deferred = $q.defer(); 
			$http.get('./getLeadCount').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		getLeadSourceCount : function(){
			var deferred = $q.defer(); 
			$http.get('./getLeadSourceCount').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		getLeadDetails : function(leadManagePkId){
			var deferred = $q.defer(); 
			$http.get('./getLeadDetails/'+leadManagePkId).success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},


		cancelByRsm : function(leadManagePkId,status,comment){

			var deferred = $q.defer(); 
			$http.post('./leadCancelByRsm/'+leadManagePkId+'/'+status+'/'+comment).success(function(result){
				deferred.resolve(result);
			});


			return deferred.promise;
		},
		getLocationList : function(){

			var deferred = $q.defer(); 
			$http.get('./getLocationList2').success(function(result){
				deferred.resolve(result);
			});


			return deferred.promise;
		},
		getSmList : function(){

			var deferred = $q.defer(); 
			$http.get('./getSmList').success(function(result){
				deferred.resolve(result);
			});

			return deferred.promise;
		},
		
		getStockyardList : function(regionId){
			var deferred=$q.defer();
			$http.get('getStockyardList/'+regionId).success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
		assignLeadByRsm : function(leadManagePkId,status,userPkId,roleList){

			var deferred = $q.defer(); 
			$http.post('./assignLeadByRsm/'+leadManagePkId+'/'+status+'/'+userPkId+'/'+roleList).success(function(result){
				deferred.resolve(result);
			});

			return deferred.promise;
		},
		assignLeadBySales : function(leadManagePkId,status,smPkId){

			var deferred = $q.defer(); 
			$http.post('./assignLeadActionBySales/'+leadManagePkId+'/'+smPkId+'/'+status).success(function(result){
				deferred.resolve(result);
			});

			return deferred.promise;
		},
		getActionList : function(){

			var deferred = $q.defer(); 
			$http.get('./getActionList').success(function(result){
				deferred.resolve(result);
			});

			return deferred.promise;
		},
		assignLeadActionByRsm : function(leadManagePkId,action,comment){

			var deferred = $q.defer(); 
			$http.post('./assignLeadActionByRsm/'+leadManagePkId+'/'+action+'/'+comment).success(function(result){
				deferred.resolve(result);
			});

			return deferred.promise;
		},
		getRegion:function(){
			var deferred = $q.defer();
			$http.get('./getRegion').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		getRsmList:function(regionId){
			var deferred = $q.defer();
			$http.get('./getRsmList/'+regionId).success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},

		getSoList:function(regionId){
			var deferred = $q.defer();
			$http.get('./getSoList/'+regionId).success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},

		


	}
});