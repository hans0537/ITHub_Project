<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${contextPath }/resources/css/jquery.range.css">
<script type="text/javascript">

	function deleteAction(j) {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check) return;
		
		location.href='${contextPath}/qna/qnaDelete?mqnaSeq=' + j;
	}
</script>	
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
					<!-- ************************************************ 메인 QnA 시작 ************************************************** -->
							</div>
							<div class="col-lg-9 col-md-12">
								<div class="main-ws-sec">
									<div class="post-topbar">
										<div class="user-picy">
											<img style="width: 35px; height: 35px; object-fit: cover; " src="${contextPath }/resources/upload/${dto.mPic}" alt="">
										</div>
										<div class="post-st">
											<ul>
												<li><a class="" href="${contextPath }/qna/qnaWriteForm" title="">QnA 작성</a></li>
											</ul>
										</div><!--post-st end-->
									</div><!--post-topbar end-->
									
									<div class="post-bar" align="center" style="font-size: 20px; font-weight: bold;">
										내 QnA 목록
									</div>
									<div class="posts-section">
										<c:choose>
											<c:when test="${empty mqlist }">
												<div class="post-bar">
													<div align="center">QnA 내역이 없습니다.</div>
												</div>
											</c:when>
											<c:otherwise>
												<c:forEach var = "mqdto" items = "${mqlist}">
															<c:if test="${mqdto.mSeq == dto.mSeq }">
													<div class="post-bar">
														<div class="post_topbar">
															<div class="usy-dt">
																<div class="usy-name">
																	<h3>${mqdto.mqnaTitle}</h3>
																	<span>${mqdto.mqnaState == 0? '답변대기중':'답변완료'}</span>
																</div>
															</div>
															
																<div class="ed-opts">
																	<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
																	<ul class="ed-options">
																		<li><a href="${contextPath}/qna/qnaUpdateForm?mqnaSeq=${mqdto.mqnaSeq}" title="">수정</a></li>
																		<li><a style="cursor: pointer;" onclick="deleteAction(${mqdto.mqnaSeq})" title="">삭제</a></li>
																	</ul>
																</div>
														</div>
											
														<!-- QnA 게시물 제목 -->
														<div class="job_descp">
															<p>${mqdto.scTitle}</p>
														</div>
											
														<div class="job-status-bar">
															<ul class="like-com">
																<li>
																	<a href="#"><i class="fas fa-heart"></i> Like</a>
																	<img src="${contextPath }/resources/images/liked-img.png" alt="">
																	<span>25</span>
																</li> 
																<li><a href="#" class="com"><i class="fas fa-comment-alt"></i> Comment 15</a></li>
															</ul>
															<a href="#"><i class="fas fa-eye"></i>Views 50</a>
														</div>
													</div><!--post-bar end-->
															</c:if>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</div>
								<div align="center">
										<c:if test="${paging.prev }">
											<a href="${contextPath }/qna/qnaCenter?page=${paging.begin - 1}&type=${param.type}&word=${param.word}">[이전]</a>	<!-- 검색 했을 때 타입, 입력값 넘어감 -->
										</c:if>
										<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
											<c:choose>
												<c:when test="${i == paging.page }">
													<strong>[${i }]</strong>
												</c:when>
												<c:otherwise>
													<a href="${contextPath }/qna/qnaCenter?page=${i}&type=${param.type}&word=${param.word}">[${i }]</a>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:if test="${paging.next }">
											<a href="${contextPath }/qna/qnaCenter?page=${paging.end + 1}&type=${param.type}&word=${param.word}">[다음]</a>
										</c:if>
								</div>

	<!-- ************************************************ 메인 QnA 끝 ************************************************** -->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
			</div>
		</main>
	</div>

<script type="text/javascript" src="${contextPath }/resources/js/jquery.range-min.js"></script>
<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>