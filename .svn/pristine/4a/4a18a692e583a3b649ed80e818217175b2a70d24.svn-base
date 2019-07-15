<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.2 -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/include/img/favicon.ico">
<%@include file="./common/cssInclude.jsp"%>
<%@include file="./common/taglib.jsp"%>
<%@include file="./common/jsInclude.jsp"%>


<link rel="stylesheet" href="style.css" />
<script src="script.js"></script>

<script
	src="<%=request.getContextPath()%>/include/js/angular/controllers/LeadController.js"></script>
<script
	src="<%=request.getContextPath()%>/include/js/angular/services/DashBoardService.js"></script>
<script
	src="<%=request.getContextPath()%>/include/js/angular/services/LeadService.js"></script>
	<script	src="<%=request.getContextPath()%>/include/js/angular/services/CommonDirective.js"></script>


<style>
#rsmmap {
	height: 611px;
	min-width: 310px;
	max-width: 1000px;
}

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
<body
	class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse"
	ng-app="leadApp" ng-controller="LeadController" ng-init="init()">
	<div class="wrapper" >
		<header class="main-header">
			<div class="container-fluid top-Bar">
				<div class="row">
					<div class="col-md-3 col-sm-3">
						<a href="#" class="logo"> <img
							src="${pageContext.request.contextPath}/include/img/jspl-w.png"
							height="35" /></a>
					</div>
					<div class="col-md-9 col-sm-9">
						<div class="navbar-custom-menu">
							<ul class="top-left clearfix">
								<li><a href="javascript:void(0)"><i
										class="fa fa-user no-margin-right"></i> <span
										class="text-white">Welcome:&nbsp;<sec:authentication
												property="principal.name" /></span> &nbsp;&nbsp;</a></li>
								<li class="dropdown lang-dropDown"><a
									href="executiveHistory" class="link dropdown-toggle"
									aria-expanded="false"><i class="fa fa-history" title="History"
										data-toggle="tooltip" data-placement="bottom"></i></a></li>
								<li><a href="${pageContext.request.contextPath}/logout"><i
										class="fa fa-sign-out" title="Logout"></i> </a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid">
				<div class="row">
					<nav class="navbar no-margin" style="display: none !important;">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
					</nav>
				</div>
			</div>
		</header>


		<div class="content-wrapper" style="margin-left: 0 !important;">
			<div class="container-fluid">
				<form name="leadForm">
					<div class="row">
						<div class="col-md-10 no-padding">
							<div class="box no-border">
								<div class="box-body">
									<div class="box-header no-margin-bottom">
										<h3 class="box-title">
											<strong>Create Lead</strong>
										</h3>										
										<button type="button" class="btn btn-warning pull-right" ng-click="bulkUpload()"  data-toggle="modal">Bulk Upload</button>
									</div>

									<div class="box-body">
										<div class="row">
											<div class="col-xs-12 col-md-6 border-right">
												<h4 class="no-margin-top section-heading text-blue">Customer
													Details</h4>
												<div class="row">
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Customer Name<span
																style="color: Red">*</span></label> <input type="text"
																ng-pattern="/^[a-z A-Z .]{3,25}$/" class="form-control"
																name="name" ng-model="leadManage.name" required /><span
																style="color: red"
																ng-show="leadForm.name.$error.pattern">min 3 &
																max 25 Characters and (a-z A-Z) characters only. </span>
														</div>
													</div>
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Email</label> <input type="text"
																class="form-control" ng-model="leadManage.email" />
														</div>
													</div>
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Office Telephone No.</label> <input type="text"
																class="form-control" ng-model="leadManage.phone"ng-pattern="/^[0-9]{6,15}$/" name="phn"
																  /><span
																style="color: Red" ng-show="leadForm.phn.$error.pattern"
																Required>Only Numbers Allowed</span>
														</div>
													</div>
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Customer Mobile No.<span
																style="color: Red">*</span></label> <input type="text"
																class="form-control" ng-model="leadManage.mobile"
																ng-pattern="/^[0-9]{10,10}$/" name="mob"
																placeholder="ex. 8521496578" required /><span
																style="color: Red" ng-show="leadForm.mob.$error.pattern"
																Required>Only 10 Digit Mob Numbers Allowed</span>
														</div>
													</div>
												</div>
											</div>
											<div class="col-xs-12 col-md-6 border-right">
												<h4 class="no-margin-top section-heading text-blue">Channel
													Detail</h4>
												<div class="row">
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Lead Source<span style="color: Red">*</span></label>
															<select class="selectpicker show-tick form-control flat"
																ng-model="leadManage.leadSourceFkId"
																ng-options="x as x.companyName for x in leadSource track by x.leadSourcePkId" required>
															</select>
														</div>
													</div>

													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Lead Type<span style="color: Red">*</span></label>
															<select class="selectpicker show-tick form-control flat"
																ng-model="leadManage.leadTypeFkId"
																ng-options="x as x.commonConstantValue for x in leadType track by x.commonConstantPkId" required>
															</select>
														</div>
													</div>
													<div class="spinner" ng-show="loading">	
															<img src="<%=request.getContextPath()%>/include/img/loader.gif" />
															</div>
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>Approx Amount</label> <input type="text"
																class="form-control" ng-model="leadManage.amount" />
														</div>
													</div>
													<div class="col-xs-12 col-md-12">
														<div class="form-group">
															<label>SBU<span style="color: Red">*</span></label> <select
																class="selectpicker show-tick form-control flat"
																onChange="openDetail()" ng-model="leadManage.sbuFkId"
																ng-options="x as x.commonConstantValue for x in sbu track by x.commonConstantPkId"
																ng-change="materialListFunction(leadManage.sbuFkId)" required>
															</select>
														</div>
													</div>

													<div class="col-xs-12 col-md-12" id="sbuDetail"
														style="display: none">
														<div class="form-group">
															<table cellpadding="0" cellspacing="0"
																class="table-bordered table">
																<thead>
																	<th style="padding: 5px;">Material Name<span
																		style="color: Red">*</span></th>
																	<th style="padding: 5px;">Qty in TN<span
																		style="color: Red">*</span></th>
																	<th>&nbsp;
																		<button class="btn btn-sm btn-primary rounded-0 p-2"
																			ng-click="addRow()"
																			style="width: 35%; font-size: 14px;">+</button>
																	</th>
																</thead>
																<tbody>
																	<tr ng-repeat="mdrow in materialList track by $index">
																		<td><select class="form-control"
																			ng-change="checkMaterialFunction($index)"
																			ng-model="materialList[$index].materialFkId.materialPkId" required>
																				<option ng-repeat="m in material"
																					value={{m.materialPkId}}>{{m.materialCode}}</option>



																				<!--  <select class="form-control" ng-model="materialList[$index].materialFkId"  ng-options="x as x.materialCode for x in material track by x.materialPkId ">
                                     <option value=""> Select Stock</option>   -->


																		</select></td>
																		<td><input type="number" name="qty"
																			ng-model="materialList[$index].quantity"
																			class="form-control"   required />
																<!-- ng-pattern="/^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/" -->

																		<td><button
																				class="btn btn-sm btn-danger rounded-0 p-2"
																				ng-click="removeRow($index)"
																				style="width: 35%; font-size: 14px;">-</button></td>


																		<!--  <td>  <span ng-show="$index == 0"   ><ng-show="" button class="btn btn-primary" ng-click="addRow()"><i class="fa fa-plus-square"></i></button></span>
      			                  <span ng-show="$index !=0" ><button type="button" class="btn btn-danger" ng-click="removeRow()"><i class="fa fa-minus-square"></i></button></span>
                            </td> -->
																	</tr>

																</tbody>
															</table>
														</div>
													</div>
												</div>

											</div>

										</div>


										<div class="row">
											<div class="col-xs-12">
												<h4 class="no-margin-top section-heading text-blue">Customer
													Address Detail</h4>
											</div>
											<div class="col-xs-12">
												<div class="form-group">
													
													<button type="button"
														class="btn btn-default btn-block text-blue"
														onClick="adressFromShow()">
														<i class="fa fa-map-marker"></i> Fill Address
													</button>
												</div>
											</div>

											<div class="col-xs-12">
												<div class="row" style="display: none;" id="addressForm">
													<div class="col-xs-12 col-md-3">
														<div class="form-group">
															<label>Country</label> <select class="form-control"
																ng-model="leadManage.countryFkId"
																ng-options="x as x.countryName for x in countries track by x.countryPkId"
																ng-change="statesList(leadManage.countryFkId)">
															</select>
														</div>
													</div>
													<div class="col-xs-12 col-md-3">
														<div class="form-group">
															<label>State</label>
															<!--  <input type="text" class="form-control" value="Haryana"> -->
															<select class="form-control"
																ng-model="leadManage.stateFkId"
																ng-options="x as x.stateName for x in states track by x.statePkId">
																<option value="">Select State</option>
															</select>
														</div>
													</div>
													<div class="col-xs-12 col-md-3">
														<div class="form-group">
															<label>District</label> <input type="text"
																ng-model="leadManage.location" class="form-control"
																>

															</select>
														</div>
													</div>
													<div class="col-xs-12 col-md-3">
														<div class="form-group">
															<label>Zip Code / Pin Code</label> <input type="text"
																ng-model="leadManage.pinCode" class="form-control"
																placeholder="ex. 124001">
														</div>
													</div>

													<div class="col-xs-12 col-md-6">
														<div class="form-group">
															<label>Street / H.N.</label>
															<textarea class="form-control"
																ng-model="leadManage.houseNo"></textarea>
														</div>
													</div>
												</div>
											</div>

											<div class="col-md-6">
												<label>Select Region<span style="color: Red">*</span></label> <select class="form-control"
													ng-model="leadManage.regionFkId"
													ng-options="x as x.regionName for x in region track by x.regionPkId" required>
												</select>
											</div>
										

											<div class="col-md-12">
											<div class="pull-right">
												<button class="btn btn-primary"
													ng-disabled="loading"
													=="false" ng-click="saveLead(26,leadManage);" ng-hide="leadForm.$invalid">Save
													& Draft</button>
												<button  class="btn btn-success"
													ng-disabled="loading"=="false" ng-hide="leadForm.$invalid" ng-click="saveLead(22,leadManage);">Submit</button>

											</div>	


											</div>
										

										</div>

									</div>
								</div>
							</div>
						</div>


						<div class="col-md-2 no-padding h-95"
							style="background-color: #e3e8e9;">
							<div class="form-group no-margin-bottom"
								style="background-color: #d9dfe1;">
								<select class="form-control" ng-model="showRegionToExecutive"
									ng-change="rsmUnderExecutive(showRegionToExecutive)"
									ng-options="x as x.regionName for x in showRegion track by x.regionPkId">
									<option value="">Select Region</option>
								</select>
							</div>



							<ul class="userList no-padding">
								<li><label class="no-margin">My Reporting RSM</lable></li>
								<li ng-repeat="rm in regionRmList track by $index"><a
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
				</form>
			</div>
		</div>
	</div>



	<footer class="dashboard-footer main-footer no-margin text-center">Copyright
		&copy; 2019-2020 Jindal Steel and Power. All rights reserved.</footer>




	<!-- <div id="bulkPopup" class="modal fade" role="dialog">
		<div class="modal-dialog" style="width: 50%">
			Modal content
			<div class="modal-content" id="upload-file"
				style="margin-top: 100px;">
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<a href="#" class="text-center d-block text-danger"><i
								class="fa fa-long-arrow-right"></i> Download Sample Excel</a><br>

							<h3 class="modal-title text-blue text-center">
								Upload Files<br> <small class="text-center text-black">Add
									multiple, Single files types are .doc, .ppt, .pdf. jpg etc...</small>
							</h3>

						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-md-12">
							<div class="fileUploader text-center">
								<div id="msg_replace">
									<h3 style="font-weight: normal">
										Drop Files here or click to upload.<br> <small
											class="text-center">Upload file types-
											.doc,.ppt,.pdf,.jpg etc... not actually uploaded</small>
									</h3>
								</div>
								<input type="file" onChange="encodeImageFileAsURL(this)"
									name="image" id="file" />
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer border-top">
					<button type="button"
						class="btn btn-default text-black no-bg no-border-radius"
						data-dismiss="modal">Not Now</button>
					<button type="button"
						class="btn btn-info text-white no-border-radius" id="upload-btn">Upload</button>
				</div>
			</div>

		</div>
	</div> -->

	<script>
		function openDetail() {
			$("#sbuDetail").show();
		}

		function adressFromShow() {
			$("#addressForm").toggle();

			// $("#addressForm").empty();

		}

	
		function assignPopupHide() {
			$("#assign-sales").modal('hide');
			$("#thanks-message").modal('show');
		}
	</script>
	<script type="text/ng-template" id="bulkUpload.html">

    <div class="modal-content" id="upload-file" style="margin-top:100px;">
 <div class="modal-header">
    <button type="button" class="close" ng-click="cancel()" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">Bulk Upload Excel</h4>
  </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-xs-12">
<label class="btn-block"> <a href="<%=request.getContextPath()%>/include/sample/lead.xlsx" class="pull-right"><strong><i class="fa fa-cloud-download" aria-hidden="true"></i> Download Sample File</strong></a></label>
            <h3 class="modal-title text-blue text-center">Select excel to upload<br> 
<input class="form-control" type="file" upload-bulk name="image">          
          </div>
        </div>     
      <div class="modal-footer border-top">
        <button type="button" class="btn btn-default text-black no-bg no-border-radius" data-dismiss="modal" ng-click="cancel()">Not Now</button>
        <button type="button" class="btn btn-info text-white no-border-radius" ng-click="bulkUploadExcel()">Upload</button>
      </div>
    </div>
<div class="spinner" ng-show="loading">	
															<img src="<%=request.getContextPath()%>/include/img/loader.gif" />
															</div>

</div>
</script>

</body>
</html>
