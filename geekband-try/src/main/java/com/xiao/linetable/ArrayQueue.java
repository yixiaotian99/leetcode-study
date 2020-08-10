package com.xiao.linetable;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-10 11:37
 * @Description 使用数组实现有界队列
 * @see https://time.geekbang.org/column/article/41330
 **/
public class ArrayQueue {

    //有界队列数据
    private String[] items;

    //队列最大长度
    private int n;

    //队头下标
    private int head = 0;

    //队尾下标
    private int tail = 0;


    //初始化队列
    public ArrayQueue(int n) {
        this.items = new String[n];
        this.n = n;
    }


    /**
     * 入队
     *
     * @param item
     */
    public boolean enqueue(String item) {

        //如果队尾已经等于最大长度，则表示队列已经满了
        if (tail == n) {
            return false;
        }

        //插入队尾
        items[tail] = item;
        tail++;

        return true;
    }


    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {

        //队列已空
        if (head == tail) {
            return null;
        }

        String item = items[head];
        items[head] = null;
        head++;

        return item;
    }


    /**
     * 入队
     * 当队列空间不够时扩容，当队列满时返回空
     *
     * @return
     */
    public boolean enqueueCapacity(String item) {

        //已经到达队尾
        if (tail == n) {

            //tail==n && head==0 说明队列满了
            if (head == 0) {
                return false;
            }

            //每个元素移动 head 个元素
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }

            //重置头和尾节点
            tail = tail - head;
            head = 0;
        }

        //插入队尾
        items[tail] = item;
        tail++;

        return true;
    }


    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
//        ArrayQueue arrayQueue = new ArrayQueue(5);
//
//        arrayQueue.enqueue("A");
//        arrayQueue.enqueue("B");
//        arrayQueue.enqueue("C");
//        arrayQueue.enqueue("D");
//        arrayQueue.enqueue("E");
//        arrayQueue.enqueue("F");
//
//        System.out.println(arrayQueue);
//
//        arrayQueue.dequeue();
//        arrayQueue.dequeue();
//        arrayQueue.dequeue();
//
//        System.out.println(arrayQueue);


        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueueCapacity("AA");
        arrayQueue.enqueueCapacity("BB");
        arrayQueue.enqueueCapacity("CC");

        arrayQueue.dequeue();
        arrayQueue.dequeue();

        arrayQueue.enqueueCapacity("DD");
        arrayQueue.enqueueCapacity("EE");

        System.out.println(arrayQueue);

        arrayQueue.enqueueCapacity("FF");
        System.out.println(arrayQueue);

    }
}















