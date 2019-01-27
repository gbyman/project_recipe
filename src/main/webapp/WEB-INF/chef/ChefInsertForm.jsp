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
<title>Insert title here</title>
</head>
<body>
<div class="login-block">
		<h1>레시피 등록</h1>
<div align="center">
	<form:form commandName="chef" method="post" action="insert.cf" enctype="multipart/form-data">
		
		
			<table>
				<tr>
			<td width="23%"><label for="csubject">요리이름</label></td>
			<td>
			<input type="text" name="csubject" id="csubject" value=""/>
			<form:errors cssClass="err" path="csubject"/></td>
		</tr>	
		
		<tr>
			<td><label for="cshortintro">간단한 설명</label></td>
			<td><input type="text" name="cshortintro" id="cshortintro" value="간단한 설명"/>
			<form:errors cssClass="err" path="cshortintro"/></td>
		</tr>	
		
		<tr>
			<td><label for="uploadcmainimage">메인 이미지</label></td>
			<td><input type="file" name="uploadcmainimage" id="uploadcmainimage" value=""/></td>
		</tr>	
		
		<tr>
			<td><label for="cingredient">재료</label></td>
		<td>	<textarea id="cingredient" name="cingredient" style="height:200px;width:380px;"
			></textarea></td>
		</tr>	
		
		<tr>
		<td>	<label for="cintro">설명</label></td>
		<td>	<textarea id="cintro" name="cintro" style="height:200px;width:380px;"
			>설명</textarea></td>
		</tr>		
		
		
		<tr>
		<td>	<label for="uploadcimage1">그림파일1</label></td>
		<td>	<input type="file" name="uploadcimage1" id="uploadcimage1" value=""/></td>
		</tr>	
		
		<tr>
		<td>	<label for="uploadcimage2">그림파일2</label></td>
		<td>	<input type="file" name="uploadcimage2" id="uploadcimage2" value=""/></td>
		</tr>	
		
		<tr>
		<td>	<label for="uploadcimage3">그림파일3</label></td>
		<td>	<input type="file" name="uploadcimage3" id="uploadcimage3" value=""/></td>
		</tr>	
		
		<tr>
		<td>	<label for="uploadcimage4">그림파일4</label></td>
		<td>	<input type="file" name="uploadcimage4" id="uploadcimage4" value=""/></td>
		</tr>	
		
		<tr>
		<td colspan="2">
			<input type="submit" value="추가하기" id="insert"/></td>
		</tr>	
	</table>
		
		
	
		
	</form:form>
</div>
</div>
</body>
<%@include file="../MainBottom.jsp" %>
</html>