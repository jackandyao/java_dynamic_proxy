package com.suning.dynamic_proxy.javassit.javassit;

import com.suning.dynamic_proxy.javassit.TicketService;

/**
 * Created by jack on 2018/6/19.
 */
public class JavassitTicketTest {
    public static void main(String[] args)throws Exception {
        TicketService proxy = TicketJavassitProxy.createProxy();
        proxy.sellTicket();
    }
}
