<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/flatpickr.min.css">
	
<script>
function deleteAction(i,j) {

	var check = null;

	if(j == 1) {
		check = confirm("(관리자용) 해당 학교 페이지를 삭제 하시겠습니까?");
	}else{
		check = confirm("(관리자용) 해당 회사 페이지를 삭제 하시겠습니까?");
	}
	
	if(!check) return;
	
	location.href='${contextPath }/admin/pageDelete?pSeq=' + i + '&pType=' + j;
}
</script>
</head>
<body>	
	<div class="wrapper">
	<%@ include file="/WEB-INF/views/layout/adminNav.jsp" %>
		<section class="companies-info">
			<div class="container">
				<div class="company-title">
					<c:choose>
						<c:when test="${pType == 0 }">
							<h3>회사 페이지 리스트</h3>
						</c:when>
						<c:otherwise>
							<h3>학교 페이지 리스트</h3>
						</c:otherwise>
					</c:choose>
				</div><!--company-title end-->
				<div class="companies-list">
					<div class="row">
						<c:forEach var="list" items="${list }">
							<div class="col-lg-3 col-md-4 col-sm-6">
								<div class="company_profile_info">
									<div class="company-up-info">
										<img src="${contextPath }/resources/upload/${list.pPic}" alt="">
										<h3>${list.pName }</h3>
										<c:choose>
											<c:when test="${list.pFounddate == null }">
												<h4>Establish - </h4>
											</c:when>
											<c:otherwise>
												<h4>Establish ${list.pFounddate }</h4>
											</c:otherwise>
										</c:choose>
										<ul>
											<c:set var="check" value="0"/>
											<c:forEach var="v" items="${flist }">
												<c:if test="${v == list.pSeq }">
													<c:set var="check" value="-1"/>
												</c:if>
											</c:forEach>	
														
											<li><a onclick="deleteAction(${list.pSeq},${list.pType})" title="" class="message-us">페이지 삭제</a></li>
										</ul>
									</div>
									<a href="${contextPath }/admin/adminPageProfile?pSeq=${list.pSeq}&pType=${list.pType}" class="view-more-pro">View Profile</a>
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