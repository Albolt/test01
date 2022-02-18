package com.personal.test01.tools;

import java.util.Random;

/**
 * @Creater albolt
 * @2020-07-03 10:41
 */

public class Probability {

    public Long getPro() {
        Long x = 0l;
        Long flag = 0l;

        Random random = new Random();
        for (int i = 0;i<100000000;i++) {
            Double gailv = 0.175;
            Double a = Math.random();
            flag++;
            if (flag >= 8){
                gailv = 1d;
            }
            if (Double.compare(a, gailv)<=0) {
                x++;
                flag = 0l;
            }
        }
        return x;
    }
}
