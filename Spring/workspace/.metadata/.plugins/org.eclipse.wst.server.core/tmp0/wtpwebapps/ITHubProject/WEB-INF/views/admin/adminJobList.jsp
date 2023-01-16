<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<link rel="stylesheet" type="text/css" href="css/jquery.range.css">
</head>
<body>

	<div class="wrapper">	
		<%@ include file="/WEB-INF/views/layout/adminNav.jsp" %>

		<div class="search-sec">
			<div class="container">
				<div class="search-box">
					<form>
						<input type="text" name="search" placeholder="Search keywords">
						<button type="submit">Search</button>
					</form>
				</div><!--search-box end-->
			</div>
		</div><!--search-sec end-->


		<main>
			<div class="main-section">
				<div class="container">
					<div class="main-section-data">
						<div class="row">
							<div class="col-lg-3">
								<div class="filter-secs">
									<div class="filter-heading">
										<h3>Filters</h3>
										<a href="#" title="">Clear all filters</a>
									</div><!--filter-heading end-->
									<div class="paddy">
										<div class="filter-dd">
											<div class="filter-ttl">
												<h3>Skills</h3>
												<a href="#" title="">Clear</a>
											</div>
											<form>
												<input type="text" name="search-skills" placeholder="Search skills">
											</form>
										</div>
										<div class="filter-dd">
											<div class="filter-ttl">
												<h3>Availabilty</h3>
												<a href="#" title="">Clear</a>
											</div>
											<ul class="avail-checks">
												<li>
													<input type="radio" name="cc" id="c1">
													<label for="c1">
														<span></span>
													</label>
													<small>Hourly</small>
												</li>
												<li>
													<input type="radio" name="cc" id="c2">
													<label for="c2">
														<span></span>
													</label>
													<small>Part Time</small>
												</li>
												<li>
													<input type="radio" name="cc" id="c3">
													<label for="c3">
														<span></span>
													</label>
													<small>Full Time</small>
												</li>
											</ul>
										</div>
										<div class="filter-dd">
											<div class="filter-ttl">
												<h3>Job Type</h3>
												<a href="#" title="">Clear</a>
											</div>
											<form class="job-tp">
												<select>
													<option>Select a job type</option>
													<option>Select a job type</option>
													<option>Select a job type</option>
													<option>Select a job type</option>
												</select>
												<i class="fa fa-ellipsis-v" aria-hidden="true"></i>
											</form>
										</div>
										<div class="filter-dd">
											<div class="filter-ttl">
												<h3>Pay Rate / Hr ($)</h3>
												<a href="#" title="">Clear</a>
											</div>
											<div class="rg-slider">
			                                    <input class="rn-slider slider-input" type="hidden" value="5,50" />
			                                </div>
			                                <div class="rg-limit">
			                                	<h4>1</h4>
			                                	<h4>100+</h4>
			                                </div><!--rg-limit end-->
										</div>
										<div class="filter-dd">
											<div class="filter-ttl">
												<h3>Experience Level</h3>
												<a href="#" title="">Clear</a>
											</div>
											<form class="job-tp">
												<select>
													<option>Select a experience level</option>
													<option>3 years</option>
													<option>4 years</option>
													<option>5 years</option>
												</select>
												<i class="fa fa-ellipsis-v" aria-hidden="true"></i>
											</form>
										</div>
										<div class="filter-dd">
											<div class="filter-ttl">
												<h3>Countries</h3>
												<a href="#" title="">Clear</a>
											</div>
											<form class="job-tp">
												<select>
													<option>Select a country</option>
													<option>United Kingdom</option>
													<option>United States</option>
													<option>Russia</option>
												</select>
												<i class="fa fa-ellipsis-v" aria-hidden="true"></i>
											</form>
										</div>
									</div>
								</div><!--filter-secs end-->
							</div>
							<div class="col-lg-6">
								<div class="main-ws-sec">
									<div class="posts-section">
									
									
										<c:choose>
											<c:when test = "${empty list}">
												<div>채용공고가 없습니다.</div>
											</c:when>
											<c:otherwise>
												<c:forEach var = "list" items = "${list}">
													<form action = "${contextPath}/post/updatePost" method = "post" enctype = "multipart/form-data">
														<input type = "hidden" value = "${list.jpostSeq}" name = "jpostSeq">
			
														<div class="post-bar">
															<div class="post_topbar">
																<c:choose>
																	<c:when test="${list.mSeq == dto.mSeq }">
																		<div class="usy-dt" style="cursor: pointer;" onclick="location.href='${contextPath}/page/myPage?pSeq=${list.pSeq }'">
																			<img height="35px" width="35px" src="${contextPath}/resources/upload/${list.pPic}" alt="">
																
																			<div class="usy-name">
																				<h4>${list.pName}</h4>
																				<span><img src="${contextPath}/resources/images/clock.png" alt="">${list.hisdate } 일전</span>
																			</div>
																		</div>
																	</c:when>
																	<c:otherwise>
																		<div class="usy-dt" style="cursor: pointer;" onclick="location.href='${contextPath}/page/pageProfile?pSeq=${list.pSeq }'">
																			<img height="35px" width="35px" src="${contextPath}/resources/upload/${list.pPic}" alt="">
																
																			<div class="usy-name">
																				<h4>${list.pName}</h4>
																				<span><img src="${contextPath}/resources/images/clock.png" alt="">${list.hisdate } 일전</span>
																			</div>
																		</div>
																	</c:otherwise>
																</c:choose>
															
																<div align = "right">
																	<span>지원자: ${list.jpostApply} 명</span>
																</div>
															</div>
															<div class="epi-sec">
																<ul class="descp">
																	<li><img src="${contextPath }/resources/images/icon8.png" alt=""></li>
																	<li><img src="${contextPath }/resources/images/icon9.png" alt=""></li>
																</ul>
															</div>
															<div class="job_descp">
																<h3>${list.jpostName}</h3>
																<ul class="job-dt">
																	<li>${list.ETYPENAME}</li>
																</ul>
																<p>${list.jpostExplain}</p>
																	
																	<a style="color: #e44d3a;" href="${contextPath}/job/jobDetails?jpostSeq=${list.jpostSeq}" title=""> view more</a>
																	<div align = "right" style = "padding-bottom : 9px;">
																		<a style="background-color: #e44d3a; border-color: #e44d3a;" href="${contextPath}/job/applyForm?jpostSeq=${list.jpostSeq}" class="btn btn-primary">
																			Apply a Job Now
																		</a>
																	</div>
																
																<ul class="skill-tags">
																	<li><a href="#" title="">${list.POSNAME}</a></li>
																	<li><a href="#" title="">${list.INAME}</a></li>
																	<li><a href="#" title="">${list.OCCNAME}</a></li>
																	<li><a href="#" title="">${list.WTYPENAME}</a></li>
																	<li><a href="#" title="">${list.JRANKNAME}</a></li> 	
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
								</div><!--main-ws-sec end-->
							</div>
							
							<div class="col-lg-3">
								<div class="right-sidebar">
									<div class="widget widget-about">
										<img src="images/wd-logo.png" alt="">
										<h3>Track Time on Workwise</h3>
										<span>Pay only for the Hours worked</span>
										<div class="sign_link">
											<h3><a href="sign-in.html" title="">Sign up</a></h3>
											<a href="#" title="">Learn More</a>
										</div>
									</div><!--widget-about end-->
									<div class="widget widget-jobs">
										<div class="sd-title">
											<h3>Top Jobs</h3>
											<i class="la la-ellipsis-v"></i>
										</div>
										<div class="jobs-list">
											<div class="job-info">
												<div class="job-details">
													<h3>Senior Product Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
											<div class="job-info">
												<div class="job-details">
													<h3>Senior UI / UX Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
											<div class="job-info">
												<div class="job-details">
													<h3>Junior Seo Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
											<div class="job-info">
												<div class="job-details">
													<h3>Senior PHP Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
											<div class="job-info">
												<div class="job-details">
													<h3>Senior Developer Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
										</div><!--jobs-list end-->
									</div><!--widget-jobs end-->
									<div class="widget widget-jobs">
										<div class="sd-title">
											<h3>Most Viewed This Week</h3>
											<i class="la la-ellipsis-v"></i>
										</div>
										<div class="jobs-list">
											<div class="job-info">
												<div class="job-details">
													<h3>Senior Product Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
											<div class="job-info">
												<div class="job-details">
													<h3>Senior UI / UX Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
											<div class="job-info">
												<div class="job-details">
													<h3>Junior Seo Designer</h3>
													<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
												</div>
												<div class="hr-rate">
													<span>$25/hr</span>
												</div>
											</div><!--job-info end-->
										</div><!--jobs-list end-->
									</div><!--widget-jobs end-->
								</div><!--right-sidebar end-->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>

		</div><!--post-project-popup end-->
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


<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>
<script type="text/javascript" src="${contextPath }/resources/js/jquery.range-min.js"></script>
<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>