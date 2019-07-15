<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<%@include file="./common/cssInclude.jsp"%>
 <%@include file="./common/taglib.jsp"%>
 <%@include file="./common/jsInclude.jsp"%>
 

<script src="<%=request.getContextPath()%>/include/js/angular/controllers/LeadController.js"></script>
<script src="<%=request.getContextPath()%>/include/js/angular/services/LeadService.js"></script>
<script src="<%=request.getContextPath()%>/include/js/angular/services/DashBoardService.js"></script>

<style>

.loading {
	margin-top: 10em;
	text-align: center;
	color: gray;
}

.main-header {
	display: block;
}
</style>

</head>
<body class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse" ng-init="init()" ng-app="leadApp" ng-controller="LeadController">
<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
<div class="wrapper">

<header class="main-header">
    <div class="container-fluid top-Bar">
      <div class="row">
        <div class="col-md-3 col-sm-3"><a href="home" class="logo"> <img src="${pageContext.request.contextPath}/include/img/jspl-w.png" height="35"/></a> </div>
        <div class="col-md-9 col-sm-9">
          <div class="navbar-custom-menu">
            <ul class="top-left clearfix">
                      <li><a href="javascript:void(0)"><i class="fa fa-user no-margin-right"></i> <span class="text-white">Welcome:&nbsp;<sec:authentication property="principal.name" /></span> &nbsp;&nbsp;</a></li>
          <li class="dropdown lang-dropDown"><a href="executiveHistory" class="link dropdown-toggle" aria-expanded="false"><i class="fa fa-history" title="History" data-toggle="tooltip" data-placement="bottom"></i></a>
          </li>
          <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out" title="Logout"></i> </a></li>
          
        </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid">
    <div class="row">
      <nav class="navbar no-margin" style="display:none !important;">
      	<div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
        </div>
    </nav>
    </div>
    </div>
  </header>
  
      
      <div class="content-wrapper" style="margin-left:0 !important;">
      <div class="container-fluid">
      <div class="row">
     <div class="col-md-10 no-padding">
      <div class="box no-border">
      <div class="box-header no-margin-bottom">
									<h3 class="box-title">
										<strong>Lead List</strong>
									
									</h3>
									<div class="pull-right">
      <a href="javascript:history.back(-1)" class="btn btn-default">Back</a>
    <!--   <button type="button" class="btn btn-warning" data-target="#bulkPopup" data-toggle="modal">Bulk Upload</button> -->
      </div>
								</div>
      
   <div class="box-body">
         
         <div role="tabpanel" class="box-body no-padding">
                <div class="table-responsive">                    
                    <table  datatable="" dt-options="dtOptionsLeadManage" dt-columns="dtColumnsLeadManage" class="table table-bordered table-condensed"></table>
                    </div>
               </div> 
               </div> 
              </div>   
        </div>
        <div class="col-md-2 no-padding h-95" style="background-color:#e3e8e9;">
        <div class="form-group no-margin-bottom" style="background-color:#d9dfe1;">
       <select class="form-control" ng-model="showRegionToExecutive" ng-change="rsmUnderExecutive(showRegionToExecutive)" ng-options="x as x.regionName for x in showRegion track by x.regionPkId">
       		<option value="">Select Region</option>
       		</select>
        </div>
        
        
        
        <ul class="userList no-padding" >
        <li><label class="no-margin">My Reporting RSM</lable></li>
        <li ng-repeat="rm in regionRmList track by $index" >
        <a href="#" class="clearfix d-flex">
        <span class="pull-left userInfo">
        <small class="text-black text-nowrap">{{rm.name}}</small>
        <small class="text-muted text-nowrap">{{rm.email}}</small>
        <small class="text-muted text-nowrap">{{rm.contactNumber}}</small>
        <br>
        <small class="text-muted text-nowrap">{{rm.region}}</small>
        </br>
        </span>
        </a>
        </li>
        
        
        </ul>
        </div> 
        </div>
        </div>
        </div>
        </div>
        
         
     

<footer class="dashboard-footer main-footer no-margin text-center">Copyright &copy; 2019-2020 Jindal Steel and Power. All rights reserved.</footer>



 
 




<script>
$('#preloader').delay(350).fadeOut('slow');
function adressFromShow (){

$("#addressForm").toggle();

}
function assignPopupHide() {
    $("#assign-sales").modal('hide');
	$("#thanks-message").modal('show');
}


Highcharts.chart('areaChart', {
    chart: {
        type: 'areaspline'
    },
    title: {
        text: ''
    },
    legend: {
        layout: 'vertical',
        align: 'center',
        verticalAlign: 'top',
        x: 0,
        y: 0,
        floating: true,
        borderWidth: 0,
        backgroundColor:'#FFFFFF'
    },
	exporting: {
            buttons: {
                contextButton: {
                    enabled: false
                },
                printButton: {
                    text: 'Print',
                    onclick: function () {
                        this.print();
                    }
                }
            }
        },
    xAxis: {
        categories: [
            'Monday',
            'Tuesday',
            'Wednesday',
            'Thursday',
            'Friday',
            'Saturday',
            'Sunday'
        ],
        plotBands: [{ // visualize the weekend
            from: 4.5,
            to: 6.5,
            color: 'rgba(68, 170, 213, 0.0)',
			
        }]
    },
    yAxis: {
        title: {
            text: 'Orders in Tonage'
        }
    },
    tooltip: {
        shared: true,
        valueSuffix: ' units'
    },
    credits: {
        enabled: false
    },
    plotOptions: {
        areaspline: {
            fillOpacity: 1,

			color: "#3ab6dc",
			borderWidth:'0'
            
        
        }
    },
    series: [{
        name: 'Delhi',
        data: [0, 3, 1, 5, 1, 5, 0],
		borderColor: '#ffffff',
		borderWidth:'0'
    }, ]
});

</script>
<script type="text/ng-template" id="openLeadDeatils.html">
<div class="modal-dialog"> 
<div class="modal-content h-100">
  <div class="modal-header">
    <button type="button" class="close" ng-click="cancel()" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Lead Details</h4>
  </div>
  <div class="modal-body">
    <div class="row lead-popup-box">
<form name="leadForm">
      	<div class="col-md-12">
          <div class="box shadow">
          
          <div class="box-body p-2">
          <div class="row">
          <div class="col-md-4">
            <label>Customer Name</label>
			<div class="form-group">
			<input type="text" class="form-control" name="customername" ng-model="leadDetails.name" ng-disabled="true" />
           </div>
          </div>
<div class="col-md-4">
            <label>Customer Mobile</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.mobile" disabled="disabled" />
           </div>	
           </div>
          <div class="col-md-4">
            <label>Lead Source</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Source" ng-model="leadDetails.leadSourceFkId.companyName" disabled="disabled" />
           </div>	
           </div>

          <div class="col-md-4">
            <label>Lead Type</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.leadTypeFkId.commonConstantValue" disabled="disabled" />
           </div>	
           </div>
          
            <div class="col-md-4">
            <label>Region</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.regionFkId.regionName" disabled="disabled" />
           </div>	
           </div>
           <div class="col-md-4">
            <label>SBU</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.sbuFkId.commonConstantValue" disabled="disabled" />
           </div>	
           </div>
           <div class="col-md-4">
            <label>Lead Staus</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.leadStatus.commonConstantValue" disabled="disabled" />
           </div>	
           </div>

           <div class="col-md-4" ng-if="leadDetails.leadStatus.commonConstantPkId==22">
            <label>Assigned To</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.rsmAssignFkId.name" disabled="disabled" />
           </div>	
           </div>
           <div class="col-md-4" ng-if="leadDetails.leadStatus.commonConstantPkId==25">
            <label>Assigned To</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.convertedToSaleBy.name" disabled="disabled" />
           </div>	
           </div>
           <div class="col-md-4" ng-if="leadDetails.leadStatus.commonConstantPkId==24">
            <label>Assigned To</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.cancelledBy.name" disabled="disabled" />
           </div>	
           </div>
           <div class="col-md-4" ng-if="leadDetails.leadStatus.commonConstantPkId==23">
            <label>Assigned To</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.soAssignFkId.name" disabled="disabled" />
           </div>	
           </div>
           <div class="col-md-4" ng-if="leadDetails.leadStatus.commonConstantPkId==28">
            <label>Assigned To</label>
			<div class="form-group">
			<input type="text" class="form-control" name="Lead Type" ng-model="leadDetails.stockyardAssignFkId.name" disabled="disabled" />
           </div>	
           </div>
        <div class="col-md-12" ng-if="leadDetails.leadStatus.commonConstantPkId==24">
        <div class="form-group">
        <label>Comments</label>
        <textarea class="form-control" style="height:100px;" ng-model="leadDetails.comment" disabled="disabled"></textarea>
        </div>
        </div>  
           <div class="col-md-12" ng-if="leadDetails.leadStatus.commonConstantPkId==25">
        <div class="form-group">
        <label>Comments</label>
        <textarea class="form-control" style="height:100px;" ng-model="leadDetails.actionCommnet" disabled="disabled"></textarea>
        </div>
        </div>  
           	<div class="col-xs-12 col-md-12" 
														>
														<div class="form-group">
															<table cellpadding="0" cellspacing="0"
																class="table-bordered table">
																<thead>
																	<th style="padding: 5px;">Material Name</th>
																	<th style="padding: 5px;">Qty in TN</th>
																	
																	</th>
																</thead>
																<tbody>
																	<tr ng-repeat="tr in leadDetails.leadMaterialMaps track by $index">
																		<td>{{tr.materialFkId.materialDmsId}}</td>
                                                                         <td>{{tr.quantity}}</td>														
																	</tr>

																</tbody>
															</table>
														</div>
													</div>

             	 
          </div>                 
          </div>         
          </div>
          </div>
      </div>
      
            	
       
</form>  
  </div>  
</div>

</div>
</script>

</body>
</html>