<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/flatpickr.min.css">

</head>
<body>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/layout/adminNav.jsp" %>

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
												<li style="cursor: pointer;" onclick="location.href='${contextPath}/follow/followerList?user=other&mp=p&cSeq=${page.pSeq }'">
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
									
									<div class="product-feed-tab current" id="feed-dd">
										<div class="posts-section">
											<div class="post-bar">
												<div class="post_topbar">
													<div class="usy-dt">
														<img src="images/resources/company-pic.png" alt="">
														<div class="usy-name">
															<h3>Facebook Inc. 	</h3>
															<span><img src="images/clock.png" alt="">3 min ago</span>
														</div>
													</div>
													<div class="ed-opts">
														<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
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
														<li><img src="images/icon8.png" alt=""><span>Epic Coder</span></li>
														<li><img src="images/icon9.png" alt=""><span>India</span></li>
													</ul>
													<ul class="bk-links">
														<li><a href="#" title=""><i class="la la-bookmark"></i></a></li>
														<li><a href="#" title=""><i class="la la-envelope"></i></a></li>
													</ul>
												</div>
												<div class="job_descp">
													<h3>Senior UI / UX designer</h3>
													<ul class="job-dt">
														<li><a href="#" title="">Full Time</a></li>
														<li><span>$30 / hr</span></li>
													</ul>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam luctus hendrerit metus, ut ullamcorper quam finibus at. Etiam id magna sit amet... <a href="#" title="">view more</a></p>
													<ul class="skill-tags">
														<li><a href="#" title="">HTML</a></li>
														<li><a href="#" title="">PHP</a></li>
														<li><a href="#" title="">CSS</a></li>
														<li><a href="#" title="">Javascript</a></li>
														<li><a href="#" title="">Wordpress</a></li> 	
													</ul>
												</div>
												<div class="job-status-bar">
													<ul class="like-com">
														<li>
															<a href="#"><i class="fas fa-heart"></i> Like</a>
															<img src="images/liked-img.png" alt="">
															<span>25</span>
														</li>
														<li><a href="#" class="com"><i class="fas fa-comment-alt"></i> Comments 15</a></li>
													</ul>
													<a href="#"><i class="fas fa-eye"></i>Views 50</a>
												</div>
											</div><!--post-bar end-->
										</div><!--posts-section end-->
									</div><!--product-feed-tab end-->
									
									
									<div class="product-feed-tab" id="info-dd">
										<div class="user-profile-ov">
											<h3><a href="#" title="" class="overview-open">Overview</a> <a href="#" title="" class="overview-open"><i class="fa fa-pencil"></i></a></h3>
											<p>${page.pText }</p>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov st2">
											<h3><a href="#" title="" class="esp-bx-open">Establish Since </a><a href="#" title="" class="esp-bx-open"><i class="fa fa-pencil"></i></a> <a href="#" title="" class="esp-bx-open"><i class="fa fa-plus-square"></i></a></h3>
											<span>${page.pFounddate }</span>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3><a href="#" title="" class="emp-open">Total Employees</a> <a href="#" title="" class="emp-open"><i class="fa fa-pencil"></i></a> <a href="#" title="" class="emp-open"><i class="fa fa-plus-square"></i></a></h3>
											<span>${page.pEmpcnt }</span>
										</div><!--user-profile-ov end-->
										<div class="user-profile-ov">
											<h3><a href="#" title="" class="lct-box-open">Location</a> <a href="#" title="" class="lct-box-open"><i class="fa fa-pencil"></i></a> <a href="#" title="" class="lct-box-open"><i class="fa fa-plus-square"></i></a></h3>
											<h4>${page.cSeq }</h4>
											<p>${page.ciSeq }</p>
											<p>${page.pAddr }</p>
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
					<p><img src="images/copy-icon2.png" alt="">Copyright 2018</p>
					<img class="fl-rgt" src="images/logo2.png" alt="">
				</div>
			</div>
		</footer><!--footer end-->


		<div class="overview-box" id="overview-box">
			<div class="overview-edit">
				<h3>Overview</h3>
				<span>5000 character left</span>
				<form action="${contextPath}/page/update" name="update" method="post">
					<textarea id="pText" name="pText"></textarea>
					<button type="submit" class="save">Save</button>
					<button type="" class="cancel">Cancel</button>
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
				<form>
					<div class="datefm">
						<select>
							<option>Country</option>
							<option value="pakistan">Pakistan</option>
							<option value="england">England</option>
							<option value="india">India</option>
							<option value="usa">United Sates</option>
						</select>
						<i class="fa fa-globe"></i>
					</div>
					<div class="datefm">
						<select>
							<option>City</option>
							<option value="london">London</option>
							<option value="new-york">New York</option>
							<option value="sydney">Sydney</option>
							<option value="chicago">Chicago</option>
						</select>
						<i class="fa fa-map-marker"></i>
					</div>
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
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
				<form action="${contextPath}/page/update" name="update" method="post">
					<div class="daty">
						<input type="date" name="establish" placeholder="Select Date" class="datepicker">
						<i class="fa fa-calendar"></i>
					</div>
					<button type="submit" class="save">Save</button>
					<button type="" class="cancel">Cancel</button>
				</form>
				<a href="#" title="" class="close-box"><i class="la la-close"></i></a>
			</div><!--overview-edit end-->
		</div><!--overview-box end-->


		<div class="overview-box" id="total-employes">
			<div class="overview-edit">
				<h3>Total Employees</h3>
				<form>
					<input type="text" name="employes" placeholder="Type in numbers">
					<button type="submit" class="save">Save</button>
					<button type="submit" class="cancel">Cancel</button>
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
	<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>
	
<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>
