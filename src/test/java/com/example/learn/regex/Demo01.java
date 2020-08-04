package com.example.learn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @创建人 xjs
 * @类描述 正则
 * @创建时间 2020/8/2 0002 下午 19:36
 */
public class Demo01 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher("xaxa2342352sfasfasf");
        boolean b = matcher.matches();

        //替换
        String s = matcher.replaceAll("#");
        System.out.println(s);
        System.out.println(b);
    }
}
