package com.suning.dynamic_proxy.javaagent.patter;

import javassist.CtClass;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by jack on 2018/6/19.
 */
public class PatternTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        PatternMatcher matcher = new Perl5Matcher();
        PatternCompiler compiler = new Perl5Compiler();
        String interceptorClass ="com.service.InsertService";
        String interceptorMethod = "insert";
        try {
            if (matcher.matches(className,compiler.compile(interceptorClass))){
                ByteCode byteCode = new ByteCode();
                CtClass ctClass = byteCode.modifyByteCode(interceptorClass, interceptorMethod);
                return ctClass.toBytecode();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
