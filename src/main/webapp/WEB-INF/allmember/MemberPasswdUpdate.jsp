<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function pwCheck(){
	if($("input[name=password]").val()!=$("input[name=repw]").val()){
		$("#pwmessage").html("위의 비밀번호와 일치하지않습니다.");
		$("#pwmessage").addClass('err');
		$("#pwmessage").show();
	}else{
		$("#pwmessage").css('display','none');
	}
}
function check(){
	if($("input[name=password]").val()==""){
		alert("패스워드를 입력하세요.");
		$("input[name=password]").focus();
		return false;
	}else{
		var str=/^[a-zA-Z0-9]{3,8}$/;
		var pw=$("input[name=password]").val();
		if(!str.test(pw)){
			alert("비밀번호 형식이 틀렸습니다.");
			return false;
		}
		var chk_num=pw.search(/[0-9]/g);
		var chk_eng=pw.search(/[a-z]/ig);
		if(chk_num<0||chk_eng<0){
			alert("비밀번호는 영문자와 숫자를 조합해 주세요.");
			return false;
		}
	}
	
	if($("input[name=repw]").val()==""){
		alert("패스워드 재확인을 해주세요.");
		$("input[name=repw]").focus();
		return false;
	}
	if($("input[name=password]").val()!=$("input[name=repw]").val()){
		alert("패스워드가 서로 다릅니다.");
		$("input[name=password]").focus();
		return false;
	}
}
</script>
<style type="text/css">
   .err{
   font-size: 9pt;
   color: red;
   font-weight: bold;
   }
</style>
</head>
<body>
<div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">비밀번호 변경
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          	고객님의 소중한 개인정보 보호를 위해 비밀번호는 주기적으로 변경해 주세요.
        </li>
      </ol>

      <!-- Blog Post -->
      
      <form method="post" action="${pageContext.request.contextPath }/update/passwd.mem" onsubmit="return check()">
      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12" align="center">
              	<label for="password">새 비밀번호</label>
         		<input type="password" name="password" id="password" placeholder="password 입력">
            </div>
            
            <div class="col-lg-12" align="center">
            <label for="repw">새 비밀번호 확인</label>
				<input type="password" placeholder="password 재입력" name="repw" id="repw" onkeyup="pwCheck()">
				<span style="display: none;" id="pwmessage"></span>
			</div>	
          </div>
        </div>
        <div class="card-footer text-muted" align="center">
          <input type="submit" class="btn btn-primary" value="입력">
        </div>
      </div>
      </form>

    </div>
</body>
<%@ include file="../MainBottom.jsp" %>
</html>