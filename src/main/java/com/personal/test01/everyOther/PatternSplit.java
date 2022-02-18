package com.personal.test01.everyOther;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Creater albolt
 * @2020-07-15 16:18
 */

public class PatternSplit {

    public static void wrong(String str) {
        int wordsCount = str.split(" ").length;

        System.out.println(str + " 单词数: " + wordsCount);
    }

    public static void right(String str) {
        Pattern pattern = Pattern.compile("\\b\\w+\\b");

        Matcher matcher = pattern.matcher(str);

        int wordsCount = 0;

        while (matcher.find()) {
            wordsCount++;
        }
        System.out.println(str + " 单词数: " + wordsCount);
    }
}
