package com.example.leetcode.InterviewQuestions.one;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:2020-5-12
 */
public class four {
    //给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
    //
    // 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
    //
    // 回文串不一定是字典当中的单词。
    //
    //
    //
    // 示例1：
    //
    // 输入："tactcoa"
    //输出：true（排列有"tacocat"、"atcocta"，等等）
    //
    //
    //
    // Related Topics 哈希表 字符串

    public static void main(String[] args) {
        boolean sdads = canPermutePalindrome("tacocat");
        System.out.println(sdads);
    }

    public static boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
            if ((map[c]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }

}
