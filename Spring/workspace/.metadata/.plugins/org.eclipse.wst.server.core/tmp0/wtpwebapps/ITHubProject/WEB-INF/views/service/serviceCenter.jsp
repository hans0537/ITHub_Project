<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="css/jquery.range.css">
</head>
<body>	
	<div class="wrapper">	
	<%@ include file="/WEB-INF/views/layout/navbar.jsp" %>	
		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
					<!-- ******************************************* 사이드 바 시작********************************************************* -->
							<div class="col-lg-3 col-md-12">
								<div class="filter-secs">
									<div class="filter-heading">
										<h3>FAQ 자세히 보기</h3>
									</div><!--filter-heading end-->
									<div class="paddy help-paddy">
									<c:forEach var = "todto" items = "${tolist}">
										<div class="filter-dd">
											<div class="filter-ttl filter--tt2">
												<div class="dropdown">
                                                   <a href="#" class="dropdown-toggle" data-toggle="dropdown">${todto.topicName}</a>
                                                   <div class="dropdown-menu">
                                                       <c:forEach var="scatedto" items="${scatelist}">
	                                                       <a href="#" class="dropdown-item top--1 ">${scatedto.scateName}</a>
                	                                   </c:forEach>
                                                   </div>
                                               </div>
											</div>
										</div>
										</c:forEach>
									</div>
								</div><!--filter-secs end-->
					<!-- ******************************************* 사이드 바 끝********************************************************* -->
					<!-- ************************************************ 메인 FAQ 시작 ************************************************** -->
							</div>
							<div class="col-lg-9 col-md-12">
								<div class="helpforum">
			                     <div class="row">
			                     	<div class="col-lg-9 col-md-12">
			                     		<h3>서비스 QnA</h3>
			                     		<p>FAQ외에 질문은 QnA센터로 오십시오</p>
			                     	</div>
			                     	<div class="col-lg-3 col-md-12">
			                     		<a href="${contextPath}/qna/qnaCenter">QnA 센터</a>
			                     	</div>
			                     </div>
								</div> 
								  <!-- end-helpforum -->
								  <div class="actions">
								  	<div class="actionstitle">
								  	<h3>자주 찾는 토픽</h3>
								  		<hr>
								  	</div>
								  		<div class="actionstext">
								  	<div class="row">
								  		<div class="col-md-6 col-sm-12">
								  			<a href="#">Change or add email address</a>
								  			<a href="#">Reset your password</a>
								  			<a href="#">Close your account</a>
								  		</div>
								  		<div class="col-md-6 col-sm-12">
								  			<a href="#">Manage emails you get from Workwise</a>
								  			<a href="#">Get Paid</a>
								  			<a href="#">Build Your Profiles</a>
								  		</div>
								  	</div>
								  	</div>
								  </div>
								  <div class="actions">
								  	<div class="actionstitle">
								  	<h3>다양한 토픽</h3>
								  		<hr>
								  	</div>
								  		<div class="actionstext">
								  	<div class="row">
								  		<div class="col-12">
								  			<a href="#">Workwise Homepage - FAQ</a>
								  			<hr>
								  			<a href="#">Workwise Public Profile Visibility</a>
								  			<hr>
								  			<a href="#">Editing Your Profile</a>
								  			<hr>
								  			<a href="#">Merging or Closing Duplicate Accounts on LinkedIn</a>
								  			<hr>
								  		</div>
								  	</div>
								  	</div>
								  </div>
	<!-- ************************************************ 메인 FAQ 끝 ************************************************** -->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>
	</div>

<script type="text/javascript" src="${contextPath }/resources/js/jquery.range-min.js"></script>
<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>