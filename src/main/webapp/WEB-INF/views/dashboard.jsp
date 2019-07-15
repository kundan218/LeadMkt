<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
	 <link rel="shortcut icon" href="${pageContext.request.contextPath}/include/img/favicon.ico">
<%@include file="./common/cssInclude.jsp"%>
<%@include file="./common/taglib.jsp"%>
<%@include file="./common/jsInclude.jsp"%>


<style>
.main-header {
	display: block;
}
</style>
<script
	src="<%=request.getContextPath()%>/include/js/angular/controllers/DashBoardController.js"></script>
<script
	src="<%=request.getContextPath()%>/include/js/angular/services/DashBoardService.js"></script>

<script
	src="<%=request.getContextPath()%>/include/plugins/Chart/heatmap.js"></script>
</head>
<sec:authorize access="hasAnyRole('ADMIN')">
	<body
		class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse"
		ng-init="init('ADMIN')" ng-app="leadApp"
		ng-controller="DashBoardController">
		
		<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
</sec:authorize>
<sec:authorize access="hasAnyRole('REGIONAL_MANAGER')">
	<body
		class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse"
		ng-init="init('REGIONAL_MANAGER')" ng-app="leadApp"
		ng-controller="DashBoardController">
		
		<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
</sec:authorize>
<sec:authorize access="hasAnyRole('SALES_MARKETING')">
	<body
		class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse"
		ng-init="init('SALES_MARKETING')" ng-app="leadApp"
		ng-controller="DashBoardController">
		
		<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
</sec:authorize>
<sec:authorize access="hasAnyRole('STOCKYARD_MANAGER')">
	<body
		class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse"
		ng-init="init('STOCKYARD_MANAGER')" ng-app="leadApp"
		ng-controller="DashBoardController">
		
		<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
</sec:authorize>


<div class="wrapper">
	<%@include file="./common/header.jsp"%>

	<div class="content-wrapper" style="margin-left: 0px !important;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-10 no-padding">
					<div class="container-fluid">
						<h4>
							Lead Status of <strong>Current Month</strong>
							<!-- <div class="pull-right">
								<div class='input-group date pull-left' id='datetimepicker10'
									style="width: 200px; margin-right: 10px;">
									<input type='text' class="form-control" placeholder="mm/yyyy" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"> </span>
									</span>
								</div>

								<button class="btn btn-sm btn-info pull-right"
									style="height: 34px;">Print</button> 
							</div> -->
						</h4>
					</div>
					<div class="container-fluid mt-8">
						<div class="row d-flex">
							<div class="col-md-3 col-xs-12 d-flex">
								<div class="box no-border">
									<div class="box-header bg-aqua no-margin-bottom">
										<h3 class="box-title">Total Lead</h3>
										<span class="pull-right">{{leadCount[3].totalLead+leadCount[4].totalLead}}</span>
									</div>

									<div class="box-body no-padding">
										<table class="table">
											<tr>
												<td><strong>Lead Retails</strong></td>
												<td><span class="pull-right">{{leadCount[3].totalLead}}</span></td>
											</tr>
											<tr>
												<td><strong>Lead Projects</strong></td>
												<td><span class="pull-right">{{leadCount[4].totalLead}}</span></td>
											</tr>
										</table>
									</div>
								</div>
							</div>

							<div class="col-md-3 col-xs-12 d-flex">
								<div class="box no-border">
									<div class="box-header bg-aqua-active no-margin-bottom">
										<h3 class="box-title">Lead Assigned</h3>
										<span class="pull-right">{{leadCount[1].totalLead+leadCount[2].totalLead+leadCount[7].totalLead}}</span>
									</div>

									<div class="box-body no-padding">
										<table class="table">
											<tr>
												<td><strong>Lead Assigned to RSM</strong></td>
												<td><span class="pull-right">{{leadCount[1].totalLead}}</span></td>
											</tr>
											<tr>
												<td><strong>Lead Assigned to SM</strong></td>
												<td><span class="pull-right">{{leadCount[2].totalLead}}</span></td>
											</tr>
											<tr>
												<td><strong>Lead Assigned to Stock Yard</strong></td>
												<td><span class="pull-right">{{leadCount[7].totalLead}}</span></td>
											</tr>

										</table>
									</div>
								</div>
							</div>

							<div class="col-md-3 col-xs-12 d-flex">
								<div class="box no-border">
									<div class="box-header bg-warning no-margin-bottom">
										<h3 class="box-title">Lead Pending</h3>
										<span class="pull-right">{{leadCount[1].totalLead+leadCount[2].totalLead+leadCount[7].totalLead}}</span>
									</div>

									<div class="box-body no-padding">
										<table class="table">
											<tr>
												<td><strong>Lead Pending at RSM</strong></td>
												<td><span class="pull-right">{{leadCount[1].totalLead}}</span></td>
											</tr>
											<tr>
												<td><strong>Lead Pending at SM</strong></td>
												<td><span class="pull-right">{{leadCount[2].totalLead}}</span></td>
											</tr>
											<tr>
												<td><strong>Lead Pending at Stock Yard</strong></td>
												<td><span class="pull-right">{{leadCount[7].totalLead}}</span></td>
											</tr>

										</table>
									</div>
								</div>
							</div>


							<div class="col-md-3 col-xs-12 d-flex">
								<div class="box no-border">
									<div class="box-header bg-danger no-margin-bottom">
										<h3 class="box-title">Lead Closed</h3>
										<span class="pull-right">{{leadCount[6].totalLead+leadCount[5].totalLead}}</span>
									</div>

									<div class="box-body no-padding">
										<table class="table">
											<tr>
												<td><strong>Lead Convert to Sales</strong></td>
												<td><span class="pull-right">{{leadCount[6].totalLead}}</span></td>
											</tr>
											<tr>
												<td><strong>Lead Cancelled</strong></td>
												<td><span class="pull-right">{{leadCount[5].totalLead}}</span></td>
											</tr>

										</table>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="box no-border no-shadow no-margin">
									<div class="box no-border">
										<div class="box-header bg-gray-dark no-margin-bottom">
											<h3 class="box-title">Lead Summary</h3>
											<!-- <a href="history.html" class="pull-right btn-info btn-sm">All Lead Summary <span class="label label-danger">1 New</span></a> -->
										</div>
										<sec:authorize access="hasAnyRole('ADMIN')">
											<div role="tabpanel" class="box-body no-padding">
												<div class="table-responsive">
													<table datatable="" dt-options="dtOptionsLeadManage"
														dt-columns="dtColumnsLeadManage"
														class="table table-bordered table-condensed"></table>
												</div>
											</div>
										</sec:authorize>
										<sec:authorize access="hasAnyRole('REGIONAL_MANAGER')">
											<div role="tabpanel" class="box-body no-padding">
												<div class="table-responsive">
													<table datatable="" dt-options="dtOptionsLeadManage"
														dt-columns="dtColumnsLeadManage"
														class="table table-bordered table-condensed"></table>
												</div>
											</div>
										</sec:authorize>
										<sec:authorize access="hasAnyRole('SALES_MARKETING')">
											<div role="tabpanel" class="box-body no-padding">
												<div class="table-responsive">
													<table datatable="" dt-options="dtOptionsLeadManage"
														dt-columns="dtColumnsLeadManage"
														class="table table-bordered table-condensed"></table>
												</div>
											</div>
										</sec:authorize>
										<sec:authorize access="hasAnyRole('STOCKYARD_MANAGER')">
											<div role="tabpanel" class="box-body no-padding">
												<div class="table-responsive">
													<table datatable="" dt-options="dtOptionsLeadManage"
														dt-columns="dtColumnsLeadManage"
														class="table table-bordered table-condensed"></table>
												</div>
											</div>
										</sec:authorize>

										<!--         <div class="box-body no-padding">
        <div class="table-responsive">
        <table class="table table-bordered table-condensed">
        <tr>
        <th>Lead No.</th>
        <th>Location</th>
        <th>Source</th>
        <th>Created On</th>
        <th>Created By</th>
        <th>Lead Assigned To</th>
        <th>Approx Amt. <i class="fa fa-inr"></i></th>
        <th>Lead Status</th>
        <th>Aging</th>
        <th>administration Action</th>
        </tr>
        
        <tr>
        <td><a href="#"><strong>LID001</strong></a></td>
        <td><strong>Delhi</strong></td>
        <td>Indiamart</td>
        <td>09-01-2019</td>
        <td>Mr. Ramchand G <strong>(SM)</strong></td>
        <td>RM (Self Assigned)</td>
        <td>10 lac</td>
        <td><label class="label label-pill label-warning">Pending</label></td>
        <td>5 days</td>
        <td>
          <div class="btn-cancelAssign"><a href="#cancelPopup" data-toggle="modal" class="btn btn-danger btn-xs btn-pill"><i class="fa fa-close" data-toggle="tooltip" title="Cancel Lead"></i></a>
            <a href="#assign-sales" data-toggle="modal" class="btn btn-success btn-xs btn-pill"><i class="fa fa-check" data-toggle="tooltip" title="Assign Lead"></i></a>
            </div>
          <div class="btn-reminder" style="display:none;"><a href="#reminder" data-toggle="modal" class="btn btn-primary btn-xs btn-pill"><i class="fa fa-bell-o" data-toggle="tooltip" title="" data-original-title="Reminder"></i></a>
            <a href="#history" data-toggle="modal" class="btn btn-info btn-xs btn-pill"><i class="fa fa-history" data-toggle="tooltip" title="History"></i></a>
            
            </div>
        </td>
        </tr>
        
        <tr>
        <td><a href="#"><strong>LID002</strong></a></td>
        <td><strong>AMBALA</strong></td>
        <td>Indiamart</td>
        <td>09-01-2019</td>
        <td>Mr. MANISH SHARMA <strong>(SM)</strong></td>
        <td>SM</td>
        <td>20 lac</td>
        <td><label class="label label-pill label-danger">Assigned to Sales</label></td>
        <td>10 Days</td>
        <td>
        <a href="#" class="btn btn-primary btn-xs btn-pill"><i class="fa fa-bell-o" data-toggle="tooltip" title="Reminder"></i></a>
        <a href="history.html" class="btn btn-info btn-xs btn-pill"><i class="fa fa-history" data-toggle="tooltip" title="History"></i></a>
        </td>
        </tr>
        </table>
        </div>
        </div> -->
									</div>

								</div>

							</div>

							<div class="col-sm-12">

								<div id="areaChart"
									style="min-width: 310px; height: 300px; margin: 0 auto"></div>
							</div>


						</div>

						<h4 class="text-center sectionHeading">Top Source Performance</h4>
						<div class="container-fluid">
							<div class="row">

								<div class="col-md-4 text-center"
									ng-repeat="comData in leadResourceCount">
									<div class="gradient-blue countstatus">
										<h5 class="f-normal margin-top-0">
											<strong>{{comData.companyName}}</strong>
										</h5>
										<h2 class="no-margin">{{comData.totalLead}}</h2>
									</div>
								</div>

							</div>
						</div>


					</div>

				</div>
				<div class="col-md-2 no-padding h-95 h-dash"
					style="background-color: #e3e8e9;">
					<div class="form-group no-margin-bottom"
						style="background-color: #d9dfe1;">
						<select class="form-control" ng-model="regionList"
							ng-change="assigned(regionList)"
							ng-options="x as x.regionName for x in region track by x.regionPkId">
							<option value="">Select Region</option>
						</select>
					</div>



					<ul class="userList no-padding">
						<li><label class="no-margin">RSM Details</lable></li>
						<li ng-repeat="rm in regionRsm track by $index"><a href="#"
							class="clearfix d-flex"> <span class="pull-left userInfo">
									<small class="text-black text-nowrap">{{rm.name}}</small> <small
									class="text-muted text-nowrap">{{rm.email}}</small> <small
									class="text-muted text-nowrap">{{rm.contactNumber}}</small> <br>
									<small class="text-muted text-nowrap">{{rm.region}}</small> </br>
							</span>
						</a></li>


					</ul>

					<ul class="userList no-padding">
						<li><label class="no-margin">SO Details</lable></li>
						<li ng-repeat="rm in regionSo track by $index"><a href="#"
							class="clearfix d-flex"> <span class="pull-left userInfo">
									<small class="text-black text-nowrap">{{rm.name}}</small> <small
									class="text-muted text-nowrap">{{rm.email}}</small> <small
									class="text-muted text-nowrap">{{rm.contactNumber}}</small> <br>
									<small class="text-muted text-nowrap">{{rm.region}}</small> </br>
							</span>
						</a></li>


					</ul>

					<ul class="userList no-padding">
						<li><label class="no-margin">Stockyard Details</lable></li>
						<li ng-repeat="rm in regionStockyard track by $index"><a
							href="#" class="clearfix d-flex"> <span
								class="pull-left userInfo"> <small
									class="text-black text-nowrap">{{rm.name}}</small> <small
									class="text-muted text-nowrap">{{rm.email}}</small> <small
									class="text-muted text-nowrap">{{rm.contactNumber}}</small> <br>
									<small class="text-muted text-nowrap">{{rm.region}}</small> </br>
							</span>
						</a></li>


					</ul>


				</div>
			</div>
		</div>
	</div>

</div>


<%@include file="./common/footer.jsp"%>

<script>
$('#preloader').delay(350).fadeOut('slow'); 
<%@ include file="/include/custom/salesReport.js" %>
	$(function() {
		$('#datetimepicker10').datetimepicker({
			viewMode : 'month',
			format : 'MM/YYYY'
		});
	});

	function cancelToggle() {
		$("#cancelBox").toggle();
	}

	function assignPopupHide() {
		$("#assign-sales").modal('hide');
		$("#thanks-message").modal('show');
	}

	function showmanager(obj) {
		var getVal = $(obj).val();
		$("#manager").show();

	}

	function assignPopupHide() {
		$("#assign-sales").modal('hide');
		$("#thanks-message").modal('show');

		$(".btn-cancelAssign").hide();
		$(".btn-reminder").show();
		$(".status-pending").hide();
		$(".status-process").show();
		$(".status-canceled").hide();
	}

	function cancelPopupHide() {
		$("#assign-sales").modal('hide');
		$("#cancel-message").modal('show');
		$(".status-pending").hide();
		$(".status-process").hide();
		$(".status-canceled").show();
		$(".btn-cancelAssign").hide();
		$(".btn-reminder").show();
	}

	function dropDownList(obj) {
		$(obj).children().find("i.collapseicon").toggleClass("fa-minus");
		$(obj).next(".childrenList").toggle();
	}

	Highcharts.chart('areaChart1', {
		chart : {
			type : 'line'
		},
		title : {
			text : ''
		},
		legend : {
			layout : 'vertical',
			align : 'right',
			verticalAlign : 'top',
			x : 0,
			y : 0,
			floating : true,
			borderWidth : 0,
			backgroundColor : '#FFFFFF'
		},
		exporting : {
			buttons : {
				contextButton : {
					enabled : false
				},
				printButton : {
					text : 'Print',
					onclick : function() {
						this.print();
					}
				}
			}
		},
		xAxis : {
			categories : [ '01', '02', '03', '04', '05', '06', '07' ],
			plotBands : [ { // visualize the weekend
				from : 4.5,
				to : 6.5,
				color : 'rgba(68, 170, 213, 0.0)',

			} ]
		},
		yAxis : {
			title : {
				text : 'Orders in Tonage'
			}
		},
		tooltip : {
			shared : true,
			valueSuffix : ' units'
		},
		credits : {
			enabled : false
		},
		plotOptions : {
			areaspline : {
				fillOpacity : 1,
				//color: "#3ab6dc",
				borderWidth : '0'

			}
		},
		series : [ {
			name : 'Delhi',
			data : [ 0, 3, 1, 5, 1, 5, 0 ],
			borderColor : '#ffffff',
			color : "#3ab6dc",
			borderWidth : '0'
		}, {
			name : 'Angul',
			data : [ 0, 10, 20, 30, 40, 20, 10 ],
			borderColor : '#ffffff',
			color : "#000000",
			borderWidth : '0'
		},

		{
			name : 'Haryana',
			data : [ 0, 5, 10, 15, 20, 12, 8 ],
			borderColor : '#ffffff',
			color : "#ffc107",
			borderWidth : '0'
		},

		]
	});
</script>
<script type="text/ng-template" id="assignLead.html">
<div class="modal-dialog"> 
<div class="modal-content h-100">
  <div class="modal-header">
    <button type="button" class="close" ng-click="cancel()" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Leads Assign To</h4>
  </div>
  <div class="modal-body">
    <div class="row lead-popup-box">
<form name="leadForm">
      	<div class="col-md-12">
          <div class="box shadow">
          <div class="box-header bg-faded p-2">
          <h5><span></span>{{leadDetails.name}}<small>Inq. From: <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></small>
          <span class="pull-right text-orange"><small class="text-muted">Lead Type:</small>{{leadDetails.leadTypeFkId.commonConstantValue}}</span>
          </h5>
          </div>
          <div class="box-body p-2">
          <div class="row">
          <div class="col-md-12"><label class="text-info">Customer Detail</label></div>
          	<div class="col-md-4"><p><i class="fa fa-building-o"></i> <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></p></div>
          	<div class="col-md-4"><p><i class="fa fa-user"></i> <strong>{{leadDetails.name}}</strong></p></div>
            <div class="col-md-4"><p><i class="fa fa-phone"></i> <strong>{{leadDetails.mobile}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-envelope"></i> <strong>{{leadDetails.email}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-map-marker"></i> <strong>{{leadDetails.location}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-cubes"></i> <strong>{{leadDetails.totalQuantity}}</strong> </p></div>              	 
          </div>                 
          </div>         
          </div>
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
      
            	 <div class="row">
                 <div class="col-md-12"><h4 class="text-info">Select Location to Assign Lead</h4></div>
     	<div class="col-md-6 form-group pr-0">
        	<label>Select Location</label>
      <select class="form-control" ng-model="location" ng-change="showRole()"   ng-options="x as x.locationName for x in locationList track by x.locationPkId">
      <option>---Select---</option>
      </select>

        </div>
        </div>

        <div class="row" ng-show="myvalue">
     	<div class="col-md-3 pr-0">
        	<label>Send to SM</label>
          <select class="form-control" ng-change="selectRole(23,'SALES_MARKETING')" ng-model="sm" ng-disabled="stockDisable"=="false" ng-options="x as x.name for x in smList track by x.userPkId">
            <option>---Select---</option>
          </select>
        </div>   	
        <div class="col-md-3">
        	<label>Send to Stockyard</label>
            <select class="form-control" ng-change="selectRole(28,'STOCKYARD_MANAGER')" ng-disabled="smDisable"=="false" ng-model="sm" ng-options="x as x.name for x in stockyardList track by x.userPkId">
            	 <option>---Select---</option>               
            </select>
        </div>
        
        <div class="col-md-12 mt-8 "> 
 <button ng-click="reset(sm)" class="btn btn-lg btn-warning pull-left" style="font-size: 14px; padding: 7px 26px;"><i class="fa fa-arrow-right"></i>Reset</button>         
            <button ng-click="assignLead(status,sm,leadManagePkId)" class="btn btn-lg btn-success pull-right" style="font-size: 14px; padding: 7px 26px;"><i class="fa fa-arrow-right"></i> Assign</button>
        </div>
   	
     </div>
</form>  
  </div>  
</div>

</div>
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
<script type="text/ng-template" id="assignLeadBySales.html">
<div class="modal-dialog"> 
<div class="modal-content h-100">
  <div class="modal-header">
    <button type="button" class="close" ng-click="cancel()" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Leads Assign to</h4>
  </div>
  <div class="modal-body">
    <div class="row lead-popup-box">
<form name="leadForm">
      	<div class="col-md-12">
          <div class="box shadow">
          <div class="box-header bg-faded p-2">
          <h5><span></span>{{leadDetails.name}}<small>Inq. From: <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></small>
          <span class="pull-right text-orange"><small class="text-muted">Lead Type:</small>{{leadDetails.leadTypeFkId.commonConstantValue}}</span>
          </h5>
          </div>
          <div class="box-body p-2">
          <div class="row">
          <div class="col-md-12"><label class="text-info">Customer Detail</label></div>
          	<div class="col-md-4"><p><i class="fa fa-building-o"></i> <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></p></div>
          	<div class="col-md-4"><p><i class="fa fa-user"></i> <strong>{{leadDetails.name}}</strong></p></div>
            <div class="col-md-4"><p><i class="fa fa-phone"></i> <strong>{{leadDetails.mobile}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-envelope"></i> <strong>{{leadDetails.email}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-map-marker"></i> <strong>{{leadDetails.location}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-cubes"></i> <strong>{{leadDetails.totalQuantity}}</strong> </p></div>              	 
          </div>                 
          </div>         
          </div>
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
      
            	 <div class="row">
                 <div class="col-md-12"><h4 class="text-info">Select Location to Assign Lead</h4></div>
     	<div class="col-md-6 form-group pr-0">
        	<label>Select Location</label>
      <select class="form-control" ng-model="location" ng-change="showRole()"   ng-options="x as x.locationName for x in locationList track by x.locationPkId">
      <option>---Select---</option>
      </select>

        </div>
        </div>
        <div class="row" ng-show="myvalue"> 	
        <div class="col-md-3 pr-0">
        	<label>Send to Stockyard</label>
            <select class="form-control" ng-model="sm" ng-options="x as x.name for x in stockyardList track by x.userPkId">
            	 <option>---Select---</option>               
            </select>
        </div>
  
        <div class="col-md-12 mt-8 "> 
<button ng-click="reset(sm)" class="btn btn-lg btn-warning pull-left" style="font-size: 14px; padding: 7px 26px;"><i class="fa fa-arrow-right"></i>Reset</button>          
            <button ng-click="assignLeadBySales(28,sm,leadManagePkId)" class="btn btn-lg btn-success pull-right" style="font-size: 14px; padding: 7px 26px;"><i class="fa fa-arrow-right"></i> Assign</button>
        </div>   	
     </div>
</form>  
  </div>  
</div>

</div>
</script>
<script type="text/ng-template" id="cancelLead.html">
<div class="modal-dialog"> 
<!-- Modal content-->
<div class="modal-content h-100">
  <div class="modal-header">
    <button type="button" class="close" ng-click="cancel()" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Cancel Lead</h4>
  </div>
  
  
  
     <div class="row lead-popup-box">
<form name="leadForm">
      	<div class="col-md-12">
          <div class="box shadow">
          <div class="box-header bg-faded p-2">
          <h5><span></span>{{leadDetails.name}}<small>Inq. From: <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></small>
          <span class="pull-right text-orange"><small class="text-muted">Lead Type:</small>{{leadDetails.leadTypeFkId.commonConstantValue}}</span>
          </h5>
          </div>
          <div class="box-body p-2">
          <div class="row">
          <div class="col-md-12"><label class="text-info">Customer Detail</label></div>
          	<div class="col-md-4"><p><i class="fa fa-building-o"></i> <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></p></div>
          	<div class="col-md-4"><p><i class="fa fa-user"></i> <strong>{{leadDetails.name}}</strong></p></div>
            <div class="col-md-4"><p><i class="fa fa-phone"></i> <strong>{{leadDetails.mobile}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-envelope"></i> <strong>{{leadDetails.email}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-map-marker"></i> <strong>{{leadDetails.location}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-cubes"></i> <strong>{{leadDetails.totalQuantity}}</strong> </p></div>              	 
          </div>                 
          </div>         
          </div>
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
<div class="modal-body">
			<div class="row">
       		 <div class="col-md-12 col-sm-4">
                
        <div class="col-md-12">
        <div class="form-group">
        <label>Comments</label>
        <textarea class="form-control" style="height:100px;" ng-model="comment"></textarea>
        </div>
        </div>        
  <div class="modal-footer">
    <button type="button" class="btn btn-danger" data-dismiss="modal" ng-click="cancelLead(leadManagePkId,24,comment)">Cancel Lead</button>
    <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">Close</button>
  </div>
</div>
</div>
</div>
</div>

</div>
</script>
<script type="text/ng-template" id="closeLead.html">
<div class="modal-dialog"> 
<!-- Modal content-->
<div class="modal-content h-100">
  <div class="modal-header">
    <button type="button" class="close" ng-click="cancel()" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Convert Lead into Sale</h4>
  </div>
  
  
  
     <div class="row lead-popup-box">
<form name="leadForm">
      	<div class="col-md-12">
          <div class="box shadow">
          <div class="box-header bg-faded p-2">
          <h5><span></span>{{leadDetails.name}}<small>Inq. From: <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></small>
          <span class="pull-right text-orange"><small class="text-muted">Lead Type:</small>{{leadDetails.leadTypeFkId.commonConstantValue}}</span>
          </h5>
          </div>
          <div class="box-body p-2">
          <div class="row">
          <div class="col-md-12"><label class="text-info">Customer Detail</label></div>
          	<div class="col-md-4"><p><i class="fa fa-building-o"></i> <strong>{{leadDetails.leadSourceFkId.companyName}}</strong></p></div>
          	<div class="col-md-4"><p><i class="fa fa-user"></i> <strong>{{leadDetails.name}}</strong></p></div>
            <div class="col-md-4"><p><i class="fa fa-phone"></i> <strong>{{leadDetails.mobile}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-envelope"></i> <strong>{{leadDetails.email}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-map-marker"></i> <strong>{{leadDetails.location}}</strong> </p></div>
            <div class="col-md-4"><p><i class="fa fa-cubes"></i> <strong>{{leadDetails.totalQuantity}}</strong> </p></div>              	 
          </div>                 
          </div>         
          </div>
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
<div class="modal-body">
			<div class="row">
       		 <div class="col-md-12 col-sm-4">
                <div class="form-group">
                	<label>Action</label>
                   <select class="form-control" ng-model="action" ng-options="x as x.commonConstantValue for x in leadAction track by x.commonConstantPkId">
                   </select>
                </div>

     	
        <div class="col-md-12">
        <div class="form-group">
        <label>Comments</label>
        <textarea class="form-control" style="height:100px;" ng-model="comment"></textarea>
        </div>
        </div>        
  <div class="modal-footer">
    <button type="button" class="btn btn-success" data-dismiss="modal" ng-click="closeLead(leadManagePkId,action,comment)">Convert To Sale</button>
    <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">Close</button>
  </div>
</div>
</div>
</div>
</div>

</div>
</script>
</body>
</html>
