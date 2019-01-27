<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(){
		if($("#opsubject").val()==false){
			alert("제목을 입력해주세요.");
			$("#opsubject").focus();
			return false;
		}
	}
	
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/opinion/insert.bod" method="post" onsubmit="return check()">
			<div class="control-group form-group">
              <div class="controls">
                <label>제목</label>
                <input type="text" name="opsubject" class="form-control" id="opsubject" >
              </div>
            </div>
			
            <div class="control-group form-group">
              <div class="controls">
                <label>내용</label>
                <textarea rows="10" cols="100" class="form-control" name="opcontent" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none"></textarea>
              </div>
            </div>
                
            <div id="success"></div>
			
            <button type="submit" class="btn btn-primary" >등록</button>
            <button type="reset" class="btn btn-warning" >취소</button>
          </form>     
</body>
</html>