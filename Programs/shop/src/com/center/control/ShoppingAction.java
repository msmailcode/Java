/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.center.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import com.center.commons.DataConnect;
import com.center.dto.ShoppingDTO;
import com.center.model.Goodmodel;
import com.center.util.DealString;
import com.center.vo.ShoppingVO;
import com.center.vo.UserVO;

/** 
 * MyEclipse Struts
 * Creation date: 05-19-2007
 * 
 * XDoclet definition:
 * @struts.action path="/shopping" name="shoppingForm" parameter="method" scope="request" validate="true"
 */
public class ShoppingAction extends LookupDispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public Connection conn;
	public ActionForward shopping(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		ShoppingForm shoppingForm = (ShoppingForm) form;// TODO Auto-generated method stub
		conn = new DataConnect().getConn();
		ShoppingCat shoppingcat = new ShoppingCat(conn);
		String goodid = request.getParameter("goodid");
		String goodname = request.getParameter("goodname");
		
		String price = request.getParameter("price");
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO) session.getAttribute("username");
		
		ShoppingDTO shoppingdto = new ShoppingDTO();
		Goodmodel goodmanager = null;
		
		System.out.println("sdfsfasdf");
		shoppingdto.setGoodid(Integer.parseInt(goodid));
		shoppingdto.setShoptime(DealString.getDateTime());
		shoppingdto.setPrice(Double.parseDouble(price));
		shoppingdto.setUsername(uservo.getUsername());
		shoppingdto.setUserid(uservo.getUserid());
		shoppingdto.setGoodname(DealString.toGBK(goodname));
		System.out.println(shoppingdto.getGoodname()+shoppingdto.getGoodid());
		response.setContentType("text/html;charset=GBK");
		ResultSet shoplist = shoppingcat.selectgood(shoppingdto);
		boolean b = false;
		if(shoplist.next()){
			PrintWriter out = response.getWriter();
			out.println("<script language=javascript>if(confirm('您已经购买了该产品，如果需要更多的，请在购物车里更改数量')==true){location.href='/shoppingcenter/shopping.do?method=shopcat';}</script>");

		}else{
		int i = shoppingcat.shop(shoppingdto);
		if(i == 1){
			goodmanager = new Goodmodel(conn);
			int j = goodmanager.updatagood(shoppingdto);
			if(j == 1){
				
				PrintWriter out = response.getWriter();
				out.write("<script language=javascript>window.close();alert('成功购买');</script>");
				out.flush();
			}
		}
		}
		return null;
	}
	
	public ActionForward shopcat(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		ShoppingForm shoppingForm = (ShoppingForm) form;// TODO Auto-generated method stub
		conn = new DataConnect().getConn();
		ShoppingCat shoppingcat = new ShoppingCat(conn);
		ShoppingVO shoppingvo = null;
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO) session.getAttribute("username");
		
		ShoppingDTO shoppingdto = new ShoppingDTO();
		ArrayList catlist = shoppingcat.shopcat(uservo.getUserid());
		if(catlist != null){
			response.setContentType("text/html;charset=gbk");
			PrintWriter out = response.getWriter();
			Iterator catiterator = catlist.iterator();
			int i = 0;
			out.println("<table><tr><td>产品名称</td><td>是否寄出</td><td>购买时间</td><td>购买数量</td><td>修改数量</td></tr>");
			while(catiterator.hasNext()){
				shoppingvo = (ShoppingVO) catiterator.next();
				
				i++;
				out.println("<script language=javascript>function change(textid){var n = textid;var nv = n.elements[0].value;;location.href='shopping.do?method=shopcatadd&id=12&goodnum=12';}</script>");
				out.println("<form name=a"+i+" ><tr><td>"+shoppingvo.getGoodname());
				out.println("</td><td>"+shoppingvo.getSelled());
				out.println("</td><td>"+shoppingvo.getShoptime()+"</td>");
				out.println("</td><td><input type='text' size=5 value="+shoppingvo.getGoodnum()+"></td>");
				out.println("</td><td><a href='#' onclick='change(a"+i+")'>修改数量</a></td></tr></form>");
			}
			out.println("</table>");
		}
		return null;
	}
	
	public ActionForward shopcatadd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		ShoppingForm shoppingForm = (ShoppingForm) form;// TODO Auto-generated method stub
		conn = new DataConnect().getConn();
		ShoppingCat shoppingcat = new ShoppingCat(conn);
		String i = request.getParameter("goodnum");
		String id = request.getParameter("id");
		int goodnum = 0;
		int good_id = 0;
		if(!i.equals("")){
			goodnum = Integer.parseInt(i);
			System.out.println(i);
			good_id = Integer.parseInt(id); 
		}
		int j = shoppingcat.shopcatadd(good_id,goodnum);
		if(j == 1){
			shopcat(mapping, form,request, response);
		}
		return null;
	}
	
	

	@Override
	protected Map getKeyMethodMap() {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put("shop", "shopping");
		map.put("shopcat", "shopcat");
		map.put("shopcatadd", "shopcatadd");
		return map;
	}
}