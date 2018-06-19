package com.suning.dynamic_proxy.javassit;

/**
 * 售票服务接口实现类，车站 
 * @author jhp
 */  
public class Station implements TicketService {  
  
    @Override  
    public void sellTicket() {  
        System.out.println("\n\t售票.....\n");  
    }  
  

}  