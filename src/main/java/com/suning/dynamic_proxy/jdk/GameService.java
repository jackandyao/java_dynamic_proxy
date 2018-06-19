package com.suning.dynamic_proxy.jdk;

/**
 * Created by jack on 2018/6/19.
 */
public class GameService implements IGameService {
    @Override
    public void playGame(String uname) {
        System.out.println("当前正在打游戏的用户是："+uname);
    }
}
