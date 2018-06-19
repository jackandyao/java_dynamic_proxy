package com.suning.dynamic_proxy.javaagent;
import java.lang.instrument.Instrumentation;

//javaagent主要作用
//		可以在加载java文件之前做拦截把字节码做修改
//		可以在运行期将已经加载的类的字节码做变更，但是这种情况下会有很多的限制，后面会详细说
//		还有其他的一些小众的功能
//		获取所有已经被加载过的类
//		获取所有已经被初始化过了的类（执行过了clinit方法，是上面的一个子集）
//		获取某个对象的大小
//		将某个jar加入到bootstrapclasspath里作为高优先级被bootstrapClassloader加载
//		将某个jar加入到classpath里供AppClassload去加载
//		设置某些native方法的前缀，主要在查找native方法的时候做规则匹配
public class TimeMonitorAgent {
	public static void premain(String agentArgs, Instrumentation inst) {
		System.out.println("execute insert method interceptor....");
		System.out.println(agentArgs);
		inst.addTransformer(new TimeMonitorTransformer(agentArgs));
	}
}
