<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp"%>

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
</head>



<body>




	<div class="container">


<div class="col-md-13">
				<!-- Blog Post -->
				<div class="card mb-4">

					<div class="card-body">
<div class="recipe_tag" align="center" display = "none">

<img src="resources/mimg/chef3.jpg" width="100%" height="140px">

</div>
</div>
</div></div>
	</div>
	
	
	
	<div class="container">
		<div class="row">
		<c:forEach items="${chefLists}" var="chef">
		<c:set var="abc" value="${pageContext.request.contextPath }/resources/chef/${chef.cmainimage}" />
			<div class="col-lg-4 col-sm-6 portfolio-item">
        
       
   
				<a class="thumbnail"
					href="detail.cf?chefnum=<c:out value="${chef.chefnum }"/>">
					<div class="card h-100" style="border-color: white;" align="center">
					<img src="${abc}" alt=""	width="310px" height="360">
			</div>
					<div class="caption">
						<h4 class="ellipsis_title2">
							<c:out value="${chef.csubject }" />
						</h4>
					
					</div>
				</a>
	        
        </div>
        </c:forEach>
		</div>
		
		<div>
				<input type="button" value="추가"class="btn btn-primary"
					onclick="insert();" />
			</div>
		<br>

 	<center>${pageInfo.pagingHtml }</center>
	</div>

	<!-- 셰프 등록 , 수정과 삭제는 자세히 보기에서 -->
	<script type="text/javascript">
	function insert(){
		location.href='insert.cf'; //get 방식
	}
</script>

</body>
<%@include file="../MainBottom.jsp"%>
</html>