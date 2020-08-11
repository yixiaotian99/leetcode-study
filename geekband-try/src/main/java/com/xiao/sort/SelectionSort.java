package com.xiao.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-11 22:44
 * @Description 选择排序 找到未排序区间最小值，交换到已排序区间末尾
 * @see https://github.com/yixiaotian99/algo/blob/master/java/11_sorts/Sorts.java
 **/
@Slf4j
public class SelectionSort {


    /**
     * 插入排序
     *
     * @param arr
     */
    public void testSelectSort(int[] arr) {

        //数组太小
        int size = arr.length;
        if (size <= 1) {
            log.info("数组太小了");
            return;
        }


        //外层循环遍历一次数组，从下标为0开始
        //遍历最大值为 size-1 最后一个元素不需要比较
        for (int i = 0; i < size - 1; i++) {

            //定义初始最小值,为有序数列最后一个元素下标
            int minVal = i;


            //内层循环，为非排序序列
            //索引从未排序序列 i+1 开始
            for (int j = i + 1; j < size; j++) {

                //在未排序序列中找到比 minVal 还小的数
                if (arr[minVal] > arr[j]) {
                    minVal = j;
                }
            }

            //找到未排序区间的下标后，交换元素
            int temp = arr[i];
            arr[i] = arr[minVal];
            arr[minVal] = temp;
        }

        System.out.println(Arrays.toString(arr));

    }


    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.testSelectSort(new int[]{4, 5, 6, 1, 3, 2});
    }

}
