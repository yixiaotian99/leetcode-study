package com.xiao.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-10 22:46
 * @Description 使用冒泡排序
 * @see https://time.geekbang.org/column/article/41802
 **/
@Slf4j
public class BubbleSort {


    /**
     * 冒泡排序
     */
    public int[] testBubbleSort(int[] arr) {

        //数组长度
        int size = arr.length;
        if (size <= 1) {
            log.info("数组长度太小");
            return arr;
        }


        //外层循环遍历一次所有元素
        for (int i = 0; i < size; i++) {

            //内层循环，注意 j=0 开始表示始终从第一个元素开始比较
            //循环终止条件，size-已排好序元素i, size - i
            //如果下一个节点则 j+1 < size-i 转为  j < size -i -1
            for (int j = 0; j < size - i - 1; j++) {

                //基于稳定排序，如果前面值>后面值，交换顺序
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

//        Arrays.stream(arr).forEach(System.out::println);
        return arr;
    }


    /**
     * 冒泡排序，添加退出循环条件
     * 当遍历一次，如果没有需要交换的元素，说明已经有序，可退出外层循环
     *
     * @param arr
     * @return
     */
    public int[] testBubbleSortWithBreak(int[] arr) {

        //数组长度
        int size = arr.length;
        if (size <= 1) {
            log.info("数组长度太小");
            return arr;
        }

        //外层循环，需要遍历一次所有元素
        for (int i = 0; i < size; i++) {

            //退出标志，当一次遍历没有需要交换的元素，说明已经有序
            boolean exchangeFlag = false;

            //内层循环，始终从第一个元素开始，j=0
            //比较相邻的两个元素， a[j] > a[j+1] 前一个元素大于后一个元素，交换顺序
            //遍历终止条件， j+1 < size - i  比较的元素=元素大小size - 已经排序元素个数i
            for (int j = 0; j + 1 < size - i; j++) {

                //交换顺序
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    exchangeFlag = true;
                }
            }

            //退出
            if (!exchangeFlag) {
                log.info("已经有序，退出冒泡排序");
                break;
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
//        int[] ints = bubbleSort.testBubbleSort(new int[]{4, 5, 6, 3, 2, 1});
        int[] ints = bubbleSort.testBubbleSortWithBreak(new int[]{1, 2, 3, 4, 5, 6});
        Arrays.stream(ints).forEach(System.out::println);

    }

}
