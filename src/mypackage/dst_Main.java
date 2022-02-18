0000package com.personal.test01.test001;
0001
0002import org.apache.commons.io.FileUtils;
0003
0004import java.io.File;
0005import java.util.Scanner;
0006
0007/**
0008 * @Creater albolt
0009 * @12/11/20 10:30 AM
0010 */
0011
0012public class Main {
0013
0014    public static void main(String[] args) {
0015        Scanner sc = new Scanner(System.in);
0016        while (true) {
0017            String a = sc.nextLine();
0018            if (a.endsWith(".java") && a.startsWith("M")) {
0019                System.out.println("true");
0020            } else {
0021                System.out.println("false");
0022            }
0023        }
0024    }
0025}