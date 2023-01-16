<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
function check(f){
	
	if(f.mode.value == "pw"){
		if(f.mEmail.value == ""){
			alert("이메일을 입력하십시오!");
			f.mEmail.focus();
			return false;
		}
	}
	
	if(f.mFirstname.value == ""){
		alert("이름을 입력하십시오!");
		f.mFirstname.focus();
		return false;
	}
	if(f.mLastname.value == ""){
		alert("성을 입력하십시오!");
		f.mLastname.focus();
		return false;
	}
	if(f.mHp.value == ""){
		alert("전화번호를 입력하십시오!");
		f.mHp.focus();
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
								<div class="sign_in_sec current" id="tab-2">
									<div class="dff-tab current" id="tab-3">
										<form action="${contextPath }/member/find" method="post" onsubmit="return check(this);">
											<div class="row">
											
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<c:choose>
															<c:when test="${param.mode == 'email' }">
																<input type="hidden" name="mode" value="email">
																<h3>Find E-Mail</h3>
															</c:when>
															<c:otherwise>
																<input type="hidden" name="mode" value="pw">					
																<h3>Find Password</h3>
															</c:otherwise>
														</c:choose>	
													</div>
												</div>

												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<c:if test="${param.mode == 'pw' }">
															<input type="text" name="mEmail" value="${param.mEmail }" placeholder="email을 입력하세요">
															<i class="la la-user"></i>
														</c:if>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mFirstname" id="mFirstname" placeholder="First Name">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mLastname" id="mLastname" placeholder="Last Name">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mHp" id="mHp" placeholder="000-0000-0000" value="">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<button type="submit" value="find">FIND</button>
												</div>
											</div>
										</form>
										
									</div><!--dff-tab end-->
								</div>		
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

	


