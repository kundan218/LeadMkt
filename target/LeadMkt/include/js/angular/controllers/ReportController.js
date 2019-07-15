
var dmsApp = angular.module('dmsApp',['ui.bootstrap','datatables','datatables.bootstrap']);
dmsApp.controller ('ReportController', function($scope,$uibModal,$filter,$window,ReportService,DTOptionsBuilder, DTColumnBuilder,$compile){

	$scope.dealerList=[];
	$scope.distributorStockList=[];
	$scope.initReport=function(){
//		$scope.prepareDealerReportTable
		 $scope.prepareTable();
	}
	
	 toastr.options = {
	           extendedTimeOut: 1000,
	           timeOut: 5000,
	           positionClass: 'toast-top-center',
	   }
	 $scope.checkValidateDate=function() {
		  if ($scope.dtTo < $scope.dtFrom) {
			   	toastr["error"]("Please select correct Date. <br /><br />Thank You!")
			   	}
	    return rs;
	  }
	
	/* SalesInvoiceService.getUserDetail().then(function(result){
		 $scope.userLocationList= result.userDetail.locationList;
		 angular.forEach($scope.userLocationList,function(data, index){
			 $scope.locationObj=data;
		 });
		
	 });*/
	//$scope.prepareDealerReportTable=function (){
		$scope.dtColumnsDealerReport = [
		         	                      DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNo),
		         	            //          DTColumnBuilder.newColumn("userFkId", "Distributor Code").withOption('name','Distributor Code'),
		         	                     DTColumnBuilder.newColumn("dealerId", "Dealer Code").withOption('name','Dealer Code'),
		         	                     DTColumnBuilder.newColumn("dealerName", "Dealer Name").withOption('name', 'Dealer Name'),
		         	                    DTColumnBuilder.newColumn("mobileNo", "Mobile").withOption('name', 'Mobile'),
		         	                   DTColumnBuilder.newColumn("emailId", "Email ID").withOption('name', 'Email ID'),
		         	                  DTColumnBuilder.newColumn("address", "Address").withOption('name', 'Address'),
		         	                  DTColumnBuilder.newColumn("pinCode", "Postal Code").withOption('name', 'Postal Code'),
		         	                 DTColumnBuilder.newColumn("cstNo", "CST No.").withOption('name', 'CST No.'),
		         	                DTColumnBuilder.newColumn("gstNo", "GST No.").withOption('name', 'GST No.'),
		         	               DTColumnBuilder.newColumn("tinNo", "TIN No.").withOption('name', 'TIN No.'),
		         	              DTColumnBuilder.newColumn("taxNo", "Tax No.").withOption('name', 'Tax No.'),
		         	             DTColumnBuilder.newColumn("tinNo", "TIN No.").withOption('name', 'TIN No.'),
		         	           DTColumnBuilder.newColumn("city", "City").withOption('name', 'City'),
		         	          DTColumnBuilder.newColumn("district", "District").withOption('name', 'District'),
		         	         DTColumnBuilder.newColumn("stateFkId.stateName", "State").withOption('name', 'State'),
		         	      
		         	                  
		         	                      
		         	                  ]
		 function renderSrNo(data, type, full,meta) {
			  return meta.row+1; 
		  }
		/*	function renderAdminStatus(data, type, full){
 			var rs ="";
 			if(full.prehelathCheckUpStatus.constantCode == 'COMPLETED'){
 				rs += '<span class="status-label label label-success">'+full.prehelathCheckUpStatus.constantValue+'</span>';
 			}else {
 				rs += '<span class="status-label label label-waring">'+full.prehelathCheckUpStatus.constantValue+'</span>'
 			}
 			
 			return rs;
 		}
		function viewHistory(data, type, full,meta){
			 var rs="";
//			  rs+=full.preHelthCheckUpName+'<br/><a href="pdf/history.html" target="_blank" style="font-size:10px">(View History)</a>';
			 rs+=full.preHelthCheckUpName;
			  return rs;
		}
		function downloadReport(data, type, full,meta){
			 var rs="";
			 rs += '<a href="downloadReport/' + full.preHelthCheckUpPkId + '" target="_blank" class="btn btn-xs btn-warning"><i class="fa fa-download"></i></a>';
			 return rs;
		}
		function actionLink(data, type, full,meta){
			 var rs="";
			 rs += '<a href="preViewDetails/' + full.preHelthCheckUpPkId + '" target="_blank" class="btn btn-primary btn-xs" data-toggle="tooltip" title="" data-original-title="View Details"><i class="fa fa-file-text-o" aria-hidden="true"></i> </a>';
			 return rs;
		}
		function renderPurposedTimedate(data, type, full) {
			  var rs =  moment(full.purposedDate).format("DD-MM-YYYY h:mm:ss A"); //$filter('date')(full.purposedDate, 'dd/MM/yyyy hh:MM:ss a');
			 
		      return rs;
		    }*/
		$scope.dtOptionsReport = DTOptionsBuilder.newOptions()
		.withOption('fnServerParams', function ( aoData ) {
			var arr = $("#report").serializeArray();
	    	 $.each(arr, function(i, field){
	    		 if(field.value!=null && field.value!='')
	    			 {
	        		 aoData[field.name]= field.value;
	    			 }
	    	    });
		})
	
	    .withOption('ajax', {
	        contentType: 'application/json',
	        url: 'findAllDealer',
	        type: 'POST',
	        data: function(data, dtInstance) {
	            return JSON.stringify(data);
	        }
	    })
	    .withDataProp(function(json){
	        json.draw = json.draw;
	        json.recordsTotal = json.recordsTotal;
	        json.recordsFiltered = json.recordsFiltered;
	   /*    angular.forEach(json.preHelthCheckUps, function(obj , index){
		   angular.forEach(obj.preHealthCheckUpTestMaps, function(obj4 , index){
					alert(JSON.stringify(obj4));
				$scope.s=obj4
				alert('asds'+JSON.stringify($scope.s));
					});
			
			});*/
	        return json.dealers;
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
	.withOption('order', [0, 'asc']);
	//}
		
	   
	
		  
		  $scope.prepareTable=function (){	
			
			  /*==========================================	Distributor Stock Report=========================================================*/
				$scope.dtColumnsDistributorStockReport = [
				         	                      DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoDist),
						         	                   DTColumnBuilder.newColumn("distributorName","Distributor Name").withOption('distributorName','Distributor Name'),
				         	                      DTColumnBuilder.newColumn("materialDmsId", "Material Code").withOption('name','Material Code'),
				         	                     DTColumnBuilder.newColumn("materialDescription", "Material Desc.").withOption('name', 'Material Desc.'),
				         	                    DTColumnBuilder.newColumn("quantity", "Quantity").withOption('name', 'Quantity'),
				         	               
				         	      
				         	                  
				         	                      
				         	                  ]
				 function renderSrNoDist(data, type, full,meta) {
					  return meta.row+1; 
				  }
				
				$scope.dtOptionsReport1 = DTOptionsBuilder.newOptions()
				.withOption('fnServerParams', function ( aoData ) {
					var arr = $("#dt").serializeArray();
			    	 $.each(arr, function(i, field){
			    		 if(field.value!=null && field.value!='')
			    			 {
			        		 aoData[field.name]= field.value;
			    			 }
			    	    });
				})
			
			    .withOption('ajax', {
			        contentType: 'application/json',
			        url: 'findDistributorStock',
			        type: 'POST',
			        data: function(data, dtInstance) {
			            return JSON.stringify(data);
			        }
			    })
			    .withDataProp(function(json){
			        json.draw = json.draw;
			        json.recordsTotal = json.recordsTotal;
			        json.recordsFiltered = json.recordsFiltered;
			   /*    angular.forEach(json.preHelthCheckUps, function(obj , index){
				   angular.forEach(obj.preHealthCheckUpTestMaps, function(obj4 , index){
							alert(JSON.stringify(obj4));
						$scope.s=obj4
						alert('asds'+JSON.stringify($scope.s));
							});
					
					});*/
			        return json.distributorStocks;
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
			.withOption('order', [0, 'asc']);
				
				$scope.clear = function() {
				    $scope.dt = null;
				  };

				  
				  $scope.open1 = function() {
				    $scope.popup1.opened = true;
				  };

				  $scope.open2 = function() {
				    $scope.popup2.opened = true;
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
			  
/*==========================================	Purchase Order Report=========================================================*/
$scope.dtColumnsPOReport = [
		         	                      DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoPo),
		         	                      DTColumnBuilder.newColumn("customerPoNo", "Requisition No.").withOption('name','Requisition No.'),
		         	                     DTColumnBuilder.newColumn("createdDate", "Date").withOption('name', 'Date').renderWith(renderPOCreationdate),
		         	                    DTColumnBuilder.newColumn("distributorName", "Distributor Name").withOption('name', 'Distributor Name'),
		         	                   DTColumnBuilder.newColumn("poStatus", "Requisition Status").withOption('name', 'Requisition Status'),
		         	                    DTColumnBuilder.newColumn("materialDmsId", "Material").withOption('name', 'Material'),
		         	                    DTColumnBuilder.newColumn("poQuantity", "Quantity").withOption('name', 'Quantity'),
		         	               
		         	      
		         	                  
		         	                      
		         	                  ]
		 function renderSrNoPo(data, type, full,meta) {
			  return meta.row+1; 
		  }

		function renderPOCreationdate(data, type, full) {
			  var rs =  $filter('date')(full.createdDate, 'dd/MM/yyyy');
		    return rs;
		  }
		
		 function renderQuantity(data, type, full,meta) {
			 var rs="";
			 for(var i=0; i<full.poList.length; i++){
				rs+='<label class="label label-default">'+full.poList[i].quantity+'</label>';
			 }
			
	   		  return rs; 
	   	  }
		 
		 function renderMaterial(data, type, full,meta) {
			 var rs="";
			 for(var i=0; i<full.poList.length; i++){
				rs+='<label class="label label-default">'+full.poList[i].material.materialDmsId+'</label>';
			 }
			
	   		  return rs; 
	   	  }
		
		$scope.dtOptionsReportPO = DTOptionsBuilder.newOptions()
		.withOption('fnServerParams', function ( aoData ) {
			var arr = $("#report").serializeArray();
	    	 $.each(arr, function(i, field){
	    		 if(field.value!=null && field.value!='')
	    			 {
	        		 aoData[field.name]= field.value;
	    			 }
	    	    });
		})
	
	    .withOption('ajax', {
	        contentType: 'application/json',
	        url: 'findPOReport',
	        type: 'POST',
	        data: function(data, dtInstance) {
	            return JSON.stringify(data);
	        }
	    })
	    .withDataProp(function(json){
	        json.draw = json.draw;
	        json.recordsTotal = json.recordsTotal;
	        json.recordsFiltered = json.recordsFiltered;
	   /*    angular.forEach(json.preHelthCheckUps, function(obj , index){
		   angular.forEach(obj.preHealthCheckUpTestMaps, function(obj4 , index){
					alert(JSON.stringify(obj4));
				$scope.s=obj4
				alert('asds'+JSON.stringify($scope.s));
					});
			
			});*/
	        return json.customerPOs;
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
	.withOption('order', [0, 'asc']);
		//  }
		  
		  /**********************End Purchase Report************************/
		  
		  /*==========================================	Sales Invoice Report=========================================================*/
		  $scope.dtColumnsSalesInvoiceReport = [
		  		         	                      DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoPo),
	  				         	                   DTColumnBuilder.newColumn("distributorName","Distributor Name").withOption('distributorName','Distributor Name'),
		  		         	                      DTColumnBuilder.newColumn("salesInvoiceNo", "Invoice No").withOption('name','Invoice No'),
		  		         	                      DTColumnBuilder.newColumn("dealerCode", "Dealer Code").withOption('name','Dealer Code'),
		  		         	                      DTColumnBuilder.newColumn("dealerName", "Dealer Name").withOption('name','Dealer Name'),
		  		         	                      DTColumnBuilder.newColumn("dealerCity", "Dealer City").withOption('name','Dealer City'),
			  		         	                  DTColumnBuilder.newColumn("createdDate", "Created Date").withOption('name', 'Created Date').renderWith(renderCreationdate),
			  		         	               DTColumnBuilder.newColumn("invoiceDate", "Invoice Date").withOption('name', 'Invoice Date').renderWith(renderInvoiceCreationdate),
			  		         	                  DTColumnBuilder.newColumn("materialDmsId", "Material").withOption('name', 'Material'),
			  		         	                  DTColumnBuilder.newColumn("quantity", "Quantity").withOption('name', 'Quantity'),
		  		         	               
		  		         	      
		  		         	                  
		  		         	                      
		  		         	                  ]
		  		 function renderSrNoPo(data, type, full,meta) {
		  			  return meta.row+1; 
		  		  }

		  		function renderCreationdate(data, type, full) {
		  			  var rs =  $filter('date')(full.createdDate, 'dd/MM/yyyy');
		  		    return rs;
		  		  }
		  		
		  		function renderInvoiceInvoicedate(data, type, full) {
		  			  var rs =  $filter('date')(full.invoiceDate, 'dd/MM/yyyy');
		  		    return rs;
		  		  }
		  		
		  		 function renderQuantity(data, type, full,meta) {
		  			 var rs="";
		  			 for(var i=0; i<full.poList.length; i++){
		  				rs+='<label class="label label-default">'+full.poList[i].quantity+'</label>';
		  			 }
		  			
		  	   		  return rs; 
		  	   	  }
		  		 
		  		 function renderMaterial(data, type, full,meta) {
		  			 var rs="";
		  			 for(var i=0; i<full.poList.length; i++){
		  				rs+='<label class="label label-default">'+full.poList[i].material.materialDmsId+'</label>';
		  			 }
		  			
		  	   		  return rs; 
		  	   	  }
		  		
		  		$scope.dtOptionsReportSalesInvoice = DTOptionsBuilder.newOptions()
		  		.withOption('fnServerParams', function ( aoData ) {
		  			var arr = $("#report").serializeArray();
		  	    	 $.each(arr, function(i, field){
		  	    		 if(field.value!=null && field.value!='')
		  	    			 {
		  	        		 aoData[field.name]= field.value;
		  	    			 }
		  	    	    });
		  		})
		  	
		  	    .withOption('ajax', {
		  	        contentType: 'application/json',
		  	        url: 'findSalesInvoiceReport',
		  	        type: 'POST',
		  	        data: function(data, dtInstance) {
		  	            return JSON.stringify(data);
		  	        }
		  	    })
		  	    .withDataProp(function(json){
		  	        json.draw = json.draw;
		  	        json.recordsTotal = json.recordsTotal;
		  	        json.recordsFiltered = json.recordsFiltered;
		  	   /*    angular.forEach(json.preHelthCheckUps, function(obj , index){
		  		   angular.forEach(obj.preHealthCheckUpTestMaps, function(obj4 , index){
		  					alert(JSON.stringify(obj4));
		  				$scope.s=obj4
		  				alert('asds'+JSON.stringify($scope.s));
		  					});
		  			
		  			});*/
		  	        return json.salesInvoices;
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
		  	.withOption('order', [0, 'asc']);
		  		
		  	/************** GoodsReceipt Report **********************************/	
		  		
		  		$scope.dtColumnsGoodsReceiptReport = [
		  				         	                      DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoDist),
		  				         	                   DTColumnBuilder.newColumn("distributorName","Distributor Name").withOption('distributorName','Distributor Name'),
		  				         	                      DTColumnBuilder.newColumn("billDoc", "Bill Doc.").withOption('name','Bill Doc.'),
		  				         	                     DTColumnBuilder.newColumn("salesCode", "SO No.").withOption('name', 'SO No.'),
		  				         	                  DTColumnBuilder.newColumn("postingDate", "Posting Date").withOption('name', 'Posting Date').renderWith(renderPostingDate),
		  				         	               DTColumnBuilder.newColumn("customerPoNumber", "PO No.").withOption('name', 'PO No.'),
		  				         	            DTColumnBuilder.newColumn("deliveryNo", "Delv. No.").withOption('name', 'Delv. No.'),
		  				         	                     DTColumnBuilder.newColumn("materialDmsId", "Material Code").withOption('name', 'Material Code'),
		  				         	                  DTColumnBuilder.newColumn("materialDescription", "Material Description").withOption('name', 'Material Description'),
		  				         	                    DTColumnBuilder.newColumn("receiveQuantity", "Receive Qt.").withOption('name', 'Receive Qt.'),
		  				         	                 DTColumnBuilder.newColumn("quantity", "Actual Qt.").withOption('name', 'Actual Qt.'),
		  				         	              DTColumnBuilder.newColumn("vehicleNo", "Vehicle No.").withOption('name', 'Vehicle No.'),
		  				         	           DTColumnBuilder.newColumn("matYear", "Year").withOption('name', 'Year'),
		  				         	     DTColumnBuilder.newColumn("purchaseDoc", "Purch. Doc.").withOption('name', 'Purch. Doc.'),
		  				         	  DTColumnBuilder.newColumn("netValue", "Net. Value").withOption('name', 'Net Value'),
		  				         	DTColumnBuilder.newColumn("taxAmount", "Tax Amt.").withOption('name', 'Tax Amt.'),
		  				         	               
		  				         	      
		  				         	                  
		  				         	                      
		  				         	                  ]
		  				 function renderSrNoDist(data, type, full,meta) {
		  					  return meta.row+1; 
		  				  }
		  		
		  		function renderPostingDate(data, type, full) {
					  var rs =  $filter('date')(full.postingDate, 'dd/MM/yyyy');
				    return rs;
				  }
		  				
		  				$scope.dtOptionsReportGoodsReceipt = DTOptionsBuilder.newOptions()
		  				.withOption('fnServerParams', function ( aoData ) {
		  					var arr = $("#report").serializeArray();
		  			    	 $.each(arr, function(i, field){
		  			    		 if(field.value!=null && field.value!='')
		  			    			 {
		  			        		 aoData[field.name]= field.value;
		  			    			 }
		  			    	    });
		  				})
		  			
		  			    .withOption('ajax', {
		  			        contentType: 'application/json',
		  			        url: 'findGoodsReceiptReport',
		  			        type: 'POST',
		  			        data: function(data, dtInstance) {
		  			            return JSON.stringify(data);
		  			        }
		  			    })
		  			    .withDataProp(function(json){
		  			        json.draw = json.draw;
		  			        json.recordsTotal = json.recordsTotal;
		  			        json.recordsFiltered = json.recordsFiltered;
		  			   /*    angular.forEach(json.preHelthCheckUps, function(obj , index){
		  				   angular.forEach(obj.preHealthCheckUpTestMaps, function(obj4 , index){
		  							alert(JSON.stringify(obj4));
		  						$scope.s=obj4
		  						alert('asds'+JSON.stringify($scope.s));
		  							});
		  					
		  					});*/
		  			        return json.goodsReceipts;
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
		  			.withOption('order', [0, 'asc']);
		  				
		  				$scope.clear = function() {
		  				    $scope.dt = null;
		  				  };

		  				  
		  				  $scope.open10 = function() {
		  				    $scope.popup1.opened = true;
		  				  };

		  				  $scope.open11 = function() {
		  				    $scope.popup2.opened = true;
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
		  			  	/************** My Total GoodsReceipt Report **********************************/	
				  		
				  		$scope.dtColumnsMyTotalGoodsReceiptReport = [
				  				         	                      DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoDist),
				  				         	                   DTColumnBuilder.newColumn("distributorName","Distributor Name").withOption('distributorName','Distributor Name'),
				  				         	                      DTColumnBuilder.newColumn("billDoc", "Bill Doc.").withOption('name','Bill Doc.'),
				  				         	                     DTColumnBuilder.newColumn("salesCode", "SO No.").withOption('name', 'SO No.'),
				  				         	                  DTColumnBuilder.newColumn("postingDate", "Posting Date").withOption('name', 'Posting Date').renderWith(renderPostingDate),
				  				         	               DTColumnBuilder.newColumn("customerPoNumber", "PO No.").withOption('name', 'PO No.'),
				  				         	            DTColumnBuilder.newColumn("deliveryNo", "Delv. No.").withOption('name', 'Delv. No.'),
				  				         	                     DTColumnBuilder.newColumn("materialDmsId", "Material Code").withOption('name', 'Material Code'),
				  				         	                  DTColumnBuilder.newColumn("materialDescription", "Material Description").withOption('name', 'Material Description'),
				  				         	                 DTColumnBuilder.newColumn("quantity", "Actual Qt.").withOption('name', 'Actual Qt.'),
				  				         	              DTColumnBuilder.newColumn("vehicleNo", "Vehicle No.").withOption('name', 'Vehicle No.'),
				  				         	     DTColumnBuilder.newColumn("purchaseDoc", "Purch. Doc.").withOption('name', 'Purch. Doc.'),
				  				         	  DTColumnBuilder.newColumn("salesGroup", "Sales Type").renderWith(renderSalesGroupStatus),
				  				         	               
				  				        	                      
				  				         	                  ]
			     	      
     	                  
 				       	 function renderSalesGroupStatus(data, type, full) {
 								 var rs="";
 								 if(full.salesGroup =='907'){
 						   		   rs+='Retail';
 								 }else if(full.salesGroup =='908'){
 									 rs+='Project';
 								 }
 						   	      return rs;
 						   	    }  
				  				 function renderSrNoDist(data, type, full,meta) {
				  					  return meta.row+1; 
				  				  }
				  		
				  		function renderPostingDate(data, type, full) {
							  var rs =  $filter('date')(full.postingDate, 'dd/MM/yyyy');
						    return rs;
						  }
				  				
				  				$scope.dtOptionsReportMyTotalGoodsReceipt = DTOptionsBuilder.newOptions()
				  				.withOption('fnServerParams', function ( aoData ) {
				  					var arr = $("#report").serializeArray();
				  			    	 $.each(arr, function(i, field){
				  			    		 if(field.value!=null && field.value!='')
				  			    			 {
				  			        		 aoData[field.name]= field.value;
				  			    			 }
				  			    	    });
				  				})
				  			
				  			    .withOption('ajax', {
				  			        contentType: 'application/json',
				  			        url: 'findMyTotalGoodsReceiptReport',
				  			        type: 'POST',
				  			        data: function(data, dtInstance) {
				  			            return JSON.stringify(data);
				  			        }
				  			    })
				  			    .withDataProp(function(json){
				  			        json.draw = json.draw;
				  			        json.recordsTotal = json.recordsTotal;
				  			        json.recordsFiltered = json.recordsFiltered;
				  			  
				  			//        alert('h11'+json.myTotalGoodsReceipts);
				  			        return json.myTotalGoodsReceipts;
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
				  			.withOption('order', [0, 'asc']);
		  				
		  				
		  				$scope.clear = function() {
		  				    $scope.dt = null;
		  				  };

		  				  
		  				  $scope.open20 = function() {
		  				    $scope.popup1.opened = true;
		  				  };

		  				  $scope.open21 = function() {
		  				    $scope.popup2.opened = true;
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
		  				  
		  				  
		  			  	/************** MIS Report for SBU/ASM/Admin/RFM **********************************/	
					  		
					  		$scope.dtColumnsMisReport = [
					  		                           DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoPo),
					  		                       //    DTColumnBuilder.newColumn("distributorDmsId", "Distr.Code").withOption('name','Distr.Code'),
					  		                           DTColumnBuilder.newColumn("distributorName", "Distributor Name").withOption('name','Distributor Name'),
					  		                           DTColumnBuilder.newColumn("distributorCity", "Distributor City").withOption('name','Distributor City'),
					  		                           DTColumnBuilder.newColumn("sapId", "Distributor Code in SAP").withOption('name','Distributor Code in SAP'),
					  		                         DTColumnBuilder.newColumn("openingStock", "Opening Stock").withOption('name','Opening Stock'),
					  		         	                  DTColumnBuilder.newColumn("poQuantity", "Requisition Qty.").withOption('name', 'Requisition Qty.'),
					  		         	               DTColumnBuilder.newColumn("grnQuantity", "Receive Qty.").withOption('name','Receive Qty.'),
					  		         	            DTColumnBuilder.newColumn("grnNetValue", "Total Value of Received Qty.").withOption('name','Total Value of Received Qty.'),
					  		         	         DTColumnBuilder.newColumn("avgGrnPrice", "Avg. Price of Receive Qty.").withOption('name','Avg. Price of Receive Qty.'),
					  		         	            DTColumnBuilder.newColumn("quantity", "Total Sales Qty.").withOption('name','Total Sales Qty.'),
					  		         	         DTColumnBuilder.newColumn("salesGrossValue", "Gross Value of Sales").withOption('name','Gross Value of Sales'),
					  		         	      DTColumnBuilder.newColumn("salesTotalTaxAmount", "Gross Value of Sales Tax Amt.").withOption('name', 'Gross Value of Sales Tax Amt.'),
					  		         	   DTColumnBuilder.newColumn("freightAmt", "Gross Value of Sales Freight Amt.").withOption('name','Gross Value of Sales Freight Amt.'),
		  		         	                      DTColumnBuilder.newColumn("salesPrice", "Total Sales Value").withOption('name','Total Sales Value'),
		  		         	                   DTColumnBuilder.newColumn("avgSales", "Avg. Price of Sales Qty.").withOption('name','Avg. Price of Sales Qty.'),
		  		         	                DTColumnBuilder.newColumn("closingStock", "Closing Stock").withOption('name','Closing Stock'),
		  		         	               
		  		         	           /*  DTColumnBuilder.newColumn("stockQty", "Closing Stock").withOption('name','Closing Stock'),*/
				  		         	                  ]
				  		 function renderSrNoPo(data, type, full,meta) {
				  			  return meta.row+1; 
				  		  }

				  		function renderInvoiceCreationdate(data, type, full) {
				  			  var rs =  $filter('date')(full.invoiceDate, 'dd/MM/yyyy');
				  		    return rs;
				  		  }
				  		
				  		 function renderQuantity(data, type, full,meta) {
				  			 var rs="";
				  			 for(var i=0; i<full.poList.length; i++){
				  				rs+='<label class="label label-default">'+full.poList[i].quantity+'</label>';
				  			 }
				  			
				  	   		  return rs; 
				  	   	  }
				  		 
				  		 function renderMaterial(data, type, full,meta) {
				  			 var rs="";
				  			 for(var i=0; i<full.poList.length; i++){
				  				rs+='<label class="label label-default">'+full.poList[i].material.materialDmsId+'</label>';
				  			 }
				  			
				  	   		  return rs; 
				  	   	  }
					  				
					  				$scope.dtOptionsMisReport = DTOptionsBuilder.newOptions()
					  				.withOption('fnServerParams', function ( aoData ) {
					  					var arr = $("#report").serializeArray();
					  			    	 $.each(arr, function(i, field){
					  			    		 if(field.value!=null && field.value!='')
					  			    			 {
					  			        		 aoData[field.name]= field.value;
					  			    			 }
					  			    	    });
					  				})
					  			
					  			    .withOption('ajax', {
					  			        contentType: 'application/json',
					  			        url: 'findMisReport',
					  			        type: 'POST',
					  			        data: function(data, dtInstance) {
					  			            return JSON.stringify(data);
					  			        }
					  			    })
					  			    .withDataProp(function(json){
					  			        json.draw = json.draw;
					  			        json.recordsTotal = json.recordsTotal;
					  			        json.recordsFiltered = json.recordsFiltered;
					  		
					  			//        alert('h11'+json.myTotalGoodsReceipts);
					  			        //alert(json.misReports);
					  			        return json.misReports;
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
					  			.withOption('order', [0, 'asc']);
			  				
			  				
			  				$scope.clear = function() {
			  				    $scope.dt = null;
			  				  };

			  				  
			  				  $scope.open30 = function() {
			  				    $scope.popup1.opened = true;
			  				  };

			  				  $scope.open31 = function() {
			  				    $scope.popup2.opened = true;
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
		  				  
		  	/************** MIS Opening Closing Report for SBU/ASM/Addmin/RFM **********************************/
		  $scope.dtColumnsMisDetailReport = [
			  		                           DTColumnBuilder.newColumn("Sr No", "Sr No").renderWith(renderSrNoPo),
			  		                       //    DTColumnBuilder.newColumn("distributorDmsId", "Distr.Code").withOption('name','Distr.Code'),
			  		                           DTColumnBuilder.newColumn("distributorName", "Distributor Name").withOption('name','Distributor Name'),
			  		                     //      DTColumnBuilder.newColumn("distributorCity", "Distributor City").withOption('name','Distributor City'),
			  		                           DTColumnBuilder.newColumn("sapId", "Distributor Code in SAP").withOption('name','Distributor Code in SAP'),
			  		                         DTColumnBuilder.newColumn("materialDmsId", "Material Code").withOption('name','Material Code'),
			  		                         DTColumnBuilder.newColumn("openingStock", "Opening Stock").withOption('name','Opening Stock'),
			  		                       DTColumnBuilder.newColumn("closingStock", "Closing Stock").withOption('name','Closing Stock'),
			         	               
			         	           /*  DTColumnBuilder.newColumn("stockQty", "Closing Stock").withOption('name','Closing Stock'),*/
		  		         	                  ]
		  		 function renderSrNoPo(data, type, full,meta) {
		  			  return meta.row+1; 
		  		  }

			  				$scope.dtOptionsMisDetailReport = DTOptionsBuilder.newOptions()
			  				.withOption('fnServerParams', function ( aoData ) {
			  					var arr = $("#report").serializeArray();
			  			    	 $.each(arr, function(i, field){
			  			    		 if(field.value!=null && field.value!='')
			  			    			 {
			  			        		 aoData[field.name]= field.value;
			  			    			 }
			  			    	    });
			  				})
			  			
			  			    .withOption('ajax', {
			  			        contentType: 'application/json',
			  			        url: 'findMisDetailReport',
			  			        type: 'POST',
			  			        data: function(data, dtInstance) {
			  			            return JSON.stringify(data);
			  			        }
			  			    })
			  			    .withDataProp(function(json){
			  			        json.draw = json.draw;
			  			        json.recordsTotal = json.recordsTotal;
			  			        json.recordsFiltered = json.recordsFiltered;
			  	
			  			    //    alert('h11'+json.misDetailReports);
			  			        return json.misDetailReports;
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
			  			.withOption('order', [0, 'asc']);
						
						
						$scope.clear = function() {
						    $scope.dt = null;
						  };

						  
						  $scope.openMisDetail1 = function() {
						    $scope.popupMis1.opened = true;
						  };

						  $scope.openMisDetail2 = function() {
						    $scope.popupMis2.opened = true;
						  };

						  $scope.setDate = function(month,day,year) {
						    $scope.dt = new Date(month,day,year);
						  };

						  $scope.format = 'dd/MM/yyyy';
						  $scope.popupMis1 = {
						    opened: false
						  };

						  $scope.popupMis2 = {
						    opened: false
						  };
					  
		}
		 
		  		
});