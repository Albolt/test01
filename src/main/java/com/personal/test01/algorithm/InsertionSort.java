package com.personal.test01.algorithm;

/**
 * @Creater albolt
 * @2020-07-13 19:37
 */

public class InsertionSort {

    public static int[] a(int[] a) {

        for (int j = 1;j<a.length;j++) {
            int key = a[j];
            int i = j-1;
            while (i >= 0 && a[i] > key) {
                a[i+1] = a[i];
                i = i-1;
            }
            a[i+1] = key;
            for (int k =0;k<a.length;k++) {
                System.out.print(a[k]+",");
            }
            System.out.println();
        }

        return a;
    }

    public static int[] b(int[] b) {
        for (int j = 1;j<b.length;j++) {
            int key = b[j];
            int i = j-1;
            while (i>=0 && b[i] < key) {
                b[i+1] = b[i];
                i--;
            }
            b[i+1] = key;
            for (int k =0;k<b.length;k++) {
                System.out.print(b[k]+",");
            }
            System.out.println();
        }
        return b;
    }
}
