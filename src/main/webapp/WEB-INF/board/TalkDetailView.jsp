<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>토크 자세히 보기</title>
<script type="text/javascript">
$(document).ready(function(){
	var count=1;
	replyList();
	
});
var id='${loginInfo.id}';
var nickname='${loginInfo.nickname}';
var img='${loginInfo.img}';
function InsertReply(){
	if(id==""){
		var flag=confirm("댓글을 쓰시려면 로그인을 해야합니다. 로그인 페이지로 이동하겠습니까?");
		if(flag){
			location.href='/ex/login.mem';
		}else{
			return;
		}
	}
	console.log(id+nickname+img);
	var contents=$("#comment_tx").val();
	  $.ajax({
		url:"/ex/reply/insert.bod",
		data:{
			cate:'talk',
			canum:${tcontainer.tnum},
			rewriter:id,
			content:contents,
			renickname:nickname,
			reimg:img
		},
		type : "POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        cache : false,
        success : function(data){
        	if(data>0){
	        	alert("댓글작성에 성공하였습니다.");
	        	$("#comment_tx").val("");
	        	replyList();
        	}else{
        		alert("댓글작성에 실패하였습니다.");
        	}
			
        }
	});  
};
function replyList(){
	console.log(id);
	$.ajax({
		url:"/ex/reply/list.bod",
		type:"post",
		data:'cate=talk&canum='+${tcontainer.tnum},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        cache : false,
        success : function(data){
        	$("#replyBody").html(data);
        }
	});
};
function replyReply(num,f,level,step){
	var text='';
	text+='<div class="reply_write"><div class="input-group" style="position:relative;"><textarea id="re_comment_tx" class="form-control" placeholder="" style="height:100px; width:100%; resize:none;"></textarea>';
    text+='<span class="input-group-btn"><button onclick="replyReplyProc('+num+','+f+','+level+','+step+')" class="btn btn-default" type="button" style="height:100px; width:100px;">등록</button></span></div></div>';
    $(".replyContent"+num).html(text);
		
}
function replyUpdate(num,contents){
	console.log(num+contents);
	var text='';
	text+='<div class="reply_write"><div class="input-group" style="position:relative;"><textarea id="reup_comment_tx" class="form-control" placeholder="" style="height:100px; width:100%; resize:none;">'+contents+'</textarea>';
    text+='<span class="input-group-btn"><button onclick="replyUpdateProc('+num+',\''+contents+'\')" class="btn btn-default" type="button" style="height:100px; width:100px;">등록</button></span></div></div>';
    $(".replyUpdate"+num).html(text);
	
}

function replyDelete(renum){
	$.ajax({
		url:"/ex/reply/delete.bod",
		type:"post",
		data:'renum='+renum,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        cache : false,
        success : function(deleteData){
        	if(deleteData>0){
	        	alert("댓글삭제에 성공하였습니다.");
				replyList();
        	}else{
        		alert("댓글삭제에 실패하였습니다.");
        	}
        }
	});
};
function replyReplyProc(num,f,level,step){
	if(id==""){
		var flag2=confirm("댓글을 쓰시려면 로그인을 해야합니다. 로그인 페이지로 이동하겠습니까?");
		if(flag2){
			location.href='/ex/login.mem';
		}else{
			return;
		}
	}
	var contents=$("#re_comment_tx").val();
	 $.ajax({
		url:"/ex/reply/reInsert.bod",
		data:{
			cate:'talk',
			canum:${tcontainer.tnum},
			rewriter:id,
			content:contents,
			renickname:nickname,
			reimg:img,
			ref:f,
			restep:step,
			relevel:level,
			parentnum:num
		},
		type:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success : function(data){
        	if(data>0){
	        	alert("댓글작성에 성공하였습니다.");
	        	replyList();
        	}else{
        		alert("댓글작성에 실패하였습니다.");
        	}
        }
	}); 
}
function replyUpdateProc(num,contents){
	alert(num+contents);
	var contents=$("#reup_comment_tx").val();
	 $.ajax({
		url:"/ex/reply/reUpdate.bod",
		data:{
			renum:num,
			content:contents
		},
		type:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
       success : function(data){
       	if(data>0){
	        	alert("댓글수정에 성공하였습니다.");
	        	replyList();
       	}else{
       		alert("댓글수정에 실패하였습니다.");
       	}
       }
	}); 
	
}

</script>             
</head>
<body>
<!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">토크 자세히 보기</h1>

      <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-12">

          <!-- Blog Post -->
          <div class="card mb-4">
          	<div class="card-header">
      		 <a href="<%= contextPath %>/myPage.mem?tid=${tcontainer.tid }"><img alt="프로필사진" src="<%= contextPath %>/resources/img/${tcontainer.tid}Profile/${tcontainer.img}" width="100" height="100"> </a>
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
              <p class="card-text">${tcontainer.tcontent }</p>
            </div>
            <div class="col-lg-12">
            	<c:if test="${tcontainer.timage!=null}">
                	<img class="img-fluid rounded" src="<%= contextPath %>/resources/img/${tcontainer.timage}" alt="">
                </c:if>
                <c:if test="${tcontainer.tmovie!=null}">
                	<iframe width="650" height="400" src="https://www.youtube.com/embed/${tcontainer.tmovie }" frameborder="0" gesture="media" allow="encrypted-media" allowfullscreen></iframe>
                </c:if>
            </div>
          </div>
        </div>
            
          </div>

          <!-- Blog Post -->
          <div class="card mb-4">
          	<h2 class="card-header text-muted">
				댓글
            </h2>
            <div class="card-body" id="replyBody">
              
            </div>
            

            
            <div class="card-footer" id="next_comment"></div>
            <div class="reply_write">
                
                <div id="area_dv" class="input-group" style="position:relative;">
                    <textarea name="comment_tx" id="comment_tx" class="form-control" placeholder="" style="height:100px; width:100%; resize:none;"></textarea>
                    <span class="input-group-btn"><button onclick="InsertReply()" class="btn btn-default" type="button" style="height:100px; width:100px;">등록</button></span>
                </div>
            </div>
          </div>

        </div>

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->


</body>
<%@ include file="../MainBottom.jsp" %>
</html>