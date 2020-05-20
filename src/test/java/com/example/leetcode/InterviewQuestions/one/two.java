package com.example.leetcode.InterviewQuestions.one;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:2020-5-11 14:16:22
 */
public class two {
    //给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    //
    // 示例 1：
    //
    // 输入: s1 = "abc", s2 = "bca"
    //输出: true
    //
    //
    // 示例 2：
    //
    // 输入: s1 = "abc", s2 = "bad"
    //输出: false
    //
    //
    // 说明：
    //
    //
    // 0 <= len(s1) <= 100
    // 0 <= len(s2) <= 100
    //
    // Related Topics 数组 字符串

    public static void main(String[] args) {
        boolean b = CheckPermutation("a", "ab");
        System.out.println(b);
    }


    public static boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int num1=0;
        int num2=0;
        for(int i=0;i<chars1.length;i++){
            char c = chars1[i];

            num1=num1+Integer.valueOf(c);
        }
        for(int i=0;i<chars2.length;i++){
            char d = chars2[i];
            num2=num2+Integer.valueOf(d);
        }



        if(num1==num2){
            return true;
        }
        return false;
    }

}
