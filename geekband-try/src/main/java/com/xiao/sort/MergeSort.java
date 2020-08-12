package com.xiao.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-12 10:36
 * @Description 归并排序算法
 * @see https://time.geekbang.org/column/article/41913
 **/
@Slf4j
public class MergeSort {


    /**
     * 使用分治思想，将数组分成两部分，对两部分再分别进行排序
     *
     * @param arr 假设输入为 1，5，6，2，3，4
     */
    public void testMergeSort(int[] arr) {

        //内部本地排序，起始索引值是0，最大索引值是数组长度-1
        mergeSortInternal(arr, 0, arr.length - 1);
    }


    /**
     * 分治排序算法
     *
     * @param arr
     * @param startIndex 起始索引值
     * @param endIndex   结束索引值
     */
    private void mergeSortInternal(int[] arr, int startIndex, int endIndex) {

        //1. 分治终止条件，当切分之后的索引值>=结束索引值
        if (startIndex >= endIndex) {
            log.info("分治终止条件: startIndex:{} >= endIndex:{}", startIndex, endIndex);
            return;
        }


        //2. 分治取中间值索引，将数组一切成2，取中间值两部分，分别进行分区排序
        //注意这里的位移运算符，优先级比+号运算符还要低，所以需要括起来
        //可以使用 startIndex + (endIndex - startIndex）/2
        int mid = startIndex + ((endIndex - startIndex) >> 1);
        log.info("中间值, mid:{}", mid);


        //3. 再分区治理
        mergeSortInternal(arr, startIndex, mid);
        mergeSortInternal(arr, mid + 1, endIndex);


        //4. 合并分区
        merge(arr, startIndex, mid, endIndex);
    }

    /**
     * 将两个分区，合并成一个排序数组
     *
     * @param arr
     * @param startIndex
     * @param mid
     * @param endIndex
     */
    private void merge(int[] arr, int startIndex, int mid, int endIndex) {

        //1. 数组 arr 根据中间值mid会被切分成前后两个区间，逐一比较两个区间中每个元素大小
        //将两个区间中，较小的元素放到临时数组中
        int firstArrStartIndex = startIndex;
        int secondArrStartIndex = mid + 1;

        //2. 声明临时数组，大小同原始数组大小相同
        int[] temp = new int[endIndex - startIndex + 1];
        int tempIndex = 0;


        //3. 比较两个区间
        //小区间循环条件 大区间循环条件, 边界条件是 小于等于
        while (firstArrStartIndex <= mid && secondArrStartIndex <= endIndex) {

            //4.比较两个区间获取到的值
            if (arr[firstArrStartIndex] <= arr[secondArrStartIndex]) {

                //5. 将两个区间中，较小值放到临时数组
                temp[tempIndex++] = arr[firstArrStartIndex++];

            } else {
                temp[tempIndex++] = arr[secondArrStartIndex++];
            }
        }


        //6. 小区间与大区间个数不一样，会导致剩下元素，如小区间有3个，大区间有2个元素
        int remainStart = 0;
        int remainEnd = 0;

        //说明小区间还有剩余元素
        if (firstArrStartIndex <= mid) {
            remainStart = firstArrStartIndex;
            remainEnd = mid;
        }

        //说明大区间还有剩余元素
        if (secondArrStartIndex <= endIndex) {
            remainStart = secondArrStartIndex;
            remainEnd = endIndex;
        }

        //7.将剩余的元素复制到临时数据中
        while (remainEnd >= remainStart) {
            temp[tempIndex++] = arr[remainStart++];
        }

        //8.将临时数组填充覆盖原数组 arr[start, end]
        for (int i = 0; i <= endIndex - startIndex; i++) {
            arr[startIndex + i] = temp[i];
        }

        System.out.println(Arrays.toString(temp));
    }


    public static void main(String[] args) {
//        int[] arr = new int[5];
//        int i = 0;
//        arr[++i] = 11;
//        System.out.println(Arrays.toString(arr));
//        System.out.println(i);

        MergeSort mergeSort = new MergeSort();
        mergeSort.testMergeSort(new int[]{4, 5, 6, 1, 3, 2});

//        //注意右移运算的操作符，优先级最低，比加号还低
//        System.out.println(2+(5-3)>>1);  //输出2 因为先计算 2+(5-3) 的值
//        System.out.println(2+(5-3)/2);   //输出3 因为先计算 (5-3)/2 的值
    }
}


class MergeSortXZ {
    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }

        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        mergeSort(new int[]{4, 5, 6, 1, 3, 2}, 6);
    }
}
















