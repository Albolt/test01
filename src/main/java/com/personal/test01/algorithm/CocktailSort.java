package com.personal.test01.algorithm;

/**
 * @Creater albolt
 * @2020-08-07 14:11
 */

public class CocktailSort {

    public static void sort(int array[]) {

        int tmp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    //有元素交换，不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            //偶数轮之前，将标记置位true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = array.length-i-1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    //有元素交换，不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
