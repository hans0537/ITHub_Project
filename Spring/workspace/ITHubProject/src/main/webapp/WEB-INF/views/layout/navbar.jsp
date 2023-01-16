<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<div class="container">
		<div class="header-data">
			<div class="logo">
				<a href="${contextPath}/" title=""><img src="${contextPath}/resources/images/fabicon.png" alt=""></a>
			</div><!--logo end-->
			<div class="search-bar">
				<form action="${contextPath }/board/list?path=main" method="get" onsubmit="return check(this)">
					<input type="hidden" name="type" value="boardContent">
					<input type="hidden" name="path" value="main">
					<input type="text" name="word" placeholder="검색어를 입력하세요" value="${param.word }" autocomplete="off">
					<button type="submit"><i class="la la-search"></i></button>
				</form>
			</div><!--search-bar end-->
			<nav>
				<ul>
					<li>
						<a href="${contextPath}/" title="">
							<span><img src="${contextPath}/resources/images/icon1.png" alt=""></span>
							Home
						</a>
					</li>
					<li>
						<a href="${contextPath}/page/pageList?pType=0" title="">
							<span><img src="${contextPath}/resources/images/icon2.png" alt=""></span>
							Companies
						</a>
					</li>
					<li>
						<a href="${contextPath}/page/pageList?pType=1" title="">
							<span><img src="${contextPath}/resources/images/icon3.png" alt=""></span>
							University
						</a>
					</li>
					<li>
						<a href="${contextPath}/member/userList" title="">
							<span><img src="${contextPath}/resources/images/icon4.png" alt=""></span>
							Profiles
						</a>
						<ul>
							<li><a href="${contextPath}/member/userList" title="">User Profile</a></li>
							<li><a href="${contextPath }/member/profile" title="">My Profile</a></li>
						</ul>
					</li>
					<li>
						<a href="${contextPath}/job/jobList" title="">
							<span><img src="${contextPath}/resources/images/icon5.png" alt=""></span>
							Jobs
						</a>
					</li>
					<li>
						<a href="#" title="" class="not-box-openm">
							<span><img src="${contextPath}/resources/images/icon6.png" alt=""></span>
							Messages
						</a>
						<div class="notification-box msg" id="message">
							<div class="nt-title">
								<h4>Setting</h4>
								<a href="#" title="">Clear all</a>
							</div>
							<div class="nott-list">
								<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath }/resources/images/resources/ny-img1.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="messages.html" title="">Jassica William</a> </h3>
					  					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do.</p>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath }/resources/images/resources/ny-img2.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="messages.html" title="">Jassica William</a></h3>
					  					<p>Lorem ipsum dolor sit amet.</p>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath}/resources/images/resources/ny-img3.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="messages.html" title="">Jassica William</a></h3>
					  					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempo incididunt ut labore et dolore magna aliqua.</p>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="view-all-nots">
				  					<a href="messages.html" title="">View All Messsages</a>
				  				</div>
							</div><!--nott-list end-->
						</div><!--notification-box end-->
					</li>
					<li>
						<a href="#" title="" class="not-box-open">
							<span><img src="${contextPath}/resources/images/icon7.png" alt=""></span>
							Notification
						</a>
						<div class="notification-box noti" id="notification">
							<div class="nt-title">
								<h4>Setting</h4>
								<a href="#" title="">Clear all</a>
							</div>
							<div class="nott-list">
								<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath}/resources/images/resources/ny-img1.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath}/resources/images/resources/ny-img2.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath}/resources/images/resources/ny-img3.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="notfication-details">
					  				<div class="noty-user-img">
					  					<img src="${contextPath}/resources/images/resources/ny-img2.png" alt="">
					  				</div>
					  				<div class="notification-info">
					  					<h3><a href="#" title="">Jassica William</a> Comment on your project.</h3>
					  					<span>2 min ago</span>
					  				</div><!--notification-info -->
				  				</div>
				  				<div class="view-all-nots">
				  					<a href="#" title="">View All Notification</a>
				  				</div>
							</div><!--nott-list end-->
						</div><!--notification-box end-->
					</li>
				</ul>
			</nav><!--nav end-->
			<div class="menu-btn">
				<a href="#" title=""><i class="fa fa-bars"></i></a>
			</div><!--menu-btn end-->
			<div class="user-account">
				<div class="user-info">
					<img height="30px" width="30px" src="${contextPath}/resources/upload/${dto.mPic}" alt="">
					<span>${dto.mFirstname }</span>
					<i class="la la-sort-down"></i>
				</div>
				<div class="user-account-settingss" id="users">
					<h3>Online Status</h3>
					<ul class="on-off-status">
						<li>
							<div class="fgt-sec">
								<input type="radio" name="cc" id="c5">
								<label for="c5">
									<span></span>
								</label>
								<small>Online</small>
							</div>
						</li>
						<li>
							<div class="fgt-sec">
								<input type="radio" name="cc" id="c6">
								<label for="c6">
									<span></span>
								</label>
								<small>Offline</small>
							</div>
						</li>
					</ul>
					<h3>Custom Status</h3>
					<div class="search_form">
						<form>
							<input type="text" name="search">
							<button type="submit">Ok</button>
						</form>
					</div><!--search_form end-->
					<h3>Setting</h3>
					<ul class="us-links">
						<li><a href="${contextPath}/member/accountSetting" title="">Account Setting</a></li>
						<li><a href="#" title="">Privacy</a></li>
						<li><a href="#" title="">Faqs</a></li>
						<li><a href="#" title="">Terms & Conditions</a></li>
						<li><a href="${contextPath }/page/pageForm" title="">Create a Page</a>
					</ul>
					<h3 class="tc"><a href="${contextPath}/member/logout" title="">Logout</a></h3>
				</div><!--user-account-settingss end-->
			</div>
		</div><!--header-data end-->
	</div>
</header><!--header end-->	