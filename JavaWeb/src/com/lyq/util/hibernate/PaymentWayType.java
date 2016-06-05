package com.msmailcode.javawebshop.util.hibernate;

import com.msmailcode.javawebshop.model.PaymentWay;
/**
 * 支付方式Hibernate映射类型
 * @author Li Yongqiang
 */
public class PaymentWayType extends EnumType<PaymentWay> {
	public PaymentWayType() {
		super(PaymentWay.class);
	}
}
