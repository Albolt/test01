package com.personal.test01.test001;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.personal.test01.optional.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Creater albolt
 * @12/11/20 10:30 AM
 */

@Slf4j
public class Main {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            String a = sc.nextLine();
//            System.out.println(a.matches("^[A-Z0-9]*"));
//        }

        List<String> a = new ArrayList<>();
        a.stream().filter(x->x.equals("123")).collect(Collectors.toList());
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }

        System.out.println(Integer.MAX_VALUE);
    }

}
