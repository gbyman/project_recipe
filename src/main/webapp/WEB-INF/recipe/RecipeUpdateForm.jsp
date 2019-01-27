<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<c:set var="uploadmainimage" value="http://localhost:9090${pageContext.request.contextPath }/resources/recipe/${recipe.mainimage }"/>
<c:set var="uploadimage1" value="http://localhost:9090${pageContext.request.contextPath }/resources/recipe/${recipe.image1 }"/>
<c:set var="uploadimage2" value="http://localhost:9090${pageContext.request.contextPath }/resources/recipe/${recipe.image2 }"/>
<c:set var="uploadimage3" value="http://localhost:9090${pageContext.request.contextPath }/resources/recipe/${recipe.image3 }"/>
<c:set var="uploadimage4" value="http://localhost:9090${pageContext.request.contextPath }/resources/recipe/${recipe.image4 }"/>

<body>

	<div class="login-block">
		<h1>레시피 수정</h1>


<div align="center">
	<form:form commandName="recipe" method="post" action="update.rec" enctype="multipart/form-data">
			<table>
		
		<tr><!-- 요리 분류의 value 값 숫자로   12.15 현재 술&칵테일만 선택됨 -->
			<td width="20%"><label for="theme">요리 분류</label>
				<input type="hidden" name="recnum" value="${recipe.recnum}"/></td>
			<td>	<select name="theme" id="theme" >
					<option value="" selected>선택</option>
					<option value="1" <c:if test="${recipe.theme == 1 }"/> selected>밥요리</option>
					<option value="2" <c:if test="${recipe.theme == 2 }"/> selected>면요리</option>
					<option value="3" <c:if test="${recipe.theme == 3 }"/> selected>디저트</option>
					<option value="4" <c:if test="${recipe.theme == 4 }"/> selected>구이</option>
					<option value="5" <c:if test="${recipe.theme == 5 }"/> selected>간식</option>
					<option value="6" <c:if test="${recipe.theme == 6 }"/> selected>튀김</option>
					<option value="7" <c:if test="${recipe.theme == 7 }"/> selected>샐러드</option>
					<option value="8" <c:if test="${recipe.theme == 8 }"/> selected>도시락</option>
					<option value="9" <c:if test="${recipe.theme == 9 }"/> selected>찌개와전골</option>
					<option value="10" <c:if test="${recipe.theme == 10 }"/> selected>술안주</option>
					<option value="11" <c:if test="${recipe.theme == 11 }"/> selected>술과칵테일</option>
				</select>
			<form:errors cssClass = "err" path="theme"/></td>
		</tr>
		
		<tr>
		<td>	<label for="psubject">요리이름</label></td>
		<td>	<input type="text" name="psubject" id="psubject" value="${recipe.psubject }"/>
			<form:errors cssClass="err" path="psubject"/></td>
		</tr>
		
		<tr>
		<td>	<label for="shortintro">간단한 설명</label></td>
		<td>	<input type="text" name="shortintro" id="shortintro" value="${recipe.shortintro }"/></td>
		</tr>
		
		<tr>
		<td>	<label for="uploadmainimage">메인 이미지</label></td>
		<td>	<img src="${uploadmainimage }" width="250" height="250"/><br>
			<input type="file" name="uploadmainimage" id="uploadmainimage" value=""/></td>
		</tr>
		
		<tr>
			<td><label for="ingredient">재료</label></td>
			<td><textarea id="ingredient" name="ingredient" style="height:200px;width:380px;"
			><c:out value="${recipe.ingredient}"/></textarea></td>
		</tr>
		
		<tr>
		<td>	<label for="intro">설명</label></td>
		<td>	<textarea id="intro" name="intro" style="height:200px;width:380px;"
			><c:out value="${recipe.intro}"/></textarea></td>
		</tr>	
		
		<tr>
		<td>	<label for="movieurl">동영상</label></td>
		<td>	<input type="text" name="movieurl" id="movieurl" value="${recipe.movieurl }"/></td>
		</tr>

		<tr>
		<td>	<label for="uploadimage1">그림파일1</label></td>
		<td>	<img src="${uploadimage1 }"/><br>
			<input type="file" name="uploadimage1" id="uploadimage1" value=""/></td>
		</tr>
		
		<tr>
		<td>	<label for="uploadimage2">그림파일2</label></td>
		<td>	<img src="${uploadimage2 }"/><br>
			<input type="file" name="uploadimage2" id="uploadimage2" value=""/></td>
		</tr>
		
		<tr>
		<td>	<label for="uploadimage3">그림파일3</label></td>
		<td>	<img src="${uploadimage3 }"/><br>
			<input type="file" name="uploadimage3" id="uploadimage3" value=""/></td>
		</tr>
		
		<tr>
		<td>	<label for="uploadimage4">그림파일4</label></td>
		<td>	<img src="${uploadimage4 }"/><br>
			<input type="file" name="uploadimage4" id="uploadimage4" value=""/></td>
		</tr>
		
		
		<tr class="btnRow">
		<td colspan="2" align="center">
			<input type="submit" value="수정하기" id="insert"/>
			<input type="button" value="레시피" onclick="goList();"id="insert"/>
			<input type="button" value="메인화면" onclick="goHome();"id="insert"/>
		</td>
		</tr>
	</table>		
	</form:form>
</div>
</div>
</body>

<script type="text/javascript">
function goList(){// 버튼 누르면 레시피로 이동
	location.href='list.rec'; //get 방식
}

function goHome(){//홈으로 이동
	location.href = 'mainPage.rec';
}

</script>

<%@include file="../MainBottom.jsp" %>
</html>