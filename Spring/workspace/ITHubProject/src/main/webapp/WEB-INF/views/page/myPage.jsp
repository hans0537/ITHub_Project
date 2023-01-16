<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="css/flatpickr.min.css">
<script>
	function deleteAction(j,p) {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check) return;
		
		location.href='${contextPath}/job/jobDelete?jpostSeq=' + j + '&pSeq=' + p;
	}
</script>
</head>
<body>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/layout/navbar.jsp" %>

		<section class="cover-sec">
			<c:choose>
				<c:when test="${page.pBackpic == null }">
					<img src="${contextPath}/resources/images/resources/cover-img.jpg" alt="">
				</c:when>
				<c:otherwise>
					<img width="1600px" height="400px" src="${contextPath }/resources/upload/${page.pBackpic}" alt="???">
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
												<c:when test="${page.pPic == null }">
													<img src="${contextPath}/resources/images/resources/cover-img.jpg" alt="">
												</c:when>
												<c:otherwise>
													<img height="180px" width="180px" src="${contextPath }/resources/upload/${page.pPic}" alt="어디갔노">
												</c:otherwise>
											</c:choose>
											<div class="add-dp" id="OpenImgUpload">
												<input type="file" id="file">
												<label for="file"><i class="fas fa-camera"></i></label>												
											</div>
										</div><!--user-pro-img end-->
										<div class="user_pro_status">
											<ul class="flw-status">
												<li style="cursor: pointer;" onclick="location.href='${contextPath}/follow/followerList?user=me&mp=p&cSeq=${page.pSeq }'">
													<span>Followers</span>
													<b>${page.pFollower }</b>
												</li>
											</ul>
										</div><!--user_pro_status end-->
										<ul class="social_links">
											<li><a href="http://${page.pLink}">
													<i class="la la-globe"></i>${page.pLink } 
												</a>
											</li>
										</ul>
									</div><!--user_profile end-->
									
									<div class="suggestions full-width">
										<div class="sd-title">
											<h3>내 페이지 조회한 사람</h3>
											<i class="la la-ellipsis-v"></i>
										</div><!--sd-title end-->
										<div class="suggestions-list">
										
											<c:forEach var="hit" items="${hitList }">
												<div class="suggestion-usd">
													<c:forEach var="mlist" items="${mlist }">
														<c:if test="${hit.mSeq == mlist.mSeq }">
															<img height="35px" width="35px" src="${contextPath }/resources/upload/${mlist.mPic}" alt="">
															<div class="sgt-text">
																<h4>${mlist.mLastname }${mlist.mFirstname }</h4>
																<span>${mlist.mIntro }</span>
															</div>
															<span><a href="${contextPath }/member/userProfile?otherSeq=${mlist.mSeq}"><i class="la la-plus"></i></a></span>
														</c:if>
													</c:forEach>
													
												</div>
											</c:forEach>
											
											<div class="view-more">
												<a href="${contextPath }/member/hitList?pSeq=${page.pSeq}" title="">View More</a>
											</div>
										</div><!--suggestions-list end-->
									</div><!--suggestions end-->
									
									
								</div><!--main-left-sidebar end-->
							</div>
							<div class="col-lg-6">
								<div class="main-ws-sec">
									<div class="user-tab-sec">
										<h3>${page.pName }</h3>
										<div class="star-descp">
											<span>${page.pInfo }</span>
											<span>${page.iSeq }</span>
											
										</div><!--star-descp end-->
										<div class="tab-feed">
											<ul>
												<li data-tab="feed-dd" class="active">
													<a href="#" title="">
														<img src="${contextPath}/resources/images/ic1.png" alt="">
														<span>Feed</span>
													</a>
												</li>
												<li data-tab="info-dd">
													<a href="#" title="">
														<img src="${contextPath}/resources/images/ic2.png" alt="">
														<span>Info</span>
													</a>
												</li>
												<li data-tab="portfolio-dd">
													<a href="#" title="">
														<img src="${contextPath}/resources/images/ic3.png" alt="">
														<span>Portfolio</span>
													</a>
												</li>
											</ul>
										</div><!-- tab-feed end-->
									</div><!--user-tab-sec end-->
									
									
									<div class="post-topbar">
										<div class="user-picy">
											<img src="${contextPath }/resources/upload/${page.pPic}.png" alt="">
										</div>
										
										<div class="post-st">
											<ul>
												<li><a href="" title="">게시글 올리기</a></li>
												<li><a href="${contextPath }/job/jobPost?pSeq=${page.pSeq }" title="">채용 공고 올리기</a></li>
											</ul>
										</div><!--post-st end-->
									</div><!--post-topbar end-->


									<div class="product-feed-tab current" id="feed-dd">
										<div class="posts-section">
											<c:choose>
												<c:when test = "${empty jplist}">
													<div class="post-bar">
														<div>채용공고가 없습니다.</div>
													</div>
												</c:when>
												<c:otherwise>
													<c:forEach var = "dto" items = "${jplist}">
													<form action = "${contextPath}/post/updatePost" method = "post" enctype = "multipart/form-data">
														<input type = "hidden" value = "${dto.jpostSeq}" name = "jpostSeq">
														<div class="post-bar">
															<div class="post_topbar">
																<div class="usy-dt">
																	<img height="35px" width="35px" src="${contextPath}/resources/upload/${page.pPic}" alt="">
																	<div class="usy-name">
																		<h4>${page.pName}</h4>
																		<span>
																			<img src="${contextPath}/resources/images/clock.png" alt="">
																			<!-- 현재년도 -->
																			${dto.hisdate } 일전
																		</span>
																	</div>
																</div>
																<div class="ed-opts">
																	<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
																	<ul class="ed-options">
																		<li><a href="${contextPath}/job/jobUpdate?jpostSeq=${dto.jpostSeq}" >수정</a></li>
																		<li><a style="cursor: pointer;" onclick="deleteAction(${dto.jpostSeq}, ${page.pSeq})">삭제</a></li>
																	</ul>
																</div>
															</div>
															<div align = "right">
																<span style="cursor: pointer;" onclick="location='${contextPath}/job/applylist?jpostSeq=${dto.jpostSeq}'">지원자: ${dto.jpostApply} 명</span>
															</div>
															<div class="job_descp">
																<h3>${dto.jpostName}</h3>
																<ul class="job-dt">
																	<li>${dto.ETYPENAME}</li>
																</ul>
																<p>${dto.jpostExplain}</p>
																<ul class="skill-tags">
																	<li><a href="#" title="">${dto.POSNAME}</a></li>
																	<li><a href="#" title="">${dto.INAME}</a></li>
																	<li><a href="#" title="">${dto.OCCNAME}</a></li>
																	<li><a href="#" title="">${dto.WTYPENAME}</a></li>
																	<li><a href="#" title="">${dto.JRANKNAME}</a></li> 	
																</ul>
															</div>
															<div class="job-status-bar">
																<ul class="like-com">
																	<li>
																		<a href="#"><i class="fas fa-heart"></i> Like</a>
																		<img src="${contextPath}/resources/images/liked-img.png" alt="">
																		<span>25</span>
																	</li> 
																	<li><a href="#" class="com"><i class="fas fa-comment-alt"></i> Comment 15</a></li>
																</ul>
																<a href="#"><i class="fas fa-eye"></i>Views 50</a>
															</div>
														</div>
													</form>
											</c:forEach>
										</c:otherwise>
									</c:choose>										
										
										
										</div><!--posts-section end-->
									</div><!--product-feed-tab end-->
									<div class="product-feed-tab" id="info-dd">
										<div class="user-profile-ov">
											<h3><a href="#" title="" class="overview-open">Overview</a> <a href="#" title="" class="overview-open"><i class="fa fa-pencil"></i></a></h3>
											<p id="pText-feed" style="word-wrap:break-word;">${page.pText }</p>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov st2">
											<h3><a href="#" title="" class="esp-bx-open">Establish Since </a><a href="#" title="" class="esp-bx-open"><i class="fa fa-pencil"></i></a></h3>
											<span id="pFounddate-feed">${page.pFounddate }</span>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3><a href="#" title="" class="emp-open">Total Employees</a> <a href="#" title="" class="emp-open"><i class="fa fa-pencil"></i></a></h3>
											<span id="pEmpcnt-feed">${page.pEmpcnt }</span>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3><a href="#" title="" class="lct-box-open">Location</a> <a href="#" title="" class="lct-box-open"><i class="fa fa-pencil"></i></a></h3>
											<p id="pAddr-feed">${page.pAddr }</p>
										</div><!--user-profile-ov end-->
									</div><!--product-feed-tab end-->
									<div class="product-feed-tab" id="portfolio-dd">
										<div class="portfolio-gallery-sec">
											<h3>Portfolio</h3>
											<div class="gallery_pf">
												<div class="row">
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img1.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img2.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img3.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img4.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img5.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img6.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img7.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img8.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img9.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 col-6">
														<div class="gallery_pt">
															<img src="images/resources/pf-img10.jpg" alt="">
															<a href="#" title=""><img src="images/all-out.png" alt=""></a>
														</div><!--gallery_pt end-->
													</div>
												</div>
											</div><!--gallery_pf end-->
										</div><!--portfolio-gallery-sec end-->
									</div><!--product-feed-tab end-->
								</div><!--main-ws-sec end-->
							</div>
							<div class="col-lg-3">
								<div class="right-sidebar">
									<div class="message-btn">
										<a href="#" title=""><i class="fa fa-envelope"></i> Message</a>
									</div>
									<div class="widget widget-portfolio">
										<div class="wd-heady">
											<h3>Portfolio</h3>
											<img src="images/photo-icon.png" alt="">
										</div>
										<div class="pf-gallery">
											<ul>
												<li><a href="#" title=""><img src="images/resources/pf-gallery1.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery2.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery3.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery4.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery5.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery6.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery7.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery8.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery9.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery10.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery11.png" alt=""></a></li>
												<li><a href="#" title=""><img src="images/resources/pf-gallery12.png" alt=""></a></li>
											</ul>
										</div><!--pf-gallery end-->
									</div><!--widget-portfolio end-->
								</div><!--right-sidebar end-->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>

		<footer>
			<div class="footy-sec mn no-margin">
				<div class="container">
					<ul>
						<li><a href="${contextPath }/service/serviceCenter" title="">Help Center</a></li>
						<li><a href="#" title="">About</a></li>
						<li><a href="#" title="">Privacy Policy</a></li>
						<li><a href="#" title="">Community Guidelines</a></li>
						<li><a href="#" title="">Cookies Policy</a></li>
						<li><a href="#" title="">Career</a></li>
						<li><a href="#" title="">Forum</a></li>
						<li><a href="#" title="">Language</a></li>
						<li><a href="#" title="">Copyright Policy</a></li>
					</ul>
					<p><img src="images/copy-icon2.png" alt="">Copyright 2018</p>
					<img class="fl-rgt" src="images/logo2.png" alt="">
				</div>
			</div>
		</footer><!--footer end-->


		<div class="overview-box" id="overview-box">
			<div class="overview-edit">
				<h3>Overview</h3>
				<form name="update_text" id="update_text" method="post">
					<input type="hidden" name="pSeq" value="${page.pSeq }"/>
					<textarea id="pText" name="pText" value="${page.pText }"></textarea>
					<button type="submit" class="save">Save</button>
					<button type="button" class="close-box-cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="experience-box">
			<div class="overview-edit">
				<h3>Experience</h3>
				<form>
					<input type="text" name="subject" placeholder="Subject">
					<textarea></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="education-box">
			<div class="overview-edit">
				<h3>Education</h3>
				<form>
					<input type="text" name="school" placeholder="School / University">
					<div class="datepicky">
						<div class="row">
							<div class="col-lg-6 no-left-pd">
								<div class="datefm">
									<input type="text" name="from" placeholder="From" class="datepicker">	
									<i class="fa fa-calendar"></i>
								</div>
							</div>
							<div class="col-lg-6 no-righ-pd">
								<div class="datefm">
									<input type="text" name="to" placeholder="To" class="datepicker">
									<i class="fa fa-calendar"></i>
								</div>
							</div>
						</div>
					</div>
					<input type="text" name="degree" placeholder="Degree">
					<textarea placeholder="Description"></textarea>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="location-box">
			<div class="overview-edit">
				<h3>Location</h3>
				<form name="update_addr" id="update_addr" method="post">
					<input type="hidden" name="pSeq" value="${page.pSeq }"/>
					<input type="text" name="pAddr" id="pAddr" value="${page.pAddr }">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="close-box-cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->


		<div class="overview-box" id="skills-box">
			<div class="overview-edit">
				<h3>Skills</h3>
				<ul>
					<li><a href="#" title="" class="skl-name">HTML</a><a href="#" title="" class="close-skl"><i class="la la-close"></i></a></li>
					<li><a href="#" title="" class="skl-name">php</a><a href="#" title="" class="close-skl"><i class="la la-close"></i></a></li>
					<li><a href="#" title="" class="skl-name">css</a><a href="#" title="" class="close-skl"><i class="la la-close"></i></a></li>
				</ul>
				<form>
					<input type="text" name="skills" placeholder="Skills">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="save-add">Save & Add More</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="create-portfolio">
			<div class="overview-edit">
				<h3>Create Portfolio</h3>
				<form>
					<input type="text" name="pf-name" placeholder="Portfolio Name">
					<div class="file-submit nomg">
						<input type="file" name="file">
					</div>
					<div class="pf-img">
						<img src="images/resources/np.png" alt="">
					</div>
					<input type="text" name="website-url" placeholder="htp://www.example.com">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="establish-box">
			<div class="overview-edit">
				<h3>Establish Since</h3>
				<form name="update_founddate" id="update_founddate" method="post">
					<input type="hidden" name="pSeq" value="${page.pSeq }"/>
					<div class="daty">
						<input type="date" id="pFounddate" name="pFounddate" placeholder="Select Date" class="datepicker"  value="${page.pFounddate }">
					</div>
					<button type="submit" class="save">Save</button>
					<button type="button" class="close-box-cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->



		<div class="overview-box" id="total-employes">
			<div class="overview-edit">
				<h3>Total Employees</h3>
				<form name="update_empcnt" id="update_empcnt" method="post">
					<input type="hidden" name="pSeq" value="${page.pSeq }"/>
					<input type="text" id="pEmpcnt" name="pEmpcnt" value="${page.pEmpcnt }">
					<button type="submit" class="save">Save</button>
					<button type="button" class="close-box-cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->

		<div class="overview-box" id="changeBack-pic">
			<div class="overview-edit">
				<h3>Change BackImage</h3>
				<form action="${contextPath }/page/backPic" method="post" enctype="multipart/form-data">
					<input type="hidden" name="pSeq" value="${page.pSeq }"/>
					<input type="file" name="backPic" size="400"/>
					<button type="submit" class="save">Save</button>
					<button type="reset" class="cancel">Reset</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->
	
		<div class="overview-box" id="change-image">
			<div class="overview-edit">
				<h3>Change ProfileImage</h3>
				<form action="${contextPath }/page/pPic" method="post" enctype="multipart/form-data">
					<input type="hidden" name="pSeq" value="${page.pSeq }"/>
					<input type="file" name="logo" size="400"/>
					<button type="submit" class="save">Save</button>
					<button type="reset" class="cancel">Reset</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->
	</div>

<script type="text/javascript">
	
	
	
	$("#update_text").submit(function(event) {
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		console.log(data);
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/page/update",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);	
				
		        // pText
				$("#overview-box").removeClass("open");
		        $(".wrapper").removeClass("overlay");
				
		        $("#pText").val(data.pText);
		        $("#pText-feed").text(data.pText);
		        
		        
			}
		});
		
	});
	
	$("#update_founddate").submit(function(event) {
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		console.log(data);
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/page/update",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);	
				
				// pFounddate
				$("#establish-box").removeClass("open");
		        $(".wrapper").removeClass("overlay");
		        
		        $("#pFounddate").val(data.pFounddate);
		        $("#pFounddate-feed").text(data.pFounddate);
		        
			}
		});
		
	});
	
	$("#update_empcnt").submit(function(event) {
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		console.log(data);
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/page/update",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);	
				
				// pEmpcnt
				$("#total-employes").removeClass("open");
		        $(".wrapper").removeClass("overlay");
		        
		        $("#pEmpcnt").val(data.pEmpcnt);
		        $("#pEmpcnt-feed").text(data.pEmpcnt);
		        
			}
		});
		
	});
	
	$("#update_addr").submit(function(event) {
		
		event.preventDefault(); // submit 취소
		
		var data = {};
		
		$.each($(this).serializeArray(),function(index,o){
			data[o.name] = o.value;
		});
		
		console.log(data);
		
		$.ajax({
			url:"${ pageContext.request.contextPath }/page/update",
			type:"POST",
			dataType:"json",
			contentType: "application/json",
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);	
				
				// pAddr
				$("#location-box").removeClass("open");
		        $(".wrapper").removeClass("overlay");
		        
		        $("#pAddr").val(data.pAddr);
		        $("#pAddr-feed").text(data.pAddr);
		        
			}
		});
		
	});
	
		        
</script>
	<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>	
<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>
