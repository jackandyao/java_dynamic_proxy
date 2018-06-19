package com.suning.dynamic_proxy.javassit.javassit;
import com.suning.dynamic_proxy.javassit.Station;
import com.suning.dynamic_proxy.javassit.TicketService;
import javassist.*;
import java.lang.reflect.*;
/**
 * Created by jack on 2018/6/19.
 * 通过javassit创建动态字节码 创建一个车票代理点
 * ClassPool
 * CtClass
 * CtField
 * CtMethod
 */
public class TicketJavassitProxy {
    /*
    * 手动创建字节码
    */
    public static TicketService createProxy() throws Exception
    {
        String packPath = "com.suning.dynamic_proxy.javassit.";
        //获取类的连接池
        ClassPool pool = ClassPool.getDefault();
        //创建一个类 包名+类名
        CtClass cc = pool.makeClass(packPath+".javassit"+"StationProxy");

        //设置接口
        CtClass interface1 = pool.get(packPath+"TicketService");
        cc.setInterfaces(new CtClass[]{interface1});

        //设置Field
        CtField field = CtField.make("private com.suning.dynamic_proxy.javassit.Station station;", cc);
        cc.addField(field);

        //获取接口的实现类
        CtClass stationClass = pool.get("com.suning.dynamic_proxy.javassit.Station");
        CtClass[] arrays = new CtClass[]{stationClass};
        CtConstructor ctc = CtNewConstructor.make(arrays,null,CtNewConstructor.PASS_NONE,null,null, cc);
        //设置构造函数内部信息
        ctc.setBody("{this.station=$1;}");
        cc.addConstructor(ctc);

        //创建收取手续 takeHandlingFee方法
        CtMethod takeHandlingFee = CtMethod.make("private void takeHandlingFee() {}", cc);
        takeHandlingFee.setBody("System.out.println(\"收取手续费，打印发票。。。。。\");");
        cc.addMethod(takeHandlingFee);

        //创建showAlertInfo 方法
        CtMethod showInfo = CtMethod.make("private void showAlertInfo(String info) {}", cc);
        showInfo.setBody("System.out.println($1);");
        cc.addMethod(showInfo);

        //sellTicket
        CtMethod sellTicket = CtMethod.make("public void sellTicket(){}", cc);
        sellTicket.setBody("{this.showAlertInfo(\"××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××\");"
                + "station.sellTicket();"
                + "this.takeHandlingFee();"
                + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}");
        cc.addMethod(sellTicket);


        //获取动态生成的class
        Class c = cc.toClass();
        //获取构造器
        Constructor constructor= c.getConstructor(Station.class);
        //通过构造器实例化
        TicketService ticketService = (TicketService)constructor.newInstance(new Station());

        //动态的class文件写入
        cc.writeFile("/soft/idea/workspace/java_dynamic_proxy/src/main/java/com/suning/dynamic_proxy/javassit/javassit/");
        return ticketService;
    }
}
