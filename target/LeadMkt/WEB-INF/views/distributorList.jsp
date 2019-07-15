<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@include file="./common/cssInclude.jsp"%>
<%@include file="./common/taglib.jsp"%>
<%@include file="./common/jsInclude.jsp"%>
   <script src="<%=request.getContextPath()%>/include/js/angular/controllers/DistributorController.js"></script>
<script src="<%=request.getContextPath()%>/include/js/angular/services/DistributorService.js"></script>
<!-- <script>
  angular.module("dmsApp").constant("CSRF_TOKEN", '{{ csrf_token() }}');
</script> -->
</head>
<body class="skin-black user-body" ng-app="dmsApp" ng-controller="DistributorController" ng-init="initDistributor()">
<div class="wrapper">
 <%@include file="./common/admin-header.jsp"%>
   
  <div class="content-wrapper content-wrapper-inner">
   	 
   
    <section class="col-md-12 content padding-bottom-none">
    
    <h3 class="text-white">Manage Your Distributor 
    <!-- <a href="#" ng-click="openDistributorModal()" class="pull-right"><span class="btn btn-success">Add New</span></a> -->
    </h3>
    <br />
    
    
    <div class="box no-border">
      <div class="box-body">
      <div class=" ">
      <div class="table-responsive" style="overflow-x:scroll">
      <table class="table view-history table-responsive table-bordered" id="dataGrid">
      <thead>
          <tr>
           
            <th>Sr. No.</th>
            <th>Dist. SAP Id</th>
            <th>Dist. Name</th>
            <th>Dist. Contact Person</th>
            <th>Dist. Address</th>
            <th>Dist. City</th>
            <th>District</th>
            <th>State</th>
            <th>Postal Code</th>
            <th>Mobile</th>
            <th>Email ID</th>
            <th>GST No</th>
            <th>PAN No</th>
             <th>Action</th>
          </tr>
          </thead>
          <tbody>
			 <tr ng-repeat="distributor in distributors" >
									<td>{{$index+1}}</td>
									<td>{{distributor.sapId}}</td>
									<td>{{distributor.distributorName}}</td>
									<td>{{distributor.contactPerson}}</td>
									<td>{{distributor.address}}</td>
									<td>{{distributor.city}}</td>
									<td>{{distributor.district}}</td>
									<td>{{distributor.stateFkId.stateName}}</td>
									<td>{{distributor.pinCode}}</td>
									<td>{{distributor.mobileNo}}</td>
									<td>{{distributor.email}}</td>
									<td>{{distributor.vatNo}}</td>
									<td>{{distributor.panNo}}</td>
									  <td><a href="" ng-click="openDistributorModal(distributor,$index)" class="btn btn-info btn-xs pull-left"><i class="fa fa-edit"></i></a>
									   <a href="" ng-click="openRemoveDistributorModal(distributor.distributorPkId,$index)" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a> </td>
                   				</tr>
								
          </tbody>
        </table>
        </div>
      </div>
      </div>
      </div>
      
     
    </section>
    
     
    
    
    <div class="clearfix"></div>
  </div>
 <%@include file="./common/footer.jsp"%>
</div>



<script type="text/ng-template" id="addDistributor.html">
<form:form name="distributorForm">
 <div role="dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" ng-click="cancel()">&times;</button>
        <h4 class="modal-title">Add/Edit Distributors</h4>
      </div>

      <div class="modal-body">
      
			<div class="row">
       
       
       		 <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Distributor Name</label>
                   <input type="text" class="form-control" ng-model="distributor.distributorName" name="distributorName" required/>
                <p ng-show="distributorForm.distributorName.$invalid && !distributorForm.distributorName.$pristine" class="help-block"></p>

                </div>
            </div>
            
           
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Contact Person</label>
                   <input type="text" class="form-control"  ng-model="distributor.contactPerson"/>
                </div>
            </div>

   			<div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Distributor SAP Id</label>
                   <input type="text" class="form-control"  ng-model="distributor.sapId" required/>
 <p ng-show="distributorForm.sapId.$invalid && !distributorForm.sapId.$pristine" class="help-block"> Please Enter the SAP ID.</p>
                </div>
            </div>
            
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Address</label>
                   <input type="textarea" class="form-control"  ng-model="distributor.address"/> 
                </div>
            </div>
            
       
       <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>District</label>
                  <input type="text" class="form-control"  ng-model="distributor.district"/>
                </div>
            </div>
       <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>City</label>
                 <input type="text" class="form-control"  ng-model="distributor.city"/>
                </div>
            </div>
       		
 			<div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Location</label>
					<Select class="form-control checkout-cart" ng-model="distributor.locationFkId" ng-options="location as location.locationName for location in locations  track by location.locationPkId">>
                        	<option value="">--Select Location--</option>
                        </Select>
                </div>
            </div>

            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>State</label>
					<Select class="form-control checkout-cart" ng-model="distributor.stateFkId" ng-options="state as state.stateName for state in states  track by state.statePkId">>
                        	<option value="">--Select State--</option>
                    		 
					</Select>
                </div>
            </div>

				 <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Country</label>
					<Select class="form-control checkout-cart" ng-model="distributor.countryFkId" ng-options="country as country.countryName for country in countrys  track by country.countryPkId">>
                        	<option value="">--Select Country--</option>
                        </Select>
                </div>
            </div>
            
             <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Pincode</label>
                    <input type="text" class="form-control"  ng-model="distributor.pinCode" name="pinCode" ng-pattern="/^[0-9]{6}$/" maxlength="6" required/>
					<p ng-show="distributorForm.pinCode.$error.pattern" class="help-block">Please Enter Valid Pin Code.</p>
			
                </div>
            </div>
       
       
       		<div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>GST No.</label>
                   <input type="text" class="form-control"  ng-model="distributor.vatNo"/>
                </div>
            </div>
            
             <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>TIN No.</label>
                    <input type="text" class="form-control"  ng-model="distributor.tinNo"/>
                </div>
            </div>
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>PAN No.</label>
                    <input type="text" class="form-control"  ng-model="distributor.panNo"/>
                </div>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Service Tax No.</label>
                    <input type="text" class="form-control"  ng-model="distributor.serviceTaxNo"/>
                </div>
            </div>
            
            
            
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Mobile No.</label>
                     <input type="text" class="form-control"  ng-model="distributor.mobileNo" name="mobileNo" ng-pattern="/^[0-9]{10}$/" maxlength="10" required/>
 						<p ng-show="distributorForm.mobileNo.$error.pattern" class="help-block">Please Enter Valid Mobile No.</p>
                </div>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Email-ID</label>
                    <input type="email" class="form-control"  ng-model="distributor.email" name="email" ng-pattern="/^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/" required/>
                    <p ng-show="distributorForm.email.$invalid && !distributorForm.email.$pristine" class="help-block"> Please Enter valid Email.</p>
                </div>
            </div>



     <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Regional Officer </label>
					<Select class="form-control checkout-cart" ng-model="distributor.regionalManager">
                        	<option value="" selected="true">--Select Regional Officer--</option>
							<option ng-repeat="user in regionalOfficers" value="{{user.userPkId}}" ng-selected="{{user.userPkId == distributor.regionalManager}}">{{user.name}}</option>   
                        </Select>
                </div>
            </div> 

             <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Sales Officer</label>
					<Select class="form-control checkout-cart" ng-model="distributor.salesOfficer">
                        	<option value="" selected="true">--Select Sales Officer--</option>
							<option ng-repeat="user in salesOfficers" value="{{user.userPkId}}" ng-selected="{{user.userPkId == distributor.salesOfficer}}">{{user.name}}</option>
                        </Select>
                </div>
            </div>   
		
 <div class="col-md-12 col-sm-4">
                <div class="form-group">
                	<label>Terms & Condition</label>
					<input type="text" class="form-control"  ng-model="distributor.termsCondition" name="termsCondition" />
                </div>
            </div> 
              
         </div>
       
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-default" ng-click="cancel()">Close</button> <button type="button" class="btn btn-info" ng-disabled="distributorForm.$invalid" ng-click="saveDistributor(distributor)">Submit</button>

      </div>
    </div>

</div>
</form:form>
</script>
<script type="text/ng-template" id="removeDistributor.html"> 
  <div class="modal-body">
    Are you sure! Delete Distributor ?
  </div>
  <div class="modal-footer">
    <button type="button"  class="btn btn-danger btn-ok" ng-click="deleteDistributor(distributorId)">Delete</button>
    <button type="button"  class="btn" ng-click="cancel()">Cancel</button>
  </div>
</script>

<script>
$(function(){ 
      $('.eventsBar ul').slimScroll({
          allowPageScroll: 'false' ,
		  height : 700,
      });

    });
	

  $(function () {
  $('.dropdown-menu a').click(function () {
  var gettext = $(this).text(); 
  $(".dropdown-toggle span").text(gettext);
  });
    $('#dataGrid').DataTable({
    });
	
	$('#create-PO').click(function () {
		toastr.options = {
		extendedTimeOut: 1000,
		timeOut: 5000,
		positionClass: 'toast-top-center',
		}
		toastr["success"]("Price has been Update Successfully.<br /><br />Thank You!")
		});
		
		
		$('.btn-reject').click(function () {
		toastr.options = {
		extendedTimeOut: 0,
		timeOut: 0,
		positionClass: 'toast-top-center',
		}
		toastr["error"]("Are you sure to reject a request.<br /><br /><br /><button type=\"button\" class=\"btn btn-default clear\">Yes</button>")
		
		});
	
  });
  
  $(function () {
        $('#datetimepicker6').datetimepicker({
            useCurrent: false,
			format: "DD/MM/YYYY" //Important! See issue #1075
        });
        $('#datetimepicker7').datetimepicker({
            useCurrent: false,
			format: "DD/MM/YYYY" //Important! See issue #1075
        });
        
    });
  
  $('li').each(function(){
      if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
      {
      $(this).addClass('active').siblings().removeClass('active');
      }
   });
</script>


</body>
</html>
