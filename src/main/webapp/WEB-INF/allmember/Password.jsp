<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		if($("#password").val()==false){
			alert("패스워드를 입력해 주세요.");
			$("#password").focus();
			return false;
		}
	}
</script>
</head>
<body>
<div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">개인정보 보호
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          	고객님의 소중한 개인정보 보호를 위해 한번 더 인증해 주시기 바랍니다.
        </li>
      </ol>

      <!-- Blog Post -->
      
      <form method="post" action="pass.mem" onsubmit="return check()">
      <input type="hidden" name="passnum" value="${passnum }">
      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12" align="center">
              	<label for="password">비밀번호</label>
         		<input type="password" name="password" id="password" >
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
<%@include file="../MainBottom.jsp" %>
</html>