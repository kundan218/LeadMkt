<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@include file="./common/cssInclude.jsp"%>
</head>
<body class="skin-black user-body">
<div class="wrapper">
 <%@include file="./common/admin-header.jsp"%>
   <%@include file="./common/taglib.jsp"%>
  <div class="content-wrapper content-wrapper-inner">
   	 
   
    <section class="col-md-12 content padding-bottom-none">
    
    <h3 class="text-white">Add Distributor<a href="distributor" class="pull-right"><span class="btn btn-default">Back</span></a></h3>
    <br />
    <form:form id="distributorId" modelAttribute="distributor"  action="../saveDistributor" name="distributorId">
    <div class="box no-border">
      <div class="box-body">
     
       <div class="row">
       		 <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>First Name</label>
                     <form:input path="firstName"  class="form-control add-on validate" id="firstNameId" />
                </div>
            </div>
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Last Name</label>
                     <form:input path="lastName"  class="form-control add-on validate" id="lastNameId" />
                </div>
            </div>
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Contact Person</label>
                      <form:input path="contactPerson"  class="form-control add-on validate" id="contactPersonId" />
                </div>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Distributor SAP Id</label>
                      <form:input path="sapId"  class="form-control add-on validate" id="sapId11" />
                </div>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Address</label>
                    <form:textarea path="address"  class="form-control add-on validate" id="addressId" />
                </div>
            </div>
            
       
       <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>District</label>
                     <form:input path="district"  class="form-control add-on validate" id="districtId" />
                </div>
            </div>
       <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>City</label>
                    <form:input path="city"  class="form-control add-on validate" id="cityId" />
                </div>
            </div>
       		
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>State</label>
                	<Select name="stateId.statePkId" class="form-control checkout-cart">
                        	<option value="">--Select State--</option>
                        	<c:forEach var="state" items="${stateList}">
	                  
	                   			<option  value="${state.statePkId}">${state.stateName }</option>
	                   			
                    		</c:forEach>
                        </Select>
        <%--      <form:select id="stateId" path="stateName"  class="form-control"  >
				<form:option value="" label="----Select State ---"/>
				 <form:options  items="${state.stateName }"  /> 
				</form:select> --%>
                </div>
            </div>
            
             <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Pincode</label>
                    <form:input path="pinCode"  class="form-control add-on validate" id="pincodeId" />
                </div>
            </div>
       
       
       
       
       		<div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>VAT No.</label>
                      <form:input path="vatNo"  class="form-control add-on validate" id="vatId" />
                </div>
            </div>
            
             <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>TIN No.</label>
                     <form:input path="tinNo"  class="form-control add-on validate" id="tinId" />
                </div>
            </div>
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>PAN No.</label>
                      <form:input path="panNo"  class="form-control add-on validate" id="panId" />
                </div>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Service Tax No.</label>
                     <form:input path="serviceTaxNo"  class="form-control add-on validate" id="serviceTaxId" />
                </div>
            </div>
            
            
            
            
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Mobile No.</label>
                     <form:input path="mobileNo"  class="form-control add-on validate" id="mobileId" />
                </div>
            </div>
            <div class="col-md-4 col-sm-4">
                <div class="form-group">
                	<label>Email-ID</label>
                   <form:input path="email"  class="form-control add-on validate" id="emailId" />
                </div>
            </div>
                            
         </div>
      <div class="col-xs-12">
      <div class="">
      	<a href="distributor">
      	<button class="btn btn-default">Cancel</button></a> 
      	<button type="submit" class="btn btn-success margin" >Save</button>
      </div>
 
      
      </div>
    
      </div>
      </div>
    </form:form>  
     
    </section>
    
     
    
    
    <div class="clearfix"></div>
  </div>
  <footer class="main-footer"> <strong>Copyright &copy; 2017-2018 <a href="#">Jindal Steel and Power</a>.</strong> All rights reserved. </footer>
</div>



<div id="executePopup" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add/Edit Users</h4>
      </div>
      <div class="modal-body">
      <div class="row">
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>User Name</label>
                <input type="text" class="form-control">
           </div>
      </div>
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>Contact No.</label>
                <input type="text" class="form-control">
           </div>
      </div>
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>Email-ID</label>
                <input type="text" class="form-control">
           </div>
      </div>
      
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>SAP-ID</label>
                <input type="text" class="form-control">
           </div>
      </div>
      
       
      
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>Select Role</label>
                <select class="form-control">
                    <option>--Select Role--</option>
                    <option>Admin</option>
                    <option>User</option>
                </select>
      </div>
      </div>
      
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>Select Location</label>
                <select class="form-control">
                    <option>--Select State--</option>
                    <option>Sonipat</option>
                    <option>Raigarh</option>
                </select>
      </div>
      </div>
      
      
      <div class="col-xs-12 col-md-6">
      <div class="form-group">
                <label>Password</label>
                <input type="text" class="form-control">
      </div>
      </div>
      
      
      </div>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" data-dismiss="modal">Submit</button>
      </div>
    </div>

  </div>
</div>



<%@include file="./common/jsInclude.jsp"%>
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
     "bFilter":false,
	 "bInfo":false,
	 "bSort":false,
	 "bLengthChange":false, 
    });
	
	$('#create-PO').click(function () {
		toastr.options = {
		extendedTimeOut: 1000,
		timeOut: 3000,
		positionClass: 'toast-top-center',
		}
		toastr["success"]("Distributor has been Added successfully.<br /><br />Thank You!");
		
		setTimeout(function(){ 
		window.location.href = "manage-distributor.html";
		
		}, 3000);
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
  
  
</script>


</body>
</html>
