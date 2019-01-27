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
.bg-me {
	background-color: #FFC0CB !important
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


		<div class="breadcrumb"  style="background-color: white; border: 1px solid #ddd;">
			<h1>매거진 & 뉴스</h1>
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

							<c:set var="theString"
								value="${pageContext.request.contextPath}/resources/img/${cookinfo.infoimage }" />


							<!-- Project One -->
							<div class="row">
								<div class="col-md-7">

									<a
										href="infodetail.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />&infokind=image">
										<img src="${theString}" width="350" height="200">


									</a>

								</div>
								<div class="col-md-5">
								<br>
									<h3>
										<a
											href="infodetail.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />&infokind=image">
											${cookinfo.infosubject} </a>
									</h3>
																	
									
									<fmt:formatDate value="${cookinfo.indate}" var="date" pattern="yyyy-MM-dd KK:mm"/>

									<p><br><br>올레시피      <br> ${date }</p>

								
									<c:if test="${loginInfo.id=='admin'}">
										<a class="btn btn-primary "
											href="infoupdate.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />&infokind=image">수정</a>
										<a class="btn btn-primary "
											href="infodelete.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />&infokind=image">삭제</a>
									</c:if>

								</div>
								
							</div>
							<!-- /.row -->

							<br>
							<hr>
							<br>


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






































	<%-- 


 <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">매거진</h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="infolist.bod">매거진</a></li>
        </li>
        <li class="breadcrumb-item active">  
        <a href="infolist2.bod">동영상</a></li>
       
        
 
        <c:if test="${loginInfo.id=='admin'}">
            <li ><a href="javascript:insert();" class="btn btn-info">등록</a></li>
       </c:if>
      </ol>




	<c:forEach var="cookinfo" items="${list }" varStatus="sta">
  




		<c:set var="theString" 
value="${pageContext.request.contextPath}/resources/${cookinfo.infoimage }"/>		
					
 	

						

					<td align="center">${bean.writer }</td>
					<fmt:formatDate value="${bean.regdate }" var="date" pattern="yyyy/MM/dd" />
					<td align="center">${date }</td>
					<td align="center">${bean.readcount }</td>
					<td align="center">${bean.ip }</td>
				</tr>
			
      <!-- Project One -->
      <div class="row">
        <div class="col-md-7">
        
          <a href="infodetail.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />"> 
 <img src="${theString}" width="100px" height="100px"> 


     </a>
      
        </div>
        <div class="col-md-5">
          <h3>
          <a href="infodetail.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />"> 
          ${cookinfo.infosubject}
          </a>
          </h3>
          <br>
          <p>${cookinfo.infointro}</p>
          
          
    <c:if test="${loginInfo.id=='admin'}">
    <a class="btn btn-info" href="infoupdate.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />">수정</a>      
	<a class="btn btn-info" href="infodelete.bod?infonum=<c:out value="${cookinfo.infonum}" />&pageNumber=<c:out value="${pageInfo.pageNumber}" />">삭제</a>
      </c:if>
 
        </div>
      </div>
      <!-- /.row -->

      	<br>
      	<hr>
      	<br>


      </c:forEach>
      
      
      
      
      
      
      ${pageInfo.pagingHtml }
      
    </div>
    
     
    
    
     --%>

</body>
<%@ include file="../MainBottom.jsp"%>
</html>