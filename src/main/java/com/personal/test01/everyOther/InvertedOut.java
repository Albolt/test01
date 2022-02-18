package com.personal.test01.everyOther;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;



public class InvertedOut {


    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            reverseString1(a);
            System.out.println();
        }
    }

    public static void reverseString1(String s){
        if(s.length()>0){
            char[] c = s.toCharArray();
            for(int i=c.length-1;i>=0;i--){
                System.out.print(c[i]);
            }
        }else{
            System.out.println("是一个空字符串");
        }
    }
}
