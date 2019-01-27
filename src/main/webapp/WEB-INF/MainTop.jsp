<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	String contextPath=request.getContextPath();
	String Path=request.getRealPath("/map");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap core CSS -->
    <link href="<%= contextPath %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%= contextPath %>/resources/css/modern-business.css" rel="stylesheet">
   
    <script src="<%= contextPath %>/resources/js/jquery.js" type="text/javascript"></script>
    

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
a {
   color: black;
   font-size: 16px;
   font-weight: bold;
   font-family: "Trebuchet MS", Dotum, Arial;
}
#topMenu {
   height: 50px;
   background-color: #FFC0CB;
   

}

#topMenu ul li {
   list-style: none;
   color: black;
   background-color: #FFC0CB;
   float: left;
   line-height: 50px;
   vertical-align: middle;
   text-align: center;
}

#topMenu .menuLink {
   text-decoration: none;
   color: black;
   display: block;

   width: 270px;
   font-size: 18px;
   font-weight: bold;
   font-family: "Trebuchet MS", Dotum, Arial;
}

#topMenu .menuLink:hover {
   color: #FF1493;
   
}
#quick {
	background-color:white; 
	border: 2px solid #FFC0CB;
    border-radius: 5px;
	position: absolute;
	top: 175px;
	right: 0;
	z-index: 97;
	height: 447px;
}

#quick {
	position: absolute;
	top: 175px;
	right: 0;
	z-index: 97;
	height: 447px;
}

#quick .quick_bg {
	width: 129px;
	height: 524px;
	background: url(../images/quick_bg.png) right 0 no-repeat;
	padding-left: 19px;
	padding-top: 2px
}

#quick .quick_bg.bg2 {
	height: 447px;
	background: url(../images/quick_bg3.png) right 0 no-repeat;
}

.quick_inner {
	position: relative;
	padding-top: 20px;
	height: 100%;
}

.quick_link {
	margin-left: 16px; /* border-bottom:1px solid #f6f6f6; */
	width: 78px;
	padding-bottom: 17px;
}

.quick_link a {
	display: block;
	font-size: 12px;
	color: #5e5e5e;
	margin-top: 20px;
	line-height: 14px;
}

.quick_link a:first-child {
	margin: 0;
}

.quick_link a img {
	display: inline-block;
	vertical-align: middle;
	margin-right: 5px;
	margin-top: -2px
}

.quick_product {
	margin-left: 15px;
}

.quick_prod_top {
	padding-top: 16px;
	width: 79px;
	margin-bottom: 8px;
}

.quick_prod_top img {
	margin: 0 auto;
}

.quick_prod_top p {
	text-align: center;
	font-size: 12px;
	color: #5e5e5e;
	line-height: 12px;
	margin-top: 7px;
}

.quick_area {
	font-size: 0;
	line-height: 0;
	overflow: hidden;
	position: relative;
}

.quick_areaList {
	position: absolute;
	top: 0px;
	height: 255px;
}

.quick_area .quick_areaList .sliderQuick {
	margin-bottom: 9px;
}

.quick_area .quick_areaList a {
	display: block;
	width: 79px;
	height: 79px;
	position: relative;
	overflow: hidden;
}

.quick_area .quick_areaList img {
	width: 100%;
	position: absolute;
	bottom: 0;
}

.quick_areaList .no_list {
	padding-top: 100px;
	line-height: 20px;
	font-size: 12px;
	color: #888;
	text-align: center;
	word-break: keep-all;
}

.quick_today_btn {
	font-size: 0;
	line-height: 0;
	margin-top: 9px;
}

.quick_today_btn a:first-child {
	margin-right: 2px;
}

.quick_today_btn img {
	float: left;
	margin-right: 3px;
}

#quick .quicktop {
	display: block;
	position: absolute;
	width: 110px;
	right: 0;
	bottom: 7px;
	height: 34px;
	line-height: 34px;
	text-align: center;
	font-size: 10px;
	color: #383838;
	font-weight: 500
}

#quick .quick_btn {
	display: block;
	position: absolute;
	left: 0;
	top: 224px;
	width: 19px;
	height: 64px;
	background: url(../images/btn_quick_off.png) 0 0 no-repeat;
}

#quick .quick_btn {
	position: absolute;
	left: 0;
	top: 50%;
	margin-top: -30px;
}

#quick .quick_btn.on {
	background: url(../images/btn_quick_on.png) 0 0 no-repeat;
}

#quick.off {
	background: none;
}

#quick.off .quick_bg {
	display: none;
}

#quick.off .quick_inner {
	display: none;
}

#quick.off .quicktop {
	display: none;
}
</style>
<script>
	$(document).ready(function() {

		// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
		var floatPosition = parseInt($("#quick").css('top'));
		// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

		$(window).scroll(function() {
			// 현재 스크롤 위치를 가져온다.
			var scrollTop = $(window).scrollTop();
			var newPosition = scrollTop + floatPosition + "px";

			/* 애니메이션 없이 바로 따라감
			 $("#quick").css('top', newPosition);
			 */

			$("#quick").stop().animate({
				"top" : newPosition
			}, 500);

		}).scroll();

	});
	

	
</script>



</head>
<body>
<!-- <div id="quick">
		<div class="quick_bg">
			<div class="quick_inner">
					
				<div class="quick_link">
					<a href=""><img
						src="" />장바구니</a>
			
				
				</div>
			</div>
		</div>
		<a href="javascript:void(0);" class="quicktop">top</a>	
		<a href="javascript:quick_click();" class="quick_btn on"><img src="resources/mimg/btn_quick_on.png"></a>
	</div>
 -->
	<script type="text/javascript">
		function quick_click() {
			if ($('.quick_btn').hasClass('on')) {
				$('.quick_btn').removeClass('on');
				$('#quick').animate({
					"width" : "19"
				}, 500, function() {
					$('#quick').addClass('off');
				});
			} else {
				$('.quick_btn').addClass('on');
				$('#quick').animate({
					"width" : "129"
				}, 500);
				$('#quick').removeClass('off');
			}
		}
	
	
		$(document).ready(function() {
			// 퀵메뉴
	
			if ($("#qVal").val() != "1") {
				var currentPosition = parseInt($("#quick").css("top"));
				$(window).scroll(function() {
					var position = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
					var sHeight = position + currentPosition;
					if ($(document).height() > 900) $("#quick").stop().animate({
							"top" : sHeight + "px"
						}, 1000);
				//$("#quick2").stop().animate({"top":position+currentPosition+"px"},1000); 
				});
			}
	
			// 맨위로
			$('.quicktop').click(function() {
				$('html, body').animate({
					scrollTop : 0
				}, 'slow');
			});
		});
	</script>
  <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg bg-white fixed-top">
      <div class="container">
        
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
          	<c:if test="${loginInfo==null }">
	            <li class="nav-item">
	              <a class="nav-link" href="<%= contextPath %>/login.mem" href="login.mem" style="color: black;">로그인</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="<%= contextPath %>/insert.mem" href="login.mem" style="color: black;">회원가입</a>
	            </li>
            </c:if>
            <c:if test="${loginInfo!=null }">
	            <li class="nav-item">
	              <a class="nav-link" href="<%= contextPath %>/logout.jsp" href="login.mem" style="color: black;">로그아웃</a>
	            </li>
	            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" style="color: black;"aria-haspopup="true" aria-expanded="false">
                	마이페이지
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="<%= contextPath %>/myhome.mem">MyHome</a>
                <a class="dropdown-item" href="<%= contextPath %>/pass.mem?passnum=1">개인정보수정</a>
                <a class="dropdown-item" href="<%= contextPath %>/pass.mem?passnum=2">비밀번호수정</a>
                <a class="dropdown-item" href="<%= contextPath %>/order.mall">주문내역</a>
                <a class="dropdown-item" href="<%= contextPath %>/myhome.mem?tid=${loginInfo.id }&cate=opinion">문의내역</a>
              </div>
            </li>
            </c:if>
            <li class="nav-item">
              <a class="nav-link" href="<%= contextPath %>/opinion/list.bod" style="color: black;">고객센터</a>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    
    
    
   
	
    
    
    <div class="container" align="center">

      <a href="<%= contextPath %>/mainPage.rec"> <img src="<%= contextPath %>/resources/bg.jpg" width="40%"
         alt="올레시피" />
      </a>

	<div align="right">
		<form action="list.rec" method="get">
		<input type="hidden" name="what" value="yes">
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form> </div>


   </div>
   <nav id="topMenu" >
<div align="center" >
   <ul>
      <li><a class="menuLink" href="<%= contextPath %>/list.rec">레시피</a></li>
      <li><a class="menuLink" href="<%= contextPath %>/talk/list.bod">토크</a></li>
      <li><a class="menuLink" href="<%= contextPath %>/infolist.bod?infokind=image">요리정보</a></li>
      <li><a class="menuLink" href="<%= contextPath %>/list.mt?pkind=pkind1">올마트</a></li>
      <li><a class="menuLink" href="<%= contextPath %>/list.cf">내가셰프</a></li>
   </ul>
   </div>
   </nav>
<br>
</body>
</html>
