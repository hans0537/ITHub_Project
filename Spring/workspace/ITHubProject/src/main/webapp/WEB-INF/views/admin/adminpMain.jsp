<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script>
	function deleteAction(j) {
		var check = confirm("(관리자용) 해당 게시글을 삭제 하시겠습니까?");
		
		if(!check) return;
		
		location.href='${contextPath}/admin/boardDelete?boardSeq=' + j;
	}
	
	function sendName(name,orderno,i){
		$("#bcContent" + i).val("@"+name+" ");
		$("#depthno" + i).val(2);
		$("#orderno" + i).val(orderno);
	}
	
	function novalue(i){
		$("#bcContent" + i).val("");
	}
	
	function focusing(i){
		$("#bcContent" + i).focus();
	}
	
</script>

</head>

    
<body>	
	<div class="wrapper">	
		<header>
	<div class="container">
		<div class="header-data">
			<div class="logo">
				<a href="${contextPath}/adminMain.go" title=""><img src="${contextPath}/resources/images/fabicon.png" alt=""></a>
			</div><!--logo end-->
			<div class="search-bar">
				<form action="${contextPath }/adminMain.go?" method="get" onsubmit="return check(this)">
					<input type="hidden" name="type" value="boardContent">
					<input type="hidden" name="path" value="main">
					<input type="text" name="word" placeholder="검색어를 입력하세요" value="${param.word }" autocomplete="off">
					<button type="submit"><i class="la la-search"></i></button>
				</form>
			</div><!--search-bar end-->
			<nav>
				<ul>
					<li>
						<a href="${contextPath}/adminMain.go" title="">
							<span><img src="${contextPath}/resources/images/icon1.png" alt=""></span>
							Home
						</a>
					</li>
					<li>
						<a href="${contextPath}/page/pageList?pType=0" title="">
							<span><img src="${contextPath}/resources/images/icon2.png" alt=""></span>
							회사 페이지 관리
						</a>
					</li>
					<li>
						<a href="${contextPath}/page/pageList?pType=1" title="">
							<span><img src="${contextPath}/resources/images/icon3.png" alt=""></span>
							학교 페이지 관리
						</a>
					</li>
					<li>
						<a href="${contextPath}/member/userList" title="">
							<span><img src="${contextPath}/resources/images/icon4.png" alt=""></span>
							회원 관리
						</a>
					</li>
					<li>
						<a href="${contextPath}/job/jobList" title="">
							<span><img src="${contextPath}/resources/images/icon5.png" alt=""></span>
							채용공고 관리
						</a>
					</li>
				</ul>
			</nav><!--nav end-->
			<div class="menu-btn">
				<a href="#" title=""><i class="fa fa-bars"></i></a>
			</div><!--menu-btn end-->
			<div class="user-account">
				<div class="user-info">
					<span>${dto.adminName }</span>
					<i class="la la-sort-down"></i>
				</div>
				<div class="user-account-settingss" id="users">
					<h3 class="tc"><a href="${contextPath}/admin/logout" title="">Logout</a></h3>
				</div><!--user-account-settingss end-->
			</div>
		</div><!--header-data end-->
	</div>
</header><!--header end-->	
		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
							<div class="col-lg-3 col-md-4 pd-left-none no-pd">
								<div class="main-left-sidebar no-margin">
									<div class="user-data full-width">
										<div class="user-profile">
											<div class="user-specs">
												<h3>${dto.adminName}</h3>
												<span>${adlist.get(dto.deptSeq-1).deptName }팀</span>
											</div>
										</div><!--user-profile end-->
									</div><!--user-data end-->
									
									
									<div class="tags-sec full-width">
										<ul>
											<li><a href="${contextPath }/service/help" title="">Help Center</a></li>
											<li><a href="#" title="">About</a></li>
											<li><a href="#" title="">Privacy Policy</a></li>
											<li><a href="#" title="">Community Guidelines</a></li>
											<li><a href="#" title="">Cookies Policy</a></li>
											<li><a href="#" title="">Career</a></li>
											<li><a href="#" title="">Language</a></li>
											<li><a href="#" title="">Copyright Policy</a></li>
										</ul>
										<div class="cp-sec">
											<img src="${contextPath }/resources/images/logo2.png" alt="">
											<p><img src="${contextPath }/resources/images/cp.png" alt="">Copyright 2022</p>
										</div>
									</div><!--tags-sec end-->
									
								</div><!--main-left-sidebar end-->
							</div>
							
							<div class="col-lg-6 col-md-8 no-pd">
								<div class="main-ws-sec">
									<div class="post-topbar">
										<div class="user-picy">
											<img style="width: 35px; height: 35px; object-fit: cover; " src="${contextPath }/resources/images/fabicon.png" alt="">
										</div>
										<div class="post-st">
											<ul>
												<li><a class="" href="${contextPath }/adminMain.go" title="">회원 게시글 관리</a></li>
												<li><a class="" href="${contextPath }/admin/adminpMain" title="">페이지 게시글 관리</a></li>
											</ul>
										</div><!--post-st end-->
									</div><!--post-topbar end-->	
									<div class="posts-section">
										<c:choose>
											<c:when test="${empty list2 }">
												<div class="post-bar">
													<div>게시물이 없습니다.</div>
												</div>
											</c:when>
											<c:otherwise>
												<c:forEach var = "blist" items = "${list2}">
													<div class="posty"> 
														<div class="post-bar no-margin">
															<div class="post_topbar">
																<div class="usy-dt">
																	<img style="width: 35px; height: 35px;" src="${contextPath }/resources/upload/${blist.pPic}" alt="">
																	<div class="usy-name">
																		<h3>${blist.pName}</h3>
																		<span><img src="${contextPath }/resources/images/clock.png" alt="">${blist.boardDate }</span>
																	</div>
																</div>
																
																<div class="ed-opts">
																	<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
																	<ul class="ed-options">
																		<li><a style="cursor: pointer;" onclick="deleteAction(${blist.boardSeq})" title="">게시글 삭제</a></li>
																	</ul>
																</div>
															</div>
												
															<!-- 게시물 제목 -->
															<div class="job_descp">
																<p>${blist.boardContent}</p>
															</div>
												
															<div class="job-status-bar">
																<ul class="like-com">
																	<li>
																		<a href="#"><i class="fas fa-heart"></i> Like</a>
																		<img src="${contextPath }/resources/images/liked-img.png" alt="">
																		<span>25</span>
																	</li>
																	<c:set var="v" value="0"/>
																	<c:forEach var="cnt" items="${bcCount}">
																		<c:if test="${cnt.boardSeq == blist.boardSeq }">
																			<c:set var="v" value="${cnt.bcCount }"/>
																		</c:if>
																	</c:forEach> 
																	<li><a style="cursor: pointer;" class="com" id="commentCnt${blist.boardSeq}" onclick="toggleBtn(${blist.boardSeq});focusing(${blist.boardSeq});"><i class="fas fa-comment-alt"></i> Comment ${v}</a></li>
																</ul>
																<a href="#"><i class="fas fa-eye"></i>Views 50</a>
															</div>
														</div><!--post-bar end-->
													
														<div class="comment-section" id="combox${blist.boardSeq }" style="display:none">
															<div id="comment-view" style="height: 500px; overflow-y: scroll;">
																<div class="comment-sec" id="comment-sec">
														
																	<ul id="commentList${blist.boardSeq }">
																		<c:forEach var="bc" items="${bclist}">
																			<c:if test="${bc.groupno == blist.boardSeq}">
																				<c:if test="${bc.depthno == 1 }">
																					<li>
																						<div class="comment-list">
																							<div class="bg-img">
																								<img style="max-width: none;width: 33px;height: 33px;" src="${contextPath }/resources/upload/${bc.mPic}" alt="">
																							</div>
																							<div class="comment">
																								<h3>${bc.mLastname}${bc.mFirstname}</h3>
																								<span><img src="images/clock.png" alt=""> ${bc.bcDate }</span>
																								<p id="newcomment">${bc.bcContent }</p>
																								<a onclick="sendName( '${bc.mLastname}${bc.mFirstname}' ,${bc.orderno },${blist.boardSeq});focusing(${blist.boardSeq});" title="" class="active"><i class="fa fa-reply-all"></i>Reply</a>
																							</div>
																						</div>
																					</li>
																				</c:if>
																				<c:if test="${bc.depthno == 2  }">
																					<ul>
																						<li>
																							<div class="comment-list">
																								<div class="bg-img">
																									<img style="max-width: none;width: 30px;height: 30px;" src="${contextPath }/resources/upload/${bc.mPic}" alt="">
																								</div>
																								<div class="comment">
																									<h3>${bc.mLastname}${bc.mFirstname}</h3>
																									<span><img src="images/clock.png" alt=""> ${bc.bcDate }</span>
																									<p id="newcomment">${bc.bcContent }</p>
																									<a onclick="sendName('${bc.mLastname}${bc.mFirstname}',${bc.orderno },${blist.boardSeq});focusing(${blist.boardSeq});" title="" class="active"><i class="fa fa-reply-all"></i>Reply</a>
																								</div>
																							</div>
																						</li>
																					</ul>
																				</c:if>
																			</c:if>
																		</c:forEach>
																	</ul>
																	
																</div><!--comment-sec end-->
															</div>
														</div><!--comment-section end-->
													
													</div>
													<div>  &nbsp; </div>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
									<!-- 페이징 -->
								<div align="center">
									<c:if test="${paging.prev }">
										<a href="${contextPath }/board/list?page=${paging.begin - 1}&type=${param.type}&word=${param.word}&path=main">[이전]</a>	<!-- 검색 했을 때 타입, 입력값 넘어감 -->
									</c:if>
									<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
										<c:choose>
											<c:when test="${i == paging.page }">
												<strong>[${i }]</strong>
											</c:when>
											<c:otherwise>
												<a href="${contextPath }/board/list?page=${i}&type=${param.type}&word=${param.word}&path=main">[${i }]</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:if test="${paging.next }">
										<a href="${contextPath }/board/list?page=${paging.end + 1}&type=${param.type}&word=${param.word}&path=main">[다음]</a>
									</c:if>
								</div>
							</div>
							<div class="col-lg-3 pd-right-none no-pd">
								<div class="right-sidebar">
									<div class="widget widget-jobs">
										<div class="sd-title">
											<h3>관리자 목록</h3>
											<i class="la la-ellipsis-v"></i>
										</div>
										<div class="jobs-list">
											<c:forEach var="list" items="${alist}">
												<div class="job-info">
													<div class="job-details">
														<h3>${list.adminName }</h3>
														<p>${list.adminEmail }</p>
													</div>
													<div class="hr-rate">
														<span>${list.deptName }</span>
													</div>
												</div><!--job-info end-->
											</c:forEach>
										</div><!--jobs-list end-->
									</div><!--widget-jobs end-->
								</div><!--right-sidebar end-->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>
	</div>
	
<script type="text/javascript">

function toggleBtn(f) {
	$("#combox" + f).toggle("hide");
}


</script>

<script type="text/javascript" src="${contextPath}/resources/js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${contextPath}/resources/lib/slick/slick.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/scrollbar.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>
