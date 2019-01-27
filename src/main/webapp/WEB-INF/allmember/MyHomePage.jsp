<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function profilePop(profile){
		var winW=600;
		var winH=600;
		
		var winleft=(screen.width - winW)/2;
		var wintop=(screen.height - winH)/2;
		
		var options="width="+winW+",height=" +winH+",left="+winleft+",top="+wintop;
		//left,top은 팝업창의 왼쪽 위 꼭지점 위치임
		open(profile,'Profile',options);

	}
</script>
</head>
<body>
<div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">MyPage
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath }/myhome.mem?tid=${container.id }&cate=recipe">Recipe</a>
        </li>
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath }/myhome.mem?tid=${container.id }&cate=talk">Talk</a>
        </li>
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath }/myhome.mem?tid=${container.id }&cate=reply">Reply</a>
        </li>
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath }/myhome.mem?tid=${container.id }&cate=opinion">Opinion</a>
        </li>
      </ol>

      <div class="row">

        <!-- Post Content Column -->
        <c:if test="${cate=='recipe' }">
        	<%@include file="RecipeBody.jsp" %>
        </c:if>
        <c:if test="${cate=='talk' }">
        	<%@include file="TalkBody.jsp" %>
        </c:if>
        <c:if test="${cate=='reply' }">
        	<%@include file="ReplyBody.jsp" %>
        </c:if>
       	<c:if test="${cate=='opinion' }">
        	<%@include file="opinionBody.jsp" %>
        </c:if>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Search Widget -->
          <div class="card mb-4">
            <div class="card-body" align="center">
            
           	<a <c:if test="${loginInfo.id!=container.id }">
           			href="#"
           		</c:if>
	           	<c:if test="${loginInfo.id==container.id }">
	           		onclick="profilePop('profile.mem?img=${container.img}&tid=${container.id }')"
	           	</c:if>>
            
            <c:if test="${container.img!='basic.png' }">
            
              		<img alt="프로필사진" src="${pageContext.request.contextPath }/resources/img/${container.id}Profile/${container.img}" width="200"height="200" id="profile"><br>
              	
            </c:if>
            <c:if test="${container.img=='basic.png' }">
              	<img alt="프로필사진" src="${pageContext.request.contextPath }/resources/img/${container.img}" width="200"height="200" id="profile"><br>
            </c:if>
            </a>
              <b>${container.nickname }</b>
            </div>
          </div>
          	<c:if test="${loginInfo.id==container.id }">
			<div class="card my-4">
            <h5 class="card-header">Categories</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-12">
                  <ul class="list-unstyled mb-0">
                    <li>
                      <a href="${pageContext.request.contextPath }/myhome.mem">MyPageHome</a>
                    </li>
                    <hr>
                    <li>
                      <a href="${pageContext.request.contextPath }/pass.mem?passnum=1">개인정보수정</a>
                    </li>
                    <hr>
                    <li>
                      <a href="${pageContext.request.contextPath }/pass.mem?passnum=2">패스워드수정</a>
                    </li>
                    <hr>
                    <li>
                      <a href="#">주문내역</a>
                    </li>
                    <hr>
                    <li>
                      <a href="#">문의내역</a>
                    </li>
                    <hr>
                    <li>
                      <a href="${pageContext.request.contextPath }/pass.mem?passnum=3">회원탈퇴</a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          </c:if>
        </div>
		
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
</body>
<%@ include file="../MainBottom.jsp" %>
</html>