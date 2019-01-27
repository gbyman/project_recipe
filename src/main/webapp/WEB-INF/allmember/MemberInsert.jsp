<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../MainTop.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 페이지</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/MemberInsert.js"></script>
<style type="text/css">
   .err{
   font-size: 9pt;
   color: red;
   font-weight: bold;
   }
   .great{
   font-size: 9pt;
   color: green;
   font-weight: bold;
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

.login-block input,button {
    width: 45%;
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


.login-block input:active, .login-block input:focus {
    border: 1px solid #ff656c;
}

.login-block input#insert,#serch,#ch {
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

.login-block input#insert:hover,#serch:hover,#ch:hover {
    background: #ff7b81;
} 
</style>
</head>
<body>
<div class="login-block">
<h1>회원 가입</h1>
   <form method="post" action="insert.mem" onsubmit="return writecheck()"> 
   <hr>
   필수사항
    <hr>
    <table>
    <tr>
    <td>

    
         <label for="id">아이디</label>
         </td>
         <td>
         <input type="text" name="id" id="id" placeholder="아이디 입력" >
         <input type="button" value="중복확인" onclick="dupCheck()" style="width:20%" id="ch" >
		 <span style="display: none;" id="idmessage"></span>
		 <td>
      
      </tr>
       <tr>
        <td>
         <label for="password">비밀번호</label>
         </td>
         <td>
         <input type="password" placeholder="비밀번호 입력" name="password" id="password">
         </td>
    </tr>
       <tr>
       <td>
         <label for="repw">비밀번호 확인</label>
         </td>
         <td>
		<input type="password" placeholder="비밀번호 입력확인" name="repw" id="repw" onkeyup="pwCheck()">
		<span style="display: none;" id="pwmessage"></span>
		</td>
     </tr>
      
       <tr>
       <td>
         <label for="nickname">별명</label>
        </td><td> <input type="text" name="nickname" id="nickname" placeholder="별명 입력">
        </td>
     </tr>
      
      
       <tr>
        <td>
         <label for="name">이름</label>
        </td> 
        <td> <input type="text" name="name" id="name" placeholder="이름 입력"></td>
    </tr>
      
       <tr>
       <td>
         <label for="hp1">핸드폰번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label></td>
         <td>
        <select name="hp1" id="hp1">
						<option value="">선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select>&nbsp;-
         <input type="text" name="hp2" id="hp2" maxlength="4" style="width:20%" >&nbsp;-
         <input type="text" name="hp3" id="hp3" maxlength="4"style="width:20%" >
      </td>
      </tr>
      
      
        <tr>
        <td>
         <label for="email1">이메일</label>
         </td>
         <td>
         
         <input type="text" name="email1" id="email1">@
         <input type="text" name="email3" style="display:none;">
			<select name="email2" onchange="insertEmail(this)" id="mail" style="width:30%">
				<option value="">선택</option>
				<option value="naver.com">naver.com</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="daum.net">daum.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>
				<option value="hotmail.com">hotmail.com</option>
				<option value="insert">직접입력</option>
			</select>
         
         </td>
      </tr>
      <tr>
      <td colspan="2">
      <hr>
      선택사항
      <hr>
      </td>
      </tr>
      
      
</table>
   <table>
       <tr>
       <td width="20%">
     
         <label for="postnumber" >우편번호</label>
      </td>
         <td colspan="2">
         <input type="text"  name="postnumber" id="postnumber" style="width:40%">
   
         <input type="button" value="우편번호찾기" onclick="openDaumPostcode()"style="width:30%" id="serch">
      </td>
      </tr>
      <tr>
       <td>
         <label for="address1">주소</label> 
         </td> <td colspan="2">
         <input type="text" name="address1" id="address1"style="width:40%" >
         <input type="text" name="address2" id="address2" style="width:40%">
       </td>
      </tr>
     
      <tr>
       <td>
         <label for="year">생년월일</label></td> <td colspan="2">
         <input type="text" name="year" id="year" style="width:20%" >년
         <input type="text" name="month" id="month" style="width:20%" >월
         <input type="text" name="day" id="day" style="width:20%" >일
       </td>
      </tr>
    
         
      <tr>
       <td>
         <label for="gender">성별</label> </td><td>
         <input type="radio" name="gender"  value="man" style="size: auto;">남</td><td>
         <input type="radio" name="gender"  value="woman">여
       </td>
      </tr>
   
      <tr>
       <td colspan="3" align="center">
         <input type="submit" value="가입하기" id="insert">      
       </td>
      </tr>  
    </table>
   </form>
</div>
</body>
<%@include file="../MainBottom.jsp" %>
</html>
