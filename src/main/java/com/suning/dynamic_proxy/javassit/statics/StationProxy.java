package com.suning.dynamic_proxy.javassit.statics;

import com.suning.dynamic_proxy.javassit.Station;
import com.suning.dynamic_proxy.javassit.TicketService;

/**
 * 车票代售点
 * @author louluan
 *
 */
public class StationProxy implements TicketService {

	private TicketService station;

	public StationProxy(TicketService station){
		this.station = station;
	}
	
	@Override
	public void sellTicket() {

		// 1.做真正业务前，提示信息
		this.showAlertInfo("××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××");
		// 2.调用真实业务逻辑
		station.sellTicket();
		// 3.后处理
		this.takeHandlingFee();
		this.showAlertInfo("××××欢迎您的光临，再见！××××\n");

	}
	/*
	 * 展示额外信息
	 */
	private void showAlertInfo(String info) {
		System.out.println(info);
	}

	/*
	 * 收取手续费
	 */
	private void takeHandlingFee() {
		System.out.println("收取手续费，打印发票。。。。。\n");
	}

}
