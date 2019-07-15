leadApp.factory ('SourceService', function($http, $q){
	
	return {		
	getLeadSourceStatusList : function(){
		var deferred = $q.defer(); 
		$http.get('./getLeadSourceStatusList').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	saveEditLeadSource : function(leadSource){
		var deferred = $q.defer(); 
		$http.post('./editSaveLeadSource',leadSource).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	getLeadSourceList : function(leadSource){
		var deferred = $q.defer(); 
		$http.get('./getLeadSourceList').success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	deleteLeadSource :function(leadSourcePkId){
		var deferred = $q.defer(); 
		$http.post('./deleteLeadSource/'+leadSourcePkId).success(function(result){
			deferred.resolve(result);
		});
		return deferred.promise;
	},
	}
	
});