<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(f) {
		if(f.adminId.value == ""){
			alert("ID를 입력하십시오!");
			f.adminId.focus();
			return false;
		}else if(f.adminPw.value == ""){
			alert("PW를 입력하십시오!");
			f.adminPw.focus();
			return false;
		}
		return true;
	}
</script>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>
</head>
<body class="sign-in">
	<div class="wrapper">		
		<div class="sign-in-page">
			<div class="signin-popup">
				<div class="signin-pop">
					<div class="row">
						<div class="col-lg-6">
							<div class="cmp-info">
								<div class="cm-logo">
									<img src="${contextPath}/resources/images/ithubLogo.png" alt="">
									<p>ITHub info</p>
								</div><!--cm-logo end-->	
								<img src="${contextPath}/resources/images/cm-main-img.png" alt="">			
							</div><!--cmp-info end-->
						</div>
						
						<div class="col-lg-6">
							<div class="login-sec">
								<ul class="sign-control">
									<li data-tab="tab-1" class="current">
										<a href="" title="">관리자 로그인</a>
									</li>				
									<li data-tab="tab-2">
										<a href="${contextPath }/" title="">일반 로그인</a>
									</li>				
								</ul>			
								<div class="sign_in_sec current" id="tab-1">
									
									<h3>관리자 로그인</h3>
									<form action="${contextPath}/admin/checkLogin" method="post" onsubmit="return check(this)">
										<div class="row">
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="text" name="adminId" placeholder="UserId">
													<i class="la la-user"></i>
												</div><!--sn-field end-->
											</div>
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="password" name="adminPw" placeholder="Password">
													<i class="la la-lock"></i>
												</div>
											</div>
											<div class="col-lg-12 no-pdd" >
												<button type="submit" value="submit">Sign in</button>
											</div>
										</div>
									</form>
								</div><!--sign_in_sec end-->
							</div><!--login-sec end-->
						</div>
					</div>		
				</div><!--signin-pop end-->
			</div><!--signin-popup end-->
			
			<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
		
		</div><!--sign-in-page end-->


	</div><!--theme-layout end-->
	
<script type="text/javascript" src="${contextPath}/resources/lib/slick/slick.min.js"></script>
	
<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>

	


