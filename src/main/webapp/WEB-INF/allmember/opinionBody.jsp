<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
                <!-- /.panel-heading -->
                <div class="col-lg-8">
                    <div class="table-responsive" align="center">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성일</th>
                                    <th>삭제</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="bean" items="${list }">
                                <tr>
			                        
                                    <td>
                                    <c:if test="${bean.relevel>0 }">
										<c:set var="wid" value="${bean.relevel*20 }" />
										<img src="${pageContext.request.contextPath }/resources/img/level.gif" width="${wid }" height="16">
										<img src="${pageContext.request.contextPath }/resources/img/re.gif">
									</c:if> 
									<c:if test="${bean.relevel<=0 }">
										<img src="${pageContext.request.contextPath }/resources/img/level.gif" width="0" height="16">
									</c:if> 
	                                    <a href="${pageContext.request.contextPath}/opinion/detail.bod?pageNumber=${pageInfo.pageNumber }&opnum=${bean.opnum }">
	                                    ${bean.opsubject }</a>
                                    </td>
                                    <td>${bean.opid }</td>
                                    <td><fmt:formatDate value="${bean.currdate }" pattern="yyyy-MM-dd"/></td>
                                    <td>
                                    	<input type="button" value="삭제"
                                    	onclick="location.href='${pageContext.request.contextPath}/opinion/delete.bod?pageNumber=${pageInfo.pageNumber }&opnum=${bean.opnum }'">
                                    </td>
                                </tr>
                            </c:forEach>
                           
                            </tbody>
                        </table>
                         ${pageInfo.pagingHtml }
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            <!-- /.panel -->
</body>
</html>