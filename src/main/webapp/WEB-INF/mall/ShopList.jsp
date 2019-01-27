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
ShopList.jsp<br><br> <!-- OrderMallController에서 넘어옴  -->
<h2 align = "center">주문 내역</h2>

<table border ="1" align = "center">
	<tr>
		<td colspan="3" align = "center">
			주문자 정보 :${sessionScope.loginInfo.nickname}(${sessionScope.loginInfo.name })
		</td>
	</tr>
	<tr>
		<td><span>주문 번호</span></td>
		<td><span>주문 일자</span></td>
		<td><span>상세보기</span></td>
	</tr>
	<c:forEach items="${orderlists }" var="shopinfo">
		<tr>
			<td align = "center">${shopinfo.onum }</td>
			<td align = "center">${shopinfo.orderdate }</td>
			<td align = "center">
				<a href = "detailview.mall?pnum=${shopinfo.onum }">상세보기</a>
				<!--detailview.mall => DetailViewController  -->
			</td>
		</tr>
		
	</c:forEach>
</table>


</body>
<%@include file="../MainBottom.jsp" %>
</html>