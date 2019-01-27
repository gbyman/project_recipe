<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %> 
<html>
<head>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인정보 수정 페이지</title>
<script type="text/javascript">
function insertEmail(addr){
	if(addr.value=="insert"){
		$("input[name=email3]").show();
	}else{
		$("input[name=email3]").css('display','none');
	}
}
function openDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다.
            if(data.bname !== ''){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있을 경우 추가한다.
            if(data.buildingName !== ''){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }


            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("postnumber").value = data.zonecode; //5자리 우편번호 사용
            //document.getElementById("mPostcode2").value = data.postcode2;
            document.getElementById("address1").value = fullRoadAddr;//+" "+data.jibunAddress;
			document.getElementById("address2").focus();


        }
    }).open();
}

function writecheck(){
	
	if($("input[name=nickname]").val()==""){
		alert("닉이름을 입력해주세요.");
		$("input[name=name]").focus();
		return false;
	}
	if($("input[name=name]").val()==""){
		alert("이름을 입력해주세요.");
		$("input[name=name]").focus();
		return false;
	}
	
	if($("input[name=email1]").val()==""){
		alert("email주소를 입력해주세요.");
		$("input[name=email1]").focus();
		return false;
	}
	var email1regex=/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*$/;
	if($("input[name=email1]").val().search(email1regex)<0){
		alert("email주소는 3~15자의 영문자와 숫자로 입력해주세요.");
		$("input[name=email1]").focus();
		return false;
	}

	if($("#mail option:selected").val()==""){
		alert("email도메인을 선택해주세요.");
		$("#mail").focus();
		return false;
	}
	if($("#mail option:selected").val()=="insert" && $("input[name=email3]").val()==""){
		alert("email도메인을 입력해주세요.");
		$("input[name=email3]").focus();
		return false;
	}
	var email2regex=/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

	if($("#mail option:selected").val()=="insert" && $("input[name=email3]").val().search(email2regex)<0){
		alert("email도메인형식이 맞지않습니다.");
		$("input[name=email2]").focus();
		return false;
	}
	if($("select[name=hp1] option:selected").val()==""){
		alert("핸드폰번호 앞자리를 선택해주세요.");
		$("select[name=hp1]").focus();
		return false;
	}
	if($("input[name=hp2]").val()==""){
		alert("핸드폰번호를 입력해주세요.");
		$("input[name=hp2]").focus();
		return false;
	}
	var str=/^\d{3,4}$/;
	var hp2=$("input[name=hp2]").val();
	if(hp2.search(str)<0){
		alert("핸드폰번호는 숫자3~4자리만 입력해주세요.");
		$("input[name=hp2]").focus();
		return false;
	}
	if($("input[name=hp3]").val()==""){
		alert("핸드폰번호를 입력해주세요.");
		$("input[name=hp3]").focus();
		return false;
	}
	var str=/^\d{3,4}$/;
	var hp3=$("input[name=hp3]").val();
	if(hp3.search(str)<0){
		alert("핸드폰번호는 숫자3~4자리만 입력해주세요.");
		$("input[name=hp3]").focus();
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
   .great{
   font-size: 9pt;
   color: green;
   font-weight: bold;
   }
</style>
</head>
<body>
<h2>회원 가입</h2>
<div>
   <form method="post" action="${pageContext.request.contextPath }/update/info.mem" onsubmit="return writecheck()" enctype="multipart/form-data"> 
   		
      <p>
         	아이디 ${bean.id }
         	<input type="hidden" name="id" value="${bean.id }">
      </p>
      
      <p>
         <label for="img">프로필사진</label>
         <c:if test="${bean.img!='basic.png' }">
         <img alt="프로필 사진" src="${pageContext.request.contextPath }/resources/img/${bean.id}Profile/${bean.img}" width="200" height="200">
         </c:if>
         <c:if test="${bean.img=='basic.png' }">
         <img alt="프로필 사진" src="${pageContext.request.contextPath }/resources/img/${bean.img}" width="200" height="200">
         </c:if>
         <input type="file" name="imgUpload" id="img">
         <input type="hidden" name="img2" value="${bean.img }">
      </p>
      
      <p>
         <label for="nickname">별명</label>
         <input type="text" name="nickname" id="nickname" value="${bean.nickname }"> 
      </p>
      
      <p>
         <label for="name">이름</label>
         <input type="text" name="name" id="name" value="${bean.name }">
      </p>
      
      <p>
     
         <label for="hp1">핸드폰번호</label>
        <select name="hp1" id="hp1">
						<option value="">선택</option>
						<option value="010" <c:if test="${bean.hp1=='010' }">selected </c:if>>010</option>
						<option value="011" <c:if test="${bean.hp1=='011' }">selected </c:if>>011</option>
						<option value="016" <c:if test="${bean.hp1=='016' }">selected </c:if>>016</option>
						<option value="017" <c:if test="${bean.hp1=='017' }">selected </c:if>>017</option>
						<option value="018" <c:if test="${bean.hp1=='018' }">selected </c:if>>018</option>
						<option value="019" <c:if test="${bean.hp1=='019' }">selected </c:if>>019</option>
					</select>
         <input type="text" name="hp2" id="hp2" maxlength="4" value="${bean.hp2 }">
         <input type="text" name="hp3" id="hp3" maxlength="4" value="${bean.hp3 }">
      
      </p>
      
      
       <p>
         <label for="email1">이메일</label>
         <input type="text" name="email1" id="email1" value="${bean.email1 }">@
         <input type="text" name="email3" style="display:none;">
			<select name="email2" onchange="insertEmail(this)" id="mail">
				<option value="">선택</option>
				<option value="naver.com" <c:if test="${bean.email2=='naver.com' }">selected </c:if>>naver.com</option>
				<option value="hanmail.net" <c:if test="${bean.email2=='hanmail.net' }">selected </c:if>>hanmail.net</option>
				<option value="daum.net" <c:if test="${bean.email2=='daum.net' }">selected </c:if>>daum.net</option>
				<option value="nate.com" <c:if test="${bean.email2=='nate.com' }">selected </c:if>>nate.com</option>
				<option value="gmail.com" <c:if test="${bean.email2=='gmail.com' }">selected </c:if>>gmail.com</option>
				<option value="hotmail.com" <c:if test="${bean.email2=='hotmail.com' }">selected </c:if>>hotmail.com</option>
				<option value="insert">직접입력</option>
			</select>
         
         
      </p>
      <hr>
      <p>
         <label for="postnumber">우편번호</label>
         <input type="text" name="postnumber" id="postnumber" ${bean.postnumber }>
         <input type="button" value="우편번호찾기" onclick="openDaumPostcode()">
      </p>
      
      <p>
         <label for="address1">주소</label>
         <input type="text" name="address1" id="address1" value="${bean.address1 }">
         <input type="text" name="address2" id="address2" value="${bean.address2 }">
      </p>
      
      <p>
         	생년월일
         <input type="text" name="year" id="year" value="${bean.year }">년
         <input type="text" name="month" id="month" value="${bean.month }">월
         <input type="text" name="day" id="day" value="${bean.day }">일
      </p>
            
         
      <p>
         <label for="gender">성별</label>
         <input type="radio" name="gender"  value="man" <c:if test="${bean.gender=='man' }">checked </c:if>>남
         <input type="radio" name="gender"  value="woman" <c:if test="${bean.gender=='woman' }">checked </c:if>>여
      </p>   
   
      <p>
         <input type="submit" value="수정하기">      
      </p>
   </form>
</div>
</body>
<%@include file="../MainBottom.jsp" %>
</html>