<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">
</head>

<script>

function check(f) {
	if(f.jpostName.value === ""){
		alert("제목을 입력 하세요!!");
		f.jpostName.focus();
		return false;
	}else if(f.jpostExplain.value === ""){
		alert("공고 내용을 입력 하세요!!");
		f.jpostExplain.focus();
		return false;
	}else if(f.jpostCnt.value === 0){
		alert("채용인원을 입력 하세요");
		f.jpostCnt.focus();
		return false;
	}else {
		return true;
	}
}

</script>
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
										<form action="${contextPath}/job/checkUpdate" method="post" onsubmit="return check(this)">
											<input type="hidden" name="pSeq" value="${jdto.pSeq }" />
											<input type ="hidden" name = "jpostSeq" value = "${jdto.jpostSeq}">
											<div class="cp-field">
												<span style="float: left; font-size: 50px; font-weight: bold;">${jdto.pName }</span>
												<img style="float: right; border: 1px solid black;" height="100px" width="150px" src="${contextPath}/resources/upload/${jdto.pPic}"	alt="">
											</div>
									
											<div class="cp-field">
												<h5>채용 공고 제목</h5>
												<div class="cpp-fiel">
													<input type="text" name="jpostName" value="${jdto.jpostName }">
												</div>
											</div>
											
											<div class="cp-field">
												<h5>채용 형태</h5>
												<div class="cpp-fiel">
													<select name = "etypeSeq" id="etypeSeq">
														<c:forEach var="elist" items="${elist}">
															<option value = "${elist.etypeSeq }" ${jdto.etypeSeq == elist.etypeSeq ? 'selected' : '' }>${elist.etypeName }</option>
														</c:forEach>
													</select>
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
													<select name="wtypeSeq" id="iSeq">
														<c:forEach var="wlist" items="${wlist }">
															<option value="${wlist.wtypeSeq }" ${jdto.wtypeSeq == wlist.wtypeSeq ? 'selected' : ''}> ${wlist.wtypeName } </option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>산업 형태</h5>
												<div class="cpp-fiel">
													<select name="iSeq" id="iSeq">
														<c:forEach var="ilist" items="${ilist }">
															<option value="${ilist.iSeq }" ${jdto.iSeq == ilist.iSeq ? 'selected' : ''}> ${ilist.iName } </option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>직업 형태</h5>
												<div class="cpp-fiel">
													<select name="occSeq" id="iSeq">
														<c:forEach var="olist" items="${olist }">
															<option value="${olist.occSeq }" ${jdto.occSeq == olist.occSeq ? 'selected' : ''}> ${olist.occName } </option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>포지션 형태</h5>
												<div class="cpp-fiel">
													<select name="posSeq" id="iSeq">
														<c:forEach var="plist" items="${plist }">
															<option value="${plist.posSeq }" ${jdto.posSeq == plist.posSeq ? 'selected' : ''}> ${plist.posName } </option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="cp-field">
												<h5>직급 형태</h5>
												<div class="cpp-fiel">
													<select name="jrankSeq" id="iSeq">
														<c:forEach var="jlist" items="${jlist }">
															<option value="${jlist.jrankSeq }" ${jdto.jrankSeq == jlist.jrankSeq ? 'selected' : ''}> ${jlist.jrankName } </option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>채용 인원</h5>
												<div class="cpp-fiel">
													<input type="number" name="jpostCnt" value="${jdto.jpostCnt }">
												</div>
											</div>
											
											<div class="save-stngs pd3">
												<ul>
													<li><button type="submit">채용 공고 수정</button></li>
													<li><button type="reset">초기화</button></li>
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
							  	</div>
							</div>
						</div>
					</div>
				</div><!--account-tabs-setting end-->
			</div>
		</section>
		<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

	</div><!--theme-layout end-->

	
	<script type="text/javascript" src="${contextPath }/resources/js/jquery.mCustomScrollbar.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>