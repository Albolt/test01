package com.personal.test01.test001;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Scanner;

/**
 * @Creater albolt
 * @12/11/20 10:30 AM
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String a = sc.nextLine();
            if (a.endsWith(".java") && a.startsWith("M")) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
