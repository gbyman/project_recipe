<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Montserrat;
}

.login-block {
	width: 500px;
	padding: 20px;
/* 	background: #FFC0CB; */
	border:solid #FFC0CB;
	
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

.login-block input#name {
	width: 50%;
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

.login-block input#hp1,#hp2,#hp3 {
	width: 25%;
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

.login-block input:focus {
	border: 1px solid #ff656c;
}

.login-block input#serch {
	width: 80%;
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

.login-block input#serch:hover {
	background: #ff7b81;
}
</style>
</head>
<body>
<br><br><br>
<div class="login-block" align="center">
환영합니다.<br>
회원 가입에 성공하였습니다<br>
<br>

<a href="mainPage.rec"><input type="button" id="serch" value="메인페이지"/></a>
<br><br>
<a href="login.mem"><input type="button" id="serch" value="로그인페이지"/></a>
</div> 
<br><br><br><br><br><br><br><br>

</body>
<%@ include file="../MainBottom.jsp" %>
</html>