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
function pwCheck(){
	if($("input[name=password]").val()!=$("input[name=repw]").val()){
		$("#pwmessage").html("위의 비밀번호와 일치하지않습니다.");
		$("#pwmessage").addClass('err');
		$("#pwmessage").show();
	}else{
		$("#pwmessage").css('display','none');
	}
}
var Id_check=false;
var Id_change=false;
var msg="impossible";

function dupCheck(){
	Id_check=true;
	var str=/^[a-zA-Z0-9]{3,15}$/;
	var id=$("#id").val();
	if(!str.test(id)){
		$("#idmessage").html("공백없는 3~15자의 영문/숫자를 조합하여 입력해주세요.");
		$("#idmessage").addClass('err');
		$("#idmessage").show();
		return;
	}
	
	
	$.ajax({
		url:"/ex/idcheck.mem",
		data:({
			userId:id
		}),
		success:function(data){
			if($("input[name=id]").val()==""){
				$("#idmessage").html("아이디를 입력해주세요.");
				$("#idmessage").addClass('err');
				$("#idmessage").show();
				return;
			}else if(jQuery.trim(data)=="YES"){
				$("#idmessage").html("중복된 아이디 입니다.");
				$("#idmessage").addClass('err');
				$("#idmessage").show();
				Id_change=false;
			}else{
				$("#idmessage").html("사용 가능한 아이디 입니다.");
				$("#idmessage").addClass('great');
				$("#idmessage").show();
				Id_change=false;
				msg="possible";
			}
		}
	});
}

function writecheck(){
	if($("input[name=id]").val()==""){
		alert("아이디를 입력하세요.");
		$("input[name=id]").focus();
		return false;
	}
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
	
	if(Id_check==false||Id_change==true){
		alert("아아디 중복 확인을 해주세요.");
		return false;
	}
	if(msg=="impossible"){
		alert("사용 불가능한 아이디입니다.");
		return false;
	}
		

	
}
