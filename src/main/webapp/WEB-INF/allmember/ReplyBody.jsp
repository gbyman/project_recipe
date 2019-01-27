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
    		<h1>등록된 댓글이 없습니.</h1>
    	</div>
    </c:if>
    <c:if test="${list!=null }">
	<c:forEach var="bean" items="${list }">
		<div class="card mb-4">
           	
            <div class="card-body">
            	
              <p class="card-text">${bean.cate }게시판에 댓글을 등록하셨습니다.</p><br>
              <p class="card-text">${bean.content }</p>
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