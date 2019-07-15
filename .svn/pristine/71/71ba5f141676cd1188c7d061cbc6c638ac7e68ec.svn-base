dmsApp.factory ('MaterialService', function($http, $q){
	
	return {
		getMaterialList: function(){
			var deferred = $q.defer();
			$http.get('./materialList').success(function(result){
				deferred.resolve(result);
			});
			return deferred.promise;
		},
		
	saveMaterial : function(material){
		var deferred = $q.defer();
		$http.post('./saveMaterial', material).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	deleteMaterial : function(materialId){
		var deferred = $q.defer(); 
		$http.get('./deleteMaterial/'+materialId).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	getSbuTypeList : function(){
		var deferred = $q.defer(); 
		$http.get('./sbuTypeList').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},

	
	
	
	
	}
	
});