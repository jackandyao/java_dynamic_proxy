package com.suning.dynamic_proxy.javassit.statics;

import com.suning.dynamic_proxy.javassit.Station;
import com.suning.dynamic_proxy.javassit.TicketService;

/**
 * Created by jack on 2018/6/19.
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        TicketService ticketService = new Station();
        TicketService ticketproxy = new  StationProxy(ticketService);
        ticketproxy.sellTicket();
    }
}
