package com.personal.leetcode.easy;

public class Q27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int x = 0;
        for(int i = 0;i<nums.length;i++) {
            if (nums[i]!=val) {
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
            } else {
                x++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return x;
    }
}
