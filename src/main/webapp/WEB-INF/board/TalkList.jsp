<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
	  var count=1;
		$(document).scroll(function() {
	    var maxHeight = $(document).height();
	    var currentScroll = $(window).scrollTop() + $(window).height();
		
	    if (maxHeight <= currentScroll + 100) {
    	  count++;
			$.ajax({
				url : "/ex/talk/infinitescroll.bod",
				type : "POST",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		        cache : false,
		        data : "count="+count,
		        success : function(Rdata){
		        	
		        	$("#infinite").append(Rdata);

		        }
	      });
	    };
	  });
	});
</script>
</head>
<body>

<!-- Page Content -->
    <div class="container" id="infinite">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">토크
        <small>서로 소통해보아요 </small>
      </h1>
    	<c:if test="${loginInfo!=null }">
    	 <a href="<%= contextPath %>/talk/insert.bod" class="btn btn-primary">등록</a>
		</c:if>
      <!-- Blog Post -->
      <c:forEach var="tcontainer" items="${list }">
      
      <div class="card mb-4">
       <div class="card-header">
       <a href="<%= contextPath %>/myhome.mem?tid=${tcontainer.tid }">
       		<c:if test="${tcontainer.img!='basic.png' }">
              <img alt="프로필사진" src="${pageContext.request.contextPath }/resources/img/${tcontainer.tid}Profile/${tcontainer.img}" width="100"height="100"><br>
            </c:if>
            <c:if test="${tcontainer.img=='basic.png' }">
              <img alt="프로필사진" src="${pageContext.request.contextPath }/resources/img/${tcontainer.img}" width="100"height="100"><br>
            </c:if>
       </a>
          ${tcontainer.nickname }
          <c:if test="${loginInfo.id==tcontainer.tid}">
          	<a href="<%= contextPath %>/talk/update.bod?tnum=${tcontainer.tnum }" class="btn btn-primary">수정</a>
          	<a href="<%= contextPath %>/talk/delete.bod?tnum=${tcontainer.tnum }" class="btn btn-primary">삭제</a>
          </c:if>
          <br>
          ${tcontainer.timeString }
          
          
        </div>
        <div class="card-body">
          <div class="row">
            
            <div class="col-lg-12">
            	<a href="<%= contextPath %>/talk/detailView.bod?tnum=${tcontainer.tnum }">
              		<p class="card-text">${tcontainer.tcontent }</p>
              	</a>
            </div>
            <div class="col-lg-12">
              <a href="<%= contextPath %>/talk/detailView.bod?tnum=${tcontainer.tnum }">
              	<c:if test="${tcontainer.timage!=null }">
                	<img class="img-fluid rounded" src="<%= contextPath %>/resources/img/${tcontainer.timage}" width="300">
                </c:if>
              </a>
              <c:if test="${tcontainer.tmovie!=null }">
              	<iframe width="300" height="200" src="https://www.youtube.com/embed/${tcontainer.tmovie }" frameborder="0" gesture="media" allow="encrypted-media" allowfullscreen></iframe>
              </c:if>
            </div>
          </div>
        </div>
       
      </div>
	 </c:forEach>

    </div>

  <!-- /.container -->
</body>
<%@ include file="../MainBottom.jsp" %>
</html>