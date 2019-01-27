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
    <c:if test="${list==null }">
    	<div align="center">
    		<h1>소통을 하러가요!</h1>
    		<a href="${pageContext.request.contextPath }/talk/insert.bod" class="btn btn-primary">토크등록</a>
    	</div>
    </c:if>
    <c:if test="${list!=null }">
	<c:forEach var="bean" items="${list }">
		<div class="card mb-4">
			<c:if test="${bean.timage!=null }">
	            <a href="${pageContext.request.contextPath }/talk/detailView.bod?tnum=${bean.tnum }">
	            	<img class="card-img-top" src="${pageContext.request.contextPath }/resources/img/${bean.timage}" alt="Card image cap">
	            </a>	
            </c:if>
            <div class="card-body">
              <p class="card-text">${bean.tcontent }</p>
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