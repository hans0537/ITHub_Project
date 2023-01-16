<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script>
	function deleteAction(j) {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check) return;
		
		location.href='${contextPath}/board/delete?boardSeq=' + j;
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
	
	function likeColor(i){
		$("#likeColor" + i).s;
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
							<div class="col-lg-3 col-md-4 pd-left-none no-pd">
								<div class="main-left-sidebar no-margin">
									<div class="user-data full-width">
										<div class="user-profile">
											<div class="username-dt">
												<div class="usr-pic">
													<c:choose>
														<c:when test="${dto.mPic == null }">
															<img src="${contextPath}/resources/images/resources/cover-img.jpg" alt="">
														</c:when>
														<c:otherwise>
															<img height="110px" width="110px" src="${contextPath }/resources/upload/${dto.mPic}" alt="어디갔노">
														</c:otherwise>
													</c:choose>
												</div>
											</div><!--username-dt end-->
											<div class="user-specs">
												<h3>${dto.mLastname}${dto.mFirstname}</h3>
												<span>${dto.mIntro }</span>
											</div>
										</div><!--user-profile end-->
										<ul class="user-fw-status">
											<li style="cursor: pointer;" onclick="location.href='${contextPath}/follow/followList?user=me&mp=m&cSeq=${dto.mSeq}'">
												<h4>Following</h4>
												<span>${dto.following }</span>
											</li>
											<li style="cursor: pointer;" onclick="location.href='${contextPath}/follow/followerList?user=me&mp=m&cSeq=${dto.mSeq}'">
												<h4>Followers</h4>
												<span>${dto.follower }</span>
											</li>
											<li>
												<a href="${contextPath}/member/profile" title="">View Profile</a>
											</li>
										</ul>
									</div><!--user-data end-->
									<div class="suggestions full-width">
										<div class="sd-title">
											<h3>Suggestions</h3>
											<i class="la la-ellipsis-v"></i>
										</div><!--sd-title end-->
										<div class="suggestions-list">
											<div class="suggestion-usd">
												<img src="${contextPath }/resources/images/resources/s1.png" alt="">
												<div class="sgt-text">
													<h4>Jessica William</h4>
													<span>Graphic Designer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="${contextPath }/resources/images/resources/s2.png" alt="">
												<div class="sgt-text">
													<h4>John Doe</h4>
													<span>PHP Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="${contextPath }/resources/images/resources/s3.png" alt="">
												<div class="sgt-text">
													<h4>Poonam</h4>
													<span>Wordpress Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="${contextPath }/resources/images/resources/s4.png" alt="">
												<div class="sgt-text">
													<h4>Bill Gates</h4>
													<span>C & C++ Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="${contextPath }/resources/images/resources/s5.png" alt="">
												<div class="sgt-text">
													<h4>Jessica William</h4>
													<span>Graphic Designer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="${contextPath }/resources/images/resources/s6.png" alt="">
												<div class="sgt-text">
													<h4>John Doe</h4>
													<span>PHP Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="view-more">
												<a href="#" title="">View More</a>
											</div>
										</div><!--suggestions-list end-->
									</div><!--suggestions end-->
									
									
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
											<img style="width: 35px; height: 35px; object-fit: cover; " src="${contextPath }/resources/upload/${dto.mPic}" alt="">
										</div>
										<div class="post-st">
											<ul>
												<li><a class="" href="${contextPath }/board/writeForm?path=main" title="">게시글 작성</a></li>
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
																	<img style="width: 35px; height: 35px;" src="${contextPath }/resources/upload/${blist.mPic}" alt="">
																	<div class="usy-name">
																		<h3>${blist.mLastname}${blist.mFirstname}</h3>
																		<span><img src="${contextPath }/resources/images/clock.png" alt="">${blist.boardDate }</span>
																	</div>
																</div>
																
																<c:if test="${blist.mSeq == dto.mSeq }">
																	<div class="ed-opts">
																		<a href="#" title="" class="ed-opts-open"><i class="la la-ellipsis-v"></i></a>
																		<ul class="ed-options">
																			<li><a href="${contextPath}/board/updateForm?boardSeq=${blist.boardSeq}" title="">수정</a></li>
																			<li><a style="cursor: pointer;" onclick="deleteAction(${blist.boardSeq})" title="">삭제</a></li>
																		</ul>
																	</div>
																</c:if>
															</div>
												
															<!-- 게시물 제목 -->
															<div class="job_descp">
																<p>${blist.boardContent}</p>
															</div>
												
												
															
															<div class="job-status-bar">
																<!-- 게시물 좋아요 및 댓글 수 -->
																<ul class="like-com">
																	<li id="likeList${blist.boardSeq}">
																		<c:set var="check" value="0"/>
																		<c:forEach var="mylike" items="${myLike}">
																			<c:if test="${mylike.boardSeq == blist.boardSeq}">
																				<c:set var="check" value="1"/>
																			</c:if>
																		</c:forEach>
																		<form style="float: left;" id="likeform${blist.boardSeq}" onsubmit="return false;">
																			<input type="hidden" name="boardSeq" id="boardSeq" value="${blist.boardSeq}">
																			<input type="hidden" name="check" id="check" value="${check}">
																			<c:if test="${check == 1}">
																				<a onclick="likeSubmit(${blist.boardSeq})" style="color:red;cursor: pointer;"><i class="fas fa-heart"></i> Like</a>
																			</c:if>
																			<c:if test="${check == 0}">
																				<a onclick="likeSubmit(${blist.boardSeq})" style="cursor: pointer;"><i class="fas fa-heart"></i> Like</a>
																			</c:if>
																		</form>
																		<img src="${contextPath }/resources/images/liked-img.png" alt="">
																		<c:set var="l" value="0"/>
																		<c:forEach var="lcnt" items="${likeCount}">
																			<c:if test="${lcnt.boardSeq == blist.boardSeq }">
																				<c:set var="l" value="${lcnt.likeCount }"/>
																			</c:if>
																		</c:forEach> 
																		<span id="likeCount${blist.boardSeq}">${l}</span>	<!-- 좋아요 누를때마다 올라가는거 해야함 -->
																	</li>
																	<c:set var="v" value="0"/>
																	<c:forEach var="cnt" items="${bcCount}">
																		<c:if test="${cnt.boardSeq == blist.boardSeq }">
																			<c:set var="v" value="${cnt.bcCount }"/>
																		</c:if>
																	</c:forEach> 
																	<li><a style="cursor: pointer;" class="com" id="commentCnt${blist.boardSeq}" onclick="toggleBtn(${blist.boardSeq});focusing(${blist.boardSeq});"><i class="fas fa-comment-alt"></i> Comment ${v}</a></li>
																</ul>
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
															<div class="post-comment">
																<div class="cm_img">
																	<img style="width: 35px; height: 35px;" src="${contextPath }/resources/upload/${dto.mPic}" alt="">
																</div>
																<div class="comment_box">
																	<form id="commentform${blist.boardSeq}" onsubmit="return false;">
																		<input type="hidden" name="boardSeq" id="boardSeq" value="${blist.boardSeq}">
																		<input type="hidden" name="orderno" id="orderno${blist.boardSeq}"  value="1">
																		<input type="hidden" name="depthno" id="depthno${blist.boardSeq}"  value="1">
																		<!-- <textarea rows="15" cols="65" name="bcContent" placeholder="Post a comment"></textarea> -->
																		<input style="background-color: rgb(255 235 235); color: black;"type="text" name="bcContent" id="bcContent${blist.boardSeq}" value="" >
																		<button type="button" onclick="commentSubmit(${blist.boardSeq});novalue(${blist.boardSeq});" >Send</button>
																	</form>
																</div>
															</div><!--post-comment end-->
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
									<div class="widget suggestions full-width">
										<div class="sd-title">
											<h3>Most Viewed People</h3>
											<i class="la la-ellipsis-v"></i>
										</div><!--sd-title end-->
										<div class="suggestions-list">
											<div class="suggestion-usd">
												<img src="images/resources/s1.png" alt="">
												<div class="sgt-text">
													<h4>Jessica William</h4>
													<span>Graphic Designer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s2.png" alt="">
												<div class="sgt-text">
													<h4>John Doe</h4>
													<span>PHP Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s3.png" alt="">
												<div class="sgt-text">
													<h4>Poonam</h4>
													<span>Wordpress Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s4.png" alt="">
												<div class="sgt-text">
													<h4>Bill Gates</h4>
													<span>C &amp; C++ Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s5.png" alt="">
												<div class="sgt-text">
													<h4>Jessica William</h4>
													<span>Graphic Designer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="suggestion-usd">
												<img src="images/resources/s6.png" alt="">
												<div class="sgt-text">
													<h4>John Doe</h4>
													<span>PHP Developer</span>
												</div>
												<span><i class="la la-plus"></i></span>
											</div>
											<div class="view-more">
												<a href="#" title="">View More</a>
											</div>
										</div><!--suggestions-list end-->
									</div>
								</div><!--right-sidebar end-->
							</div>
						</div>
					</div><!-- main-section-data end-->
				</div> 
			</div>
		</main>
	</div>
		
<script type="text/javascript">
$(document).ready(function() {
	$('.summernote').summernote({
		lang: 'ko-KR',
		height: 400
	});
});

function toggleBtn(f) {
	$("#combox" + f).toggle("hide");
}

//$(function() {
    //$("#toggleBtn").on("click", function() {
    //	$("#combox").toggle("hide");
  //  })
//});

function commentSubmit(i) {
	httpRequest = new XMLHttpRequest();
	
	if(!httpRequest){
		alert("인스턴스 생성 불가!");
		return;
	}
	
	var httpMethod = "POST";
	var httpURL = "${ pageContext.request.contextPath }/board/comment";
	
	var dataForm = document.getElementById("commentform" + i);
	
	let rawData = new FormData(dataForm);
	
	console.log(rawData);
	
	serialize(rawData);
	
	let d = serialize(rawData);
	
	console.log(JSON.stringify(d));
	
	httpRequest.open(httpMethod,httpURL,true);
	
	httpRequest.setRequestHeader("Content-Type","application/json");
	
	//콜백메소드 지정..
	httpRequest.onreadystatechange = formDatas;
	httpRequest.send(JSON.stringify(d));
}

function serialize(rawData) {
	
	let data = {};
	
	for(var[key,value] of rawData){
		let sel = document.querySelectorAll(key);
		
		if(sel.length > 1){
			if(data[key] === undefined){
				data[key] = [];
			}
			data[key].push(value);
		}else{
			data[key] = value;
		}
	}
	
	return data;
}
	
	
function formDatas(){
	
	var boardSeq = document.getElementById("boardSeq");
	var orderno = document.getElementById("orderno");
	var depthno = document.getElementById("depthno");
	var bcContent = document.getElementById("bcContent");
	
	if(httpRequest.readyState === XMLHttpRequest.DONE){
		var data = JSON.parse(httpRequest.responseText);
		console.log(data);
		if(httpRequest.status === 200){

			var str = "";
			var st = "";
			
			
			
			var commentList = document.getElementById("commentList"+data.bclist[0].boardSeq);
			console.log(commentList);
			
			var commentCount = document.getElementById("commentCnt"+data.bclist[0].boardSeq);
			console.log(commentCount);
			
			data.bclist.forEach((bc)=>{
				if(bc.depthno == 2) {
					str += "<ul>";
				}
					str += "<li>";
					str += "<div class='comment-list'>";
					str += "<div class='bg-img'>";
					str += "<img style='max-width: none;width: 33px;height: 33px;' src='${contextPath }/resources/upload/" + bc.mPic + "' alt=''>";
					str += "</div>";
					str += "<div class='comment'>";
					str += "<h3>" + bc.mLastname + bc.mFirstname + "</h3>";
					str += "<span><img src='${contextPath}/resources/images/clock.png' alt=''> "+ bc.bcDateS +"</span>";
					str += "<p id='newcomment'>" +bc.bcContent + "</p>";
					str += "<a onclick='sendName(\"" + bc.mLastname + "" + bc.mFirstname + "\" ," + bc.orderno + "," +bc.boardSeq+ ");focusing(" + bc.boardSeq + ");' title='' class='active'><i class='fa fa-reply-all'></i>Reply</a>";
					str += "</div>";				
					str += "</div>";			
					str += "</li>";	
				if(bc.depthno == 2) {
					str += "</ul>";
				}
			});
			
			data.bcCount.forEach((cnt)=>{
				if(cnt.boardSeq == data.bclist[0].boardSeq){
					st += "<i class='fas fa-comment-alt'></i> Comment "+cnt.bcCount;
				}
				
			});
			
			commentCount.innerHTML = st;
			commentList.innerHTML = str;
			document.getElementById("orderno"+data.bclist[0].boardSeq).value = "1";
			document.getElementById("depthno"+data.bclist[0].boardSeq).value = "1";
		}
	}
}


function likeSubmit(i) {
	httpRequest = new XMLHttpRequest();
	
	if(!httpRequest){
		alert("인스턴스 생성 불가!");
		return;
	}
	
	var httpMethod = "POST";
	var httpURL = "${ pageContext.request.contextPath }/board/like";
	
	var dataForm = document.getElementById("likeform" + i);
	
	let rawData = new FormData(dataForm);
	
	console.log(rawData);
	
	serialize(rawData);
	
	let d = serialize(rawData);
	
	console.log(JSON.stringify(d));
	
	httpRequest.open(httpMethod,httpURL,true);
	
	httpRequest.setRequestHeader("Content-Type","application/json");
	
	//콜백메소드 지정..
	httpRequest.onreadystatechange = likeData;
	httpRequest.send(JSON.stringify(d));
}

function likeData(){
	
	if(httpRequest.readyState === XMLHttpRequest.DONE){
		var data = JSON.parse(httpRequest.responseText);
		console.log(data);
		if(httpRequest.status === 200){

			var str = "";
			
			var likeList = document.getElementById("likeList"+data.dto.boardSeq);
			console.log(likeList);
			
			
			
			str += "<form style='float: left;' id='likeform" + data.dto.boardSeq + "' onsubmit='return false;'>";
			str += "<input type='hidden' name='boardSeq' id='boardSeq' value='" + data.dto.boardSeq + "'>";
			if(data.dto.check == 1){
				str += "<input type='hidden' name='check' id='check' value='0'>";
			}else{
				str += "<input type='hidden' name='check' id='check' value='1'>";
			}
			if(data.myLikeBoard.includes(data.dto.boardSeq)){
				str += "<a onclick='likeSubmit(" + data.dto.boardSeq + ")' style='color:red; cursor:pointer;'><i class='fas fa-heart'></i> Like</a>";
			}else{
				str += "<a onclick='likeSubmit(" + data.dto.boardSeq + ")' style='cursor:pointer;'><i class='fas fa-heart'></i> Like</a>";
			}
			str += "</form>";
			str += "<img src='${contextPath }/resources/images/liked-img.png' alt=''>";
			
			
			
			
			var ck = 0;
			var cnt = 0;
			data.likeCount.forEach((a)=>{
				if(a.boardSeq == data.dto.boardSeq){
					ck = 1;
					cnt = a.likeCount;
				}
			});
			
			if(ck == 1){
				str += "<span>" + cnt + "</span>";
			}else{
				str += "<span>0</span>";
			}
			
			likeList.innerHTML = str;
		}
	}
}

</script>
<script type="text/javascript" src="${contextPath}/resources/js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${contextPath}/resources/lib/slick/slick.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/scrollbar.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>
