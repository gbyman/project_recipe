<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-lg-8">

   	<div align="center">
   		<h1>레시피를 등록하러가요!</h1>
   		<a href="${pageContext.request.contextPath }/insert.rec" class="btn btn-primary">레시피등록</a>
   	</div>
    <c:if test="${list!=null }">
	<c:forEach var="bean" items="${list }">
		<div class="card mb-4">
            <a href="${pageContext.request.contextPath }/detail.rec?recnum=${bean.recnum }">
            	<img class="card-img-top" src="${pageContext.request.contextPath }/resources/recipe/${bean.writer}Recipe/${bean.mainimage}" alt="Card image cap">
            </a>	
            <div class="card-body">
              <h2 class="card-title">${bean.psubject }</h2>
              <p class="card-text">${bean.intro }</p>
            </div>
            <div class="card-footer text-muted">
             ${bean.inputdate }
            </div>
        		</div>
	</c:forEach>
	</c:if>
</div>
</body>
</html>