package com.personal.test01.test001;

import java.util.Random;

public class 战双S概率 {

    public static void main(String[] args) {
        Integer result = 0;
        Integer sum = 0;
        Integer x = 100000;
        for (int i = 0; i < x; i++) {
            Integer danci = 赌狗池();
            System.out.println(danci);
            sum+=danci;
        }
        result = sum/x;
        System.out.println();
        System.out.println(result);
    }

    public static Integer 保底池() {
        Random random = new Random();
        for (int i = 0; i < 60; i++) {
            Integer re = random.nextInt(1000);
            if (re<5) {
                return i;
            }
        }
        return 60;
    }

    public static Integer 赌狗池() {
        Random random = new Random();
        Integer 保底 = random.nextInt(21)+80;
        for (int i = 0; i < 保底; i++) {
            Integer re = random.nextInt(1000);
            if (re<15) {
                return i;
            }
        }
        return 保底;
    }
}
