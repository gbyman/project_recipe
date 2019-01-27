<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">

function readURL(input) {
   if (input.files && input.files[0]) {
       var reader = new FileReader();
       
       reader.onload = function (e) {
           $('#blah').attr('src', e.target.result);
       }
       
       reader.readAsDataURL(input.files[0]);
       $('#profileSubmitBtn').prop('disabled',false);
   }
}
$(function(){
	$("#file_1").change(function(){
		readURL(this);
	});	
})

function deleteProfile(){
	$('#profileSubmitBtn').prop('disabled',false);
	$('#blah').attr('src', '${pageContext.request.contextPath }/resources/img/basic.png');
}
</script>
</head>
<body>
<form action="profile.mem" method="post" enctype="multipart/form-data">
<div id="vProfileImageModal" class="modal" role="dialog" aria-hidden="true">
      <div class="modal-dialog" style="width:570px">
        <div class="modal-content" style="padding:0;">
          <div class="modal-header">
            <h4 class="modal-title">프로필 사진 편집</h4>
          </div>
          <div class="modal-body" style="padding:10px;text-align:center;">
          		<c:if test="${img!='basic.png' }">
                	<img id="blah" src="${pageContext.request.contextPath }/resources/img/${tid}Profile/${img}" style="max-width:550px;max-height:500px;">
                </c:if>
                <c:if test="${img=='basic.png' }">
                	<img id="blah" src="${pageContext.request.contextPath }/resources/img/basic.png" style="max-width:550px;max-height:500px;">
                </c:if>
            <div style="margin-top:10px;">
            <input type="hidden" name="tid" value="${tid }">
            <input type="file" name="newfile" id="file_1" style="display:none;" />
            <input type="hidden" name="img" value="${img }">
            <button type="button" onClick="document.getElementById('file_1').click();" class="btn btn-primary">프로필 사진 바꾸기</button>
            <button type="button" onClick="deleteProfile()" class="btn btn-primary">프로필 사진 지우기</button>
            <button type="submit" id="profileSubmitBtn" " class="btn btn-primary" disabled="disabled">저장</button>
            </div>
                    </div>
        </div>
      </div>
    </div>
</form>
</body>
</html>