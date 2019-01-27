<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
div{
	align : center;
}
ul {
    list-style:none;
    margin:0;
    padding:0;
}

li {
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;
}


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


.thumbnail {
	display: block;
	padding: 4px;
	margin-bottom: 20px;
	line-height: 1.42857143;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 4px;
	-webkit-transition: border .2s ease-in-out;
	-o-transition: border .2s ease-in-out;
	transition: border .2s ease-in-out;
	box-shadow: 0 2px 3px #eee;
}



a.thumbnail.active, a.thumbnail:focus, a.thumbnail:hover {
	
	border: 2px solid #FFC0CB;
	text-decoration: none;
	cursor: pointer;
}

a.div.thumbnail.active, a.div.thumbnail:focus, a.div.thumbnail:hover {
	border-color: #FFC0CB;
	border: 2px solid #FFC0CB;
	text-decoration: none;
}

.thumbnail .caption {
	padding: 9px;
	color: #333;
}

/* .thumbnail_over {
	position: absolute;
	left:1px; top:1px;
	width: 100%;
	height: 100%;
	opacity: 0;
	filter:alpha(opacity=0);
	
 */
caption {
	padding-top: 8px;
	padding-bottom: 8px;
	color: #777;
	text-align: left
}

.thumbnail .caption {
	padding: 10px 20px;
}

.thumbnail .caption h4 {
	font-size: 19px;
	font-weight: bold;
}

.thumbnail .caption p.m_list_cate {
	color: #84accb;
	margin-bottom: 4px;
}

.thumbnail .caption p {
	color: #999;
	margin: 0;
}

.thumbnail .caption span {
	margin: 0 6px;
	display: inline-block;
}






</style>

<title>레시피</title>
</head>
<body>







	<div class="container">


<div class="col-md-12" >
				<!-- Blog Post -->
				<div class="card mb-4" >

					<div class="card-body">
<div class="recipe_tag" align="center" display = "none">


	<table>
	<tr>
		<td <c:if test="${theme=='1'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=1"><img src="resources/mimg/a1.jpg" /></a></td>
		<td <c:if test="${theme=='2'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=2"><img src="resources/mimg/a2.jpg" /></a></td>
		<td <c:if test="${theme=='3'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=3"><img src="resources/mimg/a3.jpg" /></a></td>
		<td <c:if test="${theme=='4'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=4"><img src="resources/mimg/a4.jpg" /></a></td>
		<td <c:if test="${theme=='5'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=5"><img src="resources/mimg/a5.jpg" /></a></td>
		<td <c:if test="${theme=='6'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=6"><img src="resources/mimg/a6.jpg" /></a></td>
	</tr>
	<tr>
		<td <c:if test="${theme=='7'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=7"><img src="resources/mimg/a7.jpg" /></a></td>
		<td <c:if test="${theme=='8'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=8"><img src="resources/mimg/a8.jpg" /></a></td>
		<td <c:if test="${theme=='9'}">style="border: solid 2px #FFC0CB"</c:if> ><a href="list.rec?theme=9"><img src="resources/mimg/a9.jpg" /></a></td>
		<td <c:if test="${theme=='10'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=10"><img src="resources/mimg/a10.jpg" /></a></td>
		<td <c:if test="${theme=='11'}">style="border: solid 2px #FFC0CB"</c:if>><a href="list.rec?theme=11"><img src="resources/mimg/a11.jpg" /></a></td>
		<td></td>
	
	</tr>

	</table>

</div>
</div>
</div></div>
<div id ="toggle_theme" align="center" style="padding:0"><img src="resources/mimg/tag_btn_off.png" /></div>

<%-- 
<Br><br>
<div class="col-md-12" style="border: 1px solid #ddd; ">
<Br> <c:if test="${theme=='1'}">
       <h2 align="center"><img src="resources/mimg/a1.jpg" />밥요리</h2>
        </c:if> 
        </div> --%>
        <br><br>
 <div class="row">
	
	

	 <c:forEach var="recipe" items="${recipeLists}">
	   
	        <div class="col-lg-4 mb-4">
	          <div class="card h-100">
	          <h4 class="card-header">${recipe.psubject}</h4>
	          <div class="card-body">
	          <p class="card-text">
							<img class="card-img-top" src="resources/recipe/${recipe.writer }Recipe/${recipe.mainimage }" width="100%" height="300" />

						</p>
	           </div>
	           <div class="card-footer">
						<a href="detail.rec?recnum=<c:out value="${recipe.recnum }"/>" class="btn btn-primary">자세히보기</a>
					</div>
			     </div>
	        </div>
	        </c:forEach>
		</div>

		<c:if test="${loginInfo.id=='admin'}">
			<input type="button" value="추가" class="btn btn-primary" onclick="insert();"/>
		</c:if>


		
		
	<br>	
		
	 
 	
	<center>
		${pageInfo.pagingHtml }
	</center> 

	</div>
<!-- 레시피 등록 , 수정과 삭제는 자세히 보기에서 -->
<script type="text/javascript">
	
	function insert(){
		location.href='insert.rec'; //get 방식
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

