  
   <header>
		<div class="container-fluid pad">
        	<div class="col-sm-3 col-xs-6 head-logo">
            <a href="dashboard"><img src="${pageContext.request.contextPath}/include/img/jspl-w.png" height="43"/></a>
            </div>
            <div class="col-xs-6 text-center hidden-xs">
            	
            </div>
            <div class="col-sm-3 col-xs-6 text-center">
            	<ul class="top-left">
                <%-- 	<li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-lock"></i></a></li>
                	<li><strong> ${sessionScope.userFullName}</strong></li>
                    <li class="dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-cog"></i></a>
                        <ul class="dropdown-menu small-menu">
                        	<li class="text-uppercase"><span>Settings</span></li>
                            <li><a href="#" data-target="#changePassword" data-toggle="modal"><i class="fa fa-unlock-alt"></i> <span>Change Password</span></a></li>
                        </ul>
                    </li> --%>
                    
                    <li class="dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-user"></i></a>
                        <ul class="dropdown-menu small-menu">
                        	<li class="text-uppercase"><span><sec:authentication property="principal.name" /></span></li>
                        		<sec:authorize access="hasAnyRole('DISTRIBUTOR')">
                        	<li><a href="#"><i class="fa fa-user"></i> <span>My Profile</span></a></li>
                        	</sec:authorize>
                            <li><a href="#" data-target="#changePassword" data-toggle="modal"><i class="fa fa-unlock-alt"></i> <span>Change Password</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-lock"></i> <span>Logout</span></a></li>
                        </ul>
                    </li>
                  <!--   <li class="dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-plus-square"></i></a>
                        <ul class="dropdown-menu small-menu">
                        	<li class="text-uppercase"><span>Create</span></li>
                            <li><a href="#" data-target="#newUser" data-toggle="modal"><i class="fa fa-user"></i> <span>New User</span></a></li>
                            <li><a href="#" data-target="#addDist" data-toggle="modal"><i class="fa fa-list-alt"></i> <span>Add Description</span></a></li>
                            <li><a href="#" data-target="#newMat" data-toggle="modal"><i class="fa fa-cubes"></i> <span>New Material</span></a></li>
                        </ul>
                    </li>  -->
                </ul>
            </div>       
        </div>
  
	
  <nav class="navbar navbar-default">
      <div class="container-fluid">
      	<div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-custom-menu navbar-custom-inner">
          <ul class="nav navbar-nav">
              <li><a><i class="fa fa-th"></i> <span>DMS</span></a></li>
              <sec:authorize access="hasAnyRole('ADMIN')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
              <li><a href="user"><i class="fa fa-user"></i> <span>Manage User</span></a></li>
              <li><a href="distributor"><i class="fa fa-users"></i> <span>Manage Distributor</span></a></li>
              <li><a href="material"><i class="fa fa-cubes"></i> <span>Manage Material</span></a></li>
         <li><a href="materialPrice"><i class="fa fa-rupee"></i> <span>Manage Price</span></a></li> 
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
                          <li><a href="add-distributor-material"><i class="fa fa-cubes"></i> <span>Add Distributor Material</span></a></li>
            
                  <li class=" dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-shopping-bag"></i> <span>Inventory Management <i class=" fa fa-angle-down"></i></span></a>
                    <ul class="dropdown-menu small-menu">
                         <li><a href="stock-norms"><i class="fa fa-industry"></i> <span>Stock Norms</span></a></li>
                   <li><a href="action-stock"><i class="fa fa-industry"></i> <span>Action Stock</span></a></li>
               <li><a href="update-stock"><i class="fa fa-industry"></i> <span>Update Stock</span></a></li> 
                    </ul>
              </li>
              </sec:authorize>
               <sec:authorize access="hasAnyRole('SALES_MARKETING')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
             <li><a href="${pageContext.request.contextPath}/sales/po-list"><i class="fa fa-file-text-o"></i> <span>Requisition Request</span></a></li>
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
            <!--    <li><a href="receive-delivery"><i class="fa fa-file-text-o"></i> <span>Receive Delivery</span></a></li> -->
              </sec:authorize>
              
              <sec:authorize access="hasAnyRole('REGIONAL_MANAGER')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
             <li><a href="${pageContext.request.contextPath}/rm/po-list"><i class="fa fa-file-text-o"></i> <span>Requisition Request</span></a></li>
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
              </sec:authorize>
              
              <sec:authorize access="hasAnyRole('STOCKYARD_MANAGER')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
              
                  <li class=" dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-shopping-bag"></i> <span>Inventory Management <i class=" fa fa-angle-down"></i></span></a>
                    <ul class="dropdown-menu small-menu">
                         
			              <li><a href="update-stock"><i class="fa fa-industry"></i> <span>Update Stock</span></a></li> 
			             <li><a href="action-stock"><i class="fa fa-industry"></i> <span>Action Stock</span></a></li>
                    </ul>
              </li>
              </sec:authorize>
              <sec:authorize access="hasAnyRole('ZSM')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
               <li class=" dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-shopping-bag"></i> <span>Inventory Management <i class=" fa fa-angle-down"></i></span></a>
                    <ul class="dropdown-menu small-menu">
                         
			             <li><a href="stock-norms"><i class="fa fa-industry"></i> <span>Stock Norms</span></a></li>
			             <li><a href="action-stock"><i class="fa fa-industry"></i> <span>Action Stock</span></a></li>
			             <li><a href="update-stock"><i class="fa fa-industry"></i> <span>Update Stock</span></a></li> 
                    </ul>
              </li>
              </sec:authorize>
              
               <sec:authorize access="hasAnyRole('NWM')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
                  <li class=" dropdown lang-dropDown"><a href="#" class="link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-shopping-bag"></i> <span>Inventory Management <i class=" fa fa-angle-down"></i></span></a>
                    <ul class="dropdown-menu small-menu">
                         
			             <li><a href="stock-norms"><i class="fa fa-industry"></i> <span>Stock Norms</span></a></li>
			             <li><a href="action-stock"><i class="fa fa-industry"></i> <span>Action Stock</span></a></li>
                    </ul>
              </li>
              </sec:authorize>
              
                    <sec:authorize access="hasAnyRole('ASM','SBU')">
              <li class="active"><a href="dashboard"><i class="fa fa-home"></i> <span>Home</span></a></li>
              <li><a href="report"><i class="fa fa-file-text-o"></i> <span>Report</span></a></li>
              </sec:authorize>
              
              
          </ul>
        </div>
      </div>
      
       <div id="changePassword" class="modal fade" role="dialog">
  <div class="modal-dialog animated popIn no-margin"> 
    
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Change Password</h4>
      </div>
       <form id="formId" method="POST" action="${pageContext.request.contextPath}/changePassword">
      <div class="modal-body">
      
     
      <div id="updatePasswordDiv2" style="color:red;display: none">
												Password does not match. <br>
												Please try again.
											</div>
        <div class="row">
        <div style="margin-top: 25px;" class="form-group">
											<input type="hidden" value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}" id="txtuser" class="form-control input-radius" name="username">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										
										</div>
          <div class="col-md-12">
            <div class="form-group">
              <label>New Password</label>
              <input type="password" id="newPassword" placeholder="New Password" name="password" class="form-control input-radius">
            </div>
          </div>
          <div class="col-md-12">
            <div class="form-group">
              <label>Confirm Password</label>
             <input type="password" id="confirmPassword" placeholder="Confirm Password" class="form-control input-radius">
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success" onclick="changePassword()" >Submit</button>
       
      </div>
       </form>
    </div>
  </div>
</div>
    </nav>
    
    </header>
    <script>
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