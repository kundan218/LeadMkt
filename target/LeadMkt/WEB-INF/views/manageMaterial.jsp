<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/include/img/favicon.ico">
<%@include file="./common/cssInclude.jsp"%>

<%@include file="./common/taglib.jsp"%>
<%@include file="./common/jsInclude.jsp"%>
   <script src="<%=request.getContextPath()%>/include/js/angular/controllers/MaterialController.js"></script>
<script src="<%=request.getContextPath()%>/include/js/angular/services/MaterialService.js"></script>

</head>
<body class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse"  ng-app="dmsApp" ng-controller="MaterialController" ng-init="initMaterial()">

<div class="wrapper">
<%@include file="./common/header.jsp"%>
  <div class="content-wrapper content-wrapper-inner style="margin-left:0 !important;">
   
   	 
     <div class="box-header">
     	<div class="container-fluid">        
            <div class="row">                 
                <div class="col-md-8">
                    <div class="header-icon pull-left">
                        <i class="fa fa-cubes"></i>
                    </div>
                    <div class="page-heading pull-left">    	                
	                    <h5 class="no-margin">Manage Your</h5>
                        <h4>Material</h4>
                    </div>
                </div>
                <div class="col-md-4">
       <a href="#" ng-click="openMaterialModal()" class="pull-right"><span class="btn btn-success">Add New</span></a>
    
                </div>
            </div>
        </div>
     </div>
   
    
    
    <section class="col-md-12 content" style="padding-top:0">
    
   
    
    <div class="box no-border">
      <div class="box-body no-padding">
      <div class="">
       <br>
      <div class="col-xs-12">
      <div class="table-responsive">
      <table class="table view-history table-responsive table-bordered dataTable" id="dataGrid">
      <thead>
      <tr> 
      <th>S.No</th>
      <th>Mat. Code</th>
      <th>Mat. Desc.</th>
  <!--     <th>Mat. SAP Id</th> -->
      <th>Mat. DMS Id</th>
      <th>Mat. Sbu Type</th>
      <th>Action</th>
      </tr>
      </thead>
      <tbody>
       <tr ng-repeat="material in materials" >
									<td>{{$index+1}}</td>
									<td>{{material.materialCode}}</td>
									<td>{{material.materialDesc}}</td>
									
									<!-- <td> <span ng-repeat="sapMaterial in material.materialPlant">{{sapMaterial.materialPlantName}} </span></td> -->
									
									<td>{{material.materialDmsId}}</td>
									<td>{{material.sbuTypeFkId.commonConstantValue}}</td>
									  <td><a href="" ng-click="openMaterialModal(material,$index)" class="btn btn-info btn-xs"><i class="fa fa-edit"></i></a>
									   <a href="" ng-click="openRemoveMaterialModal(material.materialPkId,$index)" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a> </td>
                   				</tr>
      </tbody>
      </table>
      </div>
      </div>
      </div>
      </div>
      </div>
    </section>
    <div class="clearfix"></div>
  </div>
 <%@include file="./common/footer.jsp"%></div>

<script type="text/ng-template" id="addMaterial.html">
<form:form name="materialForm">
 <div role="dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="cancel()">&times;</button>
        <h4 class="modal-title">Add/Edit Material</h4>
      </div>


         <div class="modal-body">
			<div class="row">
       		 <div class="col-md-12 col-sm-4">
                <div class="form-group">
                	<label>SBU</label>
                   <select class="form-control" ng-model="material.sbuTypeFkId" ng-options="x as x.commonConstantValue for x in sbuTypeList track by x.commonConstantPkId">
                   </select>
                </div>
 

			<div class="row">
       		 <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Material Code</label>
                   <input type="text" class="form-control" ng-model="material.materialCode" name="materialCode" required/>
                <p ng-show="materialForm.materialCode.$invalid && !materialForm.materialName.$pristine" class="help-block"></p>
                </div>
            </div>
            
           
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Material Desc</label>
  <input type="text" class="form-control" ng-model="material.materialDesc" name="materialDesc" required/>
                <p ng-show="materialForm.materialDesc.$invalid && !materialForm.materialDesc.$pristine" class="help-block"></p>
                           </div>
            </div>
            
            
            <div class="col-md-4 col-sm-4">
 <div class="form-group">
                	<label>Material Dms Id</label>
                <input type="text" class="form-control" ng-model="material.materialDmsId" name="materialDmsId" required/>
                <p ng-show="materialForm.materialDmsId.$invalid && !materialForm.materialDmsId.$pristine" class="help-block"></p>
           
                </div>
               
            </div>
            
       
       <div class="col-md-12 col-sm-12">
<table class="table table-bordered">
<tr>
<!--<th>Material Sap Id</th>-->
<!--<th>Add / Delete</th>-->
</tr>
 <!--<tr ng-repeat="sAPMaterial in  addSAPMaterial">
<td><input type="text" class="form-control" ng-model="sapMaterials[$index].materialPlantName" name="materialPlantName" required/>
<p ng-show="materialForm.materialPlantName.$invalid && !materialForm.materialPlantName.$pristine" class="help-block"></p>
</td>
<td ng-show="$index==0"><button class="btn btn-primary btn-xs" ng-click="addRow()"><i class="fa fa-plus"></i></button></td>
<td ng-show="$index!=0"><button class="btn btn-danger btn-xs" ng-click="removeRow($index)"><i class="fa fa-trash-o"></i></button></td>-->
</tr>

</table>
               
            </div>
             </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-default" ng-click="cancel()">Close</button> <button type="button" class="btn btn-info" ng-disabled="materialForm.$invalid" ng-click="saveMaterial(material,sapMaterials)">Submit</button>

      </div>
    </div>

</div>
</form:form>
</script>
<script type="text/ng-template" id="removeMaterial.html"> 
  <div class="modal-body">
    Are you sure! Delete Material ?
  </div>
  <div class="modal-footer">
    <button type="button"  class="btn btn-danger btn-ok" ng-click="deleteMaterial(materialId)">Delete</button>
    <button type="button"  class="btn" ng-click="cancel()">Cancel</button>
  </div>
</script>
<script type="text/javascript">
$('li').each(function(){
    if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
    {
    $(this).addClass('active').siblings().removeClass('active');
    }
 });
</script>

</body>
</html>