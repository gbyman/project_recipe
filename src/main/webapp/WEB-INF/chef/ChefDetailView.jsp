<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.btn {
  font-weight: 700;
  text-transform: uppercase;
  border: none;
  border-radius: 300px;
  font-family: 'Open Sans', 'Helvetica Neue', Arial, sans-serif; }


.btn-primary {
  background-color: #F05F40;
  border-color: #F05F40; }
  .btn-primary:hover, .btn-primary:focus, .btn-primary:active {
    color: #fff;
    background-color: #ee4b28 !important; }
  .btn-primary:active, .btn-primary:focus {
    box-shadow: 0 0 0 0.2rem rgba(240, 95, 64, 0.5) !important; }

</style>
</head>
<body>
<c:set var="uploadcmainimage" value="${pageContext.request.contextPath }/resources/chef/${chef.cmainimage }"/>
<c:set var="uploadcimage1" value="${pageContext.request.contextPath }/resources/chef/${chef.cimage1 }"/>
<c:set var="uploadcimage2" value="${pageContext.request.contextPath }/resources/chef/${chef.cimage2 }"/>
<c:set var="uploadcimage3" value="${pageContext.request.contextPath }/resources/chef/${chef.cimage3 }"/>
<c:set var="uploadcimage4" value="${pageContext.request.contextPath }/resources/chef/${chef.cimage4 }"/>










<div class="container">
<br>

<div class="col-md-12" >
				<!-- Blog Post -->
				<div class="card mb-4">

					<div class="card-body" style="padding: 4%">
        
        
		<table border="0">
			<tr>
				<td width="50%"><img width="490" height="490"
					src="${uploadcmainimage }" /></td>
				<td width="50%"><div style="padding: 10%">
						<h2>
							<c:out value="${chef.csubject }" />
						</h2>
						<br>
						<h5><c:out value="${chef.cshortintro }" /></h5>
						<Br>
						<c:out value="${chef.cintro }" />
						<br><br>
						<hr>
						<br>
						<c:out value="${chef.cingredient }" />
					</div></td>
			</tr>
		
			
			<tr align="center">
				<td colspan="2"><br><br><img width="500" height="500" src="${uploadcimage1 }" /></td>
			</tr>

			<tr align="center">
				<td colspan="2"><img width="500" height="500" src="${uploadcimage2 }" /></td>
			</tr>

			<tr align="center">
				<td colspan="2"><img width="500" height="500" src="${uploadcimage3 }" /></td>
			</tr >

			<tr align="center">
				<td colspan="2"><img width="500" height="500" src="${uploadcimage4 }" /></td>
			</tr>

			
		</table>





<br>
<div align = "center">
	<input class="btn btn-primary" type="button" value="목록보기" onclick="goList();"/>
	
	<input class="btn btn-primary" type="button" value="삭제" value="${chef.chefnum }" onclick="goDelete('${chef.chefnum}')"/>
	
	<input class="btn btn-primary" type="button" value="수정" value="${chef.chefnum }" onclick="goUpdate('${chef.chefnum}')"/>
	
	<input class="btn btn-primary" type="button" value="스크랩하기" value="${chef.chefnum }" onclick="goScrap('${chef.chefnum}')"/>
</div>




</div></div></div></div>










<%-- 
<div align="center">
	<table border="1">
	
		<tr>
			<td>
				<img src="${uploadcmainimage }"/>
			</td>
			
			<td align="center">
				<table border="1">
					<tr height="50">
						<td width="120">요리이름</td>
						<td width="300"><c:out value="${chef.csubject }"/></td>
					</tr>
					
					<tr height="50">
						<td width="120">간단한 설명</td>
						<td width="300"><c:out value="${chef.cshortintro }"/></td>
					</tr>
				
					<tr height="50">
						<td width="120">재료</td>
						<td width="300"><c:out value="${chef.cingredient }"/></td>
					</tr>
					
				</table>
			</td>
		</tr>
		
			<tr>
				<td colspan ="2">
					<img src="${uploadcimage1 }"/>
				</td>
			</tr>
			
			<tr>
				<td colspan ="2">
					<img src="${uploadcimage2 }"/>
				</td>
			</tr>
			
			<tr>
				<td colspan ="2">
					<img src="${uploadcimage3 }"/>
				</td>
			</tr>
			
			<tr>
				<td colspan ="2">
					<img src="${uploadcimage4 }"/>
				</td>
			</tr>
			
			<tr>
				<td width="120">설명</td>
				<td width="300"><c:out value="${chef.cintro }"/></td>
			</tr>
	</table>



</div>
<br>

 --%>

</body>

<script type="text/javascript">
	function goList(){// 버튼 누르면 나도셰프로 이동
		location.href='list.cf'; //get 방식
	}
	
	function goUpdate(num){//수정하기 버튼눌렀을 때 chefnum을 담아서 간다
		location.href = 'update.cf?chefnum='+num; //ChefUpdateController get
	}
	
	function goDelete(num){//삭제 버튼 눌렀을 때 recnum을 담아서 간다
		location.href = 'delete.cf?chefnum='+num; //ChefDeleteController get 
	}
	
	function goScrap(num){//스크랩 버튼 눌렀을 때 chefnum을 통해 정보를 가져와서 마이페이지와 연동
		
	}
</script>
<%@include file="../MainBottom.jsp" %>
</html>