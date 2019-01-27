<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<link href="resources/vendor/bootstrap/css1/creative.css"
	rel="stylesheet">
	
	<link href="resources/vendor/bootstrap/css1/createive.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<!--Note : 관리자 페이지 구현 안되서 제품 등록은 회원가입하면 아무나 할 수 있게 함 -->
<!-- 12.19 : 이미지 출력 안됨 -->



	<div class="container">


<div class="col-md-12">
				<!-- Blog Post -->
				<div class="card mb-4">

					<div class="card-body">
<div class="recipe_tag" align="center" display = "none">


	<table>
	<tr align="center" >
	<td width="5" <c:if test="${pkind=='pkind1'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind1"><img src="resources/mimg/q1.jpg" width="109px" height="109px">과일</a></td>
		<td width="5" <c:if test="${pkind=='pkind2'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind2"><img src="resources/mimg/q2.jpg" width="109px" height="109px">채소</a></td>
		<td width="5" <c:if test="${pkind=='pkind3'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind3"><img src="resources/mimg/q3.jpg" width="109px" height="109px">쌀</a></td>
		<td width="5" <c:if test="${pkind=='pkind4'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind4"><img src="resources/mimg/q4.jpg" width="109px" height="109px">수산</a></td>
		<td width="5" <c:if test="${pkind=='pkind5'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind5"><img src="resources/mimg/q5.jpg" width="109px" height="109px">정육</a></td>
		<td width="5" <c:if test="${pkind=='pkind6'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind6"><img src="resources/mimg/q6.jpg" width="109px" height="109px">유제품</a></td>
		<td width="5" <c:if test="${pkind=='pkind7'}">style="border: solid 2px #FFC0CB"</c:if>><a style="color: black;" href="list.mt?pageNumber=<c:out value="${pageInfo.pageNumber}" />&pkind=pkind7"><img src="resources/mimg/q7.jpg" width="109px" height="109px">가공식품</a></td>
	
		<td></td>
	</tr>
	
 
	</table>

</div>
</div>
</div></div>
	</div>
	
	
	<div class="container">

		<table width=100% border=0 align=center> 
		
						
		<tr>
	<% 
			int count=0;
	%>
		<c:forEach items ="${list }"  var ="product">
	<c:set var="uploadpimage" value="${pageContext.request.contextPath }/resources/mart/${product.pimage }"/>	 

	<%			count++;%>
	
			
				<td align="left" >
				
			 <div class="row" style="padding: 30px">
        <div>
              <a  class="portfolio-box"  href="detail.mt?pnum=<c:out value="${product.pnum }"/>" >
         <img src="${uploadpimage}" width="250px" height="250px">
			 <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                   <p>상품 : <c:out value="${product.pname}"/></p>
                  </div>
                  <div class="project-name">
                  <p>가격 : <c:out value="${product.price }"/>원</p>
                  </div>
                </div>
              </div>
        
            </a>
         
        </div>
        
       </div>
	</td>	
		<%
				if(count%4==0){ 
					out.println("</tr><tr>");
				}//if-------
				%>	
				</c:forEach>
	
			
			
			</table>
<c:if test="${loginInfo.id=='admin'}">
			<input type="button" value="추가" class="btn btn-primary" onclick="insert();"/>
		</c:if>


	</div>


		

		
		
	<br>	
		
	
		
	<center>
		${pageInfo.pagingHtml }
	</center>	

<script type="text/javascript">
	/* 상품 추가  */	
	function insert(){
		location.href='insert.mt'; //get 방식
	}

</script>

<!--메뉴 태그 -->
<script type="text/javascript">
    
    $(document).ready(function(){
        $("#toggle_theme").click(function(){
            $(".recipe_tag").slideToggle(500);
        });
    });

</script >
</body>
<%@include file="../MainBottom.jsp" %>
</html>