package com.personal.test01.everyOther;

public class RegularExpression {

    //大写字母和数字,且必须字母开头
    static String regularA = "^[A-Z]+[A-Z0-9]+";

    static String regularB = "^[A-Za-z0-9\\u4e00-\\u9fa5\\-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
}
