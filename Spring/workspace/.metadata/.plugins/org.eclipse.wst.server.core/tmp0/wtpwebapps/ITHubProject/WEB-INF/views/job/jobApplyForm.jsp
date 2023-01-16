<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.min.css">
<script>
	function back(){
		alert("myPage로~~")
		location.href='javascript:history.back();';
	}
	
	function check(f) {
		if(!f.file.value){
			alert("이력서를 첨부 해주세요!");
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<div id="mymodal">
        <div class="modal-dialog">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="text-light text-center">지원서</h3>
                </div>
                <div class="modal-body">
                    <div class="innerbody apply-jobbox">
                        <h3>지원 양식</h3>
                        <form action = "${contextPath}/job/jobApply" method = "post" onsubmit="return check(this)" enctype = "multipart/form-data">
                            <input type="hidden" name="jpostSeq" value = "${jdto.jpostSeq}">
                            <input type="hidden" name="mSeq" value="${dto.mSeq }">
							<span style="float: left; font-size: 30px; font-weight: bold;">${jdto.pName }</span>
							<img style="float: right; border: 1px solid black;" height="50px" width="50px" src="${contextPath}/resources/upload/${jdto.pPic}"	alt="">
                        	
                        	<input type="text" name="jpostName" value="${jdto.jpostName }" disabled> 
                        	<input type="text" name="posName" value="${jdto.posName }" disabled> 
                            <input type="text" name="mName" value = "${dto.mLastname}${dto.mFirstname}" disabled><br>
                            <input type="text" name="mEmail" value = "${dto.mEmail}" disabled>
	                        <div class="select-files">
								<input type="file" name="file" class="custom-file-inputs">
	                        </div>
                       		<div class="modal-footer">
		                    	<button type="submit">지원하기</button>
		                    	<button type="button" onclick = "back()">뒤로가기</button>
              			  	</div>
                        </form>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
<script type="text/javascript" src="${contextPath }/resources/js/jquery.mCustomScrollbar.js"></script>
<script type="text/javascript" src="${contextPath }/resources/lib/slick/slick.min.js"></script>

<%@ include file="/WEB-INF/views/layout/footJs.jsp" %>