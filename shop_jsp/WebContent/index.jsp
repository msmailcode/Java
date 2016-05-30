<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.msmailcode.shop_jsp.*"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div id="wrap">
  <%@include file="/include/header.htm"%>
  <div class="center_content">
    <div class="left_content">
      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>热销商品</div>
      
      <div class="feat_prod_box">
        <div class="prod_img"><a href="details.htm"><img src="images/prod1.gif" alt="" title="" border="0" /></a></div>
        <div class="prod_det_box">
          <div class="box_top"></div>
          <div class="box_center">
            <div class="prod_title">Product name</div>
            <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
            <a href="details.htm" class="more">- more details -</a>
            <div class="clear"></div>
          </div>
          <div class="box_bottom"></div>
        </div>
        <div class="clear"></div>
      </div>
      
      <div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" title="" /></span>最新上架</div>

      <div class="new_products">
        <div class="new_prod_box"> <a href="details.htm">product name</a>
          <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
        </div>
      </div>
      
      <div class="clear"></div>
    </div>
    <!--end of left content-->
  <%@include file="/include/right.jsp"%>
    <div class="clear"></div>
  </div>
  <!--end of center content-->
  <%@include file="/include/footer.htm"%>
</div>
</body>
</html>
