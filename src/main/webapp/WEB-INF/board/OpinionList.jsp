<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">고객센터게시판
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
        	<c:if test="${cate=='question' }">
				자주 묻는 질문
			</c:if>
			<c:if test="${cate=='insert' }">
				문의 하기
			</c:if>
			<c:if test="${cate=='oplist' }">
				문의 게시판
			</c:if>
        </li>
      </ol>

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-9" id="body">
        <c:if test="${cate=='question' }">
			<%@include file="OpinionQuestion.jsp" %>	         
		</c:if>
		<c:if test="${cate=='insert' }">
			<%@include file="OpinionInsert.jsp" %>
		</c:if>
		<c:if test="${cate=='oplist' }">
			<%@include file="OpinionSubList.jsp" %>
		</c:if>
        
        </div>

        <%@include file="OpinionSideBar.jsp" %>
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
</body>
<%@ include file="../MainBottom.jsp" %>
</html>