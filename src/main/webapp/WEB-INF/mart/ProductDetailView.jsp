<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp"%>
<html>
<style type="text/css">
.err {
	font-size: 9pt;
	color: red;
	font-weight: bold;
}
body{
font-size: 14pt;
}
.btn {
	font-weight: 700;
	text-transform: uppercase;
	border: none;
	border-radius: 300px;
	font-family: 'Open Sans', 'Helvetica Neue', Arial, sans-serif;
}

.btn-primary {
	background-color: #F05F40;
	border-color: #F05F40;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active {
	color: #fff;
	background-color: #ee4b28 !important;
}

.btn-primary:active, .btn-primary:focus {
	box-shadow: 0 0 0 0.2rem rgba(240, 95, 64, 0.5) !important;
}

.point1 {
	border: 1px solid #3e3d3c;
	color: #3e3d3c;
}

.point1:hover {
	border: 1px solid #fa2828;
	color: #4f4e4d;
}

.point1 {
	width: 130px;
	height: 60px;
	line-height: 59px;
	font-size: 16px;
	font-weight: bold;
}

.point2 {
	
	background: #3e3d3c;
	border: 1px solid #3e3d3c;
	color: #fff;
	font-weight: bold;
}

.point2:hover {
	background: #4f4e4d;
	border: 1px solid #4f4e4d;
}

.point2 {
	width: 130px;
	height: 60px;
	line-height: 59px;
	font-size: 20px;
	font-weight: bold;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="uploadpimage"
		value="${pageContext.request.contextPath }/resources/mart/${product.pimage }" />


	<div class="container">
		<br>

		<div class="col-md-12">
			<!-- Blog Post -->
			<div class="card mb-4">

				<div class="card-body" style="padding: 4%">


					<table border="0">
						<tr>
							<td width="50%"><img width="490" height="490"
								src="${uploadpimage}" /></td>




							<td width="100%"><div style="padding: 10%">

									<table align="left" border="0" width="40%" >
										<tr>
											<td colspan="2"><h2>
													<c:out value="${product.pname}" />
												</h2></td>
										</tr>
										<tr>
											<td><br>판매가</td>
											<td><br><c:out value="${product.price}" />원</td>

										</tr>

										<tr>
											<td >원산지</td>
											<td><c:out value="${product.origin}" /></td>

										</tr>

										<tr>
											<td >재고</td>
											<td><c:out value="${product.stock}" /></td>

										</tr>

										<tr>
											<td>수량선택</td>
											<td>
												<form action="add.mall" method="post">
													<input type="hidden" name="pnum" value="${product.pnum }" />
													<select name="orderqty" id="orderqty">
														<option value="1" selected>1개</option>
														<option value="2">2개</option>
														<option value="3">3개</option>
														<option value="4">4개</option>
														<option value="5">5개</option>
														<option value="6">6개</option>
														<option value="7">7개</option>
														<option value="8">8개</option>
														<option value="9">9개</option>
														<option value="10">10개</option>
														<option value="11">11개</option>
														<option value="12">12개</option>
														<option value="13">13개</option>
														<option value="14">14개</option>
														<option value="15">15개</option>
														<option value="16">16개</option>
														<option value="17">17개</option>
														<option value="18">18개</option>
														<option value="19">19개</option>
														<option value="20">20개</option>

													</select>
													<form:errors cssClass="err" path="orderqty" />
											</tr>	<tr>
											<td><br>																					
													 <input class="point1" type="submit" value="장바구니" /> 
													 </td>
													 
												</form><td><br> <input class="point2" type="submit" value="바로구매"
												value="${product.pnum }" onclick="goBuy('${product.pnum}')" /> 
														
											</td>
										</tr>

									</table>
									<br><br><br><br><br><br><br><br><br><br><br><br>
								</div></td>
						</tr>
					</table>

					<div align="center">
						<br> <br> <br> <input type="button" value="상품목록"
							onclick="goList();" class="btn btn-primary" />
						<c:if test="${loginInfo.id=='admin'}">
							<input type="button" value="삭제" value="${product.pnum }"
								class="btn btn-primary" onclick="goDelete('${product.pnum }')" />
							<input type="button" value="수정" value="${product.pnum }"
								class="btn btn-primary" onclick="goUpdate('${product.pnum}')" />
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript">
	function goList() { // 버튼 누르면 레시피로 이동
		location.href = 'list.mt'; //get 방식
	}

	function goUpdate(num) { //수정하기 버튼눌렀을 때 pnum을 담아서 간다
		location.href = 'update.mt?pnum=' + num; //ProductUpdateController get
	}

	function goDelete(num) { //삭제 버튼 눌렀을 때 pnum을 담아서 간다
		location.href = 'delete.mt?pnum=' + num; //ProductDeleteController get 
	}

	function goBuy(num) { //pnum을 통해 정보를 가져와서 바로 구매
		alert('바로구매');
		location.href ='order.mall?pnum=' + num;  //OrderMallController  
	}

	$(function() {
		$('#decreaseQuantity').click(function(e) {
			e.preventDefault();
			var stat = $('#numberUpDown').text();
			var num = parseInt(stat, 10);
			num--;
			if (num <= 0) {
				alert('더이상 줄일수 없습니다.');
				num = 1;
			}
			$('#numberUpDown').text(num);
		});
		$('#increaseQuantity').click(function(e) {
			e.preventDefault();
			var stat = $('#numberUpDown').text();
			var num = parseInt(stat, 10);
			num++;

			if (num > 5) {
				alert('더이상 늘릴수 없습니다.');
				num = 5;
			}
			$('#numberUpDown').text(num);
		});
	});
</script>
<%@include file="../MainBottom.jsp"%>
</html>