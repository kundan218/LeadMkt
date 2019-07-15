<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- Bootstrap 3.3.2 -->
<%@include file="./common/cssInclude.jsp"%>
<%@include file="./common/taglib.jsp"%>
<%@include file="./common/jsInclude.jsp"%>
<script src="<%=request.getContextPath()%>/include/js/angular/controllers/SourceController.js"></script>
<script src="<%=request.getContextPath()%>/include/js/angular/services/SourceService.js"></script>


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
.main-header{ display:block;}

</style>



</head>
<body class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse" ng-app="leadApp" ng-controller="SourceController" ng-init="initSource()">
<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
<div class="wrapper">
<%@include file="./common/header.jsp"%>      
      <div class="content-wrapper" style="margin-left:0 !important;">
      <div class="container-fluid">
      <div class="row">
      <div class="col-md-10 no-padding">
      <div class="box no-border">
      <div class="box-body">
      <div class="box-header no-margin-bottom">
      <h3 class="box-title"><strong>Manage Source</strong></h3>
      <div class="pull-right">
      <a  href="javascript:history.back(-1)"class="btn btn-default">Back</a>
<a href="" ng-click="createSource()" class="btn btn-primary" data-toggle="modal">Create New</a>
      </div>
      </div>
      
      <div class="box-body">
      <table class="table table-bordered">
                  <tr>
                  <th>Company</th>
                  <th>Contact Validity Till</th>
                  <th>Status</th>
                  <th>Action</th>
                  </tr>
                  <tr ng-repeat="lsl in leadSourceList track by $index">
                    <td><strong class="text-primary">{{lsl.companyName}}</strong></td>
                    <td><strong>{{lsl.contractValidityDateFrom |  date :"dd-MMM-yyyy "}} to {{lsl.contractValidityDateTo |  date :"dd-MMM-yyyy"}}</strong></td>
                    <td><span class="label label-success">{{lsl.leadSourceStatusFkId.commonConstantValue}}</span></td>
                    <td><a href="#managePopup" data-toggle="modal" ng-click="editSource(lsl)"><i class="fa fa-edit text-info" data-toggle="tooltip" title="Edit"></i></a> <a href="" ng-click="deleteLeadSource(lsl.leadSourcePkId,$index)"><i class="fa fa-trash text-danger" data-toggle="tooltip" title="Delete"></i></a></td>
                  </tr>
                  </table>
      </div>
      </div>
      </div>           	 
        
         
        </div>
        

      </div>
      </div>
      </div>
      
      </div>
  

<%@include file="./common/footer.jsp" %>



<script type="text/ng-template" id="createSource.html">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header bg-blue">
        <h4 class="modal-title" id="exampleModalLabel">Add / Edit Detail
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" ng-click="cancel()">
          <span aria-hidden="true">&times;</span>
        </button>
        </h4>
        
      </div>
      <div class="modal-body">
      <div class="row">
      <div class="col-md-6">
      <div class="form-group">
      <label>Company Name</label>
      <input type="text" ng-model="leadSource.companyName" class="form-control" />
      </div>
      </div>
      
      <div class="col-md-3">
      <div class="form-group">
      <label>Contract Validity (From) </label>
      <input type="text"   id="datefrom" class="form-control" ng-model="leadSource.contractValidityDateFrom"  ng-model="visitor.dateFrom" placeholder="" 
																				uib-datepicker-popup="{{format}}" ng-click="open1()"
																				ng-pattern="/^((\d{4})-(\d{2})-(\d{2})|(\d{2})\/(\d{2})\/(\d{4}))$/"
																				is-open="popup1.opened"
																				datepicker-options="fromDateOptions" Required>
      
      </div>
      </div>
      
      <div class="col-md-3">
      <div class="form-group">
      <label>To </label>
      <input type="text"   id="datefrom" class="form-control"  ng-model="leadSource.contractValidityDateTo" placeholder="" 
																				uib-datepicker-popup="{{format}}" ng-click="open3()"
																				ng-pattern="/^((\d{4})-(\d{2})-(\d{2})|(\d{2})\/(\d{2})\/(\d{4}))$/"
																				is-open="popup3.opened"
																				datepicker-options="fromDateOptions" Required>
      </div>
      </div>
      
      <div class="col-md-6">
      <div class="form-group">
      <label>Status</label>
      <select class="form-control" ng-model="leadSource.leadSourceStatusFkId" ng-options="x as x.commonConstantValue for x in leadStatusList track by x.commonConstantPkId">
      <option>---Select---</option>
      </select>
      </div>
      </div>
      
      </div>
      
      
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" ng-click="cancel()">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="saveEditSource(leadSource)">Submit</button>
      </div>
    </div>
  </div>
</script>





<div id="bulkPopup" class="modal fade" role="dialog">
  <div class="modal-dialog" style="width:50%"> 
    <!-- Modal content-->
    <div class="modal-content" id="upload-file" style="margin-top:100px;">
      <div class="modal-body">
        <div class="row">
          <div class="col-xs-12">
            <h3 class="modal-title text-blue text-center">Upload Files<br>
<small class="text-center text-black">Add multiple, Single files types are .doc, .ppt, .pdf. jpg etc...</small></h3>
            
          </div>
        </div>
        <div class="row">
          <div class="col-xs-12 col-md-12">
            <div class="fileUploader text-center">
              <div id="msg_replace"><h3 style="font-weight:normal">Drop Files here or click to upload.<br>
<small class="text-center">Upload file types- .doc,.ppt,.pdf,.jpg etc... not actually uploaded</small></h3></div>
              <input type="file" onChange="encodeImageFileAsURL(this)"  name="image" id="file" />
          </div>

          </div>
        </div>
      </div>
      <div class="modal-footer border-top">
        <button type="button" class="btn btn-default text-black no-bg no-border-radius" data-dismiss="modal">Not Now</button>
        <button type="button" class="btn btn-info text-white no-border-radius" id="upload-btn">Upload</button>
      </div>
    </div>

</div></div>





 




<div id="thanks-message" class="modal fade" role="dialog">
  <div class="modal-dialog" style="width: 425px;"> 
    <div class="modal-content">
      <div class="modal-header" style="background-color: #407928 !important; color: #fff !important; border-bottom:none">
        <button type="button" class="close" data-dismiss="modal" style="color:#fff">&times;</button>
        <h5 class="modal-title">Your Lead has been Succesfully Assigned to the RSM. </h5>
      </div>
    </div>
  </div>
</div>



<script>
$('#preloader').delay(350).fadeOut('slow');
function adressFromShow (){

$("#addressForm").toggle();
}
function dropDownList (obj){
	$(obj).children().find("i.collapseicon").toggleClass("fa-minus");
	$(obj).next(".childrenList").toggle();
	}



function assignPopupHide() {
    $("#assign-sales").modal('hide');
	$("#thanks-message").modal('show');
}

 
</script>

</body>
</html>