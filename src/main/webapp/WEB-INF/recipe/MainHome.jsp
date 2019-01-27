<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../MainTop.jsp"%>
<html>
<head>
<link href="resources/vendor/bootstrap/css1/creative.css"
	rel="stylesheet">
	
	<link href="resources/vendor/bootstrap/css1/createive.min.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainPage</title>

<script type="text/javascript">
	$(function(){
		var count=1;
		ProductList();
		$("#mbtn").click(function(){
			count++;
			console.log(count);
			$.ajax({
				url : "/ex/moreRecipe.rec",
				type : "POST",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		        cache : false,
		        data : "count="+count,
		        success : function(data){
		        	var Rdata = JSON.parse(data);
		        	var uploadmainimage=JSON.parse(data);
		        	var text="";
		        	for(var i=0;i<Rdata.length;i++){
		        		text+='<div class="col-lg-4 mb-4">';
		        		text+='<div class="card h-100">';
		        		text+='<h4 class="card-header">'+Rdata[i].psubject+'</h4>';
		        		text+='<div class="card-body">';
		        		text+='<p class="card-text"><img class="card-img-top" src="resources/recipe/'+Rdata[i].writer+'Recipe/'+Rdata[i].mainimage+'" width="100%" height="300"></p>';
		        		text+='</div><div class="card-footer">';
		        		text+='<a href="#" class="btn btn-primary">Learn More</a>';
		        		text+='</div></div></div>';
		        	} 
		        	
		        	$("#moreRecipe").append(text);
		        	console.log(Rdata);

		        }
			});
		});
	});	
	function ProductList(){
		$.ajax({
			url:"/ex/product/list.mt",
			type:"post",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        cache : false,
	        success : function(data){
	        	$("#proBody").html(data);
	        }
		});
	}
</script>
</head>
<body>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<!-- Slide One - Set the background image for this slide in the line below -->
			<div class="carousel-item active"
				style="background-image: url('resources/mimg/m1.jpg')"></div>
			<!-- Slide Two - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('resources/mimg/m2.jpg')"></div>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('resources/mimg/m3.jpg')"></div>


			<!-- Slide four - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('resources/mimg/m4.jpg')"></div>


			<!-- Slide five - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url('resources/mimg/m5.jpg')"></div>
		</div>


		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>

	<br>
	<!-- Page Content -->
	<div class="container">

		
			


<c:if test="${list==null }">
			<div class="row"><p>등록된 레시피가 없습니다.</p></div>
		</c:if>
		<c:if test="${list!=null}">
	    
	     
	    
	<h2>최신레시피</h2>	    
	    
<div class="row" id="moreRecipe">
	      <c:forEach var="recipe" items="${list}">
	   
	        <div class="col-lg-4 mb-4">
	          <div class="card h-100">
	          <h4 class="card-header">${recipe.psubject}</h4>
	          <div class="card-body">
	          <p class="card-text">
							<img class="card-img-top" src="resources/recipe/${recipe.writer }Recipe/${recipe.mainimage }" width="100%" height="300" />

						</p>
	           </div>
	           <div class="card-footer">
						<a href="detail.rec?recnum=<c:out value="${recipe.recnum }"/>" class="btn btn-primary">자세히보기</a>
					</div>
			     </div>
	        </div>
	        </c:forEach>
	    
	      </div>
	      
	      <div class="col-md-4">
          <input type="button" class="btn btn-lg btn-secondary btn-block btn-primary" id="mbtn" value="더보기">
        </div>
       </c:if> 
        
        
        
        
  		<!-- Marketing Icons Section -->
	<!-- 	<div class="row">
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">앙증맞은 닭다리</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r1.jpg" width="100%" height="300" />

						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">노란밥</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r2.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">게맛살샐러드</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r3.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">초코뭐시기</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r4.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			
			
			
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">고기반찬</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r5.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">장어구이인가 더덕구이인가</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r6.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">알수없는요리</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r7.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">요깃거리</h4>
					<div class="card-body">
						<p class="card-text">
							<img src="resources/rimg/r8.jpg" width="100%" height="300" />
						</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
		</div>
		
		
		 -->
		
		
		<!-- /.row -->
		
		
<br>


 <!-- Related Projects Row -->
      <h3 class="my-4">재료구매하기</h3>

      <div class="row" id="proBody">
		
      </div>
      <!-- /.row -->







		<!-- Call to Action Section -->
		<div class="row mb-4">
			<div class="col-md-8">
				
			</div>
			<div class="col-md-4">
				<a class="btn btn-lg btn-secondary btn-block btn-primary" href="list.mt">장보러  go!go!</a>
			</div>
		</div>

	</div>




</body>
<%@include file="../MainBottom.jsp"%>
</html>