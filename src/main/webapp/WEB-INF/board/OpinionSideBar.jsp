<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Sidebar Widgets Column -->
        <div class="col-md-3">

          <!-- Categories Widget -->
          <div class="card my-4" align="center">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-12">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="<%=contextPath %>/opinion/list.bod?cate=question">자주 묻는 질문</a>
                    </li>
                    <hr>
                    <li>
                      <a href="<%=contextPath %>/opinion/insert.bod">문의하기</a>
                    </li>
                    <c:if test="${loginInfo.id=='admin'}">
                    	<hr>
	                    <li>
	                      <a href="<%=contextPath %>/opinion/list.bod?cate=oplist">문의게시판</a>
	                    </li>
                    </c:if>
                  </ul>
                </div>
                
              </div>
            </div>
          </div>

        </div>
</body>
</html>