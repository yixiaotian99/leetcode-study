package com.xiao.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-12 21:49
 * @Description 快排
 * @see https://time.geekbang.org/column/article/41913
 **/
@Slf4j
public class QuickSort {


    /**
     * 使用快排，采用快慢指针实现
     *
     * @param arr 假设数组为 6，11，3，9，8
     */
    public void testQuickSort(int[] arr) {

        quickSortInternal(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 使用分治思想，选出中轴元素pivot节点，将小元素放在pivot之前，大元素放到pivot之后
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private void quickSortInternal(int[] arr, int startIndex, int endIndex) {

        //1.递归中止条件
        if (startIndex >= endIndex) {
            log.info("达到中止条件, startIndex:{} >= endIndex:{}", startIndex, endIndex);
            return;
        }


        //2.获取分区点下标
        int partitionIndex = this.partition(arr, startIndex, endIndex);


        //3. 递归分区小元素区间
        this.quickSortInternal(arr, startIndex, partitionIndex - 1);

        //4. 递归分区大元素区间
        this.quickSortInternal(arr, partitionIndex + 1, endIndex);

    }


    /**
     * 选择中轴元素 pivot 获取分区点 i
     * 使用慢指针 i 用于交换中轴元素pivot位置
     * 使用快指针 j 用于遍历数组元素
     */
    private int partition(int[] arr, int startIndex, int endIndex) {

        //1.慢指针 i 快指针 j
        int i = startIndex;
        int j = startIndex;
        int pivot = arr[endIndex];

        //2.遍历数组元素，快指针j每次移动一个位置，直到pivot前一个位置
        //注意结束索引，不是 arr.length
        for (; j < endIndex; j++) {

            //2.1.判断元素是否小于pivot
            if (arr[j] < pivot) {

                //2.2.如果快慢指针相同，则增加慢指针
                if (i == j) {
                    i++;
                } else {
                    //2.3.如果元素小于pivot，则交换快慢指针元素，增加慢指针
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i++] = temp; //可写成 arr[i] = temp; i++;
                }

            }
        }

        //3.找到中轴pivot应该插入的位置，为慢指针i的下一个位置++i
        int temp = arr[endIndex];
        arr[endIndex] = arr[i];
        arr[i] = temp;
        log.info("分区下标:{}", i);

        return i;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//        quickSort.testQuickSort(new int[]{6, 11, 3, 9, 8});
        quickSort.testQuickSort(new int[]{3, 5, 1, 2, 7, 6, 4});
    }

}
