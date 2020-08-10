package com.xiao.linetable;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-10 16:49
 * @Description 循环队列
 **/
@Slf4j
public class CircularQueue {

    //存储数据
    private String[] iterms;

    //最大值
    private int n;

    //头节点下标
    private int head = 0;

    //尾节点下标
    private int tail = 0;

    //初始化数组队列
    public CircularQueue(int n) {
        iterms = new String[n];
        this.n = n;
    }


    /**
     * 入队
     *
     * @param s
     * @return
     */
    public boolean enqueue(String s) {

        //判断是否循环队列已经满了，判断条件是 (tail + 1) % n = head
        if ((tail + 1) % n == head) {
            log.info("队列已经满了");
            return false;
        }

        //追加到队尾
        iterms[tail] = s;

        //注意这里并不是 tail=tail + 1,因为循环队列下标是循环的，并不是一直递增
        tail = (tail + 1) % n;

        return true;
    }


    /**
     * 出队
     *
     * @return
     */
    public String dequeue() {

        //判断是否队列为空
        if (tail == head) {
            log.info("队列为空");
            return null;
        }

        String iterm = iterms[head];

        //重置头节点下标
        head = (head + 1) % n;

        return iterm;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "iterms=" + Arrays.toString(iterms) +
                ", n=" + n +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {

        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue("A");
        circularQueue.enqueue("B");
        circularQueue.enqueue("C");

        System.out.println(circularQueue);

        circularQueue.enqueue("D");
        circularQueue.enqueue("E");
        circularQueue.enqueue("F");
        System.out.println(circularQueue);

        circularQueue.dequeue();
        circularQueue.dequeue();
        System.out.println(circularQueue);
    }
}
