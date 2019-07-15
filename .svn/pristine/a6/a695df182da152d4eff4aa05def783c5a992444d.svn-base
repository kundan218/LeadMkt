<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

  <header class="main-header">
    <div class="container-fluid top-Bar">
      <div class="row">
        <div class="col-md-3 col-sm-3"><a href="dashboard" class="logo"> <img src="${pageContext.request.contextPath}/include/img/jspl-w.png" height="35"/></a> </div>
        <div class="col-md-9 col-sm-9">
          <div class="navbar-custom-menu">
            <ul class="top-left clearfix">
            <li><a href="javascript:void(0)"><i class="fa fa-user no-margin-right"></i> <span class="text-white">Welcome:&nbsp;<sec:authentication property="principal.name" /></span> &nbsp;&nbsp;</a></li>
 <sec:authorize access="hasAnyRole('ADMIN')">
<li class="dropdown">
  <a href="#" class="dropdown-toggle text-white" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Manage Masters <i class="fa fa-caret-down"></i>
  </a>
  <div class="dropdown-menu headerDropDown" aria-labelledby="dropdownMenuButton">    <!-- <a class="dropdown-item d-block" href="manage-location.html">Manage Location</a> -->
<!--     <a class="dropdown-item d-block" href="manage-role.html">Manage Role</a>
    <a class="dropdown-item d-block" href="manage-sbu.html">manage SBU</a> -->
    <a class="dropdown-item d-block" href="user">Manage User</a>
    <a class="dropdown-item d-block" href="material">Manage Material</a>
    <a class="dropdown-item d-block" href="manageSource">Manage Source</a>
</div>
</li>            
</sec:authorize>            
            <li><a href="dashboard"><i class="fa fa-dashboard" title="Dashboard" data-toggle="tooltip" data-placement="bottom"></i></a></li>
            
          
          
          <li class="dropdown lang-dropDown"><a href="leadHistory" class="link dropdown-toggle" aria-expanded="false"><i class="fa fa-history" data-placement="bottom" title="History" data-toggle="tooltip" ></i><!--  <span class="label label-danger notification-counter">1</span> --></a></li>
          
           <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> </a></li>
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
        <div id="navbar" class="navbar-collapse mainNav collapse">
          <ul class="nav navbar-nav" style="width:100%">
              <li class="page-heading"><i class="fa fa-th"></i> <span>CRM</span></li>
              <li class="active"><a href="home.html" onClick="callThisFn()"><i class="fa fa-home"></i></a></li>
              <li><a href="target.html"><i class="fa fa-file-text-o"></i> <span>Target</span></a></li>
              <li><a href="lead.html"><i class="fa fa-file-text-o"></i> <span>Lead</span> <label class="label label-danger">1 New</label></a></li>
              <li><a href="opportunity.html"><i class="fa fa-file-text-o"></i> <span>Opportunity</span></a></li>
              <li><a href="calendar.html"><i class="fa fa-file-text-o"></i> <span>Calendar</span></a></li>
              <li><a href="stock.html"><i class="fa fa-file-text-o"></i> <span>Stock</span></a></li>
              <li><a href="account.html"><i class="fa fa-file-text-o"></i> <span>Accounts</span></a></li>
              <li><a href="reports.html"><i class="fa fa-file-text-o"></i> <span>Reports</span></a></li>
              <li class="pull-right text-muted"><span>Welcome <strong>RM, Delhi</strong></span></li>
          </ul>
        </div>
    </nav>
    </div>
    </div>
  </header>
   
   
   <script type="text/javascript">
	$('li').each(function(){
        if(window.location.href.indexOf($(this).find('a:first').attr('href'))>-1)
        {
        $(this).addClass('active').siblings().removeClass('active');
        }
     });
	
	 function changePassword(){
	var flag=0;
	if($("#newPassword").val()==""){
		$("#newPassword").addClass("error");
		flag=1;
	}else{
		$("#newPassword").removeClass("error");
	}
	if($("#confirmPassword").val()==""){
		$("#confirmPassword").addClass("error");
		flag=1;
	}else{
		$("#confirmPassword").removeClass("error");
	}
	if(flag==0){
	if( $("#newPassword").val()==$("#confirmPassword").val()){
		$("#formId").submit();
	}else{
		$("#updatePasswordDiv2").show();
	}
	}
	
} 
</script>

