package com.suning.dynamic_proxy.classloader;

/**
 * Created by jack on 2018/6/19.
 * 自定义类加载器 用户把字节码转换为class对象
 */
public class PersonClassLoader extends ClassLoader{

    public Class<?> defineMyClass(byte[] b, int off, int len)  {
        return super.defineClass(b, off, len);
    }

    //findClass(String name) 寻找类文件也就是.class文件
    //loadClass(String name, boolean resolve)
    //defineClass(String name, byte[] b, int off, int len) 字节码加载的jvm中
}
