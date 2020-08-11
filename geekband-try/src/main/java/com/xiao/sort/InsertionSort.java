package com.xiao.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-11 14:36
 * @Description 插入排序
 * @see https://time.geekbang.org/column/article/41802
 **/
@Slf4j
public class InsertionSort {


    /**
     * 老师例子
     *
     * @param a
     * @param n
     */
    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }

        Arrays.stream(a).forEach(System.out::println);
    }


    /**
     * 使用插入排序
     * 已经排序区间 + 未排序区间
     * 将未排序区间元素，每个元素插入到已排序区间合适的位置
     *
     * @param arr 假设数组是 4,5,6,1,3,2
     */
    public void testInsertSort(int[] arr) {

        int size = arr.length;
        if (size <= 1) {
            log.info("只有一个元素数据已经有序:{}", arr[0]);
            return;
        }


        //外层循环, 即当前遍历的数组列表  4,5,6,1,3,2
        //从第2个元素开始
        for (int i = 1; i < size; i++) {

            //无序区间第一个元素
            int unorderVal = arr[i];

            //有序序列索引截止位置，如果有 i 个元素，则有 i-1 个元素有序
            int j = i - 1;

            //内层循环，即已经排序的数组序列，使用倒序遍历 4,5,6
            for (; j >= 0; j--) {

                //移动元素条件：当无序区间元素小于倒序有序区间元素时, 如 1 小于 4,5,6
                if (unorderVal < arr[j]) {
                    arr[j + 1] = arr[j];

                } else {
                    //找到第一个大于等于有序区间元素，准备进行插入
                    break;
                }
            }

            //找到第一个大于等于有序区间元素 后一个位置，插入
            arr[j + 1] = unorderVal;
        }

        Arrays.stream(arr).forEach(System.out::println);
    }


    public static void main(String[] args) {
        InsertionSort insertSort = new InsertionSort();
//        insertSort.insertionSort(new int[]{4, 5, 6, 1, 3, 2}, 6);

        insertSort.testInsertSort(new int[]{4, 5, 6, 1, 3, 2});
    }
}
