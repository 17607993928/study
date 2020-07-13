package com.example.learn.dynamic.annotation.study;

/**
 * @类描述:注解
 * @创建人:xiejs
 * @创建时间:2020-6-19 10:26:27
 */
public class Demo01 extends Object {




//    @Info(studentName = "我是你爸爸",age = 19,id = 10086)
    public void test(){
        System.out.println("用于注解作用范围");
    }


    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        Class<Student> clazz = Student.class;
        Field annotation = clazz.getAnnotation(Field.class);
        String s = annotation.columnName();
        System.out.println(s);


        java.lang.reflect.Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        Field annotation1 = id.getAnnotation(Field.class);
        int length = annotation1.length();
        System.out.println(length);
    }
}

