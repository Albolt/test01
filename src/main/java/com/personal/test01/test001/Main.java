package com.personal.test01.test001;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.personal.test01.everyOther.User2;
import com.personal.test01.optional.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Creater albolt
 * @12/11/20 10:30 AM
 */

@Slf4j
public class Main {
    public static void main(String[] args) {
        User user1 = new User("1", 5123123123L, new HashMap<>());
        user1.getEmail().put("1", "12");
        user1.getEmail().put("2", "23");
        System.out.println(user1);
    }

    public static Boolean isNumeric(String str) {
        return str.matches("^[-\\+]?[.\\d]*$");
    }

}
