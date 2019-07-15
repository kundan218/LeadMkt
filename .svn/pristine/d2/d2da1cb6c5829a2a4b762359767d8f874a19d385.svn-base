dmsApp.factory ('DistributorService', function($http, $q){
	
	return {
		getDistributorList: function(){
			var deferred = $q.defer();
			$http.get('./distributorList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
		getStateList: function(){
			var deferred = $q.defer();
			$http.get('./stateList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
		getLocationList: function(){
			var deferred = $q.defer();
			$http.get('./locationList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
		getCountryList: function(){
			var deferred = $q.defer();
			$http.get('./countryList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
		getSOList: function(){
			var deferred = $q.defer();
			$http.get('./soList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
		getRMList: function(){
			var deferred = $q.defer();
			$http.get('./rmList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
	saveDistributor : function(distributor){
		var deferred = $q.defer();
		$http.post('./saveDistributor', distributor).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	deleteDistributor : function(distributorId){
		var deferred = $q.defer(); 
		$http.get('./deleteDistributor/'+distributorId).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},	
	getDistributorById : function(){
		var deferred = $q.defer();
		$http.get('./getDistributorById').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	
	saveNormsstock : function(normsStocks){
		var deferred = $q.defer();
		$http.post('../saveStockNorms', normsStocks).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	getDistributorByUserId : function(){
		var deferred = $q.defer();
		$http.get('../getDistributorByUserId').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	
	getStockNormsByDistributorId : function(distributorId){
		var deferred = $q.defer();
		$http.get('../getStockNormsByDistributorId/'+distributorId).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	searchStockNormsHistory : function(stockNormsHistory){
		var deferred = $q.defer();
		$http.get('../searchStockNormsHistory', stockNormsHistory).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	findAllDistributorStockByDistributorCode : function(distributorCode){
		var deferred = $q.defer(); 
		$http.get('../findAllDistributorStockByDistributorCode/'+distributorCode).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	saveDistributorStock : function(distributorStocks){
		var deferred = $q.defer();
		$http.post('../saveDistributorStock', distributorStocks).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	
	findAllNormsStockList : function(){
		var deferred = $q.defer(); 
		$http.get('../findAllNormsStockList').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	
	findAllDistributorStockHistory : function(searchNorms){
		var deferred = $q.defer(); 
		$http.post('../findAllDistributorStockHistory',searchNorms).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	
	findAllDistributorStockHistoryByDistributorCode : function(distributorCode){
		var deferred = $q.defer(); 
		$http.get('../findAllDistributorStockHistoryByDistributorCode/'+distributorCode).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	findAllMaterialList : function(){
		var deferred = $q.defer();
		$http.get('../get-all-materialList').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	getAllDistributorStockByDistributorCode : function(distributorCode){
		var deferred = $q.defer(); 
		$http.get('../findAllDistributorstockByDisCode/'+distributorCode).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},	
	
	updateDistributorStock : function(distributorStocks){
		var deferred = $q.defer();
		$http.post('../updateDistributorStock', distributorStocks).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	deleteDistributorStock : function(distributorStockPkId){
		var deferred = $q.defer();
		$http.get('../deleteDistributorStock/'+distributorStockPkId).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	
	
	getDistributorStockbyDistributorCode : function(distributorCode){
		var deferred = $q.defer(); 
		$http.get('../getDistributorStockbyDistributorCode/'+distributorCode).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},	
	}
	
});