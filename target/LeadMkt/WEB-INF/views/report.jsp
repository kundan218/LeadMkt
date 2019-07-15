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
<body class="skin-black user-body">
<div class="wrapper">


   <sec:authorize access="hasAnyRole('DISTRIBUTOR')">
   <%@include file="./common/header.jsp"%>
   </sec:authorize>
    <sec:authorize access="hasAnyRole('ADMIN','SALES_MARKETING','ASM','SBU','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM','NWM')">
     <%@include file="./common/admin-header.jsp"%>
     </sec:authorize>
  <div class="content-wrapper content-wrapper-inner">
   	 
     <div class="box-header">
     	<div class="container-fluid">        
            <div class="row">                 
                <div class="col-md-8">
                    <div class="header-icon pull-left">
                        <i class="fa fa-file-text-o"></i>
                    </div>
                    <div class="page-heading pull-left">    	                
	                    <h5 class="no-margin">View Your all</h5>
                        <h4>Reports Summary</h4>
                    </div>
                </div>
            </div>
        </div>
     </div>
   
    
    
    <section class="col-md-12 content" style="padding-top:0">
    
   <br><br>
    
    <div class="box no-border">
      <div class="box-body no-padding">
       	<div class="container">
       	<sec:authorize access="hasAnyRole('DISTRIBUTOR','SALES_MARKETING','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM')">  
        <div class="col-md-4 col-sm-3 col-xs-6">
            <div class="report-box text-center black">
                <a href="purchase-order-report"><i class="fa fa-file-pdf-o"></i>
                <small>Display <br>
Requisition Order</small></a>
            </div>
        </div>
        </sec:authorize>
        <sec:authorize access="hasAnyRole('DISTRIBUTOR','SALES_MARKETING','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM')">
        <div class="col-md-4 col-sm-3 col-xs-6">
            <div class="report-box text-center green">
                <a href="my-sales-report"><i class="fa fa-bar-chart-o"></i>
                <small>My <br>
Sales/Dispatch</small></a>
            </div>
        </div>
        </sec:authorize>
      <sec:authorize access="hasAnyRole('DISTRIBUTOR','SALES_MARKETING','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM')">    
        <div class="col-md-4 col-sm-3 col-xs-6">
            <div class="report-box text-center blue">
                <a href="distributor-stock-report"><i class="fa fa-cubes"></i>
                <small>My Stock</small></a>
            </div>
        </div>
    </sec:authorize>    
       <!--  <div class="col-md-3 col-sm-3 col-xs-6 custom-grid-5">
            <div class="report-box text-center orange">
                <a href="dealer-stock-report.html"><i class="fa fa-users"></i>
                <small>Dealer's Stock</small></a>
            </div>
        </div> -->
        
       <!--  <div class="col-md-3 col-sm-3 col-xs-6 custom-grid-5">
            <div class="report-box text-center red">
                <a href="ready-order-jspl.html"><i class="fa fa-check-square-o"></i>
                <small>Ready Orders <br>
with JSPL</small></a>
            </div>
        </div> -->
          <sec:authorize access="hasAnyRole('DISTRIBUTOR','SALES_MARKETING','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM')">
        <div class="col-md-4 col-sm-3 col-xs-6">
            <div class="report-box text-center yellow">
                <a href="dealer-report"><i class="fa fa-list"></i>
                <small>My <br>
Dealer's List</small></a>
            </div>
        </div>
   </sec:authorize>     
       <!--  <div class="col-md-3 col-sm-3 col-xs-6 custom-grid-5">
            <div class="report-box text-center purple">
                <a href="myorder-tracking.html"><i class="fa fa-map-marker"></i>
                <small>My Order <br>
Tracking</small></a>
            </div>
        </div> -->
        
      <!--   <div class="col-md-3 col-sm-3 col-xs-6 custom-grid-5">
            <div class="report-box text-center red">
                <a href="material-price-inquiry.html"><i class="fa fa-rupee"></i>
                <small>Material <br>
Price Inquiry</small></a>
            </div>
        </div> -->
        
        
           <sec:authorize access="hasAnyRole('DISTRIBUTOR','SALES_MARKETING','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM')">
        <div class="col-md-4 col-sm-3 col-xs-6">
            <div class="report-box text-center red">
                <a href="my-goods-receipt"><i class="fa fa-file-text-o"></i>
                <small>My Goods <br>
Receipt Report</small></a>
            </div>
        </div>
       </sec:authorize> 
        <sec:authorize access="hasAnyRole('DISTRIBUTOR','SALES_MARKETING','REGIONAL_MANAGER','STOCKYARD_MANAGER','ZSM')">
        <div class="col-md-4 col-sm-3 col-xs-6">
            <div class="report-box text-center blue">
                <a href="my-total-dispatch-goods"><i class="fa fa-shopping-bag"></i>
                <small>My Total Dispatch From JSPL</small></a>
            </div>
        </div>
      </sec:authorize>
       <sec:authorize access="hasAnyRole('ADMIN','SBU','ASM','NWM')">
        <div class="col-md-4 col-sm-3 col-xs-4">
            <div class="report-box text-center blue">
                <a href="mis"><i class="fa fa-shopping-bag"></i>
                <small>MIS (Summary)</small></a>
            </div>
        </div>
        
        <div class="col-md-4 col-sm-3 col-xs-4">
            <div class="report-box text-center blue">
                <a href="misDetail"><i class="fa fa-shopping-bag"></i>
                <small>MIS (Details) Opening/Closing Balance</small></a>
            </div>
        </div>
        <div class="col-md-4 col-sm-3 col-xs-4">
            <div class="report-box text-center blue">
                <a href="action-stock"><i class="fa fa-shopping-bag"></i>
                <small>Inventory Norms Report</small></a>
            </div>
        </div>
      </sec:authorize>
     	</div>
      </div>
      </div>
      
     
    </section>
    
    
    <div class="clearfix"></div>
  </div>
  <footer class="main-footer"> <strong>Copyright &copy; 2017-2018 <a href="#">Jindal Steel and Power</a>.</strong> All rights reserved. </footer>
</div>


 





<script src="js/jQuery-2.1.3.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="plugins/chart/Chart.bundle.js"></script>
<script src="plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
<script src="plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
<script src="plugins/toast/toastr.min.js"></script>
<script src="js/moment-with-locales.js"></script> 
<script src="js/bootstrap-datetimepicker.js"></script> 

<script type="text/javascript" src="plugins/slimScroll/jquery.slimscroll.js"></script>
<script src="js/app.min.js" type="text/javascript"></script>
<script>
$(function(){ 
      $('.eventsBar ul').slimScroll({
          allowPageScroll: 'false' ,
		  height : 700,
      });

    });
	
	$(document).ready(function(){
		$('#po-msg').hide();
		$('#add-new').click(function(){
			$('#po-msg').show();
		});
	});
	
$('#po-req').modal({backdrop: 'static', keyboard: false, show: false})

  
    $(function () {
   
    $('#dataGrid').DataTable({
     "bSort":false,
    });

	
	
	$('#create-PO').click(function () {
		toastr.options = {
		extendedTimeOut: 1000,
		timeOut: 5000,
		positionClass: 'toast-top-center',
		}
		toastr["success"]("Request No 45000079 is Created.<br /><br />Thank You!")
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
