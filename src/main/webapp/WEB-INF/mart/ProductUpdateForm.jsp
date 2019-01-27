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
<c:set var="uploadpimage" value="http://localhost:9090${pageContext.request.contextPath }/resources/mart/${product.pimage }"/>
</head>

<body>
<div class="login-block">
		<h1>상품 수정</h1>
<div align = "center">
	<form:form commandName = "product" method="post" action="update.mt" enctype="multipart/form-data">
	
		<input type="hidden" name ="pnum" value="${product.pnum }"/>
					<table>
		<tr>
		<td  width="23%">
			<label for="pname">상품명</label></td>
		<td>	<input type="text" name="pname" id="pname" value="${product.pname} "/>
			<form:errors cssClass="err" path="pname"/></td>
		</tr>
		
		<tr>
		<td>	<label for="price">가격</label></td>
		<td>	<input type="text" name="price" id="price" value="${product.price} "/>
			<form:errors cssClass="err" path="price"/></td>
		</tr>
		
		<tr>
		<td>	<label for="stock">재고</label></td>
		<td>	<input type="text" name="stock" id="stock" value="${product.stock} "/>
			<form:errors cssClass="err" path="stock"/></td>
		</tr>
		
		<tr>
		<td>	<label for="company">제조회사</label></td>
		<td>	<input type="text" name="company" id="company" value="${product.company} "/></td>
		</tr>
		
		<tr>
		<td>	<label for="origin">원산지</label></td>
		<td>	<input type="text" name="origin" id="origin" value="${product.origin} "/>
			<form:errors cssClass="err" path="origin"/></td>
		</tr>
		
		<tr>
		<td>	<label for="uploadpimage">상품 이미지</label></td>
		<td>	<img src = "${uploadpimage }" width="250px" height="250px"/><br>
			<input type="file" name="uploadpimage" id="uploadpimage" value=""/>
			<input type="hidden" name="pimage" id="uploadpimage" value="${product.pimage }"/></td>
		</tr>
		<tr>
		<td colspan="2">
		
			<input type="submit" value="수정하기" id="insert"/>
			<input type="button" value="목록보기" id="insert" onclick="goList();"/>
			<input type="button" value="메인화면" id="insert"  onclick="goHome();"/>
		</td></tr>
	</table>
	</form:form>
</div>
</div>
</body>
<script type="text/javascript">
function goList(){// 버튼 누르면 레시피로 이동
	location.href='list.mt'; //get 방식
}

function goHome(){//홈으로 이동
	location.href = 'mainPage.rec';
}

</script>

<%@include file="../MainBottom.jsp" %>
</html>