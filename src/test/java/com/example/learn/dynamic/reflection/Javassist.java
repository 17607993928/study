package com.example.learn.dynamic.reflection;

import javassist.*;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @类描述:javassist字节码操作
 * @创建人:xiejs
 * @创建时间:2020-7-10 09:40:48
 */
@Data
public class Javassist {
    private String empNo;

    private String name;


    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //建立新类
        CtClass ctClass = pool.makeClass("com.example.learn.dynamic.reflection.Javassist");

        //创建属性
        CtField field = CtField.make("private String age;", ctClass);
        ctClass.addField(field);

        //创建方法
        CtMethod method = CtMethod.make("private void test(){System.out.println(10086);}", ctClass);
        ctClass.addMethod(method);

        ctClass.writeFile("D:/");


    }

    @Test
    /**
     * 处理类的基本方法
     */
    public void testJavassist() throws NotFoundException, IOException, CannotCompileException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        //获取指定类
        CtClass cc = pool.get("com.example.learn.dynamic.reflection.Demo01");

        CtMethod method = cc.getDeclaredMethod("test",new CtClass[]{});

        method.insertAfter("System.out.println(\"我是\");");

        Class clazz = cc.toClass();
        Object o = clazz.newInstance();
        Method main = clazz.getDeclaredMethod("test");
        main.setAccessible(true);
        main.invoke(o,null);


    }

    @Test
    /**
     * 添加属性
     */
    public void testUpdateField() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //获取指定类
        CtClass cc = pool.get("com.example.learn.dynamic.reflection.Demo01");
        CtField field = new CtField(CtClass.intType,"age",cc);
        field.setModifiers(Modifier.PRIVATE);
        cc.addField(field,"10068");

        Class clazz = cc.toClass();
        Field age = clazz.getDeclaredField("age");
        String name = age.getName();
        System.out.println(name);

    }

    @Test
    /**
     * 获取构造器
     */
    public void getConst() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //获取指定类
        CtClass cc = pool.get("com.example.learn.dynamic.reflection.Demo01");


        CtConstructor ctConstructor=new CtConstructor(new CtClass[]{CtClass.intType},cc);
        cc.addConstructor(ctConstructor);


        CtConstructor[] constructors = cc.getConstructors();
        for (CtConstructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        cc.writeFile("D:/");
    }

}
