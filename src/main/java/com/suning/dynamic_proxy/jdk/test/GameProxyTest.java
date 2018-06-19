package com.suning.dynamic_proxy.jdk.test;

import com.suning.dynamic_proxy.jdk.GameService;
import com.suning.dynamic_proxy.jdk.IGameService;
import com.suning.dynamic_proxy.jdk.proxy.GameProxy;

/**
 * Created by jack on 2018/6/19.
 */
public class GameProxyTest {
    public static void main(String[] args) {
        IGameService gameService = new GameService();
        IGameService gameProxyService = GameProxy.getProxy(gameService);
        gameProxyService.playGame("jhp");
    }
}
