<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

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
<body>


	<div class="login-block">
		

<div align="center">
	<h1>레시피 등록</h1>
	<form:form commandName = "product" method="post" action ="insert.mt" enctype="multipart/form-data">
		<table>
		
			<tr>
			<td><label for="pkind">정보종류</label></td>
			<td>
			 <select name="pkind" id="pkind">
						
						<option value="pkind1">과일</option>
						<option value="pkind2">채소</option>
						<option value="pkind3">쌀</option>
						<option value="pkind4">수산</option>
						<option value="pkind5">정육</option>
						<option value="pkind6">유제품</option>
						<option value="pkind7">가공식품</option>
										
					</select>
	
        			 </td>
				</tr>	
		
		
			<tr>
			
		
		<!-- 요리 분류의 value 값 숫자로    -->
			<td><label for="pname">상품 이름</label></td>
				<td><input type="text" name="pname" id="pname" value=""/>
			<form:errors cssClass = "err" path = "pname"/></td>
		</tr>	
		
		
		
	<tr>
			<td width="20%"><label for="price">가격</label></td>
			<td><input type="text" name="price" id="price" value=""/>
			<form:errors cssClass = "err" path = "price"/></td>
		</tr>	
		
		<tr>
			<td><label for="stock">재고</label></td>
			<td><input type="text" name="stock" id="stock" value=""/>
			<form:errors cssClass = "err" path = "stock"/></td>
		</tr>	
		
		<tr>
			<td><label for="company">제조 회사</label></td>
			<td><input type="text" name="company" id="company" value=""/></td>
		</tr>	
		
		<tr>
			<td><label for="origin">원산지</label></td>
		<td><input type="text" name="origin" id="origin" value=""/>
			<form:errors cssClass = "err" path = "origin"/></td>
		</tr>	
		
		<tr>
		<td>	<label for="uploadpimage">상품 이미지</label></td>
		<td>	<input type="file" name="uploadpimage" id="uploadpimage" value=""/></td>
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