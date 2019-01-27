<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

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
<script type="text/javascript">
function insertProcedure(){
	var form = new FormData(document.getElementById('fileForm'));
	console.log(form);
     $.ajax({
         type : 'post',
         url : 'procedureInsert.rec',
         data : form,
         processData: false,
         contentType: false,
         success : function(data) {
        	 if(data>0){
             	alert("파일 업로드하였습니다.");
             	procedureList();
        	 }
         },
         error : function(error) {
             alert("파일 업로드에 실패하였습니다.");
             console.log(error);
             console.log(error.status);
         }
     });
}
$(function(){
	procedureList();
	$("#proimage").change(function(){
		readURL1(this);
	});
})
function readURL1(input) {
	   if (input.files && input.files[0]) {
	       var reader = new FileReader();
	       
	       reader.onload = function (e) {
	           $('#img').attr('src', e.target.result);
	       }
	       
	       reader.readAsDataURL(input.files[0]);
	   }
}
function procedureList(){
	$.ajax({
		url:"procudureList.rec",
		type:"post",
		data:'recnum='+${recipe.recnum},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        cache : false,
        success : function(data){
        	$("#procedureBody").html(data);
        }
	});
}


</script>
</head>
<body>
	<c:set var="uploadmainimage"
		value="${pageContext.request.contextPath }/resources/recipe/${recipe.writer}Recipe/${recipe.mainimage }" />
	<c:set var="uploadimage1"
		value="${pageContext.request.contextPath }/resources/recipe/${recipe.writer}Recipe/${recipe.image1 }" />
	<c:set var="uploadimage2"
		value="${pageContext.request.contextPath }/resources/recipe/${recipe.writer}Recipe/${recipe.image2 }" />
	<c:set var="uploadimage3"
		value="${pageContext.request.contextPath }/resources/recipe/${recipe.writer}Recipe/${recipe.image3 }" />
	<c:set var="uploadimage4"
		value="${pageContext.request.contextPath }/resources/recipe/${recipe.writer}Recipe/${recipe.image4 }" />


<div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">
      	레시피 자세히 보기
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
			작성자 ${recipe.writer }
        </li>
        <li class="breadcrumb-item active">작성일 ${recipe.inputdate }</li>
      </ol>

      <!-- Portfolio Item Row -->
      <div class="row">

        <div class="col-md-8">
          <img class="img-fluid" src="${uploadmainimage}" alt="">
        </div>

        <div class="col-md-4">
          <h3 class="my-3">요리 소개</h3>
          <p>${recipe.intro}</p>
          
        </div>

      </div>
      <!-- /.row -->

      <!-- Related Projects Row -->
      <h3 class="my-4">완성된 요리사진</h3>

      <div class="row">

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="${uploadimage1}" alt="">
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="${uploadimage2}" alt="">
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="${uploadimage3}" alt="">
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="${uploadimage4}" alt="">
          </a>
        </div>

      </div>
      <!-- /.row -->
   	<div class="card mb-4">
		<div class="card-header">
		요리 절차
		</div>
		<div class="card-body" id="procedureBody">
		</div>
	</div>
	<c:if test="${loginInfo.id=='admin' }">
		<div class="card mb-4">
		<div class="card-header">
			요리 절차 등록하기
		</div>
		<form action="procedureInsert.rec" enctype="multipart/form-data" method="post" id="fileForm">
        <div class="card-body">
          <div class="row">
				<input type="hidden" name="recnum" value="${recipe.recnum }">          	
            <div class="col-lg-8">
 				<textarea name=procontent id="procontent" class="form-control" placeholder="" style="height:177px; width:100%; resize:none;"></textarea>
            </div>
            <div class="col-lg-4" align="center">
              <input type="file" name="proUpload" id="proimage" style="display: none;">
              <img src="http://recipe.ezmember.co.kr/img/pic_none3.gif" alt="파일첨부" width="200" height="200" onclick="document.getElementById('proimage').click();" style="cursor:pointer;" id="img"/>
            </div>
          </div>
        </div>
        <div class="card-footer text-muted" align="center">
          <input type="button" class="btn btn-primary" onclick="insertProcedure()" value="등록"></a>
        </div>
        </form>
      </div>
	</c:if>
	<a href="delete.rec?recnum=<c:out value="${recipe.recnum }"/>" class="btn btn-primary">삭제하기</a>
	
    </div>
    <!-- /.container -->


<%-- <div class="container">
<br>


<div class="col-md-12" >
				<!-- Blog Post -->
				<div class="card mb-4">

					<div class="card-body" style="padding: 4%">
        
        
		<table border="0">
			<tr>
				<td width="50%"><img width="490" height="490"
					src="${uploadmainimage }" /></td>
				<td width="50%"><div style="padding: 10%">
						<h2>
							<c:out value="${recipe.psubject }" />
						</h2>
						<br>
						<c:out value="${recipe.intro }" />
						<br><br>
						<hr>
						<br>
					</div></td>
			</tr>
			
			<tr align="center">
				<td colspan="2"><br><br><img width="500" height="500" src="${uploadimage1 }" /></td>
			</tr>

			<tr align="center">
				<td colspan="2"><img width="500" height="500" src="${uploadimage2 }" /></td>
			</tr>

			<tr align="center">
				<td colspan="2"><img width="500" height="500" src="${uploadimage3 }" /></td>
			</tr >

			<tr align="center">
				<td colspan="2"><img width="500" height="500" src="${uploadimage4 }" /></td>
			</tr>

			<tr height="50" align="center">
				<td colspan="2"><c:out value="${recipe.movieurl }" /></td>
			</tr>
		</table>





	<br>
	<div align="center">
		<input type="button" value="목록보기" onclick="goList();" class="btn btn-primary"/> 
		<c:if test="${loginInfo.id=='admin'}">
			<input type="button" value="삭제" value="${recipe.recnum }"  class="btn btn-primary"
			onclick="goDelete('${recipe.recnum}')" /> 
			<input type="button" value="수정" value="${recipe.recnum }"  class="btn btn-primary"
			onclick="goUpdate('${recipe.recnum}')" /> 
		</c:if>
		
		
		
	</div>
</div>
</div></div></div> --%>
</body>

<script type="text/javascript">
	function goList() { // 버튼 누르면 레시피로 이동
		location.href = 'list.rec'; //get 방식
	}

	function goUpdate(num) { //수정하기 버튼눌렀을 때 recnum을 담아서 간다
		location.href = 'update.rec?recnum=' + num; //RecipeUpdateController get
	}

	function goDelete(num) { //삭제 버튼 눌렀을 때 recnum을 담아서 간다
		location.href = 'delete.rec?recnum=' + num; //RecipeDeleteController get 
	}

	function goScrap(num) { //스크랩 버튼 눌렀을 때 recnum을 통해 정보를 가져와서 마이페이지와 연동

	}
</script>
<%@include file="../MainBottom.jsp"%>
</html>