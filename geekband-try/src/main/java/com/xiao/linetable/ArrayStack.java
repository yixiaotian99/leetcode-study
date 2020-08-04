package com.xiao.linetable;

import java.util.Arrays;

/**
 * @Author sunjinwei
 * @Date 2020-08-04 22:04
 * @Description 使用数组实现顺序栈
 **/
public class ArrayStack {

    /**
     * 数组
     */
    private String[] myArr;

    /**
     * 数组当前大小
     */
    private int count;

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 初始化数组，最大容量、初始值
     *
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.myArr = new String[maxSize];
        this.count = 0;
        this.maxSize = maxSize;
    }

    /**
     * 实现栈的 push 推入
     *
     * @return
     */
    public boolean push(String element) {

        //边界检查 TODO
        if (count >= maxSize) {
            return false;
        }

        myArr[count] = element;
        count++;

        return true;
    }


    /**
     * 实现栈的 pop 弹出
     *
     * @return
     */
    public String pop() {

        //边界检查
        if (count <= 0) {
            return null;
        }

        //TODO 元素下标为个数减1
        String s = myArr[count - 1];
        myArr[count - 1] = null;
        count--;

        return s;
    }


    public static void main(String[] args) {
        ArrayStack ms = new ArrayStack(10);

        ms.push("A");
        ms.push("B");
        ms.push("C");

        System.out.println(ms);

        ms.pop();
        ms.pop();

        System.out.println(ms);

        ms.pop();
        ms.pop();

        System.out.println(ms);
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "myArr=" + Arrays.toString(myArr) +
                ", count=" + count +
                ", maxSize=" + maxSize +
                '}';
    }
}
