package com.personal.test01.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeUtils {

    static Faker chineseFaker = new Faker(Locale.CHINA);

    public static String fakeChinese() {

        String name = chineseFaker.phoneNumber().cellPhone();
        return name;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000000; i++) {
            System.out.println(fakeChinese());
        }

    }
}
