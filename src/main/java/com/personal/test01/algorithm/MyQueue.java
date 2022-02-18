package com.personal.test01.algorithm;

/**
 * @Creater albolt
 * @2020-07-16 19:28
 */

public class MyQueue {

    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enQueue(int element) throws Exception {
        if ((rear+1)%array.length==front) {
            throw new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear+1)%array.length;
    }

    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        int deQueue = array[front];
        front = (front+1)%array.length;
        return deQueue;
    }

    public void outPut() {
        for(int i = front;i != rear;i = (i+1)%array.length) {
            System.out.print(array[i]+",");
        }
        System.out.println();
    }


}
