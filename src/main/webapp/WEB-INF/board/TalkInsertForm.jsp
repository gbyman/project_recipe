<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){

	$("#video_url").blur(function() {
        if ($(this).val() != '' && $(this).val() != $(this).attr('prev_url')) {
            if ($(this).val().indexOf('http://') > -1 || $(this).val().indexOf('https://') > -1) {
                getVideoThumb($.trim($(this).val()));
            } else {
            	alert("주소형식이 맞지않습니다.");
                delVideoPhoto();
            }
        } else if ($.trim($(this).val()) == '' || ($(this).val().indexOf('http://') < 0 && $(this).val().indexOf('https://') < 0)) {
        	alert("주소형식이 맞지않습니다.");
            delVideoPhoto();
        } 
    });

});

function getVideoThumb(url){
	var str=url.substring(17,28);
	console.log(str);
	var thumb='http://img.youtube.com/vi/'+str+'/0.jpg';
	console.log(thumb);
	$("#videoPhotoHolder").attr('src',thumb);
	
}

function delVideoPhoto(){
    $("#video_url").val('');
    $("#videoPhotoHolder").attr('src','http://recipe.ezmember.co.kr/img/pic_none5.gif');
}

</script>

</head>
<body>
<div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">토크 등록하기
        <small>소통해보아요</small>
      </h1>
	<div class="col-lg-8 mb-4">
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">함께 하고픈 다양한 요리 이야기를 남겨주세요.</li>
      </ol>
	</div>

      <!-- Contact Form -->
      <!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
      <div class="row">
        <div class="col-lg-8 mb-4">
          <form action="<%=contextPath %>/talk/insert.bod" method="post" id="contactForm" enctype="multipart/form-data">
            <div class="control-group form-group">
              <div class="controls">
                <label>내용</label>
                <textarea rows="10" cols="100" class="form-control" name="tcontent" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
              </div>
            </div>
            
            <div class="control-group form-group">
              <div class="controls">
                <label>동영상 주소 입력란</label>
                <textarea name="tmovie" id="video_url" class="form-control step_cont" prev_url="" placeholder="동영상이 있으면 주소를 입력하세요.(Youtube,네이버tvcast,다음tvpot 만 가능) 예)http://youtu.be/lA0Bxo3IZmM" style="height:100px; width:500px; resize:none;"></textarea>
              </div>
                 <img id="videoPhotoHolder" src="http://recipe.ezmember.co.kr/img/pic_none5.gif" style="width: 177px; height: 100px;display:inline-block;margin-left:10px;">
            </div>
            
            <div class="control-group form-group">
              <div class="controls">
                <input type="file" name="tUploader" id="file_1"/>
                </div>
             </div>  
            
                
            <div id="success"></div>
            <!-- For success/fail messages -->
            <button type="submit" class="btn btn-primary" id="sendMessageButton">등록</button>
          </form>
        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
</body>
<%@ include file="../MainBottom.jsp" %>
</html>