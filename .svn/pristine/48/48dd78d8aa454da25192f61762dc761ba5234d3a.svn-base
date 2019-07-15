var counter=0;
var statusDocUpload=function(basePath){
    $('#fileupload').fileupload({dataType: 'json',
        done: function (e, data) {
        	console.log(JSON.stringify(data));
//        	$("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
            	/*var fileGrid="<tr>";
            	fileGrid+='<td>'+file.fileName+'</td>';
            	fileGrid+='<td><a href="javascript:void()" ng-click="index.splice($index, 1)" class="btn btn-xs btn-danger"><i class="fa fa-trash" aria-hidden="true"></i></a></td>';
            	var fileGrid="</tr>";
            	$("#uploaded-files").append(fileGrid);*/
//            	$("#uploadedFile").val(index);
//            	$("#uploadedFile1").val(index+1);
//            	$("#uploadedFile").trigger('input');
//            	$("#uploadedFile1").trigger('input');
            	//alert(JSON.stringify(file));
            	var sel = 'body[ng-controller="DealerController"]';
            	var $scope= angular.element(sel).scope();
            	$scope.currentProfileImage=file.fileName;
            	$('#profileImage').attr('src', basePath+file.fileName);
//            	$scope.request.files=file.fileName;
//            	$("#files").val(file.fileName);
//            	$("#files").trigger('input');
            	
            	counter++;
            }); 
        },
        
        progressall: function (e, data) {
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        $('#progress .bar').css('width',progress + '%');
   		},
   		
		dropZone: $('#dropzone')
    });
};
var deleteFile=function(counter){
	var sel = 'div[ng-controller="requestController"]';
	var $scope= angular.element(sel).scope();
	/*alert($scope.request.files[counter].fileName);*/
	$.ajax({
		type:'POST',
		url:'../common/deleteFile',
		data:{
			fileName:$scope.request.files[counter].fileName
		},success:function(data, textStatus, jqXHR){
			$("#file"+counter).remove();
			$scope.request.files.splice(counter, 1);
		},error:function(jqXHR, textStatus, errorThrown){
			
		}
	});
}