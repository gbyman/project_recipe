<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
ShopResult.jsp<br><br>
<h2 align = "center">주문 상세 내역</h2>
<br>

<table border="1" align ="center">

	<tr>
		<td colspan="2" align ="left">
			<span> 고객 : ${sessionScope.loginInfo.name }</span>
		</td>
		<td colspan="3" align="left">
			<span> 주문 번호 : ${requestScope.pnum } </span>
		</td>
	</tr>
	<tr>
		<td colspan="5" align="left">
			배송지 : ${sessionScope.loginInfo.address1 } ${sessionScope.loginInfo.address2 }
		</td>
	</tr>
	<tr>
		<td colspan ="5" align ="left">
			우편번호 : ${sessionScope.loginInfo.postnumber }
		</td>
	</tr>
	
	<tr>
		<th><span>상품명</span></th>
		<th><span>수량</span></th>
		<th><span>단가</span></th>
		<th><span>총액</span></th>
	</tr>
		<c:forEach items="${requestScope.shoplists }" var="result" varStatus="status">
			<tr>
				
				<td align ="center">
					${result.pname }
				</td>
				<td align ="center">
					${result.qty }
				</td>
				<td align ="center">
					<fmt:formatNumber value="${result.price }" pattern="###,###"/>
				</td>		
				<td align ="center">
					<fmt:formatNumber value="${result.amount }" pattern ="###,###"/>
				</td>
			</tr>
		</c:forEach>
		
</table>
<div>
	<input type="button" value="메인화면" onclick="goHome();"/>
</div>

<script type="text/javascript">

function goHome(){//홈으로 이동
	location.href = 'mainPage.rec';
}

</script>
</body>
<%@include file="../MainBottom.jsp" %>
</html>