package com.example.leetcode.InterviewQuestions.one;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:2020-5-11 14:16:27
 */
public class one {
    //实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
// 输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
//输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 数组


    public static void main(String[] args) {
        boolean ss = isUnique("aa");
        System.out.println(ss);
    }


    public static boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
