<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<c:set var="check" value="0"/>
	<link rel="stylesheet" type="text/css" href="css/flatpickr.min.css">
	
<script>
function deleteAction(i) {

	var check = confirm("(관리자용) 해당 회원을 삭제 하시겠습니까?");

	if(!check) return;
	
	location.href='${contextPath }/admin/userDelete?mSeq=' + i;
}
</script>
</head>
<body>	
	<div class="wrapper">
	<%@ include file="/WEB-INF/views/layout/adminNav.jsp" %>


		<section class="companies-info">
			<div class="container">
				<div class="company-title">
					<h3>회원 리스트</h3>
				</div><!--company-title end-->
				<div class="companies-list">
					<div class="row">
					
						<c:forEach var="list" items="${list }">
								<div class="col-lg-3 col-md-4 col-sm-6">
									<div class="company_profile_info">
										<div class="company-up-info">
											<c:choose>
												<c:when test="${list.mPic == null }">
													<img height="100px" width="100px" src="${contextPath}/resources/images/resources/cover-img.jpg" alt="">
												</c:when>
												<c:otherwise>
													<img height="100px" width="100px" src="${contextPath }/resources/upload/${list.mPic}" alt="어디갔노">
												</c:otherwise>
											</c:choose>
										
											<h3>${list.mLastname }${list.mFirstname }</h3>
											
											<c:choose>
												<c:when test="${list.mIntro == null || list.mIntro == '' }">
													<h4> - </h4>
												</c:when>
												<c:otherwise>
													<h4>${list.mIntro}</h4>
												</c:otherwise>
											</c:choose>
											
											<ul>
												<li><a onclick="deleteAction(${list.mSeq})" title="" class="message-us">회원 삭제하기</a></li>
											</ul>
										</div>
										<a href="${contextPath }/admin/adminUserProfile?otherSeq=${list.mSeq}" class="view-more-pro">View Profile</a>
									</div><!--company_profile_info end-->
								</div>
						</c:forEach>
					</div>
				</div><!--companies-list end-->
				
				
			</div>
		
		
		
		</section><!--companies-info end-->
		<footer>
			<div class="footy-sec mn no-margin">
				<div class="container">
					<ul>
						<li><a href="help-center.html" title="">Help Center</a></li>
						<li><a href="about.html" title="">About</a></li>
						<li><a href="#" title="">Privacy Policy</a></li>
						<li><a href="#" title="">Community Guidelines</a></li>
						<li><a href="#" title="">Cookies Policy</a></li>
						<li><a href="#" title="">Career</a></li>
						<li><a href="forum.html" title="">Forum</a></li>
						<li><a href="#" title="">Language</a></li>
						<li><a href="#" title="">Copyright Policy</a></li>
					</ul>
					<p><img src="images/copy-icon2.png" alt="">Copyright 2019</p>
					<img class="fl-rgt" src="images/logo2.png" alt="">
				</div>
			</div>
		</footer>

	</div><!--theme-layout end-->


	<script type="text/javascript" src="${contextPath }/resources/js/flatpickr.min.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>