package com.personal.leetcode.hard;

import java.util.Arrays;

public class Q4 {

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int length1 = nums1.length;
        int[] nums3 = new int[length];
        double result = 0;
        for (int i = 0; i < length; i++) {
            if (i<nums1.length) {
                nums3[i] = nums1[i];
            } else {
                nums3[i] = nums2[i-length1];
            }
        }
        Arrays.sort(nums3);
        int length3 = nums3.length;
        if (nums3.length%2 != 1) {
            result = (double)(nums3[length3/2-1] + nums3[length3/2])/2;
        } else {
            result = nums3[(length3-1)/2];
        }
        return result;
    }
}
