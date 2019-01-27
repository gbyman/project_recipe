<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function insert() {
		location.href = "infoinsert.bod";
	}
</script>

<style type="text/css">
iframe {
	width: 100%;
	height: 370px;
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


</style>
</head>
<body>
	<!-- Page Content -->

	<div class="container">
		<!-- Page Heading/Breadcrumbs -->


		<div class="breadcrumb" style="background-color: white; border: 1px solid #ddd;">
			<h1>올레시피 TV</h1>
			&nbsp;&nbsp;&nbsp;
			<DIV align="center">
				<c:if test="${loginInfo.id=='admin'}">
					<a href="javascript:insert();" class="btn btn-primary ">등록</a>
				</c:if>
			</DIV>
		</div>




		<div class="row">
			<!-- Blog Entries Column -->
			<div class="col-md-8">
				<!-- Blog Post -->
				<div class="card mb-4">

					<div class="card-body">


	<c:forEach var="cookinfo" items="${list }" varStatus="sta">
	


						<div class="card mb-4">
						  ${cookinfo.infomovie}
							<%-- <a href="infodetail.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />">
											${cookinfo.infoimage} </a> --%>
							<div class="card-body">
						 		<h2 class="card-title">
								<a href="infodetail.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}&infokind=movie" />">
												${cookinfo.infosubject} </a>
								</h2>
										<c:if test="${loginInfo.id=='admin'}">
											<a class="btn btn-primary "
												href="infoupdate.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}&infokind=movie" />">수정</a>
											<a class="btn btn-primary "
												href="infodelete.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}&infokind=movie" />">삭제</a>
										</c:if>
					
							</div>

						</div>
			
						
</c:forEach>





						<div align="center">${pageInfo.pagingHtml }</div>
					</div>
				</div>






			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">



				<!-- Categories Widget -->
				<div class="card my-4">
					<h5 class="card-header">카테고리</h5>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-12">
								<ul class="list-unstyled mb-0">
									<li><a href="infolist.bod?infokind=image">매거진 & 뉴스</a></li>
									<HR>
									<li><a href="infolist.bod?infokind=movie">올레시피 TV</a></li>

								</ul>
							</div>

						</div>
					</div>
				</div>

				<!-- Side Widget -->


			</div>  

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->


</body>
<%@ include file="../MainBottom.jsp"%>
</html>