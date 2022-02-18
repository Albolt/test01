package com.personal.test01.algorithm;

/**
 * @Creater albolt
 * @2020-07-14 15:37
 */

public class MergeSort {

    public static void a(int[] A, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r-q;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i =0;i<n1;i++) {
            L[i] = A[p+i-1];
        }
        for (int j =0;j<n2;j++) {
            R[j] = A[q+j];
        }
        L[n1] = 99999999;
        R[n2] = 99999999;
        int i = 0;
        int j = 0;
        A = new int[20];
        for (int k = p;k<=r;k++) {
            if (L[i]<=R[j]) {
                A[k-1] = L[i];
                i++;
            } else {
                A[k-1] = R[j];
                j++;
            }
        }
        for (int x=0;x<A.length;x++) {
            System.out.print(A[x]+",");
        }
        System.out.println();
        for (int x=0;x<L.length;x++) {
            System.out.print(L[x]+",");
        }
        System.out.println();
        for (int x=0;x<R.length;x++) {
            System.out.print(R[x]+",");
        }
        System.out.println();
    }
}
