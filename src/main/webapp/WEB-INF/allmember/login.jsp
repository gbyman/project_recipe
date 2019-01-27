<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login page</title>

<script type="text/javascript">
 $(function(){
	$("#insert").click(function(){
		location.href="insert.mem";	
	});
	$("#findid").click(function(){
		location.href="findid.mem";
	});
	$("#findpw").click(function(){
		location.href="findpw.mem";
	});
})

</script>
<style type="text/css">

body {
    font-family: Montserrat;
}



.login-block {
    width: 320px;
    padding: 20px;
    background:  #FFC0CB ;
    border-radius: 5px;
    border-top: 5px solid #ff656c ;
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

.login-block input {
    width: 100%;
    height: 42px;
    box-sizing: border-box;
    border-radius: 5px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    font-size: 14px;
    font-family: Montserrat;
    padding: 0 20px 0 50px;
    outline: none;
}

.login-block input#username {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#username:focus {
    background: #fff url('http://i.imgur.com/u0XmBmv.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input#password {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px top no-repeat;
    background-size: 16px 80px;
}

.login-block input#password:focus {
    background: #fff url('http://i.imgur.com/Qf83FTt.png') 20px bottom no-repeat;
    background-size: 16px 80px;
}

.login-block input:active, .login-block input:focus {
    border: 1px solid #ff656c;
}

.login-block input#login,#insert,#findid,#findpw {
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

.login-block input#login:hover,#insert:hover,#findid:hover,#findpw:hover {
    background: #ff7b81;
}

</style>
</head>



<body>



<div class="login-block">
		
    <h1>로그인</h1>
  	<form action="login.mem" method="post">
  	<input type="text" name="id" placeholder="아이디" value="${userid }"id="username"  >
	<input type="password" name="password" placeholder="비밀번호" value="${userpw }"id="password" >
	<input type="submit" value="로그인" id="login">
	<input type="button" value="회원가입" id="insert">
	<input type="button" value="아이디찾기" id="findid">
	<input type="button" value="비번찾기" id="findpw"> 

    </form>
</div>

</body>
<%@include file="../MainBottom.jsp" %>
</html>