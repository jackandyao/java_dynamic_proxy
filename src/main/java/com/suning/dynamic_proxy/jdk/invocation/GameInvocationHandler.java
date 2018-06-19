package com.suning.dynamic_proxy.jdk.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jack on 2018/6/19.
 */
public class GameInvocationHandler implements InvocationHandler {
    private Object target;
    public GameInvocationHandler (Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String uname = args[0].toString();
        if (uname.equals("jhp")){
            return method.invoke(target,args);
        }
        else {
            throw new Exception("对不起,用户信息不合法...");
        }

    }
}
