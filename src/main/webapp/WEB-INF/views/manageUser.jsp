<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@include file="./common/cssInclude.jsp"%>
 <%@include file="./common/taglib.jsp"%>

<style>
.main-header{ display:block;}
</style>
</head>
<body class="sidebar-mini skin-black wysihtml5-supported sidebar-collapse">
<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>
<div class="wrapper">
<%@include file="./common/header.jsp"%>
   
  <div class="content-wrapper content-wrapper-inner">
   	 
   
    <section class="col-md-12 content padding-bottom-none">
    
    <h3 class="box-title"><strong>Manage User</strong><a href="#" data-target="#executePopup" onclick="addUser()" data-toggle="modal" class="pull-right"><span class="btn btn-success">Add New</span></a></h3>
    <br />
    <div class="box no-border">
      <div class="box-body">
      <div class="table-responsive">
      <table class="table view-history table-responsive" id="dataGrid">
      <thead>
      <tr> 
      <th>S.No</th>
      <th>Name</th>
      <th>User ID</th>
      <th>Email ID</th>
      <th style="display:none" >Password</th>  
      <th style="display:none"></th>
      <th style="display:none"></th>
      <th style="display:none"></th>         
      <th>Contact No.</th>
      <th>Role</th> 
      <th>Location</th>
      
<!--       <th>Sap ID</th>  -->
     
      <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <!-- <tr>
      <td>1</td>
      <td>Aman Singh</td>
      <td>amansingh@gmail.com</td>
      <td>1254785</td>
      <td>+91 9966998855</td>
      <td><label class="label label-default">Admin</label></td>
      <td>Sonipat</td>
      <td>12345</td>
       <td><a href="#" class="btn btn-info btn-xs" data-toggle="tooltip" title="Edit"><i class="fa fa-edit"></i></a> <a href="#" class="btn btn-danger btn-xs" data-toggle="tooltip" title="Delete"><i class="fa fa-trash-o"></i></a></td>
      </tr> -->
      
      
      <c:forEach var="user" items="${userList}" varStatus="i">
								<tr>
									<td>${i.index+1}</td>
									<td id="name_${i.index}">${user.name}</td>
									<td id="username_${i.index}">${user.username}</td>
									<td id="email_${i.index}">${user.email}</td>
									
									<td style="display:none" id="status_${i.index}">${user.status}</td>
									<td  style="display:none"  id="registeredDate_${i.index}">${user.registeredDate}</td>
									
									<td style="display:none" id="pass_${i.index}">${user.password}</td>  
									
									<td style="display:none" id="distributorDmsId_${i.index}">${user.distributorDmsId}</td> 
									
									<td id="contact_${i.index}">${user.contactNumber}</td>
								 	<td>
									${user.roleName}
									<input type="hidden" id="userPkId_${i.index}" value="${user.userPkId}">
									</td> 
									<td>${user.locationName}</td>
									
	<%-- 								<td id="sap_${i.index}">${user.sapId}</td>  --%>
									
									<td><div class="btn-group">
									
									<a href="javascript:void(0);" data-target="#executePopup" data-toggle="modal"  onclick="editUser(${i.index},'${user.roleId}','${user.locationPkId}','${user.regionPkId}')"><i
											class="fa fa-fw fa-pencil text-blue"
											title="View User Details"></i></a> 
									</div></td>
                   				</tr>
								
                   		</c:forEach>
      </tbody>
      </table>
      </div>
      </div>
      </div>
    </section>
    <div class="clearfix"></div>
  </div>
  <footer class="main-footer"> <strong>Copyright &copy; 2017-2018 <a href="#">Jindal Steel and Power</a>.</strong> All rights reserved. </footer>
</div>
 <div id="executePopup" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
        <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title text-red">Add/Edit User</h4>
      </div>
        <form:form id="userId" modelAttribute=""  action="../saveUser.html">
  <input type="hidden" name="userFkId" id="userPkId" /> 
 
  <input type="hidden" name="status" id="statusId" value="0" /> 
  <input type="hidden" name="registeredDate" id="registeredDateId" value="<fmt:formatDate pattern = "yyyy-MM-dd" 
         value = "${now}" />" /> 
      <div class="modal-body">
 <div class="row">
<div class="col-xs-12 col-md-6">
<div class="form-group">

<label>Name</label>
      <input type="text" name="name"  class="form-control add-on" id="nameId" required/>
      </div>
</div>
<div class="col-xs-12 col-md-6">
<div class="form-group">
<label>User Name</label>
      <input type="text" name="username"  class="form-control add-on" id="userNameId" required/>
      </div>
      </div>
  <div class="col-xs-12 col-md-6">    
<div class="form-group">
<label>Email Id</label>
      <input type="text" name="email"  class="form-control add-on" id="validId"  required/>
      </div> </div>
      
       
      
      
       <div class="col-xs-12 col-md-6">    
<div class="form-group">
<label>Contact Number</label>
      <input type="text" name="contactNumber"  class="form-control add-on" id="contactId"  required/>
      </div> </div>
      
 <div class="col-xs-12 col-md-6">    
<div class="form-group">
<label>Password</label>
      <input type="password" name="password"  class="form-control add-on" id="passId" required/>
      </div></div>
       <div class="col-xs-12 col-md-6">    			
      <div class="form-group">
      <label>Region</label>
      <select id="userRegionId" name="userRegionId"  class="form-control" onchange="getLocation(this.value)" >
 	 <option value="" >--Select Region--</option>
 	 <c:forEach items="${regionList}" var="region" varStatus="lindex">
				<option  value="${region.regionPkId}">${region.regionName}</option>
				</c:forEach>
				</select>
      </div>      
      </div>
    <div class="col-xs-12 col-md-6">      
       <div class="form-group">
	 <label>Location</label>
	 
 	 <select id="userLoactionId" name="locationList"  class="form-control" multiple required>
 	 
 	 <c:forEach items="${locationList}" var="location" varStatus="lindex">
				<option  value="${location.locationPkId}">${location.locationName}</option>
				</c:forEach>
	 </select>
	 </div></div>
	<div class="col-xs-12 col-md-6">    			
      <div class="form-group">
      <label>Role</label>
       <select id="userRoleId" name="userRoleId"  class="form-control"  required onclick="sapDivHideShow(this.value)">
 	 <option value="" >--Select Role--</option>
 	 <c:forEach items="${roleList}" var="role" varStatus="lindex">
				<option  value="${role.roleId}">${role.roleName}</option>
				</c:forEach>
				</select> 
      </div>      
      </div>
      
      <div class="col-xs-12 col-md-6" id="sapDivHideShow"  style="display:none">    
<div class="form-group">
<label>Sap Id</label>
      <input type="text" name="sapId"  class="form-control add-on" id="sapId" required />
      </div> 
      </div>
      
      
       <div class="col-xs-12 col-md-6" id="dmsDivHideShow"  style="display:none">    
<div class="form-group">
<label>Distributor DMS Id</label>
      <input type="text" name="distributorDmsId"  class="form-control add-on" id="distributorDmsId" required />
      </div> 
      </div>
      </div> 
      
 </div>

      
     
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary"  >Submit</button>

      </div>
       </form:form>  
    </div>

  </div>
</div>




<%@include file="./common/jsInclude.jsp"%>
 <%@include file="./common/footer.jsp"%>
<script>
$('#preloader').delay(350).fadeOut('slow');
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
    $('#dataGrid').DataTable({});
    
   
	$('#create-PO').click(function () {
		toastr.options = {
		extendedTimeOut: 1000,
		timeOut: 5000,
		positionClass: 'toast-top-center',
		}
		toastr["success"]("User has been Update Successfully.<br /><br />Thank You!")
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
  
  
  

  function editUser(value,roleId,locationList,regionId){
 	 var userName=$('#username_'+value).html();
 	 var userPkId=$('#userPkId_'+value).val();
 	 $('#userNameId').val(userName);
 	 $('#userNameId').attr('readonly', true)
 	 //$('#passId').val($('#pass_'+value).text());
 	 /* $('#passId').attr('readonly', true) */
 	 $('#userPkId').val(userPkId);
 	 $('#nameId').val($('#name_'+value).text());
 	 $('#validId').val($('#email_'+value).text());
 	 
 	$('#sapId').val($('#sap_'+value).text());
 	
 	$('#statusId').val($('#status_'+value).text());
 	
 	$('#registeredDateId').val($('#registeredDate_'+value).text());
 	
 	$('#distributorDmsId').val($('#distributorDmsId_'+value).text());
 	 
 	
 	$('#contactId').val($('#contact_'+value).text());
 	 
 	 $('#userRoleId option[value="'+roleId+'"]').attr("selected","selected");
 	$('#userRegionId option[value="'+regionId+'"]').attr("selected","selected");
 	
 	
 	
 	getLocation(regionId);
 
 	
 	 var locations=locationList.split(",");
 	 if(locations.length>0)
 		 {
 		 for(var i=0;i<locations.length;i++)
 			 { 			
 		$('#userLoactionId option[value="'+locations[i]+'"]').attr("selected","selected");
 		
 		 $('#userLoactionId').val(locations[i]);

 		 }
 		
 		 }
	
 	 //colors[1]
 	 	sapDivHideShow(roleId)
 	
  }
  
  function addUser(){

 	 $("option:selected").prop("selected", false)
 	 $('#userNameId').attr('readonly', false)
 	 $('#passId').attr('readonly', false)
 	 $('#userNameId').val('');
 	 
 	$('#userPkId').val('');
 	 $('#validId').val('');
 	 $('#passId').val('');
 	 $('#nameId').val('');
 	 $("#modalUser").modal('show');
 	 
 	
  }
  
  
  function removeUser(userId){
      var deleteFlag = confirm("Are you confirm for delete User ?");
           if(!deleteFlag)
                   return false;
           else{
      $.get("./deleteUser.html",{'userId':userId},function(modal){
     	 
              });
      $("#removeUser"+userId).remove(); 
           }
    location.reload();
      
 }
  
	function getLocation(userRegionId){
		
		
	
	       
		$.ajax({
		    url : "${pageContext.request.contextPath}/admin/getLocationList",
		    type : "get",
		    data: {'userRegionId':userRegionId},
		    async: false,
		    success : function(modal) {
		    	
		    	var data=modal;
				var location = "";
				for (var i = 0; i < data.length; i++) {
					location += "<option value='"+data[i].locationPkId+"'>"+ data[i].locationName + "</option>";
				}
				$("#userLoactionId").html(location);

		    },
		    error: function() {
		       connectionError();
		    }
		 });
	}
	
	  $('li').each(function(){
	      if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
	      {
	      $(this).addClass('active').siblings().removeClass('active');
	      }
	   });
</script>

<script type="text/javascript">

function sapDivHideShow(sapDivHideShow){
	destroy: true;	
	
	if(sapDivHideShow==2){
		$("#sapDivHideShow").show();
		$("#dmsDivHideShow").show();
		

        $("#distributorDmsId"). attr("required","required");
		$("#sapId"). attr("required","required");
	}else{
		$("#sapDivHideShow").hide();	
		$("#dmsDivHideShow").hide();	
		
$("#distributorDmsId"). removeAttr("required");
		
		$("#sapId"). removeAttr("required");
	}
	
	
}



</script>

</body>
</html>
