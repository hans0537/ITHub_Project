<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/flatpickr.min.css">

<script>
	function checkDelete(f) {
		
		var check = confirm("지원을 취소 하시겠습니까?");
		
		if(!check) return;
		
		location.href='${contextPath}/job/deleteResume?jsSeq=' + f;
	}

</script>
</head>
<body>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/layout/navbar.jsp"%>
		<section class="cover-sec">
			<c:choose>
				<c:when test="${dto.mBackpic == null }">
					<img src="${contextPath}/resources/images/resources/cover-img.jpg"
						alt="">
				</c:when>
				<c:otherwise>
					<img width="1600px" height="400px"
						src="${contextPath }/resources/upload/${dto.mBackpic}" alt="???">
				</c:otherwise>
			</c:choose>

			<div class="add-pic-box">
				<div class="container">
					<div class="row no-gutters">
						<div class="col-lg-12 col-sm-12">
							<div id="changeBackpic">
								<label>Change Image</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
							<div class="col-lg-3">
								<div class="main-left-sidebar">



									<div class="user_profile">

										<div class="user-pro-img">
											<c:choose>
												<c:when test="${dto.mPic == null }">
													<img
														src="${contextPath}/resources/images/resources/cover-img.jpg"
														alt="">
												</c:when>
												<c:otherwise>
													<img height="180px" width="180px"
														src="${contextPath }/resources/upload/${dto.mPic}"
														alt="어디갔노">
												</c:otherwise>
											</c:choose>
											<div class="add-dp" id="OpenImgUpload">
												<input type="file" id="file"> <label for="file"><i
													class="fas fa-camera"></i></label>
											</div>
										</div>
										<!--user-pro-img end-->

										<div class="user-tab-sec">
											<h3>${dto.mLastname }${dto.mFirstname }</h3>
										</div>


										<div class="user_pro_status">
											<ul class="flw-status">
												<li style="cursor: pointer;"
													onclick="location.href='${contextPath}/follow/followList?user=me&mp=m&cSeq=${dto.mSeq}'">
													<span>Following</span> <b>${dto.following }</b>
												</li>
												<li style="cursor: pointer;"
													onclick="location.href='${contextPath}/follow/followerList?user=me&mp=m&cSeq=${dto.mSeq}'">
													<span>Followers</span> <b>${dto.follower }</b>
												</li>
											</ul>
										</div>
										<!--user_pro_status end-->

										<ul class="social_links">
											<li><h3 align="center" style="font-weight: bold;">
													<c:choose>
														<c:when
															test="${myPage.size() != 0 && myPage.size() != null }">
														나의 페이지( ${myPage.size() } )
													</c:when>
														<c:otherwise>
														나의 페이지( 0 )
													</c:otherwise>
													</c:choose>
												</h3></li>
											<c:forEach var="my" items="${myPage }">
												<li><a
													href="${contextPath }/page/myPage?pSeq=${my.pSeq}"> <img
														height="20px" width="20px"
														src="${contextPath }/resources/upload/${my.pPic}" /> <span
														style="font-size: 20px; padding-left: 15px;">${my.pName }</span>
												</a></li>
											</c:forEach>
										</ul>
									</div>
									<!--user_profile end-->



									<div class="suggestions full-width">
										<div class="sd-title">
											<h3>내 프로필 조회한 사람</h3>
											<i class="la la-ellipsis-v"></i>
										</div>
										<!--sd-title end-->
										<div class="suggestions-list">

											<c:forEach var="hit" items="${hitList }">
												<div class="suggestion-usd">
													<c:forEach var="list" items="${list }">
														<c:if test="${hit.mSeq == list.mSeq }">
															<img height="35px" width="35px"
																src="${contextPath }/resources/upload/${list.mPic}"
																alt="">
															<div class="sgt-text">
																<h4>${list.mLastname }${list.mFirstname }</h4>
																<span>${list.mIntro }</span>
															</div>
															<span><a
																href="${contextPath }/member/userProfile?otherSeq=${list.mSeq}"><i
																	class="la la-plus"></i></a></span>
														</c:if>
													</c:forEach>

												</div>
											</c:forEach>

											<div class="view-more">
												<a href="${contextPath }/member/hitList" title="">View
													More</a>
											</div>
										</div>
										<!--suggestions-list end-->
									</div>
									<!--suggestions end-->



								</div>
								<!--main-left-sidebar end-->
							</div>
							<div class="col-lg-6">
								<div class="main-ws-sec">
									<div class="user-tab-sec rewivew">
										<div class="posts-bar">
											<div class="post-bar bgclr">
												<div class="wordpressdevlp">
													<h3>
														<한줄소개>
														<br>
														--------------------------------------------------------------
													</h3>
													<br>
													<h1>${dto.mIntro }<a href="#" title=""
															class="intro-open" id="intro-open"><i
															style="float: right;" class="fa fa-pencil"></i></a>
													</h1>
												</div>
											</div>
										</div>
										<div class="tab-feed st2 settingjb">
											<ul>
												<li data-tab="feed-dd" class="active"><a href="#"
													title=""> <img
														src="${contextPath}/resources/images/ic1.png" alt="">
														<span>Feed</span>
												</a></li>
												<li data-tab="info-dd"><a href="#" title=""> <img
														src="${contextPath}/resources/images/ic2.png" alt="">
														<span>Info</span>
												</a></li>
												<li data-tab="saved-jobs"><a href="#" title=""> <img
														src="${contextPath}/resources/images/ic4.png" alt="">
														<span>Jobs</span>
												</a></li>
												<li data-tab="portfolio-dd"><a href="#" title=""> <img
														src="${contextPath}/resources/images/ic3.png" alt="">
														<span>Portfolio</span>
												</a></li>
											</ul>
										</div>
										<!-- tab-feed end-->
									</div>
									<!--user-tab-sec end-->


									<div class="product-feed-tab" id="saved-jobs">
										<ul class="nav nav-tabs" id="myTab" role="tablist">
											<li class="nav-item"><a class="nav-link active"
												id="mange-tab" data-toggle="tab" href="#mange" role="tab"
												aria-controls="home" aria-selected="true">Manage Jobs</a></li>
											<li class="nav-item"><a class="nav-link" id="saved-tab"
												data-toggle="tab" href="#saved" role="tab"
												aria-controls="profile" aria-selected="false">Saved Jobs</a>
											</li>
											<li class="nav-item"><a class="nav-link"
												id="contact-tab" data-toggle="tab" href="#applied"
												role="tab" aria-controls="applied" aria-selected="false">Applied
													Jobs</a></li>
										</ul>
										<div class="tab-content" id="myTabContent">
											<div class="tab-pane fade show active" id="mange"
												role="tabpanel" aria-labelledby="mange-tab">

												<c:if test="${empty myJoblist }">
													<div class="posts-bar">
														<div class="post-bar bgclr">
															<div class="wordpressdevlp">
																<h2>현재 지원중인 목록이 없습니다.</h2>
															</div>
														</div>
													</div>
												</c:if>
												<c:if test="${!empty myJoblist }">
													<c:forEach var="alist" items="${myJoblist }">
														<div class="posts-bar">
															<div class="post-bar bgclr">
																<div class="wordpressdevlp">

																	<h2>${alist.jpostName }</h2>
																	<span> <img height="20px" width="20px"
																		src="${contextPath }/resources/upload/${alist.pPic}" />
																		<span style="font-size: 20px; padding-left: 15px;">${alist.pName }</span>
																	</span>
																	<p>${alist.wtypeName }</p>
																	<p>${alist.posName }</p>
																</div>
																<br>
																<div class="row no-gutters">
																	<div class="col-md-6 col-sm-12">
																		<div class="cadidatesbtn">
																			<button type="button" class="btn btn-primary"
																				onclick="location.href='${contextPath}/job/jobDetails?jpostSeq=${alist.jpostSeq }&check=true'">
																				<span class="badge badge-light"></span>공고 보기
																			</button>
																			<a style="cursor: pointer;"
																				href="${contextPath}/job/updateResumeForm?jpostSeq=${alist.jpostSeq}&jsSeq=${alist.jpostsaveSeq}">
																				<i class="far fa-edit"></i>
																			</a> <a style="cursor: pointer;"
																				onclick="checkDelete(${alist.jpostsaveSeq})"> <i
																				class="far fa-trash-alt"></i>
																			</a>
																		</div>
																	</div>
																	<div class="col-md-6 col-sm-12">
																		<ul class="bk-links bklink">
																			<li><a href="#" title=""><i
																					class="la la-bookmark"></i></a></li>
																			<li><a href="#" title=""><i
																					class="la la-envelope"></i></a></li>
																		</ul>
																	</div>
																</div>
															</div>
														</div>
													</c:forEach>
												</c:if>
											</div>
										</div>
									</div>

									<div class="product-feed-tab current" id="feed-dd">
										<div class="posts-section">
											<div class="post-topbar">
												<div class="user-picy">
													<img style="width: 35px; height: 35px; object-fit: cover;"
														src="${contextPath }/resources/upload/${dto.mPic}" alt="">
												</div>
												<div class="post-st">
													<ul>
														<li><a class=""
															href="${contextPath }/board/writeForm?path=myProfile"
															title="">게시글 작성</a></li>
													</ul>
												</div>
												<!--post-st end-->
											</div>
											<!--post-topbar end-->
											<c:choose>
												<c:when test="${empty list2 }">
													<div class="post-bar">
														<h3>게시물이 없습니다.</h3>
													</div>
													<!--post-bar end-->
												</c:when>
												<c:otherwise>
													<c:forEach var="blist" items="${list2}">
														<c:if test="${dto.mSeq == blist.mSeq }">
															<div class="post-bar">
																<div class="post_topbar">
																	<div class="usy-dt">
																		<img style="width: 35px; height: 35px;"
																			src="${contextPath }/resources/upload/${blist.mPic}"
																			alt="">
																		<div class="usy-name">
																			<h3>${blist.mLastname}${blist.mFirstname}</h3>
																			<span><img
																				src="${contextPath }/resources/images/clock.png"
																				alt="">${blist.boardDate }</span>
																		</div>
																	</div>

																	<c:if test="${blist.mSeq == dto.mSeq }">
																		<div class="ed-opts">
																			<a href="#" title="" class="ed-opts-open"><i
																				class="la la-ellipsis-v"></i></a>
																			<ul class="ed-options">
																				<li><a
																					href="${contextPath}/board/updateForm?boardSeq=${blist.boardSeq}&path=main"
																					title="">수정</a></li>
																				<li><a style="cursor: pointer;"
																					onclick="deleteAction(${blist.boardSeq})" title="">삭제</a></li>
																			</ul>
																		</div>
																	</c:if>
																</div>

																<!-- 게시물 제목 -->
																<div class="job_descp">
																	<p>${blist.boardContent}</p>
																</div>

																<div class="job-status-bar">
																	<ul class="like-com">
																		<li><a href="#"><i class="fas fa-heart"></i>
																				Like</a> <img
																			src="${contextPath }/resources/images/liked-img.png"
																			alt=""> <span>25</span></li>
																		<li><a href="#" class="com"><i
																				class="fas fa-comment-alt"></i> Comment 15</a></li>
																	</ul>
																	<a href="#"><i class="fas fa-eye"></i>Views 50</a>
																</div>
															</div>
															<!--post-bar end-->
														</c:if>
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</div>

										<div align="center">
											<c:if test="${paging.prev }">
												<a
													href="${contextPath }/board/list?page=${paging.begin - 1}&type=${param.type}&word=${param.word}&path=myProfile">[이전]</a>
												<!-- 검색 했을 때 타입, 입력값 넘어감 -->
											</c:if>
											<c:forEach var="i" begin="${paging.begin }"
												end="${paging.end }" step="1">
												<c:choose>
													<c:when test="${i == paging.page }">
														<strong>[${i }]</strong>
													</c:when>
													<c:otherwise>
														<a
															href="${contextPath }/board/list?page=${i}&type=${param.type}&word=${param.word}&path=myProfile">[${i }]</a>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:if test="${paging.next }">
												<a
													href="${contextPath }/board/list?page=${paging.end + 1}&type=${param.type}&word=${param.word}&path=myProfile">[다음]</a>
											</c:if>
										</div>
									</div>
									<!--product-feed-tab end-->


									<div class="product-feed-tab" id="info-dd">

										<!-- 경력사항 -->
										<div class="user-profile-ov st2" id="career-feed">
											<h3>
												<a href="#" title="" class="exp-bx-open">Career </a><a
													href="#" title="" class="exp-bx-open"><i
													class="fa fa-plus-square"></i></a>
											</h3>
											<c:forEach var="myCareer" items="${myCareer }">
												<input type="hidden" name="carSeq" id="carSeq"
													value="${myCareer.carSeq}">
												<h4>${myCareer.posName }
													<a title="" id="delete-career"><i class="fa fa-pencil"></i></a>
												</h4>
												<span>${myCareer.etypeName}</span>
												<span>${myCareer.carStart } ~ ${myCareer.carEnd}</span>
												<p>${myCareer.carContent }</p>
											</c:forEach>
										</div>
										<!--user-profile-ov end-->



										<div class="user-profile-ov" id="edu-feed">
											<h3>
												<a href="#" title="" class="ed-box-open">Education</a> <a
													href="#" title="" class="ed-box-open"><i
													class="fa fa-pencil"></i></a> <a href="#" title=""><i
													class="fa fa-plus-square"></i></a>
											</h3>
											<c:forEach var="myEdu" items="${myEdu }">
												<h4>${myEdu.pName}</h4>
												<span>${myEdu.eduDegree }</span>
												<span>${myEdu.eduStart } ~ ${myEdu.eduEnd }</span>
												<span>${myEdu.eduCredit}</span>
												<p>${myEdu.eduContent }</p>
		                                        &nbsp;
											</c:forEach>
										</div>
                                        
                                        
                                        
										<!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3>
												<a href="#" title="" class="lct-box-open">Location</a> <a
													href="#" title="" class="lct-box-open"><i
													class="fa fa-pencil"></i></a> <a href="#" title=""><i
													class="fa fa-plus-square"></i></a>
											</h3>
											<h4>${country.get(dto.cSeq - 1).cName }</h4>
											<p>${country.get(dto.cSeq - 1).city.get(dto.ciSeq - 1).ciName }</p>
										</div>
										<!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3>
												<a href="#" title="" class="skills-open">Skills</a> <a
													href="#" title="" class="skills-open"><i
													class="fa fa-pencil"></i></a> <a href="#"><i
													class="fa fa-plus-square"></i></a>
											</h3>
											<ul>
												<li><a href="#" title="">HTML</a></li>
												<li><a href="#" title="">PHP</a></li>
												<li><a href="#" title="">CSS</a></li>
												<li><a href="#" title="">Javascript</a></li>
												<li><a href="#" title="">Wordpress</a></li>
												<li><a href="#" title="">Photoshop</a></li>
												<li><a href="#" title="">Illustrator</a></li>
												<li><a href="#" title="">Corel Draw</a></li>
											</ul>
										</div>
										<!--user-profile-ov end-->
									</div>
									<!--product-feed-tab end-->
									<div class="product-feed-tab" id="rewivewdata">
										<section></section>



										<div class="posts-section">
											<div class="post-bar reviewtitle">
												<h2>Reviews</h2>
											</div>
											<!--post-bar end-->
											<div class="post-bar ">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/bg-img3.png" alt="">
														<div class="usy-name">
															<h3>Rock William</h3>
															<div class="epi-sec epi2">
																<ul class="descp review-lt">
																	<li><img src="images/icon8.png" alt=""><span>Epic
																			Coder</span></li>
																	<li><img src="images/icon9.png" alt=""><span>India</span></li>
																</ul>
															</div>
														</div>
													</div>
												</div>

												<div class="job_descp mngdetl">
													<div class="star-descp review">
														<ul>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star-half-o"></i></li>
														</ul>
														<a href="#" title="">5.0 of 5 Reviews</a>
													</div>
													<div class="reviewtext">
														<p>Lorem ipsum dolor sit amet, adipiscing elit. Nulla
															luctus mi et porttitor ultrices</p>
														<hr>
													</div>

													<div class="post_topbar post-reply">
														<div class="usy-dt">
															<img src="images/resources/bg-img4.png" alt="">
															<div class="usy-name">
																<h3>John Doe</h3>
																<div class="epi-sec epi2">
																	<p>
																		<i class="la la-clock-o"></i>3 min ago
																	</p>
																	<p class="tahnks">Thanks :)</p>
																</div>
															</div>
														</div>
													</div>
													<div class="post_topbar rep-post rep-thanks">
														<hr>
														<div class="usy-dt">
															<img src="images/resources/bg-img4.png" alt=""> <input
																class="reply" type="text" placeholder="Reply"> <a
																class="replybtn" href="#">Send</a>

														</div>
													</div>

												</div>
											</div>
											<!--post-bar end-->
											<div class="post-bar post-thanks">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/bg-img1.png" alt="">
														<div class="usy-name">
															<h3>Jassica William</h3>
															<div class="epi-sec epi2">
																<ul class="descp review-lt">
																	<li><img src="images/icon8.png" alt=""><span>Epic
																			Coder</span></li>
																	<li><img src="images/icon9.png" alt=""><span>India</span></li>
																</ul>
															</div>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i
															class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>

												<div class="job_descp mngdetl">
													<div class="star-descp review">
														<ul>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star"></i></li>
															<li><i class="fa fa-star-half-o"></i></li>
														</ul>
														<a href="#" title="">5.0 of 5 Reviews</a><br>
														<br>
														<p>Awesome Work, Thanks John!</p>
														<hr>
													</div>
													<div class="post_topbar rep-post">
														<div class="usy-dt">
															<img src="images/resources/bg-img4.png" alt=""> <input
																class="reply" type="text" placeholder="Reply"> <a
																class="replybtn" href="#">Send</a>

														</div>
													</div>
												</div>
											</div>
											<!--post-bar end-->
										</div>
										<!--posts-section end-->
									</div>
									<!--product-feed-tab end-->
									<div class="product-feed-tab" id="my-bids">
										<div class="posts-section">
											<div class="post-bar">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/us-pic.png" alt="">
														<div class="usy-name">
															<h3>John Doe</h3>
															<span><img src="images/clock.png" alt="">3
																min ago</span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i
															class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>
												<div class="epi-sec">
													<ul class="descp">
														<li><img src="images/icon8.png" alt=""><span>Frontend
																Developer</span></li>
														<li><img src="images/icon9.png" alt=""><span>India</span></li>
													</ul>
													<ul class="bk-links">
														<li><a href="#" title=""><i
																class="la la-bookmark"></i></a></li>
														<li><a href="#" title=""><i
																class="la la-envelope"></i></a></li>
														<li><a href="#" title="" class="bid_now">Bid Now</a></li>
													</ul>
												</div>
												<div class="job_descp">
													<h3>Simple Classified Site</h3>
													<ul class="job-dt">
														<li><span>$300 - $350</span></li>
													</ul>
													<p>
														Lorem ipsum dolor sit amet, consectetur adipiscing elit.
														Aliquam luctus hendrerit metus, ut ullamcorper quam
														finibus at. Etiam id magna sit amet... <a href="#"
															title="">view more</a>
													</p>
													<ul class="skill-tags">
														<li><a href="#" title="">HTML</a></li>
														<li><a href="#" title="">PHP</a></li>
														<li><a href="#" title="">CSS</a></li>
														<li><a href="#" title="">Javascript</a></li>
														<li><a href="#" title="">Wordpress</a></li>
														<li><a href="#" title="">Photoshop</a></li>
														<li><a href="#" title="">Illustrator</a></li>
														<li><a href="#" title="">Corel Draw</a></li>
													</ul>
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li><a href="#"><i class="la la-heart"></i> Like</a>
															<img src="images/liked-img.png" alt=""> <span>25</span>
														</li>
														<li><a href="#" title="" class="com"><img
																src="images/com.png" alt=""> Comment 15</a></li>
													</ul>
													<a><i class="la la-eye"></i>Views 50</a>
												</div>
											</div>
											<!--post-bar end-->
											<div class="post-bar">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/us-pic.png" alt="">
														<div class="usy-name">
															<h3>John Doe</h3>
															<span><img src="images/clock.png" alt="">3
																min ago</span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i
															class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>
												<div class="epi-sec">
													<ul class="descp">
														<li><img src="images/icon8.png" alt=""><span>Frontend
																Developer</span></li>
														<li><img src="images/icon9.png" alt=""><span>India</span></li>
													</ul>
													<ul class="bk-links">
														<li><a href="#" title=""><i
																class="la la-bookmark"></i></a></li>
														<li><a href="#" title=""><i
																class="la la-envelope"></i></a></li>
														<li><a href="#" title="" class="bid_now">Bid Now</a></li>
													</ul>
												</div>
												<div class="job_descp">
													<h3>Ios Shopping mobile app</h3>
													<ul class="job-dt">
														<li><span>$300 - $350</span></li>
													</ul>
													<p>
														Lorem ipsum dolor sit amet, consectetur adipiscing elit.
														Aliquam luctus hendrerit metus, ut ullamcorper quam
														finibus at. Etiam id magna sit amet... <a href="#"
															title="">view more</a>
													</p>
													<ul class="skill-tags">
														<li><a href="#" title="">HTML</a></li>
														<li><a href="#" title="">PHP</a></li>
														<li><a href="#" title="">CSS</a></li>
														<li><a href="#" title="">Javascript</a></li>
														<li><a href="#" title="">Wordpress</a></li>
														<li><a href="#" title="">Photoshop</a></li>
														<li><a href="#" title="">Illustrator</a></li>
														<li><a href="#" title="">Corel Draw</a></li>
													</ul>
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li><a href="#"><i class="la la-heart"></i> Like</a>
															<img src="images/liked-img.png" alt=""> <span>25</span>
														</li>
														<li><a href="#" title="" class="com"><img
																src="images/com.png" alt=""> Comment 15</a></li>
													</ul>
													<a><i class="la la-eye"></i>Views 50</a>
												</div>
											</div>
											<!--post-bar end-->
											<div class="post-bar">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/us-pic.png" alt="">
														<div class="usy-name">
															<h3>John Doe</h3>
															<span><img src="images/clock.png" alt="">3
																min ago</span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i
															class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>
												<div class="epi-sec">
													<ul class="descp">
														<li><img src="images/icon8.png" alt=""><span>Frontend
																Developer</span></li>
														<li><img src="images/icon9.png" alt=""><span>India</span></li>
													</ul>
													<ul class="bk-links">
														<li><a href="#" title=""><i
																class="la la-bookmark"></i></a></li>
														<li><a href="#" title=""><i
																class="la la-envelope"></i></a></li>
														<li><a href="#" title="" class="bid_now">Bid Now</a></li>
													</ul>
												</div>
												<div class="job_descp">
													<h3>Simple Classified Site</h3>
													<ul class="job-dt">
														<li><span>$300 - $350</span></li>
													</ul>
													<p>
														Lorem ipsum dolor sit amet, consectetur adipiscing elit.
														Aliquam luctus hendrerit metus, ut ullamcorper quam
														finibus at. Etiam id magna sit amet... <a href="#"
															title="">view more</a>
													</p>
													<ul class="skill-tags">
														<li><a href="#" title="">HTML</a></li>
														<li><a href="#" title="">PHP</a></li>
														<li><a href="#" title="">CSS</a></li>
														<li><a href="#" title="">Javascript</a></li>
														<li><a href="#" title="">Wordpress</a></li>
														<li><a href="#" title="">Photoshop</a></li>
														<li><a href="#" title="">Illustrator</a></li>
														<li><a href="#" title="">Corel Draw</a></li>
													</ul>
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li><a href="#"><i class="la la-heart"></i> Like</a>
															<img src="images/liked-img.png" alt=""> <span>25</span>
														</li>
														<li><a href="#" title="" class="com"><img
																src="images/com.png" alt=""> Comment 15</a></li>
													</ul>
													<a><i class="la la-eye"></i>Views 50</a>
												</div>
											</div>
											<!--post-bar end-->
											<div class="post-bar">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/us-pic.png" alt="">
														<div class="usy-name">
															<h3>John Doe</h3>
															<span><img src="images/clock.png" alt="">3
																min ago</span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i
															class="la la-ellipsis-v"></i></a>
														<ul class="ed-options">
															<li><a href="#" title="">Edit Post</a></li>
															<li><a href="#" title="">Unsaved</a></li>
															<li><a href="#" title="">Unbid</a></li>
															<li><a href="#" title="">Close</a></li>
															<li><a href="#" title="">Hide</a></li>
														</ul>
													</div>
												</div>
												<div class="epi-sec">
													<ul class="descp">
														<li><img src="images/icon8.png" alt=""><span>Frontend
																Developer</span></li>
														<li><img src="images/icon9.png" alt=""><span>India</span></li>
													</ul>
													<ul class="bk-links">
														<li><a href="#" title=""><i
																class="la la-bookmark"></i></a></li>
														<li><a href="#" title=""><i
																class="la la-envelope"></i></a></li>
														<li><a href="#" title="" class="bid_now">Bid Now</a></li>
													</ul>
												</div>
												<div class="job_descp">
													<h3>Ios Shopping mobile app</h3>
													<ul class="job-dt">
														<li><span>$300 - $350</span></li>
													</ul>
													<p>
														Lorem ipsum dolor sit amet, consectetur adipiscing elit.
														Aliquam luctus hendrerit metus, ut ullamcorper quam
														finibus at. Etiam id magna sit amet... <a href="#"
															title="">view more</a>
													</p>
													<ul class="skill-tags">
														<li><a href="#" title="">HTML</a></li>
														<li><a href="#" title="">PHP</a></li>
														<li><a href="#" title="">CSS</a></li>
														<li><a href="#" title="">Javascript</a></li>
														<li><a href="#" title="">Wordpress</a></li>
														<li><a href="#" title="">Photoshop</a></li>
														<li><a href="#" title="">Illustrator</a></li>
														<li><a href="#" title="">Corel Draw</a></li>
													</ul>
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li><a href="#"><i class="la la-heart"></i> Like</a>
															<img src="images/liked-img.png" alt=""> <span>25</span>
														</li>
														<li><a href="#" title="" class="com"><img
																src="images/com.png" alt=""> Comment 15</a></li>
													</ul>
													<a><i class="la la-eye"></i>Views 50</a>
												</div>
											</div>
											<!--post-bar end-->
											<div class="process-comm">
												<a href="#" title=""><img src="images/process-icon.png"
													alt=""></a>
											</div>
											<!--process-comm end-->
										</div>
										<!--posts-section end-->
									</div>
									<!--product-feed-tab end-->
									<div class="product-feed-tab" id="portfolio-dd">
										<div class="portfolio-gallery-sec">
											<h3>Portfolio</h3>
											<div class="portfolio-btn">
												<a href="#" title=""><i class="fas fa-plus-square"></i>
													Add Portfolio</a>
											</div>
											<div class="gallery_pf">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img1.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img2.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img3.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img4.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img5.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img6.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img7.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img8.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img9.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-6 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img10.jpg" alt=""> <a
																href="#" title=""><img src="images/all-out.png"
																alt=""></a>
														</div>
														<!--gallery_pt end-->
													</div>
												</div>
											</div>
											<!--gallery_pf end-->
										</div>
										<!--portfolio-gallery-sec end-->
									</div>
									<!--product-feed-tab end-->
								</div>
								<!--main-ws-sec end-->
							</div>
							<div class="col-lg-3">
								<div class="right-sidebar">
									<div class="message-btn">
										<a href="${contextPath }/member/accountSetting" title=""><i
											class="fas fa-cog"></i> Setting</a>
									</div>
									<div class="widget widget-portfolio">
										<div class="wd-heady">
											<h3>Portfolio</h3>
											<img src="images/photo-icon.png" alt="">
										</div>
										<div class="pf-gallery">
											<ul>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery1.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery2.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery3.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery4.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery5.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery6.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery7.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery8.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery9.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery10.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery11.png" alt=""></a></li>
												<li><a href="#" title=""><img
														src="images/resources/pf-gallery12.png" alt=""></a></li>
											</ul>
										</div>
										<!--pf-gallery end-->
									</div>
									<!--widget-portfolio end-->
								</div>
								<!--right-sidebar end-->
							</div>
						</div>
					</div>
					<!-- main-section-data end-->
				</div>
			</div>
		</main>

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
					<p>
						<img src="images/copy-icon2.png" alt="">Copyright 2019
					</p>
					<img class="fl-rgt" src="images/logo2.png" alt="">
				</div>
			</div>
		</footer>
		<!--footer end-->

		<div class="overview-box" id="overview-box">
			<div class="overview-edit">
				<h3>Overview</h3>
				<span>5000 character left</span>
				<form>
					<textarea></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->


		<div class="overview-box" id="experience-box">
			<div class="overview-edit">
				<h3>Career</h3>
				<form name="insert_career" id="insert_career" method="post">
					<div class="datefm">
						<select name="posSeq">
							<c:forEach var="position" items="${position }">
								<option value="${position.posSeq }">${position.posName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="datefm">
						<select name="etypeSeq">
							<c:forEach var="emptype" items="${emptype}">
								<option value="${emptype.etypeSeq }">${emptype.etypeName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="datepicky">
						<div class="row">
							<div class="col-lg-6 no-left-pd">
								<div class="datefm">
									<input type="date" name="carStart" id="carStart" >	
								</div>
							</div>
							<div class="col-lg-6 no-righ-pd">
								<div class="datefm">
									<input type="date" name="carEnd" id="carEnd"  >
								</div>
							</div>
						</div>
					</div>
					<div class="datefm">
						<select name="iSeq">
							<c:forEach var="i" items="${industry}">
								<option value="${i.iSeq }">${i.iName}</option>
							</c:forEach>
						</select>
					</div>
					<textarea name="carContent" id="carContent"></textarea>
					<button type="submit" class="save">Save</button>
					<button type="button" class="close-box-cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="education-box">
			<div class="overview-edit">
				<h3>Education</h3>
				<form name="insert_edu" id="insert_edu" method="post">
						<select name="pSeq">
							<c:forEach var="univ" items="${eduList }">
								<option value="${univ.pSeq }">${univ.pName }</option>			
							</c:forEach>
						</select>
					<div class="datepicky">
						<div class="row">
							<div class="col-lg-6 no-left-pd">
								<div class="datefm">
									<input type="text" name="eduStart" placeholder="From"
										class="datepicker" id="eduStart"> <i class="fa fa-calendar"></i>
								</div>
							</div>
							<div class="col-lg-6 no-righ-pd">
								<div class="datefm">
									<input type="text" name="eduEnd" placeholder="To"
										class="datepicker" id="eduEnd"> <i class="fa fa-calendar"></i>
								</div>
							</div>
						</div>
					</div>
					<input type="text" name="eduDegree" id="eduDegree" placeholder="학위">
					<input type="text" name="eduMajor" id="eduMajor" placeholder="전공">
					<input type="text" name="eduCredit" id="eduCredit" placeholder="학점">
					<textarea name="eduContent" placeholder="세부 내용"></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->

		<div class="overview-box" id="location-box">
			<div class="overview-edit">
				<h3>Location</h3>
				<form>
					<div class="datefm">
						<select>
							<option>Country</option>
							<option value="pakistan">Pakistan</option>
							<option value="england">England</option>
							<option value="india">India</option>
							<option value="usa">United Sates</option>
						</select> <i class="fa fa-globe"></i>
					</div>
					<div class="datefm">
						<select>
							<option>City</option>
							<option value="london">London</option>
							<option value="new-york">New York</option>
							<option value="sydney">Sydney</option>
							<option value="chicago">Chicago</option>
						</select> <i class="fa fa-map-marker"></i>
					</div>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->

		<div class="overview-box" id="skills-box">
			<div class="overview-edit">
				<h3>Skills</h3>
				<ul>
					<li><a href="#" title="" class="skl-name">HTML</a><a href="#"
						title="" class="close-skl"><i class="la la-close"></i></a></li>
					<li><a href="#" title="" class="skl-name">php</a><a href="#"
						title="" class="close-skl"><i class="la la-close"></i></a></li>
					<li><a href="#" title="" class="skl-name">css</a><a href="#"
						title="" class="close-skl"><i class="la la-close"></i></a></li>
				</ul>
				<form>
					<input type="text" name="skills" placeholder="Skills">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->

		<div class="overview-box" id="create-portfolio">
			<div class="overview-edit">
				<h3>Create Portfolio</h3>
				<form>
					<input type="text" name="pf-name" placeholder="Portfolio Name">
					<div class="file-submit">
						<input type="file" id="file"> <label for="file">Choose
							File</label>
					</div>
					<div class="pf-img">
						<img src="images/resources/np.png" alt="">
					</div>
					<input type="text" name="website-url"
						placeholder="htp://www.example.com">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->

		<div class="overview-box" id="changeBack-pic">
			<div class="overview-edit">
				<h3>Change BackImage</h3>
				<form action="${contextPath }/member/backPic" method="post"
					enctype="multipart/form-data">
					<input type="file" name="fileBackPic" size="400" />
					<button type="submit" class="save">Save</button>
					<button type="reset" class="cancel">Reset</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->

		<div class="overview-box" id="change-image">
			<div class="overview-edit">
				<h3>Change ProfileImage</h3>
				<form action="${contextPath }/member/mPic" method="post"
					enctype="multipart/form-data">
					<input type="file" name="filePic" size="400" />
					<button type="submit" class="save">Save</button>
					<button type="reset" class="cancel">Reset</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->


		<div class="overview-box" id="intro-box">
			<div class="overview-edit">
				<h3>Intro</h3>
				<span>100 character left</span>
				<form action="${contextPath }/member/introUpdate" method="post">
					<input type="text" name="mIntro" placeholder="${dto.mIntro }" />
					<button type="submit" class="save">Save</button>
					<button type="reset" class="cancel">Reset</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div>
			<!--overview-edit end-->
		</div>
		<!--overview-box end-->

	</div>
	<!--theme-layout end-->




	<script type="text/javascript">

	$("#insert_career").submit(function(event) {
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		
		console.log(data);
		
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/career/insert",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				
				var str = "";
				
				str += "<h3><a title='' class='exp-bx-open'>Career </a><a title='' class='exp-bx-open'><i class='fa fa-plus-square'></i></a></h3>";
				
				
				data.forEach((myCareer)=>{
					
					
					str += "<h4>" + myCareer.posName + "<a title=''><i class='fa fa-pencil'></i></a></h4>";
					
					str += "<span>" + myCareer.etypeName + "</span>";
					
					if(myCareer.carStart != null && myCareer.carEnd != null){
						str += "<span>" + myCareer.carStart + " ~ " + myCareer.carEnd + "</span>";
					}
					
					if(myCareer.carContent == null){
						myCareer.carContent = " ";
					}
					
					str += "<p>" + myCareer.carContent + "</p>";
					
				});
				
				$("#experience-box").removeClass("open");
		        $(".wrapper").removeClass("overlay");
				
		        $("#career-feed").html(str);
		        
		        
		        
		        
			}
		});
		
	});

	$("#insert_edu").submit(function(event) {
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		
		console.log(data);
		
		console.log(data.eduStart);
		console.log(data.eduEnd);
		data.eduStart = data.eduStart.substr(0,10);
		data.eduEnd = data.eduEnd.substr(0,10);
		console.log(data.eduStart);
		console.log(data.eduEnd);
		
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/edu/insert",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				
				var str = "";
				
				str += "<h3><a href='#' title='' class='ed-box-open'>Education</a><a href='#' title='' class='ed-box-open'><i class='fa fa-pencil'></i></a> <a href='#' title=''><i class='fa fa-plus-square'></i></a></h3>";
				
				data.forEach((myEdu)=>{
					
					str += "<h4>" + myEdu.pName + "<a title=''><i class='fa fa-pencil'></i></a></h4>";
					
					str += "<span>" + myEdu.eduDegree + "</span>";
					
					if(myEdu.eduStart != null && myEdu.eduEnd != null){
						str += "<span>" + myEdu.eduStart + " ~ " + myEdu.eduEnd + "</span>";
					}
					
					str += "<span>" + myEdu.eduCredit + "</span>";
					
					if(myEdu.eduContent == null){
						myEdu.eduContent = " ";
					}
					
					str += "<p>" + myEdu.eduContent + "</p>";
					
					str += "&nbsp;";
					
				});
				
				$("#education-box").removeClass("open");
		        $(".wrapper").removeClass("overlay");
				
		        $("#edu-feed").html(str);
		        
		        
			}
		});
		
	});

	
	/* $("#insert_career").submit(function(event) {
		
		alert("submit직후");
		
		console.log(document.getElementById("carStart").value);
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		console.log(data);
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/career/insert",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);	
				
				
				var str = "";
				
				str += "<h3><a title='' class='exp-bx-open'>Career </a><a title='' class='exp-bx-open'><i class='fa fa-plus-square'></i></a></h3>";
				data.forEach((myCareer)=>{
					str += "<h4>" + myCareer.posName + "<a title=''><i class='fa fa-pencil'></i></a></h4>";
					str += "<span>" + myCareer.etypeName + "</span>";
					str += "<span>" + myCareer.carStart "-" + myCareer.carEnd + "</span>";
					str += "<p>" + myCareer.carContent + "</p>";
				});
				
				
		        // career                
				$("#experience-box").removeClass("open");
		        $(".wrapper").removeClass("overlay");
				
		        $("#career-feed").html(str);
		        
		        
		        
		        
			}
		});
		
	}); */
	
	/* $("#delete_career").on("click", function(event) {
		
		event.preventDefault(); // submit 취소 */
		
		/* var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		}); */
		
		/* var data = document.getElementById("carSeq").value;
		
		console.log(data);
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/career/delete",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);	
				
				
				var str = "";
				
				str += "<h3><a title='' class='exp-bx-open'>Career </a><a title='' class='exp-bx-open'><i class='fa fa-plus-square'></i></a></h3>";
				data.forEach((myCareer)=>{
					str += "<h4>" + myCareer.posName + "<a title=''><i class='fa fa-pencil'></i></a></h4>";
					str += "<span>" + myCareer.etypeName + "</span>";
					str += "<span>" + myCareer.carStart "-" + myCareer.carEnd + "</span>";
					str += "<p>" + myCareer.carContent + "</p>";
				});
				
				
		        // career
				
		        $("#career-feed").html(str);
		        
		        
		        
		        
			}
		});
		
	}); */




</script>


	<script type="text/javascript"
		src="${contextPath}/resources/js/flatpickr.min.js"></script>
	<script type="text/javascript"
		src="${contextPath}/resources/lib/slick/slick.min.js"></script>
	<%@ include file="/WEB-INF/views/layout/footJs.jsp"%>