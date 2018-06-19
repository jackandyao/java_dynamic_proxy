package com.suning.dynamic_proxy.classloader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 * Created by jack on 2018/6/19.
 * 测试自定义的类加载器
 */
public class ClassLoaderTest {
    public static void main(String[] args)throws Exception {
        File file = new File(".");
        String classPath = "/target/classes/com/suning/dynamic_proxy/classloader/Person.class";
        InputStream  input = new FileInputStream(file.getCanonicalPath()+classPath);
        byte [] result = new byte[1024];
        int count = input.read(result);

        //使用自定义类加载起
        PersonClassLoader personClassLoader = new PersonClassLoader();
        //通过类加载器获取对应的class对象
        Class<?> personClass = personClassLoader.defineMyClass(result, 0, count);

        System.out.println("class info:"+personClass.getSimpleName());
        //通过反射实例户class对象
        Object object = personClass.newInstance();
        //通过反射调用class的相关方法
        personClass.getMethod("eat").invoke(object,null);
    }
}
