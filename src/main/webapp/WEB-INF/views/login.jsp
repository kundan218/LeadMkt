<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>CRM</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
<!-- Bootstrap 3.3.2 -->
 <link rel="shortcut icon" href="${pageContext.request.contextPath}/include/img/favicon.ico">
<link href="${pageContext.request.contextPath}/include/css/bootstrapv3.3.5.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/fonts/ionicons-1.5.2/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/fonts/icon-font/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/fonts/open-sans/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/include/plugins/toast/toastr.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/include/plugins/select/bootstrap-select.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/include/css/animate.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/include/css/custom.css" rel="stylesheet" type="text/css" />
<style>

body{
	background: url(${pageContext.request.contextPath}/include/img/login-page.gif) 0 -100px / 100% no-repeat,linear-gradient(to right, #39bdcd, #00a2d1 48%, #005872) !important;
	background-size: 100%, auto;
	
}
.wrapper { background-color:transparent !important;}

	
</style>


</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body class="skin-black user-body">
<header class="login-header">
<div class="row">
<div class="col-md-3">
<img src="${pageContext.request.contextPath}/include/img/logo-JSPL-panther.png" height="60"/>
</div>

<div class="col-md-6">
<h1 class="no-margin text-white login-heading text-center">Jindal Customer Relationship Management</h1>
</div>

<div class="col-md-3">
<a href="#" ><i data-toggle="tooltip" data-placement="bottom" data-title="Download User Manual"><img src="${pageContext.request.contextPath}/include/img/download-icon.png" /></i></a>
</div>
</div>
</header>

  <c:url var="loginUrl" value="/login" />
  <form class="login-form" action="${loginUrl}" method="post" class="login-content" id="loginFormId">
  <h3 class="text-center">Login in to portal</h3>
  <c:if test="${param.error!=null}">
					<div id="danger-alert" class="alert alert-danger w-100 d-block" style="left:20%; top:18%;">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div id="success-alert" class="alert alert-success w-100 d-block" style="left:20%; top:18%;">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
  <br />
<br />
  <div class="form-group">
 	<input type="text" class="form-control" placeholder="Username" id="username" name="username" />
  </div>
  <br />
  <div class="form-group">
 	<input type="password" class="form-control" placeholder="password" id="password" name="password" />
	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
  </div>
  <br />
  <div class="form-group text-center">
 <!-- <button  type="submit" style="background:none; border: none;"><img src="${pageContext.request.contextPath}/include/img/login-img.jpg" /></button>-->
<button type="submit" class="btn btn-info btn-lg">Login</button>  

</div>
  <div class="form-group">
  <a href="#forgotModal" data-toggle="modal" class="text-white text-center d-block">Forgot Password?</a> 
   </div>
   
   <div class="form-group">
   <br>

  
   </div>
  </form>
  <%--   <div class="login-box-body" id="forgot-pass-box" style="display:none; padding:0px">
          <div class="box-header no-bg" style="padding: 12px 10px;">
            <h3 class="no-margin" style="font-weight:500">Forgot Password</h3>
          </div> 
          <form role="form" id="forgetPasswordId" action="" method="post" onsubmit="return false">
				 
                <div class="form-group">
                <input type="text" name="email" placeholder="Enter Your Valid Email Id" class="form-control" id="userEmailId" required>
                </div>
               
                   
                   <div class="form-group no-margin"> <button onclick="getNewPassword()"  type="submit" class="btn btn-primary">Submit</button> <a href="#" class="btn-back">Back to login</a></div>
                 
                
              </form>
          
          </div> --%>
<%-- <c:url var="loginUrl" value="/login" />
<form action="${loginUrl}" method="post" class="login-form" id="loginFormId">
  <h4 class="text-white no-margin-top margin-bottom">Login in to portal</h4>
  <c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
                <div class="form-group">
                <input type="text" class="form-control validate" id="username" name="username" placeholder="Username / Email / Mobile No." required>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control validate" id="password" name="password" placeholder="Enter Password" required>
                  </div>
                   <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
  <br>

  <div class="form-group">
   <button  type="submit" class="btn btn-primary">Login</button></div>
  <!-- <a href="#" class="btn btn-default login-btn btn-lg rounded-corner" onClick="login()">Login <big style="vertical-align:middle;"><i class="fa fa-angle-right"></i></big></a> 
   </div> -->
   <div class="form-group">
  <a href="#" class="text-white">Forgot Password?</a> 
   </div>
   
   <div class="form-group">
   <br>

  
   </div>
  </form> --%>
 <%-- <c:url var="loginUrl" value="/login" />
          <form action="${loginUrl}" method="post" class="login-content" id="loginFormId">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Invalid username and password.</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>You have been logged out successfully.</p>
					</div>
				</c:if>
                <div class="form-group">
                <input type="text" class="form-control validate" id="username" name="username" placeholder="Username / Email / Mobile No." required>
                </div>
                <div class="form-group">
                  <input type="password" class="form-control validate" id="password" name="password" placeholder="Enter Password" required>
                  </div>
                   <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                   
                   <div class="form-group no-margin"> <button  type="submit" class="btn btn-primary">Login</button></div>
                 
                
              </form> --%>
<footer class="no-border main-footer no-margin  text-center no-bg no-shadow hidden-xs" style="position:fixed; bottom:0; left:0; width:100%;">
Copyright &copy; 2017-2018 Jindal Steel and Power. All rights reserved.
 


</footer>

<%@include file="./common/jsInclude.jsp"%>

<div id="forgotModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header bg-warning">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Forgot Password</h4>
      </div>
      <div class="modal-body">
      <h4 class="text-danger">Type your email id for the password</h4>
        <input type="text" class="form-control" style="height:50px;" id="userEmailId" placeholder="xyz@company.com"/>
      </div>
      <div class="modal-footer text-center">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" onclick="getNewPassword()" class="btn btn-primary" data-dismiss="modal">Submit</button>
        
      </div>
    </div>

  </div>
</div>
<script>

$(document).ready (function(){
    //$("#").hide();
        setTimeout(function () { 
                    $("#danger-alert").hide('close'); }, 3000); 
            });
            
$(document).ready (function(){
    //$("#").hide();
        setTimeout(function () { 
                    $("#success-alert").hide('close'); }, 3000); 
            });
            
       

function getNewPassword(){
	 var email= $("#userEmailId").val();

	 $.ajax({
		    type: 'POST',
	        url:  '${pageContext.request.contextPath}/forgetPassword',
	       
	        data: {email:email},
	        success: function(result) {
	        	
	        	
	        	/* if(result!=""){ */
	        		toastr["success"]("<b>Password has been send to mail Successfully.<b/><br />Thank You!")
	        	/* }else
	        		{
	        		toastr["error"]("User not exits.<br /><br />Thank You!")
	        		} */
	        	
	        	
	        }
		}); 
}
</script>



<script>
function showChat (obj){
$(obj).hide();
$(".chat-window").addClass("chat-Open").css({"z-index":"999"});
$(".icon-close").show();
$(".chat-window").addClass("rotateInUpRight");
$(".chat-window").removeClass("rotateOutDownRight");


}

function hideChat(obj){
$(obj).hide();
$(".chat-window").removeClass("chat-Open");
$(".chat-window").addClass("rotateOutDownRight");
$(".chat-window").removeClass("rotateInUpRight");
$(".icon-open").show();
setTimeout(function(){ 
$(".chat-window").css({"z-index":"-1"}); 
}, 1000);

}


function login()

{
if(txtuser.value=='aso'){window.location.href="Aso/home.html"}
else if(txtuser.value=='rsm'){window.location.href="RM/home.html"}
else if(txtuser.value=='executive'){window.location.href="executive/home.html"}
else if(txtuser.value=='admin'){window.location.href="Admin/home.html"}
else if(txtuser.value=='salesmanager'){window.location.href="sales-manager/home.html"}
else if(txtuser.value=='stockmanager'){window.location.href="stockyard/home.html"}
else if(txtuser.value=='executive'){window.location.href="admin/home.html"}
else if(txtuser.value=='dms'){window.location.href="dms/dashboard.html"}
else{alert("Please use admin / front-desk admin as username to login. This is for demo purpose only")}
}
</script>
</body>
</html>
