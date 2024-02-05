package com.personal.test01.everyOther;

public class splitFile {


    public static void splitFile() {
        String[] cmd = {"/bin/sh", "-c", "split -l 2 -d /Users/zhangchi/personaldocument/test.csv /Users/zhangchi/personaldocument/test_"};
        try {
            Process proc = new ProcessBuilder(cmd).start();
            proc.waitFor();
            if (proc.exitValue() == 0) {
                System.out.println(proc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        splitFile();
    }
}
