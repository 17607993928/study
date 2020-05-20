package com.example.csdn;

/**
 * @类描述:冒泡排序
 * @创建人:xiejs
 * @创建时间:2020-5-9 14:52:50
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr={111,123,513,56423,2,315,87,316,32154,1324,32135,1321,5,132,165,1321,114,31};


        System.out.println(arr.length);

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr.length-1;i++){
            System.out.print(arr[i]+"  ");
        }
    }
}
