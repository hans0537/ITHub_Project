<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">



<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>

<style>
.radio {
	padding-left: 20px;
}

</style>
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
										<h3>QnA 수정</h3>
										
										<form action="${contextPath }/qna/qnaUpdate" method="post" enctype="multipart/form-data">
											<input type="hidden" name="mqnaState" value = "0">
											<input type="hidden" name="mqnaSeq" value = "${mqdto.mqnaSeq}">
											<div class="cp-field">
												<h5>제목</h5>
											</div>
											<input type = "text" name ="mqnaTitle" value = "${mqdto.mqnaTitle}">
											<div class="cp-field">
												<h5>내용</h5>
											</div>
											<textarea id="summernote" class="summernote" name="mqnaContent">${mqdto.mqnaContent}</textarea>

											<div class="cp-field">
												<h5>분류</h5>
											</div>
											
											<div class="cp-field">
												<select name="scSeq">
													<c:forEach var="scdto" items="${sclist}">
														<option value = "${scdto.scSeq}">${scdto.scTitle}</option>
													</c:forEach>
												</select>
											</div>

											<div class="cp-field">
												<h5>첨부 파일</h5>
												<div class="cpp-fiel">
													<input type="file" name="file" size="400">
												</div>
											</div>
											
											<div class="save-stngs pd3">
												<ul>
													<li><button type="submit">QnA 수정하기</button></li>
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
    <script>
    $('#summernote').summernote({
        tabsize: 2,
        height: 400
      });
    </script>
	<script type="text/javascript" src="${contextPath }/resources/js/jquery.mCustomScrollbar.js"></script>
	<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>