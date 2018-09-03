package com.jiangcheng.theory.algorithm.sort.bubblesort;

import java.util.Arrays;

/**
 * 类名称：BubbleSort3<br>
 * 类描述：<br>
 * 创建时间：2018年09月03日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class BubbleSort3 {

    public static void main(String[] args) {
        int[] arr = {2,4,6,3,12,7,23,15};

        //System.out.println(Arrays.asList(arr));//貌似被误导了很久这样打印不出来东 //System.out.println(arr);//这样更打印不出来 //System.out.println(Arrays.asList(arr).toString());//仍然打印不出来 //System.out.println(arr.toString());//数组也有toString方法 果然数组也是类 但是仍然打印不出来
        /*for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }*///打印太麻烦

        System.out.println("before sort:");
        Arrays.stream(arr).forEach(System.out::println);//lambada打印不费力

        bubbleSort01(arr);

        System.out.println("after sort:");
        Arrays.stream(arr).forEach(System.out::println);//lambada打印不费力
    }

    private static void bubbleSort01(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 一开始第一次写的时候直接a跟b进行交换swap(a,b){a = temp,b = a,b = temp} 真的错误的很离谱 因为调用这两个index做参数 根本改变不了数组中的每个元素的值，最后还是写成了如下所示的
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr,int a, int b) {
        System.out.printf("befor swap %d: %d, %d: %d%n",a,arr[a],b,arr[b]);
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        System.out.printf("after swap %d: %d, %d: %d%n",a,arr[a],b,arr[b]);
    }
}
