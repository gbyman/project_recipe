<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	        <div class="card">
	          <div class="card-header" role="tab" id="headingOne">
	            <h5 class="mb-0">
	              <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">회원탈퇴 방법을 알려주세요</a>
	            </h5>
	          </div>
	
	          <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
	            <div class="card-body">
	            	사용중인 아이디는 회원탈퇴 후 복구가 불가합니다.<br>
					<br>
					신중하게 선택해 주세요.<br> 
					<br>
					오른쪽 상단 [마이페이지>MyHome]으로 들어갑니다.<br>
					<br>
					1. 오른쪽 카테고리 메뉴 중 [회원탈퇴]를 클릭해주세요.<br>
					<br>
					2. 비밀번호를한번 더 정확하게 입력해주세요.<br>
					<br>
					3. [입력]을 누르면 탈퇴가완료됩니다.<br>
					<br>
					- 공공적 성격의커뮤니티 게시물은 탈퇴 후에도 삭제되지 않으므로 반드시 직접 삭제하신 후 탈퇴해 주시기 바랍니다.<br>
					
	            </div>
	          </div>
	        </div>
	        
	        <div class="card">
	          <div class="card-header" role="tab" id="headingTwo">
	            <h5 class="mb-0">
	              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">나의 활동내역을 확인하고 싶어요
	              </a>
	            </h5>
	          </div>
	          <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
	            <div class="card-body">
					내가 활동한 내용들을 한꺼번에 확인하고 싶으신가요?<br>
					<br>
					오른쪽 상단 [마이페이지>MyHome]메뉴를 클릭하시면 나의 자취를 확인하실 수 있습니다.<br>
	            </div>
	          </div>
	        </div>
	        
	        <div class="card">
	          <div class="card-header" role="tab" id="headingThree">
	            <h5 class="mb-0">
	              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">비밀번호를 변경하고 싶어요</a>
	            </h5>
	          </div>
	          <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
	            <div class="card-body">
	            	사용중인 비밀번호를 변경하고 싶으시면,<br>
					<br>
					로그인 후 우측 상단 [마이페이지>비밀번호수정]페이지에서 변경하실 수 있습니다.<br>
	            </div>
	          </div>
	        </div>
	        <div class="card">
	          <div class="card-header" role="tab" id="headingFour">
	            <h5 class="mb-0">
	              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">동영상 URL 가져오는 방법 안내</a>
	            </h5>
	          </div>
	          <div id="collapseFour" class="collapse" role="tabpanel" aria-labelledby="headingFour">
	            <div class="card-body">
	            <img alt="동영상url가져오는법" src="<%= contextPath %>/resources/img/url.png">
	            </div>
	          </div>
	        </div>
	      </div>
</body>
</html>