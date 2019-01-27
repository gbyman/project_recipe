<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../MainTop.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디찾기</title>
<style type="text/css">
body {
	font-family: Montserrat;
}

.login-block {
	width: 500px;
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

.login-block input#serch:hover {
	background: #ff7b81;
}
</style>
</head>
<body>
<br><br><br>
<div class="login-block">
<h1>아이디찾기</h1>
	<form action="findid.mem" method="post">
		<table>
			<tr>
				<td width="22%">이름</td><td><input type="text" name="name" id="name">
				</td>
			</tr>
			<tr>
				<td>휴대폰번호</td><td><input type="text" name="hp1" id="hp1">&nbsp;-&nbsp;<input
					type="text" name="hp2"id="hp2">&nbsp;-&nbsp;<input type="text" name="hp3"id="hp3">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="찾기" id="serch"></td>
			</tr>
		</table>
	</form>
</div> 
<br><br><br><br><br><br><br><br>
</body>
<%@include file="../MainBottom.jsp"%>
</html>