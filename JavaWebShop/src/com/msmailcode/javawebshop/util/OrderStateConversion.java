package com.msmailcode.javawebshop.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.msmailcode.javawebshop.model.OrderState;
/*
 * 订单状态类型转换器
 *
 *
 */
public class OrderStateConversion extends StrutsTypeConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		OrderState[] orderStates = OrderState.values();
		for (OrderState orderState : orderStates) {
			if(orderState.getName().equals(arg1[0])){
				return orderState;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		OrderState orderState = (OrderState) arg1;
		return orderState.getName();
	}

}
