<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map,com.msmailcode.shop_jsp.model.Model"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% Model model = new Model();
	Map<String,Object> product = model.getProduct(1);%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Book Store</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div id="wrap">
<%= product %>>
  <%@include file="/include/header.htm"%>  
  <div class="left_content">
      <div class="crumb_nav"> <a href="index.htm">home</a> &gt;&gt; product name </div>
      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title=""></span>Product name</div>
      <div class="feat_prod_box_details">
        <div class="prod_img"><a href="details.htm"><img src="images/prod1.gif" alt="" title="" border="0"></a> <br>
          
           </div>
        <div class="prod_det_box">
          <div class="box_top"></div>
          <div class="box_center">
            <div class="prod_title">Details</div>
            <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.<br>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation. </p>
            <div class="price"><strong>PRICE:</strong> <span class="red">100 $</span></div>
            
            <a href="details.htm" class="more"><img src="images/order_now.gif" alt="" title="" border="0"></a>
            <div class="clear"></div>
          </div>
          <div class="box_bottom"></div>
        </div>
        <div class="clear"></div>
      </div>
      <div id="demo" class="demolayout">
        <ul id="demo-nav" class="demolayout">
          <li><a class="active" href="#tab1">More details</a></li>
          
        </ul>
        <div class="tabs-container">
          <div style="display: block;" class="tab" id="tab1">
            <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation. </p>
            <ul class="list">
              <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
              <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
              <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
              <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
            </ul>
            <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation. </p>
          </div>
          <div style="display: none;" class="tab" id="tab2">
            <div class="new_prod_box"> <a href="details.htm">product name</a>
              <div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0"></a> </div>
            </div>
            <div class="new_prod_box"> <a href="details.htm">product name</a>
              <div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0"></a> </div>
            </div>
            <div class="new_prod_box"> <a href="details.htm">product name</a>
              <div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0"></a> </div>
            </div>
            <div class="new_prod_box"> <a href="details.htm">product name</a>
              <div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0"></a> </div>
            </div>
            <div class="new_prod_box"> <a href="details.htm">product name</a>
              <div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0"></a> </div>
            </div>
            <div class="new_prod_box"> <a href="details.htm">product name</a>
              <div class="new_prod_bg"> <a href="details.htm"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0"></a> </div>
            </div>
            <div class="clear"></div>
          </div>
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