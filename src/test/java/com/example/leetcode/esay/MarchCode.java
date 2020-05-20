package com.example.leetcode.esay;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @类描述:三月份的leetCode题
 * @创建人:xiejs
 * @创建时间:2020-3-26
 */
public class MarchCode {
    @Test
    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    void one(){
        int[] nums= new int[]{2, 7, 11, 15,99,54,2165,156};
        int target=153;
        int a;
        List<Integer> arr=new ArrayList();
        for(int i=0;i<nums.length;i++){
            a=target-nums[i];
            for(int j=0;j<nums.length;j++){
                if(a==nums[j]){
                    arr.add(j);
                }
            }
        }
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }




}
