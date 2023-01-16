<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
								<div class="sign_in_sec current" id="tab-2" style="padding-top:200px;">
									<div class="dff-tab current" id="tab-3">
										<div class="row">
											<div class="col-lg-12 no-pdd">
											
												<c:choose>
													<c:when test="${!check}">
														<c:choose>
															<c:when test="${param.mode == 'email' }">
																<h3>아이디를 찾지 못하였습니다.</h3>
																<button type="button" onclick="location.href='${contextPath }/member/findForm?mode=email'" value="find">Find E-Mail</button>
															</c:when>
															<c:otherwise>
																<h3>비밀번호를 찾지 못하였습니다.</h3>
																<button type="button" onclick="location.href='${contextPath }/member/findForm?mode=email'" value="find">Find E-Mail</button>
																<button type="button" onclick="location.href='${contextPath }/member/findForm?mode=pw'" value="find">Find Password</button>															
															</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${param.mode == 'email' }">
																<h3>E-Mail : ${mEmail }</h3>
																<button style="float: right;" type="button" onclick="location.href='${contextPath }/member/findForm?mode=pw&mEmail=${mEmail}'" value="find">Find Password</button>
															</c:when>
															<c:otherwise>
																<h3>PW : ${mPw }</h3>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
												<button type="button" onclick="location.href='${contextPath }'" value="signIn">Sign in</button>
											</div>

										</div>
										
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

	


