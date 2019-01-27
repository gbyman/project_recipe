<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../MainTop.jsp" %>
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
        	문의게시판
        </li>
      </ol>

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-9" id="body">
		<div class="panel panel-default">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive" align="center">
                        <table class="table">
                            <thead>
                            	<tr>
                            		<th>제목</th>
                            		<td colspan="3">${bean.opsubject }</td>
                            	</tr>
                            	
                                <tr>
                                    <th>작성자</th>
                                    <td>${bean.opid }</td>
                                    <th>작성일</th>
                                    <td><fmt:formatDate value="${bean.currdate }" pattern="yyyy-MM-dd"/></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr align="center">
                                	<th colspan="4">내용</th>
                                </tr>
                                <tr align="left">
                                	<td colspan="4">${bean.opcontent }</td>
                                </tr>
                                
                                <tr>
                                    
                                    <td align="center" colspan="4"> 
                                    	<input type="button" value="삭제"
                                    	onclick="location.href='${pageContext.request.contextPath}/opinion/delete.bod?pageNumber=${pageNumber }&opnum=${bean.opnum }'">
                                    	<input type="button" value="답글"
                                    	onclick="location.href='${pageContext.request.contextPath}/opinion/reply.bod?pageNumber=${pageNumber }&opnum=${bean.opnum }&ref=${bean.ref }&restep=${bean.restep }&relevel=${bean.relevel }'">
                                    </td>
                                </tr>
                           
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
</div>

        <%@include file="OpinionSideBar.jsp" %>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
</body>
<%@include file="../MainBottom.jsp" %>
</html>