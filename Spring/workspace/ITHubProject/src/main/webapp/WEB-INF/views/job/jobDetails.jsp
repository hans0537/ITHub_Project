<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">
<script type="text/javascript">
function back(){
	
	alert("뒤로~~")
	location.href='javascript:history.back();';
}
function toJobApply(f){
	alert("지원하러 ㄱㄱ!")
	location.href = '${contextPath}/job/applyForm?jpostSeq=' + f;
}
</script>	
	
</head>
<body>
<div class="wrapper">	
		<%@ include file="/WEB-INF/views/layout/navbar.jsp" %>
		<section class="profile-account-setting">
			<div class="container">
				<div class="account-tabs-setting">
					<div class="row">
						<div class="col-lg-12">
							<div class="tab-content" id="nav-tabContent">
							  	<div class="tab-pane fade active show" id="nav-deactivate" role="tabpanel" aria-labelledby="nav-deactivate-tab">
							  		<div class="acc-setting">
										<h3>채용 공고</h3>
										<form>
											<div class="cp-field">
												<span style="float: left; font-size: 50px; font-weight: bold;">${jdto.pName }</span>
												<img style="float: right; border: 1px solid black;" height="100px" width="150px" src="${contextPath}/resources/upload/${jdto.pPic}"	alt="">
											</div>
									
											<div class="cp-field">
												<h5>채용 공고 제목</h5>
												<div class="cpp-fiel">
													<span>${jdto.jpostName }</span>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>채용 형태</h5>
												<div class="cpp-fiel">
													<span> ${jdto.etypeName}</span>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>공고 내용</h5>
												<div class="cpp-fiel">
													<textarea id="jexplain" name="jpostExplain">${jdto.jpostExplain }</textarea>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>고용 형태</h5>
												<div class="cpp-fiel">
													<span> ${jdto.wtypeName}</span>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>산업 형태</h5>
												<div class="cpp-fiel">
													<span> ${jdto.iName}</span>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>직업 형태</h5>
												<div class="cpp-fiel">
													<span> ${jdto.occName}</span>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>포지션 형태</h5>
												<div class="cpp-fiel">
													<span> ${jdto.posName}</span>
												</div>
											</div>

											<div class="cp-field">
												<h5>직급 형태</h5>
												<div class="cpp-fiel">
													<span> ${jdto.jrankName}</span>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>채용 인원</h5>
												<div class="cpp-fiel">
													<span> ${jdto.jpostCnt}명</span>
												</div>
											</div>
											
											<c:choose>
												<c:when test="${check == null }">
													<div class="save-stngs pd3">
														<ul>
															<li><button type="button" onclick = "toJobApply(${jdto.jpostSeq})">지원하기</button></li>
															
															<li><button type="button" onclick = "back()">뒤로가기</button></li>
														</ul>
													</div><!--save-stngs end-->
												</c:when>
												<c:otherwise>
													<div class="save-stngs pd3">
														<ul>
															<li><button type="button" onclick = "back()">뒤로가기</button></li>
														</ul>
													</div><!--save-stngs end-->
												</c:otherwise>
											</c:choose>
										</form>
									</div><!--acc-setting end-->
							  	</div>
							</div>
						</div>
					</div>
				</div><!--account-tabs-setting end-->
			</div>
		</section>
	</div>
<script type="text/javascript" src="${contextPath }/resources/js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>