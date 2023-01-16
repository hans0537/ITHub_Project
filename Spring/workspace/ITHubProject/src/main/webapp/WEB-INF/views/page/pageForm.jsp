<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">
</head>

<script>
$(document).ready(function(){
	 
    // 라디오버튼 클릭시 이벤트 발생
    $("input:radio[name=pType]").click(function(){
 
        if($("input[name=pType]:checked").val() == "1"){
            $(".tlqkf").attr("disabled",true);
 
        }else if($("input[name=pType]:checked").val() == "0"){
              $(".tlqkf").attr("disabled",false);
        }
    });
});

function check(f) {
	if(f.pName.value === ""){
		alert("Name 을 입력 하세요!!");
		f.pName.focus();
		return false;
	}else if(f.pLink.value === ""){
		alert("Link 를 입력 하세요!!");
		f.pLink.focus();
		return false;
	}else if(f.pEmpcnt.value === 0){
		alert("직원수를 입력 하세요");
		f.pEmpcnt.focus();
		return false;
	}else if(f.mFirstname.value === ""){
		alert("이름을 입력 하세요!!");
		f.mFirstname.focus();
		return false;
	}else {
		return true;
	}
}

</script>
<body>	
	<div class="wrapper">	
		<%@ include file="/WEB-INF/views/layout/navbar.jsp" %>
		<section class="profile-account-setting">
			<div class="container">
				<div class="account-tabs-setting">
					<div class="row">
						<div class="col-lg-12">
							<div class="tab-content" id="nav-tabContent">
							  	<div class="tab-pane fade active show" id="nav-deactivate" role="tabpanel" aria-labelledby="nav-deactivate-tab">
							  		<div class="acc-setting">
										<h3>Create a Page</h3>
										<form action="${contextPath}/page/create" method="post" onsubmit="return check(this)" enctype="multipart/form-data">
											<div class="cp-field">
												<h5>Page Type</h5>
											</div>
											
											<div style="position: relative; left: 20px; top: 10px; font-size: 20px;">
												<input type="radio" id="r0" name="pType" value="0" checked>&nbsp;회사
												&nbsp;&nbsp;
												<input type="radio" id="r1" name="pType" value="1">&nbsp;학교
											</div>
									
											<div class="cp-field">
												<h5>회사</h5>
												<div class="cpp-fiel">
													<input type="text" name="pName" placeholder="name">
												</div>
											</div>
											
											<div class="cp-field">
												<h5>홈페이지</h5>
												<div class="cpp-fiel">
													<input type="text" name="pLink" placeholder="link">
												</div>
											</div>
											
											<div class="cp-field">
												<h5>업계</h5>
												<div class="cpp-fiel">
													<select name="iSeq" id="iSeq">
														<c:forEach var="ind" items="${industry }">
														<option value="${ind.iSeq }"> ${ind.iName } </option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="cp-field">
												<h5>직원수</h5>
												<div class="cpp-fiel">
													<input type="number" name="pEmpcnt" placeholder="0">
												</div>
											</div>
											
											<div class="cp-field">
												<h5>단체 종류</h5>
												<div class="cpp-fiel">
													<select name="ptypeSeq" id="iSeq" class="tlqkf">
														<c:forEach var="ptype" items="${pagetype }">
														<option value="${ptype.ptypeSeq }"> ${ptype.ptypeName } </option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="cp-field">
												<h5>로고 사진</h5>
												<div class="cpp-fiel">
													<input type="file" name="logo" size="400">
												</div>
											</div>
											
											<div class="cp-field">
												<h5>한줄 소개</h5>
												<div class="cpp-fiel">
													<input type="text" name="pInfo" placeholder="한줄 소개">
												</div>
											</div>

									
											<div class="save-stngs pd3">
												<ul>
													<li><button type="submit">페이지 생성</button></li>
													<li><button type="reset">초기화</button></li>
												</ul>
											</div><!--save-stngs end-->
										</form>
									</div><!--acc-setting end-->
							  	</div>
							</div>
						</div>
					</div>
				</div><!--account-tabs-setting end-->
			</div>
		</section>
		<%@ include file="/WEB-INF/views/layout/footer.jsp" %>

	</div><!--theme-layout end-->

	
	<script type="text/javascript" src="${contextPath }/resources/js/jquery.mCustomScrollbar.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>