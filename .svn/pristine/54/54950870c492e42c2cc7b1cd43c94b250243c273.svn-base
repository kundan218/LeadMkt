<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<%@include file="./common/cssInclude.jsp"%>
<%@include file="./common/taglib.jsp"%>
<%@include file="./common/jsInclude.jsp"%>
   </head>
      <script src="<%=request.getContextPath()%>/include/js/angular/controllers/DistributorController.js"></script>
<script src="<%=request.getContextPath()%>/include/js/angular/services/DistributorService.js"></script>
<body class="skin-black" ng-app="dmsApp" ng-controller="DistributorController" ng-init="initDistributor()">
<div id="preloader">
               <div id="status">&nbsp;</div>
  </div>





<%-- <%@ include file="./common/header.jsp" %> --%>
<sec:authorize access="hasAnyRole('DISTRIBUTOR')">
	<%@include file="./common/header.jsp"%>
 </sec:authorize>
<%--   <sec:authorize access="hasAnyRole('SALES_MARKETING','ADMIN','REGIONAL_MANAGER','SBU','ASM')">
  <%@include file="./common/admin-header.jsp"%>
  </sec:authorize>
	 --%>
  <div class="content-wrapper content-wrapper-inner">
  
   <div class="box-header">
     	<div class="container-fluid">        
            <div class="row">                 
                <div class="col-md-8">
                    <div class="header-icon pull-left">
                        <i class="fa fa-file-text-o"></i>
                    </div>
                    <div class="page-heading pull-left">    	                
	                    <h5 class="no-margin">Edit Profile</h5>
                        <h4>My Profile</h4>
                    </div>
                </div>
                
                <div class="col-md-4">
                	<div class="btn-group btn-group-sm pull-right">
                     <!--  <a href="create-po-request" class="btn btn-default">Back <i class="fa fa-arrow-circle-left"></i></a> -->
                   </div>
                </div>
                
            </div>
        </div>
     </div>
  
  
  
    <div class="container-fluid">
      <div class="row">
      <div class="col-xs-12">
      
            <div class="box no-border dash-min-height" style="min-height:390px">             
            	
			     
			     
            	<div class="box-body">
                	
                	<div class="row">                    	
                    	<div class="col-md-3" style="margin-top:15px">
                			<div class="product-detail-image no-padding">
                			<img src="${pageContext.request.contextPath}/include/img/avatar5.png" id="image"> 
                			
                			<a href="javascript:void();" name="addPhoto" id="addPhoto"><i class="fa fa-upload"></i></a>
               <!-- <input type="button" name="addPhoto" id="addPhoto" value="Add Photo" /> -->
                                                                           <input type="file" name="uploadFile" id="uploadImage1" style="visibility:hidden;"  onchange="readURL(this);"/>
                			</div>                            
                    	</div>
                        
                        <div class="col-md-9">
                        	<div class="row flex-row" id="view-detail" ng-hide="editDisFlag">
                                  <div class="col-xs-12 col-md-6 border-right">
                                    <h3 class="no-margin-top section-heading text-blue" style="font-size:20px">{{distributerDetail.distributorName}} </h3>
                                     
                                    <div class="row">
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-user"></i> Name</label>
                                          <p>{{distributerDetail.contactPerson}} <a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-envelope"></i> Email</label>
                                          <p>{{distributerDetail.email}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                     <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-phone"></i> Contact No.</label>
                                          <p>{{distributerDetail.mobileNo}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-cubes"></i> Address</label>
                                          <p>{{distributerDetail.address}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                         <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-cubes"></i> Terms & Condition</label>
                                          <p>{{distributerDetail.termsCondition}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="col-xs-12 col-md-6">
                                    <h4 class="no-margin-top section-heading text-blue">&nbsp;</h4>
                                    <div class="row">
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-briefcase"></i> Pin Code</label>
                                          <p>{{distributerDetail.pinCode}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-file-text-o"></i> GST No.</label>
                                          <p>{{distributerDetail.vatNo}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-file-text-o"></i> PAN No.</label>
                                          <p>{{distributerDetail.panNo}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                          <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-file-text-o"></i> Service Tax No.</label>
                                          <p>{{distributerDetail.serviceTaxNo}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                         <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-file-text-o"></i> TIN No.</label>
                                          <p>{{distributerDetail.tinNo}}<a href="" ng-click="editDistributer()" class="edit-icon text-gray formOpen"><i class="fa fa-pencil pull-right"></i></a></p>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  
                    		  </div>
                        	
                            <div class="row" ng-show="editDisFlag">
                                  <div class="col-xs-12 col-md-6 border-right">
                                    <h4 class="no-margin-top section-heading text-blue">Edit Detail</h4>
                                    <div class="row">
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                          <label><i class="fa fa-user"></i> Name</label>
                                          <input type="text" class="form-control"  ng-model="distributerDetail.contactPerson">
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                            <label><i class="fa fa-envelope"></i> Email</label>
                                          <input type="text" readonly="readonly" class="form-control" ng-model="distributerDetail.email">
                                        </div>
                                      </div>
                                     <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                              <label><i class="fa fa-phone"></i> Contact No.</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.mobileNo">
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                            <label><i class="fa fa-cubes"></i> Address </label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.address">
                                        </div>
                                      </div>
                                        <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                            <label><i class="fa fa-cubes"></i> Terms & Condition</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.termsCondition">
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                             
                                  <div class="col-xs-12 col-md-6">
                                    <h4 class="no-margin-top section-heading text-blue">&nbsp;</h4>
                                    <div class="row">
                                    <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                             <label><i class="fa fa-briefcase"></i> Pin Code</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.pinCode">
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                            <label><i class="fa fa-file-text-o"></i> GST No.</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.vatNo">
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                             <label><i class="fa fa-file-text-o"></i> PAN No.</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.panNo">
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                      <label><i class="fa fa-file-text-o"></i> Service Tax No.</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.serviceTaxNo">
                                        </div>
                                      </div>
                                      <div class="col-xs-12 col-md-12">
                                        <div class="form-group">
                                           <label><i class="fa fa-file-text-o"></i> TIN No.</label>
                                          <input type="text" class="form-control" ng-model="distributerDetail.tinNo">
                                        </div>
                                      </div>
                                       
                                    </div>
                                  </div>
                                   <div class="col-md-12">
                                    <button class="btn btn-default close-edit" ng-click="cancelProfile()">Cancel</button> &nbsp; 
                                    <button class="btn btn-success close-edit" type="button" ng-click="saveDistributorDetail(distributerDetail)">Submit</button>
                                </div>
                    		  </div>
                        
                        
                        	  
                        	 
                        </div>
                        
                        
                        
                    </div>
                    
            	</div>
            </div>
           
        </div>
      </div>

      </div>
        
      </div>
     
    <div class="clearfix"></div>

  <footer class="main-footer"> <strong>Copyright &copy; 2017-2018 <a href="#">Jindal Steel and Power</a>.</strong> All rights reserved. </footer>






<%-- 


<script src="<%=request.getContextPath()%>/include/js/jQuery-2.1.3.min.js"></script> 
<script src="<%=request.getContextPath()%>/include/js/bootstrap.min.js" type="text/javascript"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/include/plugins/chart/Chart.bundle.js"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/toast/toastr.min.js"></script> 
<script src="<%=request.getContextPath()%>/include/js/moment-with-locales.js"></script> 
<script src="<%=request.getContextPath()%>/include/js/bootstrap-datetimepicker.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/include/plugins/slimScroll/jquery.slimscroll.js"></script> 
<script src="<%=request.getContextPath()%>/include/js/app.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/include/plugins/highchart/highcharts.js"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/highchart/funnel.js"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/highchart/highcharts-more.js"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/highchart/heatmap.js"></script> 
<script src="<%=request.getContextPath()%>/include/plugins/highchart/exporting.js"></script>  --%>
<script>
function formOpen (){
	$('#edit-detail').fadeIn();
	$('#view-detail').fadeOut();	
	
}

function formclose (){
	$('#edit-detail').fadeOut();
	$('#view-detail').fadeIn();	
	
}



$('.stock-list-inc').slimScroll({
    height: '100px',
    size: '2px',
    color: '#ffcc00'
});




$(function(){ 
      $('.eventsBar ul').slimScroll({
          allowPageScroll: 'false' ,
		  height : 700,
      });

    });
	

function tooltipshow (obj){
$(obj).children(".custom-tooltip").css({"opacity":"1"});
$(obj).children(".custom-tooltip").addClass("slideInRight");

}

function tooltipshide (){
$(".custom-tooltip").css({"opacity":"0"});
$(".custom-tooltip").removeClass("slideInRight");
}


  $(function () {
  //$('.dropdown-menu a').click(function () {
  //var gettext = $(this).text(); 
  //$(".dropdown-toggle span").text(gettext);
  //});
    $('#dataGrid').DataTable({
     "bFilter":false,
	 "bInfo":false,
	 "bSort":false,
	 "bLengthChange":false, 
    });
	
	$('button[type="submit"]').click(function () {
		toastr.options = {
		extendedTimeOut: 1000,
		timeOut: 5000,
		positionClass: 'toast-top-center',
		}
		toastr["success"]("Request has been successfully approved.<br /><br />Thank You!")
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
  
  
  
  function tableDataHide(obj){
  $(obj).parent().parent(".dataTable").animate({"height":"0", "opacity":"0", "top":"0px"}).fadeOut();
  }
  
 $(function(){
 $(".pop-dismiss").click(function(){
 $(this).parent().parent().parent().children(".modal-body").removeClass("popIn");
 $(this).parent().parent().parent(".modal").hide();
 
 });
  });
  
  $(document).ready(function(){
		$('#po-msg').hide();
		$('#add-new').click(function(){
			$('#po-msg').show();
		});
	});

  $('li').each(function(){
      if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
      {
      $(this).addClass('active').siblings().removeClass('active');
      }
   });
  

  function openList (obj){
	  $(obj).next(".open-list").slideToggle();
	  $(obj).toggleClass("opened");

	  if ($(obj).hasClass("closed")) {
	          $(this).children("i.fa-caret-down").hide();
	  		$(this).children("i.fa-caret-right").show();
	              
	   
	      }
	  	
	  	else if ($(obj).hasClass("opened")) {
	          $(this).children("i.fa-caret-down").show();
	  		$(this).children("i.fa-caret-right").hide();
	              
	   
	      }

	  }
  
  
  function showdetailInlineInfo (obj){
  $("#detailInlineInfo").animate({"right":"105%","opacity":"1", "z-index":"999"});
  var getText = $(obj).children("span").text();
  $("#detailInlineInfo .box-title span").text(getText);
  }

  function hidedetailInlineInfo (){
  $("#detailInlineInfo-top").animate({"left":"0%","opacity":"0", "z-index":"-1"});
  $("#detailInlineInfo").animate({"right":"0%","opacity":"0", "z-index":"-1"});
  }

  function showdetailInlineInfoTop (obj){
  $("#detailInlineInfo-top").animate({"left":"105%","opacity":"1", "z-index":"999"});
  var getText = $(obj).children("span").text();
  $("#detailInlineInfo-top .box-title span").text(getText);
  }

  
  var highestBox = 0;
  $('.height-2').each(function(){  
          if($(this).height() > highestBox){  
          highestBox = $(this).height();  
  }
  });    
  $('.height-2').height(highestBox);

</script>

<script type="text/javascript">
$(window).on('load', function() { // makes sure the whole site is loaded
$('#status').fadeOut(); // will first fade out the loading animation
$('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
$('body').delay(350).css({'overflow':'visible'});
})

/* Profile Image*/
$('#addPhoto').click(function()
           {               
               $('#uploadImage1').click();
           });
           function readURL(input) {
               if (input.files && input.files[0]) {
                   var reader = new FileReader();

                   var type=input.files[0].type.split('/');
                   if(type[0]!="image"){
                       alert("Only Image can be uploaded");
                       $('input[type=file]').val('');
                   }else if(input.files[0].size>1000000){
                       alert('Image should be less than 100 kb ');
                       $('#uploadImage1').val('');
                   }else{
                       reader.onload = function (e) {
                           $('#image').attr('src', e.target.result);
                       }

                       reader.readAsDataURL(input.files[0]);
                   }
               }
           }

</script>


</body>
</html>