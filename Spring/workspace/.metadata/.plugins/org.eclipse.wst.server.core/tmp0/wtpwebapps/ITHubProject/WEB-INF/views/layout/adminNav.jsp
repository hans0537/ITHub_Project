<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<div class="container">
		<div class="header-data">
			<div class="logo">
				<a href="${contextPath}/adminMain.go" title=""><img src="${contextPath}/resources/images/fabicon.png" alt=""></a>
			</div><!--logo end-->
			<div class="search-bar">
				<form action="${contextPath }/adminMain.go" method="get" onsubmit="return check(this)">
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
						<a href="${contextPath}/admin/adminPageList?pType=0" title="">
							<span><img src="${contextPath}/resources/images/icon2.png" alt=""></span>
							회사 페이지 관리
						</a>
					</li>
					<li>
						<a href="${contextPath}/admin/adminPageList?pType=1" title="">
							<span><img src="${contextPath}/resources/images/icon3.png" alt=""></span>
							학교 페이지 관리
						</a>
					</li>
					<li>
						<a href="${contextPath}/admin/adminUserList" title="">
							<span><img src="${contextPath}/resources/images/icon4.png" alt=""></span>
							회원 관리
						</a>
					</li>
					<li>
						<a href="${contextPath}/admin/adminJobList" title="">
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