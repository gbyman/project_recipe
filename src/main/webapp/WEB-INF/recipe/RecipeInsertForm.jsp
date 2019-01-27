<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.err{
		font-size : 9pt;
		color : red;
		font-weight : bold;
	}
	
	 
	
body {
	font-family: Montserrat;
}

.login-block {
	width: 770px;
	padding: 20px;
	background: #FFC0CB;
	border-radius: 5px;
	border-top: 5px solid #ff656c;
	margin: 0 auto;
}

.login-block h1 {
	text-align: center;
	color: #000;
	font-size: 18px;
	text-transform: uppercase;
	margin-top: 0;
	margin-bottom: 20px;
}

.login-block input, button {
	width: 100%;
	height: 42px;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 20px;
	font-size: 14px;
	font-family: Montserrat;
	padding: 0 20px 0 20px;
	outline: none;
}

.login-block input, button,textarea {
	width: 100%;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 20px;
	font-size: 14px;
	font-family: Montserrat;
	padding: 0 20px 0 20px;
	outline: none;
}

.login-block input:focus {
	border: 1px solid #ff656c;
}




.login-block select {
    width: 25%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
/*     padding: 0 20px 0 50px; */
    outline: none;
}

.login-block option {
    width: 25%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
/*     padding: 0 20px 0 50px; */
    outline: none;
}




.login-block input#insert {
	width: 100%;
	height: 40px;
	background: #ff656c;
	box-sizing: border-box;
	border-radius: 5px;
	border: 1px solid #e15960;
	color: #fff;
	font-weight: bold;
	text-transform: uppercase;
	font-size: 14px;
	font-family: Montserrat;
	outline: none;
	cursor: pointer;
}

.login-block input#insert:hover {
	background: #ff7b81;
}
</style>
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
<script type="text/javascript">

function readURL1(input) {
   if (input.files && input.files[0]) {
       var reader = new FileReader();
       
       reader.onload = function (e) {
           $('#img1').attr('src', e.target.result);
       }
       
       reader.readAsDataURL(input.files[0]);
   }
}
function readURL2(input) {
	   if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       
	       reader.onload = function (e) {
	           $('#img2').attr('src', e.target.result);
	       }
	       
	       reader.readAsDataURL(input.files[0]);
	   }
	}
function readURL3(input) {
	   if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       
	       reader.onload = function (e) {
	           $('#img3').attr('src', e.target.result);
	       }
	       
	       reader.readAsDataURL(input.files[0]);
	   }
	}
function readURL4(input) {
	   if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       
	       reader.onload = function (e) {
	           $('#img4').attr('src', e.target.result);
	       }
	       
	       reader.readAsDataURL(input.files[0]);
	   }
	}
function readURLmain(input) {
	   if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       
	       reader.onload = function (e) {
	           $('#mainimg').attr('src', e.target.result);
	       }
	       
	       reader.readAsDataURL(input.files[0]);
	   }
	}
$(function(){
	$("#uploadimage1").change(function(){
		readURL1(this);
	});
	$("#uploadimage2").change(function(){
		readURL2(this);
	});
	$("#uploadimage3").change(function(){
		readURL3(this);
	});
	$("#uploadimage4").change(function(){
		readURL4(this);
	});
	$("#uploadmainimage").change(function(){
		readURLmain(this);
	});
})

function deleteImg(){
	$('#img1').attr('src', 'http://recipe.ezmember.co.kr/img/pic_none3.gif');
	$('#img2').attr('src', 'http://recipe.ezmember.co.kr/img/pic_none3.gif');
	$('#img3').attr('src', 'http://recipe.ezmember.co.kr/img/pic_none3.gif');
	$('#img4').attr('src', 'http://recipe.ezmember.co.kr/img/pic_none3.gif');
	$('#mainimg').attr('src', 'http://recipe.ezmember.co.kr/img/pic_none3.gif');
}
</script>
<title>레시피 등록</title>
</head>
<body>


	<div class="login-block">
		<h1>레시피 등록</h1>

<div align="center">
	<form:form commandName="recipe" method="post" action="insert.rec" enctype="multipart/form-data">
		<table>
			<tr>
			
		
		<!-- 요리 분류의 value 값 숫자로    -->
			<td><label for="theme">요리 분류</label>	</td>
				<td colspan="4"><select name="theme" id="theme" >
					<option value="" selected>선택</option>
					<option value="1">밥요리</option>
					<option value="2">면요리</option>
					<option value="3">디저트</option>
					<option value="4">구이</option>
					<option value="5">간식</option>
					<option value="6">튀김</option>
					<option value="7">샐러드</option>
					<option value="8">도시락</option>
					<option value="9">찌개&전골</option>
					<option value="10">술안주</option>
					<option value="11">술&칵테일</option>
				</select>
			<form:errors cssClass ="err" path="theme"/> </td>
		</tr>	
		
	<tr>
			<td width="20%"><label for="psubject">요리이름</label></td>
			<td colspan="4"><input type="text" name="psubject" id="psubject" value=""/>
			<form:errors cssClass="err" path="psubject"/></td>
		</tr>	
		
		<tr>
			<td><label for="intro">요리 설명</label></td>
			<td colspan="4"><textarea name="intro" id="intro" placeholder="요리 소개를 써주세요" style="height:100px; width:500px; resize:none;"></textarea>
			<form:errors cssClass="err" path="shortintro"/></td>
		</tr>	
		
		<tr>
			<td><label for="uploadmainimage">메인 이미지</label></td>
			<td colspan="4"><input type="file" name="uploadmainimage" id="uploadmainimage" style="display:none;"/>
				<img src="http://recipe.ezmember.co.kr/img/pic_none3.gif" alt="파일첨부" width="140" height="140" onclick="document.getElementById('uploadmainimage').click();" style="cursor:pointer;" id="mainimg"/>
			</td>
		</tr>	
		
		<tr>
		<td>	<label for="video_url">동영상</label></td>
		<td colspan="3">	<textarea name="movieurl" id="video_url" class="form-control step_cont" prev_url="" placeholder="동영상이 있으면 주소를 입력하세요.(Youtube,네이버tvcast,다음tvpot 만 가능) 예)http://youtu.be/lA0Bxo3IZmM" style=" height:100px; resize:none;"></textarea></td>
		<td>
			<img id="videoPhotoHolder" src="http://recipe.ezmember.co.kr/img/pic_none5.gif" style="width: 177px; height: 100px;display:inline-block;margin-left:10px;">
		</td>
		</tr>	

		<tr>
		<td>	<label for="uploadimage1">완성 이미지</label></td>
		<td>	<input type="file" name="uploadimage1" id="uploadimage1" style="display:none;"/>
				<img src="http://recipe.ezmember.co.kr/img/pic_none3.gif" alt="파일첨부" width="140" height="140" onclick="document.getElementById('uploadimage1').click();" style="cursor:pointer;" id="img1"/>
		</td>
		<td>	<input type="file" name="uploadimage2" id="uploadimage2" style="display:none;"/>
				<img src="http://recipe.ezmember.co.kr/img/pic_none3.gif" alt="파일첨부" width="140" height="140" onclick="document.getElementById('uploadimage2').click();" style="cursor:pointer;" id="img2"/>
		</td>
		<td>	<input type="file" name="uploadimage3" id="uploadimage3" style="display:none;"/>
				<img src="http://recipe.ezmember.co.kr/img/pic_none3.gif" alt="파일첨부" width="140" height="140" onclick="document.getElementById('uploadimage3').click();" style="cursor:pointer;" id="img3"/>
		</td>
		<td>	<input type="file" name="uploadimage4" id="uploadimage4" style="display:none;"/>
				<img src="http://recipe.ezmember.co.kr/img/pic_none3.gif" alt="파일첨부" width="140" height="140" onclick="document.getElementById('uploadimage4').click();" style="cursor:pointer;" id="img4"/>
		</td>
		</tr>	
		
		<tr>
			<td><button type="button" onClick="deleteImg()" class="btn btn-primary">사진 지우기</button></td>
		</tr>
		<tr>
		<td colspan="5">
			<input type="submit" value="추가하기" id="insert"/></td>
		</tr>	
	</table>
	</form:form>
</div>
</div>
</body>
<%@include file="../MainBottom.jsp" %>
</html>