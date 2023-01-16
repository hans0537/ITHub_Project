<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<c:set var="idx" value="0" />
<c:set var="e" value="" />
<c:set var="f" value="" />
<c:set var="l" value="" />
<c:set var="h" value="" />
<c:if test="${param.idx != null }">
	<c:set var="idx" value="${param.idx }" />
	<c:set var="check" value="true" />
</c:if>
<c:if test="${param.e != null }" >
	<c:set var="e" value="${param.e }"></c:set>
</c:if>
<c:if test="${param.f != null }" >
	<c:set var="f" value="${param.f }"></c:set>
</c:if>
<c:if test="${param.l != null }" >
	<c:set var="l" value="${param.l }"></c:set>
</c:if>
<c:if test="${param.h != null }" >
	<c:set var="h" value="${param.h }"></c:set>
</c:if>




<script type="text/javascript">
	const autoHyphen = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
	}
	
	function change(){
		var countrySelect = document.getElementById("country");
		var e = document.getElementById("mEmail").value;
		var f = document.getElementById("mFirstname").value;
		var l = document.getElementById("mLastname").value;
		var h = document.getElementById("mHp").value;

		var selectValue = countrySelect.options[countrySelect.selectedIndex].value;
		
		location.href="/ithub/member/joinForm?idx=" + selectValue + "&e=" + e + "&f=" + f + "&l=" + l + "&h=" + h;
	}
	
	function check(f) {
		if(f.mEmail.value === ""){
			alert("Email을 입력 하세요!!");
			f.mEmail.focus();
			return false;
		}else if(f.mPw.value === ""){
			alert("PW를 입력 하세요!!");
			f.mPw.focus();
			return false;
		}else if(f.rPw.value === ""){
			alert("비밀번호 체크를 입력 하세요!!");
			f.rPw.focus();
			return false;
		}else if(f.mFirstname.value === ""){
			alert("이름을 입력 하세요!!");
			f.mFirstname.focus();
			return false;
		}else if(f.mLastname.value === ""){
			alert("성 을 입력 하세요!!");
			f.mLastname.focus();
			return false;
		}else if(f.mHp.value === ""){
			alert("전화번호를 입력 하세요!!");
			f.mHp.focus();
			return false;
		}else {
			let emailRegex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
			let hpRegex = new RegExp('01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}');
			
			
			if(f.mPw.value !== f.rPw.value) {
				alert("비밀번호가 일치하지 않습니다.");
				f.rPw.focus();
				return false;
			}else if (!emailRegex.test(f.mEmail.value)) {
				alert("이메일을 똑바로 입력하세요.");
				f.mEmail.focus();
				return false;
			}else if (!hpRegex.test(f.mHp.value)) {
				alert("전화번호를 똑바로 입력하세요.");
				f.mHp.focus();
				return false;
			}else {
				return true;
			}
		}
	}
	
	
</script>
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
									<li data-tab="tab-1" >
										<a href="${contextPath }" title="">Sign in</a>
									</li>				
									<li data-tab="tab-2"class="current">
										<a href="" title="">Sign up</a>
									</li>				
								</ul>			
								
								<div class="sign_in_sec current" id="tab-2">
									<div class="dff-tab current" id="tab-3">
										<form action="${contextPath }/member/join" method="post" onsubmit="return check(this)">
											<div class="row">
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mEmail" id="mEmail" placeholder="Email" value="${e }">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="password" name="mPw" id="mPw" placeholder="Password">
														<i class="la la-lock"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="password" name="rPw" id="rPw" placeholder="Repeat Password">
														<i class="la la-lock"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mFirstname" id="mFirstname" placeholder="First Name" value="${f }">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mLastname" id="mLastname" placeholder="Last Name" value="${l}">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<input type="text" name="mHp" id="mHp" placeholder="hp" oninput="autoHyphen(this)" value="${h }">
														<i class="la la-user"></i>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<select name="cSeq" id="country" onchange="change()">
															<c:choose>
																<c:when test="${check == null}">
																	<c:forEach items="${country}" var="country">
																		<option	value="${country.cSeq }"> ${country.cName }</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${country}" var="country">
																		<option	value="${country.cSeq }" ${country.cSeq == idx ? 'selected' : ''}> ${country.cName }</option>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</select>
														<i class="la la-globe"></i>
														<span><i class="fa fa-ellipsis-h"></i></span>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="sn-field">
														<select name="ciSeq" id="city" >
															<c:choose>
																<c:when test="${check == null}">
																	<c:forEach items="${country.get(idx).getCity()}" var="city">
																		<option value="${city.ciSeq}">${city.ciName }</option>
																	</c:forEach>
																</c:when>
																<c:otherwise>
																	<c:forEach items="${country.get(idx-1).getCity()}" var="city">
																		<option value="${city.ciSeq}">${city.ciName }</option>
																	</c:forEach>
																</c:otherwise>
															</c:choose>
														</select>
														<i class="la la-globe"></i>
														<span><i class="fa fa-ellipsis-h"></i></span>
													</div>
												</div>
												
												<div class="col-lg-12 no-pdd">
													<div class="checky-sec st2">
														<div class="fgt-sec">
															<input type="checkbox" name="cc" id="c2">
															<label for="c2">
																<span></span>
															</label>
															<small>Yes, I understand and agree to the workwise Terms & Conditions.</small>
														</div><!--fgt-sec end-->
													</div>
												</div>
												<div class="col-lg-12 no-pdd">
													<button type="submit" value="submit">Get Started</button>
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

	


