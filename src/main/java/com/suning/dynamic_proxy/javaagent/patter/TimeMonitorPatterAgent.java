package com.suning.dynamic_proxy.javaagent.patter;

import com.suning.dynamic_proxy.javaagent.TimeMonitorTransformer;

import java.lang.instrument.Instrumentation;

/**
 * Created by jack on 2018/6/19.
 */
public class TimeMonitorPatterAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new PatternTransformer());
    }
}
