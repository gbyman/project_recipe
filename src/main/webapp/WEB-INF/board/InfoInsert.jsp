<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../MainTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/MemberInsert.js"></script>



<style type="text/css">

body {
	font-family: Montserrat;
}

.login-block {
	width: 650px;
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

</head>
<body>

	<div class="login-block">
		<h1>요리정보 등록</h1>
		
		<form method="post" action="infoinsert.bod" enctype="multipart/form-data">


			<table>
			<tr>
			<td><label for="infokind">정보종류</label></td>
			<td>
			 <select name="infokind" id="infokind">
						
						<option value="image">매거진&뉴스</option>
						<option value="movie">올레시피TV</option>
					
					</select>
	
        			 </td>
				</tr>	
			
			
				<tr>
					<td width="20%"><label for="infosubject">제목</label></td>
					<td><input type="text" name="infosubject" id="infosubject"></td>

				</tr>
				<tr>
					<td><label for="infointro">내용</label></td>
					
					<td>
					<textarea name="infointro" id="infointro" rows="13" cols="50"  placeholder="내용입력해주세요"></textarea>
					
					</td>
					
				
				<tr>
					<td><label for="infoimage">사진</label></td>
					<td><input type="file" name="upload" id="upload">
					</td>
				</tr>
			

				<tr>
					<td><label for="infomovie">동영상</label></td>
					<td>
					
					<textarea name="infomovie" id="infomovie" rows="7" cols="20" placeholder="동영상"></textarea>
					

				</tr>
	<tr>
       <td colspan="2" align="center">
         <input type="submit" value="등록하기" id="insert">      
       </td>
      </tr>

			</table>
		</form>
	</div>
</body>
<%@include file="../MainBottom.jsp"%>
</html>
