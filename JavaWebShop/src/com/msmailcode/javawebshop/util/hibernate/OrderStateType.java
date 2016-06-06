package com.msmailcode.javawebshop.util.hibernate;

import com.msmailcode.javawebshop.model.OrderState;
/*
 * 订单状态Hibernate映射类型
 *
 */
public class OrderStateType extends EnumType<OrderState> {
	public OrderStateType() {
		super(OrderState.class);
	}
}
