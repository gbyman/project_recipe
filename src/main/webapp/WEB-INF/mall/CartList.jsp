<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Montserrat;
}

.login-block {
	width: 650px;
	padding: 20px;
/* 	background: #FFC0CB; */
border:solid #FFC0CB;
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

.login-block input, button {
	width: 100%;
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

.login-block input, button,textarea {
	width: 100%;
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




.login-block input#insert {
	width: 150px;
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

.login-block input#insert:hover {
	background: #ff7b81;
}
</style>
</head>
<body>
<br>

<div class="login-block">
		<h1>주문서 작성 </h1>
		
<div align="center">
주문자 정보 : ${sessionScope.loginInfo.nickname}(${sessionScope.loginInfo.name })
<br>
<table align="center" border="0"  class="table table-condensed">
	<thead>
	<tr align="center" height="50">
		<th width="100"><span>상품번호</span></th>
		<th width="100"><span>상품명</span></th>
		<th width="100"><span>가격</span></th>
		<th width="100"><span>수량</span></th>
		<th width="100"><span>금액</span></th>
	</tr>
	</thead>
		 <tbody>
	<c:forEach items="${sessionScope.shoplists }" var="shopinfo">
		<tr>
			<td align="center">
				${shopinfo.pnum }
			</td>
			<td align="center">
				${shopinfo.pname }
			</td>
			<td align="center">
				${shopinfo.price }
			</td>
			<td align="center">
				${shopinfo.qty }
			</td>
			<td align="center">
				${shopinfo.amount }
			</td>
		</tr> 
	</c:forEach>
	<tr>
		
		<th colspan = "5">
			<a> 총 금액 : ${sessionScope.totalAmount} </a>
		</th>
		
	</tr>
	<tr>
	<td colspan="5"></td></tr>
	</tbody>
	</table>
	<Table>
	<tr>
	<td align="center">
	<input type="button" id="insert" value="결제" onclick="goBuy();"/></td><td>
	<input type="button" id="insert" value="상품목록" onclick="goList();"/>
	</td>
	</tr>
</table>

<br><br><br><br>
</div></div>
<br><br>
</body>
<script type="text/javascript">
	function goBuy(){
		alert('결제합니다');
		location.href='calculate.mall';
	}
	
	function goList(){
		location.href='list.mt';
	}

</script>
<%@include file="../MainBottom.jsp" %>
</html>