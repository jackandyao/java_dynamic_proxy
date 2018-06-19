package com.suning.dynamic_proxy.jdk.proxy;

import com.suning.dynamic_proxy.jdk.invocation.GameInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * Created by jack on 2018/6/19
 * 游戏代理
 */
public class GameProxy {
    public static <T> T getProxy(Object object){
        return (T)Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),
                new GameInvocationHandler(object));
    }
}
