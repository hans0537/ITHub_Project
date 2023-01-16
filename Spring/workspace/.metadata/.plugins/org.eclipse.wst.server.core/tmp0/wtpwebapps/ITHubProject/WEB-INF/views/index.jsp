<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(f) {
		if(f.mEmail.value == ""){
			alert("Email을 입력하십시오!");
			f.mEmail.focus();
			return false;
		}else if(f.mPw.value == ""){
			alert("PW를 입력하십시오!");
			f.mPw.focus();
			return false;
		}else {
			let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
			
			if (!regex.test(f.mEmail.value)) {
				alert("이메일을 똑바로 입력하세요.");
				f.mEmail.focus();
				return false;
			}
		return true;
		}
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
										<a href="" title="">Sign in</a>
									</li>				
									<li data-tab="tab-2">
										<a href="${contextPath }/member/joinForm" title="">Sign up</a>
									</li>				
								</ul>			
								<div class="sign_in_sec current" id="tab-1">
									
									<h3>Sign in</h3>
									<form action="${contextPath}/login/checkLogin" method="post" onsubmit="return check(this)">
										<div class="row">
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="text" name="mEmail" placeholder="Useremail">
													<i class="la la-user"></i>
												</div><!--sn-field end-->
											</div>
											<div class="col-lg-12 no-pdd">
												<div class="sn-field">
													<input type="password" name="mPw" placeholder="Password">
													<i class="la la-lock"></i>
												</div>
											</div>
											<div class="col-lg-12 no-pdd">
											
											
												<div class="checky-sec">
													<div class="fgt-sec">
														<c:choose>
															<c:when test="${check}">
																<input type="checkbox" id="c1" name="ckid" value="true" checked="checked">
															</c:when>
															<c:otherwise>
																<input type="checkbox" id="c1" name="ckid" value="true">
															</c:otherwise>
														</c:choose>
														<label for="c1">
															<span></span>
														</label>
														<small>Remember me</small>
													</div><!--fgt-sec end-->
													
													
													<a href="${contextPath }/member/findForm?mode=email" title="">Forgot Email?</a>
													<a href="${contextPath }/member/findForm?mode=pw" title="">Forgot Password?</a>
													
												</div>
											</div>
											<div class="col-lg-12 no-pdd">
												<button type="submit" value="submit">Sign in</button>
											</div>
										</div>
									</form>
									<div class="login-resources">
										<h4>Login Via Social Account</h4>
										<ul>
											<li><a href="#" title="" class="fb"><i class="fa fa-facebook"></i>Login Via Facebook</a></li>
											<li><a href="#" title="" class="tw"><i class="fa fa-twitter"></i>Login Via Twitter</a></li>
										</ul>
									</div><!--login-resources end-->
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

	


