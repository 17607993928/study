package com.example.learn.reflection;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @类描述:测试脚本引擎
 * @创建人:xiejs
 * @创建时间:2020-7-9 15:09:23
 */
public class js {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        //获取脚本引擎对象
        ScriptEngineManager js=new ScriptEngineManager();
        ScriptEngine engine = js.getEngineByName("javascript");

        //定义变量、存储到引擎的上下文里面
        engine.put("msg","javascript is not !");

        String str="var user={name:'giao',age:18,work:'mi'};";

//        str+="conlose(user.name);";


        engine.eval(str);
        engine.eval("msg=9999");

        System.out.println(engine.get("msg"));

        //定义函数
        engine.eval("function add (a,b){var sum=a*b; return sum }");
        //执行js函数
        Invocable invocable = (Invocable) engine;
        Object add = invocable.invokeFunction("add", new Integer[]{15, 20});
        System.out.println(add);





    }
}
