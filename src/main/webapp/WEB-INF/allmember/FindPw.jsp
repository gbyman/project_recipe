<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비번찾기</title>
</head>
<body>

<form action="findpw.mem" method="post">
	아이디<input type="text" name="id"><br>
	이름<input type="text" name="name"><br>
	휴대폰번호<input type="text" name="hp1">-<input type="text" name="hp2">-<input type="text" name="hp3"><br>
	<input type="submit" value="비번찾기">
</form>

</body>
<%@include file="../MainBottom.jsp" %>
</html>