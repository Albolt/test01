package com.personal.test01.test001;

/**
 * @Creater albolt
 * @12/16/20 10:45 PM
 */

class change {
    public static String d2Hex(int a) {
        String c = "";
        char x[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        while (a > 0) {
            if (a % 16 > 9) {
                c = x[a % 16 - 10] + c;
            } else c = a % 16 + c;
            a = a / 16;
        }
        return c;
    }

    static int hex2d(String b) {
        int y = 1;
        int x = 0;
        int r = 0;
        for (int i = 0; i < b.length(); i++) {
            char strArray = b.charAt(i);
            switch (strArray) {
                case 'A':
                    r = 10;
                case 'B':
                    r = 11;
                case 'C':
                    r = 12;
                case 'D':
                    r = 13;
                case 'E':
                    r = 14;
                case 'F':
                    r = 15;
                case '0':
                    r = 0;
                case '1':
                    r = 1;
                case '2':
                    r = 2;
                case '3':
                    r = 3;
                case '4':
                    r = 4;
                case '5':
                    r = 5;
                case '6':
                    r = 6;
                case '7':
                    r = 7;
                case '8':
                    r = 8;
                case '9':
                    r = 9;
                default:
                    break;
            }
            x += r * y;
            y *= 16;
        }
        return x;
    }
}