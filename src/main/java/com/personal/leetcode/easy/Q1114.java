package com.personal.leetcode.easy;

public class Q1114 {

    static Integer raw = 400;

//    public Foo() {
//
//    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        withraw(200);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (raw!=200) {
            this.wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        withraw(200);
    }

    public void third(Runnable printThird) throws InterruptedException {

        while (raw!=0) {
            this.wait();;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public synchronized Integer withraw(Integer a) {
        raw-=a;
        return raw;
    }
}
